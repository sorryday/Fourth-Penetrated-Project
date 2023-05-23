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
            <h1 class="fw-bold mt-5 mb-3 text-center">회원가입</h1>
            <form action="${root}/register" method="post" id="register-form" onerror="alert('test');">
                <div class="mb-3">
                    <label for="user-id" class="form-label">아이디</label>
                    <input type="text" class="form-control" id="user-id" name="user-id" size="30" required/>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">비밀번호</label>
                    <input type="password" class="form-control" id="password" name="password" size="30" required/>
                </div>
                <div class="mb-3">
                    <label for="password-confirm" class="form-label">비밀번호 확인</label>
                    <input type="password" class="form-control" id="password-confirm" name="password-confirm" size="30"
                           required/>
                </div>
                <div class="mb-3 text-warn" id="announce"></div>
                <div class="mb-3">
                    <label for="nickname" class="form-label">닉네임</label>
                    <input type="text" class="form-control" id="nickname" name="nickname" size="30" required/>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">이메일</label>
                    <input type="email" class="form-control" id="email" name="email" size="30" required/>
                </div>
                <div class="mb-3">
                    <input type="submit" value="가입" id="register-button"
                           class="btn btn-info text-white container-fluid">
                </div>
                <div class="mb-3">
                    <a id="btn-cancel" class="btn btn-info text-white container-fluid" href="../../index.jsp">
                        취소
                    </a>
                </div>
            </form>
        </div>
    </div>
</section>
<%@ include file="../../footer.jsp" %>
<script>
    const password = document.getElementById("password");
    const password_confirm = document.getElementById("password-confirm");

    const registerButton = document.querySelector("#register-button");
    registerButton.addEventListener('click', function (event) {
        if (password.value !== password_confirm.value) {
            alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            event.preventDefault();
        }
    });

    password.addEventListener('blur', checkPassword);
    password_confirm.addEventListener('blur', checkPassword);

    function checkPassword() {
        const announce = document.getElementById("announce");
        if (password.value.length === 0 || password_confirm.value.length === 0) {
            announce.innerHTML = "";
            return;
        }
        if (password.value === password_confirm.value) {
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
