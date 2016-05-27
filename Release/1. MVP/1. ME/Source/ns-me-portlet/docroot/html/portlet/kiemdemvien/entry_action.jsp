<%--
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
--%>

<%@page import="vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien"%>
<%@page import="vn.dtt.sol.ns.util.WebKeys"%>
<%@ include file="/init.jsp" %>

<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

KiemDemVien entry = (KiemDemVien)row.getObject();

%>

<liferay-portlet:renderURL var="viewEntryURL">
	<portlet:param name="mvcPath" value="/html/portlet/kiemdemvien/view_detail.jsp" />
	<portlet:param name="id" value="<%= String.valueOf(entry.getId()) %>" />
	<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(request) %>"/>
</liferay-portlet:renderURL>

<liferay-ui:icon
	image="view"
	label="xem-chi-tiet-kiem-dem-vien"
	url="<%= viewEntryURL %>"
	message="xem-chi-tiet-kiem-dem-vien"
/>

<liferay-portlet:renderURL var="editEntryURL">
	<portlet:param name="mvcPath" value="/html/portlet/kiemdemvien/edit_kiemdemvien.jsp" />
	<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(request) %>"/>
	<portlet:param name="id" value="<%= String.valueOf(entry.getId()) %>" />
	<portlet:param name="currentURL" value="<%= currentURL %>"/>
</liferay-portlet:renderURL>

<liferay-ui:icon
	image="edit"
	message="sua-kiem-dem-vien"
	label="sua-kiem-dem-vien"
	url="<%= editEntryURL %>"
/>

<liferay-portlet:actionURL name="chuyenTrangThai" var="chuyenTrangThaiURL">
	<portlet:param name="lastURL" value="<%= PortalUtil.getCurrentURL(request) %>" />
	<portlet:param name="id" value="<%= String.valueOf(entry.getId()) %>" />
</liferay-portlet:actionURL>

<liferay-ui:icon
	image="activate"
	message="chuyen-trang-thai"
	url="<%= chuyenTrangThaiURL %>"
/>
