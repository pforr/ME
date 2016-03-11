<%@page import="vn.dtt.cmon.user.dao.service.UserTramCapLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="org.hsqldb.rights.UserManager"%>
<%@page import="vn.dtt.cmon.user.dao.service.UserHuyenLocalServiceUtil"%>
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
	String maTramCap = ParamUtil.getString(request, "maTramCap");
	String maGiamSatVien = ParamUtil.getString(request, "giamSatVienId","0");
	String orgCode = StringPool.BLANK;
	System.out.println("giamSatVienId "+maGiamSatVien);
	
	if (Validator.isNull(maGiamSatVien) || maGiamSatVien.contentEquals("")) {
		maGiamSatVien="0";
	}
	if (Validator.isNotNull(maHuyen)) {
		orgCode = maHuyen;
	} else {
		orgCode = maTinh;
	}
	

	
	
	List<UserMapping> lsGiamSatVien = UserTramCapLocalServiceUtil.findUserInTramCap(maTinh, maTramCap, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			//UserHuyenLocalServiceUtil.getGSVInHuyen(maTinh, maHuyen, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
	
	//List<KiemDemVien> lsKiemDemVien = KiemDemVienLocalServiceUtil.findKiemDemVien("2", orgCode);

%>
<aui:select name="<%=DauNoiNuocDisplayTerms.GIAM_SAT_VIEN_ID %>"  id="<%=DauNoiNuocDisplayTerms.GIAM_SAT_VIEN_ID %>" label="giamsatvien" showEmptyOption="<%= false %>">
	<aui:option value=""><liferay-ui:message key="-chon-tat-ca-"></liferay-ui:message></aui:option>
	<%
		for (UserMapping gsv : lsGiamSatVien) {
	%>
		<aui:option value="<%= gsv.getUserId() %>" selected="<%=gsv.getUserId() == (Long.parseLong(maGiamSatVien)) %>"><%= gsv.getName() %></aui:option>
	<%
		}
	%>
</aui:select>
