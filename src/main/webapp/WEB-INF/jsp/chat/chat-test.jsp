<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="name" placeholder="대화명을 적어주세요">
	<button onclick="startChat(this)" id="btn">채팅시작</button>
	<div id="chatDiv" style="display:none">
		<textarea id="chatContent" cols="50" rows="10"></textarea><br>
		<input type="text" id="chatMsg"><button onclick="sendMsg()">전송</button>
	</div>
	<script>
		function sendMsg(){
			var msg = {
				cmd	: 'msg',
				msg : $('#chatMsg').val(),
				chatName : chatName
			}
			
			websocket.send(JSON.stringify(msg));
		}
		var websocket;
		var chatName;
		function startChat(obj){
			if(obj.innerText === '종료'){
				websocket.close();
				$('#name').attr('disabled',false);
				obj.innerText='채팅시작';
				$('#chatDiv').css('display','none');
			}else{
				chatName = $('#name').val();
				if(!chatName){
					alert('대화명은 필수 입니다');
					$('#name').focus();
					return;
				}
				websocket = new WebSocket("ws://172.30.2.20/ws/chat"); //1번
				
				websocket.onmessage = function(evt){
					var chatMsg = JSON.parse(evt.data);
					console.log(chatMsg);
					if(chatMsg.cmd==='open'){
						$('#chatContent').append(chatMsg.chatName+'님이 입장하셨습니다.\r\n');
					}else if(chatMsg.cmd==='msg'){
						$('#chatContent').append('[' + chatMsg.chatName+'] : '+ chatMsg.msg + '.\r\n');
					}
				};
				websocket.onopen = function(evt){
					console.log(evt);
					var msg = {
							cmd : 'open',
							chatName : chatName
					}
					websocket.send(JSON.stringify(msg));
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
</body>
</html>