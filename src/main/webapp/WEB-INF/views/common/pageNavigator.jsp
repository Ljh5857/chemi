 <%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 
<div class="container text-center" style="display: contents;">
		 
		 <nav>
		  <!-- 크기조절 :  pagination-lg pagination-sm-->
		  <ul class="pagination" >
		    
		    <!--  <<== 좌측 nav -->
		  	<c:if test="${ resultPage.currentPage <= resultPage.pageUnit }">
		 		<li class="disabled">
			</c:if>
			<c:if test="${ resultPage.currentPage > resultPage.pageUnit }">
				<li>
			</c:if>
		   			<a href="javascript:fncGetList('${ resultPage.currentPage-1}')" aria-label="Previous">
		        		<span aria-hidden="true"><i class="fa fa-angle-left"></i></span>
		      		</a>
				</li>
		    
		    <!--  중앙  -->
			<c:forEach var="i"  begin="${resultPage.beginUnitPage}" end="${resultPage.endUnitPage}" step="1">
				
				<c:if test="${ resultPage.currentPage == i }">
					<!--  현재 page 가르킬경우 : active -->
				    <li class="active">
				    	<a href="javascript:fncGetList('${ i }');">${ i }<span class="sr-only">(current)</span></a>
				    </li>
				</c:if>	
				
				<c:if test="${ resultPage.currentPage != i}">
					<li>
						<a href="javascript:fncGetList('${ i }');">${ i }</a>
					</li>
				</c:if>
			</c:forEach>
		    
		    
		    <!--  우측 nav==>> -->
		    <c:if test="${ resultPage.currentPage >= resultPage.maxPage }">
		 		<li class="disabled">
		   	</c:if>
			<c:if test="${ resultPage.currentPage < resultPage.maxPage }">
				<li>
			</c:if>
			     	<a href="javascript:fncGetList('${resultPage.currentPage+1}')" aria-label="Next">
		        		<span aria-hidden="true"><i class="fa fa-angle-right"></i></span>
		      		</a>
		      	</li>

		  </ul>
		</nav>
		
</div>
 
