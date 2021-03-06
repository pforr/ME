<%@page import="vn.dtt.sol.ns.business.DataItemBusiness"%>
<%@page import="vn.dtt.sol.ns.util.NuocSachUtils"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="vn.dtt.sol.ns.util.DiaBanQuanLyUtils"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
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

<%@include file="../init.jsp" %>

<%
	// Ma tinh truyen vao voi nguoi dung cap Tinh
	String maTinh = ParamUtil.getString(request, "maTinh");
	
	// Danh sach cac huyen duoc phan quan ly
	List<DATAITEM> lsHuyenQLy = DiaBanQuanLyUtils.getListHuyenGS(user, maTinh,  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		 
	UserMapping userMapping = (UserMapping) renderRequest.getAttribute("userMapping");
	
	
	List<DATAITEM> lsHuyenDaChon = new ArrayList<DATAITEM>();
	long selUserId = 0;
	
	if (Validator.isNotNull(userMapping)) {
		selUserId = userMapping.getUserId(); 
		
		lsHuyenDaChon =  DiaBanQuanLyUtils.findHuyenChonByUser(maTinh, selUserId,  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
%>


<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "userhuyen/dia_ban_qly.jsp" %>'/>
</liferay-portlet:renderURL>

<div class="header-um">
	<liferay-ui:message key="chon-dia-ban-quan-ly"/>
</div>

<aui:form action="<%= searchURL %>" method="get" name="fm2">
	
	<liferay-portlet:renderURLParams varImpl="searchURL" />
		
	<aui:fieldset>
		
		<liferay-ui:search-container rowChecker="<%= new RowChecker(renderResponse) %>" delta="<%= 100 %>" emptyResultsMessage="no-result-were-found" iteratorURL="<%= searchURL %>">
			
			<liferay-ui:search-container-results results="<%= DiaBanQuanLyUtils.getListHuyenGS(user, maTinh, searchContainer.getStart(), searchContainer.getEnd()) %>"
								 total="<%= DiaBanQuanLyUtils.countHuyenByUser(user, maTinh) %>">

			</liferay-ui:search-container-results>

			<liferay-ui:search-container-row
	 			className="vn.dtt.cmon.dm.dao.model.DATAITEM"
				keyProperty="node2"
				modelVar="huyen"
			>
			
				<liferay-ui:search-container-column-text
					name="ten-huyen"
					align="left"
					cssClass="col-small"
				>

					<liferay-ui:panel collapsible="<%= true %>" extended="<%= false %>" persistState="<%= true %>" title="<%= huyen.getName() %>" helpMessage="neu-khong-chon-theo-xa-mac-dinh-quan-ly-toan-huyen" >
						
						<aui:fieldset>
							<liferay-util:include page="/html/portlet/usermapping/userhuyen/render_xa.jsp" servletContext="<%= application %>" >
								<liferay-util:param name="maTinh" value="<%= maTinh %>" />
								<liferay-util:param name="maHuyen" value="<%= huyen.getNode2() %>" />
								<liferay-util:param name="userIdSel" value="<%= Long.toString(selUserId) %>" />
							</liferay-util:include>
						</aui:fieldset>
					
					</liferay-ui:panel>
				</liferay-ui:search-container-column-text>
				
			</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator paginate="simple" />

		</liferay-ui:search-container>
	</aui:fieldset>
</aui:form>

<c:if test="<%= Validator.isNotNull(userMapping) %>">
		<div class="header-um">
			<liferay-ui:message key="dia-ban-quan-ly-da-chon"/> 
		</div>
		
		<div class="dia-ban-table">
			<table>
				<%
					for (DATAITEM huyen : lsHuyenDaChon) {
				%>
					<tr>
						<td style="width: 50px;">
							<aui:input name="selChuyenDel" type="checkbox" value="<%= huyen.getNode2() %>" label="<%= StringPool.BLANK %>"></aui:input>
						</td>
						
						<td>
							<liferay-ui:panel collapsible="<%= true %>" extended="<%= false %>" persistState="<%= true %>" title="<%= huyen.getName() %>" helpMessage="neu-khong-chon-theo-xa-mac-dinh-quan-ly-toan-huyen" >
								<aui:fieldset>
									<liferay-util:include page="/html/portlet/usermapping/userhuyen/render_xa_sel.jsp" servletContext="<%= application %>" >
										<liferay-util:param name="maTinh" value="<%= maTinh %>" />
										<liferay-util:param name="maHuyen" value="<%= huyen.getNode2() %>" />
										<liferay-util:param name="userIdSel" value="<%= Long.toString(selUserId) %>" />
									</liferay-util:include>
								</aui:fieldset>
							</liferay-ui:panel>
						</td>
					</tr>
				
				<%
					}
				%>
			</table>
			
		</div>
</c:if>