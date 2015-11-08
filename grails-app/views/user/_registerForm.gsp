<%@ page import="dk.roninit.remedy.UserCmd" %>

<div class="fieldcontain ${hasErrors(bean: userCmdInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="user.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${userCmdInstance?.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userCmdInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${userCmdInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userCmdInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="user.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" checked="true" value="${userCmdInstance?.enabled}" />
</div>


</div>

