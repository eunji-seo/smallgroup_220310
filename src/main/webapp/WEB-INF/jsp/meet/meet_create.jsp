<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="meet-create">
	<div class="bg-white d-flex align-items-center p-3">
		<a href="/user/join_view"><img src="/static/image/arrow.png" width="50"></a>
		<div class="d-flex justify-content-center">
			<h3 class="favorite-subject">모임 등록</h3>
		</div>
	</div>
	<div class="location">
		<img alt="" src="/static/image/location.png" width="30">
		<span>지역</span>
		<input type="text" name="location" id="location" placeholder="주소">
	</div>
	<div class="meet-name">
		<div></div>
		<input type="text" name="meetName" id="meetName" placeholder="모임 이름">
	</div>
	<div class="meetDesc write-box border rounded m-3">
		<textarea rows="" cols="" placeholder="모임 목표를 설명해주세요." class="border-0 w-100"></textarea>
		<div class="cleateTimelineUpload d-flex justify-content-between">
				<div class="file-upload d-flex">
			       <input type="file" id="file" class="d-none" accept=".gif, .jpg, .png, .jpeg">
						<a href="#" id="fileUploadBtn"><img width="35" src="/static/image/camera.png"></a>
						<div id="fileName" class="ml-2">
						</div>
				</div>				
		</div>	
	</div>
	<div class="">
	</div>
	<div class="">
	</div>
</div>