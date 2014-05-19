<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html class="bg-black">
<head>
<meta charset="UTF-8">
<title>AdminLTE | Reset password</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- bootstrap 3.0.2 -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<!-- font Awesome -->
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link
	href="${pageContext.request.contextPath}/resources/css/AdminLTE.css"
	rel="stylesheet" type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.${pageContext.request.contextPath}/resources/js/1.3.0/respond.min.js"></script>
        <![endif]-->
</head>
<body class="bg-black">

	<div class="form-box" id="login-box">
		<div class="header">Reset password</div>
		<form action="${pageContext.request.contextPath}/resetPassword"
			method="post">
			<div class="body bg-gray">
			<input type="hidden" name="requestId" value="${requestId}">
			<input type="hidden" name="key" value="${key}">
			
				<div class="form-group">
					<input type="password" name="password" class="form-control"
						placeholder="Password" />
				</div>
				<div class="form-group">
					<input type="password" name="repeatPassword" class="form-control"
						placeholder="Repeat password" />
				</div>
				
				<div id="recaptcha_div"></div>

				<!-- <input type="button" value="Show reCAPTCHA"
					onclick="showRecaptcha('recaptcha_div');"></input>
 -->
				<!-- <div class="form-group">
				
					Captcha
					<script type="text/javascript"
						src="//api.recaptcha.net/challenge?k=6LeLO-USAAAAAAUxYani8Yby5KxQif_VzQn1nQQt">
						
					</script>

					<noscript>
						<iframe
							src="//api.recaptcha.net/noscript?k=6LeLO-USAAAAAAUxYani8Yby5KxQif_VzQn1nQQt"
							height="300" width="500" frameborder="0"></iframe>
						<br>
						<textarea name="recaptcha_challenge_field" rows="3" cols="40"></textarea>
						<input type="hidden" name="recaptcha_response_field"
							value="manual_challenge">
					</noscript>
				</div> -->
			</div>
			<div class="footer">
				<button type="submit" class="btn bg-olive btn-block">Submit</button>
			</div>
		</form>
		
	</div>


	<!-- jQuery 2.0.2 -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"
		type="text/javascript"></script>

</body>

<script type="text/javascript"
	src="//www.google.com/recaptcha/api/js/recaptcha_ajax.js"></script>

<!-- Wrapping the Recaptcha create method in a javascript function -->
<script type="text/javascript">
$('document').ready(function(){
	Recaptcha.create("6LeLO-USAAAAAAUxYani8Yby5KxQif_VzQn1nQQt", 'recaptcha_div', {
		theme : "white",
		callback : Recaptcha.focus_response_field
});
});
</script>

<!-- ... more of your HTML  content ... -->

</head>

<body>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/notify.min.js"></script>
	<script type="text/javascript">
		$('document').ready(
				function() {

					
					<c:if test="${not empty notifications}">
					<c:forEach items="${notifications}" var="notification">
					$
							.notify('${notification.message}',
									'${notification.style}',
									'${notification.position}');
					</c:forEach>
					<c:remove var="notifications" scope="session" />
					</c:if>
				});
	</script>
</html>