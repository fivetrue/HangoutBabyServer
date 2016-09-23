package com.fivetrue.hangoutbaby.vo;

import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.AutoIncrement;
import com.fivetrue.db.annotation.ForeignKey;
import com.fivetrue.db.annotation.PrimaryKey;
import com.fivetrue.db.annotation.StringLength;

public class PlaceComment extends DatabaseObject{ 
	
	@PrimaryKey
	@AutoIncrement
	private int commentId;
	
	@StringLength(64)
	private String placeId;
	
	@StringLength(256)
	private String comment;
	
	@StringLength(256)
	private String imageUrl = null;
	
	private int feeBand;
	
	@ForeignKey(User.class)
	@StringLength(60)
	private String commentAuthor;
	
	private long commentDate;
	
	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getFeeBand() {
		return feeBand;
	}

	public void setFeeBand(int feeBand) {
		this.feeBand = feeBand;
	}

	public String getCommentAuthor() {
		return commentAuthor;
	}

	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}

	public long getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(long commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "PlaceComment [commentId=" + commentId  + ", comment=" + comment + ", imageUrl="
				+ imageUrl + ", feeBand=" + feeBand + ", commentAuthor=" + commentAuthor + ", commentDate="
				+ commentDate + "]";
	}
	
	
}
