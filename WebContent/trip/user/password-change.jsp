<%--
  Created by IntelliJ IDEA.
  User: psh32
  Date: 2023-03-27
  Time: 오후 2:52
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
            <h1 class="fw-bold mt-5 mb-3 text-center">비밀번호 변경</h1>
            <form action="${root}/change-password" method="post">
                <div class="mb-3">
                    <label for="password" class="form-label">비밀번호</label>
                    <input type="password" class="form-control" id="password" name="password" size="30" required/>
                </div>
                <div class="mb-3">
                    <label for="new-password" class="form-label">새 비밀번호</label>
                    <input type="password" class="form-control" id="new-password" name="new-password" size="30" required/>
                </div>
                <div class="mb-3">
                    <label for="new-password-confirm" class="form-label">새 비밀번호 확인</label>
                    <input type="password" class="form-control" id="new-password-confirm" name="new-password-confirm"
                           size="30" required/>
                </div>
                <div class="mb-3 text-warn" id="announce"></div>
                <div class="mb-3">
                    <input type="submit" id="change-button" value="변경" class="btn btn-info text-white container-fluid">
                </div>
            </form>
        </div>
    </div>
</section>
<%@ include file="../../footer.jsp" %>
<script>
    const new_password = document.getElementById("new-password");
    const new_password_confirm = document.getElementById("new-password-confirm");

    const changeButton = document.querySelector("#change-button");
    changeButton.addEventListener('click', function (event) {
        if (new_password.value !== new_password_confirm.value) {
            alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            event.preventDefault();
        }
    });

    new_password.addEventListener('blur', checkPassword);
    new_password_confirm.addEventListener('blur', checkPassword);

    function checkPassword() {
        const announce = document.getElementById("announce");
        if (new_password.value.length === 0 || new_password_confirm.value.length === 0) {
            announce.innerHTML = "";
            return;
        }
        if (new_password.value === new_password_confirm.value) {
            announce.innerHTML = "비밀번호가 일치합니다.";
            announce.style.color = "green";
        } else {
            announce.innerHTML = "비밀번호가 일치하지 않습니다.";
            announce.style.color = "red";
        }
    }
</script>
</body>
</html>
