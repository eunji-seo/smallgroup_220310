<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="main">
	<div class="navbar-collapse">
		 <ul class="nav d-flex">
		 	  <li class="nav-item active">
		        <a class="nav-link" href="#">전체</a>
		      </li>
		    <c:forEach var="uf" items="${userFavorites}">	
		      <li class="nav-item active">
		        <a class="nav-link" href="#" id="category">${uf.favoriteName}</a>
		      </li>
		     </c:forEach>
	    </ul>
	    <hr>
	</div>
	<form id="moreListForm">
		<ul class="content-list d-flex flex-wrap justify-content-center">
			<c:forEach var="meet" items="${meet}">
				<a href="../meet/detail_view?meetId=${meet.id}" data-meet-id="${meet.id}">
					<li class="meet-box d-flex">
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
					</li>
				</a>
				<span id="dots"></span>	<span id="more">
			</c:forEach>
		</span>
		
		</ul>
	<div class=" d-flex justify-content-end">
		<a href="../meet/meet_create_view">
			<img alt="" src="/static/image/meet_plus.png" width="100">
		</a>
	</div>
	<div class="moreView d-flex justify-content-center">
	
		<a href="#" onclick="myFunction()" id="myBtn"class="btn">
		  Read more
		</a>
	</div>
	</form>
</div>
<script>

function myFunction() {
  var dots = document.getElementById("dots");
  var moreText = document.getElementById("more");
  var btnText = document.getElementById("myBtn");

  if (dots.style.display === "none") {
    dots.style.display = "inline";
    btnText.innerHTML = "Read more"; 
    moreText.style.display = "none";
  } else {
    dots.style.display = "none";
    btnText.innerHTML = "Read less"; 
    moreText.style.display = "inline";
  }
}


 

</script>