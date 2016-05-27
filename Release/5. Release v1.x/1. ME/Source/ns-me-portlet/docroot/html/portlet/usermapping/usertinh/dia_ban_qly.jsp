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

	// Ma tinh lua chon voi nguoi dung cap TU
	String selTinh = ParamUtil.getString(request, "selTinh");
	
	// Danh sach huyen theo quan ly
	List<DATAITEM> lsHuyen = DataItemBusiness.getInLevel2(1, selTinh);
	
	//Usermapping cua nguoi Them tai khoan 
	UserMapping userMappingCreator = UserMappingBusiness.getByUserId(user.getUserId());
	
	//UserMapping cua doi tuong tai khoan khi sua
	UserMapping userMapping = (UserMapping) renderRequest.getAttribute("userMapping");
	
	// Danh sach tinh quan ly theo nguoi tao Tai khoan
	List<DATAITEM> lsTinhQuanLy = new ArrayList<DATAITEM>();
	
	if (Validator.isNull(userMapping)) {
		if (Validator.isNotNull(userMappingCreator) && userMappingCreator.getUserType() == 1) {
			lsTinhQuanLy = DiaBanQuanLyUtils.getListTinhTU(user, isSupperAdmin, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} else if (Validator.isNotNull(userMappingCreator) && userMappingCreator.getUserType() == 2){
			DATAITEM tinh = NuocSachUtils.getDataItem(1, 1, maTinh);
			if (Validator.isNotNull(tinh)) {
				lsTinhQuanLy.add(tinh);
			}
		}
	} else {
		DATAITEM tinh = NuocSachUtils.getDataItem(1, 1, maTinh);
		if (Validator.isNotNull(tinh)) {
			lsTinhQuanLy.add(tinh);
		}
	}

	List<DATAITEM> lsHuyenQuanLy = new ArrayList<DATAITEM>();
	long umId = 0;

	if (Validator.isNotNull(userMapping)) {
		User selUser = UserMappingBusiness.getUser(userMapping.getId());
		lsHuyenQuanLy = DiaBanQuanLyUtils.getListHuyenGS(selUser, maTinh, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		umId = userMapping.getUserId();
	}
%>
<div class="wrapper-0">
	<div class="wrapper-1">
			<div class="header-um">
				<liferay-ui:message key="chon-dia-ban-quan-ly"/>
			</div>
			
			<aui:select name="selTinh" label="<%= StringPool.BLANK %>" showEmptyOption="<%= lsTinhQuanLy.size() == 1 ? false : true %>">
				<%
					for (DATAITEM tinh : lsTinhQuanLy) {
				%>
					<aui:option value="<%= tinh.getNode1() %>"><%= tinh.getName() %></aui:option>
				<%
					}
				%>
			</aui:select>
			
			<div id="selecthuyen">
				
			</div>
	</div>
	
	<div class="wrapper-1">
		<c:if test="<%= lsHuyenQuanLy.size() != 0 %>">
			<div class="header-um">
				<liferay-ui:message key="chon-dia-ban-quan-ly-de-loai-bo"/>
			</div>
		
			<div class="selected-huyen">
				<table>
					<tr>
						<td>
							<strong><liferay-ui:message key="ten-huyen"/></strong>
						</td>
						<td align="center">
							<input type="checkbox" onclick="checkAll(this)">
						</td>
					</tr>
					<%
						for (DATAITEM huyen : lsHuyenQuanLy) {
					%>
						<tr>
		
							<td class="col-name">
								<%= huyen.getName() %>
							</td>
						
							<td class="col-action">
								<aui:input name="delHuyenId" type="checkbox" label="<%= StringPool.BLANK %>" value="<%= huyen.getNode2() %>"/>
							</td>
							
						</tr>
					<%
						}
					%>
				</table>
			</div>
		</c:if>

	</div>
</div>
<portlet:renderURL var="selectTinh" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value='<%= templatePath + "usertinh/render_huyen.jsp" %>'/>
</portlet:renderURL>

<script type="text/javascript">

	AUI().ready(function(A){
		
		var selTinhInput = A.one("#<portlet:namespace/>selTinh");
		
		selectHuyen(selTinhInput.val());
		
		selTinhInput.on('change', function(){
			var maTinh = selTinhInput.val();
			selectHuyen(maTinh);
		});
	});

	function selectHuyen(maTinh){
		AUI().use('aui-base','aui-io-request', function(A) {
			A.io.request('<%= selectTinh %>',
			{
				dataType: 'text/html',
				method: 'GET',
				data: {
					"<portlet:namespace />maTinh": maTinh,
					"<portlet:namespace />umId": '<%= Long.toString(umId) %>'
				},
				on: {
					success: function() {
						var selecthuyen = A.one("#selecthuyen");
						selecthuyen.set("innerHTML", this.get('responseData'));
					} 
				}
			});
		});	
	}
	
	function checkAll(bx) {
		var cbs = document.getElementsByName('<portlet:namespace />delHuyenId');
		for(var i=0; i < cbs.length; i++) {
			if(cbs[i].type == 'checkbox') {
				cbs[i].checked = bx.checked;
			}
		}
	}
</script>