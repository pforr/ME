<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="vn.dtt.sol.ns.daunoinuoc.constant.DauNoiNuocConstantString"%>
<%@page import="vn.dtt.sol.ns.util.ActionKeys"%>
<%@page import="vn.dtt.cmon.user.permission.UserMappingPermission"%>
<%@page import="vn.dtt.sol.ns.daunoinuoc.terms.DauNoiNuocTerms"%>
<%@page import="vn.dtt.sol.ns.util.NuocSachUtils"%>
<%@page import="vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien"%>
<%@page import="vn.dtt.sol.ns.kehoachkiemdemnuoc.terms.KeHoachKiemDemNuocTerms"%>
<%@page import="vn.dtt.sol.ns.tramcap.dao.model.KeHoachKiemDemNuoc"%>
<%@page import="vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc"%>
<%@page import="vn.dtt.sol.ns.business.DataItemBusiness"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="vn.dtt.sol.ns.tramcap.business.TramCapBusiness"%>
<%@page import="vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc"%>
<%@page import="vn.dtt.sol.ns.daunoinuoc.search.DauNoiNuocSearchTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@page import="vn.dtt.sol.ns.daunoinuoc.search.DauNoiNuocSearch"%>
<%@page import="vn.dtt.sol.ns.util.WebKeys"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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
<%@include file="/init.jsp" %>

<%
		 String maTinh = ParamUtil.getString(request, DauNoiNuocTerms.MA_TINH);
		 List<DATAITEM> listTinh = (List<DATAITEM>)request.getAttribute("listTinh");
		 List<TramCapNuoc>  listTramCapNuoc = (List<TramCapNuoc>)request.getAttribute("listTramCapNuoc");
		 List<KiemDemVien> listKiemDemVien = new ArrayList<KiemDemVien>(); 
		 listKiemDemVien = (List<KiemDemVien>)request.getAttribute("listKiemDemVien");
		 UserMapping userMapping = (UserMapping)request.getAttribute("loginUserMapping");
		 int year = Calendar.getInstance().get(Calendar.YEAR);
		 String requiredLabel="";
		 requiredLabel ="*";
		 String dotLabel=":";
%>
<portlet:renderURL var="selectTramCap" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/html/portlet/kehoachkiemdemnuoc/_select_tram_cap.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="selectKiemDem" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/html/portlet/kehoachkiemdemnuoc/_select_kiem_dem_vien.jsp"/>
</portlet:renderURL>
<liferay-portlet:renderURL varImpl="themDauNoiNuocURL">
	<liferay-portlet:param name="mvcPath" value="/html/portlet/kehoachkiemdemnuoc/edit_kehoachkiemdemnuoc.jsp"></liferay-portlet:param>
	<liferay-portlet:param name="<%=WebKeys.REDIRECT %>" value="<%=currentURL %>"></liferay-portlet:param>
</liferay-portlet:renderURL>
<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/html/portlet/kehoachkiemdemnuoc/view.jsp" />
</liferay-portlet:renderURL>
<aui:fieldset>
<aui:column>
<aui:select name="maTinh" id="maTinh" label="<%= LanguageUtil.get(pageContext, \"tinh-thanh-pho\") + dotLabel %>" showEmptyOption="<%= false %>">
					<c:if test="<%=userMapping.getUserType() != DauNoiNuocConstantString.UserMapping.CAP_TRAM %>">
					<aui:option value=""><liferay-ui:message key="-chon-tat-ca-"></liferay-ui:message></aui:option>
					</c:if>
					<%
						for (DATAITEM tinh : listTinh) {
					%>
						<aui:option value="<%= tinh.getNode1() %>"><%= tinh.getName() %></aui:option>
					<%
						}
					%>
				</aui:select>
</aui:column>
	<aui:column>
		<div id="tramCapCbx">
				<aui:select name="<%=KeHoachKiemDemNuocTerms.TRAM_CAP_NUOC_ID %>" id="<%=KeHoachKiemDemNuocTerms.TRAM_CAP_NUOC_ID %>" label="<%= LanguageUtil.get(pageContext, \"tram-cap-nuoc\") + dotLabel %>" onChange="javascript:selectKiemDemVien();" showEmptyOption="<%= false %>">
					<c:if test="<%=userMapping.getUserType() != DauNoiNuocConstantString.UserMapping.CAP_TRAM %>">
					<aui:option value=""><liferay-ui:message key="-chon-tat-ca-"></liferay-ui:message></aui:option>
					</c:if>
					<%
						for (TramCapNuoc tramCapNuoc : listTramCapNuoc) {
					%>
						<aui:option value="<%= tramCapNuoc.getId() %>"><%= tramCapNuoc.getTenTram() %></aui:option>
					<%
						}
					%>
				</aui:select>
		</div>
	</aui:column>
	<aui:column>
	<div id="kiemDemCbx">
	<aui:select name="<%=KeHoachKiemDemNuocTerms.KIEM_DEM_VIEN_ID %>"  id="tramCapIdAjax" label="<%= LanguageUtil.get(pageContext, \"kiem-dem-vien\") + dotLabel %>" showEmptyOption="<%= false %>">
						<aui:option value=""><liferay-ui:message key="-chon-tat-ca-"></liferay-ui:message></aui:option>
					<%
						for (KiemDemVien kiemDemVien : listKiemDemVien) {
					%>
						<aui:option value="<%= kiemDemVien.getId() %>"><%= kiemDemVien.getHoVaTen() %></aui:option>
					<%
						}
					%>
					</aui:select>
					</div>
	</aui:column>
	<aui:column>
		<aui:select name="<%=KeHoachKiemDemNuocTerms.NAM %>"  id="<%=KeHoachKiemDemNuocTerms.NAM %>" label="<%= LanguageUtil.get(pageContext, \"nam-danh-gia\") + dotLabel %>"  showEmptyOption="<%= false %>">
						<aui:option value=""><liferay-ui:message key="-chon-"></liferay-ui:message></aui:option>
					<%for(int i=year; i >= 2013; i--){ %>
						<aui:option value="<%=String.valueOf(i) %>"><liferay-ui:message key="<%=LanguageUtil.format(pageContext, \"nam-x-danh-gia\",String.valueOf(i)) %>"></liferay-ui:message></aui:option>
						<%} %>
		</aui:select>
	</aui:column>
	<aui:column>
					
					<aui:select name="trangThai"  id="trangThai" label="<%= LanguageUtil.get(pageContext, \"thang-thai\") + dotLabel %>" showEmptyOption="<%= false %>">
						<aui:option value=""><liferay-ui:message key="-chon-tat-ca-"></liferay-ui:message></aui:option>
						<aui:option value="0"><liferay-ui:message key="trang-thai-ke-hoach-0"></liferay-ui:message></aui:option>
						<aui:option value="1"><liferay-ui:message key="trang-thai-ke-hoach-1"></liferay-ui:message></aui:option>
						<aui:option value="2"><liferay-ui:message key="trang-thai-ke-hoach-2"></liferay-ui:message></aui:option>
					</aui:select>
	</aui:column>

	<aui:column>
	<aui:button cssClass="btnTop" type="button" value="tim-kiem"  onClick='<%= renderResponse.getNamespace() + \"fitterALL()\" %>'></aui:button>
	</aui:column>

</aui:fieldset>
<c:if test="<%= UserMappingPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADMIN_KEHOACH_KIEMDEM) %>">
	<aui:button-row>
		<aui:button cssClass="btn-primary" type="button" value="them-moi-ke-hoach"  onClick='<%= renderResponse.getNamespace() + "themKeHoachKiemDemNuocOnClick()" %>'></aui:button>
	</aui:button-row>
</c:if>
<script type="text/javascript">
	//fitter list
	function <portlet:namespace />fitterALL() {
		var A = AUI();
// 		imPortTuExcelURL
		var url = '<%=searchURL.toString() %>';
		
		if(A.one('#<portlet:namespace /><%=DauNoiNuocTerms.MA_TINH%>')) {
			url += '&<portlet:namespace /><%=DauNoiNuocTerms.MA_TINH%>=' + A.one('#<portlet:namespace /><%=DauNoiNuocTerms.MA_TINH%>').get('value');
		}
		if(A.one('#<portlet:namespace /><%=KeHoachKiemDemNuocTerms.TRAM_CAP_NUOC_ID %>')) {
			url += '&<portlet:namespace /><%=KeHoachKiemDemNuocTerms.TRAM_CAP_NUOC_ID %>=' + A.one('#<portlet:namespace /><%=KeHoachKiemDemNuocTerms.TRAM_CAP_NUOC_ID %>').get('value');
		}
		if(A.one('#<portlet:namespace />tramCapIdAjax')) {
			url += '&<portlet:namespace /><%=KeHoachKiemDemNuocTerms.KIEM_DEM_VIEN_ID %>=' + A.one('#<portlet:namespace />tramCapIdAjax').get('value');
		}
		if(A.one('#<portlet:namespace /><%=KeHoachKiemDemNuocTerms.NAM %>')) {
			url += '&<portlet:namespace /><%=KeHoachKiemDemNuocTerms.NAM %>=' + A.one('#<portlet:namespace /><%=KeHoachKiemDemNuocTerms.NAM %>').get('value');
		}
		
		if(A.one('#<portlet:namespace />trangThai')) {
			url += '&<portlet:namespace />trangThai=' + A.one('#<portlet:namespace />trangThai').get('value');
		}
		
		location.href = url;
	}

	function <portlet:namespace />themKeHoachKiemDemNuocOnClick() {
		var A = AUI();
//	 		imPortTuExcelURL
			var url = '<%=themDauNoiNuocURL.toString() %>';
			
			if(A.one('#<portlet:namespace /><%=DauNoiNuocTerms.MA_TINH%>')) {
				url += '&<portlet:namespace /><%=DauNoiNuocTerms.MA_TINH%>=' + A.one('#<portlet:namespace /><%=DauNoiNuocTerms.MA_TINH%>').get('value');
			}
			if(A.one('#<portlet:namespace /><%=KeHoachKiemDemNuocTerms.TRAM_CAP_NUOC_ID %>')) {
				url += '&<portlet:namespace /><%=KeHoachKiemDemNuocTerms.TRAM_CAP_NUOC_ID %>=' + A.one('#<portlet:namespace /><%=KeHoachKiemDemNuocTerms.TRAM_CAP_NUOC_ID %>').get('value');
			}
			if(A.one('#<portlet:namespace /><%=KeHoachKiemDemNuocTerms.KIEM_DEM_VIEN_ID %>')) {
				url += '&<portlet:namespace /><%=KeHoachKiemDemNuocTerms.KIEM_DEM_VIEN_ID %>=' + A.one('#<portlet:namespace /><%=KeHoachKiemDemNuocTerms.KIEM_DEM_VIEN_ID %>').get('value');
			}
			if(A.one('#<portlet:namespace />trangThai')) {
				url += '&<portlet:namespace />trangThai=' + A.one('#<portlet:namespace />trangThai').get('value');
			}
			
			location.href = url;
	}
	AUI().ready(function(A){
		var capTinhInput = A.one("#<portlet:namespace/><%=DauNoiNuocTerms.MA_TINH %>");
		capTinhInput.on('change', function(){
			var capTinhId = capTinhInput.val();
			selectTram(capTinhId);
			selectKiemDemVien();
		});
	});

	function selectTram(capTinhId){
		AUI().use('aui-base','aui-io-request', function(A){

			//aui ajax call to get updated content
			A.io.request('<%= selectTramCap %>',
			{
				dataType: 'text/html',
				method: 'GET',
				data: { 
					"<portlet:namespace />capTinhId": capTinhId
				},
				on: {
					success: function() {
						var optHuyen = A.one("#tramCapCbx");
						optHuyen.set("innerHTML", this.get('responseData'));
					} 
				}
			});
		});	
	}
	
	function selectKiemDemVien(){
		AUI().use('aui-base','aui-io-request', function(A){
			var capTinhInput = A.one("#<portlet:namespace/><%=DauNoiNuocTerms.MA_TINH %>");
			var tramCapInputsss = A.one("#<portlet:namespace/><%=KeHoachKiemDemNuocTerms.TRAM_CAP_NUOC_ID %>");
			//aui ajax call to get updated content
			
			var idToTramCap = 0;
			var typeKiemDem = 1;
			if(capTinhInput.val()>0){
				idToTramCap = capTinhInput.val();
				typeKiemDem =1;
			}
			if(tramCapInputsss.val()>0){
				idToTramCap = tramCapInputsss.val();
				typeKiemDem = 3;
			}
			
			A.io.request('<%= selectKiemDem %>',
			{
				dataType: 'text/html',
				method: 'GET',
				data: { 
					"<portlet:namespace />tramCapIdAjax": idToTramCap,
					"<portlet:namespace />typeKiemDem": typeKiemDem
				},
				on: {
					success: function() {
						var optHuyen = A.one("#kiemDemCbx");
						optHuyen.set("innerHTML", this.get('responseData'));
					} 
				}
			});
		});	
	}
</script>
