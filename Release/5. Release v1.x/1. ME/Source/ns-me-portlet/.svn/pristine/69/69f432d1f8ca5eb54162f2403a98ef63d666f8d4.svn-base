<%@page import="vn.dtt.sol.ns.util.WebKeys"%>
<%@page import="vn.dtt.sol.ns.business.DataItemBusiness"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@ include file="/init.jsp" %>

<%
	String maTinh = ParamUtil.getString(request, "capTinhId");
	String maHuyen = ParamUtil.getString(request, "capHuyenId");
	
	String initTinh = ParamUtil.getString(request, "initTinh");
	String initHuyen = ParamUtil.getString(request, "initHuyen");
	String initXa = ParamUtil.getString(request, "initXa");
	
	String selCapHuyenId = ParamUtil.getString(request, "capHuyenIdSel");
	
	if(Validator.isNull(maTinh)) {
		maTinh = initTinh;
	}
	
	List<DATAITEM> lsHuyen = DataItemBusiness.getInLevel2(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh);
	
%>

<aui:select name="maHuyen" id="maHuyen" onChange="javascript:selectXa();" label="maHuyen" showEmptyOption="<%= false %>">
	<aui:option value=""><liferay-ui:message key="-chon-tat-ca-"></liferay-ui:message></aui:option>
	<%
		for (DATAITEM huyen : lsHuyen) {
	%>
		<aui:option selected="<%= selCapHuyenId.contentEquals(huyen.getNode2()) ? true : false %>" value="<%= huyen.getNode2() %>"><%= huyen.getName() %></aui:option>
	<%
		}
	%>
</aui:select>




