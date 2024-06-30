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
        <h3><strong>캠핑장 공지사항</strong></h3>

			<hr>
			<table border="1">
        <thead>
           <tr>
              <th>번호</th>
              <th>제목</th>
              <th>조회수</th>
              <c:if test="${sessionScope.loginAdminVo != null}">
              <th><button onclick="deleteCheckedBoard();">❌</th>
              </c:if>
           </tr>
        </thead>
        <tbody>
  
           <c:forEach items="${voList}" var="vo">
              <tr>
                 <td>번호</td>
                 <td><a href="/app/board/detail?no=${vo.no}&writerNo=${vo.writerNo}">${vo.title}</a></td>
                 <td>${vo.hit}</td>
                 <c:if test="${sessionScope.loginAdminVo != null}">
                 <td><input type="checkbox" value="${vo.no}"> </td>>
                 </c:if>
              </tr>
           </c:forEach>  
        </tbody>
     </table>
         <!---------------------------------------------------------------------------------->
</section>

    </section>


	</body>
</html>