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
	int namBaoCao = ParamUtil.getInteger(request, "namBaoCao");

	long folderId = BaoCaoDLIUtil.getFolderId(themeDisplay.getUserId(), scopeGroupId);
	
	BaoCaoDLI baoCaoDLI = (BaoCaoDLI) request.getAttribute(WebKeys.BAO_CAO_DLI);

	String message = "view-bao-cao-dli";
%>

<liferay-ui:header
	backURL="<%= redirectURL %>"
	title='<%= message %>'
/>

<portlet:renderURL var="previewBaoCaoDLIURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value='<%= templatePath + "report_tu.jsp" %>'/>
</portlet:renderURL>

	<aui:form action="" name="fm" method="post" onSubmit='<%= "event.preventDefault(); submitForm(event.target);" %>'>
		<aui:input name="<%= Constants.CMD %>" type="hidden" value=""/>
		<aui:input name="redirect" type="hidden" value="<%= redirectURL %>" />
		<aui:input name="backURL" type="hidden" value="<%= currentURL %>" />
		<aui:input name="nam" type="hidden" value="<%= namBaoCao %>" />
		<aui:input name="folderId" type="hidden" value="<%= folderId %>" />
		<aui:input name="trangThai" type="hidden" value="<%= BaoCaoDLIConstants.TRANG_THAI_DANG_LAP %>" />
		<aui:input name="typeDLI" type="hidden" value="<%= typeDLI %>" />
		
		<liferay-ui:error exception="<%= SoBaoCaoException.class %>" message="error-so-bao-cao"/>
		<liferay-ui:error exception="<%= NgayBaoCaoException.class %>" message="error-ngay-bao-cao"/>
		<liferay-ui:error exception="<%= NguoiLapException.class %>" message="error-nguoi-lap-bao-cao"/>
		<liferay-ui:error exception="<%= NguoiDuyetException.class %>" message="error-nguoi-duyet-bao-cao"/>
		<liferay-ui:error exception="<%= UpdateChotBaoCaoException.class %>" message="error-update-chot-bao-cao"/>
		
		<aui:model-context bean="<%= baoCaoDLI %>" model="<%= BaoCaoDLI.class %>" />
		
		<aui:fieldset>
				<aui:col width="<%= 25 %>">
					<aui:input name="soBaoCao" />
				</aui:col>
				
				<aui:col width="<%= 25 %>">
					<aui:input name="nguoiLapTxt" label="nguoi-lap" type="text" />
				</aui:col>
				
				<aui:col width="<%= 25 %>">
					<aui:input name="nguoiDuyet" />
				</aui:col>
				
				<aui:col width="<%= 25 %>">
					<aui:input name="ngayBaoCao"/>
				</aui:col>
		
			<div class="separator"></div>
			
			<div id="<portlet:namespace/>previewBaoCao" style="min-height: 100px; width: 100%;"></div>
		</aui:fieldset>
	</aui:form>

<aui:script>
	AUI().ready("event", "node", "aui-io-request", function() {
		<portlet:namespace />previewBaoCao();
	});
	
	Liferay.provide(
		window,
		'<portlet:namespace />previewBaoCao',
		function() {
			var A = AUI();
			var previewBaoCaoId = A.one('#<portlet:namespace/>previewBaoCao');
			
			if(previewBaoCaoId) {
				previewBaoCaoId.plug(A.LoadingMask, { background: "#eee" });
				previewBaoCaoId.loadingmask.show();
				
				var ajaxURL = "<%=previewBaoCaoDLIURL %>";
				
				var namBaoCao = '<%= namBaoCao %>';
				var soBaoCao = A.one('#<portlet:namespace />soBaoCao');
				var nguoiLap = A.one('#<portlet:namespace />nguoiLapTxt');
				var nguoiDuyet = A.one('#<portlet:namespace />nguoiDuyet');
				var ngayBaoCao = A.one('#<portlet:namespace />ngayBaoCao');
				
				A.io.request(ajaxURL, { 
					data : { 
						"<portlet:namespace />namBaoCao" : namBaoCao,
						"<portlet:namespace />soBaoCao" : soBaoCao.val(),
						"<portlet:namespace />nguoiLap" : nguoiLap.val(),
						"<portlet:namespace />nguoiDuyet" : nguoiDuyet.val(),
						"<portlet:namespace />ngayBaoCao" : ngayBaoCao.val(),
					}, 
					on : { 
						success : function(event, id, object) {
							var response = this.get("responseData");
							
							previewBaoCaoId.html(response);
							previewBaoCaoId.loadingmask.hide();
						}
					} 
				});
			} else {
				console.log("<portlet:namespace/>previewBaoCao not found");
			}
		},
		['aui-base', 'aui-loading-mask']
	);
	
	Liferay.provide(
		window,
		'<portlet:namespace />xemBaoCaoDLI',
		function() {
			<portlet:namespace />previewBaoCao();
		},
		['aui-base']
	);
	
	function <portlet:namespace />updateBaoCaoDLI() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.UPDATE %>";
		submitForm(document.<portlet:namespace/>fm, '<portlet:actionURL name="updateBaoCaoDLI"/>');
	}
	
	function <portlet:namespace />chotBaoCaoDLI() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.UPDATE %>";
		document.<portlet:namespace />fm.<portlet:namespace />trangThai.value = '<%= BaoCaoDLIConstants.TRANG_THAI_DA_CHOT %>';
		submitForm(document.<portlet:namespace/>fm, '<portlet:actionURL name="updateBaoCaoDLI"/>');
	}
</aui:script>

<%!
	final Log _log = LogFactoryUtil.getLog("html.portlet.baocaodli.edit_baocaodli_tu.jsp");
%>