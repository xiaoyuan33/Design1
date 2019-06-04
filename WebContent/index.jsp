<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

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
	color: #fff;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold; 
}
</style>
<link rel="shortcut icon" href="../assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" 
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" 
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
<title>Insert title here</title>
<script src="lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	$("[rel=tooltip]").tooltip();
	$(function() {
		$('.demo-cancel-click').click(function() {
			return false;
		});
	});
</script>
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
			      <a class="brand" href="/Design/index.jsp"><span class="first">NEFU考试后台系统</span> <span class="second"></span></a>
		</div>
	</div>
	<div class="sidebar-nav">
		<a href="#dashboard-menu" class="nav-header" data-toggle="collapse" ><i
			class="icon-dashboard"></i>用户管理<i class="icon-chevron-up"></i></a>
		<ul id="dashboard-menu" class="nav nav-list collapse in">
			<li><a href="useradd.jsp">用户注册</a></li>
			<!-- a="useradd.jsp"-->
			<li><a href="userchange.jsp">用户修改</a></li>
			<!-- a="userchange.jsp" -->
			<li><a href="listuser/1">权限设置</a></li>
		</ul>

		<a href="#legal-menu" class="nav-header" data-toggle="collapse"><i
			class="icon-legal"></i>监考管理<i class="icon-chevron-up"></i></a>
		<ul id="legal-menu" class="nav nav-list collapse">
			<li><a href="/Design/examadd.jsp">添加监考信息</a></li>
			<li><a href="/Design/examallot/1">监考分配</a></li>
			<li><a href="/Design/listexam/1">查看全部考试信息</a></li>
		</ul>
		
		<a href="#news-menu" class="nav-header" data-toggle="collapse" ><i class="icon-question-sign"></i>任务管理<i class="icon-chevron-up"></i></a>
                  <ul id="news-menu" class="nav nav-list collapse">
                      <li ><a href="page.jsp">发布新任务</a></li> 
                      <li ><a href="page-list.jsp">任务列表</a></li> 
                  </ul>

	</div>

	<div class="content">

		<div class="header">
			<div class="stats"></div>
			<h1 class="page-title">我的管理系统</h1>
		</div>

		<ul class="breadcrumb">
			<li><a href="index.jsp">主页</a> <span class="divider">/</span></li>
		</ul>
		<div class="container-fluid">
			<div class="row-fluid">


				<div class="row-fluid">

					<div class="alert alert-info">
						<button type="button" class="close">×</button>
						<strong>${name}</strong> 欢迎来到软件工程专业管理系统123
					</div>

					<div class="block">
						<a href="#page-stats" class="block-heading">这里有</a>
						<div id="page-stats" class="block-body collapse in">

							<div class="stat-widget-container">
								<div class="stat-widget">
									<div class="stat-button">
										<p class="title">500</p>
										<p class="detail">用户</p>
									</div>
								</div>

								<div class="stat-widget">
									<div class="stat-button">
										<p class="title">11</p>
										<p class="detail">老师</p>
									</div>
								</div>

								<div class="stat-widget">
									<div class="stat-button">
										<p class="title">10</p>
										<p class="detail">任务</p>
									</div>
								</div>

								<div class="stat-widget">
									<div class="stat-button">
										<p class="title">50</p>
										<p class="detail">考试</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>