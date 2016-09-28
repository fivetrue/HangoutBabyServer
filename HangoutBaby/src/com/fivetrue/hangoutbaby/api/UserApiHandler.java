package com.fivetrue.hangoutbaby.api;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;
import com.fivetrue.hangoutbaby.manager.UserDBManager;
import com.fivetrue.hangoutbaby.vo.NotificationData;
import com.fivetrue.hangoutbaby.vo.PushMessage;
import com.fivetrue.hangoutbaby.vo.User;
import com.fivetrue.utils.TextUtils;

public class UserApiHandler extends HeaderCheckingApiHandler{
	
	public static final String USER_UID = "uid";
	public static final String USER_ID = "userId";
	public static final String USER_IMAGE_URL = "imageUrl";
	public static final String USER_GCM_ID = "gmcId";
	
	private static final int ACTIVED_USER = 0;
	private static final int INACTIVED_USER = 1;
	
	public UserApiHandler(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super(context, request, response);
		// TODO Auto-generated constructor stub
		checkRequestValidation();
	}
	
	public void addUser(){
		String userUid = getParameter(USER_UID);
		String userId = getParameter(USER_ID);
		String userImageUrl = getParameter(USER_IMAGE_URL);
		String userGcmId = getParameter(USER_GCM_ID);
		
		Result result = new Result();

		if(TextUtils.isEmpty(userUid)){
			result.setMessage("Id가 정확하지 않습니다.");
			result.setErrorCode(ErrorCode.INVALID_PARAMETER);
			result.makeResponseTime();
			writeObject(result);
			return;
		}
		
		long registerDate = System.currentTimeMillis();
		User user = UserDBManager.getInstance().isExistUid(userUid);
		
		if(user != null){
//			if(userImageUrl != null){
//				user.setUserImageUrl(userImageUrl);
//			}
//			if(userGcmId != null){
//				user.setGcmId(userGcmId);
//			}
//			user.setLastDate(registerDate);
//			UserDBManager.getInstance().updateObject(user);
			result.setMessage("이미 존재하는 계정입니다.");
			result.setErrorCode(ErrorCode.EXIST_DATA);
			result.makeResponseTime();
			result.setResult(user);
			writeObject(result);
		}else{
			
			int state = ACTIVED_USER;
			
			user = new User();
			user.setUserUid(userUid);
			user.setUserId(userId);
			user.setLastDate(registerDate);
			user.setRegisterDate(registerDate);
			user.setUserImageUrl(userImageUrl);
			user.setGcmId(userGcmId);
			user.setState(state);
				
			UserDBManager.getInstance().insertObject(user);
			result.setErrorCode(ErrorCode.OK);
			result.setResult(user);
			result.makeResponseTime();
			writeObject(result);
		}
	}
	
	public void loginUser(){
		
		String userUid = getParameter(USER_UID);
		String userId = getParameter(USER_ID);
		String userImageUrl = getParameter(USER_IMAGE_URL);
		String userGcmId = getParameter(USER_GCM_ID);
		
		Result result = new Result();
		if(TextUtils.isEmpty(userUid)){
			result.setMessage("ID가 정확하지 않습니다.");
			result.setErrorCode(ErrorCode.INVALID_PARAMETER);
			result.makeResponseTime();
			writeObject(result);
			return;
		}
		
		User user = UserDBManager.getInstance().isExistUid(userUid);
		if(user == null){
			result.setMessage("존재하지 않는 ID 입니다.");
			result.setErrorCode(ErrorCode.NOT_FOUND_DATA);
			result.makeResponseTime();
			writeObject(result);
			return;
		}
		
		user.setLastDate(System.currentTimeMillis());
		if(userImageUrl != null){
			user.setUserImageUrl(userImageUrl);
		}
		if(userGcmId != null){
			user.setGcmId(userGcmId);
		}
		UserDBManager.getInstance().updateObject(user);
		result.setErrorCode(ErrorCode.OK);
		result.setResult(user);
		result.makeResponseTime();
		writeObject(result);
		
		
//		PushNotificationApiHandler.sendNotification(0, "로그인", userId, userImageUrl, userGcmId);
	}

}
