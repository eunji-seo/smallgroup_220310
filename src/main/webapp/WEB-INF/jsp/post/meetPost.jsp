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
		        <a class="nav-link" href="${pageContext.request.contextPath}/post/meet_post_view?meetId=${meet.id}">게시판</a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link" href="#">채팅</a>
		      </li>
	    </ul>
	</nav>
	</div>
	<form id="moreListForm">
	<div class="list">
	<c:forEach var="content" items="${contentViewList}">
		<div class="d-flex flex-wrap justify-content-center">
					<div class="meet-post-box">
					    <div class="meet-inner d-flex justify-content-between">
					    	<div>
					    	<img alt="" src="/static/image/person.png"  width="25">
					    	<span>${content.user.loginId}</span>
					    	</div>
					    	<div>
					    	<fmt:formatDate var="resultRegDt" value="${content.meetPost.updatedAt}" pattern="yyyy년 MM월 dd일 HH:mm:ss"/>
					    	${resultRegDt}
					    	</div>
					    	<%-- 클릭할 수 있는 ... 버튼 이미지 --%>
						<%-- 글쓴사용자와 로그인 사용자가 일치할때만 삭제 가능--%>
							<a href="#" class="more-btn" data-toggle="modal" data-target="#moreModal" data-meet-post-id="${content.meetPost.id}"> 
								<img src="https://www.iconninja.com/files/860/824/939/more-icon.png" width="30">
							</a>
						</div>
					    <div class="d-flex justify-content-between">
					    	<div>
						    	<div><b>${content.meetPost.subject}</b></div>
						    	<div>						    	
									<p>${content.meetPost.contentText}</p>
						    	</div>
					    	</div>
					    	<div>
					    		<c:if test="${empty content.meetPost.postImagePath}">
								<img alt="" src="/static/image/no-photo.png"  width=150>
								</c:if>
								<img src="${content.meetPost.postImagePath}" width="200">
					    	</div>
					    	</div>
					    	<div class="">
					    		<div class="d-flex justify-content-start mt-2 ml-5">
									<a href="#" class="likeBtn mr-2" data-meet-post-id="${content.meetPost.id}" data-user-id="${content.user.id}">
											<%-- 좋아요 누름 --%>
											<c:if test="${content.filledLike eq false}">
												<img width="18" src="/static/image/notlike.png"/>
											</c:if>
											<%-- 좋아요 해제 --%>
											<c:if test="${content.filledLike eq true}">
												<img width="18" src="/static/image/like.png"/>
											</c:if>
										
									</a>		
										<a class=""><b>좋아요${content.likeCount}개</b></a>
								</div>
					    		<hr>
					    		<div class="comment-group m-2 ml-4 mr-4" >
								<c:if test="${not empty content.commentList}">
					    			<c:forEach var="comment" items="${content.commentList}">
											<div class="comment-list">
												<span class="ml-2"><b>${comment.user.loginId}</b></span>
												<span>${comment.comment.content}</span>
												<%-- 댓글 삭제버튼 --%>
													<a href="#" class="commentDelBtn" data-comment-id="">
														<img src="https://www.iconninja.com/files/603/22/506/x-icon.png" width="10px" height="10px">
													</a>
											</div>
									</c:forEach>
								</c:if>
									<div class="cleate-comment-group d-flex justify-content-start mt-2 ">
										<input type="text" id="commentText${content.meetPost.id}" name="commentText" class="form-control"  placeholder="댓글을 입력해주세요.">
										<button type="button" id="commentBtn" class="commentBtn btn btn-none"  data-meet-post-id="${content.meetPost.id}" data-meet-id="${meet.id}">게시</button>
									</div>	
					    		</div>
					    	</div>	
					</div>
			</div>
		</c:forEach>
	</div>
	<div class=" d-flex justify-content-end">
		<a href="${content.meetPost.updatedAt}/post/post_create_view?meetId=${param.meetId}">
			<img alt="" src="/static/image/meet_plus.png" width="100">
		</a>
	</div>
	<div class=" d-flex justify-content-end">
		<a href="${content.meetPost.updatedAt}/post/meet_post_detail?meetPost=${param.id}">
			<img alt="" src="/static/image/meet_plus.png" width="100">
		</a>
	</div>
	</form>
</div>

<!-- Modal -->
<div class="modal fade" id="moreModal">
  <div class="modal-dialog modal-sm modal-dialog-centered" role="document">
    <div class="modal-content">
      	<%-- modal 창 안에 내용 넣기 --%>
      	<div class="">
      		<div class="my-3 text-center">
      			<a href="#" class="del-post d-block" >삭제하기</a>
      		</div>
      		<div class="border-top py-3 text-center">
      			<a href="#" class="cancel d-block" data-dismiss="modal">취소</a>
      		</div>
      	</div>
    </div>
  </div>
</div>

<script>

$(document).ready(function(){
	
$('.commentBtn').on('click',function(){
	alert("c");
	let meetPostId= $(this).data('meet-post-id'); 
	let meetId = $(this).data('meet-id');
	
	alert(meetPostId);

	let content = $('#commentText'+ meetPostId ).val();
	alert(content);
	
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
		
	let	meetPostId = $(this).data('meet-post-id');
	let userId = $(this).data('user-id');
	
	console.log(meetPostId);
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

//카드에서 더보기(...) 클릭시 모달에 삭제될 글 번호를 넣어준다.
$('.more-btn').on('click', function(e){
	e.preventDefault();
	
	let postId = $(this).data('meet-post-id');
	//alert(postId);
	
	$('#moreModal').data('meet-post-id', postId);// set data-post-id="1" 같다 
});


// 모달창 안에 있는 삭제하기 버튼 클릭
$('#moreModal .del-post').on('click', function(e){
	e.preventDefault();
	
	let meetPostId = $('#moreModal').data('meet-post-id'); // get 꺼내서 사용할수 있게 된다
	//alert(postId);
	
	// 삭제 AJAX DELETE
	
	$.ajax({
		type:"DELETE"
		,url:"/post/delete"
		,data:{"meetPostId": meetPostId}
		,success: function(data){
			if(data.result == 'success'){
				alert("삭제 되었습니다.");
				location.reload();
				
			}else{
				alert(data.errorMessage);
			}
		
		}
		,error: function(e){
			alert("삭제가 실패되었습니다. 관리자에 문의해주세요.");
		}
		
		
	});
	
});
// 댓글 삭제
$('.commentDelBtn').on('click',function(e){
	e.preventDefault();
	
	let commentId = $(this).data('comment-id');
	//alert(commentId);
	
	
	$.ajax({
		type:"DELETE"
		,url:"/comment/delete"
		,data:{"commentId":commentId}
	
		,success:function(data){
			if(data.result == "success"){
				alert("삭제되었습니다.");
				location.reload();				
			}else{
				alet(data.errorMessage);
			}
			
		}
		,error: function(e){
			alert("댓글 삭제가 실패했습니다. 관리자에 문의바랍니다.")
		}
	});
	
});

});
</script>