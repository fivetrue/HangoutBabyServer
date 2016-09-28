package com.fivetrue.hangoutbaby.api;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;
import com.fivetrue.db.DBMessage;
import com.fivetrue.db.PageData;
import com.fivetrue.hangoutbaby.manager.PlaceCommentDBManager;
import com.fivetrue.hangoutbaby.manager.PlaceDBManager;
import com.fivetrue.hangoutbaby.manager.PlaceFeeDBManager;
import com.fivetrue.hangoutbaby.manager.UserDBManager;
import com.fivetrue.hangoutbaby.vo.Place;
import com.fivetrue.hangoutbaby.vo.PlaceComment;
import com.fivetrue.hangoutbaby.vo.PlaceFeeBand;
import com.fivetrue.hangoutbaby.vo.User;
import com.fivetrue.utils.TextUtils;

public class PlaceCommentApiHandler extends HeaderCheckingApiHandler{
	
	public static final String PLACE_ID = "placeId";
	public static final String PLACE_IMAGE_URL = "imageUrl";
	public static final String PLACE_COMMENT = "comment";
	public static final String PLACE_FEE = "fee";
	public static final String PLACE_UPLOADER = "author";
	
	
	public PlaceCommentApiHandler(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super(context, request, response);
		// TODO Auto-generated constructor stub
		checkRequestValidation();
	}
	
	public void addPlaceComment(){
		
		String placeId = getParameter(PLACE_ID);
		String imageUrl = getParameter(PLACE_IMAGE_URL);
		String fee = getParameter(PLACE_FEE);
		String comment = getParameter(PLACE_COMMENT);
		String commentAuthor = getParameter(PLACE_UPLOADER);
		long placePostDate = System.currentTimeMillis();

		Result result = new Result();

		if(TextUtils.isEmpty(placeId)){
			result.setMessage("장소 ID가 정확하지 않습니다.");
			result.setErrorCode(ErrorCode.INVALID_PARAMETER);
			result.makeResponseTime();
			writeObject(result);
			return;
		}

//		if(TextUtils.isEmpty(PLACE_IMAGE_URL)){
//			result.setMessage("이미지 정보가 없습니다.");
//			result.setErrorCode(ErrorCode.INVALID_PARAMETER);
//			result.makeResponseTime();
//			writeObject(result);
//			return;
//		}

		if(TextUtils.isEmpty(commentAuthor)){
			result.setMessage("작성자가 정확하지 않습니다.");
			result.setErrorCode(ErrorCode.INVALID_PARAMETER);
			result.makeResponseTime();
			writeObject(result);
			return;
		}
		
		if(TextUtils.isEmpty(fee)){
			result.setMessage("소비 밴드가 지정되지 않았습니다.");
			result.setErrorCode(ErrorCode.INVALID_PARAMETER);
			result.makeResponseTime();
			writeObject(result);
			return;
		}
		
		User user = UserDBManager.getInstance().isExistUid(commentAuthor);
		if(user == null){
			result.setMessage("존재하지 않는 회원 입니다.");
			result.setErrorCode(ErrorCode.NOT_FOUND_DATA);
			result.makeResponseTime();
			writeObject(result);
			return;
		}
		
		Place place = PlaceDBManager.getInstance().isExistPlaceId(placeId);
		if(place == null){
			result.setMessage("존재하지 않는 장소 입니다.");
			result.setErrorCode(ErrorCode.NOT_FOUND_DATA);
			result.makeResponseTime();
			writeObject(result);
			return;
		}
		
		PlaceFeeBand feeband = PlaceFeeDBManager.getInstance().isExistBandId(fee);
		
		if(feeband == null){
			result.setMessage("존재하지 않는 FeeBandId 입니다.");
			result.setErrorCode(ErrorCode.NOT_FOUND_DATA);
			result.makeResponseTime();
			writeObject(result);
			return;
		}

		PlaceComment placeComment = new PlaceComment();
		placeComment.setPlaceId(placeId);
		placeComment.setComment(comment);
		placeComment.setCommentAuthor(commentAuthor);
		try{
			int feeBand = Integer.parseInt(fee.trim());
			placeComment.setFeeBand(feeBand);	
		}catch(Exception e){
			
		}
		if(imageUrl != null){
			placeComment.setImageUrl(imageUrl);
		}
		placeComment.setCommentDate(placePostDate);
		DBMessage message = PlaceCommentDBManager.getInstance().insertObject(placeComment);
		result.setErrorCode(ErrorCode.OK);
		result.setResult(placeComment);
		result.setMessage(message.getMessage());
		result.makeResponseTime();
		writeObject(result);
		notifyNewPost(placeComment);
	}
	
	public void deletePlace(){
		
	}
	
	public void modifyPlace(){
		
	}
	
	public void getPlaceCommentList(){
		String placeId = getParameter(PLACE_ID);
		
		Result result = new Result();

		if(TextUtils.isEmpty(placeId)){
			result.setMessage("장소 ID가 정확하지 않습니다.");
			result.setErrorCode(ErrorCode.INVALID_PARAMETER);
			result.makeResponseTime();
			writeObject(result);
			return;
		}
		
		ArrayList<PlaceComment> datas = null;
		PageData page = getPageData();
		if(page != null){
			datas = PlaceCommentDBManager.getInstance().getPagingData(null, "placeId='" + placeId + "'", "DESC commentDate", page);
		}else{
			datas = PlaceCommentDBManager.getInstance().getSelectQueryData(null, "placeId='" + placeId + "'", "DESC commentDate");
		}
		result.setErrorCode(ErrorCode.OK);
		result.setResult(datas);
		result.makeResponseTime();
		writeObject(result);
	}
	
	
	private void notifyNewPost(PlaceComment place){
		
	}

}
