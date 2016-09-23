<%@page import="com.fivetrue.hangoutbaby.api.PlaceCommentApiHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PlaceCommentApiHandler apiHandler = new PlaceCommentApiHandler(getServletContext(), request, response);
	apiHandler.addPlaceComment();
%>