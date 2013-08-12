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
<title>Mini Blog をはじめましょう！</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="padding-top:60px;">
	<jsp:include page="/pages/header.jsp" flush="true" />
	<div class="container">
		<html:form action="/registration" styleClass="form-horizontal" style="padding-top:20px;">
			<fieldset>
				<legend>Mini Blog をはじめましょう！</legend>
				<logic:messagesPresent property="message">
					<font color="red"><html:errors property="message" header="false" footer="false" prefix="false" suffix="false" /></font>
				</logic:messagesPresent>
				<div class='control-group<logic:messagesPresent property="displayName"> error</logic:messagesPresent>'>
					<label class="control-label">名前</label>
					<div class="controls">
						<html:text property="displayName" maxlength="128" styleClass="span4" />
						<span class="help-inline"><html:errors property="displayName" header="false" footer="false" prefix="false" suffix="false" /></span>
					</div>
				</div>
				<div class='control-group<logic:messagesPresent property="userName"> error</logic:messagesPresent>'>
					<label class="control-label">ユーザー名</label>
					<div class="controls">
						<html:text property="userName" maxlength="128" styleClass="span4" />
						<span class="help-inline"><html:errors property="userName" header="false" footer="false" prefix="false" suffix="false" /></span>
					</div>
				</div>
				<div class='control-group<logic:messagesPresent property="password"> error</logic:messagesPresent>'>
					<label class="control-label">パスワード</label>
					<div class="controls">
						<html:text property="password" maxlength="128" styleClass="span4" />
						<span class="help-inline"><html:errors property="password" header="false" footer="false" prefix="false" suffix="false" /></span>
					</div>
				</div>
				<div class='control-group<logic:messagesPresent property="introduction"> error</logic:messagesPresent>'>
					<label class="control-label">自己紹介</label>
					<div class="controls">
						<html:textarea property="introduction" rows="10" styleClass="span4" />
						<span class="help-inline"><html:errors property="introduction" header="false" footer="false" prefix="false" suffix="false" /></span>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<html:submit value="アカウントを作成する" styleClass="btn" />
					</div>
				</div>
			</fieldset>
		</html:form>
	</div>
</body>
</html:html>
