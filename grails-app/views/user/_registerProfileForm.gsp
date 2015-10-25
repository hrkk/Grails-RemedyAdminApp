<%@ page import="remedyadminapp.UserCmd" %>



<div class="fieldcontain ${hasErrors(bean: userCmdInstance, field: 'fullName', 'error')} required">
    <label for="fullName">
        <g:message code="profile.fullName.label" default="Full Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="fullName" required="" value="${userCmdInstance?.fullName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userCmdInstance, field: 'email', 'error')} ">
    <label for="email">
        <g:message code="profile.email.label" default="Email"/>

    </label>
    <g:textField name="email" value="${userCmdInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userCmdInstance, field: 'phoneNumber', 'error')} ">
    <label for="phoneNumber">
        <g:message code="profile.phoneNumber.label" default="Phone Number" />

    </label>
    <g:textField name="phoneNumber" value="${userCmdInstance?.phoneNumber}"/>
</div>