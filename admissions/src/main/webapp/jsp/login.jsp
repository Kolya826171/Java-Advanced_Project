<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="contextPath" value="${pagePath.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous" />
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link href="css/login.css" rel="stylesheet" type="text/css"></link>

</head>
<body>

	<div class="wrapper fadeInDown">
		<div id="formContent">

			<form action="${contextPath}/login" method="post">
				<span>${message}</span> <input type="text" id="login"
					class="fadeIn second" name="email"
					placeholder="<spring:message code="login.email"/>" /> <input
					type="password" id="password" class="fadeIn third" name="password"
					placeholder="<spring:message code="login.password"/>" /> <br>
				<span>${error}</span> <input type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" /> <input
					type="submit" class="fadeIn fourth"
					value="<spring:message code="login.signin"/>" />
			</form>


			<div>
				<fieldset>
					<label> <spring:message code="login.choose_lang"></spring:message>
					</label> <select id="locales">
						<option value="en"><spring:message code="login.english" /></option>
						<option value="ua"><spring:message code="login.ukrainian" /></option>
					</select>
				</fieldset>
			</div>

			<div id="formFooter">
				<h4 class="text-center">
					<a href="${contextPath}/registration"><spring:message
							code="login.create_account" /></a>
				</h4>
			</div>

		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

	<script src="js/language.js"></script>

</body>
</html>