<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="main">
	<div class="navbar-collapse">
		 <ul class="nav d-flex">
		 	<c:forEach var="uf" items="${userFavorites}">	
		      <li class="nav-item active">
		        <a class="nav-link" href="#">${uf.favoriteId}</a>
		      </li>
		     </c:forEach>
	    </ul>
	    <hr>
	</div>
	<div class="list d-flex flex-wrap justify-content-center">
		<div class="meet-box">
			<a href="#">
				<div class="d-flex">
					<div class="img-area">
						<img src="https://cdn.pixabay.com/photo/2020/12/14/15/44/man-5831234__340.jpg" width="100">
					</div>			
					<div class="">
						<div class="d-flex">
							<div class="gu">강북구</div>
							<div>
								<h5>걷기모임</h5>
							</div>
						</div>	
						<p>걸어서 하늘까지</p>
						<div class="d-flex">
							<img src="/static/image/person.png" width="25">
							<div>65</div>
						</div>	
					</div>		
				</div>
			</a>
		</div>
	</div>
	<div class=" d-flex justify-content-end">
		<a href="../meet/favorite_view">
			<img alt="" src="/static/image/meet_plus.png" width="100">
		</a>
	</div>
	<div class="more d-flex justify-content-center">
		<a href="#">
			<img alt="" src="/static/image/more.png" width="50">
		</a>
	</div>
</div>
<script>

</script>