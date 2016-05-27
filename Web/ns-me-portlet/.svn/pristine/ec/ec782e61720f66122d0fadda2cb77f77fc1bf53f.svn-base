
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
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
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="vn.dtt.sol.ns.business.UserMappingBusiness"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Calendar"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
 <%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>

<%@page import="javax.portlet.PortletURL"%>
<%@include file="init.jsp" %>

<%
	
	
	UserMapping userMapping = UserMappingBusiness.getUserMapping(user);
	int userType = userMapping.getUserType();
	String maTinh = userMapping.getOrgCode1();
	_logdashboardview.info("--html.portlet.dasboard.view.jsp--userType--"+userType+"--maTinh--"+maTinh+"==");
%>


<c:choose>
	<c:when test="<%=  userType == 1  %>">
		<liferay-util:include page='<%= templatePath + "view_dashboard_tu.jsp" %>' servletContext="<%= application %>" />
	</c:when>
	<c:otherwise>
		<liferay-util:include page='<%= templatePath + "view_dashboard.jsp" %>' servletContext="<%= application %>" />
	</c:otherwise>
</c:choose>

