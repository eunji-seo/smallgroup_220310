<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="mt-3">
		<div class="mb-3">
			<div class="d-flex justify-content-between">
				<div><b>${loginId}</b></div>	
			</div>
		</div>
		<div class="mb-3">
			<input type="password" id="password" name="password" class="form-control" value="${user.password}" placeholder="*비밀번호">
			<input type="password" id="passwordConfim" name="passwordConfim" class="form-control" value="${user.password}" placeholder="*비밀번호 확인">
			<div id="isCheckPassword" class="small text-danger d-none">비밀번호를 입력 해주세요.</div>
			<div id="isCheckPasswordConfim" class="small text-danger d-none">비밀번호가 맞지 않습니다.</div>
		</div>
		<div class="mb-3">
			<input type="text" id="name" name="name" class="form-control" value="${user.name}" placeholder="*이름">
			<div id="isCheckName" class="small text-danger d-none">이름을 입력 해주세요.</div>
		</div>
		<div class="mb-3">
			<input type="text" id="birth" name="birth" class="form-control" value="${user.birth}" placeholder="*yyyymmdd">
			<div id="isCheckBirth" class="small text-danger d-none">생년월일을 입력 해주세요.</div>
			<div id="isCheckBirthText" class="small text-danger d-none">생년월일에는 숫자만 넣어주세요.</div>

		</div>
		<div class="mb-3">
			<input type="text" id="address" name="address" class="form-control" value="${user.address}" placeholder="*주소">
			<div id="isCheckAddress" class="small text-danger d-none">주소를 입력 해주세요.</div>

		</div>
		<div class="mb-3">
			<input type="text" id="email" name="email" class="form-control" value="${user.email}" placeholder="*이메일">
			<div id="isCheckEmail" class="small text-danger d-none">이메일을 입력 해주세요.</div>
		</div>
		<hr>
		<button onclick="memberJoin()" type="button" class="btn btn-primary col-12">회원수정</button>	
	</div>
</div>
<script>
function memberJoin(){
	//alert("click");

	let password = $('#password').val().trim();
	let passwordConfim = $('#passwordConfim').val().trim();
	let name = $('#name').val().trim();
	let birth = $('#birth').val().trim();
	let address = $('#address').val().trim();
	let email = $('#email').val().trim();
	
	$('#isCheckPassword').addClass('d-none');
	$('#isCheckPasswordConfim').addClass('d-none');
	$('#isCheckName').addClass('d-none');
	$('#isCheckBirth').addClass('d-none');
	$('#isCheckBirthText').addClass('d-none');
	$('#isCheckAddress').addClass('d-none');
	$('#isCheckEmail').addClass('d-none');
	$('#isCheck').addClass('d-none');

	
	if(password == ''|| passwordConfim == ''){
		$('#isCheckPassword').removeClass('d-none');
		return false;	
	}
	if(password != passwordConfim){
		$('#isCheckPasswordConfim').removeClass('d-none');
		return false;		
	}
	if(name == ''){
		$('#isCheckName').removeClass('d-none');
		return false;	
	}
	if(birth == ''){
		$('#isCheckBirth').removeClass('d-none');
		return false;	
	}

	if(address == ''){
		$('#isCheckAddress').removeClass('d-none');
		return false;		
	}
	if(email == ''){
		$('#isCheckEmail').removeClass('d-none');
		return false;		
	}
	
	if($('#isCheckOK').hasClass('d-none')){
		$('#isCheck').removeClass('d-none');
		return false;
	}
	$.ajax({
		type:"PUT"
		,url:"/user/member_update"
		,data: {
			"password":password
			,"name":name
			,"birth":birth
			,"address":address
			,"email":email
		}
		,success: function(data){
			if(data.result == 'success'){
				alert( "회원정보가 수정 되었습니다.");
				location.href="/main/mypage_view"
			}else{
				alert(data.errorMessage);
			}
		}
		,error: function(e){
			alert("회원가입이 실패하였습니다. 관리자에 문의해주세요.");
		}
	});
	
}

</script>	
    
