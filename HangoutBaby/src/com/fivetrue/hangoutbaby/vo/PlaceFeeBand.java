package com.fivetrue.hangoutbaby.vo;

import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.PrimaryKey;

public class PlaceFeeBand extends DatabaseObject{
	
	@PrimaryKey
	private  int bandId;
	private String band;
	private String currency;
	
	public int getBandId() {
		return bandId;
	}
	
	public void setBandId(int bandId) {
		this.bandId = bandId;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
