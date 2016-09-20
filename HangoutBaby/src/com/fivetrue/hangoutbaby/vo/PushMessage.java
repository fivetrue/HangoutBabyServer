package com.fivetrue.hangoutbaby.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PushMessage {
	
	private List<String> registration_ids = new ArrayList<>();
	private Data data = new Data();
	public List<String> getRegistration_ids() {
		return registration_ids;
	}
	public void setRegistration_ids(ArrayList<String> registration_ids) {
		this.registration_ids = registration_ids;
	}
	
	public void setRegistration_ids(String... ids){
		this.registration_ids = Arrays.asList(ids);
	}
	public Object getData() {
		return data;
	}
	public void setData(NotificationData data) {
		this.data.data = data;
	}
	
	protected static final class Data{
		private Object data = null;
	}
	@Override
	public String toString() {
		return "PushMessage [registration_ids=" + registration_ids + ", data=" + data + "]";
	}
	
}
