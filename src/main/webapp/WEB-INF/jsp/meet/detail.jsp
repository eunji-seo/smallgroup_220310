<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="meet-detail">
	<div class="bg-white d-flex align-items-center p-3">
			<a href="/main/main_view"><img src="/static/image/arrow.png" width="50"></a>
			<div class="d-flex justify-content-center">
				<h3 class="favorite-subject">${meet.meetName}</h3>
			</div>
	</div>
	<nav class="navbar-collapse">
		<ul class="nav d-flex">
		      <li class="nav-item active">
		        <a class="nav-link" href="${pageContext.request.contextPath}/meet/detail_view?meetId=${meet.id}">정보</a>
		      </li>
		      <c:if test="${cnt == 1 or id == meet.userId}">
		      <li class="nav-item active">
		        <a class="nav-link" href="${pageContext.request.contextPath}/post/meet_post_view?meetId=${meet.id}">게시판</a>
		      </li>
		       <li class="nav-item active">
			        <a class="nav-link" href="${pageContext.request.contextPath}/chat/chat_view?meetId=${meet.id}">채팅</a>
			    </li>
		      </c:if>
	    </ul>
	</nav>
	<div class="meet-info d-flex justify-content-around">
		<div class="meet-descAndBtn">
			<div class="meet-desc p-3 mt-2">
				<c:if test="${empty meet.meetImagePath}">
					<div class="d-flex justify-content-center">
						<img alt="" src="/static/image/no-photo.png" width="350">
					</div>	
				</c:if>
				<c:if test="${not empty meet.meetImagePath}">
					<img alt="" src="${meet.meetImagePath}" width="350">
				</c:if>
				<p>${meet.desc}</p>
			</div> 
			<c:if test="${cnt ne 1 and id != meet.userId}">
			<div class="meet-join mt-3">
				<a href="#" class="btn btn-success w-100" data-toggle="modal" data-target="#moreModalJoin"> 
					가입하기
				</a>
			</div>
			</c:if>
		</div>
		<div class="meeting">
			<c:forEach var="meeting" items="${meetingList}">
				<div class="meeting-content d-flex justify-content-start align-items-center mt-2">
				 	<div class="mr-3">
				 	<h4>정모 모임</h4>
				 		<img alt="" src="/static/image/smile.png" width="90">
				 	</div>
				 	<div>
				 		<div class="mb-2">
				 			<img alt="" src="/static/image/calendar.png" width="30">
							<span>${meeting.meetingDay}</span>	
				 		</div>
				 		<div class="mb-2">
				 			<img alt="" src="/static/image/location.png" width="30">
							<span>${meeting.place}</span>	
				 		</div>
				 		<div class="mb-2">
				 			<img alt="" src="/static/image/won.png" width="30">
							<span>${meeting.cost}</span>	
				 		</div>
				 		<div class="mb-2">
				 			<img alt="" src="/static/image/person.png" width="30">
							<span>${meeting.personnel}</span>	
				 		</div>
				 	</div>
				 	<c:if test="${cnt == 1 or id == meet.userId}">
				 	<div class="attend">
				 		<button type="button" class="btn btn-success mb-3" onclick="showModal('${meeting.id}')">참석</button>
				 		<hr>
				 		<a href="#" class="d-block" data-toggle="modal" data-target="#moreModalAttendjoin" onclick="showAttendModal('${meeting.id}')">참석자 리스트</a>
				 	</div>
				 	</c:if>
				</div>
				<!-- <div class="attend-list">
					<div class="d-flex justify-content-between">
						<h5>참석자 리스트</h5>
						<a href="#" "> 
						<button type="button" class="btn btn-success" onclick="showModal('${meeting.id}')">참석</button> 
						위의 show modal 참고
						
							<img alt="" src="/static/image/more_person.png" width="20" height="20">
						</a>
					</div>
				</div> -->
			</c:forEach>
			<c:if test="${meet.userId == id}">
				<div class="meeting- mb-3">
					<a href="../meet/meeting_view?meetId=${meet.id}"class="btn btn-secondary w-100 mt-2">+정모 등록 하기</a>
				</div>
			</c:if>
			<div class="member-list">
				<div class="d-flex justify-content-between">
					<h5>멤버 리스트</h5>
					<a href="#"><img alt="" src="/static/image/more_person.png" width="20" height="20"></a>
				</div>
				<ul>
					<li class="">${memberName.name}<b class="ml-2">방장</b></li>
					<c:forEach var="join" items="${join}">
						<li>${join.joinName}</li>
					</c:forEach>
				</ul>
				
			</div>
		</div>
	</div>
	
</div>

<!-- 가입하기 Modal -->
<div class="modal fade" id="moreModalJoin">
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
	      			<a href="../meet/detail_view?meetId=${meet.id}" class="joinBtn d-block" data-meet-id="${meet.id}">확인</a>
	      		</div>
	      		
	      	</div>
      	</div>
    </div>
  </div> 
</div>

<!-- 참석 Modal -->
<div class="modal fade" id="moreModalAttend">
  <div class="modal-dialog modal-sm modal-dialog-centered" role="document">
    <div class="modal-content">
      	<%-- modal 창 안에 내용 넣기 --%>
      	
      <div class="m-3">
      		<span class="mb-2">참석 하시겠습니까?</span>
      		<input type="text" class="form-control" id="attendName" name="attendName" placeholder="참석할 성함을 입력해주세요.">
	      	<div class="d-flex justify-content-center align-items-center">
		      	<div class="border-right pr-3 text-center">
		      			<a href="#" class="cancel d-block text-secondary" data-dismiss="modal">취소</a>
		      		</div>
	      		<div class="my-3 ml-3 text-center">
	      			<a href="../meet/detail_view?meetingId=${meeting.id}" id="attendBtn" class="attendBtn d-block"  data-meet-id="${meet.id}">참석</a>
	      		</div>
	      		<div data-meeting-id="" id="meetingId"></div>
	      	</div>
      	</div>
    </div>
  </div>
</div>
<!-- 참석 Modal -->
<div class="modal fade" id="moreModalAttendjoin">
  <div class="modal-dialog modal-sm modal-dialog-centered" role="document">
    <div class="modal-content">
      	<%-- modal 창 안에 내용 넣기 --%>
      	
      <div class="m-3">
      		<span class="mb-2"><b>참석자 리스트</b></span>      		
      		<div class="d-flex justify-content-center align-items-center">
		      	<div class="pr-3 text-center" id="attendsDiv">
		      		</div>
	      		<div data-meeting-id="" id="meetingId"></div>
	      	</div>
      	</div>
    </div>
  </div>
</div>
<script>
function showModal(meetingId){
	$('#moreModalAttend').modal();
	$('#meetingId').data('meeting-id',meetingId);
	
	
}
function showAttendModal(meetingId){
	
	//$('#meetingId').data('meeting-id',meetingId);
	$.get({
		url:"/meet/attends/" + meetingId
		,success: function(data){
			console.log(data);
			var html = '';
			html += '<div>${memberName.name}<b>방장</b></div>'
			for(var attend of data){
				html += '<div>'+attend.attendName+'</div>';
			}
			html += '<a href="#" class="cancel" data-dismiss="modal" data-meet-id="${meet.id}">취소</a>';
			$('#attendsDiv').html(html);
			$('#moreModalAttendjoin').modal();
		}
	});
	
}


$('#moreModalAttend .attendBtn').on('click', function(e){
	e.preventDefault();
	//alert("click");
	var meetId = $('#attendBtn').data('meet-id');
	var meetingId = $('#meetingId').data('meeting-id');
	var attendName = $('#attendName').val().trim(); 
		
	$.post({
		url:"/meet/detail_attend"
		,data:{
			"meetId":meetId
			,"meetingId": meetingId
			,"attendName": attendName			
	//		,"favoriteId": favoriteId			
		}
		,success: function(data){
			if(data.result == 'success'){
				alert("참석이 완료 되었습니다.");
				location.reload();
				
			}else{
				alert(data.errorMessage);
			}
		
		}
		,error: function(e){
			alert("참석이 실패하였습니다. 관리자에 문의해주세요.");
		}
		
		
	});
	
});

$('#moreModalJoin .joinBtn').on('click', function(e){
	e.preventDefault();
	//alert("click");
	var meetId = $('.joinBtn').data('meet-id'); 
	var joinName = $('#joinName').val().trim(); 
	
	//let favoriteId = $('#moreModal').data('favorite-id'); 
	//alert(postId);
	
	// 삭제 AJAX DELETE
	
	$.ajax({
		type:"POST"
		,url:"/meet/detail_join"
		,data:{
			"meetId": meetId,
			"joinName": joinName			
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