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
        <h3><strong>공지사항 상세보기</strong></h3>

			<hr>

				제목 ::   <input type="text" name="title" value="${vo.title}"> <input type="text" name="hit" value="${vo.hit}">
				<br>
				<br>
				내용 ::   
				<br>
				<br>
				<textarea style="width: 500px; height: 300px;" name="content">${vo.content}</textarea>



         <!---------------------------------------------------------------------------------->
</section>

    </section>


	</body>
</html>