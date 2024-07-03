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

	</head>
	<body >
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
        <h3><strong>내 캠핑장</strong></h3>

			<hr>
				캠핑장 썸네일 이미지 <img style="height: 300px; width: 300px;" src="${voList.zoneLayoutImg}" >
				<br>
				<br>
				지역 :: <input type="text" name="area" value="${voList.area}" readonly>
				<br>
				<br>
				캠핑장 타입 :: <input type="text" name="campsiteCategory" value="${voList.campsiteCategory}" readonly>
				<br>
				<br>
				캠핑장 이름 :: <input type="text" name="name" value="${voList.name}" readonly>
				<br>
                <br>
				캠핑장 전화번호 :: <input type="text" name="tel" value="${voList.tel}" readonly>
				<br>
				<br>
				캠핑장 주소 :: <input type="text" name="address" value="${voList.address}" readonly>
				<br>
				<br>
			    캠핑장 한줄 소개 :: <input type="text" name="basicInfo" value="${voList.basicInfo}" readonly>
				<br>
				<br>
				캠핑장 소개 :: <textarea style="width: 400px; height: 300px;" name="introduction" readonly>${voList.introduction}</textarea>
				

         <!---------------------------------------------------------------------------------->
</section>

    </section>


	</body>
</html>