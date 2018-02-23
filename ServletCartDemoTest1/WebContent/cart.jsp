<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="entity.Cart" %>
<%@ page import="entity.Item" %>
<%@ page import="java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Cart page</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link type="text/css" rel="stylesheet" href="css/style1.css" />
		<script language="javascript" >
			function delcfm() {
				if(!confirm("确认要删除？")) {
					window.event.returnValue = false;
				}
			}
		</script>
	</head>
	<body>
		<h1>购物车</h1>
		<a href="itemsList.jsp">首页</a> >> <a href="itemsList.jsp">商品列表</a>
		<hr>
		<div id="shopping">
			<form action="" method="">
				<table>
					<tr>
						<th>商品名称</th>
						<th>商品单间</th>
						<th>商品价格</th>
						<th>购买数量</th>
						<th>操作</th>
					</tr>
					<%
						//判断session中是否有cart对象
						if(request.getSession().getAttribute("cart") != null) {
							out.print("session中有cart对象，当前是cart.jsp页面");
					%>
						<%
							//遍历购物车
							Cart cart = (Cart)request.getSession().getAttribute("cart");
							//获取购物车信息（Cart类中有将购物车中商品获取的方法getGoods返回键值对）
							HashMap<Item, Integer> goods = cart.getGoods();
							//获取HashMap中所有的键
							Set<Item> items = goods.keySet();
							Iterator it = items.iterator();
							
							while(it.hasNext()) {
								Item i = (Item)it.next();	
						%>
					<tr name="products" id="product_id_1">
						<td class="thumb"><img src="images/<%=i.getPicture()%>" height="200" width="200"><a href=""><%=i.getName() %></a></td>
						<td class="number"><%=i.getPrice() %></td>
						<td class="price" id="price_id_1">
							<span><%=i.getPrice()*goods.get(i) %></span>
							<input type="hidden" value="" />
						</td>
						<td class="number"><%=goods.get(i) %></td>
						<td class="delete">
							<a href="servlet/CartServlet?action=delete&id=<%=i.getId() %>" onclick="delcfm();">删除</a>
						</td>
					</tr>
						<%
							}
						%>
				</table>
				<div class="total"><span id="total">总计：<%=cart.getTotalPrice() %>￥</span></div>
				<div class=""></div>
				<%
						}
				%>
			</form>
		</div>
	</body>
</html>