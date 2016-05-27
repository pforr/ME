package vn.dtt.sol.ns.reporting.model.tonghopvegioitu;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.reporting.model.tonghopvegioitu.TongHopVeGioiTU.TongHopVeGioiTUDanhSach;
import vn.dtt.sol.ns.tramcap.business.THONGTINKIEMDEMNUOCBusiness;
import vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.util.WebKeys;
import vn.dtt.sol.ns.vesinhmoitruong.business.ThongTinKiemDemHoGDBusiness;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemHoGD;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class TongHopVeGioiTUExport {
	private static Log _log = LogFactoryUtil.getLog(TongHopVeGioiTUExport.class);
	
	public static TongHopVeGioiTU getModel(String nam){
		_log.info("==START=TongHopVeGioiTUExport===");
		
		TongHopVeGioiTU result = new TongHopVeGioiTU();
		
		String DAKETTHUCDIEUTRA = "1";
		// nuoc
		String DANHGIAKIEMDEMDNN = "1"; ///danhgiakiemdem 1 la kiem dem dat
		// ve sinh
		String[] DANHGIAKIEMDEMVSHGD = {"1","2"};// danhgiakiemdem 1 la co nha tieu hvs xay moi, 2 la co nha tieu hvs
		// maungaunhien de lay ti le vstx
		String mauNgauNhien = nam;
		
		TongHopVeGioiTU.TongHopVeGioiTUDanhSach tongHopVeGioiTUDanhSach = null;
		List<TongHopVeGioiTUDanhSach> lstTongHopVeGioiTUDanhSach11 = null;
		List<TongHopVeGioiTUDanhSach> lstTongHopVeGioiTUDanhSach12 = null;
		List<TongHopVeGioiTUDanhSach> lstTongHopVeGioiTUDanhSach22 = null;
		
		String namValue = "";
		int tongSo11Value = 0;
		int chuHoNam11Value = 0;
		int chuHoNu11Value = 0;
		
		int tongSo12Value = 0;
		int chuHoNam12Value = 0;
		int chuHoNu12Value = 0;
		
		int tongSo22Value = 0;
		int chuHoNam22Value = 0;
		int chuHoNu22Value = 0;
		
		// 1.1 start
		List<THONGTINKIEMDEMNUOC> lstThongtinkiemdemnuoc = THONGTINKIEMDEMNUOCBusiness.getThongTinDNNTHVGGroupByMaTinh(null, nam, null, null);
		lstTongHopVeGioiTUDanhSach11 = new ArrayList<TongHopVeGioiTUDanhSach>();
		if(Validator.isNotNull(lstThongtinkiemdemnuoc) && lstThongtinkiemdemnuoc.size() > 0){
			_log.info("===TongHopVeGioiTUExport==lstThongtinkiemdemnuoc="+lstThongtinkiemdemnuoc.size()+"--");
			for (THONGTINKIEMDEMNUOC thongtinkiemdemnuoc : lstThongtinkiemdemnuoc) {
				tongHopVeGioiTUDanhSach = result.new TongHopVeGioiTUDanhSach();
				
				String maTinh = thongtinkiemdemnuoc.getMaTinh();
				
				String tenTinhValue = "";
				int tongSoValue = 0;
				int chuHoNamValue = 0;
				int chuHoNuValue = 0;
				
				tenTinhValue = NuocSachUtils.getNameTinh(maTinh);
				chuHoNamValue = THONGTINKIEMDEMNUOCBusiness.countGioiTinhChuHo(maTinh, nam, String.valueOf(WebKeys.GIOITINH_NAM), DANHGIAKIEMDEMDNN,DAKETTHUCDIEUTRA);
				chuHoNuValue = THONGTINKIEMDEMNUOCBusiness.countGioiTinhChuHo(maTinh, nam, String.valueOf(WebKeys.GIOITINH_NU), DANHGIAKIEMDEMDNN,DAKETTHUCDIEUTRA);
				tongSoValue = chuHoNamValue + chuHoNuValue;
				
				chuHoNam11Value = chuHoNam11Value + chuHoNamValue;
				chuHoNu11Value = chuHoNu11Value + chuHoNuValue;
				tongSo11Value = tongSo11Value + tongSoValue;
				
				
				tongHopVeGioiTUDanhSach.setTenTinh(tenTinhValue);
				tongHopVeGioiTUDanhSach.setTongSo(tongSoValue);
				tongHopVeGioiTUDanhSach.setChuHoNam(chuHoNamValue);
				tongHopVeGioiTUDanhSach.setChuHoNu(chuHoNuValue);
				lstTongHopVeGioiTUDanhSach11.add(tongHopVeGioiTUDanhSach);
			}
		}
		// 1.1 end
		
		// 1.2 start
		List<ThongTinKiemDemHoGD> lstThongTinKiemDemHoGD12 = ThongTinKiemDemHoGDBusiness.getThongTinKiemDemHGDTVGGroupByMatinh(null, nam, null, null, null);
		lstTongHopVeGioiTUDanhSach12 = new ArrayList<TongHopVeGioiTUDanhSach>();
		if(Validator.isNotNull(lstThongTinKiemDemHoGD12) && lstThongTinKiemDemHoGD12.size() > 0){
			_log.info("===TongHopVeGioiTUExport==lstThongTinKiemDemHoGD="+lstThongtinkiemdemnuoc.size()+"--");
			for (ThongTinKiemDemHoGD thongTinKiemDemHoGD : lstThongTinKiemDemHoGD12) {
				tongHopVeGioiTUDanhSach = result.new TongHopVeGioiTUDanhSach();
				String maTinh = thongTinKiemDemHoGD.getMaTinh();
				
				String tenTinhValue = "";
				int tongSoValue = 0;
				int chuHoNamValue = 0;
				int chuHoNuValue = 0;
				
				tenTinhValue = NuocSachUtils.getNameTinh(maTinh);
				chuHoNamValue = ThongTinKiemDemHoGDBusiness.countGioiTinhChuHo(maTinh, nam, String.valueOf(WebKeys.GIOITINH_NAM), DANHGIAKIEMDEMVSHGD,DAKETTHUCDIEUTRA);
				chuHoNuValue = ThongTinKiemDemHoGDBusiness.countGioiTinhChuHo(maTinh, nam, String.valueOf(WebKeys.GIOITINH_NU), DANHGIAKIEMDEMVSHGD,DAKETTHUCDIEUTRA);
				tongSoValue = chuHoNamValue + chuHoNuValue;
				
				chuHoNam12Value = chuHoNam12Value + chuHoNamValue;
				chuHoNu12Value = chuHoNu12Value + chuHoNuValue;
				tongSo12Value = tongSo12Value + tongSoValue;
				
				
				tongHopVeGioiTUDanhSach.setTenTinh(tenTinhValue);
				tongHopVeGioiTUDanhSach.setTongSo(tongSoValue);
				tongHopVeGioiTUDanhSach.setChuHoNam(chuHoNamValue);
				tongHopVeGioiTUDanhSach.setChuHoNu(chuHoNuValue);
				lstTongHopVeGioiTUDanhSach12.add(tongHopVeGioiTUDanhSach);
			}
		}
		// 1.2 end
		
		// 2.2 start
		List<ThongTinKiemDemHoGD> lstThongTinKiemDemHoGD22 = ThongTinKiemDemHoGDBusiness.getThongTinKiemDemHGDVSTXTVGGroupByMatinh(null, nam, null, null, null);
		lstTongHopVeGioiTUDanhSach22 = new ArrayList<TongHopVeGioiTUDanhSach>();
		if(Validator.isNotNull(lstThongTinKiemDemHoGD22) && lstThongTinKiemDemHoGD22.size() > 0){
			_log.info("===TongHopVeGioiTUExport==lstThongTinKiemDemHoGD="+lstThongtinkiemdemnuoc.size()+"--");
			for (ThongTinKiemDemHoGD thongTinKiemDemHoGD : lstThongTinKiemDemHoGD22) {
				tongHopVeGioiTUDanhSach = result.new TongHopVeGioiTUDanhSach();
				String maTinh = thongTinKiemDemHoGD.getMaTinh();
				
				String tenTinhValue = "";
				int tongSoValue = 0;
				int chuHoNamValue = 0;
				int chuHoNuValue = 0;
				tenTinhValue = NuocSachUtils.getNameTinh(maTinh);
				chuHoNamValue = ThongTinKiemDemHoGDBusiness.countGioiTinhChuHoByMauNNVSTXJoinVSGD(maTinh, mauNgauNhien, String.valueOf(WebKeys.GIOITINH_NAM));
				chuHoNuValue = ThongTinKiemDemHoGDBusiness.countGioiTinhChuHoByMauNNVSTXJoinVSGD(maTinh, mauNgauNhien, String.valueOf(WebKeys.GIOITINH_NU));
				tongSoValue = chuHoNamValue + chuHoNuValue;
				
				chuHoNam22Value = chuHoNam22Value + chuHoNamValue;
				chuHoNu22Value = chuHoNu22Value + chuHoNuValue;
				tongSo22Value = tongSo22Value + tongSoValue;
				
				
				tongHopVeGioiTUDanhSach.setTenTinh(tenTinhValue);
				tongHopVeGioiTUDanhSach.setTongSo(tongSoValue);
				tongHopVeGioiTUDanhSach.setChuHoNam(chuHoNamValue);
				tongHopVeGioiTUDanhSach.setChuHoNu(chuHoNuValue);
				lstTongHopVeGioiTUDanhSach22.add(tongHopVeGioiTUDanhSach);
			}
		}
		
		// 2.2 end
		namValue = nam;
		
		result.setNam(namValue);
		result.setTongSo11(tongSo11Value);
		result.setChuHoNam11(chuHoNam11Value);
		result.setChuHoNu11(chuHoNu11Value);
		result.setLstTongHopVeGioiTUDanhSach11(lstTongHopVeGioiTUDanhSach11);
		
		result.setTongSo12(tongSo12Value);
		result.setChuHoNam12(chuHoNam12Value);
		result.setChuHoNu12(chuHoNu12Value);
		result.setLstTongHopVeGioiTUDanhSach12(lstTongHopVeGioiTUDanhSach12);
		
		result.setTongSo22(tongSo22Value);
		result.setChuHoNam22(chuHoNam22Value);
		result.setChuHoNu22(chuHoNu22Value);
		result.setLstTongHopVeGioiTUDanhSach22(lstTongHopVeGioiTUDanhSach22);
		_log.info("==END=TongHopVeGioiTUExport===");
		return result;
	}
}
