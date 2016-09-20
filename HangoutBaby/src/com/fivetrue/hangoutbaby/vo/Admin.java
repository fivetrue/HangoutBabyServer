package com.fivetrue.hangoutbaby.vo;

import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.AutoIncrement;
import com.fivetrue.db.annotation.ForeignKey;
import com.fivetrue.db.annotation.Password;
import com.fivetrue.db.annotation.PrimaryKey;

public class Admin extends DatabaseObject{
	
	@PrimaryKey
	@AutoIncrement
	private int adminId;
	
	@ForeignKey(User.class)
	private String adminUserId;
	@Password
	private String adminPass;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(String adminUserId) {
		this.adminUserId = adminUserId;
	}
	
	public String getAdminPass() {
		return adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminUserId=" + adminUserId + "]";
	}
}
