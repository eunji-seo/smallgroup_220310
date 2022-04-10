<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			    <a class="nav-link" href="${pageContext.request.contextPath}/chat/chat_view?meetId=${meet.id}">채팅</a>
			   </li>
	    </ul>
	</nav>
	<div class="d-flex justify-content-center mt-5">
		<div class="">
			<div class="d-flex justify-content-between">
				<div id="name" data-name="${name}">${name}</div>
				<!--  <input type="text" id="name" placeholder="대화명을 적어주세요" >-->
				<button onclick="startChat(this)" id="btn" class="btn btn">채팅시작</button>
			</div>
			<div id="chatDiv">
				<textarea id="chatContent" cols="50" rows="10" class="form-control bg-white" readonly></textarea><br>
				<div class="d-flex">
					<input type="text" id="chatMsg" class="form-control">
					<button onclick="sendMsg()" class="btn btn">전송</button>
				</div>
			</div>
		</div>
		<div class="bg-white w-25">
			<ul>
				<li>${meet.joinName}<b>방장</b></li>
				<c:forEach var="join" items="${joinList}">
					<li>${join.joinName}</li>
				</c:forEach>
			</ul>
		</div>	
	</div>
	<script>
		function sendMsg(){ // 7
			var msg = {
				cmd	: 'msg',
				msg : $('#chatMsg').val(),
				chatName : chatName,
				id : ${meet.id}
			}
			
			websocket.send(JSON.stringify(msg));
			document.getElementById("chatContent").scrollTop = document.getElementById("chatContent").scrollHeight;
		}
		var websocket;
		var chatName;
		function startChat(obj){
			if(obj.innerText === '종료'){
				var msg = {
					cmd	: 'close',
					chatName : chatName,
					id : ${meet.id}
				}
				websocket.send(JSON.stringify(msg));
			}else{
				chatName = $('#name').data('name');
				/* if(!chatName){
					alert('대화명은 필수 입니다');
					$('#name').focus();
					return;
				} */
				websocket = new WebSocket("ws://172.30.2.20//ws/chat"); //1번
				
				websocket.onmessage = function(evt){ //6 //9
					var chatMsg = JSON.parse(evt.data);
					console.log(chatMsg);
					
					
					if(chatMsg.cmd==='open'){
						$('#chatContent').append(chatMsg.chatName+'님이 입장하셨습니다.\r\n');
					}else if(chatMsg.cmd==='msg'){
						$('#chatContent').append('[' + chatMsg.chatName+'] : '+ chatMsg.msg + '\r\n'); 
					}else if(chatMsg.cmd==='close'){
						$('#chatContent').append(chatMsg.chatName+'님이 퇴장하셨습니다.\r\n');
						if(chatMsg.chatName===chatName){
							websocket.close();
							obj.innerText='채팅시작';
							$('#chatDiv').css('display','');
						}
					}
				};
				websocket.onopen = function(evt){ // 3번 
					console.log(evt);
					var msg = {
							cmd : 'open',
							chatName : chatName,
							id : ${meet.id}
					}
					websocket.send(JSON.stringify(msg)); // 4
					$('#name').attr('disabled',true);
					$('#chatDiv').css('display','');
					obj.innerText='종료';
				};
				websocket.onclose = function(evt){
					console.log(evt);
				};
			}
		}
		
	</script>