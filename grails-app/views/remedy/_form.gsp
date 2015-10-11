<%@ page import="remedyadminapp.Remedy" %>



<div class="fieldcontain ${hasErrors(bean: remedyInstance, field: 'photo', 'error')} ">
	<label for="photo">
		<g:message code="remedy.photo.label" default="Photo" />
		
	</label>
	<input type="file" id="photo" name="photo" />
</div>

<div class="fieldcontain ${hasErrors(bean: remedyInstance, field: 'area', 'error')} required">
	<label for="area">
		<g:message code="remedy.area.label" default="Area" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="area" name="area.id" from="${remedyadminapp.Area.list()}" optionKey="id" required="" value="${remedyInstance?.area?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: remedyInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="remedy.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${remedyInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: remedyInstance, field: 'errorType', 'error')} required">
	<label for="errorType">
		<g:message code="remedy.errorType.label" default="Error Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="errorType" name="errorType.id" from="${remedyadminapp.ErrorType.list()}" optionKey="id" required="" value="${remedyInstance?.errorType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: remedyInstance, field: 'logs', 'error')} ">
	<label for="logs">
		<g:message code="remedy.logs.label" default="Logs" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${remedyInstance?.logs?}" var="l">
    <li><g:link controller="log" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="log" action="create" params="['remedy.id': remedyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'log.label', default: 'Log')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: remedyInstance, field: 'machine', 'error')} required">
	<label for="machine">
		<g:message code="remedy.machine.label" default="Machine" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="machine" name="machine.id" from="${remedyadminapp.Machine.list()}" optionKey="id" required="" value="${remedyInstance?.machine?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: remedyInstance, field: 'status', 'error')} required">
	<label for="status">
		<g:message code="remedy.status.label" default="Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="status" name="status.id" from="${remedyadminapp.Status.list()}" optionKey="id" required="" value="${remedyInstance?.status?.id}" class="many-to-one"/>
</div>

