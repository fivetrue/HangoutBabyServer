package com.fivetrue.hangoutbaby.vo;

import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.DisplayName;
import com.fivetrue.db.annotation.PrimaryKey;
import com.fivetrue.db.annotation.StringLength;

public class NotificationData extends DatabaseObject{
	
	@PrimaryKey
	@StringLength(64)
	private String multicast_id = null;
	
	@DisplayName("PushID")
	private int id = -1;
	
	@DisplayName("제목")
	@StringLength(128)
	private String title = null;
	@DisplayName("내용")
	@StringLength(256)
	private String message = null;
	@DisplayName("URL정보")
	@StringLength(128)
	private String uri = null;
	@DisplayName("이미지URL")
	@StringLength(128)
	private String imageUrl = null;
	
	private long createTime = 0;
	
	@StringLength(64)
	private String userUid = null;

	@DisplayName("공지사항")
	private int type = 0;
	
	public String getMulticast_id() {
		return multicast_id;
	}
	public void setMulticast_id(String multicast_id) {
		this.multicast_id = multicast_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUserUid() {
		return userUid;
	}
	public void setUser(String userUid) {
		this.userUid = userUid;
	}
	@Override
	public String toString() {
		return "NotificationData [multicast_id=" + multicast_id + ", id=" + id + ", title=" + title + ", message="
				+ message + ", uri=" + uri + ", imageUrl=" + imageUrl + ", createTime=" + createTime + ", userUid="
				+ userUid + ", type=" + type + "]";
	}
	
}
