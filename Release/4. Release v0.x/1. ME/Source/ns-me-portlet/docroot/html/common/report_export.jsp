<%@page import="vn.dtt.sol.ns.business.DataItemBusiness"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@page import="vn.dtt.sol.ns.reporting.utils.ReportConstant"%>
<%@page import="vn.dtt.sol.ns.reporting.utils.ReportUtils"%>
<%@page import="vn.dtt.sol.ns.reporting.utils.ReportBusinessUtils"%>
<%@include file="/init.jsp" %>
<%@page pageEncoding="UTF-8"%>

<%
	final Log log = LogFactoryUtil.getLog("html.common.report_export.jsp");
//so bao cao, nguoi lap, nguoi duyet, ngay bao cao, thang bao cao, nam bao cao
	//String trangThai = ParamUtil.getString(request, "trangThai");// fix  = 2
	/*  start input  */
	String type = ParamUtil.getString(request, "type");
	String duoiFile = ParamUtil.getString(request, "duoiFile");
	String thoiGianThuc = ParamUtil.getString(request, "thoiGianThuc");
	
	
	String maTinh = ParamUtil.getString(request, "maTinh");
	String namBaoCao = ParamUtil.getString(request, "namBaoCao");	
	String soBaoCao = ParamUtil.getString(request, "soBaoCao");
	String nguoiLap = ParamUtil.getString(request, "nguoiLap");
	String nguoiDuyet = ParamUtil.getString(request, "nguoiDuyet");
	String ngayBaoCao = ParamUtil.getString(request, "ngayBaoCao");
	
	/*  end input  */
	String tenFileExport = ReportConstant.TEN_FILE_DEFAULT+"."+duoiFile;
	String fileName = "";
	String urlFileDowLoad = "";
	String urlFile = "";
	String realPath = "";
	log.info("==report_export.jsp======tenFileExport==macdinh==" + tenFileExport);
	
	realPath=ReportUtils.getTemplateReportFilePath(request);
	urlFile="/"+portletSession.getPortletContext().getPortletContextName()+"/"+ReportUtils.PATH_FILE_EXPORT+"/"+tenFileExport;
	
	
	if(Validator.isNotNull(maTinh)
			&& Validator.isNotNull(namBaoCao) 
			&& Validator.isNotNull(thoiGianThuc) 
			&& Validator.isNotNull(type) 
			&& type.trim().equalsIgnoreCase(ReportConstant.DLI1_1_TONGHOP_SO_DAU_NOI_MOI_HOAT_DONG)){
		log.info("==type--"+type);
		log.info("---report_export.jsp-----namBaoCao=="+namBaoCao+"==maTinh--"+maTinh+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		fileName = ReportBusinessUtils.actionExport_Dli_11_TH(realPath, namBaoCao, maTinh,soBaoCao,ngayBaoCao,nguoiLap,nguoiDuyet,duoiFile,thoiGianThuc); 
	}
	
	if(Validator.isNotNull(maTinh)
			&& Validator.isNotNull(namBaoCao) 
			&& Validator.isNotNull(thoiGianThuc) 
			&& Validator.isNotNull(type)
			&& type.trim().equalsIgnoreCase(ReportConstant.DLI1_1_CHITIET_DSDAU_NOI_MOI_CAP_NUOC)){
		log.info("==type--"+type);
		log.info("---report_export.jsp-----namBaoCao=="+namBaoCao+"==maTinh--"+maTinh+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		fileName = ReportBusinessUtils.actionExport_Dli_11_CT(realPath, namBaoCao, maTinh,soBaoCao,ngayBaoCao,nguoiLap,nguoiDuyet,duoiFile,thoiGianThuc); 		
	}
	
	if(Validator.isNotNull(maTinh)
			&& Validator.isNotNull(namBaoCao) 
			&& Validator.isNotNull(thoiGianThuc) 
			&& Validator.isNotNull(type) 
			&& type.trim().equalsIgnoreCase(ReportConstant.DLI1_2_TH)){
		log.info("==type--"+type);
		log.info("---report_export.jsp-----namBaoCao=="+namBaoCao+"==maTinh--"+maTinh+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		fileName = ReportBusinessUtils.actionExport_Dli_12_TH(realPath, namBaoCao, maTinh,soBaoCao,ngayBaoCao,nguoiLap,nguoiDuyet,duoiFile,thoiGianThuc); 	
	}
	
	if(Validator.isNotNull(maTinh)
			&& Validator.isNotNull(namBaoCao) 
			&& Validator.isNotNull(thoiGianThuc) 
			&& Validator.isNotNull(type) 
			&& type.trim().equalsIgnoreCase(ReportConstant.DLI1_2_CT)){
		log.info("==type--"+type);
		log.info("---report_export.jsp-----namBaoCao=="+namBaoCao+"==maTinh--"+maTinh+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		fileName = ReportBusinessUtils.actionExport_Dli_12_CT(realPath, namBaoCao, maTinh,soBaoCao,ngayBaoCao,nguoiLap,nguoiDuyet,duoiFile,thoiGianThuc); 	
	}
	
	if(Validator.isNotNull(maTinh)
			&& Validator.isNotNull(namBaoCao) 
			&& Validator.isNotNull(type) 
			&& type.trim().equalsIgnoreCase(ReportConstant.DLI2_1_SNDTCHTCNBV)){
		log.info("==type--"+type);
		log.info("---report_export.jsp-----namBaoCao=="+namBaoCao+"==maTinh--"+maTinh+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		fileName = ReportBusinessUtils.actionExport_Dli_21(realPath, namBaoCao, maTinh,soBaoCao,ngayBaoCao,nguoiLap,nguoiDuyet,duoiFile); 		
	}
	
	
	
	if(Validator.isNotNull(maTinh)
			&& Validator.isNotNull(namBaoCao) 
			&& Validator.isNotNull(type) 
			&& type.trim().equalsIgnoreCase(ReportConstant.DLI2_2)){
		log.info("==type--"+type);
		log.info("---report_export.jsp-----namBaoCao=="+namBaoCao+"==maTinh--"+maTinh+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		fileName = ReportBusinessUtils.actionExport_Dli_22(realPath, namBaoCao, maTinh,soBaoCao,ngayBaoCao,nguoiLap,nguoiDuyet,duoiFile); 		
	}
	
	if( Validator.isNotNull(maTinh)
			&& Validator.isNotNull(namBaoCao) 
			&& Validator.isNotNull(type) 
			&& type.trim().equalsIgnoreCase(ReportConstant.DLI3)){
		log.info("==type--"+type);
		log.info("---report_export.jsp-----namBaoCao=="+namBaoCao+"==maTinh--"+maTinh+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		fileName = ReportBusinessUtils.actionExport_Dli_3(realPath, namBaoCao, maTinh,soBaoCao,ngayBaoCao,nguoiLap,nguoiDuyet,duoiFile); 		

	}

	if( Validator.isNotNull(maTinh)
			&& Validator.isNotNull(namBaoCao) 
			&& Validator.isNotNull(type) 
			&& type.trim().equalsIgnoreCase(ReportConstant.DLI_TH)){
		log.info("==type--"+type);
		log.info("---report_export.jsp-----namBaoCao=="+namBaoCao+"==maTinh--"+maTinh+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		fileName = ReportBusinessUtils.actionExport_Dli_TH(realPath, namBaoCao, maTinh,soBaoCao,ngayBaoCao,nguoiLap,nguoiDuyet,duoiFile); 		
	}
	
	if( Validator.isNotNull(maTinh)
			&& Validator.isNotNull(namBaoCao) 
			&& Validator.isNotNull(type) 
			&& type.trim().equalsIgnoreCase(ReportConstant.THDK_DNSDN)){
		log.info("==type--"+type);
		log.info("---report_export.jsp-----namBaoCao=="+namBaoCao+"==maTinh--"+maTinh+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		fileName = ReportBusinessUtils.actionExport_THDK_DNSDN(realPath, namBaoCao, maTinh,soBaoCao,ngayBaoCao,nguoiLap,nguoiDuyet,duoiFile); 		
	}
	
	if( Validator.isNotNull(maTinh)
			&& Validator.isNotNull(namBaoCao) 
			&& Validator.isNotNull(type) 
			&& type.trim().equalsIgnoreCase(ReportConstant.THDK_NTHVSXM)){
		log.info("==type--"+type);
		log.info("---report_export.jsp-----namBaoCao=="+namBaoCao+"==maTinh--"+maTinh+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		fileName = ReportBusinessUtils.actionExport_THDK_NTHVSXM(realPath, namBaoCao, maTinh,soBaoCao,ngayBaoCao,nguoiLap,nguoiDuyet,duoiFile); 		
	}
	
	if( Validator.isNotNull(maTinh)
			&& Validator.isNotNull(namBaoCao) 
			&& Validator.isNotNull(type) 
			&& type.trim().equalsIgnoreCase(ReportConstant.TDTHCNTT)){
		log.info("==type--"+type);
		log.info("---report_export.jsp-----namBaoCao=="+namBaoCao+"==maTinh--"+maTinh+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		fileName = ReportBusinessUtils.actionExport_TDTHCNTT(realPath, namBaoCao, maTinh,soBaoCao,ngayBaoCao,nguoiLap,nguoiDuyet,duoiFile); 		
	}
	
	if (fileName.trim().length() > 0) {
		tenFileExport = fileName;
		log.info("==report_export.jsp======tenFileExport===" + tenFileExport);

		urlFile = request.getContextPath() + "/"+ReportUtils.PATH_FILE_EXPORT+"/" + tenFileExport;
		
	}
	
	log.info("UrlFile====" + urlFile);
	//urlFileDowLoad = urlFile.replace(".pdfs", ".pdf");
	urlFileDowLoad = urlFile;
%>

<div align="center">
	
	
	
	<OBJECT data="<%=urlFileDowLoad%>#view=FitH&scrollbar=0&amp;page=1&toolbar=0&statusbar=0&messages=0&navpanes=0"
		type="application/pdf" TITLE="Báo cáo" 
		WIDTH="100%" HEIGHT="900px"
		style="background: white; min-height: 100%;" >
			
	</OBJECT>
	
	
	<a href="<%=urlFileDowLoad%>">Tải xuống file</a> 
</div>