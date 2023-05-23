<%--
  Created by IntelliJ IDEA.
  User: psh32
  Date: 2023-03-24
  Time: 오후 4:09
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
        h1 {
            word-break: break-all;
        }
    </style>
</head>
<body>
<%@include file="../../header.jsp" %>
<section>
    <div class="d-flex justify-content-center">
        <div class="d-flex flex-column w-50">
            <h1 class="fw-bold mt-5 mb-3 text-center">여행 정보 공유</h1>
            <div class="d-flex flex-column">
                <a href="${root}/posts" class="text-decoration-none text-info mb-2 fw-bold">게시판 &gt;</a>
                <div class="d-flex align-items-center">
                    <h2><c:if test="${post.isNotice == 'true'}">
                        <span class="badge text-bg-primary fs-4 mb-3">공지</span>
                    </c:if>${post.title}</h2>
                </div>
                <div class="d-flex align-items-center mb-3">
                    <div class="d-flex me-3">
                        <img src="${root}/assets/img/no-profile-image.png" class="rounded-circle border border-2 border-dark" width="64" height="64" alt="">
                    </div>
                    <div class="d-flex flex-column">
                        <span class="fw-bold">${post.creatorNickname}</span>
                        <span class="text-secondary">${post.createdAt}&nbsp;조회&nbsp;${post.hits}</span>
                    </div>
                </div>
                <p class="mb-3">${post.content}</p>
                <div class="d-flex justify-content-end">
                    <c:if test="${user.role == 'ADMIN' }">
                        <button id="post-notice-button" class="btn btn-primary me-3 text-white">
                            <c:if test="${post.isNotice == 'true'}">
                                공지 해제
                            </c:if>
                            <c:if test="${post.isNotice == 'false'}">
                                공지 설정
                            </c:if>
                        </button>
                    </c:if>
                    <c:if test="${user.id == post.creatorId }">
                        <a id="post-update-button" class="btn btn-warning me-3 text-white"
                           href="${root}/posts?id=${post.id}&mode=edit">수정</a>
                        <button id="post-delete-button" class="btn btn-danger">삭제</button>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</section>
<%@include file="../../footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>
    const postDeleteButton = document.querySelector('#post-delete-button');
    postDeleteButton.addEventListener('click', async function () {
        if (confirm('정말 삭제하시겠습니까?')) {
            await axios({
                url: `${root}/posts?id=${post.id}`,
                method: 'DELETE',
            }).then(function (response) {
                if (response.status === 200) {
                    alert('게시글을 삭제하였습니다.');
                    location.href = `${root}/posts`;
                }
            }).catch(function (error) {
                alert('삭제에 실패했습니다.');
            });
        }
    });

    const postNoticeButton = document.querySelector('#post-notice-button');
    postNoticeButton.addEventListener('click', async function () {
        const isNotice = ${post.isNotice} ? 'false' : 'true';
        await axios({
            url: `${root}/posts?id=${post.id}&notice=` + isNotice,
            method: 'POST',
        }).then(function (response) {
            if (response.status === 200) {
                if (isNotice === 'true')
                    alert('게시글을 공지로 설정하였습니다.');
                else
                    alert('게시글을 공지에서 해제하였습니다.');
                location.href = `${root}/posts?id=${post.id}`;
            }
        }).catch(function (error) {
            if (isNotice === 'true')
                alert('공지 설정에 실패했습니다.');
            else
                alert('공지 해제에 실패했습니다.');
        });
    });
</script>
</body>
</html>
