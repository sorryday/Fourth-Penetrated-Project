<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
    <title>EnjoyTrip</title>
    <style>
        p {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            line-height: 1;
        }
    </style>
</head>
<body>
<%@include file="../../header.jsp" %>
<section>
    <div class="d-flex justify-content-center">
        <div class="d-flex flex-column">
            <h1 class="fw-bold mt-5 mb-3 text-center">로그인</h1>
            <form action="${root}/login" method="post">
                <div class="mb-3">
                    <label for="user-id" class="form-label">아이디</label>
                    <input type="text" class="form-control" id="user-id" name="user-id" size="30"/>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">비밀번호</label>
                    <input type="password" class="form-control" id="password" name="password" size="30"/>
                </div>
                <div class="mb-3">
                    <input type="submit" id="btn-login" value="로그인" class="btn btn-info text-white container-fluid">
                </div>
            </form>
            <a href="password-find.jsp" class="btn btn-info text-white mb-5"> 비밀번호 찾기 </a>
        </div>
    </div>
</section>
<%@ include file="../../footer.jsp" %>
</body>
</html>
