<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="login d-flex justify-content-center">
		<div>
			<div class="">
				<input type="text" id="loginId" name="loginId" class="form-control" placeholder="아이디">
				<input type="password" id="password" name="password" class="form-control" placeholder="비밀번호">
				<div id="isloginId" class="small text-danger d-none">아이디를 입력해주세요.</div>
				<div id="isPassword" class="small text-danger d-none">비밀번호를 입력해주세요.</div>
			</div>
			<hr>
			<button onclick="memberLogin()" type="button" class="btn btn-primary col-12 mb-3">로그인</button>
			<a href="/user/join_view" class="btn btn-light col-12">회원가입</a>
		</div>
	</div>
<script>

	function memberLogin(){
		//alert("click");
		let loginId = $('#loginId').val().trim();
		let password = $('#password').val().trim();
		
		$('#isloginId').addClass('d-none');
		$('#isPassword').addClass('d-none');
		
		if(loginId == ''){
			$('#isloginId').removeClass('d-none');
			return false;
		}
		if(password == ''){
			$('#isPassword').removeClass('d-none');
			return false;
		}
		
		$.ajax({
			type:"POST"
			,url:"/user/login"
			,data:{
				"loginId":loginId
				,"password":password
			}
			,success: function(data){
				if(data.result == 'success'){
					alert(loginId+"님 반갑습니다.");
					location.href="/main/main_view";
				}else{
					alert(data.errorMessage);
				}
			}
			,error: function(e){
				alert("로그인에 실패하였습니다. 관리자에 문의해주세요.")
			}
		});
	}
</script>