<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="main">
	<div class="bg-white d-flex align-items-center p-3">
			<a href="/user/join_view"><img src="/static/image/arrow.png" width="50"></a>
			<div class="d-flex justify-content-center">
				<h3 class="favorite-subject">${meet.meetName}</h3>
			</div>
	</div>
	<nav class="navbar-collapse">
		<ul class="nav d-flex">
		      <li class="nav-item active">
		        <a class="nav-link" href="../meet/detail_view?meetId=${meet.id}">정보</a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link" href="../post/meetPost_view?meetId=${meet.id}">게시판</a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link" href="#">채팅</a>
		      </li>
	    </ul>
	</nav>
	</div>
	<form id="moreListForm">
	<div class="list">
		<div class="d-flex flex-wrap justify-content-center">
				<a href="#" >
					<div class="meet-box">
					    <div class="meet-inner d-flex justify-content-between">
					    	<div>
					    	<img alt="" src="/static/image/person.png"  width="25">
					    	<span>글쓴이</span>
					    	</div>
					    	<div>올린날짜</div>
					    </div>
					    <div class="d-flex justify-content-between">
					    	<div>
						    	<div><b>제목</b></div>
						    	<div>글						    	
									<p>${meet.desc}</p>
						    	</div>
					    	</div>
					    	<div>
					    		<c:if test="${empty meet.meetImagePath}">
								<img alt="" src="/static/image/no-photo.png"  width="100">
								</c:if>
								<img src="${meet.meetImagePath}" width="100">
					    	</div>
					    	</div>
					    	<div class="">
					    		<div class="d-flex">
					    			<img alt="" src="/static/image/no-photo.png"  width="25">	
					    			<div>좋아요</div>
					    			<div>3</div>				    			
					    		</div>
					    		<hr>
					    		<div class="">
					    			
									<div class="cleate-comment-group d-flex justify-content-start mt-2 ">
										<input type="text" id="commentText${content.post.id}" name="commentText" class="form-control" placeholder="댓글을 입력해주세요.">
										<button type="button" class="commentBtn btn btn-none" data-post-id="${content.post.id}">게시</button>
									</div>	
					    		</div>
					    	</div>
					    
					    		
					</div>
				</a>
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