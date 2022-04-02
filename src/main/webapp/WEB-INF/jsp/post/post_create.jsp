<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="meet-create">
	<div class="bg-white d-flex align-items-center p-3">
		<a href="/user/join_view"><img src="/static/image/arrow.png" width="50"></a>
		<div class="d-flex justify-content-center">
			<h3 class="favorite-subject">게시글</h3>
		</div>
	</div>
	<div class="meet-content">
		<div class="location d-flex justify-content-around mb-3 ">
			<input type="text" name="subject" id="subject" class="form-control col-11" placeholder="제목을 입력해주세요.">
		</div>
		<div class="meetDesc write-box border rounded m-3 bg-white">
			<textarea rows="" cols="" id="contentText" name="contentText" placeholder="내용을 입력해주세요" class="border-0 w-100 "></textarea>
			<div class="cleateContentText d-flex justify-content-between">
					<div class="file-upload d-flex bg-white">
				       <input type="file" id="file" class="d-none" accept=".gif, .jpg, .png, .jpeg">
							<a href="#" id="fileUploadBtn"><img width="35" src="/static/image/camera.png"></a>
							<div id="fileName" class="ml-2">
							</div>
					</div>				
			</div>	
		</div>
		<button type="button" class="createBtn btn btn-primary w-100"">게시글 등록${meet.id}</button>
			
	</div>
</div>
<script>
$(document).ready(function(){
	<
	
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
	
		let subject =  $('#subject').val().trim();
		let contentText = $('#contentText').val().trim();
		let meetId = $('.createBtn').data('meet-id');
		
		let formData = new FormData();
		formData.append("subject",subject)
		formData.append("contentText",contentText)
		formData.append("meetId",meetId)
		
		if( $('#file')[0].files[0]){
			formData.append("file",$('#file')[0].files[0])
         }
		$.ajax({
			type: "POST"
			, url: "/meet/post_create"
			, data: formData
			, enctype: "multipart/form-data" // 파일업로드를 위한 필수 설정
			, processData: false // 파일업로드를 위한 필수 설정
			, contentType: false // 파일업로드를 위한 필수 설정
			//---request
			, success: function(data){ //response
				if(data.result == 'success'){
					alert("게시글이 등록 되었습니다.");
					location.href="/main/main_view";
				}else{
					alert(data.errorMessage);
				}
				
			}
			, error: function(e) {
				alert("게시글 업로드에 실패했습니다. 관리자에게 문의해주세요.");
			}
		});
	});
});

</script>