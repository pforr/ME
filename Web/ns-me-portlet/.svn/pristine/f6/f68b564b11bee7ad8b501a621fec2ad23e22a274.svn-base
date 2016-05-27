package vn.dtt.sol.ns.reporting.model.baocaothongke.searchhelp.vesinh;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.portlet.ResourceRequest;

import vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien;
import vn.dtt.sol.ns.business.KiemDemVienBussiness;
import vn.dtt.sol.ns.business.UserMappingBusiness;
import vn.dtt.sol.ns.reporting.model.baocaothongke.searchhelp.vesinh.ThongKeVeSinhSearch.ThongKeVeSinhSearchDanhSach;
import vn.dtt.sol.ns.reporting.utils.ReportConstant;
import vn.dtt.sol.ns.reporting.utils.ReportFunction;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.util.format.ConvertUtil;
import vn.dtt.sol.ns.util.format.FormatData;
import vn.dtt.sol.ns.vesinhmoitruong.business.ThongTinKiemDemHoGDBusiness;
import vn.dtt.sol.ns.vesinhmoitruong.business.VeSinhGiaDinhBusiness;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemHoGD;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhGiaDinh;
import vn.dtt.sol.ns.vesinhmoitruong.terms.VeSinhGiaDinhDisplayTerms;
import vn.dtt.sol.ns.vesinhmoitruong.terms.VeSinhGiaDinhTerms;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class ThongKeVeSinhSearchExport {
	private static Log log = LogFactoryUtil.getLog(ThongKeVeSinhSearchExport.class);
	public static ThongKeVeSinhSearch getModel(ResourceRequest resourceRequest){
		log.info("==START=ThongKeVeSinhSearchExport===");
		ThongKeVeSinhSearch result = new ThongKeVeSinhSearch();
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Bangkok"));
		
		ThongKeVeSinhSearchDanhSach thongKeVeSinhSearchDanhSach = null;
		List<ThongKeVeSinhSearchDanhSach> lstThongKeVeSinhSearchDanhSach = null;
		
		
		VeSinhGiaDinhDisplayTerms veSinhGiaDinhDisplayTerms = new VeSinhGiaDinhDisplayTerms(resourceRequest);
		
		String thoiDiemValue = "";
		
		thoiDiemValue = ReportFunction.parserDateToString3LT(calendar.getTime());
		//log.info("--getNamBaoCaovstx="+String.valueOf(veSinhGiaDinhTerms.getNamBaoCaovstx())+"="+String.valueOf(veSinhGiaDinhTerms.getNamBaoCao())+"====");
		String ngayKiemDemTemp = "";
		if(Validator.isNotNull(veSinhGiaDinhDisplayTerms.getNgayKiemDem())){
			Date ngayKiemDemDate = FormatData.parseStringToDateformatDDMMYYY2(veSinhGiaDinhDisplayTerms.getNgayKiemDem());
			ngayKiemDemTemp = Validator.isNotNull(ngayKiemDemDate)? FormatData.parseDateToStringType6(ngayKiemDemDate) : "";
		}
		
		String ngayTaoTemp = "";
		if(Validator.isNotNull(veSinhGiaDinhDisplayTerms.getNgayTao())){
			Date ngayTaoDate = FormatData.parseStringToDateformatDDMMYYY2(veSinhGiaDinhDisplayTerms.getNgayTao());
			ngayTaoTemp = Validator.isNotNull(ngayTaoDate)? FormatData.parseDateToStringType6(ngayTaoDate) : "";
		}
		List<VeSinhGiaDinh> lstVeSinhGiaDinh = VeSinhGiaDinhBusiness.searchVeSinhGiaDinhAll(
				veSinhGiaDinhDisplayTerms.getMaTinh(),
				veSinhGiaDinhDisplayTerms.getMaHuyen(),
				veSinhGiaDinhDisplayTerms.getMaXa(), 
				veSinhGiaDinhDisplayTerms.getThonXom(),
				veSinhGiaDinhDisplayTerms.getTrangThai(),
				veSinhGiaDinhDisplayTerms.getDanhGiaKiemDem(),
				veSinhGiaDinhDisplayTerms.getKiemDemVien(),
				veSinhGiaDinhDisplayTerms.getGiamSatVien(),
				ngayKiemDemTemp, 
				veSinhGiaDinhDisplayTerms.getNamBaoCao(),
				veSinhGiaDinhDisplayTerms.getNamBaoCaovstx(),
				veSinhGiaDinhDisplayTerms.getIdNguoiTao(),
				ngayTaoTemp,
				veSinhGiaDinhDisplayTerms.getAdvText());
		log.info("veSinhGiaDinhDisplayTerms.getNgayKiemDem()="+veSinhGiaDinhDisplayTerms.getNgayKiemDem()+"=ngayTaoTemp="+ngayTaoTemp+"=veSinhGiaDinhDisplayTerms.getNgayTao()="+veSinhGiaDinhDisplayTerms.getNgayTao()+"=ngayTaoTemp="+ngayTaoTemp+"=");
		lstThongKeVeSinhSearchDanhSach = new ArrayList<ThongKeVeSinhSearchDanhSach>();
		if(Validator.isNotNull(lstVeSinhGiaDinh) && lstVeSinhGiaDinh.size() > 0){
			log.info("--lstVeSinhGiaDinh.size()--"+lstVeSinhGiaDinh.size());
			for (VeSinhGiaDinh veSinhGiaDinh : lstVeSinhGiaDinh) {
				thongKeVeSinhSearchDanhSach = result.new ThongKeVeSinhSearchDanhSach();
				
				String tenTinhValue = "";
				String huyenValue = "";
				String xaValue = "";
				String thonValue = "";
				String tenChuHoValue = "";
				String trangThaiKDValue = "";
				String ketQuaKDValue = "";
				String kiemDemVienValue = "";
				String GSVValue = "";
				String ngayKDValue = "";
				String namXDValue = "";
				String loaiDLValue = "";
				String ngTaoValue = "";
				String ngayNhapValue = "";
				String namBaoCaoValue = "";
				
				tenTinhValue = NuocSachUtils.getNameTinh(veSinhGiaDinh.getMaTinh());
				huyenValue = Validator.isNotNull(veSinhGiaDinh.getMaHuyen()) ? NuocSachUtils.getNameHuyen(null, veSinhGiaDinh.getMaHuyen()) : "";
				xaValue = Validator.isNotNull(veSinhGiaDinh.getMaXa()) ? NuocSachUtils.getNameXa( veSinhGiaDinh.getMaXa()) : "";
				thonValue = Validator.isNotNull(veSinhGiaDinh.getThonXom()) ? veSinhGiaDinh.getThonXom() : "";
				tenChuHoValue = Validator.isNotNull(veSinhGiaDinh.getTenChuHo()) ? veSinhGiaDinh.getTenChuHo() : "";
				
				loaiDLValue = ReportConstant.LOAIVSXM;
				if(Validator.isNotNull(veSinhGiaDinh.getMauNgauNhien())){
					String mauNgauNhienTemp = String.valueOf(veSinhGiaDinh.getMauNgauNhien());
					if(mauNgauNhienTemp.trim().length() >= 4){// vstx
						loaiDLValue = ReportConstant.LOAIVSTX;
					}else{// vsxm
						loaiDLValue = ReportConstant.LOAIVSXM;
					}
				}
				if(Validator.isNotNull(veSinhGiaDinh.getTrangThai())){
					int trangThaiTemp = veSinhGiaDinh.getTrangThai();
					if(trangThaiTemp == 0){ // chua kiem dem
						trangThaiKDValue = ReportConstant.CHUACOKEHOACH;
					}else{
						ThongTinKiemDemHoGD thongTinKiemDemHoGD = ThongTinKiemDemHoGDBusiness.getThongTinKiemDemHGDBaoCaoSearchHelp(veSinhGiaDinh.getMaTinh(), veSinhGiaDinh.getMaHuyen(), veSinhGiaDinh.getMaXa(), veSinhGiaDinh.getThonXom(), String.valueOf(veSinhGiaDinh.getId()));
						
						if(Validator.isNotNull(thongTinKiemDemHoGD)){
							ngayKDValue = Validator.isNotNull(thongTinKiemDemHoGD.getNgayKiemDem()) ? ConvertUtil.parseDateToString(thongTinKiemDemHoGD.getNgayKiemDem()) : "";
							namXDValue = Validator.isNotNull(thongTinKiemDemHoGD.getNamXayDung()) ? String.valueOf(thongTinKiemDemHoGD.getNamXayDung()) : "";
							if(Validator.isNotNull(thongTinKiemDemHoGD.getDaKetThucDieuTra())){
								int daKetThucDieuTraTemp = thongTinKiemDemHoGD.getDaKetThucDieuTra();
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
							
							if(Validator.isNotNull(thongTinKiemDemHoGD.getDanhGiaKiemDem())){
								int danhGiaKiemDemTemp = thongTinKiemDemHoGD.getDanhGiaKiemDem();
								if(danhGiaKiemDemTemp == 0){// ko ket qua
									ketQuaKDValue = ReportConstant.KHONGCOKETQUA;
								}else if(danhGiaKiemDemTemp == 1){ // hvs xm
									ketQuaKDValue = ReportConstant.NHATIEUHVSXAYMOI;
								}else if(danhGiaKiemDemTemp == 2){ // hvs xay cu
									ketQuaKDValue = ReportConstant.NHATIEUHVS;
								}else if(danhGiaKiemDemTemp == 3){ // ko co nha tieu
									ketQuaKDValue = ReportConstant.KOCONHATIEU;
								}else if(danhGiaKiemDemTemp == 4){ // KO HVS
									ketQuaKDValue = ReportConstant.KHVS;
								}
							}
							
							KiemDemVien kiemDemVien = KiemDemVienBussiness.getKiemDemVienByKeHoachKiemDemVeSinhID(String.valueOf(thongTinKiemDemHoGD.getKeHoachKiemDemVeSinhId()));
							if(Validator.isNotNull(kiemDemVien)){
								kiemDemVienValue = kiemDemVien.getHoVaTen();
								GSVValue = kiemDemVien.getNameQuanLy();
							}
						}
					}
				}
				
				
				if(Validator.isNull(namXDValue)){
					namXDValue = Validator.isNotNull(veSinhGiaDinh.getNamXayDung()) ? String.valueOf(veSinhGiaDinh.getNamXayDung()) : "";
				}
				ngTaoValue = Validator.isNotNull(veSinhGiaDinh.getIdNguoiTao()) ? String.valueOf(veSinhGiaDinh.getIdNguoiTao()) : "";// ko hien ra
				ngayNhapValue = Validator.isNotNull(veSinhGiaDinh.getNgayTao()) ? ConvertUtil.parseDateToString(veSinhGiaDinh.getNgayTao()) : "";
				namBaoCaoValue = Validator.isNotNull(veSinhGiaDinh.getNamBaoCao()) ? String.valueOf(veSinhGiaDinh.getNamBaoCao()) : "";
				
				
				thongKeVeSinhSearchDanhSach.setTenTinh(tenTinhValue);
				thongKeVeSinhSearchDanhSach.setHuyen(huyenValue);
				thongKeVeSinhSearchDanhSach.setXa(xaValue);
				thongKeVeSinhSearchDanhSach.setThon(thonValue);
				thongKeVeSinhSearchDanhSach.setTenChuHo(tenChuHoValue);
				thongKeVeSinhSearchDanhSach.setTrangThaiKD(trangThaiKDValue);
				thongKeVeSinhSearchDanhSach.setKetQuaKD(ketQuaKDValue);
				thongKeVeSinhSearchDanhSach.setKiemDemVien(kiemDemVienValue);
				thongKeVeSinhSearchDanhSach.setGSV(GSVValue);
				thongKeVeSinhSearchDanhSach.setNgayKD(ngayKDValue);
				thongKeVeSinhSearchDanhSach.setNamXD(namXDValue);
				thongKeVeSinhSearchDanhSach.setLoaiDL(loaiDLValue);
				thongKeVeSinhSearchDanhSach.setNgTao(ngTaoValue);
				thongKeVeSinhSearchDanhSach.setNgayNhap(ngayNhapValue);
				thongKeVeSinhSearchDanhSach.setNamBaoCao(namBaoCaoValue);
				lstThongKeVeSinhSearchDanhSach.add(thongKeVeSinhSearchDanhSach);
			}
		}
		result.setThoiDiem(thoiDiemValue);
		result.setLstThongKeVeSinhSearchDanhSach(lstThongKeVeSinhSearchDanhSach);
		log.info("==END=ThongKeVeSinhSearchExport===");
		return result;
	}
}
