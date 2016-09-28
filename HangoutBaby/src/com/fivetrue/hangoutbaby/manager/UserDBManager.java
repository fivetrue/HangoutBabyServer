package com.fivetrue.hangoutbaby.manager;

import java.util.ArrayList;

import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.hangoutbaby.Constants;
import com.fivetrue.hangoutbaby.vo.User;
import com.fivetrue.utils.TextUtils;

public class UserDBManager extends DatabaseManagerImpl<User>{

	private static UserDBManager sInstance = null;
	
	protected UserDBManager() {
		super(Constants.DB_SERVER, Constants.DB_NAME, Constants.DB_ID, Constants.DB_PASS);
		// TODO Auto-generated constructor stub
		create();
	}
	
	public static UserDBManager getInstance(){
		if(sInstance == null){
			sInstance = new UserDBManager();
		}
		return sInstance;
	}

	@Override
	protected Class<? extends User> getDatabaseObjectClass() {
		// TODO Auto-generated method stub
		return User.class;
	}

	@Override
	public User getDefaultData() {
		// TODO Auto-generated method stub
//		UserInfo user = new UserInfo();
//		user.setEmail("dudrpdjwls@naver.com");
//		user.setdNickname("고구마감자");
//		user.setEncId("6cea3f02bbbed6a2142142ca77fd3a457c66e0019007de3fbedb5e1fa1522e6d");
//		user.setProfileImage("https://phinf.pstatic.net/contactthumb/20160701_103/14673565707785MLfq_JPEG/image.jpg?type=s80");
//		user.setAge("30-39");
//		user.setGender("M");
//		user.setId("15028068");
//		user.setName("권오진");
//		user.setGcmId("APA91bHmu8p161n1MfxY9c0H8B0Iud4Y_IlGPkVBw4l2EZBaIhIEADnAYV4zPFOhTDsorMI7jPJttyMMOECjSdAPX_QvXuL1HP9kruE7r4Xvv9Ddd2gh7sr-WIBVzoFOOseXmcR-M385");
//		user.setBirthday("11-01");
//		user.setDevice("Custom Pho ne - 5.0.0 - API 21 - 768x1280");
		return null;
	}
	
	public User isExistUid(String userUid){
		User u = null;
		if(!TextUtils.isEmpty(userUid)){
			ArrayList<User> datas = getSelectQueryData(null, "userUid='" + userUid +"'", "LIMIT 1");
			if(datas != null && datas.size() > 0){
				u = datas.get(0);
			}
		}
		return u;
	}
	
	public User isExistEmail(String userEmail){
		User u = null;
		if(!TextUtils.isEmpty(userEmail)){
			ArrayList<User> datas = getSelectQueryData(null, "userId='" + userEmail +"'", "LIMIT 1");
			if(datas != null && datas.size() > 0){
				u = datas.get(0);
			}
		}
		return u;
	}
	
	

}
