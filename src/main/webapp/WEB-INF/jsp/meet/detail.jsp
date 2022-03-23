<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="meet-detail">
	<div class="bg-white d-flex align-items-center p-3">
			<a href="/user/join_view"><img src="/static/image/arrow.png" width="50"></a>
			<div class="d-flex justify-content-center">
				<h3 class="favorite-subject">${meet.meetName}</h3>
			</div>
	</div>
	<nav class="navbar-collapse">
		<ul class="nav d-flex">
		      <li class="nav-item active">
		        <a class="nav-link" href="#">정보</a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link" href="#">게시판</a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link" href="#">채팅</a>
		      </li>
	    </ul>
	</nav>
	<div class="meet-info d-flex justify-content-around">
		<div class="meet-descAndBtn">
			<div class="meet-desc p-3 mt-2">
				<img alt="" src="/static/image/no-photo.png" width="350">
				<p>${meet.desc}</p>
			</div>
			<div class="meet-join mt-3">
				<a href="#" class="btn btn-success w-100" data-toggle="modal" data-target="#moreModal" data-meet-id="${meet.id}"> 
					가입하기
				</a>
			</div>
		</div>
		<div>
			<div class="meeting d-flex justify-content-start align-items-center mt-2">
			 	<div class="mr-3">
			 	<h3>정모 모임</h3>
			 		<img alt="" src="/static/image/smile.png" width="90">
			 	</div>
			 	<div>
			 		<div class="mb-2">
			 			<img alt="" src="/static/image/calendar.png" width="30">
						<span>4월 8일 (토) 오후 02:00</span>	
			 		</div>
			 		<div class="mb-2">
			 			<img alt="" src="/static/image/location.png" width="30">
						<span>노원 더숲</span>	
			 		</div>
			 		<div class="mb-2">
			 			<img alt="" src="/static/image/won.png" width="30">
						<span>1/N</span>	
			 		</div>
			 	</div>
			</div>
			<div class="meeting- mb-3">
				<a href="../meet/meeting_view"class="btn btn-secondary w-100">+정모 등록 하기</a>
			</div>
			<div class="member-list">
				<ul>
					<li></li>
				</ul>
			</div>
		</div>
	</div>
	
</div>

<!-- Modal -->
<div class="modal fade" id="moreModal">
  <div class="modal-dialog modal-sm modal-dialog-centered" role="document">
    <div class="modal-content">
      	<%-- modal 창 안에 내용 넣기 --%>
      	
      <div class="m-3">
      		<span class="mb-2">가입 하시겠습니까?</span>
      		<input type="text" class="form-control" id="joinName" name="joinName" placeholder="성함을 입력해주세요.">
	      	<div class="d-flex justify-content-center align-items-center">
		      	<div class="border-right pr-3 text-center">
		      			<a href="#" class="cancel d-block text-secondary" data-dismiss="modal">취소</a>
		      		</div>
	      		<div class="my-3 ml-3 text-center">
	      			<a href="#" class="del-post d-block" >확인</a>
	      		</div>
	      		
	      	</div>
      	</div>
    </div>
  </div>
</div>
<script>
$('#moreModal .del-post').on('click', function(e){
	e.preventDefault();
	
	let meetId = $('#moreModal').data('meet-id'); 
	let joinName = $('#joinName').val().trim(); 
	
	//let favoriteId = $('#moreModal').data('favorite-id'); 
	//alert(postId);
	
	// 삭제 AJAX DELETE
	
	$.ajax({
		type:"POST"
		,url:"/meet/detail"
		,data:{
			"meetId": meetId,
			"joinName": joinName			
	//		,"favoriteId": favoriteId			
		}
		,success: function(data){
			if(data.result == 'success'){
				alert("가입이 완료 되었습니다.");
				location.reload();
				
			}else{
				alert(data.errorMessage);
			}
		
		}
		,error: function(e){
			alert("가입이 실패하였습니다. 관리자에 문의해주세요.");
		}
		
		
	});
	
});

</script>