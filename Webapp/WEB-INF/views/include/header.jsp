<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<a href = "/Mysite-spring/index" style = "text-decoration: none"><h1>MySite</h1></a>
	<ul>
		<c:choose>
			<c:when test="${empty authMember  }">
				<li><a href="/Mysite-spring/member/login">로그인</a></li>
				<li><a href="/Mysite-spring/member/join">회원가입</a></li>
			</c:when>	
			<c:otherwise>
				<li><a href="/Mysite-spring/member/edit">회원정보수정</a><li>
				<li><a href="/Mysite-spring/member/logout">로그아웃</a><li>
				<li>${authMember.name }님 안녕하세요 ^^;</li>
			</c:otherwise>
		</c:choose>
	</ul>