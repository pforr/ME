package vn.dtt.sol.ns.reporting.model.baocaothongke.vstx;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.business.KeHoachVeSinhBusiness;
import vn.dtt.sol.ns.business.MAUKIEMDEMBusiness;
import vn.dtt.sol.ns.kehoachvesinh.dao.model.KeHoachVeSinh;
import vn.dtt.sol.ns.maungaunhien.dao.model.MAUKIEMDEM;
import vn.dtt.sol.ns.reporting.model.baocaothongke.vstx.ThongKeVSTX.ThongKeVSTXDanhSach;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.vesinhmoitruong.business.ThongTinKiemDemHoGDBusiness;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class ThongKeVSTXExport {
	private static Log log = LogFactoryUtil.getLog(ThongKeVSTXExport.class);
	public static ThongKeVSTX getModel(String nam, String maTinh){
		log.info("==START ThongKeVSTXExport Tinh=ThongKeVSTXExport===");
		String DANGKYVSTX = "1"; // 1 la co dang ky ve sinh toan xa
		
		ThongKeVSTX result = new ThongKeVSTX();
		
		ThongKeVSTXDanhSach thongKeVSTXDanhSach = null;
		List<ThongKeVSTXDanhSach> lstThongKeVSTXDanhSach = null;
		
		String tenTinhValue = "";
		String namValue = "";
		
		namValue = nam;		
		tenTinhValue = NuocSachUtils.getNameTinh(maTinh);
		
		List<KeHoachVeSinh> lstKeHoachVeSinh = KeHoachVeSinhBusiness.getKeHoachVeSinhByNamTinhDangKyVSTX(nam, maTinh, DANGKYVSTX);
		lstThongKeVSTXDanhSach = new ArrayList<ThongKeVSTXDanhSach>();
		if(Validator.isNotNull(lstKeHoachVeSinh) && lstKeHoachVeSinh.size() > 0){
			log.info("--lstKeHoachVeSinh--"+lstKeHoachVeSinh.size()+"==");
			
			for (KeHoachVeSinh keHoachVeSinh : lstKeHoachVeSinh) {
				MAUKIEMDEM maukiemdem = MAUKIEMDEMBusiness.getMauVSTXBaoCaoThongKeVSTX(nam, keHoachVeSinh.getMaTinh(), keHoachVeSinh.getMaHuyen(), keHoachVeSinh.getMaXa());
				if(Validator.isNotNull(maukiemdem)){
					thongKeVSTXDanhSach = result.new ThongKeVSTXDanhSach();
					
					String huyenValue = "";
					String xaValue = "";
					int soMauValue = 0;
					int soDuPhongValue = 0;
					int soHoTrongKeHoachValue = 0;
					int soHVSValue = 0;
					int soKoHVSValue = 0;
					int soKoNhaTieuValue = 0;
					int soTongDaKetThucDieuTraValue = 0;
					int soChuaKiemDemValue = 0;
					int soDangKiemDemValue = 0;
					int soTongDangDieuTraValue = 0;
					int soConThieuVoiMauValue = 0;
					
					huyenValue = Validator.isNotNull(maukiemdem.getMaHuyen()) ? NuocSachUtils.getNameHuyen(null, maukiemdem.getMaHuyen()) : "";
					xaValue = Validator.isNotNull(maukiemdem.getMaXa()) ? NuocSachUtils.getNameXa( maukiemdem.getMaXa()) : "";
					
					soMauValue = Validator.isNotNull(maukiemdem.getSoMauNgauNhien()) ? maukiemdem.getSoMauNgauNhien() : 0;
					soDuPhongValue = Validator.isNotNull(maukiemdem.getSoMauDuPhong()) ? maukiemdem.getSoMauDuPhong() : 0;
					
					soHoTrongKeHoachValue = ThongTinKiemDemHoGDBusiness.countHoGDThongKeVSTX(null, maTinh, null, maukiemdem.getMaXa(), nam, 1, 0, 0, 0, 0, 0);
					soHVSValue = ThongTinKiemDemHoGDBusiness.countHoGDThongKeVSTX(null, maTinh, null, maukiemdem.getMaXa(), nam, 0, 1, 0, 0, 0, 0);
					soKoHVSValue = ThongTinKiemDemHoGDBusiness.countHoGDThongKeVSTX(null, maTinh, null, maukiemdem.getMaXa(), nam, 0, 0, 1, 0, 0, 0);
					soKoNhaTieuValue = ThongTinKiemDemHoGDBusiness.countHoGDThongKeVSTX(null, maTinh, null, maukiemdem.getMaXa(), nam, 0, 0, 0, 1, 0, 0);
					soTongDaKetThucDieuTraValue = soHVSValue + soKoHVSValue + soKoNhaTieuValue;
					
					soChuaKiemDemValue = ThongTinKiemDemHoGDBusiness.countHoGDThongKeVSTX(null, maTinh, null, maukiemdem.getMaXa(), nam, 0, 0, 0, 0, 1, 0);
					soDangKiemDemValue = ThongTinKiemDemHoGDBusiness.countHoGDThongKeVSTX(null, maTinh, null, maukiemdem.getMaXa(), nam, 0, 0, 0, 0, 0, 1);
					soTongDangDieuTraValue = soChuaKiemDemValue + soDangKiemDemValue;
					
					soConThieuVoiMauValue = soMauValue - soTongDaKetThucDieuTraValue; 
					if(!(soConThieuVoiMauValue > 0)){
						soConThieuVoiMauValue = 0;
					}
	
					thongKeVSTXDanhSach.setHuyen(huyenValue);
					thongKeVSTXDanhSach.setXa(xaValue);
					thongKeVSTXDanhSach.setSoMau(soMauValue);
					thongKeVSTXDanhSach.setSoDuPhong(soDuPhongValue);
					thongKeVSTXDanhSach.setSoHoTrongKeHoach(soHoTrongKeHoachValue);
					thongKeVSTXDanhSach.setSoHVS(soHVSValue);
					thongKeVSTXDanhSach.setSoKoHVS(soKoHVSValue);
					thongKeVSTXDanhSach.setSoKoNhaTieu(soKoNhaTieuValue);
					thongKeVSTXDanhSach.setSoTongDaKetThucDieuTra(soTongDaKetThucDieuTraValue);
					thongKeVSTXDanhSach.setSoChuaKiemDem(soChuaKiemDemValue);
					thongKeVSTXDanhSach.setSoDangKiemDem(soDangKiemDemValue);
					thongKeVSTXDanhSach.setSoTongDangDieuTra(soTongDangDieuTraValue);
					thongKeVSTXDanhSach.setSoConThieuVoiMau(soConThieuVoiMauValue);
					lstThongKeVSTXDanhSach.add(thongKeVSTXDanhSach);
				}
			}
		}
		
		result.setNam(namValue);
		result.setTenTinh(tenTinhValue);
		result.setLstThongKeVSTXDanhSach(lstThongKeVSTXDanhSach);
		log.info("==END ThongKeVSTXExport Tinh=ThongKeVSTXExport===");
		return result;
	}
}
