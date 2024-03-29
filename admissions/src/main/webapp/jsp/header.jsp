<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link rel="stylesheet" href="css/header.css">

<div id="wrapper" class="animate">
	<nav
		class="navbar header-top fixed-top navbar-expand-lg  navbar-dark bg-dark">
		<span class="navbar-toggler-icon leftmenutrigger"></span> <a
			class="navbar-brand" href="${contextPath}/home"> <spring:message
				code="header.users" /></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav animate side-nav">

				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/home"><spring:message code="header.home" /><span
						class="sr-only">(current)</span> </a></li>

				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li class="nav-item"><a class="nav-link"
						href="${contextPath}/createFaculty"><spring:message
								code="header.create_faculty" /></a></li>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_USER')">
					<li class="nav-item"><a class="nav-link"
						href="${contextPath}/registrationFaculty"><spring:message
								code="header.registration_faculty" /></a></li>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li class="nav-item"><a class="nav-link"
						href="${contextPath}/usersMarks"><spring:message
								code="header.users_marks" /></a></li>
				</security:authorize>

				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/notoriety"><spring:message
							code="header.notoriety" /></a></li>
			</ul>

			<ul class="navbar-nav ml-md-auto d-md-flex">
				<li class="nav-item">
					<form method="POST" action="/logout">
						<input type="submit" class="btn btn-secondary logout"
							value="<spring:message
				code="header.logout" />" /> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				</li>
			</ul>
		</div>
	</nav>
</div>