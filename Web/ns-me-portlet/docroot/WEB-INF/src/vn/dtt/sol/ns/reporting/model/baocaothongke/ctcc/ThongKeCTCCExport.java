package vn.dtt.sol.ns.reporting.model.baocaothongke.ctcc;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.reporting.model.baocaothongke.ctcc.ThongKeCTCC.ThongKeCTCCDanhSach;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.vesinhmoitruong.business.ThongTinKiemDemCongTrinhBusiness;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemCongTrinh;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class ThongKeCTCCExport {
	private static Log log = LogFactoryUtil.getLog(ThongKeCTCCExport.class);
	public static ThongKeCTCC getModel(String nam, String maTinh){
		log.info("==START ThongKeCTCCExport Tinh=ThongKeCTCCExport===");
		ThongKeCTCC result = new ThongKeCTCC();
		
		ThongKeCTCCDanhSach thongKeCTCCDanhSach = null;
		List<ThongKeCTCCDanhSach> lstThongKeCTCCDanhSach = null;
		
		String tenTinhValue = "";
		String namValue = "";
		
		namValue = nam;		
		tenTinhValue = NuocSachUtils.getNameTinh(maTinh);
		
		List<ThongTinKiemDemCongTrinh> lstTinKiemDemCongTrinh = ThongTinKiemDemCongTrinhBusiness.getListGroupByBaoCaoThongKeCTCC(nam, maTinh, null, null);
		
		lstThongKeCTCCDanhSach = new ArrayList<ThongKeCTCCDanhSach>();
		if(Validator.isNotNull(lstTinKiemDemCongTrinh) && lstTinKiemDemCongTrinh.size() > 0){
			log.info("--lstTinKiemDemCongTrinh--"+lstTinKiemDemCongTrinh.size()+"==");
			for (ThongTinKiemDemCongTrinh thongTinKiemDemCongTrinh : lstTinKiemDemCongTrinh) {
				thongKeCTCCDanhSach = result.new ThongKeCTCCDanhSach();
				
				String huyenValue = "";
				String xaValue = "";
				int soCongTrinhHVSValue = 0;
				int soCongTrinhKoHVSValue = 0;
				int soChuaKiemDemValue = 0;
				int soDangKiemDemValue = 0;
				int soTongValue = 0;
				
				huyenValue = Validator.isNotNull(thongTinKiemDemCongTrinh.getMaHuyen()) ? NuocSachUtils.getNameHuyen(null, thongTinKiemDemCongTrinh.getMaHuyen()) : "";
				xaValue = Validator.isNotNull(thongTinKiemDemCongTrinh.getMaXa()) ? NuocSachUtils.getNameXa( thongTinKiemDemCongTrinh.getMaXa()) : "";
				soCongTrinhHVSValue = ThongTinKiemDemCongTrinhBusiness.countCTCCBaoCaoThongKeCTCC(nam, maTinh, null, thongTinKiemDemCongTrinh.getMaXa(), 1, 0, 0, 0);
				soCongTrinhKoHVSValue = ThongTinKiemDemCongTrinhBusiness.countCTCCBaoCaoThongKeCTCC(nam, maTinh, null, thongTinKiemDemCongTrinh.getMaXa(), 0, 1, 0, 0);
				soChuaKiemDemValue = ThongTinKiemDemCongTrinhBusiness.countCTCCBaoCaoThongKeCTCC(nam, maTinh, null, thongTinKiemDemCongTrinh.getMaXa(), 0, 0, 1, 0);
				soDangKiemDemValue = ThongTinKiemDemCongTrinhBusiness.countCTCCBaoCaoThongKeCTCC(nam, maTinh, null, thongTinKiemDemCongTrinh.getMaXa(), 0, 0, 0, 1);
				soTongValue = soCongTrinhHVSValue + soCongTrinhKoHVSValue + soChuaKiemDemValue + soDangKiemDemValue;
				
				thongKeCTCCDanhSach.setHuyen(huyenValue);
				thongKeCTCCDanhSach.setXa(xaValue);
				thongKeCTCCDanhSach.setSoCongTrinhHVS(soCongTrinhHVSValue);
				thongKeCTCCDanhSach.setSoCongTrinhKoHVS(soCongTrinhKoHVSValue);
				thongKeCTCCDanhSach.setSoChuaKiemDem(soChuaKiemDemValue);
				thongKeCTCCDanhSach.setSoDangKiemDem(soDangKiemDemValue);
				thongKeCTCCDanhSach.setSoTong(soTongValue);
				lstThongKeCTCCDanhSach.add(thongKeCTCCDanhSach);
			}
		}
		
		
		result.setNam(namValue);
		result.setTenTinh(tenTinhValue);
		result.setLstThongKeCTCCDanhSach(lstThongKeCTCCDanhSach);
		log.info("==END ThongKeCTCCExport Tinh=ThongKeCTCCExport===");
		return result;
	}
}
