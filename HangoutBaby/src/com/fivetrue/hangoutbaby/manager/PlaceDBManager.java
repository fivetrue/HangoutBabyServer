package com.fivetrue.hangoutbaby.manager;


import java.util.ArrayList;

import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.hangoutbaby.Constants;
import com.fivetrue.hangoutbaby.vo.Place;
import com.fivetrue.utils.TextUtils;

public class PlaceDBManager extends DatabaseManagerImpl<Place>{

	private static PlaceDBManager sInstance = null;
	
	protected PlaceDBManager() {
		super(Constants.DB_SERVER, Constants.DB_NAME, Constants.DB_ID, Constants.DB_PASS);
		// TODO Auto-generated constructor stub
		create();
	}
	
	public static PlaceDBManager getInstance(){
		if(sInstance == null){
			sInstance = new PlaceDBManager();
		}
		return sInstance;
	}

	@Override
	protected Class<? extends Place> getDatabaseObjectClass() {
		// TODO Auto-generated method stub
		return Place.class;
	}

	@Override
	public Place getDefaultData() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Place isExistPlaceId(String placeId){
		Place u = null;
		if(!TextUtils.isEmpty(placeId)){
			ArrayList<Place> datas = getSelectQueryData(null, "placeId='" + placeId +"'", "LIMIT 1");
			if(datas != null && datas.size() > 0){
				u = datas.get(0);
			}
		}
		return u;
	}
	
}
