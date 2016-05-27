<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="vn.dtt.sol.ns.util.DiaBanQuanLyUtils"%>
<%@page import="vn.dtt.sol.ns.business.DataItemBusiness"%>
<%@include file="../init.jsp" %>

<%
	String maTinh = ParamUtil.getString(request, "maTinh");
	String maHuyen = ParamUtil.getString(request, "maHuyen");
	long userIdSel = ParamUtil.getLong(request, "userIdSel");
	
	List<DATAITEM> lsXa = DiaBanQuanLyUtils.findXaTrongHuyenChonByUser(maTinh, maHuyen, userIdSel, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
%>

<%
	for (DATAITEM xa : lsXa) {
%>

	<div class="sel-xa">
		<aui:input type="checkbox" value="<%= xa.getNode3() %>" label="<%= xa.getName() %>" name='<%= maHuyen + "_selXaDel" %>'/>
	</div>

<%
	}
%>

