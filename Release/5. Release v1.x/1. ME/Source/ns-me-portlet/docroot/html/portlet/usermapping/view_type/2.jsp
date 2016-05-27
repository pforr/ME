<%@page import="vn.dtt.sol.ns.util.ActionKeys"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="vn.dtt.cmon.user.permission.UserNSPermission"%>
<%@page import="vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalServiceUtil"%>
<%@page import="vn.dtt.sol.ns.business.UserMappingBusiness"%>
<%@page import="vn.dtt.sol.ns.util.NuocSachUtils"%>
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
	String redirectURL = ParamUtil.getString(request, "backURL", currentURL);
	
	String maTinh = ParamUtil.getString(request, "maTinh");
		 
	UserMapping um = UserMappingBusiness.getByUserId(user.getUserId());
	
	if (Validator.isNull(maTinh) && Validator.isNotNull(um)) {
		maTinh = um.getOrgCode1();
	}
	
	String tenTinh = ParamUtil.getString(request, "tenTinh");

%>
<c:if test="<%= Validator.isNotNull(tenTinh) %>">
	<liferay-ui:header
		backURL="<%= redirectURL %>"
		title='<%= tenTinh %>'
	/>
</c:if>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "type_view/2.jsp" %>'/>
</liferay-portlet:renderURL>


<c:if test="<%= Validator.isNotNull(um) && um.getUserType() == 2 && UserNSPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADMIN_USER) %>">

	<liferay-ui:icon-menu direction="right" message="them-nguoi-dung">

		<liferay-portlet:renderURL var="addUserTinh">
			<portlet:param name="mvcPath" value='<%= templatePath + "addUserTinh.jsp" %>'/>
			<portlet:param name="backURL" value="<%= currentURL %>"/>
			<portlet:param name="maTinh" value="<%= maTinh %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-portlet:renderURL var="addUserHuyen">
			<portlet:param name="mvcPath" value='<%= templatePath + "addUserHuyen.jsp" %>'/>
			<portlet:param name="backURL" value="<%= currentURL %>"/>
			<portlet:param name="maTinh" value="<%= maTinh %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-portlet:renderURL var="addUserTramCap">
			<portlet:param name="backURL" value="<%= currentURL %>"/>
			<portlet:param name="mvcPath" value='<%= templatePath + "addUserTramCap.jsp" %>'/>
			<portlet:param name="maTinh" value="<%= maTinh %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-ui:icon
			image="add_user"
			message="add-user-tinh"
			url="<%= addUserTinh %>"/>
		
		<liferay-ui:icon
			image="join"
			message="add-user-huyen"
			url="<%= addUserHuyen %>"/>
		
		<liferay-ui:icon
			image="assign_user_group_roles"
			message="add-user-tram-cap"
			url="<%= addUserTramCap %>"/>
		
	</liferay-ui:icon-menu>
</c:if>

<c:if test="<%= UserNSPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADMIN_USER) %>">
	<liferay-ui:success key="them-thanh-cong-nguoi-su-dung" message="them-thanh-cong-nguoi-su-dung"/>
	<liferay-ui:success key="cap-nhat-thanh-cong-nguoi-su-dung" message="cap-nhat-thanh-cong-nguoi-su-dung"/>
	
	<div class="header-user">
		<liferay-ui:message key="danh-sach-nguoi-dung-cap-tinh"/>
	</div>
	
	<aui:form action="<%= searchURL %>" method="get" name="fm2">
		
		<liferay-portlet:renderURLParams varImpl="searchURL" />
			
		<aui:fieldset>
			<liferay-ui:search-container delta="<%= 100 %>" emptyResultsMessage="no-result-were-found">
				
				<liferay-ui:search-container-results results="<%= UserMappingBusiness.findUser(StringPool.BLANK, 2, maTinh, StringPool.BLANK, searchContainer.getStart(), searchContainer.getEnd()) %>"
									 total="<%= UserMappingBusiness.countUser(StringPool.BLANK, 2, maTinh, StringPool.BLANK) %>">
	
				</liferay-ui:search-container-results>
	
					<liferay-ui:search-container-row
			 			className="vn.dtt.cmon.user.dao.model.UserMapping"
						keyProperty="id"
						modelVar="usermapping"
					>
						<portlet:renderURL var="rowURL">
							<portlet:param name="mvcPath" value='<%= templatePath + "addUserTinh.jsp" %>' />
							<portlet:param name="userMappingId" value="<%= String.valueOf(usermapping.getId()) %>"/>
							<portlet:param name="maTinh" value="<%= maTinh %>"/>
							<portlet:param name="backURL" value="<%= currentURL %>"/>
						</portlet:renderURL>
						
						<liferay-ui:search-container-column-text
							name="name"
							href="<%= rowURL %>"
							property="name"
							cssClass="col-small"
						/>
						<liferay-ui:search-container-column-text
							name="tai-khoan"
							href="<%= rowURL %>"
							buffer="taikhoan"
							cssClass="col-small"
							
						>
							<%
								User userSys = null;
								try {
									userSys = UserLocalServiceUtil.fetchUser(usermapping.getUserId());
								} catch (Exception e) {
									
								}
								
								if (Validator.isNotNull(userSys)) {
									taikhoan = taikhoan.append(userSys.getScreenName());
								}
							%>
						</liferay-ui:search-container-column-text>
						
						<liferay-ui:search-container-column-text
							name="email"
							href="<%= rowURL %>"
							cssClass="col-small"
						>
							<%= NuocSachUtils.getEmailUser(usermapping) %>
						</liferay-ui:search-container-column-text>
						
						<liferay-ui:search-container-column-text
							name="quan-ly"
						>
							<ul>
								<%
									List<Role> selRoles = RoleLocalServiceUtil.getUserRoles(usermapping.getUserId());
									
									for (Role role : selRoles) {
								%>
									<c:if test='<%= !Validator.equals(role.getName(), "User") %>'>
										<li><%= role.getTitle(locale) %></li>
									</c:if>
								<%	
									}
								%>
							</ul>
						</liferay-ui:search-container-column-text>
						
					</liferay-ui:search-container-row>
			
				<liferay-ui:search-iterator paginate="simple" />
	
			</liferay-ui:search-container>
		</aui:fieldset>
	</aui:form>
</c:if>

<c:if test="<%= UserNSPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADMIN_USER) %>">

	<div class="header-user">
		<liferay-ui:message key="gsv-cap-tinh-vesinh"/>
	</div>
	
	<aui:form action="<%= searchURL %>" method="get" name="fm2">
		
		<liferay-portlet:renderURLParams varImpl="searchURL" />
			
		<aui:fieldset>
			<liferay-ui:search-container delta="<%= 100 %>" emptyResultsMessage="no-result-were-found">
				
				<liferay-ui:search-container-results results="<%= UserMappingBusiness.findUser(StringPool.BLANK, 3, maTinh, StringPool.BLANK, searchContainer.getStart(), searchContainer.getEnd()) %>"
									 total="<%= UserMappingBusiness.countUser(StringPool.BLANK, 3, maTinh, StringPool.BLANK) %>">
	
				</liferay-ui:search-container-results>
	
					<liferay-ui:search-container-row
			 			className="vn.dtt.cmon.user.dao.model.UserMapping"
						keyProperty="id"
						modelVar="usermapping"
					>
						<portlet:renderURL var="rowURL">
							<portlet:param name="mvcPath" value='<%= templatePath + "addUserHuyen.jsp" %>' />
							<portlet:param name="userMappingId" value="<%= String.valueOf(usermapping.getId()) %>"/>
							<portlet:param name="maTinh" value="<%= maTinh %>"/>
							<portlet:param name="backURL" value="<%= currentURL %>"/>
						</portlet:renderURL>
						
						<liferay-ui:search-container-column-text
							name="name"
							href="<%= rowURL %>"
							property="name"
							cssClass="col-small"
						/>
						<liferay-ui:search-container-column-text
							name="tai-khoan"
							href="<%= rowURL %>"
							buffer="taikhoan"
							cssClass="col-small"
							
						>
							<%
								User userSys = null;
								try {
									userSys = UserLocalServiceUtil.fetchUser(usermapping.getUserId());
								} catch (Exception e) {
									
								}
								
								if (Validator.isNotNull(userSys)) {
									taikhoan = taikhoan.append(userSys.getScreenName());
								}
							%>
						</liferay-ui:search-container-column-text>
						
						<liferay-ui:search-container-column-text
							name="email"
							href="<%= rowURL %>"
							cssClass="col-small"
						>
							<%= NuocSachUtils.getEmailUser(usermapping) %>
						</liferay-ui:search-container-column-text>
						
						<liferay-ui:search-container-column-text
							name="quan-ly"
						>
							<ul>
								<%
									List<Role> selRoles = RoleLocalServiceUtil.getUserRoles(usermapping.getUserId());
									
									for (Role role : selRoles) {
								%>
									<c:if test='<%= !Validator.equals(role.getName(), "User") %>'>
										<li><%= role.getTitle(locale) %></li>
									</c:if>
								<%	
									}
								%>
							</ul>
						</liferay-ui:search-container-column-text>
						
					</liferay-ui:search-container-row>
			
				<liferay-ui:search-iterator paginate="simple" />
	
			</liferay-ui:search-container>
		</aui:fieldset>
	</aui:form>
</c:if>

<c:if test="<%= UserNSPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADMIN_USER) %>">

	<div class="header-user">
		<liferay-ui:message key="gsv-cap-tinh-nuoc"/>
	</div>
	
	<aui:form action="<%= searchURL %>" method="get" name="fm2">
		
		<liferay-portlet:renderURLParams varImpl="searchURL" />
			
		<aui:fieldset>
			<liferay-ui:search-container delta="<%= 100 %>" emptyResultsMessage="no-result-were-found">
				
				<liferay-ui:search-container-results results="<%= UserMappingBusiness.findUser(StringPool.BLANK, 4, maTinh, StringPool.BLANK, searchContainer.getStart(), searchContainer.getEnd()) %>"
									 total="<%= UserMappingBusiness.countUser(StringPool.BLANK, 4, maTinh, StringPool.BLANK) %>">
	
				</liferay-ui:search-container-results>
	
					<liferay-ui:search-container-row
			 			className="vn.dtt.cmon.user.dao.model.UserMapping"
						keyProperty="id"
						modelVar="usermapping"
					>
						<portlet:renderURL var="rowURL">
							<portlet:param name="mvcPath" value='<%= templatePath + "addUserTramCap.jsp" %>' />
							<portlet:param name="userMappingId" value="<%= String.valueOf(usermapping.getId()) %>"/>
							<portlet:param name="maTinh" value="<%= maTinh %>"/>
							<portlet:param name="backURL" value="<%= currentURL %>"/>
						</portlet:renderURL>
						
						<liferay-ui:search-container-column-text
							name="name"
							href="<%= rowURL %>"
							property="name"
							cssClass="col-small"
						/>
						<liferay-ui:search-container-column-text
							name="tai-khoan"
							href="<%= rowURL %>"
							buffer="taikhoan"
							cssClass="col-small"
							
						>
							<%
								User userSys = null;
								try {
									userSys = UserLocalServiceUtil.fetchUser(usermapping.getUserId());
								} catch (Exception e) {
									
								}
								
								if (Validator.isNotNull(userSys)) {
									taikhoan = taikhoan.append(userSys.getScreenName());
								}
							%>
						</liferay-ui:search-container-column-text>
						
						<liferay-ui:search-container-column-text
							name="email"
							href="<%= rowURL %>"
							cssClass="col-small"
						>
							<%= NuocSachUtils.getEmailUser(usermapping) %>
						</liferay-ui:search-container-column-text>
						
						<liferay-ui:search-container-column-text
							name="quan-ly"
						>
							<ul>
								<%
									List<Role> selRoles = RoleLocalServiceUtil.getUserRoles(usermapping.getUserId());
									
									for (Role role : selRoles) {
								%>
									<c:if test='<%= !Validator.equals(role.getName(), "User") %>'>
										<li><%= role.getTitle(locale) %></li>
									</c:if>
								<%	
									}
								%>
							</ul>
						</liferay-ui:search-container-column-text>
						
					</liferay-ui:search-container-row>
			
				<liferay-ui:search-iterator paginate="simple" />
	
			</liferay-ui:search-container>
		</aui:fieldset>
	</aui:form>
</c:if>