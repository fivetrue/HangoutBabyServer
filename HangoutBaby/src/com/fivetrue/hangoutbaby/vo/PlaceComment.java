package com.fivetrue.hangoutbaby.vo;

import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.ForeignKey;
import com.fivetrue.db.annotation.PrimaryKey;
import com.fivetrue.db.annotation.StringLength;

public class PlaceComment extends DatabaseObject{ 
	
	@PrimaryKey
	private int commentId;
	
	private int parentCommentId;
	
	@StringLength(512)
	private String comment;
	
	@ForeignKey(Place.class)
	private int placeNo;
	
	@ForeignKey(User.class)
	private String commentAuthor;
	
	private long commentDate;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(int parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getPlaceId() {
		return placeNo;
	}

	public void setPlaceId(int placeId) {
		this.placeNo = placeId;
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

}
