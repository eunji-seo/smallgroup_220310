<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="favorite">

	<div class="bg-white d-flex align-items-center p-3">
		<a href="/main/mypage_view"><img src="/static/image/arrow.png" width="50"></a>
		<div class="d-flex justify-content-center">
			<h3 class="favorite-subject">관심사 선택 수정</h3>
		</div>
	</div>
	<div class="text-danger m-5">* 최대 6개만 선택가능합니다.</div>
	<div class="">
		<div class="check-box d-flex flex-wrap ">
			<c:forEach var="favorite" items="${favoriteList}">
				<div class="form-check">
					<input type="checkbox" name="checkList" class="form-check-input"value="${favorite.id}" data-favorite-id="${favorite.id}" id="favor${favorite.id}">
					<label for="favor${favorite.id}" class="form-check-label">${favorite.favoriteName}</label>
				</div>
			</c:forEach>
		</div>
		<div class="d-flex justify-content-end">
			<button type="button" class="favoriteBtn btn btn-success col-2 mr-5">수정</button>
		</div>
	</div>	
</div>    
<script>
$(document).ready(function(){
	<c:forEach var="uf" items="${userFavorites}">
	$('input[value=${uf.id}]').prop('checked',true);
	</c:forEach>
	
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
		
		
		let favoriteIds = [];
		
		$('input:checkbox[name=checkList]:checked').each(function(){
			favoriteIds.push($(this).data('favorite-id'));
		
		}); 
		
		console.log(favoriteIds);
	
		$.ajax({
			Type:"GET"
			,url:"/user/user_favorite"
			,traditional : true
			,data:{
				"favoriteIds":favoriteIds
			}
			,success: function(data){
				console.log(data);
				if(data.result == 'success'){
					alert("관심사 선택이 완료 되었습니다.");
					location.href="/main/mypage_view";
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