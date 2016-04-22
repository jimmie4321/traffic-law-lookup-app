package com.trafficlawlookup.service.trafficlaw;

public class AutoCompleteModel {

	private String sectionSub;

	private String offenseTitle;
	
	public String getSectionSub() {
		return sectionSub;
	}

	public void setSectionSub(String sectionSub) {
		this.sectionSub = sectionSub;
	}

	public String getOffenseTitle() {
		return offenseTitle;
	}

	public void setOffenseTitle(String offenseTitle) {
		this.offenseTitle = offenseTitle;
	}
	
	public AutoCompleteModel() {
		super();
	}
    
}
