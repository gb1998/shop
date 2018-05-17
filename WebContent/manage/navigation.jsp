<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<table width="199" height="431"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="18" colspan="3"><img src="${pageContext.request.contextPath}/manage/images/manage_rightTitle.GIF" width="189" height="37" /></td>
          </tr>
          <tr>
            <td height="9" colspan="3" background="${pageContext.request.contextPath}/manage/images/manage_rightKtop.GIF"></td>
          </tr>

          <tr>
            <td colspan="3" align="center" valign="top" background="${pageContext.request.contextPath}/manage/images/manage_rightKmid.GIF"><table width="90%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="20%" height="50" align="center" class="tableBorder_B_dashed"><img src="${pageContext.request.contextPath}/manage/images/manage_listIco.GIF" width="10" height="11" /></td>
            <td width="80%" class="tableBorder_B_dashed"><a href="index.jsp">商品管理<br>
              Goods Manage</a></td>
            </tr>
            <tr>
            <td height="50" align="center" class="tableBorder_B_dashed"><img src="${pageContext.request.contextPath}/manage/images/manage_listIco.GIF" width="10" height="11" /></td>
            <td class="tableBorder_B_dashed"><a href="topmanage.jsp">销量排行榜<br>
              Sale Top 10</a></td>
            </tr>
          <tr>
            <td height="50" align="center" class="tableBorder_B_dashed"><img src="${pageContext.request.contextPath}/manage/images/manage_listIco.GIF" width="10" height="11" /></td>
            <td class="tableBorder_B_dashed"><a href="membermanage.jsp">会员管理<br>
              Member Manage</a></td>
            </tr>
          <tr>
            <td height="50" align="center" class="tableBorder_B_dashed"><img src="${pageContext.request.contextPath}/manage/images/manage_listIco.GIF" width="10" height="11" /></td>
            <td class="tableBorder_B_dashed"><a href="ordermanage.jsp?orderId=0" >订单管理<br>
              Order Manage</a></td>
            </tr>
            <tr>
            <td height="50" align="center" class="tableBorder_B_dashed"><img src="${pageContext.request.contextPath}/manage/images/manage_listIco.GIF" width="10" height="11" /></td>
            <td class="tableBorder_B_dashed"><a href="logout.jsp">退出后台<br>
              Exit Background </a></td>
            </tr>
            </table></td>
          </tr>
          <tr>
            <td height="9" colspan="3" align="center" background="${pageContext.request.contextPath}/manage/images/manage_rightKbottom.GIF"></td>
          </tr>
</table>
