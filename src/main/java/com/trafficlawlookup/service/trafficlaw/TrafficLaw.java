package com.trafficlawlookup.service.trafficlaw;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class TrafficLaw {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
	@Persistent
	private String sectionSub;
	
	@Persistent
	private String type;
	
	@Persistent
	private String offenseTitle;
	
	@Persistent
	private String fineMin;
	
	@Persistent
	private String fineMax;
	
	@Persistent
	private String jailMin;
	
	@Persistent
	private String jailMax;
	
	@Persistent
	private String pts;
	
	@Persistent
	private String surchargeOtherCourts;
	
	@Persistent
	private String surchargeTownVillage;
	
    @Persistent
    private Date date;
	
	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getSectionSub() {
		return sectionSub;
	}

	public void setSectionSub(String sectionSub) {
		this.sectionSub = sectionSub;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOffenseTitle() {
		return offenseTitle;
	}

	public void setOffenseTitle(String offenseTitle) {
		this.offenseTitle = offenseTitle;
	}

	public String getFineMin() {
		return fineMin;
	}

	public void setFineMin(String fineMin) {
		this.fineMin = fineMin;
	}

	public String getFineMax() {
		return fineMax;
	}

	public void setFineMax(String fineMax) {
		this.fineMax = fineMax;
	}

	public String getJailMin() {
		return jailMin;
	}

	public void setJailMin(String jailMin) {
		this.jailMin = jailMin;
	}

	public String getJailMax() {
		return jailMax;
	}

	public void setJailMax(String jailMax) {
		this.jailMax = jailMax;
	}

	public String getPts() {
		return pts;
	}

	public void setPts(String pts) {
		this.pts = pts;
	}

	public String getSurchargeOtherCourts() {
		return surchargeOtherCourts;
	}

	public void setSurchargeOtherCourts(String surchargeOtherCourts) {
		this.surchargeOtherCourts = surchargeOtherCourts;
	}

	public String getSurchargeTownVillage() {
		return surchargeTownVillage;
	}

	public void setSurchargeTownVillage(String surchargeTownVillage) {
		this.surchargeTownVillage = surchargeTownVillage;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getShortDate() {  
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
	    String s = formatter.format(date);
	    return s;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TrafficLaw() {
		super();
	}
    
}
