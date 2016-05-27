<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="vn.dtt.sol.ns.business.UserMappingBusiness"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Calendar"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
 <%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>

<%@page import="javax.portlet.PortletURL"%>
<%@ page pageEncoding="UTF-8" %>
<portlet:defineObjects />
<%@include file="init.jsp" %>
<%
	//final Log _logdashboardview = LogFactoryUtil.getLog("html.portlet.dasboard.view.jsp");
	String ctxPath = request.getContextPath();

	Calendar cal = Calendar.getInstance();
		 
	int currYear = cal.get(Calendar.YEAR);
	int userType = UserMappingBusiness.getUserType(user);
	UserMapping userMapping = UserMappingBusiness.getUserMapping(user);
	String maTinh = userMapping.getOrgCode1();
	_logdashboardview.info("--html.portlet.dasboard.view_dashboard_tu.jsp--maTinh"+maTinh+"==="); 
%>




<ul>
	<%
		for (int year = 2015; year <= currYear; year++) {
	%>
		<portlet:renderURL var="rowURL">
			<portlet:param name="mvcPath" value='<%= templatePath + "dashboard_tu.jsp" %>' />
			<portlet:param name="namBaoCao" value="<%= Integer.toString(year)  %>"/>			
			<portlet:param name="isTrungUong" value="true"/>
		</portlet:renderURL>
		
		<li> <a href="<%= rowURL %>"><%= year %></a> </li>
	<%
		}
	%>
</ul>
