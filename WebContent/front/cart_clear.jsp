<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
session.removeAttribute("cart");//移除Session
response.sendRedirect("cart_null.jsp");//转到购物车为空页面
%>
