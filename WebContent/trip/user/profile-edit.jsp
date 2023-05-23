<%--
  Created by IntelliJ IDEA.
  User: psh32
  Date: 2023-03-27
  Time: 오후 2:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
      <h1 class="fw-bold mt-5 mb-3 text-center">프로필 수정</h1>
      <form action="${root}/edit-profile" method="post" id="edit-form">
        <div class="mb-3">
          <label for="nickname" class="form-label">닉네임</label>
          <input type="text" class="form-control" id="nickname" name="nickname" value="${user.nickname}" size="30" required/>
        </div>
        <div class="mb-3">
          <label for="email" class="form-label">이메일</label>
          <input type="email" class="form-control" id="email" name="email" size="30" value="${user.email}" required/>
        </div>
        <div class="mb-3">
          <input type="submit" value="수정" id="register-button"
                 class="btn btn-info text-white container-fluid">
        </div>
      </form>
    </div>
  </div>
</section>
<%@ include file="../../footer.jsp" %>
</body>
</html>
