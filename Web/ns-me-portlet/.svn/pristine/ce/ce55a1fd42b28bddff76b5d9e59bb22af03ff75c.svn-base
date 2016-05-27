package vn.dtt.sol.ns.reporting.model.baocaothongke.vsxm;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.reporting.model.baocaothongke.vsxm.ThongKeVSXMTU.ThongKeVSXMTUDanhSach;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.vesinhmoitruong.business.ThongTinKiemDemHoGDBusiness;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemHoGD;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class ThongKeVSXMTUExport {
	private static Log log = LogFactoryUtil.getLog(ThongKeVSXMTUExport.class);
	public static ThongKeVSXMTU getModel(String nam){
		log.info("==START=ThongKeVSXMTUExport===");
		ThongKeVSXMTU result = new ThongKeVSXMTU();
		
		ThongKeVSXMTUDanhSach thongKeVSXMTUDanhSach = null;
		List<ThongKeVSXMTUDanhSach> lstThongKeVSXMTUDanhSach = null;
		
		String namValue = "";
		
		namValue = nam;	
		
		
		List<ThongTinKiemDemHoGD> lstThongTinKiemDemHoGD = ThongTinKiemDemHoGDBusiness.getListGroupByBaoCaoThongKeVSXM(nam, null, null, null);
		lstThongKeVSXMTUDanhSach = new ArrayList<ThongKeVSXMTUDanhSach>();
		if(Validator.isNotNull(lstThongTinKiemDemHoGD) && lstThongTinKiemDemHoGD.size() > 0){
			log.info("--lstThongTinKiemDemHoGD--"+lstThongTinKiemDemHoGD.size()+"==");
			for (ThongTinKiemDemHoGD thongTinKiemDemHoGD : lstThongTinKiemDemHoGD) {
				thongKeVSXMTUDanhSach = result.new ThongKeVSXMTUDanhSach();
				
				String tenTinhValue = "";
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
				
				tenTinhValue = NuocSachUtils.getNameTinh(thongTinKiemDemHoGD.getMaTinh());
				huyenValue = Validator.isNotNull(thongTinKiemDemHoGD.getMaHuyen()) ? NuocSachUtils.getNameHuyen(null, thongTinKiemDemHoGD.getMaHuyen()) : "";
				xaValue = Validator.isNotNull(thongTinKiemDemHoGD.getMaXa()) ? NuocSachUtils.getNameXa( thongTinKiemDemHoGD.getMaXa()) : "";
				soHoTrongKeHoachValue = ThongTinKiemDemHoGDBusiness.countHoGDBaoCaoThongKeVSXM(nam, thongTinKiemDemHoGD.getMaTinh(), null, thongTinKiemDemHoGD.getMaXa(), 1, 0, 0, 0, 0, 0, 0);
				soHVSXMValue = ThongTinKiemDemHoGDBusiness.countHoGDBaoCaoThongKeVSXM(nam, thongTinKiemDemHoGD.getMaTinh(), null, thongTinKiemDemHoGD.getMaXa(), 0, 1, 0, 0, 0, 0, 0);
				soHVSValue = ThongTinKiemDemHoGDBusiness.countHoGDBaoCaoThongKeVSXM(nam, thongTinKiemDemHoGD.getMaTinh(), null, thongTinKiemDemHoGD.getMaXa(), 0, 0, 1, 0, 0, 0, 0);
				soKoHVSValue = ThongTinKiemDemHoGDBusiness.countHoGDBaoCaoThongKeVSXM(nam, thongTinKiemDemHoGD.getMaTinh(), null, thongTinKiemDemHoGD.getMaXa(), 0, 0, 0, 1, 0, 0, 0);
				soKoNhaTieuValue = ThongTinKiemDemHoGDBusiness.countHoGDBaoCaoThongKeVSXM(nam, thongTinKiemDemHoGD.getMaTinh(), null, thongTinKiemDemHoGD.getMaXa(), 0, 0, 0, 0, 1, 0, 0);
				soTongDaKetThucDieuTraValue = soHVSXMValue + soHVSValue + soKoHVSValue + soKoNhaTieuValue;
				soChuaKiemDemValue = ThongTinKiemDemHoGDBusiness.countHoGDBaoCaoThongKeVSXM(nam, thongTinKiemDemHoGD.getMaTinh(), null, thongTinKiemDemHoGD.getMaXa(), 0, 0, 0, 0, 0, 1, 0);
				soDangKiemDemValue = ThongTinKiemDemHoGDBusiness.countHoGDBaoCaoThongKeVSXM(nam, thongTinKiemDemHoGD.getMaTinh(), null, thongTinKiemDemHoGD.getMaXa(), 0, 0, 0, 0, 0, 0, 1);
				soTongDangDieuTraValue = soChuaKiemDemValue + soDangKiemDemValue;
				
				
				
				thongKeVSXMTUDanhSach.setTenTinh(tenTinhValue);
				thongKeVSXMTUDanhSach.setHuyen(huyenValue);
				thongKeVSXMTUDanhSach.setXa(xaValue);
				thongKeVSXMTUDanhSach.setSoHoTrongKeHoach(soHoTrongKeHoachValue);
				thongKeVSXMTUDanhSach.setSoHVSXM(soHVSXMValue);
				thongKeVSXMTUDanhSach.setSoHVS(soHVSValue);
				thongKeVSXMTUDanhSach.setSoKoHVS(soKoHVSValue);
				thongKeVSXMTUDanhSach.setSoKoNhaTieu(soKoNhaTieuValue);
				thongKeVSXMTUDanhSach.setSoTongDaKetThucDieuTra(soTongDaKetThucDieuTraValue);
				thongKeVSXMTUDanhSach.setSoChuaKiemDem(soChuaKiemDemValue);
				thongKeVSXMTUDanhSach.setSoDangKiemDem(soDangKiemDemValue);
				thongKeVSXMTUDanhSach.setSoTongDangDieuTra(soTongDangDieuTraValue);
				
				lstThongKeVSXMTUDanhSach.add(thongKeVSXMTUDanhSach);
			}
		}
		
		
			
		
		result.setNam(namValue);
		result.setLstThongKeVSXMTUDanhSach(lstThongKeVSXMTUDanhSach);
		log.info("==END=ThongKeVSXMTUExport===");
		return result;
	}
}
