<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="meet-create">
	<div class="bg-white d-flex align-items-center p-3">
		<a href="/user/join_view"><img src="/static/image/arrow.png" width="50"></a>
		<div class="d-flex justify-content-center">
			<h3 class="favorite-subject">모임 등록</h3>
		</div>
	</div>
	<div class="meet-content">
		<div class="location d-flex justify-content-around mb-3 ">
			<div class="d-flex mb-3 ">
					<div class="">
						<img alt="" src="/static/image/location.png" width="30" height="30">
						<span>지역</span>
					</div>
					<input type="text" name="meetAddress" id="meetAddress" class="form-control col-10" placeholder="행정구(ex 강북구)">
				</div>
			<div>
				<div class="d-flex justify-content-around mb-3 ">
					<div>
					<img alt="" src="/static/image/parson.png" width="30">
					<span>이름</span>
					</div>
					<input type="text" name="joinName" id="joinName" class="form-control col-10" placeholder="방장 이름">
				</div>
			</div>
		</div>
		<div class="meet-name  d-flex justify-content-around mb-3">
			<div class="check-box d-flex flex-wrap ">
			<select id="favorite" class="form-control">
					<option value="${favorite.id}">-관심사 선택-</option>
				<c:forEach var="favorite" items="${userFavorites}">
					<option value="${favorite.id}">${favorite.favoriteName}</option>
				</c:forEach>
			</select>
			</div>
			<input type="text" name="meetName" id="meetName" class="form-control col-8" placeholder="모임 이름">
		</div>
		<div class="meetDesc write-box border rounded m-3 bg-white">
			<textarea rows="" cols="" id="desc" name="desc" placeholder="모임 목표를 설명해주세요." class="border-0 w-100 "></textarea>
			<div class="cleateDsec d-flex justify-content-between">
					<div class="file-upload d-flex bg-white">
				       <input type="file" id="file" class="d-none" accept=".gif, .jpg, .png, .jpeg">
							<a href="#" id="fileUploadBtn"><img width="35" src="/static/image/camera.png"></a>
							<div id="fileName" class="ml-2">
							</div>
					</div>				
			</div>	
		</div>
		<div class="parsonNumber d-flex justify-content-between m-3">
			<div>
				<img alt="" src="/static/image/person.png" width="30">
				<span>정원(1~10)</span>
			</div>
			<input type="text" name="personnel" id="personnel" class="form-control col-4" placeholder="인원수">	
		</div>
		<button type="button" class="createBtn btn btn-primary w-100">모임 만들기</button>
	</div>
</div>
<script>
$(document).ready(function(){
	$('#fileUploadBtn').on('click', function(e) {
		e.preventDefault(); // 기본 작동 중지
		$('#file').click(); // input file을 클릭한 것과 같은 동작
	});
	$('#file').on('change', function(e) {
		var name = e.target.files[0].name;
		
		// 확장자 유효성 확인
		var extension = name.split('.');
		if (extension.length < 2 || 
		 	(extension[extension.length - 1] != 'gif' 
		 	&& extension[extension.length - 1] != 'png' 
		 	&& extension[extension.length - 1] != 'jpg'
		 	&& extension[extension.length - 1] != 'jpeg')) {
		 	
		 	alert("이미지 파일만 업로드 할 수 있습니다.");
		 	$(this).val(""); // 이미 올라간 것을 확인한 것이기 때문에 비워주어야 한다.
		 	return;
		 }
		 
		 $("#fileName").text(name);
	});
	$('.createBtn').on('click',function(){
	
		let meetAddress =  $('#meetAddress').val().trim();
		let meetName = $('#meetName').val().trim(); 
		let desc = $('#desc').val().trim();
		let personnel = $('#personnel').val().trim();
		let favorite = $('#favorite').val();
		
		let formData = new FormData();
		formData.append("meetAddress",meetAddress)
		formData.append("meetName",meetName)
		formData.append("desc",desc)
		formData.append("personnel",personnel)
		formData.append('meetFavoriteId', favorite);
		
		if( $('#file')[0].files[0]){
			formData.append("file",$('#file')[0].files[0])
         }
		$.ajax({
			type: "POST"
			, url: "/meet/create"
			, data: formData
			, enctype: "multipart/form-data" // 파일업로드를 위한 필수 설정
			, processData: false // 파일업로드를 위한 필수 설정
			, contentType: false // 파일업로드를 위한 필수 설정
			//---request
			, success: function(data){ //response
				if(data.result == 'success'){
					alert("모임을 등록하였습니다.");
					location.href="/main/main_view";
				}else{
					alert(data.errorMessage);
				}
				
			}
			, error: function(e) {
				alert("모임등록에 실패했습니다. 관리자에게 문의해주세요.");
			}
		});
	});
});

</script>