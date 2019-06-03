<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="../lib/bootstrap/css/bootstrap.css">

<link rel="stylesheet" type="text/css" href="../stylesheets/theme.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">

<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
<script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

<!-- Demo page code -->

<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}
</style>
<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="../assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
<script src="lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	$("[rel=tooltip]").tooltip();
	$(function() {
		$('.demo-cancel-click').click(function() {
			return false;
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav pull-right">

				<li id="fat-menu" class="dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-user"></i>${user.name}<i class="icon-caret-down"></i>
				</a>
					<ul class="dropdown-menu">
						<li><a tabindex="-1" href="index.jsp">返回主页</a></li>
						<li class="divider"></li>
						<li><a tabindex="-1" class="visible-phone" href="#">Settings</a></li>
						<li class="divider visible-phone"></li>
						<li><a tabindex="-1" href="logout">注销</a></li>
					</ul></li>
			</ul>
			<a class="brand" href="index.jsp"><span class="first">软件工程专业工作管理系统</span>
				<span class="second"></span></a>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<!-- 这里的内容所对应的是uesrlist.jsp中的table -->
			<div class="btn-toolbar"></div>
			<table width="98%" align="center" border=1>
				<caption>用户</caption>
				<tr class="tr_title">
					<td>序号</td>
					<td>用户名</td>
					<td>权限</td>
					<td>权限设置</td>
				</tr>
				<c:forEach items="${pageInfo.list}" var="clazz" varStatus="state">
					<tr>
						<td>${state.count+(pageInfo.pageNum-1)*pageInfo.pageSize}</td>
						<td>${clazz.name}</td>
						<td>${clazz.authority}</td>
						<c:if test="${clazz.authority=='user'}">
						<td><button type="button" onclick="change(this)" name="${clazz.name}">修改</button></td>
						</c:if>
						<c:if test="${clazz.authority=='admin'}">
						<td><button type="button" onclick="del(this)" name="${clazz.name}">删除</button></td>
						</c:if>
					</tr>
				</c:forEach>

			</table>
			<div align="center">总页数${pageInfo.pages} 总记录数${pageInfo.total}
				当前页号${pageInfo.pageNum} 每页记录数${pageInfo.pageSize}</div>
			<div align="center">
				<a href="${pageInfo.firstPage}">首页</a> <a href="${pageInfo.prePage}">上一页</a>
				<a href="${pageInfo.nextPage}">下一页</a> <a
					href="${pageInfo.lastPage}">尾页</a> <a href="../index.jsp">返回</a>
			</div>
		</div>
	</div>

	<div class="modal small hide fade" id="myModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">Delete Confirmation</h3>
		</div>
		<div class="modal-body">
			<p class="error-text">
				<i class="icon-warning-sign modal-icon"></i>Are you sure you want to
				delete the user?
			</p>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
			<button class="btn btn-danger" data-dismiss="modal">Delete</button>
		</div>
	</div>
</body>
<script type="text/javascript">

</script>
</html>