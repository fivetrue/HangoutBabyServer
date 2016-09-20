package com.fivetrue.hangoutbaby.manager;


import java.util.ArrayList;

import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.hangoutbaby.Constants;
import com.fivetrue.hangoutbaby.vo.Place;

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
	
	public ArrayList<Place> getPlaces(int page, int limit){
		return getSelectQueryData(null, null, "OFFSET " + (page * limit) + " LIMIT " + limit);
	}
	
}
