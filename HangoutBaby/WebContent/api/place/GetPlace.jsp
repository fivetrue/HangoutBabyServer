<%@page import="com.fivetrue.hangoutbaby.api.PlaceApiHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PlaceApiHandler apiHandler = new PlaceApiHandler(getServletContext(), request, response);
	apiHandler.getPlace();
%>