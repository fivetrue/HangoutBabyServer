package com.fivetrue.hangoutbaby.vo;

import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.PrimaryKey;
import com.fivetrue.db.annotation.StringLength;

public class User extends DatabaseObject{
	
	@PrimaryKey
	@StringLength(60)
	private String userUid;
	@StringLength(128)
	private String userId;
	@StringLength(400)
	private String userImageUrl;
	@StringLength(128)
	private String gcmId;
	private long registerDate;
	private long lastDate;
	private int state;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public long getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(long registerDate) {
		this.registerDate = registerDate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public long getLastDate() {
		return lastDate;
	}
	public void setLastDate(long lastDate) {
		this.lastDate = lastDate;
	}
	public String getUserImageUrl() {
		return userImageUrl;
	}
	public void setUserImageUrl(String userImageUrl) {
		this.userImageUrl = userImageUrl;
	}
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	
	public String getGcmId() {
		return gcmId;
	}
	public void setGcmId(String gcmId) {
		this.gcmId = gcmId;
	}
	@Override
	public String toString() {
		return "User [userUid=" + userUid + ", userId=" + userId + ", userImageUrl=" + userImageUrl + ", gcmId=" + gcmId
				+ ", registerDate=" + registerDate + ", lastDate=" + lastDate + ", state=" + state + "]";
	}
	
}
