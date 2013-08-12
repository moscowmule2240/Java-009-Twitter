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
<title>タイムラインを見よう！</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
<!--
$(document).ready(function () {
	$("#tweetForm").submit(function(){
		$.ajaxSetup({scriptCharset:'utf-8'});
		$.post("tweet.do", { tweet: $("#tweetText").val() }, function(data){
			alert("正常に送信されました。");
		});
		return false;
	});
});

function setTimer() {
	setInterval("loadTweets()", 5 * 1000);
}

function loadTweets() {
	$.ajaxSetup({scriptCharset:'utf-8'});
	$.getJSON("home.do", function(data){
		$("#tweetData").empty();
		for(var i in data){
			$("#tweetData").append(
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
		<div class="row">
			<div class="span4">
				<bean:define id="userId" name="registration.user.infomation.key" property="userId" scope="session" />
				<ul class="nav nav-tabs nav-stacked">
					<li><html:link action="/profile?method=tweet" paramId="userId" paramName="userId">プロフィール</html:link></li>
					<li><html:link action="/profile?method=tweet" paramId="userId" paramName="userId">つぶやき</html:link></li>
					<li><html:link action="/profile?method=follow" paramId="userId" paramName="userId">フォロー</html:link></li>
					<li><html:link action="/profile?method=follower" paramId="userId" paramName="userId">フォロワー</html:link></li>
					<li><html:link action="/profile?method=favorite" paramId="userId" paramName="userId">お気に入り</html:link></li>
				</ul>
				<form id="tweetForm" method="post" action="">
					<textarea id="tweetText" rows="5" class="span4"></textarea><br>
					<html:submit value="つぶやく" styleClass="btn" />
				</form>
			</div>
			<div class="span8">
				<table width="100%" class="table">
				<tbody id="tweetData"><tr><td>Now Loading...</td></tr></tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html:html>
