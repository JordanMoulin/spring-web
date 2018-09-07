<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Message App</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<img
			src="https://getbootstrap.com/docs/4.1/assets/brand/bootstrap-solid.svg"
			width="30" height="30" alt="">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<a class="nav-item nav-link" href="/humancontact/admin/messages">Admin</a>
				<a class="nav-item nav-link" href="#">Chat</a>
			</div>
		</div>
	</nav>
	<div class="container">
		<h3>Créer un nouveau message :</h3>
		<c:url var="formAction" value="${requestScope['javax.servlet.forward.servlet_path']}/messages" />
		<form:form modelAttribute="message" action="${formAction}">
		<form:errors path="*" cssClass="errorBox"/>
			<div class="form-group row">
				<form:label path="expediteur" for="expediteur" class="col-sm-2 col-form-label">Expéditeur :</form:label>
				<div class="col-sm-10">
					<form:input path="expediteur" type="text" onblur="testCaps(this.value);" class="form-control" id="expediteur"/>
					<form:errors path="expediteur"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="expediteur" for="destinataire" class="col-sm-2 col-form-label">Destinataire :</form:label>
				<div class="col-sm-10">
					<form:input path="destinataire" type="text" onblur="testCaps(this.value);" class="form-control" id="destinataire"/>
					<form:errors path="destinataire"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="message" for="message" class="col-sm-2 col-form-label">Message :</form:label>
				<div class="col-sm-10">
					<form:input path="message" type="text" class="form-control" id="message"/>
					<form:errors path="message"/>
				</div>
			</div>
			<div class="form-group row">
       			<div class="col-sm-10">
          			<input type="submit" value="Créer"/>
        		</div>
     		</div>
		</form:form>
	</div>
</body>
</html>