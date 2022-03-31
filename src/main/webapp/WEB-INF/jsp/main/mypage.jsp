<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="mypage">
<h3>MyPage</h3>
	<div class="member-list d-flex justify-content-between">
		<div class="d-flex align-items-center">
			<div>
				<img alt="" src="/static/image/person.png" width="70">
			</div>
			<div class="">
				<div class="name">
				${name}
				</div>
				<div class="address d-flex align-items-center">
					<img alt="" src="/static/image/location.png" width="30">
					<div>${address}</div>
				</div>
			</div>
		</div>
		<div class="d-flex justify-content-end align-items-center">
				<a href="/main/member_update_view" class="memberBtn btn btn-success text-white">수정</a>
		</div>
	</div>
	<div class="faverite-list d-flex justify-content-between">
		<div class="nav">
			<ul class="nav d-flex">
			 	<c:forEach var="uf" items="${userFavorites}">	
			      <li class="nav-item active">
			        <a class="nav-link" href="#">${uf.favoriteName}</a>
			      </li>
			     </c:forEach>
	    	</ul>
		</div>
		<a href="/main/favorite_update_view" class="btn btn-success text-white">수정</a>
	</div>
	<div> 
	<div class="meet-join-list">
	<h3>내가 가입한 모임</h3>
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
	</div>
	<div class="meet-create-list">
	<h3>내가 만든 모임</h3>
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
	</div>
	</div>
</div>