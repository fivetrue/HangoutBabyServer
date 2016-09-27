package com.fivetrue.hangoutbaby.manager;


import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.hangoutbaby.Constants;
import com.fivetrue.hangoutbaby.vo.PlaceFeeBand;

public class PlaceFeeDBManager extends DatabaseManagerImpl<PlaceFeeBand>{

	private static PlaceFeeDBManager sInstance = null;
	
	protected PlaceFeeDBManager() {
		super(Constants.DB_SERVER, Constants.DB_NAME, Constants.DB_ID, Constants.DB_PASS);
		// TODO Auto-generated constructor stub
		create();
	}
	
	public static PlaceFeeDBManager getInstance(){
		if(sInstance == null){
			sInstance = new PlaceFeeDBManager();
		}
		return sInstance;
	}

	@Override
	protected Class<? extends PlaceFeeBand> getDatabaseObjectClass() {
		// TODO Auto-generated method stub
		return PlaceFeeBand.class;
	}

	@Override
	public PlaceFeeBand getDefaultData() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
