package vn.dtt.sol.ns.reporting.model.ktqxnnctu;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.reporting.model.ktqxnnctu.KQXetNghiemNcTU.KQXetNghiemNcTramYTeTU;
import vn.dtt.sol.ns.reporting.model.ktqxnnctu.KQXetNghiemNcTU.KQXetNghiemNcTruongHocTU;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.vesinhmoitruong.business.CongTrinhBussiness;
import vn.dtt.sol.ns.vesinhmoitruong.business.ThongTinKiemDemCongTrinhBusiness;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemCongTrinh;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhCongTrinh;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class KQXetNghiemNcTUExport {
	private static Log _log = LogFactoryUtil.getLog(KQXetNghiemNcTUExport.class);
	
	public static KQXetNghiemNcTU getModel(String namBaoCao){
		KQXetNghiemNcTU result = new KQXetNghiemNcTU();
		_log.info("==START PHIEU KET QUA XET NGHIEM NC TU=KQXetNghiemNcTUExport===");
		
		String LOAICONGTRINHTRUONGHOC = "1";//1 la truong hoc
		String LOAICONGTRINHTRAMYTE = "2";//1 la tram y te
		String TRANGTHAI = "2"; // 2 la kiem dem dat hvs
		String DAKETTHUCDIEUTRA = "1"; // 1 la da hoan thanh dieu tra
		String DANHGIAKIEMDEM = "1"; // 1 la cong trinh hop ve sinh
		//
		KQXetNghiemNcTU.KQXetNghiemNcTruongHocTU xetNghiemNcTruongHocTU = null; 
		List<KQXetNghiemNcTruongHocTU> lstXetNghiemNcTruongHocTU = null;
		 
		//KQXetNghiemNcTruongHocTUDanhSach xetNghiemNcTruongHocTUDanhSach = null;
		//List<KQXetNghiemNcTruongHocTUDanhSach> lstXetNghiemNcTruongHocTUDanhSach = null;
		
		//
		KQXetNghiemNcTU.KQXetNghiemNcTramYTeTU xetNghiemNcTramYTeTU = null;
		List<KQXetNghiemNcTramYTeTU> lstXetNghiemNcTramYTeTU = null;
		
		//KQXetNghiemNcTramYTeTUDanhSach xetNghiemNcTramYTeTUDanhSach = null;
		//List<KQXetNghiemNcTramYTeTUDanhSach> lstXetNghiemNcTramYTeTUDanhSach = null;
		
		String namValue = "";
		namValue = Validator.isNotNull(namBaoCao) ? namBaoCao : "";		
		
		if( Validator.isNotNull(namBaoCao)){
			// start truong hoc
			List<VeSinhCongTrinh> lstveSinhCongTrinhTruongHoc = CongTrinhBussiness.getVeSinhCongTrinhJoinThongTinKiemDemCT(null, null, null, null, LOAICONGTRINHTRUONGHOC, null, namBaoCao, DAKETTHUCDIEUTRA, null);
			lstXetNghiemNcTruongHocTU = new ArrayList<KQXetNghiemNcTruongHocTU>();
			
			
			//lstXetNghiemNcTruongHocTUDanhSach = new ArrayList<KQXetNghiemNcTruongHocTUDanhSach>();
			
			if(Validator.isNotNull(lstveSinhCongTrinhTruongHoc) && lstveSinhCongTrinhTruongHoc.size() > 0){
				for (VeSinhCongTrinh veSinhCongTrinhTruongHoc : lstveSinhCongTrinhTruongHoc) {
					xetNghiemNcTruongHocTU = result.new KQXetNghiemNcTruongHocTU();
					
					String tenTinhValue = "";
					String huyenXaValue = "";
					String tenTruongValue = "";
					String soPhieuXetNghiemValue = "";
					int datHayKoValue = 0;
					
					tenTinhValue = NuocSachUtils.getNameTinh(veSinhCongTrinhTruongHoc.getMaTinh());
					String huyenTemp = Validator.isNotNull(	veSinhCongTrinhTruongHoc.getMaHuyen()) ? NuocSachUtils.getNameHuyen(null, veSinhCongTrinhTruongHoc.getMaHuyen()) : "";
					String xaTemp = Validator.isNotNull(veSinhCongTrinhTruongHoc.getMaXa()) ? "-"+NuocSachUtils.getNameXa( veSinhCongTrinhTruongHoc.getMaXa()) : "";
					huyenXaValue = huyenTemp+xaTemp;
					tenTruongValue = Validator.isNotNull(	veSinhCongTrinhTruongHoc.getTenCongTrinh()) ? veSinhCongTrinhTruongHoc.getTenCongTrinh() : "";
					ThongTinKiemDemCongTrinh thongTinKiemDemCongTrinhTruongHoc = ThongTinKiemDemCongTrinhBusiness.getThongTinKiemDemCongTrinhByVeSinhCTID(String.valueOf(veSinhCongTrinhTruongHoc.getId()));
					soPhieuXetNghiemValue = Validator.isNotNull(thongTinKiemDemCongTrinhTruongHoc) ? thongTinKiemDemCongTrinhTruongHoc.getSophieuxetnghiem() : "";
					datHayKoValue = Validator.isNotNull(veSinhCongTrinhTruongHoc.getTrangThai()) ? veSinhCongTrinhTruongHoc.getTrangThai() : 0;
					
					xetNghiemNcTruongHocTU.setTenTinh(tenTinhValue);
					xetNghiemNcTruongHocTU.setHuyenXa(huyenXaValue);
					xetNghiemNcTruongHocTU.setTenTruong(tenTruongValue);
					xetNghiemNcTruongHocTU.setSoPhieuXetNghiem(soPhieuXetNghiemValue);
					xetNghiemNcTruongHocTU.setDatHayKo(datHayKoValue);
					
					lstXetNghiemNcTruongHocTU.add(xetNghiemNcTruongHocTU);
				}
			}
			// end truong hoc
			
			// start ve sinh cong trinh tram y te
			List<VeSinhCongTrinh> lstveSinhCongTrinhTramYTe = CongTrinhBussiness.getVeSinhCongTrinhJoinThongTinKiemDemCT(null, null, null, null, LOAICONGTRINHTRAMYTE, null, namBaoCao, DAKETTHUCDIEUTRA, null);
			
			lstXetNghiemNcTramYTeTU = new ArrayList<KQXetNghiemNcTramYTeTU>();
			
			if(Validator.isNotNull(lstveSinhCongTrinhTramYTe) && lstveSinhCongTrinhTramYTe.size() > 0){
				for (VeSinhCongTrinh veSinhCongTrinhTramYTe : lstveSinhCongTrinhTramYTe) {
					xetNghiemNcTramYTeTU = result.new KQXetNghiemNcTramYTeTU();
					
					String tenTinhValue = "";
					String huyenValue ="";
					String tenTramYTeValue = "";
					String soPhieuXetNghiemValue = "";
					int datHayKoValue = 0;
					
					tenTinhValue = NuocSachUtils.getNameTinh(veSinhCongTrinhTramYTe.getMaTinh());
					huyenValue = Validator.isNotNull(	veSinhCongTrinhTramYTe.getMaHuyen()) ? NuocSachUtils.getNameHuyen(null, veSinhCongTrinhTramYTe.getMaHuyen()) : "";
					tenTramYTeValue = Validator.isNotNull(	veSinhCongTrinhTramYTe.getTenCongTrinh()) ? veSinhCongTrinhTramYTe.getTenCongTrinh() : "";
					ThongTinKiemDemCongTrinh thongTinKiemDemCongTrinhTramYTe = ThongTinKiemDemCongTrinhBusiness.getThongTinKiemDemCongTrinhByVeSinhCTID(String.valueOf(veSinhCongTrinhTramYTe.getId()));
					soPhieuXetNghiemValue = Validator.isNotNull(thongTinKiemDemCongTrinhTramYTe) ? thongTinKiemDemCongTrinhTramYTe.getSophieuxetnghiem() : "";
					datHayKoValue = Validator.isNotNull(veSinhCongTrinhTramYTe.getTrangThai()) ? veSinhCongTrinhTramYTe.getTrangThai() : 0;
					xetNghiemNcTramYTeTU.setTenTinh(tenTinhValue);
					xetNghiemNcTramYTeTU.setHuyen(huyenValue);
					xetNghiemNcTramYTeTU.setTenTramYTe(tenTramYTeValue);
					xetNghiemNcTramYTeTU.setSoPhieuXetNghiem(soPhieuXetNghiemValue);
					xetNghiemNcTramYTeTU.setDatHayKo(datHayKoValue);
					lstXetNghiemNcTramYTeTU.add(xetNghiemNcTramYTeTU);
				}
			}
			
			// end ve sinh cong trinh tram y te
		}
		result.setNam(namValue);
		result.setLstXetNghiemNcTruongHocTU(lstXetNghiemNcTruongHocTU);
		result.setLstXetNghiemNcTramYTeTU(lstXetNghiemNcTramYTeTU);
		
		_log.info("==END PHIEU KET QUA XET NGHIEM NC TU=KQXetNghiemNcTUExport===");
		return result;
	}
}
