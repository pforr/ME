<%@page import="vn.dtt.sol.ns.vesinhmoitruong.terms.VeSinhGiaDinhTerms"%>
<%@page import="vn.dtt.sol.ns.daunoinuoc.search.DauNoiNuocDisplayTerms"%>
<%@page import="vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien"%>
<%@page import="vn.dtt.sol.ns.util.WebKeys"%>
<%@page import="vn.dtt.sol.ns.business.DataItemBusiness"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@ include file="/init.jsp" %>

<%
	String maTinh = ParamUtil.getString(request, "capTinhId");
	String maHuyen = ParamUtil.getString(request, "capHuyenId");
	String maKiemDemVien = ParamUtil.getString(request, "kiemDemVienId");
	String orgCode = StringPool.BLANK;
	
	if (Validator.isNotNull(maHuyen)) {
		orgCode = maHuyen;
	} else {
		orgCode = maTinh;
	}
	

	
	List<KiemDemVien> lsKiemDemVien = KiemDemVienLocalServiceUtil.findKiemDemVien("2", orgCode);

%>
<aui:select name="<%=VeSinhGiaDinhTerms.KIEM_DEM_VIEN %>"  id="<%=VeSinhGiaDinhTerms.KIEM_DEM_VIEN %>" label="<%= LanguageUtil.get(pageContext, \"kiem-dem-vien\") + \":\" %>" showEmptyOption="<%= false %>">
	<aui:option value=""><liferay-ui:message key="-chon-tat-ca-"></liferay-ui:message></aui:option>
	<%
		for (KiemDemVien kdv : lsKiemDemVien) {
	%>
		<aui:option value="<%= kdv.getTaiKhoan() %>" selected="<%=kdv.getTaiKhoan().equals(maKiemDemVien) %>"><%= kdv.getHoVaTen() %></aui:option>
	<%
		}
	%>
</aui:select>
