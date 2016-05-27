
<%@page import="vn.dtt.sol.ns.tramcap.business.TramCapBusiness"%>
<%@page import="vn.dtt.cmon.user.dao.service.UserMappingLocalServiceUtil"%>
<%@page import="vn.dtt.sol.ns.business.UserMappingBusiness"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil"%>
<%@page import="vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@page import="vn.dtt.sol.ns.util.NuocSachUtils"%>
<%@page import="vn.dtt.sol.ns.kehoachdaunam.dao.service.KeHoachDauNamLocalServiceUtil"%>
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

<%
	String backURL = ParamUtil.getString(request, "backURL");
	String maTinhInit = StringPool.BLANK;
	String maTramInit = StringPool.BLANK;
	long userMappingId = ParamUtil.getLong(request, "userMappingId");
	//maTinhInit = StringPool.BLANK;
		 
	List<DATAITEM> listTinh = DATAITEMLocalServiceUtil.getByDataGroupLevel1(1);
		
	List<TramCapNuoc> listTramCap = new ArrayList<TramCapNuoc>();
	
	UserMapping userMapping = UserMappingLocalServiceUtil.getUserMapping(userMappingId);
	
	int userType = userMapping.getUserType();
	
	maTinhInit = userMapping.getOrgCode1();
	if(userType==2){
		listTramCap = TramCapBusiness.getByTinh(maTinhInit);
	}
%>

<%@include file="/init.jsp"%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title="them-ke-hoach-dau-nam"
/>

<portlet:renderURL var="selectTram" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/html/portlet/kehoachdaunam/_select_tramcap.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="addKeHoachNuocSach" var="addKeHoachNuocSachURL"/>
<aui:form action="<%=addKeHoachNuocSachURL %>" method="POST" name="fm">
	<aui:input name="redirect" type="hidden" value="<%=StringPool.BLANK %>"></aui:input>
	<aui:input name="userId" type="hidden" value="<%=PortalUtil.getUserId(request) %>"></aui:input>
	<c:if test="<%=!(maTinhInit.equals(StringPool.BLANK))&&(userType==2) %>">
	<aui:input name="maTinh" type="hidden" value="<%=maTinhInit %>"></aui:input>
	</c:if>
	<aui:field-wrapper>
		<aui:row>
			<aui:select 
				name="namSelect" 
				label="nam-label" 
				id="nam" 
				showEmptyOption="<%= false %>" 
				required="true"
			>
				<aui:option value=""><liferay-ui:message key="-chon-"></liferay-ui:message></aui:option>
				<aui:option value="<%=2013 %>">2013</aui:option>
				<aui:option value="<%=2014 %>">2014</aui:option>
				<aui:option value="<%=2015 %>">2015</aui:option>
			</aui:select>
		</aui:row>
		
		<aui:row>
			<aui:select 
				name="maTinh" 
				label="tinh-tp"
				id="maTinh" 
				showEmptyOption="<%= false %>"
				required="true"
				disabled="<%=(userType==1)? false:true%>"
			>
				<c:if test="<%=!(maTinhInit.equals(StringPool.BLANK))&&(userType==2) %>">
				<aui:option value="<%=maTinhInit %>" selected="true"><%=NuocSachUtils.getNameTinh(maTinhInit) %></aui:option>
				</c:if>
				<aui:option value=""><liferay-ui:message key="-chon-"></liferay-ui:message></aui:option>
				<%
					for (DATAITEM tinh : listTinh) {
				%>
					<aui:option value="<%= tinh.getNode1() %>"><%= tinh.getName() %></aui:option>
				<%
					}
				%>
			</aui:select>
		</aui:row>
		
		<aui:row>
			<div id="optTram">
				<aui:select 
					name="maTram" 
					label="ma-tram"
					id="maTram" 
					showEmptyOption="<%= false %>"
					required="true"
				>
					<aui:option value=""><liferay-ui:message key="-chon-"></liferay-ui:message></aui:option>
					<%
						for (TramCapNuoc tramCap : listTramCap) {
					%>
						<aui:option value="<%= tramCap.getId() %>"><%= tramCap.getTenTram() %></aui:option>
					<%
						}
					%>
				</aui:select>
			</div>
		</aui:row>
		
		<aui:row>
			<aui:input 
				name="soDauNoiMoi" 
				label="tong-dau-noi-xay-moi" 
				cssClass="lfr-input-text"
			>
				<aui:validator name="required" />
				<aui:validator name="digits"></aui:validator>
			</aui:input>
		</aui:row>
		
		<aui:row>
			<aui:input 
				name="soHoHuongLoi" 
				label="so-ho-cap-nuoc-du-kien" 
				cssClass="lfr-input-text"
			>
				<aui:validator name="required" />
				<aui:validator name="digits"></aui:validator>
			</aui:input>
		</aui:row>
		
		<aui:row>
			<aui:input 
				name="soNguoiHuongLoi" 
				label="so-nguoi-cap-nuoc-du-kien" 
				cssClass="lfr-input-text"
			>
				<aui:validator name="required" />
				<aui:validator name="digits"></aui:validator>
			</aui:input>
		</aui:row>
		
		<aui:row>
			<aui:input 
				name="ghiChu" 
				label="ghi-chu" 
				cssClass="lfr-input-text"
			>
			</aui:input>
		</aui:row>
		
		<aui:row>
			<aui:button-row>
				<aui:button type="submit" value="save"/>
				<aui:button href="<%=redirect %>" name="cancel" type="cancel" />
			</aui:button-row>
		</aui:row>
		
	</aui:field-wrapper>
	
</aui:form>

<script type="text/javascript">

	AUI().ready(function(A){
		var capTinhInput = A.one("#<portlet:namespace/>maTinh");
		var capTramInput = A.one("#<portlet:namespace/>maTram");
		
		capTinhInput.on('change', function(){
			var capTinhId = capTinhInput.val();
			var capTramId = capTramInput.val();
		
			selectTram(capTinhId, capTramId);
		});
		
	});
	
	function selectTram(capTinhId, capTramId){
		AUI().use('aui-base','aui-io-request', function(A){
	
			//aui ajax call to get updated content
			A.io.request('<%= selectTram %>',
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