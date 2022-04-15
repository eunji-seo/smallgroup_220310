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
				${user.name}
				</div>
				<div class="address d-flex align-items-center">
					<img alt="" src="/static/image/location.png" width="30">
					<div>${user.address}</div>
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
			 	<c:forEach var="uf" items="${userFavoriteList}">	
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
	<!--  내가 가입한 모임-->
	<h3>내가 가입한 모임</h3>
		<div class="list d-flex flex-wrap justify-content-center">
		<c:forEach var="join" items="${meetJoin}">
			<div class="meet-box">
				<a href="../meet/detail_view?meetId=${join.id}" data-meet-id="${join.id}">
					<div class="d-flex">
						<div class="img-area">
							<c:if test="${empty join.meetImagePath}">
							<img alt="" src="/static/image/no-photo.png"  width="100">
							</c:if>
							<img src="${join.meetImagePath}" width="100">
						</div>			
						<div class="">
							<div class="d-flex">
								<div class="gu">${join.meetAddress}</div>
								<div>
									<h5>${join.meetName}</h5>
								</div>
							</div>	
							<p>${join.desc}</p>
							<div class="d-flex">
								<img src="/static/image/person.png" width="25">
								<div>${join.personnel}</div>
							</div>	
						</div>		
					</div>
				</a>
			</div>
			</c:forEach>
		</div>	
	</div>
	<div class="meet-create-list">
	<!--  내가 만든 모임-->
	<h3>내가 만든 모임</h3>
		<div class="list d-flex flex-wrap justify-content-center">
			<c:forEach var="user" items="${meetUser}">
			<div class="meet-box">
				<a href="../meet/detail_view?meetId=${user.id}" data-meet-id="${user.id}">
					<div class="d-flex">
						<div class="img-area">
							<c:if test="${empty user.meetImagePath}">
							<img alt="" src="/static/image/no-photo.png"  width="100">
							</c:if>
							<img src="${user.meetImagePath}" width="100">
						</div>			
						<div class="">
							<div class="d-flex">
								<div class="gu">${user.meetAddress}</div>
								<div>
									<h5>${user.meetName}</h5>
								</div>
							</div>	
							<p>${user.desc}</p>
							<div class="d-flex">
								<img src="/static/image/person.png" width="25">
								<div>${user.personnel}</div>
							</div>	
						</div>		
					</div>
				</a>
			</div>
			</c:forEach>
		</div>	
	</div>
	</div>
</div>