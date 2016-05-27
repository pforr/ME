<%@page import="vn.dtt.sol.ns.reporting.ThongTinKiemDemVeSinhCongTrinhModel"%>
<%@page import="vn.dtt.sol.ns.vesinhmoitruong.dao.service.ThongTinKiemDemCongTrinhLocalServiceUtil"%>
<%@page import="vn.dtt.sol.ns.vesinhmoitruong.dao.service.ThongTinKiemDemCongTrinhLocalService"%>
<%@page import="vn.dtt.sol.ns.vesinhmoitruong.dao.service.ThongTinKiemDemHoGDLocalServiceUtil"%>
<%@page import="vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemCongTrinh"%>
<%@page import="vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemHoGD"%>
<%@page import="vn.dtt.sol.ns.reporting.ThongTinKiemDemVeSinhGiaDinhModel"%>
<%@page import="vn.dtt.sol.ns.vesinhmoitruong.dao.model.KeHoachKiemDemVeSinh"%>
<%@page import="vn.dtt.sol.ns.vesinhmoitruong.dao.service.KeHoachKiemDemVeSinhLocalServiceUtil"%>
<%@page import="vn.dtt.sol.ns.vesinhmoitruong.business.KeHoachKiemDemVeSinhBussiness"%>
<%@page import="vn.dtt.sol.ns.vesinhmoitruong.terms.KeHoachKiemDemVeSinhTerms"%>
<%@page import="vn.dtt.sol.ns.tramcap.dao.service.THONGTINKIEMDEMNUOCLocalServiceUtil"%>
<%@page import="vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC"%>
<%@page import="vn.dtt.sol.ns.reporting.ThongTinKiemDemNuocModel"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="vn.dtt.sol.ns.util.MessageErrors"%>
<%@page import="vn.dtt.sol.ns.util.MessageSuccess"%>
<%@page import="vn.dtt.sol.ns.business.KiemDemVienBussiness"%>
<%@page import="vn.dtt.sol.ns.tramcap.business.KeHoachKiemDemNuocBusiness"%>
<%@page import="vn.dtt.sol.ns.kehoachkiemdemnuoc.terms.KeHoachKiemDemNuocTerms"%>
<%@page import="vn.dtt.sol.ns.tramcap.dao.model.KeHoachKiemDemNuoc"%>
<%@page import="vn.dtt.sol.ns.util.NuocSachUtils"%>
<%@page import="vn.dtt.sol.ns.tramcap.dao.service.persistence.DauNoiNuocUtil"%>
<%@page import="vn.dtt.sol.ns.daunoinuoc.terms.DauNoiNuocTerms"%>
<%@page import="vn.dtt.sol.ns.tramcap.business.DauNoiNuocBusiness"%>
<%@page import="vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="vn.dtt.sol.ns.tramcap.business.TramCapBusiness"%>
<%@page import="vn.dtt.sol.ns.tramcap.dao.service.TramCapNuocLocalServiceUtil"%>
<%@page import="vn.dtt.sol.ns.util.WebKeys"%>
<%@page import="vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc"%>
<%@page import="com.liferay.util.PwdGenerator"%>
<%@page import="vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@page import="vn.dtt.sol.ns.business.DataItemBusiness"%>
<%@page import="vn.dtt.sol.ns.business.DataGroupBusiness"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAGROUP"%>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="vn.dtt.sol.ns.daunoinuoc.search.DauNoiNuocSearch"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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

<script type="text/javascript" src='http://maps.google.com/maps/api/js?sensor=false&libraries=places'></script>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.10.1.min.js"></script>
<%
String idTrangThaiChk = ParamUtil.getString(request, "idTrangThaiChk");
long idTrangThaiChkLong = 0;
if(Validator.isNotNull(idTrangThaiChk) && Validator.isNumber(idTrangThaiChk)){
	idTrangThaiChkLong = Long.valueOf(idTrangThaiChk);
}else{
	idTrangThaiChkLong = 0;
}
String maTinh = (String)request.getAttribute(KeHoachKiemDemVeSinhTerms.MA_TINH);
String maHuyen = (String)request.getAttribute(KeHoachKiemDemVeSinhTerms.MA_HUYEN);
String maXa = ParamUtil.getString(request, "maXa");
String trangThai = (String)request.getAttribute("trangThai");
String daKetThucDieuTra = (String)request.getAttribute("daKetThucDieuTra");
String danhGiaKiemDem = ParamUtil.getString(request, "danhGiaKiemDem");
String idNguoiTao = (String)request.getAttribute("idNguoiTao");
String advText = (String)request.getAttribute("advText");
List<UserMapping> listUserBySearch = (List<UserMapping>)request.getAttribute("listUserBySearch");
KeHoachKiemDemVeSinh keHoachKiemDemVeSinh = (KeHoachKiemDemVeSinh)request.getAttribute("keHoachKiemDemVeSinh");
UserMapping userMapping = (UserMapping)request.getAttribute("loginUserMapping");
String namBaoCaovstx = (String)request.getAttribute("namBaoCaovstx");

List<DATAITEM> listHuyen = new ArrayList<DATAITEM>();	 
List<DATAITEM> listXa = new ArrayList<DATAITEM>();	 
List<String> listStr = new ArrayList<String>();
listStr = KeHoachKiemDemVeSinhLocalServiceUtil.getHuyenXaKeHoachKiemDemGiaDinhSearch(String.valueOf(keHoachKiemDemVeSinh.getId()), trangThai, keHoachKiemDemVeSinh.getMaTinh(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);

if(listStr.size()> 0 &&Validator.isNotNull(KeHoachKiemDemVeSinhBussiness.getHuyenKeHoachKiemDemVeSinhGdSearch(String.valueOf(keHoachKiemDemVeSinh.getId()), trangThai, keHoachKiemDemVeSinh.getMaTinh(), QueryUtil.ALL_POS, QueryUtil.ALL_POS).get(0))){
	listHuyen.addAll(KeHoachKiemDemVeSinhBussiness.getHuyenKeHoachKiemDemVeSinhGdSearch(String.valueOf(keHoachKiemDemVeSinh.getId()), trangThai, keHoachKiemDemVeSinh.getMaTinh(), QueryUtil.ALL_POS, QueryUtil.ALL_POS) );
}
if(listStr.size()> 0 &&Validator.isNotNull(KeHoachKiemDemVeSinhBussiness.getXaKeHoachKiemDemVeSinhGdSearch(String.valueOf(keHoachKiemDemVeSinh.getId()), trangThai, keHoachKiemDemVeSinh.getMaTinh(), QueryUtil.ALL_POS, QueryUtil.ALL_POS).get(0))){
	listXa.addAll(KeHoachKiemDemVeSinhBussiness.getXaKeHoachKiemDemVeSinhGdSearch(String.valueOf(keHoachKiemDemVeSinh.getId()), trangThai, keHoachKiemDemVeSinh.getMaTinh(), QueryUtil.ALL_POS, QueryUtil.ALL_POS) );
}
String requiredLabel="";
requiredLabel ="(*)";
String dotLabel=":";
int chuaKiemDemGd = KeHoachKiemDemVeSinhBussiness.getCountGiaDinhBykeHoachId(keHoachKiemDemVeSinh.getId(), WebKeys.CHUA_KET_THUC);
int daHoanThanhGd = KeHoachKiemDemVeSinhBussiness.getCountGiaDinhBykeHoachId(keHoachKiemDemVeSinh.getId(), WebKeys.DA_HOAN_THANH_DAY_DU);
int tongDauNoiGd= chuaKiemDemGd + daHoanThanhGd+ KeHoachKiemDemVeSinhBussiness.getCountGiaDinhBykeHoachId(keHoachKiemDemVeSinh.getId(), WebKeys.DA_HOAN_THANH_MOT_PHAN);
int coNhaVeSinhGd = KeHoachKiemDemVeSinhBussiness.getCountCosNhaVeSinh(keHoachKiemDemVeSinh.getId());
int coHVSGd = KeHoachKiemDemVeSinhBussiness.getCountcoHVS(keHoachKiemDemVeSinh.getId());
int coHVSXayMoiGd = KeHoachKiemDemVeSinhBussiness.getCountcoHVSXayMoi(keHoachKiemDemVeSinh.getId());

int chuaKiemDemCt = KeHoachKiemDemVeSinhBussiness.getCountCongTrinhBykeHoachId(keHoachKiemDemVeSinh.getId(), WebKeys.CHUA_KET_THUC);
int daHoanThanhCt = KeHoachKiemDemVeSinhBussiness.getCountCongTrinhBykeHoachId(keHoachKiemDemVeSinh.getId(), WebKeys.DA_HOAN_THANH_DAY_DU);
int tongDauNoiCt= chuaKiemDemCt + daHoanThanhCt;
int kiemDemDatCt= KeHoachKiemDemVeSinhBussiness.getCountCongTrinhBykeHoachIdDanhGiaKiemDem(keHoachKiemDemVeSinh.getId(), WebKeys.DANH_GIA_KIEM_DEM_DAT);
int kiemDemKhongDatCt= KeHoachKiemDemVeSinhBussiness.getCountCongTrinhBykeHoachIdDanhGiaKiemDem(keHoachKiemDemVeSinh.getId(), WebKeys.DANH_GIA_KIEM_DEM_KHONG_DAT);

List<ThongTinKiemDemVeSinhGiaDinhModel> resultBase1 = new ArrayList<ThongTinKiemDemVeSinhGiaDinhModel>(
		KeHoachKiemDemVeSinhBussiness.getListThongTinKiemDemGdModelViewDetail(keHoachKiemDemVeSinh.getId(),daKetThucDieuTra,keHoachKiemDemVeSinh.getMaTinh(),maHuyen,maXa,danhGiaKiemDem,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS));
List<ThongTinKiemDemVeSinhCongTrinhModel> resultBase2 = new ArrayList<ThongTinKiemDemVeSinhCongTrinhModel>(
		KeHoachKiemDemVeSinhBussiness.getListThongTinKiemDemCongTrinhModelViewDetail(keHoachKiemDemVeSinh.getId(),daKetThucDieuTra,keHoachKiemDemVeSinh.getMaTinh(),maHuyen,maXa,danhGiaKiemDem,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS));
String host = PortalUtil.getPortalURL(request);
String latiloto = "";
ThongTinKiemDemHoGD thongTin1 = null;
ThongTinKiemDemCongTrinh thongTin2 = null;

String ma_tinh = keHoachKiemDemVeSinh.getMaTinh();
String map_elm = "";

  

if (maTinh.equals("35")) {
	//Ha nam
	map_elm = "center: new google.maps.LatLng(20.583520,105.922990)";
	
} else if (maTinh.equals("01")) {
	//Hanoi
	map_elm = "center: new google.maps.LatLng(21.027764,105.834160)";
}else if (maTinh.equals("38")) {
	//Thanh Hoa
	map_elm = "center: new google.maps.LatLng(20.129128,105.313118)";
}else if (maTinh.equals("27")) {
	//Bac Ninh
	map_elm = "center: new google.maps.LatLng(20.129128,105.313118)";
}else if (maTinh.equals("33")) {
	//Hung Yen
	map_elm = "center: new google.maps.LatLng(20.852571,106.016997)";
}else if (maTinh.equals("25")) {
	//Phu Tho
	map_elm = "center: new google.maps.LatLng(21.268443,105.204557)";
}else if (maTinh.equals("22")) {
	//Quang Ninh
	map_elm = "center: new google.maps.LatLng(21.006382,107.292514)";
}else {
	//Vinh Phuc
	map_elm = "center: new google.maps.LatLng(21.360881,105.547437)";
}
%>
<liferay-portlet:renderURL varImpl="redirectKeHoachURL">
	<liferay-portlet:param name="mvcPath" value="/html/portlet/kehoachkiemdemvesinh/view.jsp"></liferay-portlet:param>
	<liferay-portlet:param name="<%=KeHoachKiemDemVeSinhTerms.MA_TINH %>" value="<%=keHoachKiemDemVeSinh.getMaTinh() %>"></liferay-portlet:param>
	<liferay-portlet:param name="<%=KeHoachKiemDemVeSinhTerms.MA_HUYEN %>" value="<%=keHoachKiemDemVeSinh.getMaHuyen() %>"></liferay-portlet:param>
	<liferay-portlet:param name="trangThai" value="<%=trangThai %>"></liferay-portlet:param>
	<liferay-portlet:param name="<%=KeHoachKiemDemVeSinhTerms.KIEM_DEM_VIEN_ID %>" value="<%=String.valueOf(keHoachKiemDemVeSinh.getKiemDemVienID())  %>"></liferay-portlet:param>
	<liferay-portlet:param name="idNguoiTao" value="<%=String.valueOf(keHoachKiemDemVeSinh.getIdNguoiTao()) %>"></liferay-portlet:param>
</liferay-portlet:renderURL>
<liferay-ui:header backURL="<%= redirectKeHoachURL.toString() %>" title='<%="ke-hoach-kiem-dem-ve-sinh" %>' />
	
<liferay-ui:error key="<%= MessageErrors.PHAN_CONG_LAI_DAU_NOI_MESSAGE %>" message="<%= MessageErrors.PHAN_CONG_LAI_DAU_NOI_MESSAGE %>" />
<liferay-ui:success key="<%= MessageSuccess.PHAN_CONG_LAI_DAU_NOI_MESSAGE %>" message="<%= MessageSuccess.PHAN_CONG_LAI_DAU_NOI_MESSAGE%>" />
<liferay-ui:error key="<%= MessageErrors.DONG_KE_HOACH_KIEM_DEM_MESSAGE %>" message="<%= MessageErrors.DONG_KE_HOACH_KIEM_DEM_MESSAGE %>" />
<liferay-ui:success key="<%= MessageSuccess.DONG_KE_HOACH_KIEM_DEM_MESSAGE %>" message="<%= MessageSuccess.DONG_KE_HOACH_KIEM_DEM_MESSAGE%>" />
<portlet:renderURL var="onpageError">
	<portlet:param name="mvcPath" value="/html/portlet/kehoachkiemdemnuoc/view_detail_tab1.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="onpageSuccess">
	<portlet:param name="mvcPath" value="/html/portlet/kehoachkiemdemnuoc/view_detail_tab1.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="imPortThongTinKiemDem" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/html/portlet/kehoachkiemdemnuoc/_thong_tin_kiem_dem.jsp"/>
</portlet:renderURL>
	<aui:input name="onpageError" type="hidden" value="<%= onpageError %>" />
	<aui:input name="onpageSuccess" type="hidden" value="<%= onpageSuccess %>" />
	<aui:input id="<%=KeHoachKiemDemNuocTerms.ID %>" name="<%=KeHoachKiemDemNuocTerms.ID %>" type="hidden" value="<%=String.valueOf(keHoachKiemDemVeSinh.getId()) %>" />
<c:choose>
	<c:when test="<%= Validator.isNotNull(keHoachKiemDemVeSinh) %>">
		<aui:row>
			<aui:col width="50">
				<aui:field-wrapper label="<%= LanguageUtil.get(pageContext, \"kiem-dem-vien\") + dotLabel %>" inlineLabel="true">
					<%=Validator.isNotNull(KiemDemVienBussiness.getKiemDemVien(keHoachKiemDemVeSinh.getKiemDemVienID()))?KiemDemVienBussiness.getKiemDemVien(keHoachKiemDemVeSinh.getKiemDemVienID()).getHoVaTen():StringPool.BLANK %>
				</aui:field-wrapper>
			</aui:col>
			<aui:col width="50">
			<aui:field-wrapper label="<%= LanguageUtil.get(pageContext, \"thoi-gian-du-kien\") + dotLabel %>" inlineLabel="true">
					<%=Validator.isNotNull(keHoachKiemDemVeSinh.getNgayBatDau())?dateFormatDate.format(keHoachKiemDemVeSinh.getNgayBatDau()):StringPool.BLANK %> đến <%=Validator.isNotNull(keHoachKiemDemVeSinh.getNgayKetThuc())?dateFormatDate.format(keHoachKiemDemVeSinh.getNgayKetThuc()):StringPool.BLANK %>
				</aui:field-wrapper>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col width="100">
				<aui:field-wrapper label="<%= LanguageUtil.get(pageContext, \"mo-ta\") +dotLabel %>" inlineLabel="true"  >
					<%=keHoachKiemDemVeSinh.getMoTa() %>
				</aui:field-wrapper>
			</aui:col>
		</aui:row>
		<%-- 		<aui:row> --%>
<%-- 			<aui:col width="16"> --%>
<%-- 				<aui:field-wrapper label="<%= LanguageUtil.get(pageContext, \"tong-ve-sinh-ho-gd\") + dotLabel + \" \" + tongDauNoi %>" inlineLabel="true"> --%>
<%-- 				</aui:field-wrapper> --%>
<%-- 			</aui:col> --%>
<%-- 			<aui:col width="16"> --%>
<%-- 				<aui:field-wrapper cssClass="smallLabel" label="<%= LanguageUtil.get(pageContext, \"chua-kiem-dem\") + dotLabel +\" \"+chuaKiemDem %>" inlineLabel="true"> --%>
<%-- 				</aui:field-wrapper> --%>
<%-- 			</aui:col> --%>
<%-- 			<aui:col width="16"> --%>
<%-- 			<aui:field-wrapper label="<%= LanguageUtil.get(pageContext, \"da-hoan-thanh\") + dotLabel+\" \"+daHoanThanh %>" inlineLabel="true"> --%>
<%-- 				</aui:field-wrapper> --%>
<%-- 			</aui:col> --%>
<%-- 			<aui:col width="16"> --%>
<%-- 			<aui:field-wrapper label="<%= LanguageUtil.get(pageContext, \"danh-gia-kiem-dem-1\") + dotLabel+\" \"+kiemDemDat %>" inlineLabel="true"> --%>
<%-- 				</aui:field-wrapper> --%>
<%-- 			</aui:col> --%>
<%-- 			<aui:col width="16"> --%>
<%-- 			<aui:field-wrapper label="<%= LanguageUtil.get(pageContext, \"danh-gia-kiem-dem-2\") + dotLabel+\" \"+kiemDemKhongDat %>" inlineLabel="true"> --%>
<%-- 				</aui:field-wrapper> --%>
<%-- 			</aui:col> --%>
<%-- 		</aui:row> --%>
 		<aui:row>
			<aui:col width="16">
				<aui:field-wrapper label="<%= LanguageUtil.get(pageContext, \"tong-ve-sinh-toan-xa\") + dotLabel + \" \" + tongDauNoiGd %>" inlineLabel="true">
				</aui:field-wrapper>
			</aui:col>
			<aui:col width="16">
				<aui:field-wrapper cssClass="smallLabel" label="<%= LanguageUtil.get(pageContext, \"chua-kiem-dem\") + dotLabel +\" \"+chuaKiemDemGd %>" inlineLabel="true">
				</aui:field-wrapper>
			</aui:col>
			<aui:col width="16">
			<aui:field-wrapper label="<%= LanguageUtil.get(pageContext, \"da-hoan-thanh\") + dotLabel+\" \"+daHoanThanhGd %>" inlineLabel="true">
				</aui:field-wrapper>
			</aui:col>
			<aui:col width="16">
			<aui:field-wrapper label="<%= LanguageUtil.get(pageContext, \"co-nha-ve-sinh\") + dotLabel+\" \"+coNhaVeSinhGd %>" inlineLabel="true">
				</aui:field-wrapper>
			</aui:col>
			<aui:col width="16">
			<aui:field-wrapper label="<%= LanguageUtil.get(pageContext, \"hop-ve-sinh\") + dotLabel+\" \"+coHVSGd %>" inlineLabel="true">
				</aui:field-wrapper>
			</aui:col>
			<aui:col width="16">
			<aui:field-wrapper label="<%= LanguageUtil.get(pageContext, \"hop-ve-sinh-xay-moi\") + dotLabel+\" \"+coHVSXayMoiGd %>" inlineLabel="true">
				</aui:field-wrapper>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col width="16">
				<aui:field-wrapper label="<%= LanguageUtil.get(pageContext, \"tong-ve-sinh-cong-trinh\") + dotLabel + \" \" + tongDauNoiCt %>" inlineLabel="true">
				</aui:field-wrapper>
			</aui:col>
			<aui:col width="16">
				<aui:field-wrapper cssClass="smallLabel" label="<%= LanguageUtil.get(pageContext, \"chua-kiem-dem\") + dotLabel +\" \"+chuaKiemDemCt %>" inlineLabel="true">
				</aui:field-wrapper>
			</aui:col>
			<aui:col width="16">
			<aui:field-wrapper label="<%= LanguageUtil.get(pageContext, \"da-hoan-thanh\") + dotLabel+\" \"+daHoanThanhCt %>" inlineLabel="true">
				</aui:field-wrapper>
			</aui:col>
			<aui:col width="16">
			<aui:field-wrapper label="<%= LanguageUtil.get(pageContext, \"danh-gia-kiem-dem-cong-trinh-1\") + dotLabel+\" \"+kiemDemDatCt %>" inlineLabel="true">
				</aui:field-wrapper>
			</aui:col>
			<aui:col width="16">
			<aui:field-wrapper label="<%= LanguageUtil.get(pageContext, \"danh-gia-kiem-dem-cong-trinh-2\") + dotLabel+\" \"+kiemDemKhongDatCt %>" inlineLabel="true">
				</aui:field-wrapper>
			</aui:col>
		</aui:row>
<liferay-util:include page='<%= "/html/portlet/kehoachkiemdemvesinh/top_tabs_detail.jsp" %>' servletContext="<%= application %>" />
				<div id="map" style="width: 100%; height: 400px;"></div>

  <script type="text/javascript" src='http://maps.google.com/maps/api/js?sensor=false&libraries=places'></script> 
  <script type="text/javascript">

  function initialize() {var locations = [
                                          <%for(int i=0; i < resultBase1.size(); i++){
                                        	  thongTin1 = ThongTinKiemDemHoGDLocalServiceUtil.fetchThongTinKiemDemHoGD(Integer.valueOf(resultBase1.get(i).getId()+""));
                                        	  if(thongTin1.getKinhDo() != "0 " && (thongTin1.getViDo() != "0")){
                                        	  String dkj = "'"+"<div style=\"float:left;\">"+thongTin1.getTenChuHo()+"<br/><img src=\""+host+thongTin1.getAnhToanCanh()+"\" width=\"200\"/></div><div style=\"float:left;padding-left: 10px;\"><br/>"+StringPool.BLANK+"<br/>"+StringPool.BLANK+"<br/>"+thongTin1.getTaiKhoan()+"<br/>"+StringPool.BLANK+"</div>"+"'";
                                        	  System.out.println(thongTin1.getViDo() + "- " +thongTin1.getKinhDo() );
                                        	  %>
                                          [<%=dkj%>, 
                                           <%=thongTin1.getViDo()%>, 
                                           	<%=thongTin1.getKinhDo()%>, 
                                           	<%=i+1%>],
                                         <%}}%> 
                                         
<%--                                           <%for(int i=0; i < resultBase2.size(); i++){
                                       	  thongTin2 = ThongTinKiemDemCongTrinhLocalServiceUtil.fetchThongTinKiemDemCongTrinh(Integer.valueOf(resultBase2.get(i).getId()+""));
                                       		if(Validator.isNotNull(thongTin2.getKinhDo()) && Validator.isNotNull(thongTin2.getViDo())){
                                       	  String dkj = "'"+"<div style=\"float:left;\">"+thongTin2.getTenCongTrinh()+"<br/><img src=\""+host+thongTin2.getAnhChupChungNhan()+"\" width=\"200\"/></div><div style=\"float:left;padding-left: 10px;\"><br/>"+StringPool.BLANK+"<br/>"+StringPool.BLANK+"<br/>"+thongTin2.getTaiKhoan()+"<br/>"+StringPool.BLANK+"</div>"+"'";
                                       	  %>
                                         [<%=dkj%>, 
                                          <%=thongTin2.getViDo()%>, 
                                          	<%=thongTin2.getKinhDo()%>, 
                                          	<%=i+1%>],
                                        <%}}%> 
 --%>                                          
                                          ];

                                      var map = new google.maps.Map(document.getElementById('map'), {
                                          zoom: 14,
                                          <%=map_elm%>,
                                          //center: new google.maps.LatLng(20.1291,105.3131),
                                          mapTypeId: google.maps.MapTypeId.ROADMAP,
                                          styles: [{
                                              featureType: 'parks',
                                              elementType: 'geometry',
                                              stylers: [{
                                                  color: "#8dc858"
                                              }]
                                          }, {
                                              featureType: 'road',
                                              elementType: 'geometry',
                                              stylers: [{
                                                  color: '#FFFFFF'
                                              }, {
                                                  weight: 0.6
                                              }]
                                          }, {
                                              featureType: 'landscape',
                                              elementType: 'geometry',
                                              stylers: [{
                                                  color: "#d7dfbd"
                                              }]
                                          }, {
                                              featureType: 'water',
                                              elementType: 'geometry',
                                              stylers: [{
                                                  color: "#647ca1"
                                              }]
                                          }, {
                                              featureType: 'transit.line',
                                              elementType: 'geometry',
                                              stylers: [{
                                                  color: "#696969"
                                              }]
                                          }]
                                      });

                                      var infowindow = new google.maps.InfoWindow();

                                      var marker, i;

                                      for (i = 0; i < locations.length; i++) {
                                          marker = new google.maps.Marker({
                                              position: new google.maps.LatLng(locations[i][1], locations[i][2]),
                                              map: map,
                                              icon: {
                                                  url: 'https://www.yorkshirewater.com/sites/default/files/styles/large/public/tap-with-water-icon.png',
                                                  scaledSize: new google.maps.Size(25, 25)

                                              }
                                          });

                                          google.maps.event.addListener(marker, 'click', (function (marker, i) {
                                              return function () {
                                                  infowindow.setContent(locations[i][0]);
                                                  infowindow.open(map, marker);
                                              }
                                          })(marker, i));
                                      }
  }

  google.maps.event.addDomListener(window, 'load', initialize);

  </script>
	</c:when>	
	
	<c:otherwise>
		<liferay-ui:message key="thong-tin-ke-hoach-khong-ton-tai"/>
	</c:otherwise>

</c:choose>

<aui:script>
function showDongKeHoachDialog(dongKeHoachURL)
{
    var r=confirm("B\u1EA1n c\u00F3 mu\u1ED1n \u0111\u00F3ng k\u1EBF ho\u1EA1ch ki\u1EC3m \u0111\u1EBFm n\u00E0y?");
    if (r==true)
    {
         window.location.href = dongKeHoachURL;
    }else{
    	return;
    }
}
</aui:script>
<style>
.btn.leftButon{
float: right !important;
margin-left: 20px !important;
}
.control-label{
width:155px !important;
}
</style>