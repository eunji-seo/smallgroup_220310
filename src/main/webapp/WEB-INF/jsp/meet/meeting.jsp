<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="meetion-create">
	<div class="bg-white d-flex align-items-center p-3">
			<a href="/user/join_view"><img src="/static/image/arrow.png" width="50"></a>
			<div class="d-flex justify-content-center">
				<h3 class="favorite-subject" data-meet-id="${meet.id}">정모 개설</h3>
			</div>
	</div>    
	<div class="meeting-list mt-5">
		<div class="mb-3">
			<input type="text" id="meetingName" name="meetingName" class="form-control" placeholder="정모 이름">
			<div id="isCheckmeetingName" class="small text-danger d-none">정모이름을 입력 해주세요.</div>
		</div>	
		<div class="mb-3">
			<div class="d-flex">	
				<img alt="" src="/static/image/calendar.png" class="mr-2" width="35">	
				<input type="text" id="meetingDay" name="meetingDay" class="form-control col-8 " placeholder="날짜">
			</div>
			<div id="isCheckmeetingDay" class="small text-danger d-none">모임 날짜를 입력 해주세요.</div>
		</div>
		<div class="d-flex mb-3">
			<img alt="" src="/static/image/location.png" class="mr-2" width="35">	
			<input type="text" id="Place" name="Place" class="form-control" placeholder="장소 주소">
		</div>
			<div id="isCheckPlace" class="small text-danger d-none">장소를 입력 해주세요.</div>
		<div class="d-flex mb-3">
			<img alt="" src="/static/image/won.png" class="mr-2" width="35">	
			<input type="text" id="Cost" name="Cost" class="form-control col-8" placeholder="회비">
		</div>
			<div id="isCheckCost" class="small text-danger d-none">비용을 입력 해주세요.</div>
		<div class="d-flex justify-content-between mb-3">
			<div>
				<img alt="" src="/static/image/person.png" class="mr-2" width="40">
				<span>정원(5~10)</span>
			</div>
			<input type="text" id="Personnel" name="Personnel" class="form-control col-3" placeholder="정원 10">
		</div>
			<div id="isCheckPersonnel" class="small text-danger d-none">인원을 입력 해주세요.</div>
		<div>
		 <button type="button" class="createBtn btn btn-primary w-100" >정모 만들기</button>
		</div>
	</div>
</div>
<script>
$(document).ready(function(){
	
	$("#meetingDay").datetimepicker({

        dateFormat:'yy-mm-dd',
        monthNamesShort:[ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월' ],
        dayNamesMin:[ '일', '월', '화', '수', '목', '금', '토' ],

        changeMonth:true,
        changeYear:true,

        showMonthAfterYear:true,
        minDate:0, // 오늘과 그 이후만 선택 가능
        // timepicker 설정

        timeFormat:'HH:mm:ss',
        controlType:'select',
        oneLine:true,

    });
	
	$('.createBtn').on('click',function(){
		var meetId = $('.favorite-subject').data('meet-id');
		var meetingName = $('#meetingName').val().trim();
		var meetingDay = $('#meetingDay').val().trim();
		var Place = $('#Place').val().trim();
		var Cost = $('#Cost').val().trim();
		var Personnel = $('#Personnel').val().trim();
		
		$('#isCheckmeetingName').addClass('d-none');
		$('#isCheckmeetingDay').addClass('d-none');
		$('#isCheckPlace').addClass('d-none');
		$('#isCheckCost').addClass('d-none');
		$('#isCheckPersonnel').addClass('d-none');
		
		if(meetingName == ''){
			$('#isCheckmeetingName').removeClass('d-none');
			$('#meetingName').addClass('is-invalid');
			return false;
		}
		if(meetingDay == ''){
			$('#isCheckmeetingDay').removeClass('d-none');
			$('#meetingDay').addClass('is-invalid');
			return false;
		}
		
		if(Place == ''){
			$('#isCheckPlace').removeClass('d-none');
			$('#Place').addClass('is-invalid');
			return false;
		}
		if(Cost == ''){
			$('#isCheckCost').removeClass('d-none');
			$('#Cost').addClass('is-invalid');
			return false;
		}
		if(Personnel == ''){
			$('#isCheckPersonnel').removeClass('d-none');
			$('#Personnel').addClass('is-invalid');
			return false;
		}
		
		if(Personnel.length < 0 || Personnel.length > 10 ){
			$('#isCheckPersonnelLength').removeClass('d-none');
			$('#Personnel').addClass('is-invalid');
			return false;
		}
		
		/* $.ajax({
			type:"POST"
			,url:"/meet/meeting"
			,data:{
				"meetId":meetId
				,"meetingName":meetingName
				,"meetingDay":meetingDay
				,"Place":Place
				,"Cost":Cost
				,"Personnel":Personnel
			}
			
		}); */
	});
	
	
	
});
</script>