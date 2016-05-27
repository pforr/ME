<%@page import="vn.dtt.sol.ns.util.WebKeys"%>
<%@page import="vn.dtt.sol.ns.business.DataItemBusiness"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@ include file="/init.jsp" %>

<%
	String maTinh = ParamUtil.getString(request, "capTinhId");
	String maHuyen = ParamUtil.getString(request, "capHuyenId");
	String selMaXa = ParamUtil.getString(request, "maXa");
	
	List<DATAITEM> lsXa = DataItemBusiness.getInLevel3(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh, maHuyen);
%>

<aui:select name="maXa" id="maXa" label="ma-xa" onChange="javascript:selectInfo();" showEmptyOption="<%= true %>">
	<%
		for (DATAITEM xa : lsXa) {
	%>
		<aui:option selected="<%= selMaXa.contentEquals(xa.getNode3()) ? true : false %>" value="<%= xa.getNode3() %>"><%= xa.getName() %></aui:option>
	<%
		}
	%>
</aui:select>