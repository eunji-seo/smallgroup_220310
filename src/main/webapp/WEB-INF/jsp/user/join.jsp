<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="mt-3">
		<div class="mb-3">
			<div class="d-flex justify-content-between">
				<input type="text" id="loginId" name="loginId" class="form-control mr-2" placeholder="*아이디">
				<button onclick="memberCheck()" type="button" class="checkBtn btn btn-success">중복확인</button>
			</div>
			<div id="isCheckId" class="small text-danger d-none">아이디를 입력 해주세요.</div>
			<div id="isCheckLength" class="small text-danger d-none">4자 이상 입력해주세요.</div>
			<div id="isCheckDuplicated" class="small text-danger d-none">중복된 아이디 입니다.</div>
			<div id="isCheckOK" class="small text-success d-none">사용 가능한 아이디 입니다.</div>
			<div id="isCheck" class="small text-danger d-none">중복체크를 해주세요.</div>
		</div>
		<div class="mb-3">
			<input type="password" id="password" name="password" class="form-control" placeholder="*비밀번호">
			<input type="password" id="passwordConfim" name="passwordConfim" class="form-control" placeholder="*비밀번호 확인">
			<div id="isCheckPassword" class="small text-danger d-none">비밀번호를 입력 해주세요.</div>
			<div id="isCheckPasswordConfim" class="small text-danger d-none">비밀번호가 맞지 않습니다.</div>
		</div>
		<div class="mb-3">
			<input type="text" id="name" name="name" class="form-control" placeholder="*이름">
			<div id="isCheckName" class="small text-danger d-none">이름을 입력 해주세요.</div>
		</div>
		<div class="mb-3">
			<input type="text" id="birth" name="birth" class="form-control" placeholder="*yyyymmdd">
			<div id="isCheckBirth" class="small text-danger d-none">생년월일을 입력 해주세요.</div>
			<div id="isCheckBirthText" class="small text-danger d-none">생년월일에는 숫자만 넣어주세요.</div>

		</div>
		<div class="mb-3">
			<div class="d-flex">
			<input type="text" id="postcode" class="form-control" placeholder="우편번호">
			<input type="button" onclick="execDaumPostcode()" class="btn btn-none" value="우편번호 찾기">
			</div>
			<div class="d-flex">
			<input type="text" id="address" class="form-control" placeholder="주소">
			<input type="text" id="extraAddress"  class="form-control" placeholder="참고항목">
			</div>
			<div id="isCheckAddress" class="small text-danger d-none">주소를 입력 해주세요.</div>
			<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
			<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
			</div>
		</div>
		<div class="mb-3">
			<input type="text" id="email" name="email" class="form-control" placeholder="*이메일">
			<div id="isCheckEmail" class="small text-danger d-none">이메일을 입력 해주세요.</div>
		</div>
		<hr>
		<button onclick="memberJoin()" type="button" class="btn btn-primary col-12">회원가입</button>	
	</div>
</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
// 우편번호 찾기 화면을 넣을 element
var element_layer = document.getElementById('layer');

function closeDaumPostcode() {
    // iframe을 넣은 element를 안보이게 한다.
    element_layer.style.display = 'none';
}

function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
           /*  document.getElementById("detailAddress").focus(); */

            // iframe을 넣은 element를 안보이게 한다.
            // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
            element_layer.style.display = 'none';
        },
        width : '100%',
        height : '100%',
        maxSuggestItems : 5
    }).embed(element_layer);

    // iframe을 넣은 element를 보이게 한다.
    element_layer.style.display = 'block';

    // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
    initLayerPosition();
}

// 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
// resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
// 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
function initLayerPosition(){
    var width = 300; //우편번호서비스가 들어갈 element의 width
    var height = 400; //우편번호서비스가 들어갈 element의 height
    var borderWidth = 5; //샘플에서 사용하는 border의 두께

    // 위에서 선언한 값들을 실제 element에 넣는다.
    element_layer.style.width = width + 'px';
    element_layer.style.height = height + 'px';
    element_layer.style.border = borderWidth + 'px solid';
    // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
    element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';
    element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
}
function memberCheck(){
	//alert("click");

	let loginId = $('#loginId').val().trim();
	$('#isCheckId').addClass('d-none');
	$('#isCheckId').addClass('d-none');
	$('#isCheckLength').addClass('d-none');
	$('#isCheckDuplicated').addClass('d-none');
	$('#isCheckOK').addClass('d-none');

	$('#loginId').removeClass('is-invalid');
	
	if(loginId.length < 4){
		$('#isCheckLength').removeClass('d-none');
		$('#loginId').addClass('is-invalid');
		$('#isCheckId').addClass('d-none');
		return;
	}
	
	$.ajax({
		url:"/user/is_duplicated_id"
		,data:{ "loginId":loginId }
		,success: function(data){
			if(data.result){
				$('#isCheckDuplicated').removeClass('d-none');	
				$('#loginId').addClass('is-invalid');
				$('#isCheckId').addClass('d-none');
			}else if(data.result == false){
				$('#isCheckOK').removeClass('d-none');	
				$('#loginId').addClass('is-invalid');
				$('#isCheckId').addClass('d-none');
			}
		}
		,error: function(e){
			alert("중복확인이 실패하였습니다. 관리자에 문의 부탁드립니다.");
		}
	});
	
}

function memberJoin(){
	//alert("click");

	let loginId = $('#loginId').val().trim();
	let password = $('#password').val().trim();
	let passwordConfim = $('#passwordConfim').val().trim();
	let name = $('#name').val().trim();
	let birth = $('#birth').val().trim();
	let address = $('#address').val().trim();
	let email = $('#email').val().trim();
	
	$('#isCheckId').addClass('d-none');
	$('#isCheckPassword').addClass('d-none');
	$('#isCheckPasswordConfim').addClass('d-none');
	$('#isCheckName').addClass('d-none');
	$('#isCheckBirth').addClass('d-none');
	$('#isCheckBirthText').addClass('d-none');
	$('#isCheckAddress').addClass('d-none');
	$('#isCheckEmail').addClass('d-none');
	$('#isCheck').addClass('d-none');
	
	$('#loginId').removeClass('is-invalid');
	$('#password').removeClass('is-invalid');
	$('#passwordConfim').removeClass('is-invalid');
	$('#name').removeClass('is-invalid');
	$('#birth').removeClass('is-invalid');
	$('#address').removeClass('is-invalid');
	$('#email').removeClass('is-invalid');

	
	if(loginId == ''){
		$('#isCheckId').removeClass('d-none');
		$('#loginId').addClass('is-invalid');

		return false;	
	}
	if(password == ''|| passwordConfim == ''){
		$('#isCheckPassword').removeClass('d-none');
		$('#password').addClass('is-invalid');
		$('#passwordConfim').addClass('is-invalid');
		return false;	
	}
	if(password != passwordConfim){
		$('#isCheckPasswordConfim').removeClass('d-none');
		$('#password').addClass('is-invalid');
		$('#passwordConfim').addClass('is-invalid');
		return false;		
	}
	if(name == ''){
		$('#isCheckName').removeClass('d-none');
		$('#name').addClass('is-invalid');
		return false;	
	}
	if(birth == ''){
		$('#isCheckBirth').removeClass('d-none');
		$('#birth').addClass('is-invalid');
		return false;	
	}

	if(address == ''){
		$('#isCheckAddress').removeClass('d-none');
		$('#address').addClass('is-invalid');
		return false;		
	}
	if(email == ''){
		$('#isCheckEmail').removeClass('d-none');
		$('#email').addClass('is-invalid');
		return false;		
	}
	
	if($('#isCheckOK').hasClass('d-none')){
		$('#isCheck').removeClass('d-none');
		$('#loginId').addClass('is-invalid');
		$('#isCheckId').addClass('d-none');
		return false;
	}
	$.ajax({
		type:"POST"
		,url:"/user/join"
		,data: {
			"loginId":loginId
			,"password":password
			,"name":name
			,"birth":birth
			,"address":address
			,"email":email
		}
		,success: function(data){
			if(data.result == 'success'){
				alert( loginId + "님 회원가입 되었습니다.");
				location.href="/user/favorite_view"
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
    
