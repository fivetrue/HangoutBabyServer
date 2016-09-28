package com.fivetrue.hangoutbaby.vo;

import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.ForeignKey;
import com.fivetrue.db.annotation.MemberVariable;
import com.fivetrue.db.annotation.PrimaryKey;
import com.fivetrue.db.annotation.StringLength;

public class Place extends DatabaseObject{
	
	@PrimaryKey
	@StringLength(64)
	private String placeId;
	
	@StringLength(64)
	private String placeName;

	private double placeLatitude;
	private double placeLongitude;
	
	@StringLength(80)
	private String placeCity;
	
	@StringLength(64)
	private String placeAddress;
	
	@StringLength(256)
	private String placeDescription;
	
	@ForeignKey(User.class)
	@StringLength(60)
	private String placeAuthor;
	
	private long placePostDate;
	
	private int placeCommentCount;
	
	@MemberVariable
	private User user = null;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getPlaceAddress() {
		return placeAddress;
	}

	public void setPlaceAddress(String placeAddress) {
		this.placeAddress = placeAddress;
	}

	@Override
	public String toString() {
		return "Place [placeId=" + placeId + ", placeName=" + placeName + ", placeLatitude=" + placeLatitude
				+ ", placeLongitude=" + placeLongitude + ", placeCity=" + placeCity + ", placeAddress=" + placeAddress
				+ ", placeDescription=" + placeDescription + ", placeAuthor=" + placeAuthor + ", placePostDate="
				+ placePostDate + ", placeCommentCount=" + placeCommentCount + ", user=" + user + "]";
	}
	
}
