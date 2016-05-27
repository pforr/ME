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

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ include file="/html/portlet/asset_publisher/init.jsp" %>

<%
int countAssetEntry = (Integer)request.getAttribute("view.countAssetEntry");
List results = (List)request.getAttribute("view.jsp-results");

int assetEntryIndex = ((Integer)request.getAttribute("view.jsp-assetEntryIndex")).intValue();

AssetEntry assetEntry = (AssetEntry)request.getAttribute("view.jsp-assetEntry");
AssetRendererFactory assetRendererFactory = (AssetRendererFactory)request.getAttribute("view.jsp-assetRendererFactory");
AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");

boolean show = ((Boolean)request.getAttribute("view.jsp-show")).booleanValue();

request.setAttribute("view.jsp-showIconLabel", true);

String title = (String)request.getAttribute("view.jsp-title");

if (Validator.isNull(title)) {
	title = assetRenderer.getTitle(locale);
}

PortletURL viewFullContentURL = liferayPortletResponse.createLiferayPortletURL(plid, portletDisplay.getId(), PortletRequest.RENDER_PHASE, true);

viewFullContentURL.setParameter("struts_action", "/asset_publisher/view_content");
//viewFullContentURL.setParameter("redirect", currentURL);
viewFullContentURL.setParameter("assetEntryId", String.valueOf(assetEntry.getEntryId()));
viewFullContentURL.setParameter("type", assetRendererFactory.getType());

if (Validator.isNotNull(assetRenderer.getUrlTitle())) {
	if (assetRenderer.getGroupId() != scopeGroupId) {
		viewFullContentURL.setParameter("groupId", String.valueOf(assetRenderer.getGroupId()));
	}

	viewFullContentURL.setParameter("urlTitle", assetRenderer.getUrlTitle());
}

String summary = StringUtil.shorten(HtmlUtil.stripHtml(StringUtil.replace(assetRenderer.getSummary(locale), "&nbsp;", "")), abstractLength);

String viewURL = null;

if (viewInContext) {
	String viewFullContentURLString = viewFullContentURL.toString();

	viewFullContentURLString = HttpUtil.setParameter(viewFullContentURLString, "redirect", currentURL);

	viewURL = assetRenderer.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, viewFullContentURLString);
}
else {
	viewURL = viewFullContentURL.toString();
}

if (Validator.isNull(viewURL)) {
	viewURL = viewFullContentURL.toString();
}

String viewURLMessage = viewInContext ? assetRenderer.getViewInContextMessage() : "read-more-x-about-x";

//viewURL = _checkViewURL(assetEntry, viewInContext, viewURL, currentURL, themeDisplay);
%>

<c:if test="<%= show %>">
	<div class="asset-bounddary">
	<div class="asset-abstract <%= defaultAssetPublisher ? "default-asset-publisher" : StringPool.BLANK %>">
		<div class="asset_actions_custom_style"><liferay-util:include page="/html/portlet/asset_publisher/asset_actions.jsp" /></div>
		<c:choose>
			<c:when test="<%=countAssetEntry == 0 && focusTopNews %>">
				<div class="asset-content focus-news">
					
					<%
						String path = assetRenderer.render(renderRequest, renderResponse, AssetRenderer.TEMPLATE_ABSTRACT);
						
						request.setAttribute(WebKeys.ASSET_RENDERER, assetRenderer);
						request.setAttribute(WebKeys.ASSET_PUBLISHER_ABSTRACT_LENGTH, abstractLength);
						request.setAttribute(WebKeys.ASSET_PUBLISHER_VIEW_URL, viewURL);
					%>
		
					<liferay-util:include page="<%= path %>" portletId="<%= assetRendererFactory.getPortletId() %>">
						<liferay-util:param name="countAssetEntry" value="<%=String.valueOf(countAssetEntry) %>"/>
					</liferay-util:include>
					<div class="asset-right-content">
						<h3 class="asset-title">
							<c:choose>
								<c:when test="<%= Validator.isNotNull(viewURL) %>">
									<a href="<%= viewURL %>"><%= HtmlUtil.escape(title) %></a>
								</c:when>
								<c:otherwise>
									<%= HtmlUtil.escape(title) %>
								</c:otherwise>
							</c:choose>
							
						</h3>
						<div class="asset-desc">
							<%= summary %>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="asset-content normal-news">
				<div class="asset-image">
					<%
						String smallImagePath = assetRenderer.getThumbnailPath(renderRequest);
					%>
					<a href="<%=viewURL%>"><img src="<%=smallImagePath%>" alt=""/></a>
				</div>
				
				<div class="asset-content-custom">
					<h3 class="asset-title">
						<c:choose>
							<c:when test="<%= Validator.isNotNull(viewURL) %>">
								<a href="<%= viewURL %>"><%= HtmlUtil.escape(title) %></a>
							</c:when>
							<c:otherwise>
								<%= HtmlUtil.escape(title) %>
							</c:otherwise>
						</c:choose>
					</h3>
					<div class="asset-summary">
	
						<%= summary %>

					</div>
		
					<%-- <c:if test="<%= Validator.isNotNull(viewURL) %>">
						<div class="asset-more">
							<a href="<%= viewURL %>"><liferay-ui:message arguments='<%= new Object[] {"hide-accessible", HtmlUtil.escape(assetRenderer.getTitle(locale))} %>' key="<%= viewURLMessage %>" /> &raquo; </a>
						</div>
					</c:if> --%>
				</div>
				</div>
			</c:otherwise>
		</c:choose>
		

		<div class="asset-metadata">
			<%@ include file="/html/portlet/asset_publisher/asset_metadata.jspf" %>
		</div>
	</div>
	</div>
</c:if>