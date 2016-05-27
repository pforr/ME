<%@page import="vn.dtt.sol.ns.util.ActionKeys"%>
<%@page import="vn.dtt.cmon.user.permission.UserMappingPermission"%>
<%@page import="vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien"%>
<%@page import="vn.dtt.sol.ns.business.DataItemBusiness"%>
<%@page import="vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc"%>
<%@page import="vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="vn.dtt.cmon.user.dao.service.UserMappingLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.user.dao.service.UserMappingLocalService"%>
<%@page import="vn.dtt.cmon.user.action.UserMappingAction"%>
<%@page import="vn.dtt.sol.ns.tramcap.business.TramCapBusiness"%>
<%@page import="vn.dtt.sol.ns.tramcap.dao.service.TramCapNuocLocalServiceUtil"%>
<%@page import="vn.dtt.sol.ns.util.NuocSachUtils"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalServiceUtil"%>
<%@page import="vn.dtt.sol.ns.business.KiemDemVienBussiness"%>
<%@page import="vn.dtt.sol.ns.business.UserMappingBusiness"%>


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

<%@include file="/init.jsp" %>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
		 
	String maTinh = StringPool.BLANK;
	String maHuyen = StringPool.BLANK;
	String maTram = StringPool.BLANK;
	
	String orgCode = StringPool.BLANK;
	
	List<DATAITEM> listTinh = DATAITEMLocalServiceUtil.getByDataGroupLevel1(1);

	List<DATAITEM> lsHuyen = new ArrayList<DATAITEM>();
	
	List<TramCapNuoc> lsTramCapNuoc = TramCapBusiness.getByTinh(maTinh);
	
	UserMapping userMapping = UserMappingBusiness.getUserMapping(user);
	
	int userType = UserMappingBusiness.getUserType(user);
	
	int initUserType = userType;
	
	int capHoatDong = 0;
	

	if (permissionChecker.isOmniadmin() || userType == 1) {
		
		capHoatDong = ParamUtil.getInteger(request, "capHoatDong");
		orgCode = ParamUtil.getString(request, "orgCode");
		
		if(capHoatDong==1){
			maTinh = ParamUtil.getString(request, "maTinh");
		} else if(capHoatDong==2){
			maHuyen = orgCode;
			lsHuyen = DataItemBusiness.getInLevel2(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh);
		} else if(capHoatDong==3){
			maTram = orgCode;
		}
		
	} else if(userType == 2) {
		
		capHoatDong = ParamUtil.getInteger(request, "capHoatDong");
		//if(capHoatDong==0) capHoatDong = 1;
		maTinh = userMapping.getOrgCode1();
		orgCode = ParamUtil.getString(request, "orgCode");
		if(orgCode==StringPool.BLANK) orgCode = maTinh;
		
		lsHuyen = DataItemBusiness.getInLevel2(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh);
	
	} else if(userType == 3) {
		
		capHoatDong = ParamUtil.getInteger(request, "capHoatDong");
		//if(capHoatDong==0) capHoatDong = 2;
		maTinh = userMapping.getOrgCode1();
		maHuyen = userMapping.getOrgCode2();
		
		orgCode = ParamUtil.getString(request, "orgCode");
		if(orgCode==StringPool.BLANK) orgCode = maHuyen;
		
		lsHuyen = DataItemBusiness.getInLevel2(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh);
		
	} else if(userType == 4) {
		
		capHoatDong = ParamUtil.getInteger(request, "capHoatDong");
		//if(capHoatDong==0) capHoatDong = 3;
		
		orgCode = ParamUtil.getString(request, "orgCode");
		if(orgCode==StringPool.BLANK) orgCode = ParamUtil.getString(request, "orgCode");
		
		maTinh = userMapping.getOrgCode1();
		
		lsHuyen = DataItemBusiness.getInLevel2(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh);
		maTram = orgCode;
		
	} else {
		capHoatDong = ParamUtil.getInteger(request, "capHoatDong");
		orgCode = ParamUtil.getString(request, "orgCode");
		
		if(capHoatDong==1){
			maTinh = userMapping.getOrgCode1();
		} else if(capHoatDong==2){
			maHuyen = orgCode;
			lsHuyen = DataItemBusiness.getInLevel2(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh);
		} else if(capHoatDong==3){
			maTram = orgCode;
		}
	}
	
%>

<portlet:renderURL var="selectHuyen" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/html/portlet/kiemdemvien/_select_huyen.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="selectTram" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/html/portlet/kiemdemvien/_select_tramcap.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="addKiemDemVienURL">
	<portlet:param name="mvcPath" value='<%= "/html/portlet/kiemdemvien/add_kiemdemvien.jsp" %>' />
	<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(request) %>"/>
</portlet:renderURL>

<portlet:actionURL name="search" var="searchURL"></portlet:actionURL>

<aui:form action="<%=searchURL%>" name="search" method="POST">
<table>
	<tr>
		<td>
			<aui:select 
				name="capHoatDong" 
				label="cap-quan-ly" 
				id="capHoatDong" 
				showEmptyOption="<%= false %>" 
				disabled="<%=(userType==1 || userType==2)? false:true %>"
			>
				<aui:option value=""><liferay-ui:message key="-tat-ca-"></liferay-ui:message></aui:option>
				<aui:option value="1" selected='<%= capHoatDong == 1 %>'><liferay-ui:message key="toan-tinh"/></aui:option>
				<aui:option value="2" selected='<%= capHoatDong == 2 %>'><liferay-ui:message key="ve-sinh-huyen"/></aui:option>
				<aui:option value="3" selected='<%= capHoatDong == 3 %>'><liferay-ui:message key="tram-cap-nuoc"/></aui:option>
			</aui:select>
		</td>
			
		<td id="optToanTinh">
			<aui:select 
				name="maTinh" 
				id="maTinh" 
				showEmptyOption="<%= false %>" 
				disabled="<%=(userType==1)? false:true %>"
			>
				<aui:option value=""><liferay-ui:message key="-tat-ca-"></liferay-ui:message></aui:option>
			<%
				for (DATAITEM tinh : listTinh) {
			%>
				<aui:option value="<%= tinh.getNode1() %>" selected="<%=(maTinh.equals(tinh.getNode1())) %>"><%= tinh.getName() %></aui:option>
			<%
				}
			%>
			</aui:select>
		</td>
		
		<td id="optVeSinhHuyen">
		<div id="optHuyen">
			<aui:select 
				name="maHuyen" 
				id="maHuyen" 
				showEmptyOption="<%= false %>" 
				disabled="<%=(userType==1 || userType==2)? false:true %>"
			>
				<aui:option value=""><liferay-ui:message key="-tat-ca-"></liferay-ui:message></aui:option>
				<%
					for (DATAITEM huyen : lsHuyen) {
				%>
				<aui:option value="<%= huyen.getNode2() %>" selected="<%=(maHuyen.equals(huyen.getNode2())) %>"><%= huyen.getName() %></aui:option>
				<%
						}
				%>
			</aui:select>
		</div>
		</td>
		
		<td id="optTramCapNuoc">
		<div id="optTram">
			<aui:select 
				name="maTram" 
				id="maTram" 
				showEmptyOption="<%= false %>" 
				disabled="<%=(userType==1 || userType==2)? false:true %>"
			>
				<aui:option value=""><liferay-ui:message key="-tat-ca-"></liferay-ui:message></aui:option>
				<%
					for (TramCapNuoc tramCap : lsTramCapNuoc) {
				%>
					<aui:option value="<%= tramCap.getMaTram() %>" selected="<%=(maTram.equals(tramCap.getMaTram())) %>"><%= tramCap.getTenTram() %></aui:option>
				<%
					}
				%>
			</aui:select>
		</div>
		</td>
		
		<td>
			<aui:button 
				name="search"
				type="submit" 
				value="search"
				style="margin: 6px 0px 0px 5px;"
			/>
		</td>
	</tr>
</table>
</aui:form>

<aui:button 
	href="<%= addKiemDemVienURL.toString() %>" 
	name="addEntryButton" 
	value="them-moi"
/>


<liferay-ui:search-container delta="20" iteratorURL="<%=portletURL%>" emptyResultsMessage="khong-tim-thay-kiem-dem-vien">
	<liferay-ui:search-container-results>
		<%
			results = KiemDemVienLocalServiceUtil.find(
					String.valueOf(capHoatDong), 
					orgCode, 
					searchContainer.getStart(), 
					searchContainer.getEnd());
		
			total = GetterUtil.getInteger(
					KiemDemVienLocalServiceUtil.count(
					String.valueOf(capHoatDong), 
					orgCode));
			
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
			
			pageContext.setAttribute("searchContainer", searchContainer);
			
			searchContainer.setIteratorURL(portletURL);
		%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row
 			className="vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien"
			keyProperty="id"
			modelVar="kiemDemVien"
	>
		<portlet:renderURL var="rowURL">
			<portlet:param name="mvcPath" value="/html/portlet/kiemdemvien/view_detail.jsp" />
			<portlet:param name="id" value="<%=String.valueOf(kiemDemVien.getId()) %>"/>
			<portlet:param name="currentURL" value="<%= currentURL %>"/>
		</portlet:renderURL>
		
		<liferay-ui:search-container-column-text 
			name="don-vi-quan-ly" 
			href="<%= rowURL %>" 
			align="left" 
		>
			<%=(kiemDemVien.getCapHoatDong()==1)? 
					NuocSachUtils.getNameTinh(kiemDemVien.getOrgCode1()):
					((kiemDemVien.getCapHoatDong()==2)?
					NuocSachUtils.getNameHuyen(kiemDemVien.getOrgCode1(), kiemDemVien.getOrgCode2()):
					NuocSachUtils.getTenTramByTramId(kiemDemVien.getOrgCode2()))
			%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text 
			name="name" 
			href="<%= rowURL %>" 
			align="left" 
		>
			<%=kiemDemVien.getHoVaTen() %>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text 
			name="account" 
			href="<%= rowURL %>" 
			align="left" 
		> 
			<%=kiemDemVien.getTaiKhoan() %>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text 
			name="status" 
			href="<%= rowURL %>" 
			align="left" 
		>
			<liferay-ui:message 
				key='<%=(kiemDemVien.getTrangThai()==1)? "activated":"deactivated"%>' 
			/>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-jsp 
			name="controller" 
			path="/html/portlet/kiemdemvien/entry_action.jsp" 
			align="left"
		/>
		
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator 
		searchContainer="<%=searchContainer%>" 
		paginate="true" 
	/>
</liferay-ui:search-container>
		
<%!
	private static Log _log = LogFactoryUtil.getLog("html.portlet.kiemdemvien.view.jsp");
%>
<script type="text/javascript">

	AUI().ready(function(A){
		var capHoatDong = '<%= capHoatDong %>';
		var capHoatDongInput = A.one("#<portlet:namespace/>capHoatDong");
		
		var capTinhInput = A.one("#<portlet:namespace/>maTinh");
		var capHuyenInput = A.one("#<portlet:namespace/>maHuyen");
		var capTramInput = A.one("#<portlet:namespace/>maTram");
		
		capHoatDongInput.on('change', function(){
			var capTinhId = capTinhInput.val();
			var capHuyenId = capHuyenInput.val();
			var capTramId = capTramInput.val();
			
			selectHuyen(capTinhId, capHuyenId);
			selectTram(capTinhId, capTramId);
		});
		
		capTinhInput.on('change', function(){
			var capTinhId = capTinhInput.val();
			var capHuyenId = capHuyenInput.val();
			var capTramId = capTramInput.val();
			selectHuyen(capTinhId, capHuyenId);
			selectTram(capTinhId, capTramId);
		});
		
	});
	
	function selectHuyen(capTinhId, capHuyenId){
		AUI().use('aui-base','aui-io-request', function(A){
	
			//aui ajax call to get updated content
			A.io.request('<%= selectHuyen %>',
			{
				dataType: 'text/html',
				method: 'GET',
				data: { 
					"<portlet:namespace />capTinhId": capTinhId,
					"<portlet:namespace />capHuyenId": capHuyenId
				},
				on: {
					success: function() {
						var optHuyen = A.one("#optHuyen");
						optHuyen.set("innerHTML", this.get('responseData'));
					} 
				}
			});
		});
	}
	
	function selectTram(capTinhId, capTramId){
		AUI().use('aui-base','aui-io-request', function(A){
	
			//aui ajax call to get updated content
			A.io.request('<%= selectTram%>',
			{
				dataType: 'text/html',
				method: 'GET',
				data: { 
					"<portlet:namespace />capTinhId": capTinhId,
					"<portlet:namespace />capTramId": capTramId
				},
				on: {
					success: function() {
						var optHuyen = A.one("#optTram");
						optHuyen.set("innerHTML", this.get('responseData'));
					}
				}
			});
		});
	}

</script>
