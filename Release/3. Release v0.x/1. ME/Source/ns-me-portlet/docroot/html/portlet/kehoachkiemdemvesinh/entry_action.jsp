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
<%@page import="vn.dtt.sol.ns.vesinhmoitruong.terms.KeHoachKiemDemVeSinhTerms"%>
<%@page import="vn.dtt.sol.ns.vesinhmoitruong.dao.model.KeHoachKiemDemVeSinh"%>
<%@page import="vn.dtt.sol.ns.reporting.KeHoachKiemDemVeSinhReportModel"%>
<%@page import="vn.dtt.sol.ns.util.ActionKeys"%>
<%@page import="vn.dtt.cmon.user.permission.UserMappingPermission"%>
<%@page import="vn.dtt.sol.ns.reporting.KeHoachKiemDemNuocReportModel"%>
<%@page import="vn.dtt.sol.ns.reporting.DauNoiNuocReportModel"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/init.jsp" %>

<%

String maTinh = (String)request.getAttribute(KeHoachKiemDemVeSinhTerms.MA_TINH);
String maHuyen = (String)request.getAttribute(KeHoachKiemDemVeSinhTerms.MA_HUYEN);
String kiemDemVienId = (String)request.getAttribute(KeHoachKiemDemVeSinhTerms.KIEM_DEM_VIEN_ID);
String trangThai = (String)request.getAttribute("trangThai");
SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

KeHoachKiemDemVeSinhReportModel entry = (KeHoachKiemDemVeSinhReportModel)row.getObject();
%>
<liferay-portlet:renderURL var="viewEntryURL">
	<portlet:param name="mvcPath" value="/html/portlet/kehoachkiemdemvesinh/view_detail_tab1.jsp" />
	<liferay-portlet:param name="<%=WebKeys.REDIRECT %>" value="<%=currentURL %>"></liferay-portlet:param>
	<portlet:param name="<%=KeHoachKiemDemVeSinhTerms.ID%>" value="<%= String.valueOf(entry.getId()) %>" />
	<liferay-portlet:param name="idTrangThaiChk" value="<%=String.valueOf(entry.getTrangThaiChk()) %>"></liferay-portlet:param>
</liferay-portlet:renderURL>



<liferay-portlet:renderURL var="editEntryURL">
	<portlet:param name="mvcPath" value="/html/portlet/kehoachkiemdemvesinh/edit_kehoachkiemdemvesinh.jsp" />
	<liferay-portlet:param name="<%=WebKeys.REDIRECT %>" value="<%=currentURL %>"></liferay-portlet:param>
	<portlet:param name="<%=KeHoachKiemDemVeSinhTerms.ID%>" value="<%= String.valueOf(entry.getId()) %>" />
</liferay-portlet:renderURL>

<portlet:renderURL var="onpageError">
	<portlet:param name="mvcPath" value="/html/portlet/kehoachkiemdemvesinh/view.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="onpageSuccess">
	<portlet:param name="mvcPath" value="/html/portlet/kehoachkiemdemvesinh/view.jsp"/>
</portlet:renderURL>
<liferay-portlet:actionURL var="deleteEntryURL" name="deleteKeHoachKiemDem">
	<portlet:param name="currentURL" value="<%= currentURL %>" />
	<portlet:param name="<%=KeHoachKiemDemVeSinhTerms.ID%>" value="<%= String.valueOf(entry.getId()) %>" />
	<liferay-portlet:param name="maTinh" value="<%=maTinh %>"></liferay-portlet:param>
	<liferay-portlet:param name="<%=KeHoachKiemDemVeSinhTerms.KIEM_DEM_VIEN_ID %>" value="<%=kiemDemVienId %>"></liferay-portlet:param>
	<liferay-portlet:param name="trangThai" value="<%=trangThai %>"></liferay-portlet:param>
	<liferay-portlet:param name="onpageError" value="<%= onpageError%>"></liferay-portlet:param>
	<liferay-portlet:param name="onpageSuccess" value="<%=onpageSuccess %>"></liferay-portlet:param>
</liferay-portlet:actionURL>
<portlet:actionURL name="dongkeHoachKiemDem" var="dongkeHoachKiemDemURL">
	<portlet:param name="<%=KeHoachKiemDemVeSinhTerms.ID%>" value="<%= String.valueOf(entry.getId()) %>" />
	<liferay-portlet:param name="onpageError" value="<%= onpageError%>"></liferay-portlet:param>
	<liferay-portlet:param name="onpageSuccess" value="<%=onpageSuccess %>"></liferay-portlet:param>
</portlet:actionURL>
<portlet:actionURL name="xuatBankeHoachKiemDem" var="xuatBankeHoachKiemDemURL" >
	<portlet:param name="keyExport" value="export_csv_kehoachkiemdemnuoc"/>
	<portlet:param name="<%=KeHoachKiemDemVeSinhTerms.ID %>" value="<%=String.valueOf(entry.getId()) %>"/>
	<liferay-portlet:param name="onpageError" value="<%= onpageError%>"></liferay-portlet:param>
	<liferay-portlet:param name="onpageSuccess" value="<%=onpageSuccess %>"></liferay-portlet:param>
</portlet:actionURL>
<c:if test="<%= UserMappingPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_KIEM_DEM) %>">
	<liferay-ui:icon
		image="view"
		label="xem-ke-hoach-kiem-dem"
		url="<%= viewEntryURL %>"
		message="xem-ke-hoach-kiem-dem"
	/>
</c:if>
<c:if test="<%= UserMappingPermission.contains(permissionChecker, scopeGroupId,\"me_kehoachkiemdemnuoc\",user.getUserId(),entry.getUserIdData(), entry.getTrangThaiChk(), ActionKeys.ADMIN_KEHOACH_KIEMDEM)
			%>"> 
	<liferay-ui:icon
		image="edit"
		message="edit-ke-hoach-kiem-dem"
		label="edit-ke-hoach-kiem-dem"
		url="<%= editEntryURL %>"
	/>
</c:if>
<c:if test="<%= UserMappingPermission.contains(permissionChecker, scopeGroupId,\"me_kehoachkiemdemnuoc\",user.getUserId(),entry.getUserIdData(), entry.getTrangThaiChk(), ActionKeys.ADMIN_KEHOACH_KIEMDEM)
 				%>">
	<liferay-ui:icon-delete
		message="xoa-ke-hoach-kiem-dem"
		confirmation="ban-co-chac-chan-muon-xoa-ke-hoach-kiem-dem-nay"
		image="delete"
		url="<%= deleteEntryURL %>"
	/>
</c:if>

<c:if test="<%= UserMappingPermission.contains(permissionChecker, scopeGroupId,\"me_kehoachkiemdemnuoc\",user.getUserId(),entry.getUserIdData(), entry.getTrangThaiChk(), ActionKeys.ADMIN_KEHOACH_KIEMDEM)%>"> 
<liferay-ui:icon-delete
		message="thuc-hien-ke-hoach"
		confirmation="ban-co-chac-chan-muon-thuc-hien-ke-hoach-kiem-dem-nay"
		image="export"
		url="<%= xuatBankeHoachKiemDemURL %>"
	/>
</c:if> 
<c:if test="<%=(entry.getTrangThaiChk()==1) && !UserMappingPermission.contains(permissionChecker, scopeGroupId,\"me_kehoachkiemdemnuoc\",user.getUserId(),entry.getUserIdData(), entry.getTrangThaiChk(), ActionKeys.ADMIN_KEHOACH_KIEMDEM) %>">
	<portlet:renderURL var="viewInfoDialog" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
				<portlet:param name="mvcPath" value="/html/portlet/kehoachkiemdemvesinh/dialog_info.jsp"/>
				<portlet:param name="<%=KeHoachKiemDemVeSinhTerms.ID %>" value="<%=String.valueOf(entry.getId()) %>"/>
			</portlet:renderURL>
			<aui:script>
				AUI().use('aui-base','aui-io-plugin-deprecated','liferay-util-window',function(A) {
					A.one('#<%=entry.getId()+"dongKeHoachBtn" %>').on('click', function(event){
					var popUpWindow=Liferay.Util.Window.getWindow(
					{
						dialog: {
							centered: true,
							constrain2view: true,
							modal: true,
							resizable: false,
							width: screen.width * 0.4,
							height: 450
						}
					}
					).plug(A.Plugin.IO,{autoLoad: false}).render();
					popUpWindow.show();
					popUpWindow.titleNode.html("Thông tin kế hoạch kiểm đếm");
					popUpWindow.io.set('uri','<%=viewInfoDialog.toString()%>');
					popUpWindow.io.start();
					});
				});
			</aui:script>
			
	<liferay-ui:icon id="<%=entry.getId()+\"dongKeHoachBtn\" %>" cssClass="dongKeHoachSpan" 
		message="ket-thuc-ke-hoach"
		image="lock"
		onClick="<%=viewInfoDialog.toString() %>"
		 />
</c:if>
<style>
.dongKeHoachSpan{
padding-left: 10px;
}
</style>