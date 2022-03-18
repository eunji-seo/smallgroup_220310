<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<c:forEach var="favorite" items="${favoriteList}">
				<div class="form-check">
					<input type="checkbox" name="checkList" class="form-check-input"value="${favorite.favoriteName}" data-favorite-id="${favorite.id}">
					<label for="trip" class="form-check-label">${favorite.favoriteName}</label>
				</div>
			</c:forEach>
		</div>
		<div class="d-flex justify-content-end">
			<button type="button" class="favoriteBtn btn btn-success col-2 mr-5">선택</button>
		</div>
	</div>	
</div>    
<script>
$(document).ready(function(){
	
	$('.favoriteBtn').on('click',function(){
		alert("click");
		if($('input:checkbox[name=checkList]:checked').length > 6){
			alert("6개까지만 선택 가능합니다.");
			return;
		}
		if($('input:checkbox[name=checkList]:checked').length < 1){
			alert("1개 이상 선택해야 합니다.");
			return;
		}
		
		
		let favoriteId = [];
		
		$('input:checkbox[name=checkList]:checked').each(function(){
			favoriteId.push($(this).data('favorite-id'));
		
		}); 
		
		console.log(favoriteId);
	
		$.ajax({
			Type:"GET"
			,url:"/user/is_user_favorite"
			,data:{
				"favoriteId":favoriteId
			}
			,success: function(data){
				if(data.result == 'success'){
					alert("관심사 선택이 완료 되었습니다.");
					location.href="/meet/main_view";
				}else{
					alert(data.errorMessage);		
				}
			}
			,error: function(e){
				alert("관심사 선택에 실패하였습니다. 관리자에 문의해주세요.");
			}
		});
	
	});	
	
	
});

</script>