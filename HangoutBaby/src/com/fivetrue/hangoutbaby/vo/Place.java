package com.fivetrue.hangoutbaby.vo;

import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.AutoIncrement;
import com.fivetrue.db.annotation.ForeignKey;
import com.fivetrue.db.annotation.PrimaryKey;
import com.fivetrue.db.annotation.StringLength;

public class Place extends DatabaseObject{
	
	@PrimaryKey
	@AutoIncrement
	private int placeNo;
	
	@StringLength(64)
	private String placeId;
	
	@StringLength(128)
	private String placeName;

	private double placeLatitude;
	private double placeLongitude;
	
	@StringLength(64)
	private String placeCity;
	
	@StringLength(256)
	private String placeAddress;
	
	@StringLength(128)
	private String placeImageUrl;
	
	private String placeFee;
	
	@StringLength(512)
	private String placeDescription;
	
	@ForeignKey(User.class)
	private String placeAuthor;
	
	private long placePostDate;
	
	private int placeCommentCount;

	public int getPlaceNo() {
		return placeNo;
	}

	public void setPlaceNo(int placeNo) {
		this.placeNo = placeNo;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public double getPlaceLatitude() {
		return placeLatitude;
	}

	public void setPlaceLatitude(double placeLatitude) {
		this.placeLatitude = placeLatitude;
	}

	public double getPlaceLongitude() {
		return placeLongitude;
	}

	public void setPlaceLongitude(double placeLongitude) {
		this.placeLongitude = placeLongitude;
	}

	public String getPlaceCity() {
		return placeCity;
	}

	public void setPlaceCity(String placeCity) {
		this.placeCity = placeCity;
	}

	public String getPlaceAddress() {
		return placeAddress;
	}

	public void setPlaceAddress(String placeAddress) {
		this.placeAddress = placeAddress;
	}

	public String getPlaceImageUrl() {
		return placeImageUrl;
	}

	public void setPlaceImageUrl(String placeImageUrl) {
		this.placeImageUrl = placeImageUrl;
	}

	public String getPlaceFee() {
		return placeFee;
	}

	public void setPlaceFee(String placeFee) {
		this.placeFee = placeFee;
	}

	public String getPlaceDescription() {
		return placeDescription;
	}

	public void setPlaceDescription(String placeDescription) {
		this.placeDescription = placeDescription;
	}

	public String getPlaceAuthor() {
		return placeAuthor;
	}

	public void setPlaceAuthor(String placeAuthor) {
		this.placeAuthor = placeAuthor;
	}

	public long getPlacePostDate() {
		return placePostDate;
	}

	public void setPlacePostDate(long placePostDate) {
		this.placePostDate = placePostDate;
	}
	
	public int getPlaceCommentCount() {
		return placeCommentCount;
	}

	public void setPlaceCommentCount(int placeCommentCount) {
		this.placeCommentCount = placeCommentCount;
	}

	@Override
	public String toString() {
		return "Place [placeNo=" + placeNo + ", placeId=" + placeId + ", placeName=" + placeName + ", placeLatitude="
				+ placeLatitude + ", placeLongitude=" + placeLongitude + ", placeCity=" + placeCity + ", placeAddress="
				+ placeAddress + ", placeImageUrl=" + placeImageUrl + ", placeFee=" + placeFee + ", placeDescription="
				+ placeDescription + ", placeAuthor=" + placeAuthor + ", placePostDate=" + placePostDate + "]";
	}

}
