package com.fivetrue.hangoutbaby.manager;



import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.hangoutbaby.Constants;
import com.fivetrue.hangoutbaby.vo.PlaceComment;

public class PlaceCommentDBManager extends DatabaseManagerImpl<PlaceComment>{

	private static PlaceCommentDBManager sInstance = null;
	
	protected PlaceCommentDBManager() {
		super(Constants.DB_SERVER, Constants.DB_NAME, Constants.DB_ID, Constants.DB_PASS);
		// TODO Auto-generated constructor stub
		create();
	}
	
	public static PlaceCommentDBManager getInstance(){
		if(sInstance == null){
			sInstance = new PlaceCommentDBManager();
		}
		return sInstance;
	}

	@Override
	protected Class<? extends PlaceComment> getDatabaseObjectClass() {
		// TODO Auto-generated method stub
		return PlaceComment.class;
	}

	@Override
	public PlaceComment getDefaultData() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
