package vn.dtt.sol.ns.reporting.model.ktqxnnc;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.vesinhmoitruong.business.CongTrinhBussiness;
import vn.dtt.sol.ns.vesinhmoitruong.business.ThongTinKiemDemCongTrinhBusiness;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemCongTrinh;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhCongTrinh;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class KQXetNghiemNcExport {
	private static Log _log = LogFactoryUtil.getLog(KQXetNghiemNcExport.class);
	
	public static KQXetNghiemNc getModel(String namBaoCao, String maTinh){
		_log.info("==START PHIEU KET QUA XET NGHIEM NC=KQXetNghiemNcExport===");
		String LOAICONGTRINHTRUONGHOC = "1";//1 la truong hoc
		String LOAICONGTRINHTRAMYTE = "2";//1 la tram y te
		String TRANGTHAI = "2"; // 2 la kiem dem dat hvs
		String DAKETTHUCDIEUTRA = "1"; // 1 la da hoan thanh dieu tra
		String DANHGIAKIEMDEM = "1"; // 1 la cong trinh hop ve sinh
		
		
		KQXetNghiemNc result = new KQXetNghiemNc();
		
		//
		KQXetNghiemNcTruongHoc kqXetNghiemNcTruongHoc = null;
		List<KQXetNghiemNcTruongHoc> lstKqXetNghiemNcTruongHoc = null;
		
		KQXetNghiemNcTruongHocDanhSach kqXetNghiemNcTruongHocDanhSach = null;
		List<KQXetNghiemNcTruongHocDanhSach> lstKqXetNghiemNcTruongHocDanhSach = null;
		
		//
		KQXetNghiemNcTramYTe kqXetNghiemNcTramYTe = null;
		List<KQXetNghiemNcTramYTe> lstKqXetNghiemNcTramYTe = null;
		
		KQXetNghiemNcTramYTeDanhSach kqXetNghiemNcTramYTeDanhSach = null;
		List<KQXetNghiemNcTramYTeDanhSach> lstKqXetNghiemNcTramYTeDanhSach = null;
		
		String namValue = "";
		namValue = Validator.isNotNull(namBaoCao) ? namBaoCao : "";		
		if( Validator.isNotNull(maTinh)){
			
			
			String tenTinhValue = "";
			
			tenTinhValue = NuocSachUtils.getNameTinh(maTinh);
			
			// start ve sinh cong trinh truong hoc
			lstKqXetNghiemNcTruongHoc = new ArrayList<KQXetNghiemNcTruongHoc>();
			List<VeSinhCongTrinh> lstveSinhCongTrinhTruongHoc = CongTrinhBussiness.getVeSinhCongTrinhJoinThongTinKiemDemCT(maTinh, null, null, null, LOAICONGTRINHTRUONGHOC, null, namBaoCao, DAKETTHUCDIEUTRA, null);
			
			
			kqXetNghiemNcTruongHoc = new KQXetNghiemNcTruongHoc();
			
			if(Validator.isNotNull(lstveSinhCongTrinhTruongHoc) && lstveSinhCongTrinhTruongHoc.size() > 0){
				lstKqXetNghiemNcTruongHocDanhSach = new ArrayList<KQXetNghiemNcTruongHocDanhSach>();
				for (VeSinhCongTrinh veSinhCongTrinhTruongHoc : lstveSinhCongTrinhTruongHoc) {
					kqXetNghiemNcTruongHocDanhSach = new KQXetNghiemNcTruongHocDanhSach();
					
					String huyenXaValue = "";
					String tenTruongValue = "";
					String soPhieuXetNghiemValue = "";
					int datHayKoValue = 0;
					
					String huyenTemp = Validator.isNotNull(	veSinhCongTrinhTruongHoc.getMaHuyen()) ? NuocSachUtils.getNameHuyen(null, veSinhCongTrinhTruongHoc.getMaHuyen()) : "";
					String xaTemp = Validator.isNotNull(veSinhCongTrinhTruongHoc.getMaXa()) ? "-"+NuocSachUtils.getNameXa( veSinhCongTrinhTruongHoc.getMaXa()) : "";
					huyenXaValue = huyenTemp+xaTemp;
					tenTruongValue = Validator.isNotNull(	veSinhCongTrinhTruongHoc.getTenCongTrinh()) ? veSinhCongTrinhTruongHoc.getTenCongTrinh() : "";
					ThongTinKiemDemCongTrinh thongTinKiemDemCongTrinhTruongHoc = ThongTinKiemDemCongTrinhBusiness.getThongTinKiemDemCongTrinhByVeSinhCTID(String.valueOf(veSinhCongTrinhTruongHoc.getId()));
					soPhieuXetNghiemValue = Validator.isNotNull(thongTinKiemDemCongTrinhTruongHoc) ? thongTinKiemDemCongTrinhTruongHoc.getSophieuxetnghiem() : "";
					datHayKoValue = Validator.isNotNull(veSinhCongTrinhTruongHoc.getTrangThai()) ? veSinhCongTrinhTruongHoc.getTrangThai() : 0;
					
					kqXetNghiemNcTruongHocDanhSach.setHuyenXa(huyenXaValue);
					kqXetNghiemNcTruongHocDanhSach.setTenTruong(tenTruongValue);
					kqXetNghiemNcTruongHocDanhSach.setSoPhieuXetNghiem(soPhieuXetNghiemValue);
					kqXetNghiemNcTruongHocDanhSach.setDatHayKo(datHayKoValue);
					
					lstKqXetNghiemNcTruongHocDanhSach.add(kqXetNghiemNcTruongHocDanhSach);
				}
			}
			
			kqXetNghiemNcTruongHoc.setTenTinh(tenTinhValue);
			kqXetNghiemNcTruongHoc.setLstKqXetNghiemNcTruongHocDanhSach(lstKqXetNghiemNcTruongHocDanhSach);
			
			lstKqXetNghiemNcTruongHoc.add(kqXetNghiemNcTruongHoc);
			
			// end ve sinh cong trinh truong hoc
			
			
			// start ve sinh cong trinh tram y te
			lstKqXetNghiemNcTramYTe = new ArrayList<KQXetNghiemNcTramYTe>();
			List<VeSinhCongTrinh> lstveSinhCongTrinhTramYTe = CongTrinhBussiness.getVeSinhCongTrinhJoinThongTinKiemDemCT(maTinh, null, null, null, LOAICONGTRINHTRAMYTE, null, namBaoCao, DAKETTHUCDIEUTRA, null);
						
			
			kqXetNghiemNcTramYTe = new KQXetNghiemNcTramYTe();
			
			if(Validator.isNotNull(lstveSinhCongTrinhTramYTe) && lstveSinhCongTrinhTramYTe.size() > 0){
				lstKqXetNghiemNcTramYTeDanhSach = new ArrayList<KQXetNghiemNcTramYTeDanhSach>();
				for (VeSinhCongTrinh veSinhCongTrinhTramYTe : lstveSinhCongTrinhTramYTe) {
					kqXetNghiemNcTramYTeDanhSach = new KQXetNghiemNcTramYTeDanhSach();
					
					String huyenValue ="";
					String tenTramYTeValue = "";
					String soPhieuXetNghiemValue = "";
					int datHayKoValue = 0;
					
					huyenValue = Validator.isNotNull(	veSinhCongTrinhTramYTe.getMaHuyen()) ? NuocSachUtils.getNameHuyen(null, veSinhCongTrinhTramYTe.getMaHuyen()) : "";
					tenTramYTeValue = Validator.isNotNull(	veSinhCongTrinhTramYTe.getTenCongTrinh()) ? veSinhCongTrinhTramYTe.getTenCongTrinh() : "";
					ThongTinKiemDemCongTrinh thongTinKiemDemCongTrinhTramYTe = ThongTinKiemDemCongTrinhBusiness.getThongTinKiemDemCongTrinhByVeSinhCTID(String.valueOf(veSinhCongTrinhTramYTe.getId()));
					soPhieuXetNghiemValue = Validator.isNotNull(thongTinKiemDemCongTrinhTramYTe) ? thongTinKiemDemCongTrinhTramYTe.getSophieuxetnghiem() : "";
					datHayKoValue = Validator.isNotNull(veSinhCongTrinhTramYTe.getTrangThai()) ? veSinhCongTrinhTramYTe.getTrangThai() : 0;
					
					kqXetNghiemNcTramYTeDanhSach.setHuyen(huyenValue);
					kqXetNghiemNcTramYTeDanhSach.setTenTramYTe(tenTramYTeValue);
					kqXetNghiemNcTramYTeDanhSach.setSoPhieuXetNghiem(soPhieuXetNghiemValue);
					kqXetNghiemNcTramYTeDanhSach.setDatHayKo(datHayKoValue);
					
					lstKqXetNghiemNcTramYTeDanhSach.add(kqXetNghiemNcTramYTeDanhSach);
				}
			}
			
			kqXetNghiemNcTramYTe.setTenTinh(tenTinhValue);
			kqXetNghiemNcTramYTe.setLstKqXetNghiemNcTramYTeDanhSach(lstKqXetNghiemNcTramYTeDanhSach);
			
			lstKqXetNghiemNcTramYTe.add(kqXetNghiemNcTramYTe);
			
			// end ve sinh cong trinh tram y te
		}
		
		result.setNam(namValue);
		result.setLstKqXetNghiemNcTruongHoc(lstKqXetNghiemNcTruongHoc);
		result.setLstKqXetNghiemNcTramYTe(lstKqXetNghiemNcTramYTe);
		_log.info("==END PHIEU KET QUA XET NGHIEM NC=KQXetNghiemNcExport===");
		return result;
		
	}
}
