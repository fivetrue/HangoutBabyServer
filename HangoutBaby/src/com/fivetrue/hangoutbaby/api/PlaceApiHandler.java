package com.fivetrue.hangoutbaby.api;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;
import com.fivetrue.db.DBMessage;
import com.fivetrue.hangoutbaby.manager.PlaceDBManager;
import com.fivetrue.hangoutbaby.vo.Place;
import com.fivetrue.utils.TextUtils;

public class PlaceApiHandler extends HeaderCheckingApiHandler{
	
	public static final String PLACE_NAME = "name";
	public static final String PLACE_LATITUDE = "lat";
	public static final String PLACE_LONGITUDE = "lng";
	public static final String PLACE_FEE = "fee";
	public static final String PLACE_ADDRESS = "address";
	public static final String PLACE_CITY = "city";
	public static final String PLACE_IMAGE = "image";
	public static final String PLACE_DESCRIPTION ="description";
	public static final String PLACE_AUTHOR = "author";
	
	
	public PlaceApiHandler(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super(context, request, response);
		// TODO Auto-generated constructor stub
		checkRequestValidation();
	}
	
	public void addPlace(){
		String placeName = getParameter(PLACE_NAME);
		String placelatitude = getParameter(PLACE_LATITUDE);
		String placeLongitude = getParameter(PLACE_LONGITUDE);
		String placeFee = getParameter(PLACE_FEE);
		String placeAddress = getParameter(PLACE_ADDRESS);
		String placeCity = getParameter(PLACE_CITY);
		String placeImage = getParameter(PLACE_IMAGE);
		String placeDescription = getParameter(PLACE_DESCRIPTION);
		String placeAuthor = getParameter(PLACE_AUTHOR);
		long placePostDate = System.currentTimeMillis();

		Result result = new Result();

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

		if(TextUtils.isEmpty(placeFee)){
			result.setMessage("비용이 정확하지 않습니다.");
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

		if(TextUtils.isEmpty(placeImage)){
			result.setMessage("이미지가 정확하지 않습니다.");
			result.setErrorCode(ErrorCode.INVALID_PARAMETER);
			result.makeResponseTime();
			writeObject(result);
			return;
		}



		Place place = new Place();
		place.setPlaceName(placeName);
		place.setPlaceLongitude(Double.parseDouble(placeLongitude));
		place.setPlaceLatitude(Double.parseDouble(placelatitude));
		place.setPlaceFee(placeFee);
		place.setPlaceAddress(placeAddress);
		place.setPlaceCity(placeCity);
		place.setPlaceDescription(placeDescription);
		place.setPlaceAuthor(placeAuthor);
		place.setPlacePostDate(placePostDate);
		place.setPlaceImageUrl(placeImage);

		DBMessage message = PlaceDBManager.getInstance().insertObject(place);
		result.setErrorCode(ErrorCode.OK);
		result.setResult(message);
		result.makeResponseTime();
		writeObject(result);
		notifyNewPost(place);
	}
	
	public void deletePlace(){
		
	}
	
	public void modifyPlace(){
		
	}
	
	public void getPlaceList(){
		
	}
	
	public void findPlaceList(){
		
	}
	
	
	private void notifyNewPost(Place place){
		
	}

}
