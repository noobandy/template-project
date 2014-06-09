<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html class="bg-black">
<head>
<meta charset="UTF-8">
<title>AdminLTE | Registration Page</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
   <!-- bootstrap 3.0.2 -->
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="${pageContext.request.contextPath}/resources/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="${pageContext.request.contextPath}/resources/css/AdminLTE.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.${pageContext.request.contextPath}/resources/js/1.3.0/respond.min.js"></script>
        <![endif]-->
</head>
<body class="bg-black">

	<div class="form-box" id="login-box">
		<div class="header">Register New Membership</div>
		<form:form modelAttribute="registrationFormDTO"
			action="${pageContext.request.contextPath}/user/newUser" method="post">
			<div class="body bg-gray">
				<div class="form-group">
					<form:input path="firstName" class="form-control"
						placeholder="First name" />
					<form:errors path="firstName"></form:errors>
				</div>
				<div class="form-group">
					<form:input path="lastName" class="form-control"
						placeholder="Last name" />
					<form:errors path="lastName" />
				</div>
				<div class="form-group">
					<form:input path="gender" class="form-control" placeholder="Gender" />
					<form:errors path="gender" />
				</div>
				<div class="form-group">
					<form:input id="dob" path="dob" class="form-control"
						placeholder="Date of birth" data-inputmask="'alias': 'dd/mm/yyyy'" />
					<form:errors path="dob" />
				</div>
				<div class="form-group">
					<form:input path="userId" class="form-control"
						placeholder="User ID" />
					<form:errors path="userId" />
				</div>
				<div class="form-group">
					<form:input path="emailId" class="form-control"
						placeholder="Email id" />
					<form:errors path="emailId" />
				</div>
				<div class="form-group">
					<form:password path="password" class="form-control"
						placeholder="Password" />
					<form:errors path="password" />
				</div>

				<div class="form-group">
					<form:password path="repeatPassword" class="form-control"
						placeholder="Retype password" />

				</div>
			</div>
			<div class="footer">

				<button type="submit" class="btn bg-olive btn-block">Sign
					me up</button>

				<a href="login" class="text-center">I already have a membership</a>
			</div>
		</form:form>

		<div class="margin text-center">
			<span>Register using social networks</span> <br />
			<button class="btn bg-light-blue btn-circle">
				<i class="fa fa-facebook"></i>
			</button>
			<button class="btn bg-aqua btn-circle">
				<i class="fa fa-twitter"></i>
			</button>
			<button class="btn bg-red btn-circle">
				<i class="fa fa-google-plus"></i>
			</button>

		</div>
	</div>


	<!-- jQuery 2.0.2 -->
	<!-- jQuery 2.0.2 -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- AdminLTE App -->
        <script src="${pageContext.request.contextPath}/resources/js/AdminLTE/app.js" type="text/javascript"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="${pageContext.request.contextPath}/resources/js/AdminLTE/demo.js" type="text/javascript"></script>        

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/notify.min.js"></script>
		 <script src="${pageContext.request.contextPath}/resources/js/plugins/input-mask/jquery.inputmask.js" type="text/javascript"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/plugins/input-mask/jquery.inputmask.date.extensions.js" type="text/javascript"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/plugins/input-mask/jquery.inputmask.extensions.js" type="text/javascript"></script>
	<script type="text/javascript">
	
	$('document').ready(function() {
		 //Datemask dd/mm/yyyy
        $("#dob").inputmask("dd/mm/yyyy", {"placeholder": "dd/mm/yyyy"});
		 
		<c:if test="${not empty notifications}">
		<c:forEach items="${notifications}" var="notification">
		$.notify('${notification.message}', '${notification.style}','${notification.position}');
		</c:forEach>
		<c:remove var="notifications" scope="session" />
		</c:if>
	});
</script>
</body>
</html>