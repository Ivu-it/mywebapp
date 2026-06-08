<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>アスリート一覧</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href=Athletes>アスリート</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href=Events>競技</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<form action="AthleteCreate" method="post">
  <div>
    <label for="athlete_id">アスリートID</label>
    <input type="text" id="athlete_id" name="athlete_id">
  </div>

  <div>
    <label for="name1">姓</label>
    <input type="text" id="name1" name="name1">
  </div>

  <div>
    <label for="name2">名</label>
    <input type="text" id="name2" name="name2">
  </div>

  <div>
    <label for="event_id">イベントID</label>
    <input type="text" id="eventId" name="event_id">
  </div>

  <div>
    <label for="gender">性別</label>
    <select id="gender" name="gender">
      <option value="男">男性</option>
      <option value="女">女性</option>
    </select>
  </div>

  <button class="btn btn-primary" type="submit">追加</button>
</form>
	<div>
<%= request.getAttribute("test") %>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">競技ID</th>
					<th scope="col">姓</th>
					<th scope="col">名</th>
					<th scope="col">イベントID</th>
					<th scope="col">性別</th>
				</tr>
			</thead>
			<tbody>
				<!--     <tr>
    <th scope="row">1</th>
      <td>石川</td>
      <td>遼</td>
      <td>1</td>
      <td>男</td>
    </tr>
    <tr>
    <th scope="row">2</th>
    <td>イチロー</td>
    <td></td>
    <td>2</td>
    <td>男</td>
    </tr>-->
				<c:forEach var="athlete" items="${athletes}">
					<tr>
						<th scope="row">${ athlete.athlete_id }</th>
						<td><c:out value="${ athlete.name1 }" /></td>
						<td><c:out value="${ athlete.name2 }" /></td>
						<td><c:out value="${ athlete.event_id}" /></td>
						<td><c:out value="${ athlete.gender }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:forEach var="athlete" items="${athletes}">
					
						${ athlete.athlete_id }
						<c:out value="${ athlete.name1 }" />
						<c:out value="${ athlete.name2 }" />
						<c:out value="${ athlete.event_id}" />
						<c:out value="${ athlete.gender }" />
					
				</c:forEach>
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>