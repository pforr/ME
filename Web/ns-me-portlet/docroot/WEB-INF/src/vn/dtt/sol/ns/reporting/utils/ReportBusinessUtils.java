package vn.dtt.sol.ns.reporting.utils;

import java.util.HashMap;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import vn.dtt.sol.ns.reporting.model.baocaothongke.ctcc.ThongKeCTCC;
import vn.dtt.sol.ns.reporting.model.baocaothongke.ctcc.ThongKeCTCCExport;
import vn.dtt.sol.ns.reporting.model.baocaothongke.ctcc.ThongKeCTCCTU;
import vn.dtt.sol.ns.reporting.model.baocaothongke.ctcc.ThongKeCTCCTUExport;
import vn.dtt.sol.ns.reporting.model.baocaothongke.daunoinuoc.ThongKeDauNoiNuoc;
import vn.dtt.sol.ns.reporting.model.baocaothongke.daunoinuoc.ThongKeDauNoiNuocExport;
import vn.dtt.sol.ns.reporting.model.baocaothongke.daunoinuoc.ThongKeDauNoiNuocTU;
import vn.dtt.sol.ns.reporting.model.baocaothongke.daunoinuoc.ThongKeDauNoiNuocTUExport;
import vn.dtt.sol.ns.reporting.model.baocaothongke.searchhelp.daunoinuoc.ThongKeDauNoiNuocSearch;
import vn.dtt.sol.ns.reporting.model.baocaothongke.searchhelp.daunoinuoc.ThongKeDauNoiNuocSearchExport;
import vn.dtt.sol.ns.reporting.model.baocaothongke.searchhelp.vesinh.ThongKeVeSinhSearch;
import vn.dtt.sol.ns.reporting.model.baocaothongke.searchhelp.vesinh.ThongKeVeSinhSearchExport;
import vn.dtt.sol.ns.reporting.model.baocaothongke.vstx.ThongKeVSTX;
import vn.dtt.sol.ns.reporting.model.baocaothongke.vstx.ThongKeVSTXExport;
import vn.dtt.sol.ns.reporting.model.baocaothongke.vstx.ThongKeVSTXTU;
import vn.dtt.sol.ns.reporting.model.baocaothongke.vstx.ThongKeVSTXTUExport;
import vn.dtt.sol.ns.reporting.model.baocaothongke.vsxm.ThongKeVSXM;
import vn.dtt.sol.ns.reporting.model.baocaothongke.vsxm.ThongKeVSXMExport;
import vn.dtt.sol.ns.reporting.model.baocaothongke.vsxm.ThongKeVSXMTU;
import vn.dtt.sol.ns.reporting.model.baocaothongke.vsxm.ThongKeVSXMTUExport;
import vn.dtt.sol.ns.reporting.model.dli11ct.DSDauNoiMoiCapNuoc;
import vn.dtt.sol.ns.reporting.model.dli11ct.DSDauNoiMoiCapNuocExport;
import vn.dtt.sol.ns.reporting.model.dli11th.SoDauNoiMoiHoatDong;
import vn.dtt.sol.ns.reporting.model.dli11th.SoDauNoiMoiHoatDongExport;
import vn.dtt.sol.ns.reporting.model.dli11tu.TUDauNoiCapNuoc;
import vn.dtt.sol.ns.reporting.model.dli11tu.TUDauNoiCapNuocExport;
import vn.dtt.sol.ns.reporting.model.dli12ct.DSNhaTieuHGDXayMoi;
import vn.dtt.sol.ns.reporting.model.dli12ct.DSNhaTieuHGDXayMoiExport;
import vn.dtt.sol.ns.reporting.model.dli12th.SoNhaTieuHGDXayMoiHVS;
import vn.dtt.sol.ns.reporting.model.dli12th.SoNhaTieuHGDXayMoiHVSExport;
import vn.dtt.sol.ns.reporting.model.dli12tu.SoNhaTieuXayMoiHVS;
import vn.dtt.sol.ns.reporting.model.dli12tu.SoNhaTieuXayMoiHVSExport;
import vn.dtt.sol.ns.reporting.model.dli21.HTCapNuocBenVung;
import vn.dtt.sol.ns.reporting.model.dli21.HTCapNuocBenVungExport;
import vn.dtt.sol.ns.reporting.model.dli21tu.SoNgHuongLoiCapNcBV;
import vn.dtt.sol.ns.reporting.model.dli21tu.SoNgHuongLoiCapNcBVExport;
import vn.dtt.sol.ns.reporting.model.dli22.SoNgDcTiepCanVsDienVSTX;
import vn.dtt.sol.ns.reporting.model.dli22.SoNgDcTiepCanVsDienVSTXExport;
import vn.dtt.sol.ns.reporting.model.dli22pl.BaoCaoVSTX_PL5_4_1;
import vn.dtt.sol.ns.reporting.model.dli22pl.BaoCaoVSTX_PL5_4_1_Export;
import vn.dtt.sol.ns.reporting.model.dli22pl.BaoCaoVSTX_PL5_4_2;
import vn.dtt.sol.ns.reporting.model.dli22pl.BaoCaoVSTX_PL5_4_2_Export;
import vn.dtt.sol.ns.reporting.model.dli22tu.SoNgDcTiepCanVSTX;
import vn.dtt.sol.ns.reporting.model.dli22tu.SoNgDcTiepCanVSTXExport;
import vn.dtt.sol.ns.reporting.model.dli3.KHTinhVaBaoCaoCT;
import vn.dtt.sol.ns.reporting.model.dli3.KHTinhVaBaoCaoCTExport;
import vn.dtt.sol.ns.reporting.model.dli3tu.KHNamCuaTinhVaBaoCaoCT;
import vn.dtt.sol.ns.reporting.model.dli3tu.KHNamCuaTinhVaBaoCaoCTExport;
import vn.dtt.sol.ns.reporting.model.dlith.TomTatTDTHCSGiaiNgan;
import vn.dtt.sol.ns.reporting.model.dlith.TomTatTDTHCSGiaiNganExport;
import vn.dtt.sol.ns.reporting.model.hopnhattinh.HopNhatTinh;
import vn.dtt.sol.ns.reporting.model.hopnhattinh.HopNhatTinhExport;
import vn.dtt.sol.ns.reporting.model.hopnhattinhtu.HopNhatTinhTU;
import vn.dtt.sol.ns.reporting.model.hopnhattinhtu.HopNhatTinhTUExport;
import vn.dtt.sol.ns.reporting.model.kehoachnc.KeHoachNc;
import vn.dtt.sol.ns.reporting.model.kehoachnc.KeHoachNcExport;
import vn.dtt.sol.ns.reporting.model.kehoachvesinh.KeHoachVS;
import vn.dtt.sol.ns.reporting.model.kehoachvesinh.KeHoachVSExport;
import vn.dtt.sol.ns.reporting.model.ktqxnnc.KQXetNghiemNc;
import vn.dtt.sol.ns.reporting.model.ktqxnnc.KQXetNghiemNcExport;
import vn.dtt.sol.ns.reporting.model.ktqxnnctu.KQXetNghiemNcTU;
import vn.dtt.sol.ns.reporting.model.ktqxnnctu.KQXetNghiemNcTUExport;
import vn.dtt.sol.ns.reporting.model.tdthcntt.TienDoThucHienCapNuoc;
import vn.dtt.sol.ns.reporting.model.tdthcntt.TienDoThucHienCapNuocExport;
import vn.dtt.sol.ns.reporting.model.tdthcntttu.TienDoThucHienCapNuocTU;
import vn.dtt.sol.ns.reporting.model.tdthcntttu.TienDoThucHienCapNuocTUExport;
import vn.dtt.sol.ns.reporting.model.thdkdaunoisdnuoc.DauNoiSDNcKH;
import vn.dtt.sol.ns.reporting.model.thdkdaunoisdnuoc.DauNoiSDNcKHExport;
import vn.dtt.sol.ns.reporting.model.thdknhatieuhvsxm.NhaTieuHVSXM;
import vn.dtt.sol.ns.reporting.model.thdknhatieuhvsxm.NhaTieuHVSXMExport;
import vn.dtt.sol.ns.reporting.model.tonghopvegioi.TongHopVeGioi;
import vn.dtt.sol.ns.reporting.model.tonghopvegioi.TongHopVeGioiExport;
import vn.dtt.sol.ns.reporting.model.tonghopvegioitu.TongHopVeGioiTU;
import vn.dtt.sol.ns.reporting.model.tonghopvegioitu.TongHopVeGioiTUExport;
import vn.dtt.sol.ns.util.format.ConvertUtil;
import vn.dtt.sol.ns.util.format.FormatData;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

public class ReportBusinessUtils {
	
	private static Log log = LogFactoryUtil.getLog(ReportBusinessUtils.class);
	
	private static HashMap<String, Object> parameters = null;
	
	
	
	public static String actionExport_Dli_11_TH(String realPath, String namBaoCao, String maTinh, String soBaoCao, String ngayBaoCao, String nguoiLap, String nguoiDuyet, String duoiFile, String thoigianthuc,String donViBaoCao){
		String fileUrl = "";
		log.debug("--actionExport_Dli_11_TH==maTinh--"+maTinh+"--namBaoCao=="+namBaoCao+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		
		try {
			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI1_1_TH_EXPORT+"_"+thoigianthuc;
			SoDauNoiMoiHoatDong objectReport = SoDauNoiMoiHoatDongExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,thoigianthuc,donViBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.DLI_1_1, ReportConstant.GIAY_DLI1_1_TH_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		} catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_Dli_11_CT(String realPath, String namBaoCao, String maTinh, String soBaoCao, String ngayBaoCao, String nguoiLap, String nguoiDuyet, String duoiFile, String thoigianthuc,String donViBaoCao){
		String fileUrl = "";
		log.debug("--actionExport_Dli_11_CT==maTinh--"+maTinh+"--namBaoCao=="+namBaoCao+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		
		try {
			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI1_1_CT_EXPORT+"_"+thoigianthuc;
			DSDauNoiMoiCapNuoc objectReport = DSDauNoiMoiCapNuocExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,thoigianthuc,donViBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.DLI_1_1, ReportConstant.GIAY_DLI1_1_CT_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		} catch (Exception e) {
			
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_Dli_11_TU(String realPath, String namBaoCao, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_Dli_11_TU==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_DLI1_1_TU_EXPORT;
			TUDauNoiCapNuoc objectReport = TUDauNoiCapNuocExport.getModel(namBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.DLI_1_1, ReportConstant.GIAY_DLI1_1_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		} catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_Dli_12_TH(String realPath, String namBaoCao, String maTinh, String soBaoCao, String ngayBaoCao, String nguoiLap, String nguoiDuyet, String duoiFile, String thoigianthuc,String donViBaoCao ){
		String fileUrl = "";
		log.debug("--actionExport_Dli_12_TH==maTinh--"+maTinh+"--namBaoCao=="+namBaoCao+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI1_2_TH_EXPORT+"_"+thoigianthuc;
			SoNhaTieuHGDXayMoiHVS objectReport = SoNhaTieuHGDXayMoiHVSExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet, thoigianthuc,donViBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.DLI_1_2, ReportConstant.GIAY_DLI1_2_TH_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		} catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_Dli_12_CT(String realPath, String namBaoCao, String maTinh, String soBaoCao, String ngayBaoCao, String nguoiLap, String nguoiDuyet, String duoiFile, String thoigianthuc,String donViBaoCao){
		String fileUrl = "";
		log.debug("--actionExport_Dli_12_CT==maTinh--"+maTinh+"--namBaoCao=="+namBaoCao+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI1_2_CT_EXPORT+"_"+thoigianthuc;
			DSNhaTieuHGDXayMoi objectReport = DSNhaTieuHGDXayMoiExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,thoigianthuc,donViBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.DLI_1_2, ReportConstant.GIAY_DLI1_2_CT_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		} catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_Dli_12_TU(String realPath, String namBaoCao, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_Dli_12_TU==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_DLI1_2_TU_EXPORT;
			SoNhaTieuXayMoiHVS objectReport = SoNhaTieuXayMoiHVSExport.getModel(namBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.DLI_1_2, ReportConstant.GIAY_DLI1_2_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		} catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_Dli_21(String realPath, String namBaoCao, String maTinh, String soBaoCao, String ngayBaoCao, String nguoiLap, String nguoiDuyet, String duoiFile,String donViBaoCao){
		String fileUrl = "";
		log.debug("--actionExport_Dli_21==maTinh--"+maTinh+"--namBaoCao=="+namBaoCao+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI2_1_EXPORT;
			HTCapNuocBenVung objectReport = HTCapNuocBenVungExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,donViBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.DLI_2_1, ReportConstant.GIAY_DLI2_1_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		} catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_Dli_21_TU(String realPath, String namBaoCao, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_Dli_21_TU==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_DLI2_1_TU_EXPORT;
			SoNgHuongLoiCapNcBV objectReport = SoNgHuongLoiCapNcBVExport.getModel(namBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.DLI_2_1, ReportConstant.GIAY_DLI2_1_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		} catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_Dli_22(String realPath, String namBaoCao, String maTinh, String soBaoCao, String ngayBaoCao, String nguoiLap, String nguoiDuyet, String duoiFile, int userId,String donViBaoCao){
		String fileUrl = "";
		log.debug("--actionExport_Dli_22==maTinh--"+maTinh+"--namBaoCao=="+namBaoCao+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		try {
			//Prepare data for this report

			ReportUtils.prepareDataDL2_2(namBaoCao, userId, maTinh);
			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI2_2_EXPORT;
			SoNgDcTiepCanVsDienVSTX objectReport = SoNgDcTiepCanVsDienVSTXExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,donViBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.DLI_2_2, ReportConstant.GIAY_DLI2_2_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		} catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_Dli_22_TU(String realPath, String namBaoCao,  String duoiFile) {
		String fileUrl = "";
		log.debug("--actionExport_Dli_22_TU==namBaoCao==" + namBaoCao);
		try {
			String tenFile_Export = namBaoCao +"_" + ReportConstant.GIAY_DLI2_2_TU_EXPORT;
			SoNgDcTiepCanVSTX objectReport = SoNgDcTiepCanVSTXExport.getModel(namBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau(objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.DLI_2_2, ReportConstant.GIAY_DLI2_2_TU_TEMP, tenFile_Export, dataSource, parameters, duoiFile);
		} catch (Exception e) {
			log.error(e);
		}
		return fileUrl;
	}
	
	public static String actionExport_Dli_22_PL1(String realPath, String namBaoCao, String maTinh, String soBaoCao, String ngayBaoCao, String nguoiLap, String nguoiDuyet, String duoiFile, int userId,String donViBaoCao) {
		String fileUrl = "";
		log.debug("--actionExport_Dli_22_PL1==namBaoCao==" + namBaoCao);
		try {
			String tenFile_Export = namBaoCao +"_"+maTinh+ "_" + ReportConstant.GIAY_DLI2_2_PL1_EXPORT;
			BaoCaoVSTX_PL5_4_1 objectReport = BaoCaoVSTX_PL5_4_1_Export.getModel(namBaoCao, maTinh, soBaoCao, ngayBaoCao, nguoiLap, nguoiDuyet,donViBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau(objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.DLI_2_2, ReportConstant.GIAY_DLI2_2_PL1_TEMP, tenFile_Export, dataSource, parameters, duoiFile);
		} catch (Exception e) {
			log.error(e);
		}
		return fileUrl;
	}
	
	public static String actionExport_Dli_22_PL2(String realPath, String namBaoCao, String maTinh, String soBaoCao, String ngayBaoCao, String nguoiLap, String nguoiDuyet, String duoiFile, int userId,String donViBaoCao) {
		String fileUrl = "";
		log.debug("--actionExport_Dli_22_PL2==namBaoCao==" + namBaoCao);
		try {
			String tenFile_Export = namBaoCao +"_"+maTinh+ "_" + ReportConstant.GIAY_DLI2_2_PL2_EXPORT;
			BaoCaoVSTX_PL5_4_2 objectReport = BaoCaoVSTX_PL5_4_2_Export.getModel(namBaoCao, maTinh, soBaoCao, ngayBaoCao, nguoiLap, nguoiDuyet,donViBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau(objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.DLI_2_2, ReportConstant.GIAY_DLI2_2_PL2_TEMP, tenFile_Export, dataSource, parameters, duoiFile);
		} catch (Exception e) {
			log.error(e);
		}
		return fileUrl;
	}
	
	
	/*
	public static String actionExport_Dli_3(String realPath, String namBaoCao, String maTinh, String soBaoCao, String ngayBaoCao, String nguoiLap, String nguoiDuyet, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_Dli_3==maTinh--"+maTinh+"--namBaoCao=="+namBaoCao+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI3_EXPORT;
			KHTinhVaBaoCaoCT objectReport = KHTinhVaBaoCaoCTExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.DLI_3, ReportConstant.GIAY_DLI3_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		} catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	*/
	
	public static String actionExport_Dli_3_NEW(String realPath, String namBaoCao, String maTinh, String soBaoCao, String ngayBaoCao, String nguoiLap, String nguoiDuyet,String keHoachNam,String ngayPheDuyet,String baoCaoChuongTrinh,String ngayDang, String duoiFile,String donViBaoCao){
		String fileUrl = "";
		log.debug("--actionExport_Dli_3==maTinh--"+maTinh+"--namBaoCao=="+namBaoCao+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI3_EXPORT;
			KHTinhVaBaoCaoCT objectReport = KHTinhVaBaoCaoCTExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet, keHoachNam, ngayPheDuyet, baoCaoChuongTrinh, ngayDang,donViBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.DLI_3, ReportConstant.GIAY_DLI3_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		} catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_Dli_3_TU(String realPath, String namBaoCao, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_Dli_3==namBaoCao=="+namBaoCao+"--");
		try {
			String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_DLI3_TU_EXPORT;
			KHNamCuaTinhVaBaoCaoCT objectReport = KHNamCuaTinhVaBaoCaoCTExport.getModel(namBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.DLI_3, ReportConstant.GIAY_DLI3_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		} catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_Dli_TH(String realPath, String namBaoCao, String maTinh, String soBaoCao, String ngayBaoCao, String nguoiLap, String nguoiDuyet, String duoiFile,String donViBaoCao){
		String fileUrl = "";
		log.debug("--actionExport_Dli_TH==maTinh--"+maTinh+"--namBaoCao=="+namBaoCao+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI_TH_EXPORT;
			TomTatTDTHCSGiaiNgan objectReport = TomTatTDTHCSGiaiNganExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,donViBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.DLI_TH, ReportConstant.GIAY_DLI_TH_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		} catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_THDK_DNSDN(String realPath, String namBaoCao, String maTinh, String soBaoCao, String ngayBaoCao, String nguoiLap, String nguoiDuyet, String duoiFile,String donViBaoCao){
		String fileUrl = "";
		log.debug("--actionExport_THDK_DNSDN==maTinh--"+maTinh+"--namBaoCao=="+namBaoCao+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_THDK_DNSDN_EXPORT;
			DauNoiSDNcKH objectReport = DauNoiSDNcKHExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,donViBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.TONGHOPDUKIEN, ReportConstant.GIAY_THDK_DNSDN_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		} catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_THDK_NTHVSXM(String realPath, String namBaoCao, String maTinh, String soBaoCao, String ngayBaoCao, String nguoiLap, String nguoiDuyet, String duoiFile,String donViBaoCao){
		String fileUrl = "";
		log.debug("--actionExport_THDK_NTHVSXM==maTinh--"+maTinh+"--namBaoCao=="+namBaoCao+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_THDK_NTHVSXM_EXPORT;
			NhaTieuHVSXM objectReport = NhaTieuHVSXMExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,donViBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.TONGHOPDUKIEN, ReportConstant.GIAY_THDK_NTHVSXM_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		} catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	

	
	public static String actionExport_TDTHCNTT(String realPath, String namBaoCao, String maTinh, String soBaoCao, String ngayBaoCao, String nguoiLap, String nguoiDuyet, String duoiFile,String donViBaoCao){
		String fileUrl = "";
		log.debug("--actionExport_TDTHCNTT==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_TDTHCNTT_EXPORT;
			TienDoThucHienCapNuoc objectReport = TienDoThucHienCapNuocExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,donViBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.TIENDO, ReportConstant.GIAY_TDTHCNTT_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		} catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_TDTHCNTT_TU(String realPath, String namBaoCao, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_TDTHCNTT_TU==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_TDTHCNTT_TU_EXPORT;
			TienDoThucHienCapNuocTU objectReport = TienDoThucHienCapNuocTUExport.getModel(namBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.TIENDO, ReportConstant.GIAY_TDTHCNTT_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		} catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_TONGHOPVEGIOI(String realPath, String namBaoCao, String maTinh, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_TONGHOPVEGIOI==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_TONGHOPVEGIOI_EXPORT;
			TongHopVeGioi objectReport = TongHopVeGioiExport.getModel(namBaoCao, maTinh);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.TIENDO, ReportConstant.GIAY_TONGHOPVEGIOI_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		}catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_TONGHOPVEGIOI_TU(String realPath, String namBaoCao, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_TONGHOPVEGIOI_TU==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_TONGHOPVEGIOI_TU_EXPORT;
			TongHopVeGioiTU objectReport = TongHopVeGioiTUExport.getModel(namBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.TIENDO, ReportConstant.GIAY_TONGHOPVEGIOI_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		}catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_KQXNNC(String realPath, String namBaoCao, String maTinh, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_KQXNNC==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_KETQUAXETNGHIEMNUOC_EXPORT;
			KQXetNghiemNc objectReport = KQXetNghiemNcExport.getModel(namBaoCao, maTinh);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.BAOCAOMOI, ReportConstant.GIAY_KETQUAXETNGHIEMNUOC_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		}catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	public static String actionExport_KQXNNC_TU(String realPath, String namBaoCao, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_KQXNNC_TU==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_KETQUAXETNGHIEMNUOC_TU_EXPORT;
			KQXetNghiemNcTU objectReport = KQXetNghiemNcTUExport.getModel(namBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.BAOCAOMOI, ReportConstant.GIAY_KETQUAXETNGHIEMNUOC_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		}catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	public static String actionExport_HNT(String realPath, String namBaoCao, String maTinh,String giaiDoanTu,String giaiDoanDen, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_HNT==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_HNT_EXPORT;
			HopNhatTinh objectReport = HopNhatTinhExport.getModel(namBaoCao, maTinh,giaiDoanTu,giaiDoanDen);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.BAOCAOMOI, ReportConstant.GIAY_HNT_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		}catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_HNT_TU(String realPath, String namBaoCao,String giaiDoanTu,String giaiDoanDen, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_HNT_TU==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_HNT_TU_EXPORT;
			HopNhatTinhTU objectReport = HopNhatTinhTUExport.getModel(namBaoCao, giaiDoanTu,giaiDoanDen);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.BAOCAOMOI, ReportConstant.GIAY_HNT_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		}catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_ThongKeVSTX(String realPath, String namBaoCao, String maTinh, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_ThongKeVSTX==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_THONGKEVSTX_EXPORT;
			ThongKeVSTX objectReport = ThongKeVSTXExport.getModel(namBaoCao, maTinh);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.BAOCAOTHONGKE, ReportConstant.GIAY_THONGKEVSTX_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		}catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_ThongKeVSTXTU(String realPath, String namBaoCao, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_ThongKeVSTXTU==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_THONGKEVSTX_TU_EXPORT;
			ThongKeVSTXTU objectReport = ThongKeVSTXTUExport.getModel(namBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.BAOCAOTHONGKE, ReportConstant.GIAY_THONGKEVSTX_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		}catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_ThongKeDauNoiNuoc(String realPath, String namBaoCao, String maTinh, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_ThongKeDauNoiNuoc==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_THONGKEDAUNOINUOC_EXPORT;
			ThongKeDauNoiNuoc objectReport = ThongKeDauNoiNuocExport.getModel(namBaoCao, maTinh);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.BAOCAOTHONGKE, ReportConstant.GIAY_THONGKEDAUNOINUOC_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		}catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	public static String actionExport_ThongKeDauNoiNuocTU(String realPath, String namBaoCao, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_ThongKeDauNoiNuocTU==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_THONGKEDAUNOINUOC_TU_EXPORT;
			ThongKeDauNoiNuocTU objectReport = ThongKeDauNoiNuocTUExport.getModel(namBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.BAOCAOTHONGKE, ReportConstant.GIAY_THONGKEDAUNOINUOC_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		}catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_ThongKeVSXM(String realPath, String namBaoCao, String maTinh, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_ThongKeVSXM==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_THONGKEVSXM_EXPORT;
			ThongKeVSXM objectReport = ThongKeVSXMExport.getModel(namBaoCao, maTinh);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.BAOCAOTHONGKE, ReportConstant.GIAY_THONGKEVSXM_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		}catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	public static String actionExport_ThongKeVSXMTU(String realPath, String namBaoCao, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_ThongKeVSXMTU==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_THONGKEVSXM_TU_EXPORT;
			ThongKeVSXMTU objectReport = ThongKeVSXMTUExport.getModel(namBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.BAOCAOTHONGKE, ReportConstant.GIAY_THONGKEVSXM_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		}catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static String actionExport_ThongKeCTCC(String realPath, String namBaoCao, String maTinh, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_ThongKeCTCC==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_THONGKECTCC_EXPORT;
			ThongKeCTCC objectReport = ThongKeCTCCExport.getModel(namBaoCao, maTinh);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.BAOCAOTHONGKE, ReportConstant.GIAY_THONGKECTCC_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		}catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	public static String actionExport_ThongKeCTCCTU(String realPath, String namBaoCao, String duoiFile){
		String fileUrl = "";
		log.debug("--actionExport_ThongKeCTCC==namBaoCao=="+namBaoCao);
		try {
			String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_THONGKECTCC_TU_EXPORT;
			ThongKeCTCCTU objectReport = ThongKeCTCCTUExport.getModel(namBaoCao);
			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
			parameters = new HashMap<String, Object>();
			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.BAOCAOTHONGKE, ReportConstant.GIAY_THONGKECTCC_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
		}catch (Exception e) {
			log.error(e);
		} 
		return fileUrl;
	}
	
	public static void inBaoCaoDLI(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		log.info("----inBaoCaoDLI---vao inbaocao");
		HashMap<String, Object> parameters = null;
		String currentTimeFull = FormatData.getCurrentTimeFull();
		
		String type = ParamUtil.getString(resourceRequest, "typeRS");
		String duoiFile = ParamUtil.getString(resourceRequest, "duoiFileRS");
		String thoiGianThuc = ParamUtil.getString(resourceRequest, "thoiGianThucRS");
		
		String maTinh = ParamUtil.getString(resourceRequest, "maTinhRS");
		String namBaoCao = ParamUtil.getString(resourceRequest, "namBaoCaoRS");	
		
		String donViBaoCao = ParamUtil.getString(resourceRequest, "donViBaoCaoRS");
		String soBaoCao = ParamUtil.getString(resourceRequest, "soBaoCaoRS");
		String nguoiLap = ParamUtil.getString(resourceRequest, "nguoiLapRS");
		String nguoiDuyet = ParamUtil.getString(resourceRequest, "nguoiDuyetRS");
		String ngayBaoCao = ParamUtil.getString(resourceRequest, "ngayBaoCaoRS");
		
		String keHoachId = ParamUtil.getString(resourceRequest, "keHoachId");
		
		String giaiDoanTu = ParamUtil.getString(resourceRequest, "giaiDoanTuRS");
		String giaiDoanDen = ParamUtil.getString(resourceRequest, "giaiDoanDenRS");
		
		String keHoachNam = ParamUtil.getString(resourceRequest, "keHoachNamRS");
		String ngayPheDuyet = ParamUtil.getString(resourceRequest, "ngayPheDuyetRS");
		String baoCaoChuongTrinh = ParamUtil.getString(resourceRequest, "baoCaoChuongTrinhRS");
		String ngayDang = ParamUtil.getString(resourceRequest, "ngayDangRS");
		
		String realPath = ReportUtils.getTemplateReportFilePath(resourceRequest);
		log.info("--inBaoCaoDLI--realpath--"+realPath+"==");
		
		//String tenFileExport = ReportConstant.TEN_FILE_DEFAULT+"."+duoiFile;
		log.info("---inBaoCaoDLI--duoiFile--"+duoiFile+"====");
		log.info("---type---"+type+"===");
		try{
			if(Validator.isNotNull(maTinh)
					&& Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(thoiGianThuc) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.DLI1_1_TH)){
				log.info("==type--"+type);
				
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI1_1_TH_EXPORT+"_"+thoiGianThuc+"_"+currentTimeFull;
				SoDauNoiMoiHoatDong objectReport = SoDauNoiMoiHoatDongExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,thoiGianThuc,donViBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.DLI_1_1, ReportConstant.GIAY_DLI1_1_TH_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
				
			}
			
			if(Validator.isNotNull(maTinh)
					&& Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(thoiGianThuc) 
					&& Validator.isNotNull(type)
					&& type.trim().equalsIgnoreCase(ReportConstant.DLI1_1_CT)){
				log.info("==type--"+type);
				
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI1_1_CT_EXPORT+"_"+thoiGianThuc+"_"+currentTimeFull;
				DSDauNoiMoiCapNuoc objectReport = DSDauNoiMoiCapNuocExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,thoiGianThuc,donViBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.DLI_1_1, ReportConstant.GIAY_DLI1_1_CT_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
				
			}
			
			if( Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type)
					&& type.trim().equalsIgnoreCase(ReportConstant.DLI1_1_TU)){
				log.info("==type--"+type);
				
				String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_DLI1_1_TU_EXPORT+"_"+currentTimeFull;
				TUDauNoiCapNuoc objectReport = TUDauNoiCapNuocExport.getModel(namBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.DLI_1_1, ReportConstant.GIAY_DLI1_1_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
				
			}
			
			if(Validator.isNotNull(maTinh)
					&& Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(thoiGianThuc) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.DLI1_2_TH)){
				log.info("==type--"+type);
				
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI1_2_TH_EXPORT+"_"+thoiGianThuc+"_"+currentTimeFull;
				SoNhaTieuHGDXayMoiHVS objectReport = SoNhaTieuHGDXayMoiHVSExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet, thoiGianThuc,donViBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.DLI_1_2, ReportConstant.GIAY_DLI1_2_TH_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
				
			}
			
			if(Validator.isNotNull(maTinh)
					&& Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(thoiGianThuc) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.DLI1_2_CT)){
				log.info("==type--"+type);
				
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI1_2_CT_EXPORT+"_"+thoiGianThuc+"_"+currentTimeFull;
				DSNhaTieuHGDXayMoi objectReport = DSNhaTieuHGDXayMoiExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,thoiGianThuc,donViBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.DLI_1_2, ReportConstant.GIAY_DLI1_2_CT_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
				
			}
			
			if( Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type)
					&& type.trim().equalsIgnoreCase(ReportConstant.DLI1_2_TU)){
				log.info("==type--"+type);
				
				String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_DLI1_2_TU_EXPORT+"_"+currentTimeFull;
				SoNhaTieuXayMoiHVS objectReport = SoNhaTieuXayMoiHVSExport.getModel(namBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.DLI_1_2, ReportConstant.GIAY_DLI1_2_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
				
			}
			
			if(Validator.isNotNull(maTinh)
					&& Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.DLI2_1)){
				log.info("==type--"+type);
				
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI2_1_EXPORT+"_"+currentTimeFull;
				HTCapNuocBenVung objectReport = HTCapNuocBenVungExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,donViBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.DLI_2_1, ReportConstant.GIAY_DLI2_1_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
				
			}
			
			if( Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type)
					&& type.trim().equalsIgnoreCase(ReportConstant.DLI2_1_TU)){
				log.info("==type--"+type);
				
				String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_DLI2_1_TU_EXPORT+"_"+currentTimeFull;
				SoNgHuongLoiCapNcBV objectReport = SoNgHuongLoiCapNcBVExport.getModel(namBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.DLI_2_1, ReportConstant.GIAY_DLI2_1_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
				
			}
			//---------START 2.2
			if(Validator.isNotNull(maTinh)
					&& Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.DLI2_2)){
				log.info("==type--"+type);
				
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI2_2_EXPORT+"_"+currentTimeFull;
				SoNgDcTiepCanVsDienVSTX objectReport = SoNgDcTiepCanVsDienVSTXExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,donViBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.DLI_2_2, ReportConstant.GIAY_DLI2_2_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
				
			}
			
			if( Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type)
					&& type.trim().equalsIgnoreCase(ReportConstant.DLI2_2_TU)){
				log.info("==type--"+type);
				
				String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_DLI2_2_TU_EXPORT+"_"+currentTimeFull;
				SoNgDcTiepCanVSTX objectReport = SoNgDcTiepCanVSTXExport.getModel(namBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.DLI_2_2, ReportConstant.GIAY_DLI2_2_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
				
			}
			
			if (Validator.isNotNull(maTinh) && Validator.isNotNull(namBaoCao) && Validator.isNotNull(type) && type.trim().equalsIgnoreCase(ReportConstant.DLI2_2_PL1)) {
				log.info("==type--" + type);
				
				String tenFile_Export = namBaoCao + "_" + maTinh + "_" + ReportConstant.GIAY_DLI2_2_PL1_EXPORT + "_" + currentTimeFull;
				BaoCaoVSTX_PL5_4_1 objectReport = BaoCaoVSTX_PL5_4_1_Export.getModel(namBaoCao, maTinh, soBaoCao, ngayBaoCao, nguoiLap, nguoiDuyet,donViBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau(objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.DLI_2_2, ReportConstant.GIAY_DLI2_2_PL1_TEMP, tenFile_Export, dataSource, parameters, duoiFile, resourceResponse);
				
			}
			
			if (Validator.isNotNull(maTinh) && Validator.isNotNull(namBaoCao) && Validator.isNotNull(type) && type.trim().equalsIgnoreCase(ReportConstant.DLI2_2_PL2)) {
				log.info("==type--" + type);
				
				String tenFile_Export = namBaoCao + "_" + maTinh + "_" + ReportConstant.GIAY_DLI2_2_PL2_EXPORT + "_" + currentTimeFull;
				BaoCaoVSTX_PL5_4_2 objectReport = BaoCaoVSTX_PL5_4_2_Export.getModel(namBaoCao, maTinh, soBaoCao, ngayBaoCao, nguoiLap, nguoiDuyet,donViBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau(objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.DLI_2_2, ReportConstant.GIAY_DLI2_2_PL2_TEMP, tenFile_Export, dataSource, parameters, duoiFile, resourceResponse);
				
			}
			
			//---------END 2.2
			
			/* cu
			if( Validator.isNotNull(maTinh)
					&& Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.DLI3)){
				log.info("==type--"+type);
				
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI3_EXPORT+"_"+currentTimeFull;
				KHTinhVaBaoCaoCT objectReport = KHTinhVaBaoCaoCTExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.DLI_3, ReportConstant.GIAY_DLI3_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			*/
			if( Validator.isNotNull(maTinh)
					&& Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.DLI3)){
				log.info("==type--"+type);
				
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI3_EXPORT+"_"+currentTimeFull;
				KHTinhVaBaoCaoCT objectReport = KHTinhVaBaoCaoCTExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet, keHoachNam, ngayPheDuyet, baoCaoChuongTrinh, ngayDang,donViBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.DLI_3, ReportConstant.GIAY_DLI3_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			
			if(  Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.DLI3_TU)){
				log.info("==type--"+type);
				
				String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_DLI3_TU_EXPORT+"_"+currentTimeFull;
				KHNamCuaTinhVaBaoCaoCT objectReport = KHNamCuaTinhVaBaoCaoCTExport.getModel(namBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.DLI_3, ReportConstant.GIAY_DLI3_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
				
			}
			if( Validator.isNotNull(maTinh)
					&& Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.DLI_TH)){
				log.info("==type--"+type);
				
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI_TH_EXPORT+"_"+currentTimeFull;
				TomTatTDTHCSGiaiNgan objectReport = TomTatTDTHCSGiaiNganExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,donViBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.DLI_TH, ReportConstant.GIAY_DLI_TH_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
				
			}
			
			if( Validator.isNotNull(maTinh)
					&& Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.THDK_DNSDN)){
				log.info("==type--"+type);
				
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_THDK_DNSDN_EXPORT+"_"+currentTimeFull;
				DauNoiSDNcKH objectReport = DauNoiSDNcKHExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,donViBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.TONGHOPDUKIEN, ReportConstant.GIAY_THDK_DNSDN_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
				
			}
			
			if( Validator.isNotNull(maTinh)
					&& Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.THDK_NTHVSXM)){
				log.info("==type--"+type);
				
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_THDK_NTHVSXM_EXPORT+"_"+currentTimeFull;
				NhaTieuHVSXM objectReport = NhaTieuHVSXMExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,donViBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.TONGHOPDUKIEN, ReportConstant.GIAY_THDK_NTHVSXM_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
				
			}
			
			if( Validator.isNotNull(maTinh)
					&& Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.TDTHCNTT)){
				log.info("==type--"+type);
				
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_TDTHCNTT_EXPORT+"_"+currentTimeFull;
				TienDoThucHienCapNuoc objectReport = TienDoThucHienCapNuocExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,donViBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.TIENDO, ReportConstant.GIAY_TDTHCNTT_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
				
			}
			if( Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.TDTHCNTT_TU)){
				log.info("==type--"+type);
				
				String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_TDTHCNTT_TU_EXPORT+"_"+currentTimeFull;
				TienDoThucHienCapNuocTU objectReport = TienDoThucHienCapNuocTUExport.getModel(namBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.TIENDO, ReportConstant.GIAY_TDTHCNTT_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
				
			}
			if( Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.KHNUOC)){
				KeHoachNc objectReport = KeHoachNcExport.getModel(keHoachId);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				String tenFile_Export = namBaoCao+"_"+ConvertUtil.unAccent(objectReport.getTenKiemDemVien())+"_"+ReportConstant.GIAY_KHNUOC_EXPORT+"_"+currentTimeFull;
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.KEHOACH, ReportConstant.GIAY_KHNUOC_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			
			if( Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.KHVS)){
				KeHoachVS objectReport = KeHoachVSExport.getModel(keHoachId);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				String tenFile_Export = ConvertUtil.unAccent(objectReport.getLstKeHoachVSHGD().get(0).getTenKiemDemVien())+"_"+ReportConstant.GIAY_KHVESINH_EXPORT+"_"+currentTimeFull;
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.KEHOACH, ReportConstant.GIAY_KHVESINH_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			
			if(  Validator.isNotNull(maTinh) 
					&&Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.THVG)){
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_TONGHOPVEGIOI_EXPORT+"_"+currentTimeFull;
				TongHopVeGioi objectReport = TongHopVeGioiExport.getModel(namBaoCao, maTinh);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.TIENDO, ReportConstant.GIAY_TONGHOPVEGIOI_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			if( Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.THVG_TU)){
				String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_TONGHOPVEGIOI_TU_EXPORT+"_"+currentTimeFull;
				TongHopVeGioiTU objectReport = TongHopVeGioiTUExport.getModel(namBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();				
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.TIENDO, ReportConstant.GIAY_TONGHOPVEGIOI_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			if(  Validator.isNotNull(maTinh) 
					&&Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.KQXNNC)){
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_KETQUAXETNGHIEMNUOC_EXPORT+"_"+currentTimeFull;
				KQXetNghiemNc objectReport = KQXetNghiemNcExport.getModel(namBaoCao, maTinh);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.BAOCAOMOI, ReportConstant.GIAY_KETQUAXETNGHIEMNUOC_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			if(  Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.KQXNNC_TU)){
				String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_KETQUAXETNGHIEMNUOC_TU_EXPORT+"_"+currentTimeFull;
				KQXetNghiemNcTU objectReport = KQXetNghiemNcTUExport.getModel(namBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.BAOCAOMOI, ReportConstant.GIAY_KETQUAXETNGHIEMNUOC_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			if(  Validator.isNotNull(maTinh) 
					&&Validator.isNotNull(namBaoCao) 
					&&Validator.isNotNull(giaiDoanTu) 
					&&Validator.isNotNull(giaiDoanDen) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.HNT)){
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_HNT_EXPORT+"_"+currentTimeFull;
				HopNhatTinh objectReport = HopNhatTinhExport.getModel(namBaoCao, maTinh,giaiDoanTu,giaiDoanDen);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.BAOCAOMOI, ReportConstant.GIAY_HNT_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			if(  Validator.isNotNull(namBaoCao) 
					&&Validator.isNotNull(giaiDoanTu) 
					&&Validator.isNotNull(giaiDoanDen) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.HNT_TU)){
				String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_HNT_TU_EXPORT+"_"+currentTimeFull;
				HopNhatTinhTU objectReport = HopNhatTinhTUExport.getModel(namBaoCao, giaiDoanTu,giaiDoanDen);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.BAOCAOMOI, ReportConstant.GIAY_HNT_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			
			if(  Validator.isNotNull(maTinh) 
					&&Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.THONGKEVSTX)){
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_THONGKEVSTX_EXPORT+"_"+currentTimeFull;
				ThongKeVSTX objectReport = ThongKeVSTXExport.getModel(namBaoCao, maTinh);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.BAOCAOTHONGKE, ReportConstant.GIAY_THONGKEVSTX_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			if(  Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.THONGKEVSTX_TU)){
				String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_THONGKEVSTX_TU_EXPORT+"_"+currentTimeFull;
				ThongKeVSTXTU objectReport = ThongKeVSTXTUExport.getModel(namBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.BAOCAOTHONGKE, ReportConstant.GIAY_THONGKEVSTX_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			if(  Validator.isNotNull(maTinh) 
					&&Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.THONGKEDAUNOINUOC)){
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_THONGKEDAUNOINUOC_EXPORT+"_"+currentTimeFull;
				ThongKeDauNoiNuoc objectReport = ThongKeDauNoiNuocExport.getModel(namBaoCao, maTinh);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.BAOCAOTHONGKE, ReportConstant.GIAY_THONGKEDAUNOINUOC_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			if(  Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.THONGKEDAUNOINUOC_TU)){
				String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_THONGKEDAUNOINUOC_TU_EXPORT+"_"+currentTimeFull;
				ThongKeDauNoiNuocTU objectReport = ThongKeDauNoiNuocTUExport.getModel(namBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.BAOCAOTHONGKE, ReportConstant.GIAY_THONGKEDAUNOINUOC_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			if(  Validator.isNotNull(maTinh) 
					&&Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.THONGKEVSXM)){
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_THONGKEVSXM_EXPORT+"_"+currentTimeFull;
				ThongKeVSXM objectReport = ThongKeVSXMExport.getModel(namBaoCao, maTinh);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.BAOCAOTHONGKE, ReportConstant.GIAY_THONGKEVSXM_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			if( Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.THONGKEVSXM_TU)){
				String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_THONGKEVSXM_TU_EXPORT+"_"+currentTimeFull;
				ThongKeVSXMTU objectReport = ThongKeVSXMTUExport.getModel(namBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.BAOCAOTHONGKE, ReportConstant.GIAY_THONGKEVSXM_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			if(  Validator.isNotNull(maTinh) 
					&&Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.THONGKECTCC)){
				String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_THONGKECTCC_EXPORT+"_"+currentTimeFull;
				ThongKeCTCC objectReport = ThongKeCTCCExport.getModel(namBaoCao, maTinh);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.BAOCAOTHONGKE, ReportConstant.GIAY_THONGKECTCC_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			if(  Validator.isNotNull(namBaoCao) 
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.THONGKECTCC_TU)){
				String tenFile_Export = namBaoCao+"_"+ReportConstant.GIAY_THONGKECTCC_TU_EXPORT+"_"+currentTimeFull;
				ThongKeCTCCTU objectReport = ThongKeCTCCTUExport.getModel(namBaoCao);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.BAOCAOTHONGKE, ReportConstant.GIAY_THONGKECTCC_TU_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			
			if(Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.THONGKEDNNSEARCH)){
				String tenFile_Export = ReportConstant.GIAY_THONGKENC_SEARCH_EXPORT+"_"+currentTimeFull;
				ThongKeDauNoiNuocSearch objectReport = ThongKeDauNoiNuocSearchExport.getModel(resourceRequest);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.BAOCAOTHONGKE, ReportConstant.GIAY_THONGKENC_SEARCH_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
			if(Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.THONGKEVSSEARCH)){
				String tenFile_Export = ReportConstant.GIAY_THONGKEVS_SEARCH_EXPORT+"_"+currentTimeFull;
				ThongKeVeSinhSearch objectReport = ThongKeVeSinhSearchExport.getModel(resourceRequest);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.BAOCAOTHONGKE, ReportConstant.GIAY_THONGKEVS_SEARCH_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
			}
		}catch (Exception e) {
			log.error(e);
		}
		
		
	}
}
