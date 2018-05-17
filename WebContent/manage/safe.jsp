<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*"%>
<%if (session.getAttribute("manager")==null){
	out.println("<script language='javascript'>alert('您还没有登录!');window.location.href='../index.jsp';</script>");
}%>
