<%--
  Created by IntelliJ IDEA.
  User: psh32
  Date: 2023-03-24
  Time: 오후 1:58
  To change this template use File | Settings | File Templates.
--%>
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
<%@include file="header.jsp"%>
<section>
    <div id="carouselExample" class="carousel slide mt-3 ms-3 me-3 mb-5" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExample" data-bs-slide-to="0" class="active"
                    aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExample" data-bs-slide-to="1"
                    aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExample" data-bs-slide-to="2"
                    aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active" data-bs-interval="3000">
                <img src="assets/img/1.jpg" class="d-block w-100" alt="" style="height: 700px;">
            </div>
            <div class="carousel-item" data-bs-interval="3000">
                <img src="assets/img/2.jpg" class="d-block w-100" alt="" style="height: 700px;">
            </div>
            <div class="carousel-item" data-bs-interval="3000">
                <img src="assets/img/3.jpg" class="d-block w-100" alt="" style="height: 700px;">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
    <div class="container mb-3">
        <div class="row justify-content-center">
            <div class="col-3 border border-info rounded-3 p-3 me-3">
                <div class="d-flex justify-content-between mb-2">
                    <span class="fw-bold h4">공지사항</span>
                    <button class="btn btn-outline-info rounded-5">+</button>
                </div>
                <div class="border mb-3"></div>
                <div>
                    <a href="#" class="text-decoration-none text-black">
                        <p>공지사항1 공지사항1 </p>
                    </a>
                    <a href="#" class="text-decoration-none text-black">
                        <p>공지사항1 공지사항1 </p>
                    </a>
                    <a href="#" class="text-decoration-none text-black">
                        <p>공지사항1 공지사항1 공지사항1 공지사항1</p>
                    </a>
                    <a href="#" class="text-decoration-none text-black">
                        <p>공지사항1 공지사항1 공지사항1 공지사항1</p>
                    </a>
                    <a href="#" class="text-decoration-none text-black">
                        <p>공지사항1 공지사항1 공지사항1 공지사항1 공지사항1 공지사항1</p>
                    </a>
                </div>
            </div>
            <div class="col-3 border border-info rounded-3 p-3 me-3">
                <div class="d-flex justify-content-between mb-2">
                    <span class="fw-bold h4">인기글</span>
                    <button class="btn btn-outline-info rounded-5">+</button>
                </div>
                <div class="border mb-3"></div>
                <div>
                    <a href="#" class="text-decoration-none text-black">
                        <p>공지사항1 공지사항1 </p>
                    </a>
                    <a href="#" class="text-decoration-none text-black">
                        <p>공지사항1 공지사항1 </p>
                    </a>
                    <a href="#" class="text-decoration-none text-black">
                        <p>공지사항1 공지사항1 공지사항1 공지사항1</p>
                    </a>
                    <a href="#" class="text-decoration-none text-black">
                        <p>공지사항1 공지사항1 공지사항1 공지사항1</p>
                    </a>
                    <a href="#" class="text-decoration-none text-black">
                        <p>공지사항1 공지사항1 공지사항1 공지사항1 공지사항1 공지사항1</p>
                    </a>
                </div>
            </div>
            <div class="col-3 border border-info rounded-3 p-3">
                <div class="d-flex justify-content-between mb-2">
                    <span class="fw-bold h4">핫플레이스</span>
                    <button class="btn btn-outline-info rounded-5">+</button>
                </div>
                <div class="border mb-3"></div>
                <div>
                    <a href="#" class="text-decoration-none text-black">
                        <p>공지사항1 공지사항1 </p>
                    </a>
                    <a href="#" class="text-decoration-none text-black">
                        <p>공지사항1 공지사항1 </p>
                    </a>
                    <a href="#" class="text-decoration-none text-black">
                        <p>공지사항1 공지사항1 공지사항1 공지사항1</p>
                    </a>
                    <a href="#" class="text-decoration-none text-black">
                        <p>공지사항1 공지사항1 공지사항1 공지사항1</p>
                    </a>
                    <a href="#" class="text-decoration-none text-black">
                        <p>공지사항1 공지사항1 공지사항1 공지사항1 공지사항1 공지사항1</p>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>
<%@ include file="footer.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</body>

</html>