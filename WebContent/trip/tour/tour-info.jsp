<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
    <title>EnjoyTrip</title>
    <style>
        p {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            line-height: 1;
        }

        #tourList {
            width: 100vw;
        }

        #tourList > div {
            width: 100%;
            height: auto;
            position: relative;
        }

        .left {
            display: flex;
            justify-content: flex-start;
        }

        .right {
            display: flex;
            justify-content: flex-end;
        }

        .tour_img {
            width: 70%
        }

        .gradation_left {
            position: absolute;
            top: 0;
            right: 0;
            width: 70%;
            height: 100%;
            background: linear-gradient(to left, white 50%, transparent);
        }

        .gradation_right {
            position: absolute;
            top: 0;
            left: 0;
            width: 70%;
            height: 100%;
            background: linear-gradient(to right, white 50%, transparent);
        }

        .text_group_left {
            width: 100%;
            position: absolute;
            height: 70%;
            overflow-y: scroll;
            position: absolute;
            right: 5%;
            top: 15%;
            z-index: 1;
            text-align: right;
            display: flex;
            flex-direction: column;
            align-items: flex-end;
        }
        .text_group_right {
            width: 100%;
            height: 70%;
            overflow-y: scroll;
            position: absolute;
            left: 5%;
            top: 15%;
            z-index: 1;
            text-align: left;
        }

        .tour_title {
            color: rgb(35, 35, 35);
            font-size: 2vw;
            font-weight: bold;
            font-style: italic;
            margin-bottom: 20px;
            border-bottom: solid 1px rgb(204, 204, 204);
            padding: 5px 10px;
            width: 60%;
        }

        .tour_text {
            margin-top: 20px;
            width: 50%;
            font-size: 1.2vw;
            line-height: 35px;
            word-break: keep-all;
            font-weight: 500;
        }

        .map_title {
            font-size: 25px;
            font-weight: bold;
            font-style: italic;
            border-bottom: solid 1px rgb(189, 189, 189);
            margin-left: 50px;
            width: 50%;
            margin-top: 50px;
            padding: 10px 20px;
        }
    </style>
</head>
<body>
<%@include file="../../header.jsp" %>
<section>
    <c:if test="${empty maplist }">
    <div class="d-flex flex-column">
        <h1 class="fw-bold mt-5 mb-3 text-center">지역별 관광정보</h1>
        <form action="${root}/tour-info" method="post">
            <div class="d-flex justify-content-center mb-3 align-items-center">
                <div class="row me-2">
                    <div class="col-4">
                        <select class="form-select" id="sido-select" name="sido-code"
                                style="min-width: 200px">
                            <option selected disabled>시</option>
                        </select>
                    </div>
                    <div class="col-4">
                        <select class="form-select" id="gugun-select" name="gugun-code"
                                style="min-width: 200px">
                            <option selected disabled>구, 군</option>
                        </select>
                    </div>
                    <div class="col-4">
                        <select class="form-select" id="type-select"
                                name="type-code">
                            <option selected disabled>관광지 유형</option>
                            <option value="12">관광지</option>
                            <option value="14">문화시설</option>
                            <option value="15">행사/공연/축제</option>
                            <option value="25">여행코스</option>
                            <option value="28">레포츠</option>
                            <option value="32">숙박</option>
                            <option value="38">쇼핑</option>
                            <option value="39">음식점</option>
                        </select>
                    </div>
                </div>
                <div class="align-self-center">
                    <input type="submit" value="검색" class="btn btn-info text-white">
                </div>
            </div>
        </form>
    </div>
    <div class="d-flex justify-content-center mb-3">
        <div id="map" class="w-75" style="width: 500px; height: 700px;"></div>
    </div>
    </c:if>
    <!-- list가 비어있지 않을 때 지도와 표를 출력해줄것임 -->
    <c:if test="${!empty maplist }">
    <div class="map_title">지도 보기</div>
    <div style="width: 100vw; height: 80vh;  margin: auto; margin-top: 50px; padding-bottom: 100px; display:flex; justify-content: center; align-items: center;">
        <div id="map" style="width: 100%; height: 100%; box-shadow: 1px 1px 16px 0 rgb(33 34 34 / 30%);"></div>
    </div>
    <script type="text/javascript"
            src="//dapi.kakao.com/v2/maps/sdk.js?appkey=제공받은키"></script>
    <script>
        var mapContainer = document.getElementById('map'), // 지도를 표시할 div
            mapOption = {
                center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                level: 5
                // 지도의 확대 레벨
            };
        // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
        var map = new kakao.maps.Map(mapContainer, mapOption);

        /* console.log(`${maplist[0]}`); */
        const initLat = +`${maplist[0].latitude}`;
        const initLng = +`${maplist[0].longitude}`;

        map.setCenter(new kakao.maps.LatLng(initLat, initLng));

        var markerImageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

        var imageSize = new kakao.maps.Size(24, 35);

        var markerImage = new kakao.maps.MarkerImage(markerImageSrc, imageSize);

        var marker = new kakao.maps.Marker({
            map: map,
            position: new kakao.maps.LatLng(initLat, initLng),
            image: markerImage,
        });

        marker.setMap(map);
    </script>
    <div id="tourList">
        <c:forEach items="${maplist }" var="map" varStatus="status">
            <c:if test="${map.image != ''}">
                <c:if test="${status.index % 2 == 0 }">
                    <div class="left">
                        <image class="tour_img" src="${map.image }"/>
                        <div class="gradation_left"></div>
                        <div class="text_group_left">
                            <div class="tour_title"><span style="margin-right: 10px; font-size: 15px; color: gray;">${map.address }</span>${map.title }</div>
                            <div class="tour_text">"${map.content }"</div>
                        </div>
                    </div>
                </c:if>
                <c:if test="${status.index % 2 == 1 }">
                    <div class="right">
                        <div class="text_group_right">
                            <div class="tour_title">${map.title }<span style="margin-left: 10px; font-size: 15px; color: gray;">${map.address }</span></div>
                            <div class="tour_text">"${map.content }"</div>
                        </div>
                        <div class="gradation_right"></div>
                        <image class="tour_img" src="${map.image }"/>
                    </div>
                </c:if>
            </c:if>
        </c:forEach>
    </div>

    </c:if>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script type="text/javascript"
            src="//dapi.kakao.com/v2/maps/sdk.js?appkey=제공받은키"></script>
    <script>
        let markers = [];
        let tourList = [];
        let latSum = 0;
        let lngSum = 0;

        window.addEventListener('load', async function (event) {
            await axios({
                method: 'get',
                url: '${root}/regions?mode=sido'
            }).then(function (response) {
                if (response.status === 200) {
                    const sidos = response.data;
                    for (let i = 0; i < sidos.length; i++) {
                        const sido = sidos[i];
                        const option = document.createElement('option');
                        option.value = sido.sidoCode;
                        option.innerText = sido.sidoName;
                        document.getElementById('sido-select').appendChild(option);
                    }
                }
            }).catch(function (error) {
                console.log(error);
            });
        });

        const sidoSelect = document.getElementById('sido-select');
        sidoSelect.addEventListener('change', async function (event) {
            const sidoCode = sidoSelect.value;
            await axios({
                method: 'get',
                url: '${root}/regions?mode=gugun&sido_code=' + sidoCode
            }).then(function (response) {
                if (response.status === 200) {
                    document.getElementById('gugun-select').innerHTML = '';
                    const guguns = response.data;
                    console.log(guguns)
                    for (let i = 0; i < guguns.length; i++) {
                        const gugun = guguns[i];
                        const option = document.createElement('option');
                        option.value = gugun.gugunCode;
                        option.innerText = gugun.gugunName;
                        document.getElementById('gugun-select').appendChild(option);
                    }
                }
            }).catch(function (error) {
                console.log(error);
            });
        });
    </script>
</body>
</html>