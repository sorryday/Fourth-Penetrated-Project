<%--
  Created by IntelliJ IDEA.
  User: psh32
  Date: 2023-03-24
  Time: 오후 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
    <title>EnjoyTrip</title>
</head>
<body>
<%@include file="../../header.jsp" %>
<section>
    <div class="d-flex justify-content-center">
        <div class="d-flex flex-column w-50">
            <h1 class="fw-bold mt-5 mb-3 text-center">여행 정보 공유</h1>
            <div class="d-flex flex-column">
                <form method="post" action="${root}/posts">
                    <div class="mb-3">
                        <label for="title" class="form-label">제목</label>
                        <input type="text" class="form-control" name="title" id="title">
                    </div>
                    <div class="mb-3">
                        <label for="content" class="form-label">내용</label>
                        <textarea class="form-control" id="content" name="content" rows="5"></textarea>
                    </div>
                    <div class="d-flex justify-content-end">
                        <button type="submit" class="btn btn-info text-white">등록</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<%@include file="../../footer.jsp" %>
</body>
</html>
