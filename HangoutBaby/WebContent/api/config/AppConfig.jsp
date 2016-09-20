<%@page import="com.fivetrue.hangoutbaby.api.AppConfigApiHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	AppConfigApiHandler apiHandler = new AppConfigApiHandler(getServletContext(), request, response);
	apiHandler.getAppConfig();
%>