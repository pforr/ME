<%@include file="../init.jsp" %>
<aui:input name="screenName" label="user-name" type="text">
	<aui:validator name="required" />
</aui:input>

<aui:input name="fullName" type="text" label="full-name" >
	<aui:validator name="required" />
</aui:input>

<aui:input name="emailAddress" type="text" >
	<aui:validator name="email" />
</aui:input>

<aui:input name="password1" type="password" label="password" cssClass="lfr-input-text">
	<aui:validator name="required" />
</aui:input>

<aui:input name="password2" type="password" label="re-password" cssClass="lfr-input-text">
		<aui:validator name="equalTo">'#<portlet:namespace />password1'</aui:validator>
</aui:input>
