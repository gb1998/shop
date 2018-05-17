<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%
session.invalidate();
response.sendRedirect("../index.jsp");
%>
