<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>競技一覧</title>
</head>
<body>
	<div>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Navbar</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="Athletes">アスリート</a></li>
						<li class="nav-item"><a class="nav-link" href="Events">競技</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		<form action="EventCreate" method="post">
 <div>
    <label for="name">競技名</label>
    <input type="text" id="name" name="name">
  </div>

  <button class="btn btn-primary" type="submit">追加</button>
</form>
	</div>
	<%=request.getAttribute("test")%>
	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">競技名</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="event" items="${events}">
				<tr>
					<th scope="row">${event.event_id }</th>
					<td><c:out value="${ event.name }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<c:forEach var="event" items="${events}">
					
						${ event.event_id }
						<c:out value="${ event.name }" />

	</c:forEach>
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>