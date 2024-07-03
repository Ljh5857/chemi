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
        <h3><strong>캠핑장 등록하기</strong></h3>

			<hr>
			<form  action="/owner/camp/insert" method="post" enctype="multipart/form-data" >

				<input type="text" name="area" placeholder="지역">
				<br>
				<br>
				<input type="text" name="campsiteCategory" placeholder="ex)오토 캠핑장, 글램핑장">
				<br>
				<br>
				<input type="text" name="name" placeholder="캠핑장 이름">
				<br>
                <br>
				<input type="text" name="tel" placeholder="전화번호">
				<br>
				<br>
				<input type="text" name="address" placeholder="캠핑장 주소">
				<br>
				<br>
			    <input type="text" name="basicInfo" placeholder="한줄 소개를 적어주세요">
				<br>
				<br>
				<textarea style="width: 400px; height: 300px;" name="introduction" placeholder="캠핑장 소개를 적어주세요"></textarea>
				<br>
				<br>
				<input type="file" name="zoneLayoutImg">
				<br>
				<br>
				<input type="submit" value="작성하기">
			</form>
         <!---------------------------------------------------------------------------------->
</section>

    </section>


	</body>
</html>