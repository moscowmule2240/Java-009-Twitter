<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
<title>秘密メッセージを見よう！</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
<!--
$(document).ready(function () {
	$("#sendMessageForm").submit(function(){
		$.ajaxSetup({scriptCharset:'utf-8'});
		$.post("sendMessage.do",
			{ message: $("#formMassgeText").val(), reciveUserId: $("#formReciveUserId").val() },
			function(data){
			loadMessages();
		});
		return false;
	});
});

function setTimer() {
	setInterval("loadMessages()", 5 * 1000);
}

function loadMessages() {
	$.ajaxSetup({scriptCharset:'utf-8'});
	$.getJSON("reciveMessage.do", { reciveUserId: $("#formReciveUserId").val() }, function(data){
		$("#messageData").empty();
		for(var i in data){
			$("#messageData").append(
			"<tr><td><div><div><ul class='nav nav-pills'>" +
			"<li><a href='profile.do?method=tweet&userId=" + data[i].userId + "'>" + data[i].displayName + "</a></li>" +
			"<li><a href='profile.do?method=tweet&userId=" + data[i].userId + "'>" + "お気に入り登録" + "</a></li>" +
			"</ul></div>" + "<p>" + data[i].tweet + "</p>" +
			"<p>日時：" + new Date(data[i].tweetTime)+ "<p>" +
			"</div></td></tr>");
		}
	});
}
// -->
</script>
</head>
<body style="padding-top:60px;" onload="loadTweets();setTimer();">
	<jsp:include page="/pages/header.jsp" flush="true" />
	<div class="container">
		<logic:messagesPresent property="message">
			<font color="red"><html:errors property="message" header="false" footer="false" prefix="false" suffix="false" /></font>
		</logic:messagesPresent>
		<h2>秘密メッセージ</h2>
		宛先：<bean:write name="reciveUser" property="displayName"/>
		<div class="row">
				<form id="sendMessageForm" method="post" action="">
					<textarea id="formMassgeText" rows="5" class="span10"></textarea><br>
					<input type="hidden" id="formReciveUserId" value="${param.userId}">
					<html:submit value="送信" styleClass="btn" />
				</form>
		</div>
		<div class="row">
			<table width="100%" class="table">
			<tbody id="messageData"><tr><td>Now Loading...</td></tr></tbody>
			</table>
		</div>
	</div>
</body>
</html:html>
