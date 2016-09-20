package com.fivetrue.hangoutbaby.api;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.BaseApiHandler;
import com.fivetrue.hangoutbaby.Constants;
import com.google.gson.Gson;


abstract public class HeaderCheckingApiHandler extends BaseApiHandler{

	private Gson mGson = null;
	public HeaderCheckingApiHandler(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super(context, request, response);
		// TODO Auto-generated constructor stub
		mGson = new Gson();
	}
	
	@Override
	protected boolean checkRequestValidation() {
		// TODO Auto-generated method stub
		String appId = getRequest().getHeader(Constants.KEY_APP_ID);
		String appKey = getRequest().getHeader(Constants.KEY_APP_KEY);
		Date date = new Date(System.currentTimeMillis());
		String log = getSimpleDataFormat().format(date) + " / RemoteAddr : (" + getRequest().getRemoteAddr()  + ") / "
				+"Headers : (" + "ContentType : " + getRequest().getContentType() + ", "
				+ Constants.KEY_APP_ID + " : " + appId + ", "
				+ Constants.KEY_APP_KEY + " : " + appKey + ") / ";
		log += "Path : (" + getRequest().getServletPath() + ") / "; 		
		log += "Class : (" + getClass().getName() + ") / "; 		
		log += "Parameters : (";
		for(String key : getRequest().getParameterMap().keySet()){
			log += key + " : " + getRequest().getParameter(key) + ", ";
		}
		getContext().log(log);
		boolean b = appId != null && appId.equals(Constants.APP_ID) && appKey != null && appKey.equals(Constants.APP_KEY);
		if(!b){
			try {
				getResponse().sendError(ErrorCode.REQUEST_ERROR, ErrorCode.INVALID_HEADER_VALUES);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}
	
	protected void writeObject(Object obj){
		if(obj != null && getResponse() != null){
			try {
//				String content = new Gson
				getResponse().getWriter().println(mGson.toJson(obj));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
