package vn.dtt.sol.ns.reporting.model.baocaothongke.vsxm;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.reporting.model.baocaothongke.vsxm.ThongKeVSXM.ThongKeVSXMDanhSach;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.vesinhmoitruong.business.ThongTinKiemDemHoGDBusiness;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemHoGD;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class ThongKeVSXMExport {
	private static Log log = LogFactoryUtil.getLog(ThongKeVSXMExport.class);
	public static ThongKeVSXM getModel(String nam, String maTinh){
		log.info("==START ThongKeVSXMExport Tinh=ThongKeVSXMExport===");
		ThongKeVSXM result = new ThongKeVSXM();
		
		ThongKeVSXMDanhSach thongKeVSXMDanhSach = null;
		List<ThongKeVSXMDanhSach> lstThongKeVSXMDanhSach = null;
		
		String tenTinhValue = "";
		String namValue = "";
		
		namValue = nam;		
		tenTinhValue = NuocSachUtils.getNameTinh(maTinh);
		
		List<ThongTinKiemDemHoGD> lstThongTinKiemDemHoGD = ThongTinKiemDemHoGDBusiness.getListGroupByBaoCaoThongKeVSXM(nam, maTinh, null, null);
		lstThongKeVSXMDanhSach = new ArrayList<ThongKeVSXMDanhSach>();
		if(Validator.isNotNull(lstThongTinKiemDemHoGD) && lstThongTinKiemDemHoGD.size() > 0){
			log.info("--lstThongTinKiemDemHoGD--"+lstThongTinKiemDemHoGD.size()+"==");
			for (ThongTinKiemDemHoGD thongTinKiemDemHoGD : lstThongTinKiemDemHoGD) {
				thongKeVSXMDanhSach = result.new ThongKeVSXMDanhSach();
				
				String huyenValue = "";
				String xaValue = "";
				int soHoTrongKeHoachValue = 0;
				int soHVSXMValue = 0;
				int soHVSValue = 0;
				int soKoHVSValue = 0;
				int soKoNhaTieuValue = 0;
				int soTongDaKetThucDieuTraValue = 0;
				int soChuaKiemDemValue = 0;
				int soDangKiemDemValue = 0;
				int soTongDangDieuTraValue = 0;
				
				huyenValue = Validator.isNotNull(thongTinKiemDemHoGD.getMaHuyen()) ? NuocSachUtils.getNameHuyen(null, thongTinKiemDemHoGD.getMaHuyen()) : "";
				xaValue = Validator.isNotNull(thongTinKiemDemHoGD.getMaXa()) ? NuocSachUtils.getNameXa( thongTinKiemDemHoGD.getMaXa()) : "";
				
				soHoTrongKeHoachValue = ThongTinKiemDemHoGDBusiness.countHoGDBaoCaoThongKeVSXM(nam, maTinh, null, thongTinKiemDemHoGD.getMaXa(), 1, 0, 0, 0, 0, 0, 0);
				soHVSXMValue = ThongTinKiemDemHoGDBusiness.countHoGDBaoCaoThongKeVSXM(nam, maTinh,  null, thongTinKiemDemHoGD.getMaXa(), 0, 1, 0, 0, 0, 0, 0);
				soHVSValue = ThongTinKiemDemHoGDBusiness.countHoGDBaoCaoThongKeVSXM(nam, maTinh,  null, thongTinKiemDemHoGD.getMaXa(), 0, 0, 1, 0, 0, 0, 0);
				soKoHVSValue = ThongTinKiemDemHoGDBusiness.countHoGDBaoCaoThongKeVSXM(nam, maTinh,  null, thongTinKiemDemHoGD.getMaXa(), 0, 0, 0, 1, 0, 0, 0);
				soKoNhaTieuValue = ThongTinKiemDemHoGDBusiness.countHoGDBaoCaoThongKeVSXM(nam, maTinh,  null, thongTinKiemDemHoGD.getMaXa(), 0, 0, 0, 0, 1, 0, 0);
				soTongDaKetThucDieuTraValue = soHVSXMValue + soHVSValue + soKoHVSValue + soKoNhaTieuValue;
				soChuaKiemDemValue = ThongTinKiemDemHoGDBusiness.countHoGDBaoCaoThongKeVSXM(nam, maTinh,  null, thongTinKiemDemHoGD.getMaXa(), 0, 0, 0, 0, 0, 1, 0);
				soDangKiemDemValue = ThongTinKiemDemHoGDBusiness.countHoGDBaoCaoThongKeVSXM(nam, maTinh,  null, thongTinKiemDemHoGD.getMaXa(), 0, 0, 0, 0, 0, 0, 1);
				soTongDangDieuTraValue = soChuaKiemDemValue + soDangKiemDemValue;
				thongKeVSXMDanhSach.setHuyen(huyenValue);
				thongKeVSXMDanhSach.setXa(xaValue);
				thongKeVSXMDanhSach.setSoHoTrongKeHoach(soHoTrongKeHoachValue);
				thongKeVSXMDanhSach.setSoHVSXM(soHVSXMValue);
				thongKeVSXMDanhSach.setSoHVS(soHVSValue);
				thongKeVSXMDanhSach.setSoKoHVS(soKoHVSValue);
				thongKeVSXMDanhSach.setSoKoNhaTieu(soKoNhaTieuValue);
				thongKeVSXMDanhSach.setSoTongDaKetThucDieuTra(soTongDaKetThucDieuTraValue);
				thongKeVSXMDanhSach.setSoChuaKiemDem(soChuaKiemDemValue);
				thongKeVSXMDanhSach.setSoDangKiemDem(soDangKiemDemValue);
				thongKeVSXMDanhSach.setSoTongDangDieuTra(soTongDangDieuTraValue);
				
				lstThongKeVSXMDanhSach.add(thongKeVSXMDanhSach);
			}
		}
		
		result.setTenTinh(tenTinhValue);
		result.setNam(namValue);
		result.setLstThongKeVSXMDanhSach(lstThongKeVSXMDanhSach);
		log.info("==END ThongKeVSXMExport Tinh=ThongKeVSXMExport===");
		return result;
	}
}
