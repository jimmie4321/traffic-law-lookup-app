package com.trafficlawlookup.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.trafficlawlookup.service.trafficlaw.AutoCompleteModel;
import com.trafficlawlookup.service.trafficlaw.PMF;
import com.trafficlawlookup.service.trafficlaw.TrafficLaw;

@Controller
@RequestMapping("/trafficlaw")
public class TrafficLawController {

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddTrafficLawPage(ModelMap model) {
		return "addTrafficLaw";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request, ModelMap model) {

		String sectionSub = request.getParameter("sectionSub");
		String type = request.getParameter("type");
		String offenseTitle = request.getParameter("offenseTitle");
		String fineMin = request.getParameter("fineMin");
		String fineMax = request.getParameter("fineMax");
		String jailMin = request.getParameter("jailMin");
		String jailMax = request.getParameter("jailMax");
		String pts = request.getParameter("pts");
		String surchargeOtherCourts = request.getParameter("surchargeOtherCourts");
		String surchargeTownVillage = request.getParameter("surchargeTownVillage");

		TrafficLaw trafficLaw = new TrafficLaw();
		trafficLaw.setSectionSub(sectionSub);
		trafficLaw.setType(type);
		trafficLaw.setOffenseTitle(offenseTitle);
		trafficLaw.setFineMin(fineMin);
		trafficLaw.setFineMax(fineMax);
		trafficLaw.setJailMin(jailMin);
		trafficLaw.setJailMax(jailMax);
		trafficLaw.setPts(pts);
		trafficLaw.setSurchargeOtherCourts(surchargeOtherCourts);
		trafficLaw.setSurchargeTownVillage(surchargeTownVillage);
		trafficLaw.setDate(new Date());

		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(trafficLaw);
		} finally {
			pm.close();
		}
		return new ModelAndView("redirect:list");
	}

	@RequestMapping(value = "/update/{sectionSub}", method = RequestMethod.GET)
	public String getUpdateTrafficLawPage(@PathVariable String sectionSub, HttpServletRequest request, ModelMap model) {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Query q = pm.newQuery(TrafficLaw.class);
		q.setFilter("sectionSub == nameParameter");
		q.setOrdering("date desc");
		q.declareParameters("String nameParameter");

		try {
			List<TrafficLaw> results = (List<TrafficLaw>) q.execute(sectionSub);

			if (results.isEmpty()) {
				model.addAttribute("trafficLaw", null);
			} else {
				model.addAttribute("trafficLaw", results.get(0));
			}
		} finally {
			q.closeAll();
			pm.close();
		}
		return "updateTrafficLaw";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, ModelMap model) {

		String sectionSub = request.getParameter("sectionSub");
		String type = request.getParameter("type");
		String offenseTitle = request.getParameter("offenseTitle");
		String fineMin = request.getParameter("fineMin");
		String fineMax = request.getParameter("fineMax");
		String jailMin = request.getParameter("jailMin");
		String jailMax = request.getParameter("jailMax");
		String pts = request.getParameter("pts");
		String surchargeOtherCourts = request.getParameter("surchargeOtherCourts");
		String surchargeTownVillage = request.getParameter("surchargeTownVillage");
		String key = request.getParameter("key");

		PersistenceManager pm = PMF.get().getPersistenceManager();

		try {
			TrafficLaw trafficLaw = (TrafficLaw) pm.getObjectById(TrafficLaw.class, key);

			trafficLaw.setSectionSub(sectionSub);
			trafficLaw.setType(type);
			trafficLaw.setOffenseTitle(offenseTitle);
			trafficLaw.setFineMin(fineMin);
			trafficLaw.setFineMax(fineMax);
			trafficLaw.setJailMin(jailMin);
			trafficLaw.setJailMax(jailMax);
			trafficLaw.setPts(pts);
			trafficLaw.setSurchargeOtherCourts(surchargeOtherCourts);
			trafficLaw.setSurchargeTownVillage(surchargeTownVillage);
			trafficLaw.setDate(new Date());
		} finally {
			pm.close();
		}
		return new ModelAndView("redirect:list");
	}

	@RequestMapping(value = "/delete/{key}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable String key, HttpServletRequest request, ModelMap model) {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		try {

			TrafficLaw c = (TrafficLaw) pm.getObjectById(TrafficLaw.class, key);
			pm.deletePersistent(c);

		} finally {
			pm.close();
		}
		// return to list
		// TODO check this, might be wrong
		return new ModelAndView("redirect:../list");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listTrafficLawsPage(ModelMap model) {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(TrafficLaw.class);
		q.setOrdering("date desc");

		List<TrafficLaw> results = null;

		try {
			results = (List<TrafficLaw>) q.execute();

			if (results.isEmpty()) {
				model.addAttribute("trafficLawList", null);
			} else {
				model.addAttribute("trafficLawList", results);
			}

		} finally {
			q.closeAll();
			pm.close();
		}
		return "listTrafficLaws";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String getUploadTrafficLawsPage(ModelMap model) {
		return "uploadTrafficLaws";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView processCsvData(HttpServletRequest request, ModelMap model) {
		TrafficLaw trafficLaw;
		CSVParser parser;
		List<CSVRecord> list = null;

		String csvData = request.getParameter("csvData");
		Reader in = new StringReader(csvData);

		try {
			parser = new CSVParser(in, CSVFormat.EXCEL.withHeader());
			list = parser.getRecords();
			parser.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < list.size(); i++) {
			trafficLaw = new TrafficLaw();
			CSVRecord record = list.get(i);

			trafficLaw.setSectionSub(record.get("SECTION_SUB"));
			trafficLaw.setType(record.get("TYPE"));
			trafficLaw.setOffenseTitle(record.get("OFFENSE_TITLE"));
			trafficLaw.setFineMin(record.get("FINE_MIN"));
			trafficLaw.setFineMax(record.get("FINE_MAX"));
			trafficLaw.setJailMin(record.get("JAIL_MIN"));
			trafficLaw.setJailMax(record.get("JAIL_MAX"));
			trafficLaw.setPts(record.get("PTS"));
			trafficLaw.setSurchargeOtherCourts(record.get("SURCHARGE_OTHER_COURTS"));
			trafficLaw.setSurchargeTownVillage(record.get("SURCARGE_TOWN_VILLAGE"));
			trafficLaw.setDate(new Date());

			PersistenceManager pm = PMF.get().getPersistenceManager();
			try {
				pm.makePersistent(trafficLaw);
			} finally {
				pm.close();
			}
		}
		return new ModelAndView("redirect:list");
	}
}
