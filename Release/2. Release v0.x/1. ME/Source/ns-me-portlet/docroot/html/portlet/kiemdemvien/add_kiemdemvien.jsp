<%@page import="vn.dtt.sol.ns.tramcap.business.TramCapBusiness"%>
<%@page import="vn.dtt.sol.ns.util.NuocSachUtils"%>
<%@page import="vn.dtt.sol.ns.business.DataItemBusiness"%>
<%@page import="vn.dtt.sol.ns.business.UserMappingBusiness"%>
<%@page import="vn.dtt.cmon.user.dao.service.UserMappingLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil"%>
<%@page import="vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@page import="vn.dtt.sol.ns.business.KiemDemVienBussiness"%>
<%@page import="vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien"%>
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

<portlet:renderURL var="selectHuyen" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/html/portlet/kiemdemvien/_select_huyen.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="selectTram" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/html/portlet/kiemdemvien/_select_tramcap.jsp"/>
</portlet:renderURL>

<%
	List<DATAITEM> listTinh = DATAITEMLocalServiceUtil.getByDataGroupLevel1(1);
	
	List<DATAITEM> listHuyen = new ArrayList<DATAITEM>();
	
	List<TramCapNuoc> listTramCap = new ArrayList<TramCapNuoc>();
	
	String hoVaTen = ParamUtil.getString(request, "hoVaTen");
	String taiKhoan = ParamUtil.getString(request, "taiKhoan");
	String diaChi = ParamUtil.getString(request, "diaChi");
	String chungMinhThu = ParamUtil.getString(request, "chungMinhThu");
	String dienThoai = ParamUtil.getString(request, "dienThoai");
	String imei = ParamUtil.getString(request, "imei");
	
	long capHoatDong = 0;
	String maTinhInit = StringPool.BLANK;
	String maHuyenInit = StringPool.BLANK;
	String maTramInit = StringPool.BLANK;
	
	UserMapping userMapping = UserMappingBusiness.getUserMapping(user);
	
	int userType = UserMappingBusiness.getUserType(user);
	
	if (userType == 2) {
		
		capHoatDong = 1;
		maTinhInit = userMapping.getOrgCode1();
		listHuyen = DataItemBusiness.getInLevel2(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinhInit);
	
	} else if(userType == 3) {
		
		capHoatDong = 2;
		maTinhInit = userMapping.getOrgCode1();
		maHuyenInit = userMapping.getOrgCode2();
		listHuyen = DataItemBusiness.getInLevel2(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinhInit);
		
	} else if(userType == 4) {
		
		capHoatDong = 3;
		maTinhInit = userMapping.getOrgCode1();
		maTramInit = userMapping.getOrgCode2();
		listTramCap = TramCapBusiness.getByTinh(maTinhInit);
	}
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title="add-kiem-dem-vien"
/>

<liferay-ui:error key="tai-khoan-da-ton-tai" message="tai-khoan-da-ton-tai" />

<portlet:actionURL name="addKiemDemVien" var="addKiemDemVienURL"/>
<aui:form action="<%=addKiemDemVienURL %>" method="POST" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= StringPool.BLANK %>" />
	<aui:input name="currentURL" type="hidden" value="<%= PortalUtil.getCurrentURL(request) %>" />
	<aui:input name="userId" type="hidden" value="<%=user.getUserId() %>"/>
<%
	if(userType==2||userType==3||userType==4){
%>
	<aui:input name="maTinh" type="hidden" value="<%=maTinhInit %>"></aui:input>
<%
	}
%>
<%
	if(userType==3||userType==4){
%>
	<aui:input name="maHuyen" type="hidden" value="<%=maHuyenInit %>"></aui:input>
	<aui:input name="maTram" type="hidden" value="<%=maTramInit %>"></aui:input>
<%
	}
%>
	<aui:field-wrapper>
		<aui:row>
			<aui:col width="50">
				<aui:input 
					name="hoVaTen" 
					label="full-name" 
					type="text" 
					value="<%= (hoVaTen.isEmpty())? StringPool.BLANK: hoVaTen %>" 
				>
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
			<aui:col width="50">
				<aui:input 
					name="taiKhoan" 
					label="username" 
					type="text" 
					value="<%= (taiKhoan.isEmpty())?  StringPool.BLANK: taiKhoan %>"
				>
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
		</aui:row>
		
		<aui:row>
			<aui:col width="50">
				<aui:input 
					name="matKhau" 
					label="password" 
					type="password" 
					value="<%= StringPool.BLANK %>" 
				>
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
		</aui:row>
		
		<aui:row>
			<aui:col with="50">
				<aui:input 
					name="matKhau-2" 
					label="re-password" 
					type="password" 
				>
					<aui:validator name="required" />
					<aui:validator name="equalTo">'#<portlet:namespace />matKhau'</aui:validator>
				</aui:input>
			</aui:col>
		</aui:row>
		
		<aui:row>
			<aui:col width="50">
				<aui:select 
					name="capHoatDong" 
					label="cap-hoat-dong" 
					id="capHoatDong" 
					showEmptyOption="<%= false %>" 
					required="true" 
					disabled="<%=(userType==1 || userType==2)? false:true %>"
				>
					<aui:option value=""><liferay-ui:message key="--chon--"/></aui:option>
					<aui:option value="1"><liferay-ui:message key="toan-tinh"/></aui:option>
					<aui:option value="2"><liferay-ui:message key="ve-sinh-huyen"/></aui:option>
					<aui:option value="3"><liferay-ui:message key="tram-cap-nuoc"/></aui:option>
				</aui:select>
			</aui:col>
		</aui:row>
		
		<aui:row id="optToanTinh">
			<aui:col width="50">
				<aui:select 
					name="maTinh" 
					id="maTinh" 
					showEmptyOption="<%= false %>" 
					required="true" 
					disabled="<%=(userType==1)? false:true %>"
				>
					<aui:option value=""><liferay-ui:message key="--chon--"/></aui:option>
					<%
						for (DATAITEM tinh : listTinh) {
							if(tinh.getNode1().equals(maTinhInit)){
					%>
								<aui:option value="<%= tinh.getNode1() %>" selected="<%=true %>"><%= tinh.getName() %></aui:option>
					<%
							} else {
					%>
						<aui:option value="<%= tinh.getNode1() %>"><%= tinh.getName() %></aui:option>
					<%
							}
						}
					%>
				</aui:select>
			</aui:col>
		
			<aui:col id="optVeSinhHuyen" width="50">
				<div id="optHuyen">
					<aui:select 
						name="maHuyen" 
						id="maHuyen" 
						showEmptyOption="<%= false %>" 
						disabled="<%=(userType==1 || userType==2)? false:true %>"
					>
						<aui:option value=""><liferay-ui:message key="--chon--"/></aui:option>
						<%
							for (DATAITEM huyen : listHuyen) {
						%>
						<aui:option value="<%= huyen.getNode2() %>"><%= huyen.getName() %></aui:option>
						<%
								}
						%>
					</aui:select>
				</div>
			</aui:col>
			
			<aui:col id="optTramCapNuoc" width="50">
				<div id="optTram">
					<aui:select 
						name="maTram" 
						id="maTram" 
						showEmptyOption="<%= false %>" 
						disabled="<%=(userType==1 || userType==2)? false:true %>"
					>
						<aui:option value=""><liferay-ui:message key="--chon--"/></aui:option>
						<aui:option value="<%=maTramInit %>" selected="true"><%= NuocSachUtils.getTenTram(maTramInit) %></aui:option>
						<%
							for (TramCapNuoc tramCap : listTramCap) {
						%>
							<aui:option value="<%= tramCap.getId() %>"><%= tramCap.getTenTram() %></aui:option>
						<%
							}
						%>
					</aui:select>
				</div>
			</aui:col>
		</aui:row>
		
		<aui:row>
			<aui:col width="50">
				<aui:input 
					name="diaChi" 
					label="address"
					type="text" 
					value="<%=(diaChi.isEmpty())? StringPool.BLANK:diaChi %>" 
				></aui:input>
			</aui:col>
			<aui:col width="50">
				<aui:input 
					name="chungMinhThu" 
					label="chung-minh-thu" 
					type="text" 
					value="<%= (chungMinhThu.isEmpty())? StringPool.BLANK:chungMinhThu %>" 
				></aui:input>
			</aui:col>
		</aui:row>
		
		<aui:row>
			<aui:col width="50">
				<aui:input 
					name="dienThoai" 
					label="phone" 
					type="text" 
					value="<%= (dienThoai.isEmpty())? StringPool.BLANK:dienThoai %>"
				></aui:input>
			</aui:col>
			<aui:col width="50">
				<aui:input 
					name="imei" 
					label="imei" 
					type="text" 
					value="<%= (imei.isEmpty())? StringPool.BLANK:imei %>" 
				></aui:input>
			</aui:col>
		</aui:row>
		
		<aui:row cssClass="fm-button">
			<aui:col width="100">
				<aui:button-row>
					<aui:button 
						type="submit" 
						value="save"
					/>
					<aui:button 
						href="<%= redirect %>" 
						name="cancel" 
						type="cancel"
					/>
				</aui:button-row>
			</aui:col>
		</aui:row>
	</aui:field-wrapper>
</aui:form>

<script type="text/javascript">

	AUI().ready(function(A){
		var capHoatDong = '<%= capHoatDong %>';
		var capHoatDongInput = A.one("#<portlet:namespace/>capHoatDong");
		
		var capTinhInput = A.one("#<portlet:namespace/>maTinh");
		var capHuyenInput = A.one("#<portlet:namespace/>maHuyen");
		var capTramInput = A.one("#<portlet:namespace/>maTram");
		
		<portlet:namespace/>loadingDialogState(capHoatDong);
		
		capHoatDongInput.on('change', function(){
			var value = capHoatDongInput.val();
			<portlet:namespace />loadingDialogState(value);
			var capTinhId = capTinhInput.val();
			var capHuyenId = capHuyenInput.val();
			var capTramId = capTramInput.val();
			selectHuyen(capTinhId, capHuyenId);
			selectTram(capTinhId, capTramId);
		});
	
			capTinhInput.on('change', function(){
			var capTinhId = capTinhInput.val();
			var capHuyenId = capHuyenInput.val();
			var capTramId = capTramInput.val();
			selectHuyen(capTinhId, capHuyenId);
			selectTram(capTinhId, capTramId);
		});
		
	});
	
	function selectHuyen(capTinhId, capHuyenId){
		AUI().use('aui-base','aui-io-request', function(A){
	
			//aui ajax call to get updated content
			A.io.request('<%= selectHuyen %>',
			{
				dataType: 'text/html',
				method: 'GET',
				data: { 
					"<portlet:namespace />capTinhId": capTinhId,
					"<portlet:namespace />capHuyenId": capHuyenId
				},
				on: {
					success: function() {
						var optHuyen = A.one("#optHuyen");
						optHuyen.set("innerHTML", this.get('responseData'));
					} 
				}
			});
		});
	}
	
	function selectTram(capTinhId, capTramId){
		AUI().use('aui-base','aui-io-request', function(A){
	
			//aui ajax call to get updated content
			A.io.request('<%= selectTram %>',
			{
				dataType: 'text/html',
				method: 'GET',
				data: { 
					"<portlet:namespace />capTinhId": capTinhId,
					"<portlet:namespace />capTramId": capTramId
				},
				on: {
					success: function() {
						var optHuyen = A.one("#optTram");
						optHuyen.set("innerHTML", this.get('responseData'));
					} 
				}
			});
		});
	}

	Liferay.provide(window, '<portlet:namespace/>loadingDialogState',

	function(value) {
		var A = AUI();

		var capTinh = A.one('#<portlet:namespace/>optToanTinh');
		var capHuyen = A.one('#<portlet:namespace/>optVeSinhHuyen');
		var capTramCap = A.one('#<portlet:namespace/>optTramCapNuoc');

		if (value == '1') {
			capTinh.show();
			capHuyen.hide();
			capTramCap.hide();
		} else if (value == '2') {
			capTinh.show();
			capHuyen.show();
			capTramCap.hide();
		} else if (value == '3') {
			capTinh.show();
			capHuyen.hide();
			capTramCap.show();
		} else {
			capTinh.hide();
			capHuyen.hide();
			capTramCap.hide();
		}
	});
</script>