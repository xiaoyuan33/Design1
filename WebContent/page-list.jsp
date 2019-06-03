<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Bootstrap Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
       #vv ul .ab{
            height: 20px;
            width: 100%;
            list-style-type:none;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>
    <body class=""> 
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
			      <a class="brand" href="/Design/index.jsp"><span class="first">软件工程专业工作管理系统</span> <span class="second"></span></a>
		</div>
	</div>
	<div class="sidebar-nav">
		<a href="#dashboard-menu" class="nav-header" data-toggle="collapse" ><i
			class="icon-dashboard"></i>用户管理<i class="icon-chevron-up"></i></a>
		<ul id="dashboard-menu" class="nav nav-list collapse">
			<li><a href="useradd.jsp">添加用户</a></li>
			<!-- a="useradd.jsp"-->
			<li><a href="userchange.jsp">修改用户</a></li>
			<!-- a="userchange.jsp" -->
			<li><a href="listuser/1">查看全部管理信息</a></li>
		</ul>

		<a href="#legal-menu" class="nav-header" data-toggle="collapse"><i
			class="icon-legal"></i>监考管理<i class="icon-chevron-up"></i></a>
		<ul id="legal-menu" class="nav nav-list collapse">
			<li><a href="/Design/examadd.jsp">添加监考信息</a></li>
			<li><a href="/Design/examallot/1">监考分配</a></li>
			<li><a href="/Design/examallotchange/1">监考分配修改</a></li>
			<li><a href="/Design/listexam/1">查看全部考试信息</a></li>
		</ul>
		
		<a href="#news-menu" class="nav-header" data-toggle="collapse" ><i class="icon-question-sign"></i>消息管理<i class="icon-chevron-up"></i></a>
                  <ul id="news-menu" class="nav nav-list collapse in">
                      <li ><a href="page.jsp">发布消息</a></li> 
                      <li ><a href="queryreply">回复消息</a></li> 
                  </ul>
                  <a href="#files-menu" class="nav-header" data-toggle="collapse"><i class="icon-comment"></i>文件管理<i class="icon-chevron-up"></i></a>
                  <ul id="files-menu" class="nav nav-list collapse">
                      <li ><a href="file-up.jsp">发布文件</a></li> 
                      <li ><a href="file-send.jsp">回复文件</a></li> 
                  </ul>
	</div>
            
<div class="content">
        
        <div class="header">
            
            <h1 class="page-title">任务列表</h1>
        </div>
    
        <div class="container-fluid">
            <div class="row-fluid">
    <div class="btn-toolbar">
    <div class="btn-group">
    </div>
    </div>
    <div class="well">
    <ul class="nav nav-tabs">
    </ul>
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
            <div id="vv">
                <ul>
                <li class="ab">未读任务</li>
                <c:forEach items="${unReplyTasks}" var="task" varStatus="s">
                    <li class="ab"><a href="queryone/${task.id}">${task.name}</a></li>
                </c:forEach>
                </ul>
                <ul>
                   <li class="ab">已读任务</li>
                <c:forEach items="${repliedTasks}" var="task" varStatus="s">
                    <li class="ab"><a href="queryone1/${task.id}">${task.name}</a></li>
                </c:forEach>
                </ul>
            </div>
      </div>
    </div>
    
    </div>
    </div>
            </div>
        </div>
    
    
    
    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
    </body>
    </html>