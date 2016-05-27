package vn.dtt.sol.ns.reporting.model.baocaothongke.vstx;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.business.KeHoachVeSinhBusiness;
import vn.dtt.sol.ns.business.MAUKIEMDEMBusiness;
import vn.dtt.sol.ns.kehoachvesinh.dao.model.KeHoachVeSinh;
import vn.dtt.sol.ns.maungaunhien.dao.model.MAUKIEMDEM;
import vn.dtt.sol.ns.reporting.model.baocaothongke.vstx.ThongKeVSTXTU.ThongKeVSTXTUDanhSach;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.vesinhmoitruong.business.ThongTinKiemDemHoGDBusiness;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class ThongKeVSTXTUExport {
	private static Log log = LogFactoryUtil.getLog(ThongKeVSTXTUExport.class);
	public static ThongKeVSTXTU getModel(String nam){
		log.info("==START=ThongKeVSTXExport===");
		ThongKeVSTXTU result = new ThongKeVSTXTU();
		String DANGKYVSTX = "1"; // 1 la co dang ky ve sinh toan xa
		
		ThongKeVSTXTUDanhSach thongKeVSTXTUDanhSach = null;
		List<ThongKeVSTXTUDanhSach> lstThongKeVSTXTUDanhSach = null;
		
		String namValue = "";
		
		namValue = nam;		
		
		List<KeHoachVeSinh> lstKeHoachVeSinh = KeHoachVeSinhBusiness.getKeHoachVeSinhByNamTinhDangKyVSTX(nam, null, DANGKYVSTX);
		
		lstThongKeVSTXTUDanhSach = new ArrayList<ThongKeVSTXTUDanhSach>();
		if(Validator.isNotNull(lstKeHoachVeSinh) && lstKeHoachVeSinh.size() > 0){
			log.info("--lstKeHoachVeSinh--"+lstKeHoachVeSinh.size()+"==");
			for (KeHoachVeSinh keHoachVeSinh : lstKeHoachVeSinh) {
				MAUKIEMDEM maukiemdem = MAUKIEMDEMBusiness.getMauVSTXBaoCaoThongKeVSTX(nam, keHoachVeSinh.getMaTinh(), keHoachVeSinh.getMaHuyen(), keHoachVeSinh.getMaXa());
				if(Validator.isNotNull(maukiemdem)){
					thongKeVSTXTUDanhSach = result.new ThongKeVSTXTUDanhSach();
					
					String tenTinhValue = "";
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
					
					tenTinhValue = NuocSachUtils.getNameTinh(maukiemdem.getMaTinh());
					huyenValue = Validator.isNotNull(maukiemdem.getMaHuyen()) ? NuocSachUtils.getNameHuyen(null, maukiemdem.getMaHuyen()) : "";
					xaValue = Validator.isNotNull(maukiemdem.getMaXa()) ? NuocSachUtils.getNameXa( maukiemdem.getMaXa()) : "";
					
					soMauValue = Validator.isNotNull(maukiemdem.getSoMauNgauNhien()) ? maukiemdem.getSoMauNgauNhien() : 0;
					soDuPhongValue = Validator.isNotNull(maukiemdem.getSoMauDuPhong()) ? maukiemdem.getSoMauDuPhong() : 0;
					
					soHoTrongKeHoachValue = ThongTinKiemDemHoGDBusiness.countHoGDThongKeVSTX(null, maukiemdem.getMaTinh(), null, maukiemdem.getMaXa(), nam, 1, 0, 0, 0, 0, 0);
					soHVSValue = ThongTinKiemDemHoGDBusiness.countHoGDThongKeVSTX(null, maukiemdem.getMaTinh(), null, maukiemdem.getMaXa(), nam, 0, 1, 0, 0, 0, 0);
					soKoHVSValue = ThongTinKiemDemHoGDBusiness.countHoGDThongKeVSTX(null, maukiemdem.getMaTinh(), null, maukiemdem.getMaXa(), nam, 0, 0, 1, 0, 0, 0);
					soKoNhaTieuValue = ThongTinKiemDemHoGDBusiness.countHoGDThongKeVSTX(null, maukiemdem.getMaTinh(), null, maukiemdem.getMaXa(), nam, 0, 0, 0, 1, 0, 0);
					soTongDaKetThucDieuTraValue = soHVSValue + soKoHVSValue + soKoNhaTieuValue;
					
					soChuaKiemDemValue = ThongTinKiemDemHoGDBusiness.countHoGDThongKeVSTX(null, maukiemdem.getMaTinh(), null, maukiemdem.getMaXa(), nam, 0, 0, 0, 0, 1, 0);
					soDangKiemDemValue = ThongTinKiemDemHoGDBusiness.countHoGDThongKeVSTX(null, maukiemdem.getMaTinh(), null, maukiemdem.getMaXa(), nam, 0, 0, 0, 0, 0, 1);
					soTongDangDieuTraValue = soChuaKiemDemValue + soDangKiemDemValue;
					
					soConThieuVoiMauValue = soMauValue - soTongDaKetThucDieuTraValue; 
					if(!(soConThieuVoiMauValue > 0)){
						soConThieuVoiMauValue = 0;
					}
					
					thongKeVSTXTUDanhSach.setTenTinh(tenTinhValue);
					thongKeVSTXTUDanhSach.setHuyen(huyenValue);
					thongKeVSTXTUDanhSach.setXa(xaValue);
					thongKeVSTXTUDanhSach.setSoMau(soMauValue);
					thongKeVSTXTUDanhSach.setSoDuPhong(soDuPhongValue);
					thongKeVSTXTUDanhSach.setSoHoTrongKeHoach(soHoTrongKeHoachValue);
					thongKeVSTXTUDanhSach.setSoHVS(soHVSValue);
					thongKeVSTXTUDanhSach.setSoKoHVS(soKoHVSValue);
					thongKeVSTXTUDanhSach.setSoKoNhaTieu(soKoNhaTieuValue);
					thongKeVSTXTUDanhSach.setSoTongDaKetThucDieuTra(soTongDaKetThucDieuTraValue);
					thongKeVSTXTUDanhSach.setSoChuaKiemDem(soChuaKiemDemValue);
					thongKeVSTXTUDanhSach.setSoDangKiemDem(soDangKiemDemValue);
					thongKeVSTXTUDanhSach.setSoTongDangDieuTra(soTongDangDieuTraValue);
					thongKeVSTXTUDanhSach.setSoConThieuVoiMau(soConThieuVoiMauValue);
					lstThongKeVSTXTUDanhSach.add(thongKeVSTXTUDanhSach);
				}
			}
		}
		result.setNam(namValue);
		result.setLstThongKeVSTXTUDanhSach(lstThongKeVSTXTUDanhSach);
		log.info("==END=ThongKeVSTXTUExport===");
		return result;
	}
}
