<%@page import="vn.dtt.sol.ns.baocaodli.util.BaoCaoDLIConstants"%>
<%@page import="vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLI"%>

<%@include file="init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true" var="typeDLIURL">	
	<liferay-portlet:param  name="portletResource" value="<%= portletResource %>"/>
</liferay-portlet:actionURL>


<aui:form name="menu-vbpq-config-form" method="post" action="<%= typeDLIURL %>">
		<aui:select name="typeDLI" label="bao-cao-dli">
			<aui:option selected="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_1_1 ? true : false %>" value="<%= BaoCaoDLIConstants.BAO_CAO_DLI_1_1 %>"><liferay-ui:message key="bao-cao-1-1"/></aui:option>
			<aui:option selected="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_1_2 ? true : false %>" value="<%= BaoCaoDLIConstants.BAO_CAO_DLI_1_2 %>"><liferay-ui:message key="bao-cao-1-2"/></aui:option>
			<aui:option selected="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_2_1 ? true : false %>" value="<%= BaoCaoDLIConstants.BAO_CAO_DLI_2_1 %>"><liferay-ui:message key="bao-cao-2-1"/></aui:option>
			<aui:option selected="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_2_2 ? true : false %>" value="<%= BaoCaoDLIConstants.BAO_CAO_DLI_2_2 %>"><liferay-ui:message key="bao-cao-2-2"/></aui:option>
			<aui:option selected="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_3 ? true : false %>" value="<%= BaoCaoDLIConstants.BAO_CAO_DLI_3 %>"><liferay-ui:message key="bao-cao-3"/></aui:option>
			<aui:option selected="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_TH ? true : false %>" value="<%= BaoCaoDLIConstants.BAO_CAO_DLI_TH %>"><liferay-ui:message key="bao-cao-th"/></aui:option>
			<aui:option selected="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_TDCNTT ? true : false %>" value="<%= BaoCaoDLIConstants.BAO_CAO_DLI_TDCNTT %>"><liferay-ui:message key="bao-cao-tien-do-cap-nuoc-tap-trung"/></aui:option>
			<aui:option selected="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_KQXNN ? true : false %>" value="<%= BaoCaoDLIConstants.BAO_CAO_DLI_KQXNN %>"><liferay-ui:message key="bao-cao-ket-qua-xet-nghiem-nuoc"/></aui:option>
			<aui:option selected="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_BCHNT ? true : false %>" value="<%= BaoCaoDLIConstants.BAO_CAO_DLI_BCHNT %>"><liferay-ui:message key="bao-cao-hop-nhat-tinh"/></aui:option>
			<aui:option selected="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_THVG ? true : false %>" value="<%= BaoCaoDLIConstants.BAO_CAO_DLI_THVG %>"><liferay-ui:message key="bao-cao-tong-hop-ve-gioi"/></aui:option>
			
			<aui:option selected="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_THONG_KE_DNN ? true : false %>" value="<%= BaoCaoDLIConstants.BAO_CAO_THONG_KE_DNN %>"><liferay-ui:message key="bao-cao-thong-ke-dnn"/></aui:option>
			<aui:option selected="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_THONG_KE_VSXM ? true : false %>" value="<%= BaoCaoDLIConstants.BAO_CAO_THONG_KE_VSXM %>"><liferay-ui:message key="bao-cao-thong-ke-vsxm"/></aui:option>
			<aui:option selected="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_THONG_KE_CTCC ? true : false %>" value="<%= BaoCaoDLIConstants.BAO_CAO_THONG_KE_CTCC %>"><liferay-ui:message key="bao-cao-thong-ke-ctcc"/></aui:option>
			<aui:option selected="<%= typeDLI == BaoCaoDLIConstants.BAO_CAO_THONG_KE_VSTX ? true : false %>" value="<%= BaoCaoDLIConstants.BAO_CAO_THONG_KE_VSTX %>"><liferay-ui:message key="bao-cao-thong-ke-vstx"/></aui:option>
		</aui:select>
		
		<aui:input name="isRealTimeReport" checked="<%= isRealTimeReport %>" type="checkbox" label="la-bao-cao-thoi-gian-thuc"></aui:input>
		
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button type="cancel"/>
		</aui:button-row>
</aui:form>