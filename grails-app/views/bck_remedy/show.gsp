
<%@ page import="remedyadminapp.Remedy" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'remedy.label', default: 'Remedy')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-remedy" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-remedy" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list remedy">
			
				<g:if test="${remedyInstance?.photo}">
				<li class="fieldcontain">
					<span id="photo-label" class="property-label"><img class="avatar" height="100" src="${createLink(controller:'remedy', action:'avatar_image', id:remedyInstance.id)}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${remedyInstance?.area}">
				<li class="fieldcontain">
					<span id="area-label" class="property-label"><g:message code="remedy.area.label" default="Area" /></span>
					
						<span class="property-value" aria-labelledby="area-label"><g:link controller="area" action="show" id="${remedyInstance?.area?.id}">${remedyInstance?.area?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${remedyInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="remedy.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${remedyInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${remedyInstance?.errorType}">
				<li class="fieldcontain">
					<span id="errorType-label" class="property-label"><g:message code="remedy.errorType.label" default="Error Type" /></span>
					
						<span class="property-value" aria-labelledby="errorType-label"><g:link controller="errorType" action="show" id="${remedyInstance?.errorType?.id}">${remedyInstance?.errorType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${remedyInstance?.machine}">
				<li class="fieldcontain">
					<span id="machine-label" class="property-label"><g:message code="remedy.machine.label" default="Machine" /></span>
					
						<span class="property-value" aria-labelledby="machine-label"><g:link controller="machine" action="show" id="${remedyInstance?.machine?.id}">${remedyInstance?.machine?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${remedyInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="remedy.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:link controller="status" action="show" id="${remedyInstance?.status?.id}">${remedyInstance?.status?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:remedyInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${remedyInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
