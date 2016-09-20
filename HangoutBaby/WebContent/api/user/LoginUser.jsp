<%@page import="com.fivetrue.hangoutbaby.api.UserApiHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserApiHandler apiHandler = new UserApiHandler(getServletContext(), request, response);
	apiHandler.loginUser();
 %>