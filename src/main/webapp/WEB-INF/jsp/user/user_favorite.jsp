<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="favorite">

	<div class="bg-white d-flex align-items-center p-3">
		<a href="/user/join_view"><img src="/static/image/arrow.png" width="50"></a>
		<div class="d-flex justify-content-center">
			<h3 class="favorite-subject">관심사 선택</h3>
		</div>
	</div>
	<div class="text-danger m-5">* 최대 6개만 선택가능합니다.</div>
	<div class="">
		<div class="check-box d-flex flex-wrap ">
			<div class="form-check">
				<input type="checkbox" id="trip" name="checkList" class="form-check-input" value="아웃도어/여행">
				<label for="trip" class="form-check-label">아웃도어/여행</label>
			</div>
			<div class="form-check">
				<input type="checkbox" id="language" name=checkList" class="form-check-input" value="외국/언어">
				<label for="language" class="form-check-label">외국/언어</label>
			</div>
			<div class="form-check">
				<input type="checkbox" id="dance" name="checkList" class="form-check-input" value="댄스/무용">
				<label for="dance" class="form-check-label">댄스/무용</label>
			</div>
			<div class="form-check">
				<input type="checkbox" id="book" name="checkList" class="form-check-input" value="인문학/책/글">
				<label for="book" class="form-check-label">인문학/책/글</label>
			</div>
			<div class="form-check">
				<input type="checkbox" id="pet" name="checkList" class="form-check-input" value="반려동물">
				<label for="pet" class="form-check-label">반려동물</label>
			</div>
			<div class="form-check">
				<input type="checkbox" id="crafts" name="checkList" class="form-check-input" value="공예/만들기">
				<label for="crafts" class="form-check-label">공예/만들기</label>
			</div>
			<div class="form-check">
				<input type="checkbox" id="sports" name="checkList" class="form-check-input" value="운동/스포츠">
				<label for="sports" class="form-check-label">운동/스포츠</label>
			</div>
			<div class="form-check">
				<input type="checkbox" id="show" name="checkList" class="form-check-input" value="문화/공연/축제">
				<label for="show" class="form-check-label">문화/공연/축제</label>
			</div>
			<div class="form-check">
				<input type="checkbox" id="music" name="checkList" class="form-check-input" value="음악/악기">
				<label for="music" class="form-check-label">음악/악기</label>
			</div>
			<div class="form-check">
				<input type="checkbox" id="game" name="checkList" class="form-check-input" value="게임/오락">
				<label for="game" class="form-check-label">게임/오락</label>
			</div>
			<div class="form-check">
				<input type="checkbox" id="volunteer" name="checkList" class="form-check-input" value="봉사활동">
				<label for="Volunteer" class="form-check-label">봉사활동</label>
			</div>
			<div class="form-check">
				<input type="checkbox" id="dish" name="checkList" class="form-check-input" value="요리/제조">
				<label for="Dish" class="form-check-label">요리/제조</label>
			</div>
			<div class="form-check">
				<input type="checkbox" id="car" name="checkList" class="form-check-input" value="차/오토바이">
				<label for="car" class="form-check-label">차/오토바이</label>
			</div>
			<div class="form-check">
				<input type="checkbox" id="Photo" name="checkList" class="form-check-input" value="사진/영상">
				<label for="Photo" class="form-check-label">사진/영상</label>
			</div>	
			
		</div>
		<div class="d-flex justify-content-end">
			<button type="button" class="favoriteBtn btn btn-success col-2 mr-5">선택</button>
		</div>
	</div>	
</div>    
<script>
$(document).ready(function(){
	
$('.favoriteBtn').on('click',function(){
	//alert("click");
	if($('input:checkbox[name=checkList]:checked').length > 6){
		alert("6개까지만 선택 가능합니다.");
		return;
	}
	if($('input:checkbox[name=checkList]:checked').length < 1){
		alert("1개 이상 선택해야 합니다.");
		return;
	}
	
	
	let trip = $('input:checkbox[id="trip"]').val();
	let language = $('input:checkbox[id="trip"]').val();
	let dance = $('input:checkbox[id="dance"]').val();
	let book = $('input:checkbox[id="book"]').val();
	let pet = $('input:checkbox[id="pet"]').val();
	let crafts = $('input:checkbox[id="crafts"]').val();
	let sports = $('input:checkbox[id="sports"]').val();
	let show = $('input:checkbox[id="show"]').val();
	let music = $('input:checkbox[id="music"]').val();
	let game = $('input:checkbox[id="game"]').val();
	let volunteer = $('input:checkbox[id="volunteer"]').val();
	let dish = $('input:checkbox[id="dish"]').val();
	let car = $('input:checkbox[id="car"]').val();
	let Photo = $('input:checkbox[id="Photo"]').val();
	
	$.ajax({
		type:"POST"
		,url:
	});

	//console.log(trip);
	
	
});	
	
	
});

</script>