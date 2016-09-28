package com.fivetrue.hangoutbaby.api;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;
import com.fivetrue.db.DBMessage;
import com.fivetrue.db.PageData;
import com.fivetrue.hangoutbaby.manager.PlaceDBManager;
import com.fivetrue.hangoutbaby.manager.UserDBManager;
import com.fivetrue.hangoutbaby.vo.Place;
import com.fivetrue.hangoutbaby.vo.User;
import com.fivetrue.utils.TextUtils;

public class PlaceApiHandler extends HeaderCheckingApiHandler{
	
	public static final String PLACE_ID = "id";
	public static final String PLACE_NAME = "name";
	public static final String PLACE_LATITUDE = "lat";
	public static final String PLACE_LONGITUDE = "lng";
	public static final String PLACE_ADDRESS = "address";
	public static final String PLACE_CITY = "city";
	public static final String PLACE_DESCRIPTION ="description";
	public static final String PLACE_AUTHOR = "author";
	
	
	public PlaceApiHandler(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super(context, request, response);
		// TODO Auto-generated constructor stub
		checkRequestValidation();
	}
	
	public void addPlace(){
		String placeId = getParameter(PLACE_ID);
		String placeName = getParameter(PLACE_NAME);
		String placelatitude = getParameter(PLACE_LATITUDE);
		String placeLongitude = getParameter(PLACE_LONGITUDE);
		String placeAddress = getParameter(PLACE_ADDRESS);
		String placeCity = getParameter(PLACE_CITY);
		String placeDescription = getParameter(PLACE_DESCRIPTION);
		String placeAuthor = getParameter(PLACE_AUTHOR);
		long placePostDate = System.currentTimeMillis();

		Result result = new Result();
		
		if(TextUtils.isEmpty(placeId)){
			result.setMessage("PlaceId가 정확하지 않습니다.");
			result.setErrorCode(ErrorCode.INVALID_PARAMETER);
			result.makeResponseTime();
			writeObject(result);
			return;
		}

		if(TextUtils.isEmpty(placeName)){
			result.setMessage("이름이 정확하지 않습니다.");
			result.setErrorCode(ErrorCode.INVALID_PARAMETER);
			result.makeResponseTime();
			writeObject(result);
			return;
		}

		if(TextUtils.isEmpty(placelatitude) || TextUtils.isEmpty(placeLongitude) 
				|| TextUtils.isEmpty(placeAddress) || TextUtils.isEmpty(placeCity)){
			result.setMessage("위치가 정확하지 않습니다.");
			result.setErrorCode(ErrorCode.INVALID_PARAMETER);
			result.makeResponseTime();
			writeObject(result);
			return;
		}

		if(TextUtils.isEmpty(placeDescription)){
			result.setMessage("설명이 정확하지 않습니다.");
			result.setErrorCode(ErrorCode.INVALID_PARAMETER);
			result.makeResponseTime();
			writeObject(result);
			return;
		}

		if(TextUtils.isEmpty(placeAuthor)){
			result.setMessage("작성자가 정확하지 않습니다.");
			result.setErrorCode(ErrorCode.INVALID_PARAMETER);
			result.makeResponseTime();
			writeObject(result);
			return;
		}
		
		User user = UserDBManager.getInstance().isExistUid(placeAuthor);
		if(user == null){
			result.setMessage("존재하지 않는 회원입니다.");
			result.setErrorCode(ErrorCode.NOT_FOUND_DATA);
			result.makeResponseTime();
			writeObject(result);
			return;
		}
		
		Place place = PlaceDBManager.getInstance().isExistPlaceId(placeId);
		if(place != null){
			result.setMessage("이미 등록된 장소 입니다.");
			result.setErrorCode(ErrorCode.EXIST_DATA);
			result.makeResponseTime();
			writeObject(result);
			return;
		}

		place = new Place();
		place.setPlaceId(placeId);
		place.setPlaceName(placeName);
		place.setPlaceLongitude(Double.parseDouble(placeLongitude));
		place.setPlaceLatitude(Double.parseDouble(placelatitude));
		place.setPlaceAddress(placeAddress);
		place.setPlaceCity(placeCity);
		place.setPlaceDescription(placeDescription);
		place.setPlaceAuthor(placeAuthor);
		place.setPlacePostDate(placePostDate);

		DBMessage message = PlaceDBManager.getInstance().insertObject(place);
		result.setErrorCode(ErrorCode.OK);
		result.setResult(place);
		result.setMessage(message.getMessage());
		result.makeResponseTime();
		writeObject(result);
		notifyNewPost(place);
	}
	
	public void deletePlace(){
		
	}
	
	public void modifyPlace(){
		
	}
	
	public void getPlace(){
		PageData pageData = getPageData();
		String paging = null;
		if(pageData != null){
			paging = pageData.toString();
		}
		String extra = getOrderBy();
		
		if(extra == null && paging != null){
			extra = paging;
		}else if(extra != null && paging != null){
			extra += " " + paging;
		}
		
		String placeId = getParameter(PLACE_ID);
		String where = null;
		if(placeId != null){
			where = "placeId='" + placeId + "'";
		}
		
		ArrayList<Place> places = PlaceDBManager.getInstance().getSelectQueryData(null, where, extra);
		Result result = new Result();
		result.setErrorCode(ErrorCode.OK);
		result.setResult(places);
		result.makeResponseTime();
		writeObject(result);
		
	}
	
	public void findPlaceList(){
		
	}
	
	
	private void notifyNewPost(Place place){
		
	}

}
