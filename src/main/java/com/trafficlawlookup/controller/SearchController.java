package com.trafficlawlookup.controller;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.trafficlawlookup.service.trafficlaw.AutoCompleteModel;
import com.trafficlawlookup.service.trafficlaw.PMF;
import com.trafficlawlookup.service.trafficlaw.TrafficLaw;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@RequestMapping(value = "/autocomplete/{query}", method = RequestMethod.GET)
	public @ResponseBody List<AutoCompleteModel> getAutoCompleteSearch(@PathVariable String query) {

		List<TrafficLaw> results = null;
		List<AutoCompleteModel> sectionSubs = new ArrayList<AutoCompleteModel>();
		
		
		query = (query != null ? query.toLowerCase() : "").trim();
		PersistenceManager pm = PMF.get().getPersistenceManager();

		Query q = pm.newQuery(TrafficLaw.class);
		q.setFilter("sectionSub >= '" + query + "' && sectionSub < '" + query + "\uFFFD'");

		try {
			results = (List<TrafficLaw>) q.execute();
			results.size();
		} finally {
			q.closeAll();
			pm.close();
		}
		
		for (TrafficLaw result : results){
			AutoCompleteModel sectionSub = new AutoCompleteModel();
			sectionSub.setSectionSub(result.getSectionSub());
			sectionSub.setOffenseTitle(result.getOffenseTitle());
			sectionSubs.add(sectionSub);
		}			
		return sectionSubs;
	}

	@RequestMapping(value = "/word/{sectionSub}", method = RequestMethod.GET)
	public @ResponseBody List<TrafficLaw> getMultipleSearchResults(@PathVariable String sectionSub) {

		List<TrafficLaw> results = null;
		sectionSub = (sectionSub != null ? sectionSub.toLowerCase() : "").trim();
		PersistenceManager pm = PMF.get().getPersistenceManager();

		Query q = pm.newQuery(TrafficLaw.class);
		q.setFilter("sectionSub >= '" + sectionSub + "' && sectionSub < '" + sectionSub + "\uFFFD'");

		try {
			results = (List<TrafficLaw>) q.execute();
			results.size();
			return results;

		} finally {
			q.closeAll();
			pm.close();
		}

	}
}
