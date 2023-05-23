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
<%@include file="../../header.jsp"%>

<section>
      <div class="d-flex justify-content-center">
        <div class="d-flex flex-column">
          <h1 class="fw-bold mt-5 mb-3 text-center">비밀번호 찾기</h1>
          <form>
            <div class="mb-3">
              <label for="user-id" class="form-label">아이디</label>
              <input type="text" class="form-control" id="id" name="id" size="30"/>
            </div>
            <div class="mb-3">
              <label for="email" class="form-label">가입한 이메일</label>
              <input type="email" class="form-control" id="email" name="email" size="30"/>
            </div>
            <div class="mb-3">
              <a type="submit" id="btn-findpw" class="btn btn-info text-white container-fluid" onclick="send()">
                	임시 비밀번호 발송
              </a>
            </div>
            <script>
	            function send(){
	            	alert('임시 비밀번호 전송');	
	            }
            </script>
            <div class="mb-3">
              <a id="btn-cancel" class="btn btn-info text-white container-fluid" href="login.jsp">
                	취소
              </a>
            </div>
          </form>
        </div>
      </div>
    </section>
<%@ include file="../../footer.jsp"%>
</body>
</html>
