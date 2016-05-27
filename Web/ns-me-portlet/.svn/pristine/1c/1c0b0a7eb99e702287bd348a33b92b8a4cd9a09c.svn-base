package vn.dtt.sol.ns.reporting.model.baocaothongke.searchhelp.daunoinuoc;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.portlet.ResourceRequest;

import vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien;
import vn.dtt.cmon.user.dao.model.UserMapping;
import vn.dtt.sol.ns.business.KiemDemVienBussiness;
import vn.dtt.sol.ns.business.UserMappingBusiness;
import vn.dtt.sol.ns.daunoinuoc.search.DauNoiNuocDisplayTerms;
import vn.dtt.sol.ns.reporting.model.baocaothongke.searchhelp.daunoinuoc.ThongKeDauNoiNuocSearch.ThongKeDauNoiNuocSearchDanhSach;
import vn.dtt.sol.ns.reporting.utils.ReportConstant;
import vn.dtt.sol.ns.reporting.utils.ReportFunction;
import vn.dtt.sol.ns.tramcap.business.DauNoiNuocBusiness;
import vn.dtt.sol.ns.tramcap.business.THONGTINKIEMDEMNUOCBusiness;
import vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc;
import vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC;
import vn.dtt.sol.ns.tramcap.dao.service.DauNoiNuocLocalServiceUtil;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.util.format.ConvertUtil;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

public class ThongKeDauNoiNuocSearchExport {
	private static Log log = LogFactoryUtil.getLog(ThongKeDauNoiNuocSearchExport.class);
	public static ThongKeDauNoiNuocSearch getModel(ResourceRequest resourceRequest){
		log.info("==START=ThongKeDauNoiNuocSearchExport===");
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Bangkok"));
		
		DauNoiNuocDisplayTerms dauNoiTerms = new DauNoiNuocDisplayTerms(resourceRequest);
		
		ThongKeDauNoiNuocSearch result = new ThongKeDauNoiNuocSearch();
		
		ThongKeDauNoiNuocSearchDanhSach thongKeDauNoiNuocSearchDanhSach = null;
		List<ThongKeDauNoiNuocSearchDanhSach> lstThongKeDauNoiNuocSearchDanhSach = null;
		
		String thoiDiemValue = "";
		
		thoiDiemValue = ReportFunction.parserDateToString3LT(calendar.getTime());
		
		User user = null;
		
		try {
			user = PortalUtil.getUser(resourceRequest);

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		UserMapping userMapping = UserMappingBusiness.getUserMapping(user);
		
		String maTinh = StringPool.BLANK;
		
		if (Validator.isNull(maTinh)) {
			if (Validator.isNotNull(userMapping)) {
				if (userMapping.getUserType() != 1) {
					maTinh = userMapping.getOrgCode1();
				} else {
					maTinh = dauNoiTerms.getMaTinh();
				}
			} 
		}
		
		List<DauNoiNuoc> lstDauNoiNuoc = DauNoiNuocBusiness.findDauNoiNuocAll(
					maTinh, dauNoiTerms.getMaHuyen(),
					dauNoiTerms.getMaXa(), dauNoiTerms.getTramCapNuocId(),
					dauNoiTerms.getTrangThai(), dauNoiTerms.getKetQuaKiemDem(),
					dauNoiTerms.getKiemDemVienId(),
					dauNoiTerms.getGiamSatVienID(),
					dauNoiTerms.getNgayKiemDem(), dauNoiTerms.getNamBaoCao(),
					dauNoiTerms.getIdNguoiTao(), dauNoiTerms.getNgayNhap(),
					dauNoiTerms.getTenChuHo());
		lstThongKeDauNoiNuocSearchDanhSach = new ArrayList<ThongKeDauNoiNuocSearchDanhSach>();
		if(Validator.isNotNull(lstDauNoiNuoc) && lstDauNoiNuoc.size() > 0){
			log.info("--lstDauNoiNuoc.size()--"+lstDauNoiNuoc.size());
			for (DauNoiNuoc dauNoiNuoc : lstDauNoiNuoc) {
				thongKeDauNoiNuocSearchDanhSach = result.new ThongKeDauNoiNuocSearchDanhSach();
				
				String tenTinhValue = "";
				String huyenValue = "";
				String xaValue = "";
				String thonValue = "";
				String tramCapValue = "";
				String tenChuHoValue = "";
				String trangThaiKDValue = "";
				String ketQuaKDValue = "";
				String ngayKDValue = "";
				String kiemDemVienValue = "";
				String GSVValue = "";
				String namBaoCaoValue = "";
				
				tenTinhValue = NuocSachUtils.getNameTinh(dauNoiNuoc.getMaTinh());
				huyenValue = Validator.isNotNull(dauNoiNuoc.getMaHuyen()) ? NuocSachUtils.getNameHuyen(null, dauNoiNuoc.getMaHuyen()) : "";
				xaValue = Validator.isNotNull(dauNoiNuoc.getMaXa()) ? NuocSachUtils.getNameXa( dauNoiNuoc.getMaXa()) : "";
				thonValue = Validator.isNotNull(dauNoiNuoc.getThonXom()) ? dauNoiNuoc.getThonXom() : "";
				tramCapValue = Validator.isNotNull(dauNoiNuoc.getMaHuyen()) ? NuocSachUtils.getTenTramByTramId(String.valueOf(dauNoiNuoc.getTramCapNuocId())) : "";
				tenChuHoValue = Validator.isNotNull(dauNoiNuoc.getTenChuHo()) ? dauNoiNuoc.getTenChuHo() : "";
				
				//trangThaiKDValue = "";
				if(Validator.isNotNull(dauNoiNuoc.getTrangThai())){
					int trangThaiTemp = dauNoiNuoc.getTrangThai();
					if(trangThaiTemp == 0){ // chua kiem dem
						trangThaiKDValue = ReportConstant.CHUACOKEHOACH;
					}else{
						THONGTINKIEMDEMNUOC thongtinkiemdemnuoc = THONGTINKIEMDEMNUOCBusiness.getDauNoiNuocBaoCaoSearchHelp(dauNoiNuoc.getMaTinh(), dauNoiNuoc.getMaHuyen(), dauNoiNuoc.getMaXa(), String.valueOf(dauNoiNuoc.getTramCapNuocId()), String.valueOf(dauNoiNuoc.getId()));
						if(Validator.isNotNull(thongtinkiemdemnuoc)){
							
							ngayKDValue = Validator.isNotNull(thongtinkiemdemnuoc.getNgayKiemDem()) ? ConvertUtil.parseDateToString(thongtinkiemdemnuoc.getNgayKiemDem()) : "";
							
							if(Validator.isNotNull(thongtinkiemdemnuoc.getDaKetThucDieuTra())){
								int daKetThucDieuTraTemp = thongtinkiemdemnuoc.getDaKetThucDieuTra();
								if(daKetThucDieuTraTemp == 0){// cho khao sat
									trangThaiKDValue = ReportConstant.CHOKHAOSAT;
								}else if(daKetThucDieuTraTemp == 1){// da hoan thanh
									trangThaiKDValue = ReportConstant.DAHOANTHANH;
								}else if(daKetThucDieuTraTemp == 2){// chua hoan thanh
									trangThaiKDValue = ReportConstant.CHUAHOANTHANH;
								}else if(daKetThucDieuTraTemp == 3){// da huy
									trangThaiKDValue = ReportConstant.DAHUY;
								}
							}else{// null tuong duong voi cho khao sat
								trangThaiKDValue = ReportConstant.CHOKHAOSAT;
							}
							
							if(Validator.isNotNull(thongtinkiemdemnuoc.getDanhGiaKiemDem())){
								int danhGiaKiemDemTemp = thongtinkiemdemnuoc.getDanhGiaKiemDem();
								if(danhGiaKiemDemTemp == 0){// ko ket qua
									ketQuaKDValue = ReportConstant.KHONGCOKETQUA;
								}else if(danhGiaKiemDemTemp == 1){ // kiem dem dat
									ketQuaKDValue = ReportConstant.KIEMDEMDAT;
								}else if(danhGiaKiemDemTemp == 2){ // kiem dem Ko dat
									ketQuaKDValue = ReportConstant.KIEMDEMKHONGDAT;
								}
							}
							KiemDemVien kiemDemVien = KiemDemVienBussiness.getKiemDemVienByKeHoachKiemDemNuocID(String.valueOf(thongtinkiemdemnuoc.getKeHoachKiemDemNuocId()));
							if(Validator.isNotNull(kiemDemVien)){
								kiemDemVienValue = kiemDemVien.getHoVaTen();
								GSVValue = kiemDemVien.getNameQuanLy();
							}
						}
					}
				}
				
				
				namBaoCaoValue = Validator.isNotNull(dauNoiNuoc.getNamBaoCao()) ? String.valueOf(dauNoiNuoc.getNamBaoCao()) : "";
				
				thongKeDauNoiNuocSearchDanhSach.setTenTinh(tenTinhValue);
				thongKeDauNoiNuocSearchDanhSach.setHuyen(huyenValue);
				thongKeDauNoiNuocSearchDanhSach.setXa(xaValue);
				thongKeDauNoiNuocSearchDanhSach.setThon(thonValue);
				thongKeDauNoiNuocSearchDanhSach.setTramCap(tramCapValue);
				thongKeDauNoiNuocSearchDanhSach.setTenChuHo(tenChuHoValue);
				thongKeDauNoiNuocSearchDanhSach.setTrangThaiKD(trangThaiKDValue);
				thongKeDauNoiNuocSearchDanhSach.setKetQuaKD(ketQuaKDValue);
				thongKeDauNoiNuocSearchDanhSach.setNgayKD(ngayKDValue);
				thongKeDauNoiNuocSearchDanhSach.setKiemDemVien(kiemDemVienValue);
				thongKeDauNoiNuocSearchDanhSach.setGSV(GSVValue);
				thongKeDauNoiNuocSearchDanhSach.setNamBaoCao(namBaoCaoValue);
				lstThongKeDauNoiNuocSearchDanhSach.add(thongKeDauNoiNuocSearchDanhSach);
			}
		}
		
		
		result.setThoiDiem(thoiDiemValue);
		result.setLstThongKeDauNoiNuocSearchDanhSach(lstThongKeDauNoiNuocSearchDanhSach);
		log.info("==END=ThongKeDauNoiNuocSearchExport===");
		return result;
	}
}
