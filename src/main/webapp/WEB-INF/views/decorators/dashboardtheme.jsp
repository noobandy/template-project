<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ page errorPage="../pages/examples/500.jsp"%>

<jsp:include page="../parts/cachecontrol.jsp"></jsp:include>

<html>
<head>
<title><sitemesh:write property='title' /></title>
<sitemesh:write property='head' />
</head>
<body class="skin-blue">
	<!-- header logo: style can be found in header.less -->
	<header class="header">
		<a href="${pageContext.request.contextPath}/" class="logo"> <!-- Add the class icon to your logo image or logo icon to add the margining -->
			AdminLTE
		</a>
		<!-- Header Navbar: style can be found in header.less -->
		<nav class="navbar navbar-static-top" role="navigation">
			<!-- Sidebar toggle button-->
			<a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas"
				role="button"> <span class="sr-only">Toggle navigation</span> <span
				class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
			</a>
			<div class="navbar-right">
				<ul class="nav navbar-nav">
					<!-- Messages: style can be found in dropdown.less-->
					<li class="dropdown messages-menu"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="fa fa-envelope"></i> <span class="label label-success">4</span>
					</a>
						<ul class="dropdown-menu">
							<li class="header">You have 4 messages</li>
							<li>
								<!-- inner menu: contains the actual data -->
								<ul class="menu">
									<li>
										<!-- start message --> <a href="#">
											<div class="pull-left">
												<img
													src="${pageContext.request.contextPath}/resources/img/avatar3.png"
													class="img-circle" alt="User Image" />
											</div>
											<h4>
												Support Team <small><i class="fa fa-clock-o"></i> 5
													mins</small>
											</h4>
											<p>Why not buy a new awesome theme?</p>
									</a>
									</li>
									<!-- end message -->
									<li><a href="#">
											<div class="pull-left">
												<img
													src="${pageContext.request.contextPath}/resources/img/avatar2.png"
													class="img-circle" alt="user image" />
											</div>
											<h4>
												AdminLTE Design Team <small><i class="fa fa-clock-o"></i>
													2 hours</small>
											</h4>
											<p>Why not buy a new awesome theme?</p>
									</a></li>
									<li><a href="#">
											<div class="pull-left">
												<img
													src="${pageContext.request.contextPath}/resources/img/avatar.png"
													class="img-circle" alt="user image" />
											</div>
											<h4>
												Developers <small><i class="fa fa-clock-o"></i>
													Today</small>
											</h4>
											<p>Why not buy a new awesome theme?</p>
									</a></li>
									<li><a href="#">
											<div class="pull-left">
												<img
													src="${pageContext.request.contextPath}/resources/img/avatar2.png"
													class="img-circle" alt="user image" />
											</div>
											<h4>
												Sales Department <small><i class="fa fa-clock-o"></i>
													Yesterday</small>
											</h4>
											<p>Why not buy a new awesome theme?</p>
									</a></li>
									<li><a href="#">
											<div class="pull-left">
												<img
													src="${pageContext.request.contextPath}/resources/img/avatar.png"
													class="img-circle" alt="user image" />
											</div>
											<h4>
												Reviewers <small><i class="fa fa-clock-o"></i> 2
													days</small>
											</h4>
											<p>Why not buy a new awesome theme?</p>
									</a></li>
								</ul>
							</li>
							<li class="footer"><a href="#">See All Messages</a></li>
						</ul></li>
					<!-- Notifications: style can be found in dropdown.less -->
					<li class="dropdown notifications-menu"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="fa fa-warning"></i> <span class="label label-warning">10</span>
					</a>
						<ul class="dropdown-menu">
							<li class="header">You have 10 notifications</li>
							<li>
								<!-- inner menu: contains the actual data -->
								<ul class="menu">
									<li><a href="#"> <i class="ion ion-ios7-people info"></i>
											5 new members joined today
									</a></li>
									<li><a href="#"> <i class="fa fa-warning danger"></i>
											Very long description here that may not fit into the page and
											may cause design problems
									</a></li>
									<li><a href="#"> <i class="fa fa-users warning"></i> 5
											new members joined
									</a></li>

									<li><a href="#"> <i class="ion ion-ios7-cart success"></i>
											25 sales made
									</a></li>
									<li><a href="#"> <i class="ion ion-ios7-person danger"></i>
											You changed your username
									</a></li>
								</ul>
							</li>
							<li class="footer"><a href="#">View all</a></li>
						</ul></li>
					<!-- Tasks: style can be found in dropdown.less -->
					<li class="dropdown tasks-menu"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="fa fa-tasks"></i> <span class="label label-danger">9</span>
					</a>
						<ul class="dropdown-menu">
							<li class="header">You have 9 tasks</li>
							<li>
								<!-- inner menu: contains the actual data -->
								<ul class="menu">
									<li>
										<!-- Task item --> <a href="#">
											<h3>
												Design some buttons <small class="pull-right">20%</small>
											</h3>
											<div class="progress xs">
												<div class="progress-bar progress-bar-aqua"
													style="width: 20%" role="progressbar" aria-valuenow="20"
													aria-valuemin="0" aria-valuemax="100">
													<span class="sr-only">20% Complete</span>
												</div>
											</div>
									</a>
									</li>
									<!-- end task item -->
									<li>
										<!-- Task item --> <a href="#">
											<h3>
												Create a nice theme <small class="pull-right">40%</small>
											</h3>
											<div class="progress xs">
												<div class="progress-bar progress-bar-green"
													style="width: 40%" role="progressbar" aria-valuenow="20"
													aria-valuemin="0" aria-valuemax="100">
													<span class="sr-only">40% Complete</span>
												</div>
											</div>
									</a>
									</li>
									<!-- end task item -->
									<li>
										<!-- Task item --> <a href="#">
											<h3>
												Some task I need to do <small class="pull-right">60%</small>
											</h3>
											<div class="progress xs">
												<div class="progress-bar progress-bar-red"
													style="width: 60%" role="progressbar" aria-valuenow="20"
													aria-valuemin="0" aria-valuemax="100">
													<span class="sr-only">60% Complete</span>
												</div>
											</div>
									</a>
									</li>
									<!-- end task item -->
									<li>
										<!-- Task item --> <a href="#">
											<h3>
												Make beautiful transitions <small class="pull-right">80%</small>
											</h3>
											<div class="progress xs">
												<div class="progress-bar progress-bar-yellow"
													style="width: 80%" role="progressbar" aria-valuenow="20"
													aria-valuemin="0" aria-valuemax="100">
													<span class="sr-only">80% Complete</span>
												</div>
											</div>
									</a>
									</li>
									<!-- end task item -->
								</ul>
							</li>
							<li class="footer"><a href="#">View all tasks</a></li>
						</ul></li>
					<!-- User Account: style can be found in dropdown.less -->
					<li class="dropdown user user-menu"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="glyphicon glyphicon-user"></i> <span><security:authentication
									property="principal.userId" /> <i class="caret"></i></span>
					</a>
						<ul class="dropdown-menu">
							<!-- User image -->
							<li class="user-header bg-light-blue"><img
								src="${pageContext.request.contextPath}/resources/img/avatar3.png"
								class="img-circle" alt="User Image" />
								<p>
									<span><security:authentication
											property="principal.userId" /> - Web Developer <small>Member
											since Nov. 2012</small>
								</p></li>
							<!-- Menu Body -->
							<li class="user-body">
								<div class="col-xs-4 text-center">
									<a href="#">Followers</a>
								</div>
								<div class="col-xs-4 text-center">
									<a href="#">Sales</a>
								</div>
								<div class="col-xs-4 text-center">
									<a href="#">Friends</a>
								</div>
							</li>
							<!-- Menu Footer-->
							<li class="user-footer">
								<div class="pull-left">
									<a href="#" class="btn btn-default btn-flat">Profile</a>
								</div>
								<div class="pull-right">
									<a
										href="${pageContext.request.contextPath}/j_spring_security_logout"
										class="btn btn-default btn-flat">Sign out</a>
								</div>
							</li>
						</ul></li>
				</ul>
			</div>
		</nav>
	</header>
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="left-side sidebar-offcanvas">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel -->
				<div class="user-panel">
					<div class="pull-left image">
						<img
							src="${pageContext.request.contextPath}/resources/img/avatar3.png"
							class="img-circle" alt="User Image" />
					</div>
					<div class="pull-left info">
						<p>Hello, Jane</p>

						<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
					</div>
				</div>
				<!-- search form -->
				<form action="#" method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="form-control"
							placeholder="Search..." /> <span class="input-group-btn">
							<button type='submit' name='seach' id='search-btn'
								class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
				<!-- /.search form -->
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">
					<li class="active"><a
						href="${pageContext.request.contextPath}/"> <i
							class="fa fa-dashboard"></i> <span>Dashboard</span>
					</a></li>
					<li><a href="${pageContext.request.contextPath}/pages/widgets">
							<i class="fa fa-th"></i> <span>Widgets</span> <small
							class="badge pull-right bg-green">new</small>
					</a></li>
					<li class="treeview"><a href="#"> <i
							class="fa fa-bar-chart-o"></i> <span>Charts</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="${pageContext.request.contextPath}/pages/charts/morris"><i
									class="fa fa-angle-double-right"></i> Morris</a></li>
							<li><a
								href="${pageContext.request.contextPath}/pages/charts/flot"><i
									class="fa fa-angle-double-right"></i> Flot</a></li>
							<li><a
								href="${pageContext.request.contextPath}/pages/charts/inline"><i
									class="fa fa-angle-double-right"></i> Inline charts</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-laptop"></i>
							<span>UI Elements</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="${pageContext.request.contextPath}/pages/UI/general"><i
									class="fa fa-angle-double-right"></i> General</a></li>
							<li><a
								href="${pageContext.request.contextPath}/pages/UI/icons"><i
									class="fa fa-angle-double-right"></i> Icons</a></li>
							<li><a
								href="${pageContext.request.contextPath}/pages/UI/buttons"><i
									class="fa fa-angle-double-right"></i> Buttons</a></li>
							<li><a
								href="${pageContext.request.contextPath}/pages/UI/sliders"><i
									class="fa fa-angle-double-right"></i> Sliders</a></li>
							<li><a
								href="${pageContext.request.contextPath}/pages/UI/timeline"><i
									class="fa fa-angle-double-right"></i> Timeline</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-edit"></i>
							<span>Forms</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="${pageContext.request.contextPath}/pages/forms/general"><i
									class="fa fa-angle-double-right"></i> General Elements</a></li>
							<li><a
								href="${pageContext.request.contextPath}/pages/forms/advanced"><i
									class="fa fa-angle-double-right"></i> Advanced Elements</a></li>
							<li><a
								href="${pageContext.request.contextPath}/pages/forms/editors"><i
									class="fa fa-angle-double-right"></i> Editors</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-table"></i>
							<span>Tables</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="${pageContext.request.contextPath}/pages/tables/simple"><i
									class="fa fa-angle-double-right"></i> Simple tables</a></li>
							<li><a
								href="${pageContext.request.contextPath}/pages/tables/data"><i
									class="fa fa-angle-double-right"></i> Data tables</a></li>
						</ul></li>
					<li><a
						href="${pageContext.request.contextPath}/pages/calendar"> <i
							class="fa fa-calendar"></i> <span>Calendar</span> <small
							class="badge pull-right bg-red">3</small>
					</a></li>
					<li><a href="${pageContext.request.contextPath}/pages/mailbox">
							<i class="fa fa-envelope"></i> <span>Mailbox</span> <small
							class="badge pull-right bg-yellow">12</small>
					</a></li>
					<li class="treeview"><a href="#"> <i class="fa fa-folder"></i>
							<span>Examples</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="${pageContext.request.contextPath}/pages/examples/invoice"><i
									class="fa fa-angle-double-right"></i> Invoice</a></li>
							<li><a
								href="${pageContext.request.contextPath}/pages/examples/login"><i
									class="fa fa-angle-double-right"></i> Login</a></li>
							<li><a
								href="${pageContext.request.contextPath}/pages/examples/register"><i
									class="fa fa-angle-double-right"></i> Register</a></li>
							<li><a
								href="${pageContext.request.contextPath}/pages/examples/lockscreen"><i
									class="fa fa-angle-double-right"></i> Lockscreen</a></li>
							<li><a
								href="${pageContext.request.contextPath}/pages/examples/404"><i
									class="fa fa-angle-double-right"></i> 404 Error</a></li>
							<li><a
								href="${pageContext.request.contextPath}/pages/examples/500"><i
									class="fa fa-angle-double-right"></i> 500 Error</a></li>
							<li><a
								href="${pageContext.request.contextPath}/pages/examples/blank"><i
									class="fa fa-angle-double-right"></i> Blank Page</a></li>
						</ul></li>
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Right side column. Contains the navbar and content of the page -->
		<aside class="right-side">
			<sitemesh:write property='body' />
		</aside>
		<!-- /.right-side -->
	</div>
	<!-- ./wrapper -->

</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/notify.min.js"></script>
<script type="text/javascript">
	$('document').ready(function() {
		
		<c:if test="${not empty notifications}">
		<c:forEach items="${notifications}" var="notification">
		$.notify('${notification.message}', '${notification.style}',
				{
			  // whether to hide the notification on click
			  clickToHide: true,
			  // whether to auto-hide the notification
			  autoHide: true,
			  // if autoHide, hide after milliseconds
			  autoHideDelay: 5000,
			  // show the arrow pointing at the element
			  arrowShow: true,
			  // arrow size in pixels
			  arrowSize: 5,
			  // default positions
			  elementPosition: '${notification.position}',
			  globalPosition: '${notification.position}',
			  // default style
			  style: 'bootstrap',
			  // default class (string or [string])
			  className: '${notification.style}',
			  // show animation
			  showAnimation: 'slideDown',
			  // show animation duration
			  showDuration: 400,
			  // hide animation
			  hideAnimation: 'slideUp',
			  // hide animation duration
			  hideDuration: 200,
			  // padding between element and notification
			  gap: 2
			}		
		);
		</c:forEach>
		<c:remove var="notifications" scope="session" />
		</c:if>
	});
</script>
</html>