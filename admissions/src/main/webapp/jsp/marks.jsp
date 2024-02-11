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

<title>Entering marks</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/faculty.css">
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>



	<div class="wrapper fadeInDown">
		<div id="formContent">

			<form:form method="post" modelAttribute="marksForm"
				class="form-signin">
				<h2 class="form-signin-heading">Enter your marks</h2>

				<spring:bind path="exam">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input path="exam" type="number" class="fadeIn"
							placeholder="Exam mark" />
						<form:errors path="exam"></form:errors>
					</div>
				</spring:bind>

				<spring:bind path="interview">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input path="interview" type="number" class="fadeIn"
							placeholder="Interview mark" />
						<form:errors path="interview"></form:errors>
					</div>
				</spring:bind>

				<spring:bind path="certificate">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:input path="certificate" type="number" class="fadeIn"
							placeholder="Certificate mark" />
						<form:errors path="certificate"></form:errors>
					</div>
				</spring:bind>

				<input type="submit" class="fadeIn submit" value="Enter" />
			</form:form>

		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.6/dist/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

	<script src="js/header.js"></script>
</body>
</html>