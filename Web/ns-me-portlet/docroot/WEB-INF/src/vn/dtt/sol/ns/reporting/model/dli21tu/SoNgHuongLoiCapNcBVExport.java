package vn.dtt.sol.ns.reporting.model.dli21tu;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.tramcap.business.DanhGiaBenVungBussiness;
import vn.dtt.sol.ns.tramcap.business.TramCapBusiness;
import vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc;
import vn.dtt.sol.ns.util.NuocSachUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class SoNgHuongLoiCapNcBVExport {
	private static Log log = LogFactoryUtil.getLog(SoNgHuongLoiCapNcBVExport.class);
	
	
	public static SoNgHuongLoiCapNcBV getModel(String namBaoCao){
		log.info("==START==DLI 2.1 TW==SoNgHuongLoiCapNcBVExport===");
		String KETQUADANHGIA = "1";
		SoNgHuongLoiCapNcBV result = new SoNgHuongLoiCapNcBV();
		
		///
		SoNgHuongLoiCapNcBVToanTinh soNgHuongLoiCapNcBVToanTinh = null;
		List<SoNgHuongLoiCapNcBVToanTinh> lstSoNgHuongLoiCapNcBVToanTinh = null;
		
		SoNgHuongLoiCapNcBVToanTinhDanhSach soNgHuongLoiCapNcBVToanTinhDanhSach = null;
		List<SoNgHuongLoiCapNcBVToanTinhDanhSach> lstSoNgHuongLoiCapNcBVToanTinhDanhSach = null;
		///
		SoNgHuongLoiCapNcBVTinh soNgHuongLoiCapNcBVTinh = null;
		List<SoNgHuongLoiCapNcBVTinh> lstSoNgHuongLoiCapNcBVTinh = null;
		
		SoNgHuongLoiCapNcBVTinhDanhSach soNgHuongLoiCapNcBVTinhDanhSach = null;
		List<SoNgHuongLoiCapNcBVTinhDanhSach> lstSoNgHuongLoiCapNcBVTinhDanhSach = null;
		
		
		String namValue = "";
		
		namValue = Validator.isNotNull(namBaoCao) ? namBaoCao : "";	
		
		//1 start cap nuoc ben vung tat ca cac tinh
		lstSoNgHuongLoiCapNcBVToanTinh = new ArrayList<SoNgHuongLoiCapNcBVToanTinh>();
		List<TramCapNuoc> lstTramCapNuocToanTinh = null;
		if(Validator.isNotNull(namBaoCao)){
			lstTramCapNuocToanTinh = TramCapBusiness.getTramCapJoinDanhGiaBenVungGroupByMaTinhTW(namBaoCao, KETQUADANHGIA);
		}
		
		if(Validator.isNotNull(lstTramCapNuocToanTinh) && lstTramCapNuocToanTinh.size() > 0){
			soNgHuongLoiCapNcBVToanTinh = new SoNgHuongLoiCapNcBVToanTinh();
			
			int soTinhTotalValue = 0;
			soTinhTotalValue = lstTramCapNuocToanTinh.size();
			
			lstSoNgHuongLoiCapNcBVToanTinhDanhSach = new ArrayList<SoNgHuongLoiCapNcBVToanTinhDanhSach>();
			for (TramCapNuoc tramCapNuocToanTinh : lstTramCapNuocToanTinh) {
				soNgHuongLoiCapNcBVToanTinhDanhSach = new SoNgHuongLoiCapNcBVToanTinhDanhSach();
				
				String tenTinhValue = "";
				int soNguoiHuongLoiValue = 0;
				
				tenTinhValue = NuocSachUtils.getNameTinh(tramCapNuocToanTinh.getMaTinh());
				soNguoiHuongLoiValue = Validator.isNotNull(tramCapNuocToanTinh.getMaTinh()) ? DanhGiaBenVungBussiness.sumSoNgHgLoiByMaTinhHuyenXaTramCapId(tramCapNuocToanTinh.getMaTinh(), null, null, namBaoCao, KETQUADANHGIA, null) : 0;
				
				soNgHuongLoiCapNcBVToanTinhDanhSach.setTenTinh(tenTinhValue);
				soNgHuongLoiCapNcBVToanTinhDanhSach.setSoNguoiHuongLoi(soNguoiHuongLoiValue);
				lstSoNgHuongLoiCapNcBVToanTinhDanhSach.add(soNgHuongLoiCapNcBVToanTinhDanhSach);
			}
			
			soNgHuongLoiCapNcBVToanTinh.setSoTinhTotal(soTinhTotalValue);
			soNgHuongLoiCapNcBVToanTinh.setLstSoNgHuongLoiCapNcBVToanTinhDanhSach(lstSoNgHuongLoiCapNcBVToanTinhDanhSach);
			lstSoNgHuongLoiCapNcBVToanTinh.add(soNgHuongLoiCapNcBVToanTinh);
		}		
		//1 end cap nuoc ben vung tat ca cac tinh
		
		//2 start cap nuoc ben vung tung tinh
		List<TramCapNuoc> lstTramCapNuocTinh = null;
		if(Validator.isNotNull(namBaoCao)){
			lstTramCapNuocTinh = TramCapBusiness.getTramCapJoinDanhGiaBenVungGroupByMaTinhTW(namBaoCao, KETQUADANHGIA);
		}
		if(Validator.isNotNull(lstTramCapNuocTinh) && lstTramCapNuocTinh.size() > 0){
			lstSoNgHuongLoiCapNcBVTinh = new ArrayList<SoNgHuongLoiCapNcBVTinh>();
			
			for (TramCapNuoc tramCapNuocTinh : lstTramCapNuocTinh) {
				soNgHuongLoiCapNcBVTinh = new SoNgHuongLoiCapNcBVTinh();
				
				String tenTinhValue = "";
				tenTinhValue = NuocSachUtils.getNameTinh(tramCapNuocTinh.getMaTinh());
				
				lstSoNgHuongLoiCapNcBVTinhDanhSach = new ArrayList<SoNgHuongLoiCapNcBVTinhDanhSach>();
				List<TramCapNuoc> lstTramCapNuocMotTinh = null;
				if(Validator.isNotNull(tramCapNuocTinh.getMaTinh())){
					lstTramCapNuocMotTinh = TramCapBusiness.getTramCapJoinDanhGiaBenVungGroupByMaHuyenXaTW(namBaoCao, tramCapNuocTinh.getMaTinh(), KETQUADANHGIA);
				}
				if(Validator.isNotNull(lstTramCapNuocMotTinh) && lstTramCapNuocMotTinh.size() > 0){
					for (TramCapNuoc tramCapNuocMotTinh : lstTramCapNuocMotTinh) {
						soNgHuongLoiCapNcBVTinhDanhSach = new SoNgHuongLoiCapNcBVTinhDanhSach();
						
						String huyenValue = "";
						String xaValue = "";
						String tenHeThongCapNuocValue = "";
						int soNguoiHuongLoiValue = 0;
						
						huyenValue =  Validator.isNotNull(tramCapNuocMotTinh.getMaHuyen()) ? NuocSachUtils.getNameHuyen(null, tramCapNuocMotTinh.getMaHuyen()) : "";
						xaValue = Validator.isNotNull(tramCapNuocMotTinh.getMaXa()) ? NuocSachUtils.getNameXa( tramCapNuocMotTinh.getMaXa()) : "";
						tenHeThongCapNuocValue = Validator.isNotNull(tramCapNuocMotTinh.getTenTram()) ? tramCapNuocMotTinh.getTenTram() : "";
						soNguoiHuongLoiValue = Validator.isNotNull(tramCapNuocMotTinh.getMaTinh()) ? DanhGiaBenVungBussiness.sumSoNgHgLoiByMaTinhHuyenXaTramCapId(tramCapNuocMotTinh.getMaTinh(), tramCapNuocMotTinh.getMaHuyen(), tramCapNuocMotTinh.getMaXa(), namBaoCao, KETQUADANHGIA, String.valueOf(tramCapNuocMotTinh.getId())) : 0;
						
						soNgHuongLoiCapNcBVTinhDanhSach.setHuyen(huyenValue);
						soNgHuongLoiCapNcBVTinhDanhSach.setXa(xaValue);
						soNgHuongLoiCapNcBVTinhDanhSach.setTenHeThongCapNuoc(tenHeThongCapNuocValue);
						soNgHuongLoiCapNcBVTinhDanhSach.setSoNguoiHuongLoi(soNguoiHuongLoiValue);
						lstSoNgHuongLoiCapNcBVTinhDanhSach.add(soNgHuongLoiCapNcBVTinhDanhSach);
					}
				}
				
				soNgHuongLoiCapNcBVTinh.setTenTinh(tenTinhValue);
				soNgHuongLoiCapNcBVTinh.setLstSoNgHuongLoiCapNcBVTinhDanhSach(lstSoNgHuongLoiCapNcBVTinhDanhSach);
				
				lstSoNgHuongLoiCapNcBVTinh.add(soNgHuongLoiCapNcBVTinh);
			}
		}
		//2 end cap nuoc ben vung tung tinh
		
		result.setNam(namValue);
		result.setLstSoNgHuongLoiCapNcBVToanTinh(lstSoNgHuongLoiCapNcBVToanTinh);
		result.setLstSoNgHuongLoiCapNcBVTinh(lstSoNgHuongLoiCapNcBVTinh);
		log.info("==END==DLI 2.1 TW==SoNgHuongLoiCapNcBVExport===");
		return result;
	}
}
