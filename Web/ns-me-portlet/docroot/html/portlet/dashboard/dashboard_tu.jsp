<%@page import="vn.dtt.sol.ns.reporting.utils.ReportConstant"%>
<%@page
	import="vn.dtt.sol.ns.reporting.model.dlith.TomTatTDTHCSGiaiNgan"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="vn.dtt.sol.ns.business.UserMappingBusiness"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Calendar"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>

<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>

<%@page import="javax.portlet.PortletURL"%>
<%@ page pageEncoding="UTF-8"%>
<portlet:defineObjects />
<%@include file="init.jsp"%>
<%
	//final Log _logdashboardview = LogFactoryUtil.getLog("html.portlet.dasboard.view.jsp");
	String ctxPath = request.getContextPath();

	Calendar cal = Calendar.getInstance();
		 
	int currYear = cal.get(Calendar.YEAR);
	UserMapping userMapping = UserMappingBusiness.getUserMapping(user);
	String maTinh = userMapping.getOrgCode1();
	_logdashboardview.info("--html.portlet.dasboard.dashboard_tu.jsp--maTinh"+maTinh+"==="); 
	
	String namBaoCao = ParamUtil.getString(request, "namBaoCao");
	String imgDLI11 = (String) renderRequest.getAttribute("imgDLI11");
	String imgDLI12 = (String) renderRequest.getAttribute("imgDLI12");
	String imgDLI21 = (String) renderRequest.getAttribute("imgDLI21");
	String imgDLI22 = (String) renderRequest.getAttribute("imgDLI22");
	List<TomTatTDTHCSGiaiNgan> lstDli11 = (List<TomTatTDTHCSGiaiNgan>)renderRequest.getAttribute("lstDLI11");
	List<TomTatTDTHCSGiaiNgan> lstDli12 = (List<TomTatTDTHCSGiaiNgan>)renderRequest.getAttribute("lstDLI12");
	List<TomTatTDTHCSGiaiNgan> lstDli21 = (List<TomTatTDTHCSGiaiNgan>)renderRequest.getAttribute("lstDLI21");
	List<TomTatTDTHCSGiaiNgan> lstDli22 = (List<TomTatTDTHCSGiaiNgan>)renderRequest.getAttribute("lstDLI22");
%>




<portlet:actionURL name="piechart" var="piechartURL" />
<ul>
	<%
		for (int year = 2015; year <= currYear; year++) {
	%>
	<portlet:renderURL var="rowURL">
		<portlet:param name="mvcPath" value='<%= templatePath + "dashboard_tu.jsp" %>' />
		<portlet:param name="namBaoCao" value="<%= Integer.toString(year)  %>" />
		<portlet:param name="isTrungUong" value="true" />
	</portlet:renderURL>

	<li><a href="<%= rowURL %>"><%= year %></a></li>
	<%
		}
	%>
</ul>

<liferay-portlet:renderURL varImpl="searchURL" windowState="<%=LiferayWindowState.NORMAL.toString()%>">
	<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>' />
	<portlet:param name="namBaoCao"
		value="<%= Integer.toString(currYear-1) %>" />
</liferay-portlet:renderURL>



<aui:form name="piechartfrm" action="${piechartURL}" method="POST">


	<aui:layout>
		<aui:row>
			<aui:column>
				<aui:fieldset>
					<img src="<%= ctxPath %>/images/<%=imgDLI11 %>" alt="DLI 1.1" height="300" width="200">
				</aui:fieldset>
			</aui:column>

			<aui:column>
			<br />
			<br />
				<%
			for(TomTatTDTHCSGiaiNgan thongtin : lstDli11){
				%>
				<aui:row>
					<aui:fieldset>
						<liferay-portlet:renderURL var="viewBaoCaoDLIDialogDLI11" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
							<portlet:param name="mvcPath" value='<%= templatePath + "view_report.jsp" %>' />
							<portlet:param name="maTinh" value='<%=thongtin.getMaTinh() %>' />
							<portlet:param name="namBaoCao" value='<%=namBaoCao %>' />
							<portlet:param name="type" value="<%=ReportConstant.DLI1_1_TH%>" />
						</liferay-portlet:renderURL>
						<aui:script>
						AUI().use('aui-base','aui-io-plugin-deprecated','liferay-util-window',function(A) {
							A.one('#<portlet:namespace /><%="viewdli11"+thongtin.getMaTinh() %>').on('click', function(event){
							var popUpWindow=Liferay.Util.Window.getWindow(
							{
								dialog: {
									centered: true,
									constrain2view: true,
									modal: true,
									resizable: false,
									width: screen.width * 0.8,
									height:  screen.height * 0.9
								}
							}
							).plug(A.Plugin.IO,{autoLoad: false}).render();
							popUpWindow.show();
							popUpWindow.titleNode.html("<liferay-ui:message key="bao-cao-title" /> DLI 1.1");
							popUpWindow.io.set('uri','<%=viewBaoCaoDLIDialogDLI11.toString()%>');
							popUpWindow.io.start();
							});
						});
						</aui:script>
						<aui:a id="<%=\"viewdli11\"+thongtin.getMaTinh() %>" href="#" onClick="<%=viewBaoCaoDLIDialogDLI11.toString()%>">
							<%= thongtin.getTenTinh() %> <%= thongtin.getSoDauNoiThucHienKH() %>
						</aui:a>
					</aui:fieldset>
				</aui:row>
				<% 
			}
			%>


			</aui:column>
			<aui:column>
				<aui:fieldset>
					<img src="<%= ctxPath %>/images/<%=imgDLI12 %>" alt="DLI 1.2" height="300" width="200">
				</aui:fieldset>
			</aui:column>
			<aui:column>
			<br />
			<br />
				<%
			for(TomTatTDTHCSGiaiNgan thongtin : lstDli12){
				%>
				<aui:row>
					<aui:fieldset>
						<liferay-portlet:renderURL var="viewBaoCaoDLIDialogDLI12" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
							<portlet:param name="mvcPath" value='<%= templatePath + "view_report.jsp" %>' />
							<portlet:param name="maTinh" value='<%=thongtin.getMaTinh() %>' />
							<portlet:param name="namBaoCao" value='<%=namBaoCao %>' />
							<portlet:param name="type" value="<%=ReportConstant.DLI1_2_TH%>" />
						</liferay-portlet:renderURL>
						<aui:script>
						AUI().use('aui-base','aui-io-plugin-deprecated','liferay-util-window',function(A) {
							A.one('#<portlet:namespace /><%="viewdli12"+thongtin.getMaTinh() %>').on('click', function(event){
							var popUpWindow=Liferay.Util.Window.getWindow(
							{
								dialog: {
									centered: true,
									constrain2view: true,
									modal: true,
									resizable: false,
									width: screen.width * 0.8,
									height:  screen.height * 0.9
								}
							}
							).plug(A.Plugin.IO,{autoLoad: false}).render();
							popUpWindow.show();
							popUpWindow.titleNode.html("<liferay-ui:message key="bao-cao-title" /> DLI 1.2");
							popUpWindow.io.set('uri','<%=viewBaoCaoDLIDialogDLI12.toString()%>');
							popUpWindow.io.start();
							});
						});
						</aui:script>
						<aui:a id="<%=\"viewdli12\"+thongtin.getMaTinh() %>" href="#" onClick="<%=viewBaoCaoDLIDialogDLI12.toString()%>">
							<%= thongtin.getTenTinh() %> <%= thongtin.getSoNhaTieuHGDXayMoiThucHienKH() %>
						</aui:a>
					</aui:fieldset>
				</aui:row>
				<% 
			}
			%>

			</aui:column>
		</aui:row>
		<aui:row>
			<aui:column>
				<aui:fieldset>
					<img src="<%= ctxPath %>/images/<%=imgDLI21 %>" alt="DI 2.1" height="300" width="200">
				</aui:fieldset>
			</aui:column>
			<aui:column>
			<br />
			<br />
				<%
			for(TomTatTDTHCSGiaiNgan thongtin : lstDli21){
				%>
				<aui:row>
					<aui:fieldset>
						<liferay-portlet:renderURL var="viewBaoCaoDLIDialogDLI21" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
							<portlet:param name="mvcPath" value='<%= templatePath + "view_report.jsp" %>' />
							<portlet:param name="maTinh" value='<%=thongtin.getMaTinh() %>' />
							<portlet:param name="namBaoCao" value='<%=namBaoCao %>' />
							<portlet:param name="type" value="<%=ReportConstant.DLI2_1%>" />
						</liferay-portlet:renderURL>
						<aui:script>
						AUI().use('aui-base','aui-io-plugin-deprecated','liferay-util-window',function(A) {
							A.one('#<portlet:namespace /><%="viewdli21"+thongtin.getMaTinh() %>').on('click', function(event){
							var popUpWindow=Liferay.Util.Window.getWindow(
							{
								dialog: {
									centered: true,
									constrain2view: true,
									modal: true,
									resizable: false,
									width: screen.width * 0.8,
									height:  screen.height * 0.9
								}
							}
							).plug(A.Plugin.IO,{autoLoad: false}).render();
							popUpWindow.show();
							popUpWindow.titleNode.html("<liferay-ui:message key="bao-cao-title" /> DLI 2.1");
							popUpWindow.io.set('uri','<%=viewBaoCaoDLIDialogDLI21.toString()%>');
							popUpWindow.io.start();
							});
						});
						</aui:script>
						<aui:a id="<%=\"viewdli21\"+thongtin.getMaTinh() %>" href="#" onClick="<%=viewBaoCaoDLIDialogDLI21.toString()%>">
							<%= thongtin.getTenTinh() %> <%= thongtin.getSoNgHgLoiTuCapNcBenVungThucHienKH() %>
						</aui:a>
					</aui:fieldset>
				</aui:row>
				<% 
			}
			%>
			</aui:column>
			<aui:column>
				<aui:fieldset>
					<img src="<%= ctxPath %>/images/<%=imgDLI22 %>" alt="DLI 2.2" height="300" width="200">
				</aui:fieldset>
			</aui:column>
			<aui:column>
			<br />
			<br />
				<%
			for(TomTatTDTHCSGiaiNgan thongtin : lstDli22){
				%>
				<aui:row>
					<aui:fieldset>
						<liferay-portlet:renderURL var="viewBaoCaoDLIDialogDLI22" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
							<portlet:param name="mvcPath" value='<%= templatePath + "view_report.jsp" %>' />
							<portlet:param name="maTinh" value='<%=thongtin.getMaTinh() %>' />
							<portlet:param name="namBaoCao" value='<%=namBaoCao %>' />
							<portlet:param name="type" value="<%=ReportConstant.DLI2_2%>" />
						</liferay-portlet:renderURL>
						<aui:script>
						AUI().use('aui-base','aui-io-plugin-deprecated','liferay-util-window',function(A) {
							A.one('#<portlet:namespace /><%="viewdli22"+thongtin.getMaTinh() %>').on('click', function(event){
							var popUpWindow=Liferay.Util.Window.getWindow(
							{
								dialog: {
									centered: true,
									constrain2view: true,
									modal: true,
									resizable: false,
									width: screen.width * 0.8,
									height:  screen.height * 0.9
								}
							}
							).plug(A.Plugin.IO,{autoLoad: false}).render();
							popUpWindow.show();
							popUpWindow.titleNode.html("<liferay-ui:message key="bao-cao-title" /> DLI 2.2");
							popUpWindow.io.set('uri','<%=viewBaoCaoDLIDialogDLI22.toString()%>');
							popUpWindow.io.start();
							});
						});
						</aui:script>
						<aui:a id="<%=\"viewdli22\"+thongtin.getMaTinh() %>" href="#" onClick="<%=viewBaoCaoDLIDialogDLI22.toString()%>">
							<%= thongtin.getTenTinh() %> <%= thongtin.getSoNgHgLoiTuVSTXThucHienKH() %>
						</aui:a>
					</aui:fieldset>
				</aui:row>
				<% 
			}
			%>

			</aui:column>
		</aui:row>

	</aui:layout>
</aui:form>