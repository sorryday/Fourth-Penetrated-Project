<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: psh32
  Date: 2023-03-24
  Time: 오후 4:57
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
        td {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }
        button {
            word-break: keep-all;
        }
    </style>
</head>
<body>
<%@include file="../../header.jsp" %>
<section>
    <div class="d-flex justify-content-center">
        <div class="d-flex flex-column container">
            <h1 class="fw-bold mt-5 mb-3 text-center">여행 정보 공유</h1>
            <div class="d-flex justify-content-end mb-2">
                <form class="d-flex" action="${root}/posts" method="get">
                    <input class="form-control me-2" type="search" name="keyword" placeholder="검색어를 입력하세요"
                               aria-label="Search">
                    <button class="btn btn-info text-white" type="submit">검색</button>
                </form>
            </div>
            <table class="table table-info table-bordered" style="table-layout: fixed">
                <thead>
                <tr>
                    <th scope="col" class="text-center" style="width: 7%">번호</th>
                    <th scope="col" class="text-center" style="width: 56%">제목</th>
                    <th scope="col" class="text-center" style="width: 15%">작성자</th>
                    <th scope="col" class="text-center" style="width: 15%">작성일</th>
                    <th scope="col" class="text-center" style="width: 7%">조회수</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="post" items="${posts}">
                    <tr>
                        <c:if test="${post.isNotice == 'true'}">
                            <th class="text-center text-primary" scope="row">
                                공지
                            </th>
                        </c:if>
                        <c:if test="${post.isNotice == 'false'}">
                            <th class="text-center" scope="row">
                                    ${post.id}
                            </th>
                        </c:if>
                        <td>
                            <a class="text-decoration-none text-black"
                               href="posts?id=${post.id}">&nbsp;${post.title}</a>
                        </td>
                        <td class="text-center">
                                ${post.creatorNickname }
                        </td>
                        <c:set var="now" value="<%=new java.util.Date()%>"/>
                        <c:set var="nowDate"><fmt:formatDate value="${now}" pattern="yyyy-MM-dd"/></c:set>
                        <c:set var="postDate" value="${post.createdAt.substring(0, 10)}"/>
                        <c:if test="${nowDate == postDate}">
                            <td class="text-center">
                                    ${post.createdAt.substring(11, 16)}
                            </td>
                        </c:if>
                        <c:if test="${nowDate != postDate}">
                            <td class="text-center">
                                    ${post.createdAt.substring(0, 10)}
                            </td>
                        </c:if>
                        <td class="text-center">${post.hits}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="d-flex justify-content-end">
                <button class="btn btn-info text-white" id="write-button">글쓰기</button>
            </div>
        </div>
    </div>
</section>
<%@include file="../../footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>
    const writeButton = document.querySelector('#write-button');
    writeButton.addEventListener('click', () => {
        <c:if test="${sessionScope.user == null}">
            alert('로그인 후 이용해주세요.');
            location.href = '${root}/trip/user/login.jsp';
        </c:if>
        <c:if test="${sessionScope.user != null}">
            location.href = '${root}/trip/post/post-insert.jsp';
        </c:if>
    });
</script>
</body>
</html>
