<%@ page import="remedyadminapp.Profile" %>



<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'fullName', 'error')} required">
	<label for="fullName">
		<g:message code="profile.fullName.label" default="Full Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="fullName" required="" value="${profileInstance?.fullName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="profile.email.label" default="Email" />

	</label>
	<g:textField name="email" value="${profileInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'phoneNumber', 'error')} ">
	<label for="phoneNumber">
		<g:message code="profile.phoneNumber.label" default="Phone Number" />

	</label>
	<g:textField name="phoneNumber" value="${profileInstance?.phoneNumber}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'areas', 'error')} ">
	<label for="areas">
		<g:message code="profile.areas.label" default="Areas" />

	</label>
	<g:select name="areas" from="${remedyadminapp.Area.list()}" multiple="multiple" optionKey="id" size="5" value="${profileInstance?.areas*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'machines', 'error')} ">
	<label for="machines">
		<g:message code="profile.machines.label" default="Machines" />

	</label>
	<g:select name="machines" from="${remedyadminapp.Machine.list()}" multiple="multiple" optionKey="id" size="5" value="${profileInstance?.machines*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="profile.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${remedyadminapp.User.list()}" optionKey="id" required="" value="${profileInstance?.user?.id}" class="many-to-one"/>
</div>

