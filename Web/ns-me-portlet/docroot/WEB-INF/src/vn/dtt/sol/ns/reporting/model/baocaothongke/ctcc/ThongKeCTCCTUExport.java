package vn.dtt.sol.ns.reporting.model.baocaothongke.ctcc;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.reporting.model.baocaothongke.ctcc.ThongKeCTCCTU.ThongKeCTCCTUDanhSach;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.vesinhmoitruong.business.ThongTinKiemDemCongTrinhBusiness;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemCongTrinh;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class ThongKeCTCCTUExport {
	private static Log log = LogFactoryUtil.getLog(ThongKeCTCCTUExport.class);
	public static ThongKeCTCCTU getModel(String nam){
		log.info("==START=ThongKeCTCCTUExport===");
		ThongKeCTCCTU result = new ThongKeCTCCTU();
		
		ThongKeCTCCTUDanhSach thongKeCTCCTUDanhSach = null;
		List<ThongKeCTCCTUDanhSach> lstThongKeCTCCTUDanhSach = null;
		
		String namValue = "";
		
		namValue = nam;	
		
		List<ThongTinKiemDemCongTrinh> lstTinKiemDemCongTrinh = ThongTinKiemDemCongTrinhBusiness.getListGroupByBaoCaoThongKeCTCC(nam, null, null, null);
		lstThongKeCTCCTUDanhSach = new ArrayList<ThongKeCTCCTUDanhSach>();
		if(Validator.isNotNull(lstTinKiemDemCongTrinh) && lstTinKiemDemCongTrinh.size() > 0){
			log.info("--lstTinKiemDemCongTrinh--"+lstTinKiemDemCongTrinh.size()+"==");
			for (ThongTinKiemDemCongTrinh thongTinKiemDemCongTrinh : lstTinKiemDemCongTrinh) {
				thongKeCTCCTUDanhSach = result.new ThongKeCTCCTUDanhSach();
				
				String tenTinhValue = "";
				String huyenValue = "";
				String xaValue = "";
				int soCongTrinhHVSValue = 0;
				int soCongTrinhKoHVSValue = 0;
				int soChuaKiemDemValue = 0;
				int soDangKiemDemValue = 0;
				int soTongValue = 0;
				
				tenTinhValue = NuocSachUtils.getNameTinh(thongTinKiemDemCongTrinh.getMaTinh());
				huyenValue = Validator.isNotNull(thongTinKiemDemCongTrinh.getMaHuyen()) ? NuocSachUtils.getNameHuyen(null, thongTinKiemDemCongTrinh.getMaHuyen()) : "";
				xaValue = Validator.isNotNull(thongTinKiemDemCongTrinh.getMaXa()) ? NuocSachUtils.getNameXa( thongTinKiemDemCongTrinh.getMaXa()) : "";
				
				soCongTrinhHVSValue = ThongTinKiemDemCongTrinhBusiness.countCTCCBaoCaoThongKeCTCC(nam, thongTinKiemDemCongTrinh.getMaTinh(), null, thongTinKiemDemCongTrinh.getMaXa(), 1, 0, 0, 0);
				soCongTrinhKoHVSValue = ThongTinKiemDemCongTrinhBusiness.countCTCCBaoCaoThongKeCTCC(nam, thongTinKiemDemCongTrinh.getMaTinh(), null, thongTinKiemDemCongTrinh.getMaXa(), 0, 1, 0, 0);
				soChuaKiemDemValue = ThongTinKiemDemCongTrinhBusiness.countCTCCBaoCaoThongKeCTCC(nam, thongTinKiemDemCongTrinh.getMaTinh(), null, thongTinKiemDemCongTrinh.getMaXa(), 0, 0, 1, 0);
				soDangKiemDemValue = ThongTinKiemDemCongTrinhBusiness.countCTCCBaoCaoThongKeCTCC(nam, thongTinKiemDemCongTrinh.getMaTinh(), null, thongTinKiemDemCongTrinh.getMaXa(), 0, 0, 0, 1);
				soTongValue = soCongTrinhHVSValue + soCongTrinhKoHVSValue + soChuaKiemDemValue + soDangKiemDemValue;
				
				thongKeCTCCTUDanhSach.setTenTinh(tenTinhValue);
				thongKeCTCCTUDanhSach.setHuyen(huyenValue);
				thongKeCTCCTUDanhSach.setXa(xaValue);
				thongKeCTCCTUDanhSach.setSoCongTrinhHVS(soCongTrinhHVSValue);
				thongKeCTCCTUDanhSach.setSoCongTrinhKoHVS(soCongTrinhKoHVSValue);
				thongKeCTCCTUDanhSach.setSoChuaKiemDem(soChuaKiemDemValue);
				thongKeCTCCTUDanhSach.setSoDangKiemDem(soDangKiemDemValue);
				thongKeCTCCTUDanhSach.setSoTong(soTongValue);
				lstThongKeCTCCTUDanhSach.add(thongKeCTCCTUDanhSach);
			}
		}
		result.setNam(namValue);
		result.setLstThongKeCTCCTUDanhSach(lstThongKeCTCCTUDanhSach);
		log.info("==END=ThongKeCTCCTUExport===");
		return result;
	}
}
