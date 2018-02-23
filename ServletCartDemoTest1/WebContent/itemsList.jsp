<!-- @author LZD	2018/02/08 -->
<!-- 展示所有商品页 -->
<%@ page import="dao.itemsDao" %>
<%@ page import="entity.Item" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":"
					+ request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv = "Content-Type" content="text/html; charset=utf-8">
		<title>商品展示页</title>
		<style type="text/css" >
			div{
				float:left;
				margin:10px;
			}
			div dd{
				margin:0px;
				font-size:10pt;
			}
			div dd.dd_name{	color:blue;	}
			div dd.dd_city(	color:#000;	)
		</style>
	</head>
<body>
	<h1>商品展示</h1>
	<hr>
	<center>
		<table width="750" height="60" cellpadding="0" border="0">
			<tr>
				<td>
				<!-- 遍历所有商品 -->
				<%
				itemsDao itemsDao = new itemsDao();
				ArrayList<Item> list = itemsDao.getAllItems();
				if(list != null && list.size()>0) {
					for(Item i : list) {
				%>
				<div>
					<dl>
						<dt>
							<a href="goodsInfo.jsp?id=<%=i.getId() %>" target="_blank">
							<img src="images/<%=i.getPicture() %>" width="120" height="90" border="1" />
							</a>
						</dt>
						<dd class="dd_name"><%=i.getName() %></dd>
						<dd class="dd_city">产地：<%=i.getCity() %>&nbsp;&nbsp;价格：<%=i.getPrice() %></dd>
					</dl>
				</div>
				<%
					}
				}
				%>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>