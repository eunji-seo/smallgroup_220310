<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		        <a class="nav-link" href="${pageContext.request.contextPath}/meet/detail_view?meetId=${meet.id}">정보</a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link" href="${pageContext.request.contextPath}/post/meetPost_view?meetId=${meet.id}">게시판</a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link" href="#">채팅</a>
		      </li>
	    </ul>
	</nav>
	</div>
	<form id="moreListForm">
	<div class="list">
	<c:forEach var="postList" items="${postList}">
		<div class="d-flex flex-wrap justify-content-center">
					<div class="meet-post-box">
					    <div class="meet-inner d-flex justify-content-between">
					    	<div>
					    	<img alt="" src="/static/image/person.png"  width="25">
					    	<span>${postList.userId}</span>
					    	</div>
					    	<div>
					    	<fmt:formatDate var="resultRegDt" value="${postList.updatedAt}" pattern="yyyy년 MM월 dd일 HH:mm:ss"/>
					    	${resultRegDt}
					    	</div>
					    </div>
					    <div class="d-flex justify-content-between">
					    	<div>
						    	<div><b>${postList.subject}</b></div>
						    	<div>						    	
									<p>${postList.contentText}</p>
						    	</div>
					    	</div>
					    	<div>
					    		<c:if test="${empty postList.postImagePath}">
								<img alt="" src="/static/image/no-photo.png"  width=150>
								</c:if>
								<img src="${postList.postImagePath}" width="200">
					    	</div>
					    	</div>
					    	<div class="">
					    		<div class="d-flex">
					    			<img alt="" src="/static/image/notlike.png"  width="25">	
					    			<div>좋아요</div>
					    			<div>3</div>				    			
					    		</div>
					    		<hr>
					    		<div class="">
											<div class="comment-list">
												<span class="ml-2"><b></b></span>
												<span></span>
												<%-- 댓글 삭제버튼 --%>
													<a href="#" class="commentDelBtn" data-comment-id="">
														<img src="https://www.iconninja.com/files/603/22/506/x-icon.png" width="10px" height="10px">
													</a>
											</div>

									<div class="cleate-comment-group d-flex justify-content-start mt-2 ">
										<input type="text" id="commentText" name="commentText" class="form-control" data-meetPost-id="${postList.id}" placeholder="댓글을 입력해주세요.">
										<button type="button" class="commentBtn btn btn-none"  data-meet-id="${postList.meetId}">게시</button>
									</div>	
					    		</div>
					    	</div>	
					</div>
			</div>
		</c:forEach>
	</div>
		<c:if test="${cnt == 1 or id == meet.userId}">
	<div class=" d-flex justify-content-end">
		<a href="../post/post_create_view?meetId=${param.meetId}">
			<img alt="" src="/static/image/meet_plus.png" width="100">
		</a>
	</div>
	</c:if>
	<div class="more d-flex justify-content-center">
		<a href="#">
			<img alt="" src="/static/image/more.png" width="50">
		</a>
	</div>
	</form>
</div>
<script>

$('.commentBtn').on('click',function(){
let meetPostId= $('#commentText').data('meetPost-id'); 
let meetId= $(this).data('meet-id'); 
	//alert(postId);

	let content = $('#commentText').val();
	//alert(commentText);
	
	if(content == ''){
		alert("댓글을 입력해주세요.")
		return;
	}
	
	$.ajax({
		type:"POST"
		,url:"/comment/create"
		,data: { 
			"meetId":meetId, 
			"meetPostId":meetPostId,
			"content":content
			}
		,success: function(data){
			if(data.result == 'success'){
				alert("댓글이 입력되었습니다.")
				location.reload();
			}
			
		}
		,error: function(e){
			alert("댓글입력에 실패하였습니다. 관리자에 연락해주세요.")	
		}
		
		
		
	});
	
});
$('.likeBtn').on('click', function(e){
		e.preventDefault();
		
	let	meetPostId = $(this).data('post-id');
	let userId = $(this).data('user-id');
	
	console.log(postId);
	console.log(userId);
	
	if(userId == ''){
		alert("로그인후 사용가능합니다.");
		return;
	}
	
	$.ajax({
		type: "POST"
		, url: "/like/" + meetPostId
		, success: function(data){
			if(data.result == 'success'){
				location.reload();
				
			}else {
				alert(data.errorMassage);
			}
		}
		, error: function(e){
			alert("좋아요의 실패하였습니다.");	
		}
		
	});
});


</script>