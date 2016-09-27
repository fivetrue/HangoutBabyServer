package com.fivetrue.hangoutbaby.api;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;
import com.fivetrue.db.DBMessage;
import com.fivetrue.hangoutbaby.manager.AppConfigDBManager;
import com.fivetrue.hangoutbaby.manager.PlaceFeeDBManager;
import com.fivetrue.hangoutbaby.vo.AppConfig;
import com.fivetrue.hangoutbaby.vo.PlaceFeeBand;



public class AppConfigApiHandler extends HeaderCheckingApiHandler{


	public AppConfigApiHandler(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super(context, request, response);
		// TODO Auto-generated constructor stub
	}

	public void getAppConfig(){
		if(checkRequestValidation()){
			Result result = new Result();
			result.setErrorCode(Result.ERROR_CODE_OK);
			AppConfig config = null;
			ArrayList<AppConfig> configs = AppConfigDBManager.getInstance().getSelectQueryData(null, null, "ORDER BY appVersionCode DESC LIMIT 1");
			if(configs != null && configs.size() > 0){
				config = configs.get(0);
				config.setFeeBands(PlaceFeeDBManager.getInstance().getSelectQueryData(null, null, null));
			}
			
			result.setResult(config);
			writeObject(result);
		}
	}

	public void updateConfig(){
		if(checkRequestValidation()){
			writeObject(updateConfigResult());
		}
	}

	public Result updateConfigResult(){
		Result result = new Result();
		AppConfig config = new AppConfig();
		try {
			for(Field f : AppConfig.class.getDeclaredFields()){
				f.setAccessible(true);
				String value = getParameter(f.getName());
				if(f.getType() == String.class){
					f.set(config, value);
				}else{
					f.setInt(config, Integer.parseInt(value));
				}
			}
			DBMessage msg =  AppConfigDBManager.getInstance().updateObject(config);
			result.setResult(msg);
			result.setErrorCode(Result.ERROR_CODE_OK);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setErrorCode(Result.ERROR_CODE_REQUEST_ERROR);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setErrorCode(Result.ERROR_CODE_REQUEST_ERROR);
		}
		result.makeResponseTime();
		return result;
	}
}
