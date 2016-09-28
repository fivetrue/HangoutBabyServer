package com.fivetrue.hangoutbaby.dto;

import java.util.ArrayList;

import com.fivetrue.hangoutbaby.vo.AppConfig;
import com.fivetrue.hangoutbaby.vo.PlaceFeeBand;

public class AppConfigEntry {
	
	public int appVersionCode = 0;
	public String appId = null;
	public String appSercureKey = null;
    public String appVersionName = null;
    public String appMarketUrl = null;
    public String senderId = null;

    public int forceUpdate = 0;
    
    public String adminUrl = null;
    
	public ArrayList<PlaceFeeBand> feeBands = null;
	
	public void setAppConfig(AppConfig config){
		appVersionCode = config.getAppVersionCode();
		appId = config.getAppId();
		appSercureKey = config.getAppSercureKey();
		appVersionName = config.getAppVersionName();
		appMarketUrl = config.getAppMarketUrl();
		senderId = config.getSenderId();
		forceUpdate = config.getForceUpdate();
		adminUrl = config.getAdminUrl();
	}
}
