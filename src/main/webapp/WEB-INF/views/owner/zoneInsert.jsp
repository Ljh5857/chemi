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
        <h3><strong>캠핑존 등록하기</strong></h3>
			<hr>
				<input type="text" name="seasonNo" value="1" hidden>
				<input type="text" name="name" placeholder="존 이름">
				<br>
				<br>
				<input type="number" name="maxPeople" placeholder="최대인원"> 명
				<br>
				<br>
				<input type="number" name="price" placeholder="가격"> 원
				<button onclick="insertZone();">등록하기</button>
         <!---------------------------------------------------------------------------------->
</section>

    </section>


	</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>

	function insertZone(){
		const seasonNoValue = document.querySelector("input[name=seasonNo]").value;
		const nameValue = document.querySelector("input[name=name]").value;
		const maxPeopleValue = document.querySelector("input[name=maxPeople]").value;
		const priceValue = document.querySelector("input[name=price]").value;

		$.ajax({
			url : "http://127.0.0.1:8080/owner/api/zone/insert",
			method : "post",
			data : {
				seasonNo : seasonNoValue,
				name : nameValue,
				maxPeople : maxPeopleValue,
				price : priceValue
			},
			success : function(x){
				alert(x);
				location.href="/owner/zone/list"
			},
			error : function(error){
					console.log(error);
			},
		});

	}


</script>
