<%@page import="com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.store.DLStoreUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
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
	
	int namBaoCao = ParamUtil.getInteger(request, "namBaoCao");
	String soBaoCao = ParamUtil.getString(request, "soBaoCao");
	String nguoiLap = ParamUtil.getString(request, "nguoiLap");
	String nguoiDuyet = ParamUtil.getString(request, "nguoiDuyet");
	
	String ngayBaoCao = ParamUtil.getString(request, "ngayBaoCao");
	
	String tabNameValues = "bao-cao-dli-tong-hop,bao-cao-dli-chi-tiet";

	if (!(typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_1_1 || typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_1_2)) {
		tabNameValues = "bao-cao-dli-tong-hop";
	}
	
	if (typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_3 && !isRealTimeReport) {
		tabNameValues = "bao-cao-dli-tong-hop,bao-cao-dli-3-1,bao-cao-dli-3-2";
	}
%>

<liferay-util:include page="/html/common/report_export.jsp" servletContext="<%= application %>" >
	<portlet:param name="namBaoCao" value="<%= String.valueOf(namBaoCao) %>"/>
	<portlet:param name="soBaoCao" value="<%= soBaoCao %>"/>
	<portlet:param name="nguoiLap" value="<%= nguoiLap %>"/>
	<portlet:param name="nguoiDuyet" value="<%= nguoiDuyet %>"/>
	<portlet:param name="ngayBaoCao" value="<%= ngayBaoCao %>"/>
	<portlet:param name="duoiFile" value="<%= ReportConstant.DUOI_PDF %>"/>
	<portlet:param name="thoiGianThuc" value="<%= ReportConstant.CHOT %>"/>
	
	<c:choose>
		<c:when test="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_1_1 %>">
			<portlet:param name="type" value="<%= ReportConstant.DLI1_1_TU %>"/>
		</c:when>

		<c:when test="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_1_2 %>">
			<portlet:param name="type" value="<%= ReportConstant.DLI1_2_TU %>"/>
		</c:when>

		<c:when test="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_2_1 %>">
			<portlet:param name="type" value="<%= ReportConstant.DLI2_1_TU %>"/>
		</c:when>

		<c:when test="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_2_2 %>">
			<portlet:param name="type" value="<%= ReportConstant.DLI2_2_TU %>"/>
		</c:when>

		<c:when test="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_3 %>">
			<portlet:param name="type" value="<%= ReportConstant.DLI3_TU %>"/>
		</c:when>

		<c:when test="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_TH %>">
			<portlet:param name="type" value="<%= ReportConstant.DLI_TH_TU %>"/>
		</c:when>

		<c:when test="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_TDCNTT %>">
			<portlet:param name="type" value="<%= ReportConstant.TDTHCNTT_TU %>"/>
		</c:when>

		<c:when test="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_THVG %>">
			<portlet:param name="type" value="<%= ReportConstant.THVG_TU %>"/>
		</c:when>

		<c:when test="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_KQXNN %>">
			<portlet:param name="type" value="<%= ReportConstant.KQXNNC_TU %>"/>
		</c:when>

		<c:when test="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_BCHNT %>">
			<portlet:param name="type" value="<%= ReportConstant.HNT_TU %>"/>
		</c:when>

		<c:when test="<%= typeDLI == BaoCaoDLIConstants.LINK_MINH_BACH %>">
			<portlet:param name="type" value="<%= ReportConstant.MB_TU %>"/>
		</c:when>
	</c:choose>
</liferay-util:include>
