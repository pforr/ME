<%@page import="vn.dtt.sol.ns.util.WebKeys"%>
<%@page import="vn.dtt.sol.ns.business.DataItemBusiness"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>

<%@ include file="../init.jsp" %>

<%
	String maTinh = ParamUtil.getString(request, "capTinhId");


	
	List<DATAITEM> lsHuyen = DataItemBusiness.getInLevel2(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh);
%>


<aui:select name="maHuyen" id="maHuyen" onChange="javascript:changeHuyenOpt();" showEmptyOption="<%= true %>">
	<%
		for (DATAITEM huyen : lsHuyen) {
	%>
		<aui:option value="<%= huyen.getNode2() %>"><%= huyen.getName() %></aui:option>
	<%
		}
	%>
</aui:select>

<portlet:renderURL var="requestHuyenURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="mvcPath" value="/html/portlet/usermapping/userhuyen/_select_xa.jsp"/>
</portlet:renderURL>




