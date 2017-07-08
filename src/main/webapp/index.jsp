<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
<style>
#main {
	width:1000px;
	height: auto;
}

#left {
	width:300px;
	height: 600px;
}

#right {
	width: 500px;
	height: 600px;
	margin-left:10px;
}

#left, #right {
	float: left;
}
</style>

<body>
	<!-- 下面两种写法都可以访问 -->
	<div id="main">
		<div id="left">
		<form action="${pageContext.request.contextPath }/category_save.action"
		method="post">
		<h3>添加类别</h3>
		商品类型 <input type="text" name="type" /> <br> 是否热销（true或者false） <input
			type="text" name="hot" /> <input type="submit">
	</form>
	<form
		action="${pageContext.request.contextPath }/category_update.action"
		method="post">
		<h3>更新类别</h3>
		商品id<input type="text" name="id" /> <br> 商品类型 <input type="text"
			name="type" /> <br> 是否热销（true或者false） <input type="text"
			name="hot" /> <input type="submit">
	</form>

	<form
		action="${pageContext.request.contextPath }/category_delete.action"
		method="post">
		<h3>删除类别</h3>
		商品id<input type="text" name="id" /> <input type="submit">
	</form>
		
		
		</div>
		<div id="right">
		<h3>
		<a href="category_query.action">查询所有类别</a>
	</h3>
	<br />
	<h1>requestScope域</h1>
	
	 <table border="1">
	 <tr><td>ID</td><td>类别</td><td>是否热销</td> </tr>
		<c:forEach items="${requestScope.categoryList }" var="category">  
      <tr> <td> ${category.id } </td> <td>${category.type } </td><td> ${category.hot }</td> </tr> 
		</c:forEach>
		</table>
	 
	<h1>sessionScope域</h1>
  <table border="1">
	 <tr><td>ID</td><td>类别</td><td>是否热销</td> </tr>
		<c:forEach items="${sessionScope.categoryList }" var="category">  
      <tr> <td> ${category.id } </td> <td>${category.type } </td><td> ${category.hot }</td> </tr> 
		</c:forEach>
	 </table>
	<h1>applicationScope域</h1>
  <table border="1">
	 <tr><td>ID</td><td>类别</td><td>是否热销</td> </tr>
		<c:forEach items="${applicationScope.categoryList }" var="category">  
     <tr> <td> ${category.id } </td> <td>${category.type } </td><td> ${category.hot }</td> </tr> 
		</c:forEach>
 </table>
		
		</div>
	</div>
	


	
</body>
</html>
