<%@page import="org.apache.jasper.tagplugins.jstl.core.Param"%>
<%@page import="vn.dtt.cmon.user.action.UserMappingAction"%>
<%@page import="vn.dtt.sol.ns.business.UserMappingBusiness"%>
<%@page import="vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc"%>
<%@page import="vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.security.membershippolicy.RoleMembershipPolicyUtil"%>
<%@page import="vn.dtt.sol.ns.util.PortletKeys"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="vn.dtt.sol.ns.util.PortletPropsValues"%>
<%@page import="vn.dtt.sol.ns.util.MessageErrors"%>
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

<%@include file="/init.jsp" %>

<%
	List<DATAITEM> listTinh = DATAITEMLocalServiceUtil.getByDataGroupLevel1(1);
	
	List<DATAITEM> listHuyen = new ArrayList<DATAITEM>();
		 
	String selCapHuyen = ParamUtil.getString(request, "capHuyen");

	String selCapTram = ParamUtil.getString(request, "capTram");

	int userType = UserMappingBusiness.getUserType(user);
%>

<portlet:resourceURL var="callResourceURL" id="searchType2">
	<portlet:param name="mvcPath" value="/html/portlet/usermapping/_blank.jsp"/>
</portlet:resourceURL>

<liferay-portlet:renderURL varImpl="userSearchURL">
	<portlet:param name="mvcPath" value="/html/portlet/usermapping/view.jsp"/>
</liferay-portlet:renderURL>

<aui:field-wrapper cssClass="search-form">
	<aui:form action="<%= userSearchURL %>" method="post" name="fm">
		<aui:row cssClass="row-search">
				<aui:col width="20">
					<aui:input name="keyword" cssClass="search-ip"/>
				</aui:col>
				<aui:col width="20">
					<aui:select name="userType" id="userType" showEmptyOption="<%= true %>" helpMessage="gioi-thieu-cach-chon-cap">
						<aui:option value="1" selected='<%= userType == 1 %>'><liferay-ui:message key="cap-trung-uong"/></aui:option>
						<aui:option value="2" selected='<%= userType == 2 %>'><liferay-ui:message key="cap-tinh"/></aui:option>
						<aui:option value="3" selected='<%= userType == 3 %>'><liferay-ui:message key="cap-huyen"/></aui:option>
						<aui:option value="4" selected='<%= userType == 4 %>'><liferay-ui:message key="cap-tram-cap"/></aui:option>
					</aui:select>
				</aui:col>
				<aui:col width="20" id="formCapTinh">
					<aui:select name="capTinh" showEmptyOption="<%= true %>" id="capTinh" inlineField="<%= true %>">
						<%
							for (DATAITEM tinh : listTinh) {
						%>
							<aui:option value="<%= tinh.getNode1() %>"><%= tinh.getName() %></aui:option>
						<%
							}
						%>
					</aui:select>
				</aui:col>
				<aui:col width="20" id="formCapHuyen">
					<aui:select name="capHuyen" id="capHuyen" showEmptyOption="<%= true %>" inlineField="<%= true %>">
					</aui:select>
				</aui:col>
				<aui:col width="20" id="formCapTram">
					<aui:select name="capTram" id="capTram" showEmptyOption="<%= true %>" inlineField="<%= true %>">
					</aui:select>
				</aui:col>
				<aui:col width="20">
					<div class="filter-bnt">
						<aui:button name="search" type="submit" value="search"/>
					</div>
				</aui:col>
		</aui:row>
	</aui:form>
</aui:field-wrapper>

<style>
<!--
.field.search-ip {
    width: 150px !important;
}
.filter-bnt {
    margin-top: 20px;
}

.row-search {
	margin-top: 10px;
}
-->
</style>

<script type="text/javascript">
	AUI().ready(function(A){
		// gia tri khoi tao cua UserType
		var userType = '<%= userType %>';
		var userTypeInput = A.one("#<portlet:namespace/>userType");
		var capTinhInput = A.one("#<portlet:namespace/>capTinh");

		// khi userType co gi tri, formSearch hien thi theo userType nay 
		if (userTypeInput.val() != '0') {
			userType = userTypeInput.val();
		}
		
		<portlet:namespace/>loadingSearchForm(userType);

		ajaxRequest(capTinhInput.val(), userTypeInput.val());

		capTinhInput.on('change', function(){
			var capTinhId = capTinhInput.val();
			var userTypeId = userTypeInput.val();
			ajaxRequest(capTinhId, userTypeId);
		});
		
		userTypeInput.on('change', function(){
			var value = userTypeInput.val();
			<portlet:namespace />loadingSearchForm(value);
		});
	});
	
	function ajaxRequest(capTinhId, userTypeId){
		AUI().use('aui-base','aui-io-request', function(A){
			//aui ajax call to get updated content
			A.io.request('<%= callResourceURL %>',
			{
				dataType: 'json',
				method: 'GET',
				data: { 
					"<portlet:namespace />capTinhId": capTinhId,
					"<portlet:namespace />userType": userTypeId
				},
				on: {
					success: function() {
						var data = this.get('responseData');
						if (userTypeId == '3') {
							document.<portlet:namespace />fm.<portlet:namespace/>capHuyen.options.length=0;
							
							A.Array.each(data, function(obj, index){
								
								// kiem tra truong hop da select
								if (obj.idHuyen == '<%= selCapHuyen %>') {
									document.<portlet:namespace />fm.<portlet:namespace />capHuyen.options[index+1] = new Option(obj.nameHuyen, obj.idHuyen, false, true);
								} else {
									document.<portlet:namespace />fm.<portlet:namespace />capHuyen.options[index+1] = new Option(obj.nameHuyen,obj.idHuyen);					
								}
							});
							
						} else {
							document.<portlet:namespace />fm.<portlet:namespace/>capTram.options.length=0;
							
							A.Array.each(data, function(obj, index){
								if (obj.idTramCap == '<%= selCapTram %>') {
									document.<portlet:namespace />fm.<portlet:namespace />capTram.options[index+1] = new Option(obj.nameTramCap,obj.idTramCap,false, true);
								} else {
									document.<portlet:namespace />fm.<portlet:namespace />capTram.options[index+1] = new Option(obj.nameTramCap,obj.idTramCap);									
								}
							});
						}
					}
				}
			});
		});
	}

	Liferay.provide(window, '<portlet:namespace/>loadingSearchForm',

	function(value) {
		var A = AUI();

		var capTinh = A.one('#<portlet:namespace/>formCapTinh');
		var capHuyen = A.one('#<portlet:namespace/>formCapHuyen');
		var capTramCap = A.one('#<portlet:namespace/>formCapTram');

		if (value == '2') {
			capTinh.show();
			capHuyen.hide();
			capTramCap.hide();
		} else if (value == '3') {
			capTinh.show();
			capHuyen.show();
			capTramCap.hide();
		} else if (value == '4') {
			capTinh.show();
			capHuyen.hide();
			capTramCap.show();
		} else {
			capTinh.hide();
			capHuyen.hide();
			capTramCap.hide();
		}
	});
</script>
