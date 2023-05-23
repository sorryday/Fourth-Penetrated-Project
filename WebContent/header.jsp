<%--
  Created by IntelliJ IDEA.
  User: psh32
  Date: 2023-03-24
  Time: 오후 2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<fmt:requestEncoding value="UTF-8"/>
<style>
    html, body {
        height: 100%
    }

    section {
        min-height: 100%;
        position: relative;
        padding-bottom: 60px;
    }

    footer {
        bottom: 0;
    }
</style>
<header>
    <nav class="navbar navbar-expand-lg bg-info bg-opacity-75" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="${root}/index.jsp">
                <h3 class="text-white fw-bold">EnjoyTrip</h3>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link text-white fw-bold" href="${root}/trip/tour/tour-info.jsp">지역별관광지</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white fw-bold" href="${root}/hotplaces">핫플레이스</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white fw-bold" href="${root}/posts">게시판</a>
                    </li>
                </ul>
                <c:if test="${empty user}">
                    <a class="btn btn-info me-3 text-white fw-bold" href="${root}/trip/user/login.jsp">로그인</a>
                    <a class="btn btn-info text-white fw-bold" href="${root}/trip/user/register.jsp">회원가입</a>
                </c:if>
                <c:if test="${not empty user}">
                    <a class="btn btn-info me-3 text-white fw-bold" href="${root}/trip/user/my-page.jsp">마이페이지</a>
                    <a class="btn btn-info text-white fw-bold" href="${root}/logout" onclick="javascript:alert('로그아웃 되었습니다.')">로그아웃</a>
                </c:if>
            </div>
        </div>
    </nav>
</header>