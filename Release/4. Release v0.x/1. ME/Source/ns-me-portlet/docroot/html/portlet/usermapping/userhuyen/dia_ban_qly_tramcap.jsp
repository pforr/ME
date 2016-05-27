<%@page import="vn.dtt.sol.ns.util.NuocSachUtils"%>
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
	List<DATAITEM> lsTinh = NuocSachUtils.getListTinh(user);
	List<DATAITEM> lsHuyen = new ArrayList<DATAITEM>();
	List<DATAITEM> lsXa = new ArrayList<DATAITEM>();
		 
%>

<div id="diaban-fields">
	<div class="lfr-form-row lfr-form-row-inline">
		<div class="row-fields">
			<aui:row>
				<aui:column columnWidth="50">
					<aui:select id="maTinh0" name="maTinh0" onChange="javascript:changeTinhOpt();" label="ma-tinh" inlineField="<%= true %>">
						<%
							for (DATAITEM tinh : lsTinh) {
						%>
							<aui:option value="<%= tinh.getNode1() %>"><%= tinh.getName() %></aui:option>
						<%
							}
						%>
					</aui:select>
				</aui:column>
				<aui:column columnWidth="50">
					<div id="huyenblock">
						<aui:select id="mahuyen0" name="mahuyen0" label="ma-huyen" inlineField="<%= true %>" showEmptyOption="true">
							
						</aui:select>
					</div>
				</aui:column>
			</aui:row>
			
			<div id="selectxa">
			
			</div>
		</div>
	</div>
</div>

<portlet:renderURL var="requestHuyenURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/html/portlet/usermapping/userhuyen/_select_huyen.jsp"/>
</portlet:renderURL>

<script type="text/javascript">
	function changeTinhOpt(){
		AUI().use('aui-base','aui-io-request', function(A){
			
			var capTinhInput = A.one("#<portlet:namespace/>maTinh0");
	
			//aui ajax call to get updated content
			A.io.request('<%= requestHuyenURL %>',
			{
				dataType: 'text/html',
				method: 'GET',
				data: {
					"<portlet:namespace />capTinhId": capTinhInput.val(),
				},
				on: {
					success: function() {
						var optHuyen = A.one("#huyenblock");
						optHuyen.set("innerHTML", this.get('responseData'));
					} 
				}
			});
		});	
	}
	function changeHuyenOpt(){
		AUI().use('aui-base','aui-io-request', function(A){
			
			var capTinhInput = A.one("#<portlet:namespace/>maHuyen");
			var capHuyenInput = A.one("#<portlet:namespace/>maHuyen");
	
			//aui ajax call to get updated content
			A.io.request('<%= requestHuyenURL %>',
			{
				dataType: 'text/html',
				method: 'GET',
				data: {
					"<portlet:namespace />capTinhId": capTinhInput.val(),
					"<portlet:namespace />capHuyenId": capHuyenInput.val(),
				},
				on: {
					success: function() {
						var optHuyen = A.one("#selectxa");
						optHuyen.set("innerHTML", this.get('responseData'));
					} 
				}
			});
		});	
	}

</script>

<aui:script use="liferay-auto-fields">
	new Liferay.AutoFields({
		contentBox: '#diaban-fields',
		fieldIndexes: '<portlet:namespace />diabanIndexes'
	}).render();
</aui:script>