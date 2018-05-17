<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<jsp:useBean id="conn" scope="page" class="com.tools.ConnDB"/>
<jsp:include page="safe.jsp"/>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
<%
if(request.getParameter("ID")!=""){
	int ID=Integer.parseInt(request.getParameter("ID"));
	String sql="update tb_order set enforce=1 where orderID="+ID;
	int ret=0;
	ret=conn.executeUpdate(sql);
	if (ret!=0){
		out.println("<script language='javascript'>alert('订单执行成功！');window.location.href='ordermanage.jsp';</script>");
		}else{
		out.println("<script language='javascript'>alert('订单执行失败！');window.location.href='ordermanage.jsp';</script>");
	}
}
%>
</body>
</html>
