<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="main">
	<div class="navbar-collapse">
		 <ul class="nav d-flex">
		 	<c:forEach var="uf" items="${userFavorites}">	
		      <li class="nav-item active">
		        <a class="nav-link" href="#">${uf.favoriteName}</a>
		      </li>
		     </c:forEach>
	    </ul>
	    <hr>
	</div>
	<form id="moreListForm">
	<div class="list">
		<div class="d-flex flex-wrap justify-content-center">
			<c:forEach var="meet" items="${meet}">
				<a href="../meet/detail_view?meetId=${meet.id}" data-meet-id="${meet.id}">
					<div class="meet-box d-flex">
						<div class="img-area">
							<c:if test="${empty meet.meetImagePath}">
							<img alt="" src="/static/image/no-photo.png"  width="100">
							</c:if>
							<img src="${meet.meetImagePath}" width="100">
						</div>			
						<div class="">
							<div class="d-flex">
								<div class="gu">${meet.meetAddress}</div>
								<div>
									<h5>${meet.meetName}</h5>
								</div>
							</div>	
							<c:if test="${fn:length(meet.desc) > 18}">
								<p>${fn:substring(meet.desc,0,18)}...</p>
							</c:if>
							<c:if test="${fn:length(meet.desc) <= 18}">
								<p>${meet.desc}</p>
							</c:if>
							<div class="d-flex">
								<img src="/static/image/person.png" width="25">
								<div>${meet.personnel}</div>
							</div>	
						</div>		
					</div>
				</a>
			</c:forEach>
		</div>
	</div>
	<div class=" d-flex justify-content-end">
		<a href="../meet/meet_create_view">
			<img alt="" src="/static/image/meet_plus.png" width="100">
		</a>
	</div>
	<div class="more d-flex justify-content-center">
		<a href="#">
			<img alt="" src="/static/image/more.png" width="50">
		</a>
	</div>
	</form>
</div>
<script>


</script>