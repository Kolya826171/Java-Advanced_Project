<link rel="stylesheet" href="css/header.css">

<div id="wrapper" class="animate">
	<nav
		class="navbar header-top fixed-top navbar-expand-lg  navbar-dark bg-dark">
		<span class="navbar-toggler-icon leftmenutrigger"></span> <a
			class="navbar-brand" href="${contextPath}/home">Faculties</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav animate side-nav">
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/home">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/createFaculty">Add faculty</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/registrationFaculty">Registration at the
						faculty</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/usersMarks">Add to notoriety</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/notoriety">Notoriety</a></li>
			</ul>

			<ul class="navbar-nav ml-md-auto d-md-flex">
				<li class="nav-item">
					<form method="POST" action="/logout">
						<input type="submit" class="btn btn-secondary logout"
							value="LogOut" /> 
						<input type="hidden" name="${_csrf.parameterName}" 
							value="${_csrf.token}" />
					</form>
				</li>
			</ul>
		</div>
	</nav>
</div>