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
<title>プロフィールを閲覧しよう！</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="padding-top:60px;">
	<jsp:include page="/pages/header.jsp" flush="true" />
	<div class="container">
		<logic:messagesPresent property="message">
			<font color="red"><html:errors property="message" header="false" footer="false" prefix="false" suffix="false" /></font>
		</logic:messagesPresent>
		<logic:notEmpty name="user">
			<div class="row span12" style="padding-top:10px;">
				<font size="+2"><html:link action="/profile?method=tweet" paramId="userId" paramName="user" paramProperty="userId"><bean:write name="user" property="displayName" /></html:link></font>
			</div>
			<div class="row span12" style="padding-top:10px;">
				<p><bean:write name="user" property="introduction" /></p>
			</div>
		</logic:notEmpty>
		<div class="row">
			<div class="span4">
				<ul class="nav nav-tabs nav-stacked">
					<li class='<logic:equal parameter="method" value="tweet">active</logic:equal>'><html:link action="/profile?method=tweet" paramId="userId" paramName="user" paramProperty="userId">つぶやき</html:link></li>
					<li class='<logic:equal parameter="method" value="follow">active</logic:equal>'><html:link action="/profile?method=follow" paramId="userId" paramName="user" paramProperty="userId">フォロー</html:link></li>
					<li class='<logic:equal parameter="method" value="follower">active</logic:equal>'><html:link action="/profile?method=follower" paramId="userId" paramName="user" paramProperty="userId">フォロワー</html:link></li>
					<li class='<logic:equal parameter="method" value="favorite">active</logic:equal>'><html:link action="/profile?method=favorite" paramId="userId" paramName="user" paramProperty="userId">お気に入り</html:link></li>
				</ul>
			</div>
			<div class="span8">
				<table width="100%" class="table">
				<tbody>
				<logic:notEmpty name="tweetList">
				<logic:iterate id="row" name="tweetList">
				<tr>
				<td>
				<div>
					<div>
						<ul class="nav nav-pills">
							<li><html:link action="/profile?method=tweet" paramId="userId" paramName="row" paramProperty="userId"><bean:write name="row" property="displayName" /></html:link></li>
							<li><html:link action="">お気に入り</html:link></li>
						</ul>
					</div>
					<p><bean:write name="row" property="tweet" /></p>
					<p>日時：<bean:write name="row" property="tweetTime" /><p>
				</div>
				</td>
				</tr>
				</logic:iterate>
				</logic:notEmpty>
				<logic:notEmpty name="usersList">
				<logic:iterate id="row" name="usersList">
				<tr>
				<td>
				<div>
					<div>
						<ul class="nav nav-pills">
							<li><html:link action="/profile?method=tweet" paramId="userId" paramName="row" paramProperty="userId"><bean:write name="row" property="displayName" /></html:link></li>
							<li><html:link action=""><bean:write name="row" property="follow" /></html:link></li>
						</ul>
					</div>
					<p><bean:write name="row" property="introduction" /></p>
				</div>
				</td>
				</tr>
				</logic:iterate>
				</logic:notEmpty>
				</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html:html>
