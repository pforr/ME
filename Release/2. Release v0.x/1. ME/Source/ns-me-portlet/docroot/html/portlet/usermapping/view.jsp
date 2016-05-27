<%@page import="vn.dtt.sol.ns.tramcap.business.TramCapBusiness"%>
<%@page import="vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc"%>
<%@page import="vn.dtt.sol.ns.util.NuocSachUtils"%>
<%@page import="vn.dtt.sol.ns.util.ActionKeys"%>
<%@page import="vn.dtt.cmon.user.permission.UserMappingPermission"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="vn.dtt.cmon.user.action.UserMappingAction"%>
<%@page import="vn.dtt.sol.ns.business.UserMappingBusiness"%>
<%@page import="vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="com.liferay.portal.model.Contact"%>
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
	List<DATAITEM> listTinh = DATAITEMLocalServiceUtil.getByDataGroupLevel1(1);
	
	List<DATAITEM> listHuyen = new ArrayList<DATAITEM>();
	
	UserMapping loginUserMapping = UserMappingBusiness.getUserMapping(user);

	// userType cua nguoi dang nhap
	int userType = UserMappingBusiness.getUserType(user);
	
	// userType dat cho user, bien nay co dinh dung de kiem tra viec hien thi
	int initUserType = userType;
	
	String keyword = ParamUtil.getString(request, "keyword");
	
	int userTypeSearch = 0;
	
	String capTinhSearch = StringPool.BLANK;
	String capHuyenSearch = StringPool.BLANK;
	String capTramSearch = StringPool.BLANK;
	
	String orgCode1 = StringPool.BLANK;
	String orgCode2 = StringPool.BLANK;

	if (permissionChecker.isOmniadmin() || userType == 1) {
		// Neu dang nhap la Admin hoac cap tinh, hien thi full form tim kiem
		userTypeSearch = ParamUtil.getInteger(request, "userType");
		
		if (userTypeSearch == 1) {
			orgCode1 = StringPool.BLANK;
			orgCode2 = StringPool.BLANK;
		} else if (userTypeSearch == 2){
			orgCode1 = ParamUtil.getString(request, "capTinh");
			orgCode2 = StringPool.BLANK;
		} else if (userTypeSearch == 3) {
			orgCode1 = ParamUtil.getString(request, "capTinh");
			orgCode2 = ParamUtil.getString(request, "capHuyen");
		} else if (userTypeSearch == 4) {
			orgCode1 = ParamUtil.getString(request, "capTinh");
			orgCode2 = ParamUtil.getString(request, "capTram");
		}
	} else if (userType == 2){
		// Neu dang nhap la cap Tinh, loc theo tram hoac huyen
		userTypeSearch = ParamUtil.getInteger(request, "userType");
		
		if (userTypeSearch == 0) {
			userTypeSearch = loginUserMapping.getUserType();
		}
		
		orgCode1 = loginUserMapping.getOrgCode1();
		
		if (userTypeSearch == 3) {
			orgCode2 = ParamUtil.getString(request, "capHuyen");
		} else if (userTypeSearch == 4) {
			orgCode2 = ParamUtil.getString(request, "capTram");
		}
	}
	
%>

<c:if test="<%= UserMappingPermission.contains(permissionChecker, scopeGroupId, ActionKeys.PERMISSIONS) %>">
	<aui:button-row cssClass="bnt-add-entry" >
		<liferay-security:permissionsURL
			modelResource="vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc"
			modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
			resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
			var="permissionsURL"
		/>
	
		<aui:button href="<%= permissionsURL %>" value="nuocsach-permissions" />
	</aui:button-row>
</c:if>



<c:choose>
	<c:when test="<%= initUserType == 1 || permissionChecker.isOmniadmin() %>">
		<liferay-util:include page="/html/portlet/usermapping/search/user_type_1.jsp" servletContext="<%=this.getServletContext() %>" />
	</c:when>
	
	<c:when test="<%= initUserType == 2 %>">
		<liferay-util:include page="/html/portlet/usermapping/search/user_type_2.jsp" servletContext="<%= application %>" />
	</c:when>
</c:choose>

<c:if test="<%= UserMappingPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADMIN_NGUOIDUNG) %>">
	<aui:button-row cssClass="bnt-add-entry">
		<portlet:renderURL var="editEntryURL">
			<portlet:param name="mvcPath" value='<%= "/html/portlet/usermapping/add_user.jsp" %>' />
			<portlet:param name="redirect" value="<%= currentURL %>"/>
		</portlet:renderURL>
		
		<aui:button href="<%= editEntryURL %>" value="add-user" cssClass="btn-primary"></aui:button>
	</aui:button-row>
	
	<liferay-ui:icon-menu direction="right" message="them-nguoi-dung" icon="add">
		<liferay-portlet:renderURL var="addUserTU">
			<portlet:param name="mvcPath" value="/html/portlet/usermapping/addUserTU.jsp"/>
			<portlet:param name="backURL" value="<%= currentURL %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-portlet:renderURL var="addUserTinh">
			<portlet:param name="mvcPath" value="/html/portlet/usermapping/addUserTinh.jsp"/>
			<portlet:param name="backURL" value="<%= currentURL %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-portlet:renderURL var="addUserHuyen">
			<portlet:param name="mvcPath" value="/html/portlet/usermapping/addUserHuyen.jsp"/>
			<portlet:param name="backURL" value="<%= currentURL %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-portlet:renderURL var="addUserTramCap">
			<portlet:param name="backURL" value="<%= currentURL %>"/>
			<portlet:param name="mvcPath" value="/html/portlet/usermapping/addUserTramCap.jsp"/>
		</liferay-portlet:renderURL>
		
		<liferay-ui:icon
			image="add"
			message="add-user-tu"
			url="<%= addUserTU %>"/>
		
		<liferay-ui:icon
			image="add"
			message="add-user-tinh"
			url="<%= addUserTinh %>"/>
		
		<liferay-ui:icon
			image="add"
			message="add-user-huyen"
			url="<%= addUserHuyen %>"/>
		
		<liferay-ui:icon
			image="add"
			message="add-user-tram-cap"
			url="<%= addUserTramCap %>"/>
		
	</liferay-ui:icon-menu>
</c:if>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/html/portlet/usermapping/view.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm2">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
		
	<aui:fieldset>
		<liferay-ui:search-container delta="15" emptyResultsMessage="no-result-were-found">
			<liferay-ui:search-container-results
				results="<%= UserMappingBusiness.findUser(keyword, userTypeSearch, orgCode1, orgCode2, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%= UserMappingBusiness.countUser(keyword, userTypeSearch, orgCode1, orgCode2) %>"
		/>

			<liferay-ui:search-container-row
	 			className="vn.dtt.cmon.user.dao.model.UserMapping"
				keyProperty="id"
				modelVar="usermapping"
			>
				<portlet:renderURL var="rowURL">
					<portlet:param name="mvcPath" value="/html/portlet/usermapping/add_user.jsp" />
					<portlet:param name="id" value="<%= String.valueOf(usermapping.getId()) %>"/>
					<portlet:param name="currentURL" value="<%= currentURL %>"/>
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text
					name="name"
					href="<%= rowURL %>"
					property="name"
					cssClass="um-col-name"
				/>
				
				<liferay-ui:search-container-column-text
					name="email"
					href="<%= rowURL %>"
					cssClass="um-col-email"
				>
					<%= NuocSachUtils.getEmailUser(usermapping) %>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					name="usertype"
					href="<%= rowURL %>"
					cssClass="um-col-usertype"
				>
					<liferay-ui:message key='<%= "cap-don-vi-" + usermapping.getUserType() %>'/>
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text
					name="tinh"
					href="<%= rowURL %>"
					cssClass="um-col-province"
				>
					<%
						NuocSachUtils nuocSachUtil = new NuocSachUtils();
						String userOrgCode1 = usermapping.getOrgCode1();
					%>
					
					<%= nuocSachUtil.getNameTinh(userOrgCode1) %> 
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					name="huyen"
					href="<%= rowURL %>"
					cssClass="um-col-district"
				>
					<%
						NuocSachUtils nuocSachUtil = new NuocSachUtils();
						
						String userOrgCode1 = usermapping.getOrgCode1();
		
						String userOrgCode2 = usermapping.getOrgCode2();
					%>
					<c:if test="<%= !userOrgCode2.trim().isEmpty() && !userOrgCode1.trim().isEmpty()%>">
						<%= nuocSachUtil.getNameHuyen(userOrgCode1, userOrgCode2) %>
					</c:if>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					name="tramcap"
					href="<%= rowURL %>"
					buffer="buffer"
					cssClass="um-col-district"
				>
						<c:if test="<%= usermapping.getUserType() == 4 %>">
							<%
								TramCapNuoc tramCap = TramCapBusiness.getTramCap(Long.parseLong(usermapping.getOrgCode2()));
								
								if(Validator.isNotNull(tramCap)) 
									buffer = buffer.append(tramCap.getTenTram());
								else 
									buffer = buffer.append("-");
							%>
						
						</c:if>

				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator />

		</liferay-ui:search-container>
	</aui:fieldset>
</aui:form>

<%!
	private static Log _log = LogFactoryUtil.getLog("html.portlet.usermapping.view.jsp");
%>