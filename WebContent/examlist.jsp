<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css"
	href="/Design/lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/Design/stylesheets/theme.css">
<link rel="stylesheet" href="/Design/lib/font-awesome/css/font-awesome.css">
<script src="/Design/lib/jquery-1.7.2.min.js" type="text/javascript"></script>

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
<link rel="shortcut icon" href="../assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
<script src="/Design/lib/bootstrap/js/bootstrap.js"></script>
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
						<li><a tabindex="-1" href="/Design/index.jsp">返回主页</a></li>
						<li class="divider"></li>
						<li><a tabindex="-1" class="visible-phone" href="#">Settings</a></li>
						<li class="divider visible-phone"></li>
						<li><a tabindex="-1" href="/Design/logout">注销</a></li>
					</ul></li>
			</ul>
			<a class="brand" href="/Design/index.jsp"><span class="first">软件工程专业工作管理系统</span>
				<span class="second"></span></a>
		</div>
	</div>
	<div class="sidebar-nav">
		<a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i
			class="icon-dashboard"></i>用户管理</a>
		<ul id="dashboard-menu" class="nav nav-list collapse">
			<li><a href="/Design/useradd.jsp">添加用户</a></li>
			<!-- a="useradd.jsp"-->
			<li><a href="/Design/userchange.jsp">修改用户</a></li>
			<!-- a="userchange.jsp" -->
			<li><a href="/Design/listuser/1">查看全部管理信息</a></li>
		</ul>

		<a href="#legal-menu" class="nav-header" data-toggle="collapse"><i
			class="icon-legal"></i>监考管理</a>
		<ul id="legal-menu" class="nav nav-list collapse in">
			<li><a href="/Design/examadd.jsp">添加监考信息</a></li>
			<li><a href="/Design/examallot/1">监考分配</a></li>
			<li><a href="/Design/examallotchange/1">监考分配修改</a></li>
			<li><a href="/Design/listexam/1">查看全部考试信息</a></li>
		</ul>

		<a href="#news-menu" class="nav-header" data-toggle="collapse"><i
			class="icon-question-sign"></i>消息管理</a>
		<ul id="news-menu" class="nav nav-list collapse">
			<li><a href="/Design/page.jsp">发布消息</a></li>
			<li><a href="/Design/page-list.jsp">回复消息</a></li>
		</ul>
		<a href="#files-menu" class="nav-header" data-toggle="collapse"><i
			class="icon-comment"></i>文件管理</a>
		<ul id="files-menu" class="nav nav-list collapse">
			<li><a href="/Design/file-up.jsp">发布文件</a></li>
			<li><a href="/Design/file-send.jsp">回复文件</a></li>
		</ul>
	</div>
	<div class="content">

		<div class="header">

			<h1 class="page-title">查看全部考试信息</h1>
		</div>

		<div class="container-fluid">
			<div class="row-fluid">
				<!-- 这里的内容所对应的是uesrlist.jsp中的table -->
				<div class="btn-toolbar"></div>
				<table width="80%" align="center" border=1>
					<tr class="tr_title">
						<td>序号</td>
						<td>考试名</td>
						<td>地点</td>
						<td>开始时间</td>
						<td>结束时间</td>
						<td>监考人数</td>
						<td>状态</td>
					</tr>

					<c:forEach items="${pageInfo.list}" var="clazz" varStatus="statee">
						<tr>
							<td>${statee.count+(pageInfo.pageNum-1)*pageInfo.pageSize}</td>
							<td>${clazz.name}</td>
							<td>${clazz.position}</td>
							<td>${clazz.startTime}</td>
							<td>${clazz.endTime}</td>
							<td>${clazz.num}</td>
							<td>${clazz.state}</td>

						</tr>
					
					</c:forEach>
						</table>
					<div class="modal small hide fade" id="myModal" tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h3 id="myModalLabel">Delete Confirmation</h3>
						</div>
						<div class="modal-body">

							<p class="error-text">
								<i class="icon-warning-sign modal-icon"></i>Are you sure you
								want to delete the user?
							</p>
						</div>
						<div class="modal-footer">
							<button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
							<button class="btn btn-danger" data-dismiss="modal">Delete</button>
						</div>
					</div>
					</div>
					</div>
					</div>
</body>
</html>