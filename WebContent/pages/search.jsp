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
<title>検索をしよう！</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="padding-top:60px;">
	<jsp:include page="/pages/header.jsp" flush="true" />
	<div class="container">
		<div class="row">
			<div class="container">
				<logic:messagesPresent property="message">
					<font color="red"><html:errors property="message" header="false" footer="false" prefix="false" suffix="false" /></font>
				</logic:messagesPresent>
				<div class="row">
					<div class="span4">
						<h2>検索結果</h2>
					</div>
					<div class="span8">
						<html:form action="/search" styleClass="search-form">
							<html:text property="searchValue" styleClass="search-query" />
							<html:submit property="dispatch" styleClass="btn"><bean:message key="from.button.search.user"/></html:submit>
							<html:submit property="dispatch" styleClass="btn"><bean:message key="from.button.search.tweet"/></html:submit>
						</html:form>
						<logic:messagesPresent property="searchValue">
							<font color="red"><html:errors property="searchValue" header="false" footer="false" prefix="false" suffix="false" /></font>
						</logic:messagesPresent>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="container">
				<table width="100%" class="table">
				<tbody>
				<logic:notEmpty name="usersList">
				<logic:iterate id="user" name="usersList">
					<tr>
					<td>
					<div>
						<div>
							<ul class="nav nav-pills">
								<li><html:link action="/profile?method=tweet" paramId="userId" paramName="user" paramProperty="userId"><bean:write name="user" property="displayName" /></html:link></li>
								<li><html:link action="">フォロー</html:link></li>
							</ul>
						</div>
						<p><bean:write name="user" property="introduction" /></p>
					</div>
					</td>
					</tr>
				</logic:iterate>
				</logic:notEmpty>
				<logic:notEmpty name="timeLineList">
				<logic:iterate id="timeLine" name="timeLineList">
					<tr>
					<td>
					<div>
						<div>
							<ul class="nav nav-pills">
								<li><html:link action="/profile?method=tweet" paramId="userId" paramName="timeLine" paramProperty="userId"><bean:write name="timeLine" property="displayName" /></html:link></li>
								<li><html:link action="">お気に入り</html:link></li>
							</ul>
						</div>
						<p><bean:write name="timeLine" property="tweet" /></p>
						<p>日時：<bean:write name="timeLine" property="tweetTime" /><p>
					</div>
					</td>
					</tr>
				</logic:iterate>
				</logic:notEmpty>
				</tbody>
				</table>
				<logic:empty name="usersList">
					<logic:empty name="timeLine">
						<div align="center" style="padding-top:20px;">検索結果がありません。</div>
					</logic:empty>
				</logic:empty>
			</div>
		</div>
	</div>
</body>
</html:html>
