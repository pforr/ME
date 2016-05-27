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

<%@ include file="/html/portlet/asset_publisher/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

List results = (List)request.getAttribute("view.jsp-results");

if (Validator.isNull(redirect) && results.isEmpty()) {
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("struts_action", "/asset_publisher/view");

	redirect = portletURL.toString();
}

int assetEntryIndex = ((Integer)request.getAttribute("view.jsp-assetEntryIndex")).intValue();

AssetEntry assetEntry = (AssetEntry)request.getAttribute("view.jsp-assetEntry");
AssetRendererFactory assetRendererFactory = (AssetRendererFactory)request.getAttribute("view.jsp-assetRendererFactory");
AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");

String languageId = LanguageUtil.getLanguageId(request);

String title = assetRenderer.getTitle(LocaleUtil.fromLanguageId(languageId));

boolean show = ((Boolean)request.getAttribute("view.jsp-show")).booleanValue();
boolean print = ((Boolean)request.getAttribute("view.jsp-print")).booleanValue();

request.setAttribute(WebKeys.LAYOUT_ASSET_ENTRY, assetEntry);

request.setAttribute("view.jsp-fullContentRedirect", currentURL);
request.setAttribute("view.jsp-showIconLabel", true);

assetEntryQuery.setEnablePermissions(false);
%>

<div class="asset-full-content-title"><%= title %></div>

<div class="asset-full-content <%= defaultAssetPublisher ? "default-asset-publisher" : StringPool.BLANK %> <%= showAssetTitle ? "show-asset-title" : "no-title" %>">
	<c:if test="<%= !print %>">
		<liferay-util:include page="/html/portlet/asset_publisher/asset_actions.jsp" />
	</c:if>

	

	<%

	// Dynamically created asset entries are never persisted so incrementing the view counter breaks

	if (!assetEntry.isNew() && assetEntry.isVisible()) {
		AssetEntry incrementAssetEntry = null;

		if (assetEntryQuery.isEnablePermissions()) {
			incrementAssetEntry = AssetEntryServiceUtil.incrementViewCounter(assetEntry.getClassName(), assetEntry.getClassPK());
		}
		else {
			incrementAssetEntry = AssetEntryLocalServiceUtil.incrementViewCounter(user.getUserId(), assetEntry.getClassName(), assetEntry.getClassPK());
		}

		if (incrementAssetEntry != null) {
			assetEntry = incrementAssetEntry;
		}
	}

	if (showContextLink) {
		if (PortalUtil.getPlidFromPortletId(assetRenderer.getGroupId(), assetRendererFactory.getPortletId()) == 0) {
			showContextLink = false;
		}
	}

	PortletURL viewFullContentURL = renderResponse.createRenderURL();

	viewFullContentURL.setParameter("struts_action", "/asset_publisher/view_content");
	viewFullContentURL.setParameter("type", assetRendererFactory.getType());
	viewFullContentURL.setParameter("viewMode", print ? Constants.PRINT : Constants.VIEW);

	if (Validator.isNotNull(assetRenderer.getUrlTitle())) {
		if (assetRenderer.getGroupId() != scopeGroupId) {
			viewFullContentURL.setParameter("groupId", String.valueOf(assetRenderer.getGroupId()));
		}

		viewFullContentURL.setParameter("urlTitle", assetRenderer.getUrlTitle());
	}

	String viewFullContentURLString = viewFullContentURL.toString();

	viewFullContentURLString = HttpUtil.setParameter(viewFullContentURLString, "redirect", currentURL);
	%>

	<div class="asset-content" id="<portlet:namespace /><%= assetEntry.getEntryId() %>">
		<c:if test='<%= enableSocialBookmarks && socialBookmarksDisplayPosition.equals("top") && !print %>'>
			<liferay-ui:social-bookmarks
				contentId="<%= String.valueOf(assetEntry.getEntryId()) %>"
				displayStyle="<%= socialBookmarksDisplayStyle %>"
				target="_blank"
				title="<%= title %>"
				url="<%= PortalUtil.getCanonicalURL(viewFullContentURL.toString(), themeDisplay, layout) %>"
			/>
		</c:if>

		<%
		String path = assetRenderer.render(renderRequest, renderResponse, AssetRenderer.TEMPLATE_FULL_CONTENT);

		request.setAttribute(WebKeys.ASSET_RENDERER_FACTORY, assetRendererFactory);
		request.setAttribute(WebKeys.ASSET_RENDERER, assetRenderer);
		
		%>

		<liferay-util:include page="<%= path %>" portletId="<%= assetRendererFactory.getPortletId() %>">
			<liferay-util:param name="showHeader" value="<%= Boolean.FALSE.toString() %>" />
		</liferay-util:include>
		<span class="back-history"><a href="javascript:goBack();"><liferay-ui:message key="back"/></a></span>
		

		<c:if test="<%= showContextLink && !print && assetEntry.isVisible() %>">
			<div class="asset-more">
				<a href="<%= assetRenderer.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, viewFullContentURLString) %>"><liferay-ui:message key="<%= assetRenderer.getViewInContextMessage() %>" /> &raquo;</a>
			</div>
		</c:if>

		<br />

		
	</div>

	
</div>

<c:if test="<%= !showAssetTitle && ((assetEntryIndex + 1) < results.size()) %>">
	<div class="separator"><!-- --></div>
</c:if>


<%
	List<AssetEntry> newAssetList = new ArrayList<AssetEntry>();
	AssetEntryQuery assetQuery = assetEntryQuery;
	assetQuery.setPublishDate(new Date());
	assetQuery.setStart(0);
	assetQuery.setEnd(5);
	newAssetList = AssetEntryLocalServiceUtil.getEntries(assetQuery);
	
%>
<c:if test="<%=newAssetList!= null && !newAssetList.isEmpty() %>">
	<div class="tinkhac">
		<p><liferay-ui:message key="news-new"/></p>
		<ul>
			<%
				for(AssetEntry newAsset:newAssetList){
					AssetRenderer newAssetRenderer = newAsset.getAssetRenderer();
					String newAssetTitle = newAssetRenderer.getTitle(locale);
					
					PortletURL viewNewAssetContentURL = renderResponse.createRenderURL();

					viewNewAssetContentURL.setParameter("struts_action", "/asset_publisher/view_content");
					viewNewAssetContentURL.setParameter("type", newAsset.getAssetRendererFactory().getType());
					viewNewAssetContentURL.setParameter("viewMode", print ? Constants.PRINT : Constants.VIEW);

					if (Validator.isNotNull(newAssetRenderer.getUrlTitle())) {
						if (newAssetRenderer.getGroupId() != scopeGroupId) {
							viewNewAssetContentURL.setParameter("groupId", String.valueOf(newAssetRenderer.getGroupId()));
						}

						viewNewAssetContentURL.setParameter("urlTitle", newAssetRenderer.getUrlTitle());
					}

					String viewNewAssetContentURLString = viewNewAssetContentURL.toString();
					%>
						<li><a href="<%=viewNewAssetContentURLString%>"><%=newAssetTitle %></a></li>
					<%
				}
			%>
		</ul>
	</div>
</c:if>

<script>
	function goBack() {
	    window.history.back()
	}
</script>

<%!
private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.asset_publisher.display_full_content_jsp");
%>