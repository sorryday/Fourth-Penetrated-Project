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
            <h1 class="fw-bold mt-5 mb-3 text-center">마이 페이지</h1>
            <%--          <form action="${root}/user" method="post">--%>
            <%--          	<input type="hidden" name="action" value="" id="action">--%>
            <%--            <div class="mb-3">--%>
            <%--              <label for="user-id" class="form-label">아이디</label>--%>
            <%--              <input type="text" value="${userInfo.user_id}" class="form-control" id="user_id" name="user_id" size="30" readonly/>--%>
            <%--            </div>--%>
            <%--            <div class="mb-3">--%>
            <%--              <label for="name" class="form-label">별명</label>--%>
            <%--              <input type="text" value="${userInfo.nickname}" class="form-control" id="nickname" name="nickname" size="30"/>--%>
            <%--            </div>--%>
            <%--            <div class="mb-3">--%>
            <%--              <label for="email" class="form-label">이메일</label>--%>
            <%--              <input type="email" value="${userInfo.email}" class="form-control" id="email" name="email" size="30"/>--%>
            <%--            </div>--%>
            <%--            <div class="mb-3">--%>
            <%--              <label for="pw" class="form-label">변경할 비밀번호</label>--%>
            <%--              <input type="password" class="form-control" id="passwordNew" name="passwordNew" size="30"/>--%>
            <%--            </div>--%>
            <%--            <div class="mb-1">--%>
            <%--              <label for="pwChk" class="form-label">비밀번호 확인</label>--%>
            <%--              <input type="password" class="form-control" id="passwordNew2" name="passwordNew2" size="30"/>--%>
            <%--            </div>--%>
            <%--            <div class="mb-3 text-warn" id="announce"></div>--%>
            <%--            <div class="mb-3">--%>
            <%--              <input type="submit" id="btn-edit" class="btn btn-info text-white container-fluid" value="수정">--%>
            <%--            </div>--%>
            <%--            <div class="mb-3">--%>
            <%--              <a id="btn-signin" class="btn btn-info text-white container-fluid" href="index.jsp">--%>
            <%--                취소--%>
            <%--              </a>--%>
            <%--            </div>--%>
            <%--            <div class="mb-3">--%>
            <%--              <input type="submit" id="btn-quit" class="btn btn-danger text-white container-fluid" value="탈퇴">--%>
            <%--            </div>--%>
            <%--          </form>--%>
            <div class="card" style="width: 18rem;">
                <img src="${root}/assets/img/no-profile-image.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title fw-bold">${user.nickname}</h5>
                    <p class="card-text">${user.userId}</p>
                    <a href="${root}/trip/user/profile-edit.jsp" class="btn btn-primary mb-3">프로필 수정</a>
                    <a href="${root}/trip/user/password-change.jsp" class="btn btn-primary mb-3">비밀번호 변경</a>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">이메일 : ${user.email}</li>
                    <li class="list-group-item">회원 등급 : ${user.role}</li>
                </ul>
            </div>
        </div>
    </div>
</section>
<%@ include file="../../footer.jsp" %>
<script>
    const pw1 = document.getElementById("passwordNew");
    const pw2 = document.getElementById("passwordNew2");
    const text = document.getElementById("announce");
    pw1.addEventListener('blur', checkPW);
    pw2.addEventListener('blur', checkPW);

    const action = document.getElementById("action");
    const edit = document.getElementById("btn-edit");
    const quit = document.getElementById("btn-quit");
    edit.addEventListener('click', svlMypage);
    quit.addEventListener('click', svlQuit);

    edit.addEventListener('click', check);

    function svlMypage() {
        action.value = 'mypage';
    }

    function svlQuit() {
        action.value = 'quit';
    }


    function checkPW() {
        if (pw1.value == "" && pw2.value == "") {
            text.innerHTML = "";
        } else if (pw1.value == pw2.value) {
            text.innerHTML = "비밀번호가 일치합니다.";
            text.style.color = "green";
        } else if (pw1.value == "" | pw2.value == "") {
            text.innerHTML = "변경할 비밀번호를 입력하세요.";
            text.style.color = "black";
        } else {
            text.innerHTML = "비밀번호 불일치";
            text.style.color = "red";
            text.style.fontweight = "bold";
        }
    }

    function check() {
        if (pw1.value != pw2.value)
            alert("다시 입력하세요.");
        else
            alert("입력한 정보로 변경되었습니다.")
    }
</script>
</body>
</html>
