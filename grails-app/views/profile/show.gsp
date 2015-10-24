<%@ page import="remedyadminapp.Profile" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'profile.label', default: 'Profile')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-profile" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                              default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-profile" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list profile">

        <g:if test="${profileInstance?.fullName}">
            <li class="fieldcontain">
                <span id="fullName-label" class="property-label"><g:message code="profile.fullName.label"
                                                                            default="Full Name"/></span>

                <span class="property-value" aria-labelledby="fullName-label"><g:fieldValue bean="${profileInstance}"
                                                                                            field="fullName"/></span>

            </li>
        </g:if>

        <g:if test="${profileInstance?.email}">
            <li class="fieldcontain">
                <span id="email-label" class="property-label"><g:message code="profile.email.label"
                                                                         default="Email"/></span>

                <span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${profileInstance}"
                                                                                         field="email"/></span>

            </li>
        </g:if>

        <g:if test="${profileInstance?.phoneNumber}">
            <li class="fieldcontain">
                <span id="phoneNumber-label" class="property-label"><g:message code="profile.phoneNumber.label"
                                                                               default="Phone Number"/></span>

                <span class="property-value" aria-labelledby="phoneNumber-label"><g:fieldValue bean="${profileInstance}"
                                                                                               field="phoneNumber"/></span>

            </li>
        </g:if>

        <g:if test="${profileInstance?.areas}">
            <li class="fieldcontain">
                <span id="areas-label" class="property-label"><g:message code="profile.areas.label"
                                                                         default="Areas"/></span>

                <g:each in="${profileInstance.areas}" var="a">
                    <span class="property-value" aria-labelledby="areas-label"><g:link controller="area" action="show"
                                                                                       id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
                </g:each>

            </li>
        </g:if>

        <g:if test="${profileInstance?.machines}">
            <li class="fieldcontain">
                <span id="machines-label" class="property-label"><g:message code="profile.machines.label"
                                                                            default="Machines"/></span>

                <g:each in="${profileInstance.machines}" var="m">
                    <span class="property-value" aria-labelledby="machines-label"><g:link controller="machine"
                                                                                          action="show"
                                                                                          id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
                </g:each>

            </li>
        </g:if>

        <g:if test="${profileInstance?.user}">
            <li class="fieldcontain">
                <span id="user-label" class="property-label"><g:message code="profile.user.label"
                                                                        default="User"/></span>

                <span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show"
                                                                                  id="${profileInstance?.user?.id}">${profileInstance?.user?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource: profileInstance, action: 'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${profileInstance}"><g:message code="default.button.edit.label"
                                                                                        default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
