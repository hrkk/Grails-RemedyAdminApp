
<%@ page import="remedyadminapp.Remedy" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'remedy.label', default: 'Remedy')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-remedy" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-remedy" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="photo" title="${message(code: 'remedy.photo.label', default: 'Photo')}" />
					
						<th><g:message code="remedy.area.label" default="Area" /></th>
					
						<g:sortableColumn property="description" title="${message(code: 'remedy.description.label', default: 'Description')}" />
					
						<th><g:message code="remedy.errorType.label" default="Error Type" /></th>
					
						<th><g:message code="remedy.machine.label" default="Machine" /></th>
					
						<th><g:message code="remedy.status.label" default="Status" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${remedyInstanceList}" status="i" var="remedyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${remedyInstance.id}">${fieldValue(bean: remedyInstance, field: "photo")}</g:link></td>
					
						<td>${fieldValue(bean: remedyInstance, field: "area")}</td>
					
						<td>${fieldValue(bean: remedyInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: remedyInstance, field: "errorType")}</td>
					
						<td>${fieldValue(bean: remedyInstance, field: "machine")}</td>
					
						<td>${fieldValue(bean: remedyInstance, field: "status")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${remedyInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
