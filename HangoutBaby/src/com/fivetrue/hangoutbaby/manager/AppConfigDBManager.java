package com.fivetrue.hangoutbaby.manager;



import com.fivetrue.db.DBMessage;
import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.hangoutbaby.Constants;
import com.fivetrue.hangoutbaby.vo.AppConfig;

public class AppConfigDBManager extends DatabaseManagerImpl<AppConfig>{

	private static AppConfigDBManager sInstance = null;
	
	
	protected AppConfigDBManager() {
		super(Constants.DB_SERVER, Constants.DB_NAME, Constants.DB_ID, Constants.DB_PASS);
		// TODO Auto-generated constructor stub
		create();
	}
	
	public static AppConfigDBManager getInstance(){
		if(sInstance == null){
			sInstance = new AppConfigDBManager();
		}
		return sInstance;
	}
	@Override
	protected Class<? extends AppConfig> getDatabaseObjectClass() {
		// TODO Auto-generated method stub
		return AppConfig.class;
	}

	@Override
	public AppConfig getDefaultData() {
		// TODO Auto-generated method stub
		AppConfig config = new AppConfig();
		config.setAppId(Constants.APP_ID);
		config.setAppMarketUrl(Constants.APP_MARKET_URL);
		config.setAppSercureKey(Constants.APP_KEY);
		config.setAppVersionCode(Constants.APP_LATEST_VERSION);
		config.setAppVersionName(Constants.APP_VERSION_NAME);
		config.setSenderId(Constants.GCM.GCM_SENDER_ID);
		return config;
	}
	
	@Override
	public DBMessage create() {
		// TODO Auto-generated method stub
		DBMessage msg = super.create();
		if(getCountData(null) <= 0){
			insertObject(getDefaultData());
		}
		return msg;
	}
	
}
