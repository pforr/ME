<%@page import="vn.dtt.sol.ns.baocaodli.business.BaoCaoDLITongHopBusiness"%>
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
	BaoCaoDLIBusiness.initBaoCaoDLITongHop();
		 
	int userType = UserMappingBusiness.getUserType(user);
	
	UserMapping um = UserMappingBusiness.getUserMapping(user);
	
	String maTinh = um.getOrgCode1();
%>

<liferay-ui:success key="success-chot-bao-cao-thanh-cong" message="success-chot-bao-cao-thanh-cong"/>
<liferay-ui:success key="success-xoa-bao-cao-thanh-cong" message="success-xoa-bao-cao-thanh-cong"/>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>' />
</liferay-portlet:renderURL>

<%
%>
<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
				
			<aui:fieldset>
				<liferay-ui:search-container delta="20" emptyResultsMessage="no-result-were-found" 
					searchContainer="<%= new BaoCaoDLISearch(renderRequest, currentURLObj) %>">
					
					<liferay-ui:search-form
						page='<%= templatePath + "baocaodli_search.jsp" %>'
						servletContext="<%= application %>"
					/>
				
					<%
						BaoCaoDLIDisplayTerms searchTerms = (BaoCaoDLIDisplayTerms)searchContainer.getSearchTerms();
						final Log _log = LogFactoryUtil.getLog("html.portlet.baocaodli.view_dli_th.jsp");
						_log.info("--html.portlet.baocaodli.view_dli_th.jsp--"+searchTerms.getNam()+"==");
						
					%>
					
					<liferay-ui:search-container-results
						results="<%= BaoCaoDLITongHopBusiness.searchDLITH(userType, String.valueOf(searchTerms.getNam()) , maTinh, searchContainer.getStart(), searchContainer.getEnd())  %>"
						total="<%= BaoCaoDLITongHopBusiness.searchDLITH(userType, String.valueOf(searchTerms.getNam()) , maTinh, searchContainer.getStart(), searchContainer.getEnd()).size() %>"
					/>
		
					<liferay-ui:search-container-row
			 			className="vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHop"
						keyProperty="id"
						modelVar="baoCaoDLI"
					>
						<portlet:renderURL var="rowURL">
							<portlet:param name="mvcPath" value='<%= templatePath + "edit_baocaodli_th.jsp" %>' />
							<portlet:param name="baoCaoDLIId" value="<%=String.valueOf(baoCaoDLI.getId()) %>"/>
							<portlet:param name="redirect" value="<%= currentURL %>"/>
						</portlet:renderURL>
						
						<liferay-ui:search-container-column-text
							buffer="buffer"
							name="tinh-thanh-pho"
							href="<%=rowURL %>"
						>
							<%
							String tenTinh = NuocSachUtils.getNameTinh(baoCaoDLI.getMaTinh());
							
							buffer.append(HtmlUtil.escape(tenTinh));
							%>
						</liferay-ui:search-container-column-text>
						
						<liferay-ui:search-container-column-text
							buffer="buffer"
							name="nam-bao-cao"
						>
							<%
							buffer.append("<div class=\"text-center\">");
							buffer.append("<a href=\"" + rowURL +  "\">");
							buffer.append(baoCaoDLI.getNam());
							buffer.append("</a>");
							buffer.append("</div>");
							%>
						</liferay-ui:search-container-column-text>
		
						<liferay-ui:search-container-column-text
							href="<%=rowURL %>"
							name="trang-thai"
						>
							<c:choose>
								<c:when test="<%= baoCaoDLI.getTrangThai() == BaoCaoDLIConstants.TRANG_THAI_DANG_LAP %>">
									<liferay-ui:message key="dang-lap"/>
								</c:when>
								
								<c:when test="<%= baoCaoDLI.getTrangThai() == BaoCaoDLIConstants.TRANG_THAI_DA_CHOT %>">
									<liferay-ui:message key="da-luu-tru"/>
								</c:when>
							</c:choose>
						</liferay-ui:search-container-column-text>
						

			
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</aui:fieldset>
</aui:form>

<%!
	private static Log _log = LogFactoryUtil.getLog("html.portlet.baocaodli.view.jsp");
%>