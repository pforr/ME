package vn.dtt.sol.ns.reporting.model.dli11tu;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.reporting.utils.ReportBusinessUtils;
import vn.dtt.sol.ns.reporting.utils.ReportConstant;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class TUDauNoiCapNuocExport {
	private static Log log = LogFactoryUtil.getLog(TUDauNoiCapNuocExport.class);
	
	public static TUDauNoiCapNuoc getModel(String namBaoCao){
		TUDauNoiCapNuoc result = new TUDauNoiCapNuoc();
		/*
		TUDauNoiCapNuocTHDanhSach tuDauNoiCapNuocTHDanhSach = null;
		List<TUDauNoiCapNuocTHDanhSach> lstTuDauNoiCapNuocTHDanhSach = null;
		TUDauNoiCapNuocTinhDanhSach tuDauNoiCapNuocTinhDanhSach = null;
		List<TUDauNoiCapNuocTinhDanhSach> lstTuDauNoiCapNuocTinhDanhSach = null;
		
		String namValue = "";
		
		namValue = namBaoCao;
		
		lstTuDauNoiCapNuocTHDanhSach = new ArrayList<TUDauNoiCapNuocTHDanhSach>();
		
		for(int i = 0;  i < 3; i++){
			tuDauNoiCapNuocTHDanhSach = new TUDauNoiCapNuocTHDanhSach();
			
			String tenTinhValue = "";	
			int soDauNoiTheoKeHoachValue = 0;
			int soDauNoiMoiHoatDongValue = 0;
			double phanTramThucHienKeHoachValue = 0;
			
			tenTinhValue = "HN "+i;
			soDauNoiTheoKeHoachValue = 200+i;
			soDauNoiMoiHoatDongValue = 100+i;
			
			tuDauNoiCapNuocTHDanhSach.setTenTinh(tenTinhValue);
			tuDauNoiCapNuocTHDanhSach.setSoDauNoiTheoKeHoach(soDauNoiTheoKeHoachValue);
			tuDauNoiCapNuocTHDanhSach.setSoDauNoiMoiHoatDong(soDauNoiMoiHoatDongValue);
			
			
			lstTuDauNoiCapNuocTHDanhSach.add(tuDauNoiCapNuocTHDanhSach);
		}
		
		lstTuDauNoiCapNuocTinhDanhSach = new ArrayList<TUDauNoiCapNuocTinhDanhSach>();
		
		for(int i = 0 ; i < 200 ; i++){
			tuDauNoiCapNuocTinhDanhSach = new TUDauNoiCapNuocTinhDanhSach();
			
			String tenTinhValue = "";	
			String huyenValue = "";
			String xaValue = "";
			String tenHeThongCapNuocValue = "";
			int soDauNoiMoiHoatDongValue = 0;
			
			if(i < 44){
				tenTinhValue = "HN 0";
				if(i < 10){
					huyenValue = "Buon Ma Thuot";
				}else if(i >= 10 && i < 30){
					huyenValue = "Dak Lak";
				}else{
					huyenValue = "Ha Giang";
				}
				
				xaValue = "Mu Cang Chai "+i;
				tenHeThongCapNuocValue = "NS Nhat Tan "+i;
				soDauNoiMoiHoatDongValue = 110+i;
			}else if(i >= 44 && i < 130 ){
				tenTinhValue = "HN 1";
				if(i < 80){
					huyenValue = "Ca Mau";
				}else if(i >= 80 && i < 100){
					huyenValue = "Tinh Te";
				}else{
					huyenValue = "Nhat Tao";
				}
//				huyenValue = "Lao Cai 1";
				xaValue = "Mu Cang Chai "+i;
				tenHeThongCapNuocValue = "NS Nhat Tan "+i;
				soDauNoiMoiHoatDongValue = 120+i;
			}else if(i >= 130 ){
				tenTinhValue = "HN 2";
				if(i < 150){
					huyenValue = "Vinasas";
				}else if(i >= 150 && i < 190){
					huyenValue = "Apolo";
				}else{
					huyenValue = "London";
				}
//				huyenValue = "Lao Cai 2";
				xaValue = "Mu Cang Chai "+i;
				tenHeThongCapNuocValue = "NS Nhat Tan "+i;
				soDauNoiMoiHoatDongValue = 130+i;
			}
			
			tuDauNoiCapNuocTinhDanhSach.setTenTinh(tenTinhValue);
			tuDauNoiCapNuocTinhDanhSach.setHuyen(huyenValue);
			tuDauNoiCapNuocTinhDanhSach.setXa(xaValue);
			tuDauNoiCapNuocTinhDanhSach.setTenHeThongCapNuoc(tenHeThongCapNuocValue);
			tuDauNoiCapNuocTinhDanhSach.setSoDauNoiMoiHoatDong(soDauNoiMoiHoatDongValue);
			
			lstTuDauNoiCapNuocTinhDanhSach.add(tuDauNoiCapNuocTinhDanhSach);
		}
		
		result.setNam(namValue);
		result.setLstTUDauNoiCapNuocTHDanhSach(lstTuDauNoiCapNuocTHDanhSach);
		result.setLstTUDauNoiCapNuocTinhDanhSach(lstTuDauNoiCapNuocTinhDanhSach);
		*/
		return result;
	}
	
//	public static void main(String[] args) {
//		String a = ReportBusinessUtils.actionExport_Dli_11_TU("D:\\DEV\\liferay-plugins-sdk-6.2.0\\portlets\\ns-me-portlet\\docroot\\", "2015", ReportConstant.DUOI_DOC);
//		System.out.println("====TU===="+a);
//	}
}
