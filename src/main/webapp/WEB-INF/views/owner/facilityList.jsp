<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!doctype html>
<html class="fixed">
<head>

    <!-- Basic -->
    <meta charset="UTF-8">

    <title>캠핑장 등록</title>
    <meta name="keywords" content="HTML5 Admin Template" />
    <meta name="description" content="JSOFT Admin - Responsive HTML5 Template">
    <meta name="author" content="JSOFT.net">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <jsp:include page="/resources/commonCssAdmin.jsp"/>

    <style>
        .image-container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
        }
        .image-item {
            display: flex;
            flex-direction: column;
            align-items: center;
            width: 200px; /* 원하는 이미지 아이템의 너비로 설정 */
        }
        .image-item img {
            max-width: 150px; /* 이미지의 최대 너비를 설정 */
            max-height: 150px; /* 이미지의 최대 높이를 설정 */
            height: auto;
        }
        .image-item button {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <section class="body">
        <!-- start: header -->
        <jsp:include page="../common/ownerHeader.jsp"/>
        <!-- end: header -->

        <div class="inner-wrapper">
            <!-- start: sidebar -->
            <jsp:include page="../common/ownerSidebar.jsp"/>
            <!-- end: sidebar -->
            <section role="main" class="content-body" style="padding-top: 0px;">

                <!---------------------------------------------------------------------------------->
                <h3><strong>주요시설 등록</strong></h3>
                <hr>

                <div class="image-container">
                    <div class="image-item">
                        <img src="/resources/images/facility/sink.png" alt="sink" data-name="sink">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/wifi.png" alt="wifi" data-name="wifi">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/market.png" alt="market"  data-name="market">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/shower.png" alt="shower" data-name="shower"> 
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/toilet.png" alt="toilet" data-name="toilet">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/electric_station.png" alt="electric_station" data-name="electric_station">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/bbq.png" alt="bbq" data-name="bbq">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/cafe.png" alt="cafe" data-name="cafe">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/pool.png" alt="pool" data-name="pool">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/activity.png" alt="activity" data-name="activity">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/playground.png" alt="playground" data-name="playground">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/pet.png" alt="pet" data-name="pet">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/trailer.png" alt="trailer" data-name="trailer">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/caravan.png" alt="caravan" data-name="caravan">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/tracking.png" alt="tracking" data-name="tracking">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/trampoline.png" alt="trampoline" data-name="trampoline">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/sleigh.png" alt="sleigh" data-name="sleigh">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/camping_tool.png" alt="camping_tool" data-name="camping_tool">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/water_play.png" alt="water_play" data-name="water_play">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/fishing.png" alt="fishing" data-name="fishing">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/water_activity.png" alt="water_activity" data-name="water_activity">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/MTB.png" alt="MTB" data-name="MTB">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/hiking.png" alt="hiking" data-name="hiking">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/golf.png" alt="golf" data-name="golf">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/beach.png" alt="beach" data-name="beach">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    <div class="image-item">
                        <img src="/resources/images/facility/ski.png" alt="ski" data-name="ski">
                        <button onclick="updateFacil(this);">등록</button>
                    </div>
                    
                </div>

                <!---------------------------------------------------------------------------------->
            </section>
        </div>
    </section>
</body>
</html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script>
  
  function updateFacil(button){
    // 부모 요소에서 img 태그를 찾기
   const imgElement = button.parentElement.querySelector('img');
    // data-name 속성 값 가져오기
    const name = imgElement.dataset.name;
    console.log(name);
   
   $.ajax({
      url : "http://127.0.0.1:8080/owner/facility",
      method : "post",
      data : {
         name : name
      },
      success : (x) => {
         alert(x);
         const checkImageUrl = '/resources/images/checkPoint.png';
            

            imgElement.src = checkImageUrl;
            imgElement.alt = '체크';


            button.disabled = true;
         
      },
   });
  }
</script>
