<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Todo新規作成</title>
</head>
<body>
<div class="container mt-4">
    <h2>新規登録画面</h2>

    <form action="TodoCreate" method="post">

        <div class="mb-3">
            <label for="title" class="form-label">タイトル</label>
            <input type="text" class="form-control" id="title" name="title" required>
        </div>

        <div class="mb-3">
            <label for="detail" class="form-label">詳細</label>
            <textarea class="form-control" id="detail" name="detail" rows="3"></textarea>
        </div>

        <div class="mb-3">
            <label for="status" class="form-label">ステータス</label>
            <select class="form-select" id="status" name="status">
                <option value="未着手">未着手</option>
                <option value="進行中">進行中</option>
                <option value="完了">完了</option>
            </select>
        </div>

        <div class="mb-3">
            <label for="due_date" class="form-label">期限日</label>
            <input type="date" class="form-control" id="due_date" name="due_date" required>
        </div>

        <button type="submit" class="btn btn-primary">登録</button>
        <a href="Todo" class="btn btn-secondary">キャンセル</a>

    </form>
</div>

<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>