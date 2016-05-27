
<%@page import="vn.dtt.sol.ns.reporting.utils.ReportConstant"%>
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
	
	
	String namBaoCao = ParamUtil.getString(request, "namBaoCao");
	String maTinh = ParamUtil.getString(request, "maTinh");
	String type = ParamUtil.getString(request, "type");
	_logdashboardview.info("--html.portlet.dasboard.view_report.jsp--");
%>


<liferay-util:include page="/html/common/report_export.jsp" servletContext="<%= application %>" >
	<portlet:param name="maTinh" value="<%= maTinh %>"/>
	<portlet:param name="namBaoCao" value="<%= namBaoCao  %>"/>
	<portlet:param name="duoiFile" value="<%= ReportConstant.DUOI_PDF%>"/>
	<portlet:param name="thoiGianThuc" value="<%=ReportConstant.CHOT%>"/>
	<portlet:param name="type" value="<%=type%>"/>
</liferay-util:include>

