
package vn.dtt.sol.ns.reporting.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ReportUtils {
	
	private static Log _log = LogFactoryUtil.getLog(ReportUtils.class);
	
	public static final String PATH_FILE_REPORT = "report";
	public static final String PATH_FILE_EXPORT = "export";

	public static final String DLI_1_1 = "dli1_1";
	public static final String DLI_1_2 = "dli1_2";
	public static final String DLI_2_1 = "dli2_1";
	public static final String DLI_2_2 = "dli2_2";
	public static final String DLI_3 = "dli3";
	public static final String DLI_TH = "dli_th";
	
	public static final String TONGHOPDUKIEN = "tonghopdukien";
	public static final String BAOCAOMOI = "baocaomoi";
	
	public static String getTemplateReportFilePath(HttpServletRequest request, String reportOrexport, String fileName) {
		
		return request.getSession().getServletContext().getRealPath("/").replace("/", File.separator).replace(File.separator + ".", "") +
			reportOrexport + File.separator + fileName;
		/**
		 * ResourceRequest
		 *
		 * return resourceRequest.getPortletSession().getPortletContext().getRealPath("/").
		 * replace("/", File.separator).replace(File.separator + ".", "") + File.separator + reportOrexport + File.separator + fileName;
		 * */
	}
	
	public static String getTemplateReportFilePath(PortletSession session) {
		

		return session.getPortletContext().getRealPath("/").replace("/", File.separator).replace(File.separator + ".", "");
		/**
		 * ResourceRequest
		 *
		 * return resourceRequest.getPortletSession().getPortletContext().getRealPath("/").
		 * replace("/", File.separator).replace(File.separator + ".", "") + File.separator + reportOrexport + File.separator + fileName;
		 * */
	}
	
	public static String getTemplateReportFilePath(ResourceRequest request) {
		return request.getPortletSession().getPortletContext().getRealPath("/").replace("/", File.separator).replace(File.separator + ".", "");
		
	}
	
	public static String getTemplateReportFilePath(HttpServletRequest request) {
		
		return request.getSession().getServletContext().getRealPath("/").replace("/", File.separator).replace(File.separator + ".", "");
		/**
		 * ResourceRequest
		 *
		 * return resourceRequest.getPortletSession().getPortletContext().getRealPath("/").
		 * replace("/", File.separator).replace(File.separator + ".", "") + File.separator + reportOrexport + File.separator + fileName;
		 * */
	}
	
	

	/*
	 * Function Export to Server
	 */
	public static String exportFunction(
			String realPath, String dirParent, String tenFile_Template, String tenFile_Export, JRDataSource dataSource, Map<String, Object> parameters,String duoiFile) 
		throws IOException {
		
		
		
		String tenFile = tenFile_Export+"."+duoiFile;
		
		InputStream inputStream = null;
		
		try {
			String pathTemplate = realPath + PATH_FILE_REPORT + File.separator + dirParent + File.separator + tenFile_Template;
			inputStream = new FileInputStream(pathTemplate);
			
			JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			if(duoiFile.equalsIgnoreCase(ReportConstant.DUOI_XLS)){
				parameters.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);
				parameters.put("TYPE_EXPORT", "XLS");
			}
			parameters.put("SUBREPORT_DIR", realPath + PATH_FILE_REPORT + File.separator + dirParent + File.separator);
			parameters.put("IMG_DIR", realPath + PATH_FILE_REPORT + File.separator + "img" + File.separator);
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
			String pathExport = realPath + PATH_FILE_EXPORT + File.separator + tenFile;
			
			
			JasperExportManager.exportReportToPdfFile(jasperPrint, pathExport);
			
			_log.info("==exportFunction=="+pathExport);
			
			if(duoiFile.equalsIgnoreCase(ReportConstant.DUOI_PDF)){
				JasperExportManager.exportReportToPdfFile(jasperPrint, pathExport);
			}else if(duoiFile.equalsIgnoreCase(ReportConstant.DUOI_XLS)){
				makeExcelXlsReport(jasperPrint, pathExport  );
			}else if(duoiFile.equalsIgnoreCase(ReportConstant.DUOI_DOC)){
				makeWordDocReport(jasperPrint, pathExport);			
			}
		} catch (Exception e) {
			
			tenFile = ReportConstant.TEN_FILE_DEFAULT+"."+duoiFile;
			
			_log.error(e);
		} finally {
			if(inputStream != null) {
				inputStream.close();
			}
		}
		
		return tenFile;
	}
	
	 public static void makeWordDocReport(JasperPrint jasperPrint, String pathExport ) throws IOException {
		 ByteArrayOutputStream baoxDoc = null;
		 FileOutputStream outputfile = null;
		 try {
			 baoxDoc = new ByteArrayOutputStream();
			 JRDocxExporter exporterDoc = new JRDocxExporter();
			 exporterDoc.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			 exporterDoc.setParameter(JRExporterParameter.OUTPUT_STREAM, baoxDoc);
			 exporterDoc.exportReport();
			 
			 outputfile = new FileOutputStream(pathExport);
			 outputfile.write(baoxDoc.toByteArray());
			 _log.info("==makeWordDocReport=="+pathExport);
			 
		 } catch (Exception e) {
			 _log.error("==Error==makeWordDocReport=="+e);
		 }finally{
			 if(baoxDoc != null){
				 baoxDoc.close();
			 }
			 if(outputfile != null){
				 outputfile.close();
			 }
		 }
		  
	 }
	public static void makeExcelXlsReport(JasperPrint jasperPrint, String pathExport  ) throws IOException{
		OutputStream outStream = null;
		ByteArrayOutputStream baoxXLS = null;
		try {
			baoxXLS = new ByteArrayOutputStream();
			
			JRXlsExporter exporterXLS = new JRXlsExporter();
			exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
			exporterXLS.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,pathExport);
			exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baoxXLS);
			/**
			 * FALSE, phan trang, 1 file jasper, when in pdf co n trang, co n sheet
			 * TRUE, ko phan trang, 1 file jasper, when in pdf co n trang, co 1 sheet
			 * */
			
			exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN, Boolean.FALSE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.FALSE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED, Boolean.TRUE);
			
			exporterXLS.exportReport();
			

			outStream = new FileOutputStream(pathExport);
			outStream.write(baoxXLS.toByteArray());
			_log.info("==makeExcelXlsReport==="+pathExport);
			
		} catch (Exception e) {
			_log.error("==Error==makeExcelXlsReport=="+e);
			
		}finally{
			if(baoxXLS != null){
				baoxXLS.close();
			}
			if(outStream != null){
				outStream.close();
			}
		}
	}
//	
//	/*
//	 * Function Export to Server
//	 * 
//	 */
//	public void exportFunction(String tenFile_Template, String tenFile_Export, JRDataSource dataSource, Map<String, Object> parameters) throws IOException {
//		InputStream inputStream = null;
//		try {
//			String pathFileTemp = null;
//			inputStream = new FileInputStream(pathFileTemp + tenFile_Template);
//			JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
//			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//			
//			parameters.put("SUBREPORT_DIR", pathFileTemp);
//			
//			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//			String pathFileSub = null;
//			JasperExportManager.exportReportToPdfFile(jasperPrint, pathFileSub + tenFile_Export);
//			log.debug("----- END EXPORT SERVER ---" + pathFileSub);
//		} catch (Exception e) {
//			log.error("---LOI EXPORT ---" + e);
//			e.printStackTrace();
//		}finally {
//			if(inputStream != null) {
//				inputStream.close();
//			}
//		}
//	}
//	
//	
//	public static void exportFunctionWithSubreport(
//		HttpServletRequest request, String tenFile_Template, String subreportDir, String tenFile_Export, JRDataSource jrDataSource) throws IOException {
//		InputStream inputStream = null;
//		try {
//			String pathTemplate = getTemplateReportFilePath(request, PATH_FILE_REPORT, tenFile_Template);
//			log.debug("====pathTemplate====" + pathTemplate);
//			inputStream = new FileInputStream(pathTemplate);
//			
//			JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
//			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//			
//			Map<String, Object> parameters = new HashMap<String, Object>();
//			
//			subreportDir = getTemplateReportFilePath(request, PATH_FILE_REPORT, subreportDir);
//			parameters.put("SUBREPORT_DIR", subreportDir);
//			
//			log.debug("====subreportDir====" + subreportDir);
//			
//			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
//			String pathExport = getTemplateReportFilePath(request, PATH_FILE_EXPORT, tenFile_Export);
//			
//			log.debug("subreport dir: " + parameters.get("SUBREPORT_DIR"));
//			log.debug("====pathExport====" + pathExport);
//			
//			JasperExportManager.exportReportToPdfFile(jasperPrint, pathExport);
//			log.debug("----- END EXPORT SERVER ---" + pathExport);
//		} catch (Exception e) {
//			log.error("---LOI EXPORT ---" + e);
//			e.printStackTrace();
//		}finally {
//			if(inputStream != null) {
//				inputStream.close();
//			}
//		}
//		
//	}
//	
//	
//	public static String exportFunctionDataSourc(
//			String realPath, String dirParent, String tenFile_Template, String tenFile_Export, JRDataSource dataSource1,  Map<String, Object> parameters) throws IOException {
//			String tenFile = tenFile_Export;
//			InputStream inputStream = null;
//			try {
//				String pathTemplate = realPath + PATH_FILE_REPORT + File.separator + dirParent + File.separator + tenFile_Template;
//				System.out.println("====pathTemplate====" + pathTemplate);
//				inputStream = new FileInputStream(pathTemplate);
//				
//				JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
//				JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//				
//				System.out.println("====SUBREPORT_DIR====" + (realPath + PATH_FILE_REPORT + File.separator + dirParent + File.separator));
//				
//				parameters.put("SUBREPORT_DIR", realPath + PATH_FILE_REPORT + File.separator + dirParent + File.separator);
//				parameters.put("IMG_DIR", realPath + PATH_FILE_REPORT + File.separator + "img" + File.separator);
//				
//				System.out.println("====IMG_DIR====" + realPath + PATH_FILE_REPORT + File.separator + "img" + File.separator);
//				JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport, parameters, dataSource1);
//				
//				String pathExport = realPath + PATH_FILE_EXPORT + File.separator + tenFile_Export;
//				
//				System.out.println("====pathExport====" + pathExport);
//				
//				JasperExportManager.exportReportToPdfFile(jasperPrint1, pathExport);
//				System.out.println("----- END EXPORT SERVER ---" + pathExport);
//			} catch (Exception e) {
//				System.out.println("---LOI EXPORT Return FileName---");
//				tenFile = ReportConstant.TEN_FILE_DEFAULT;
//				System.out.println("---LOI EXPORT ---" + e);
//				e.printStackTrace();
//			}finally {
//				if(inputStream != null) {
//					inputStream.close();
//				}
//			}
//			
//			return tenFile;
//		}
//	
//	
//	public static String exportFunctionTwoDataSourc(
//			String realPath, String dirParent, String tenFile_Template, String tenFile_Export, JRDataSource dataSource1, JRDataSource dataSource2,  Map<String, Object> parameters) throws IOException {
//			String tenFile = tenFile_Export;
//			InputStream inputStream = null;
//			try {
//				String pathTemplate = realPath + PATH_FILE_REPORT + File.separator + dirParent + File.separator + tenFile_Template;
//				System.out.println("====pathTemplate====" + pathTemplate);
//				inputStream = new FileInputStream(pathTemplate);
//				
//				JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
//				JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//				
//				System.out.println("====SUBREPORT_DIR====" + (realPath + PATH_FILE_REPORT + File.separator + dirParent + File.separator));
//				
//				parameters.put("SUBREPORT_DIR", realPath + PATH_FILE_REPORT + File.separator + dirParent + File.separator);
//				parameters.put("IMG_DIR", realPath + PATH_FILE_REPORT + File.separator + "img" + File.separator);
//				
//				System.out.println("====IMG_DIR====" + realPath + PATH_FILE_REPORT + File.separator + "img" + File.separator);
//				JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport, parameters, dataSource1);
//				//
//				if (dataSource2 != null) {
//					
//					String pathTemplatePhan2 = realPath + PATH_FILE_REPORT + File.separator + dirParent + File.separator + "xu_ly_ho_so.jrxml";
//					parameters.put("SUBREPORT_DIR", realPath + PATH_FILE_REPORT + File.separator + dirParent + File.separator);
//					
//					inputStream = new FileInputStream(pathTemplatePhan2);
//					JasperDesign jasperDesignPhan2 = JRXmlLoader.load(inputStream);
//					JasperReport jasperReportPhan2 = JasperCompileManager.compileReport(jasperDesignPhan2);
//					
//					JasperPrint jasperPrint2 = JasperFillManager.fillReport(jasperReportPhan2, parameters, dataSource2);
//					for (JRPrintPage page : jasperPrint2.getPages()) {
//						jasperPrint1.addPage(page);
//					}
//				}
//				///
//				String pathExport = realPath + PATH_FILE_EXPORT + File.separator + tenFile_Export;
//				
//				System.out.println("====pathExport====" + pathExport);
//				
//				JasperExportManager.exportReportToPdfFile(jasperPrint1, pathExport);
//				System.out.println("----- END EXPORT SERVER ---" + pathExport);
//			} catch (Exception e) {
//				System.out.println("---LOI EXPORT Return FileName---");
//				tenFile = ReportConstant.TEN_FILE_DEFAULT;
//				System.out.println("---LOI EXPORT ---" + e);
//				e.printStackTrace();
//			}finally {
//				if(inputStream != null) {
//					inputStream.close();
//				}
//			}
//			
//			return tenFile;
//		}

}
