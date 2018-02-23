<!-- @author LZD	2018/02/08 -->
<!-- 展示商品详情页 -->
<%@page import="java.util.ArrayList"%>
<%@ page import="dao.itemsDao"%>
<%@ page import="entity.Item"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 
				request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>商品详情页</title>
		
		<link href="css/main.css" rel="stylesheet" type="text/css" >
		<script type="text/javascript" src="js/lhgcore.js"></script>
		<script type="text/javascript" src="js/lhgdialog.js"></script>
		<script type="text/javascript">
			function selflog_show(id) {
				var num = document.getElementById("number").value;
				J.dialog.get({id: 'haoyue_creat', title:'购物成功', width:600, height:400,
					link:'<%=path%>/CartServlet?id=' + id + '&num=' + num + '&action=add', cover:true});
			}
			
			function getNum() {
				var num = document.getElementById("number").value;
			}
			
			function add() {
				var num = parseInt(document.getElementById("number").value);
				if(num < 100) {
					document.getElementById("number").value = ++num;
				}
			}
			
			function sub() {
				var num = parseInt(document.getElementById("number").value);
				if(num > 1) {
					document.getElementById("number").value = --num;
				}
			}
		</script>
		
		<style type="text/css">
		hr {
			border-color:FF7F00;
		}
		
		div {
			float: left;
			margin-left: 30px;
			margin-right: 30px;
			margin-top: 5px;
			margin-bottom: 5px;
		}
		
		div dd {
			margin: 0px;
			font-size: 10pt;
		}
		
		div dd.dd_name {
			color: blue;
		}
		
		div dd.dd_city {
			color: #000;
		}
		
		div #cart {
			margin:0px auto;
			text-align:right;
		}
		span {
			padding:0 2px;border:1px #c0c0c0 solid;cursor:pointer;
		}
		a {
			text-decoration:none;
		}
		</style>
	</head>
	<body>
		<h1>商品详情</h1>
		<br><br>
		<center>
			<table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
				<tr>
				<%
				Item i = new Item();
				i = new itemsDao().getItemById(Integer.parseInt(request.getParameter("id")));
				if(i != null) {
				%>
				<td width="70%" valign="top">
					<table>
						<tr>
							<td rowspan="4"><img src="images/<%=i.getPicture()%>"
								width="200" height="160" /></td>
						</tr>
						<tr>
							<td><B><%=i.getName()%></B></td>
						</tr>
						<tr>
							<td>产地：<%=i.getCity()%></td>
						</tr>
						<tr>
							<td>价格：<%=i.getPrice()%>￥
							</td>
						</tr>
						<tr>
							<td>
								购买数量：<span id="sub" onclick="sub();">-</span>
								<input type="text" id="number" name="number" value="1" size="2" />
								<span id="add" onclick="add();">+</span>
							</td>
						</tr>
					</table>
					<div>
						<img src="images/buy_now.png">
						<a href="javascript:selflog_show(<%=i.getId()%>)"><img src="images/in_cart.png"></a>
						<a href="CartServlet?action=show"><img src="images/view_cart.jpg"></a>
					</div>
				</td>
				<%
				}
				%>
				</tr>
			</table>
		</center>
	</body>
</html>