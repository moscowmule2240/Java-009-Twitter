<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<html:link action="/welcome" styleClass="brand">Mini Blog</html:link>
			<html:form action="/search" styleClass="navbar-form pull-left">
				<html:text property="searchValue" styleClass="search-query" />
				<html:submit property="dispatch" styleClass="btn"><bean:message key="from.button.search.user"/></html:submit>
				<html:submit property="dispatch" styleClass="btn"><bean:message key="from.button.search.tweet"/></html:submit>
			</html:form>
			<logic:notEmpty name="registration.user.infomation.key" scope="session">
			<ul class="nav pull-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">アカウント<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><html:link action="/logout">プロフィール更新</html:link></li>
						<li><a href="#message" data-toggle="modal" onclick="address()">秘密メッセージ</a></li>
						<li><html:link action="/logout">ログアウト</html:link></li>
					</ul>
				</li>
			</ul>
			</logic:notEmpty>
		</div>
	</div>
</div>
<div id="message" class="modal hide fade">
	<div class="modal-header">
		<a class="close" data-dismiss="modal">x</a>
		<h3>秘密メッセージ</h3>
		送信相手を選択してください。
	</div>
	<div class="modal-body">
		<table class="table">
		<tbody id="address"></tbody>
		</table>
	</div>
</div>
<script type="text/javascript">
function address(){
	$.ajaxSetup({scriptCharset:'utf-8'});
	$.getJSON('address.do', function(data){
		$("#address").empty();
		for(var i in data){
			$("#address").append("<tr><td><a href='message.do?userId=" + data[i].userId + "'>" + data[i].displayName + "</a></td><td>" + data[i].introduction + "</td></tr>");
		}
	});
}
</script>
