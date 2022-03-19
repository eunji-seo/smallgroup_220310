<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="mt-3 d-flex justify-content-between">
	<a href="/main/main_view" class="logo">	
		<h1>작은모임</h1>
	</a>
	<div>
		<c:if test="${not empty loginId}">
				<a href="/main/mypage_view" class="ml-2 font-weight-bold">MYPAGE</a> 
				<a href="/user/log_out" class="ml-2 font-weight-bold">로그아웃</a> 
		</c:if>
	</div>
</div>