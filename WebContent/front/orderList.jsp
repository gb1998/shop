<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.sql.*"%>
<%@ page import="java.util.Vector"%>
<%@ page import="com.model.Goodselement"%>
<jsp:useBean id="conn" scope="page" class="com.tools.ConnDB" />
<%
	String username = "";
	username = (String) session.getAttribute("username");
	if (username == "" || username == null) {
		out.println("<script language='javascript'>alert('请先登录!');window.location.href='index.jsp';</script>");
	} else {
		ResultSet rs = conn.executeQuery(
				"select * from tb_order t1,tb_order_detail t2,tb_goods t3 where t2.goodsID=t3.ID and t1.OrderID=t2.orderID and t1.username='"
						+ username + "' order by t1.OrderDate desc");
		rs.last();
		int RecordCount = rs.getRow();
		if (RecordCount == 0) {
			out.println("<script language='javascript'>window.location.href='order_null.jsp';</script>");
			return;
		}
		rs.beforeFirst();
		int orderID = 0;
		int number = 0;
		String recevieName = "";
		String tel = "";
		String goodsName = "";
		float price = 0;
		String orderDate = "";
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>我的购物车-51商城</title>
<link rel="stylesheet" href="css/mr-01.css" type="text/css">

<script src="js/jsArr01.js" type="text/javascript"></script>
<script src="js/module.js" type="text/javascript"></script>
<script src="js/jsArr02.js" type="text/javascript"></script>
<script src="js/tab.js" type="text/javascript"></script>
</head>

<body>
	<jsp:include page="index-loginCon.jsp" />
	<!-- 网站头部 -->
	<%@ include file="common-header.jsp"%>
	<!-- //网站头部 -->
	<div id="mr-mainbody" class="container mr-mainbody">
		<div class="row">
			<!-- 显示订单列表 -->
			<div id="mr-content" class="mr-content col-xs-12">
				<div id="mrshop" class="mrshop common-home">
					<div class="container_oc">
						<div class="row">
							<div id="content_oc" class="col-sm-12">
								<h1>我的订单</h1>
									<div class="table-responsive cart-info">
										<table class="table table-bordered">
											<thead>
												<tr>
													<td class="text-center image">订单号</td>
													<td class="text-center name">产品名称</td>
													<td class="text-center name">购买数量</td>
													<td class="text-center name">单价</td>
													<td class="text-center name">消费金额</td>
													<td class="text-center quantity">收货人姓名</td>
													<td class="text-center price">收货人手机</td>
													<td class="text-center total">下单日期</td>
												</tr>
											</thead>
											<tbody>
												<%
													while (rs.next()) {
															orderID = rs.getInt("orderID");
															goodsName = rs.getString("goodsName");
															number = rs.getInt("number");
															recevieName = rs.getString("recevieName");
															tel = rs.getString("tel");
															price = rs.getFloat("price");
															orderDate = rs.getString("orderDate");
															orderDate = orderDate.substring(0, 16);
												%>
												<tr>
													<td class="text-center image" width="10%"><%=orderID%>
													</td>
													<td class="text-center name"><%=goodsName%></td>
													<td class="text-center quantity"><%=number%>件</td>
													<td class="text-center quantity"><%=price%>元</td>
													<td class="text-center quantity"><%=number * price%>元</td>
													<td class="text-center quantity"><%=recevieName%></td>
													<td class="text-center quantity"><%=tel%></td>
													<td class="text-center quantity"><%=orderDate%></td>
												</tr>
												<%
													}
												%>
											</tbody>
										</table>
									</div>
							</div>
						</div>
						<br /><br />
						<div class="row">
							<div id="content_oc" class="col-sm-12">
								<br />
								<br />
								<div class="buttons">
									<div class="pull-right">
										<a href="index.jsp" class="tigger btn btn-primary btn-primary">继续购物</a>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		<!-- //显示订单列表 -->
		</div>
	</div>
	<!-- 版权栏 -->
	<%@ include file="common-footer.jsp"%>
	<!-- //版权栏 -->
</body>
</html>
<%
	conn.close();
	}
%>
