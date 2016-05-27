<%@page import="vn.dtt.sol.ns.util.NuocSachUtils"%>
<%@page import="vn.dtt.sol.ns.daunoinuoc.constant.DauNoiNuocConstantString"%>
<%@page import="vn.dtt.sol.ns.business.UserMappingBusiness"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="vn.dtt.sol.ns.business.NavigationBusiness"%>
<%@page import="vn.dtt.cmon.dm.dao.model.NAVIGATION"%>

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

<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/init.jsp"%>

<%
	String urlRedirect = currentURL.substring(0, currentURL.lastIndexOf("/"));
	UserMapping loginUserMapping = UserMappingBusiness.getUserMapping(user);

	// userType cua nguoi dang nhap
	int userType = UserMappingBusiness.getUserType(user);
	//id xa huyen t/w
	String orgCodeChk = "";
	// userType dat cho user, bien nay co dinh dung de kiem tra viec hien thi
	int initUserType = userType;
	if(initUserType == DauNoiNuocConstantString.UserMapping.CAP_HUYEN){
		orgCodeChk = loginUserMapping.getOrgCode2();
	}else if(initUserType == DauNoiNuocConstantString.UserMapping.CAP_TINH){
		orgCodeChk = loginUserMapping.getOrgCode1();
	}else if(initUserType == DauNoiNuocConstantString.UserMapping.CAP_TRAM){
		orgCodeChk = loginUserMapping.getOrgCode2();
	}else{
		orgCodeChk = "0";
	}
%>
<div class="nav_sub">
	<ul>
		<%
			List<NAVIGATION> listLeftMenu = new ArrayList<NAVIGATION>(NavigationBusiness.getLeftMenu(0, 1,currentURL,initUserType,0,orgCodeChk,""));
			String cssActive = "";
			for(NAVIGATION nav: listLeftMenu) {
				if(currentURL.contains(nav.getNavSub())) {
					cssActive = "nt active2";
				}else{
					cssActive = "nt";
				}
		%>
				<li class=" <%= cssActive %>"><a href='<%=urlRedirect+nav.getNavSub() %>'><span class="numnav"><%=Validator.isNotNull(nav.getThongKe())? NuocSachUtils.formatNumber( Integer.parseInt(nav.getThongKe())):String.valueOf(0) %></span><liferay-ui:message key="<%=nav.getName() %>"></liferay-ui:message> </a></li>
		<%
			}
		%>
	</ul>
</div>

<%!
	private static Log _log = LogFactoryUtil
			.getLog("html.portlet.navigation.view.jsp");%>