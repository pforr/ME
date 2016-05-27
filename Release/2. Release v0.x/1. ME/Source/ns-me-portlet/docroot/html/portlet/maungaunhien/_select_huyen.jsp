<%@page import="vn.dtt.sol.ns.util.WebKeys"%>
<%@page import="vn.dtt.sol.ns.business.DataItemBusiness"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@ include file="/init.jsp" %>

<%
	String maTinh = ParamUtil.getString(request, "capTinhId");
	
	List<DATAITEM> lsHuyen = DataItemBusiness.getInLevel2(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh, user);
	
	String selCapHuyen = ParamUtil.getString(request, "maHuyen");
%>

<aui:select name="maHuyen" id="maHuyen" label="ma-huyen" onChange="javascript:selectHuyen();" showEmptyOption="<%= true %>">
	<%
		for (DATAITEM huyen : lsHuyen) {
	%>
		<aui:option selected="<%= selCapHuyen.contentEquals(huyen.getNode2()) ? true : false %>" value="<%= huyen.getNode2() %>"><%= huyen.getName() %></aui:option>
	<%
		}
	%>
</aui:select>




