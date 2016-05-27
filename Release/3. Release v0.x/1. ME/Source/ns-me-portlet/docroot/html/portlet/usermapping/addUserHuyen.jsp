<%
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@include file="init.jsp" %>

<%
	String[] CATEGORY_NAMES = new String[]{"basic-information", "dia-ban-quan-ly", "quyen-han"};
	
	String[] basic_information = new String[]{"basic"};
	String[] dia_ban_quan_ly = new String[]{"dia_ban_qly_tramcap"};
	String[] quyen_han = new String[]{"quyen_han"};
	
	String[][] categorySections = {basic_information, dia_ban_quan_ly, quyen_han};
%>

<liferay-ui:header
	backURL="<%= redirectURL %>"
	title="add-user-mapping"
/>

<portlet:actionURL var="formAction" name="addUserTramCap" />

<aui:form action="<%= formAction %>" method="post" name="fm">
	<div class="add-user-tramcap-wrapper">
		<liferay-ui:form-navigator
			categoryNames="<%= CATEGORY_NAMES %>"
			categorySections="<%= categorySections %>"
			jspPath="/html/portlet/usermapping/userhuyen/"
		/>
	</div>
</aui:form>