<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Todoリスト</title>
</head>
<body>
	<div>
		<form class="d-flex mb-3" role="search" aria-label="一覧検索フォーム"
			action="TodoList" method="get">
			<input class="form-control w-25 me-2" type="search" name="keyword"
				placeholder="キーワードを入力（例：タイトル名など）" aria-label="検索キーワード入力">
	</div>
	<div class="col-md-4">
		<label for="status" class="form-label fw-semibold">ステータス</label> <select
			id="status" name="status" class="form-select rounded-3 py-2">
			<option value="">すべて</option>
			<option value="未着手">未着手</option>
			<option value="進行中">進行中</option>
			<option value="完了">完了</option>
		</select>
	</div>
	<button class="btn btn-primary" type="submit">
		<i class="bi bi-search"></i> 検索
	</button>
	</form>
	<div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">ToDo ID</th>
					<th scope="col">タイトル</th>
					<th scope="col">詳細</th>
					<th scope="col">ステータス</th>
					<th scope="col">期限日</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="todos" items="${Todo}">
					<tr>
						<th scope="row">${ todos.todo_id }</th>
						<td><c:out value="${ todos.title }" /></td>
						<td><c:out value="${ todos.detail }" /></td>
						<td><c:out value="${ todos.status}" /></td>
						<td><c:out value="${ todos.due_date }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:forEach var="todos" items="${Todo}">
					
						${ todos.todo_id }
						<c:out value="${ todos.title }" />
		<c:out value="${ todos.detail }" />
		<c:out value="${ todos.status}" />
		<c:out value="${ todos.due_date }" />

	</c:forEach>
	<form action="TodoCreate">
		<button type="submit" class="btn btn-primary">新規追加</button>
	</form>
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>