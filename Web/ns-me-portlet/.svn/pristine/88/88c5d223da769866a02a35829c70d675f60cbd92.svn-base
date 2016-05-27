package vn.dtt.sol.ns.reporting.model.baocaothongke.daunoinuoc;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.reporting.model.baocaothongke.daunoinuoc.ThongKeDauNoiNuoc.ThongKeDauNoiNuocDanhSach;
import vn.dtt.sol.ns.tramcap.business.DauNoiNuocBusiness;
import vn.dtt.sol.ns.tramcap.business.TramCapBusiness;
import vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.util.format.ConvertUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class ThongKeDauNoiNuocExport {
	private static Log log = LogFactoryUtil.getLog(ThongKeDauNoiNuocExport.class);
	public static ThongKeDauNoiNuoc getModel(String nam, String maTinh){
		log.info("==START ThongKeDauNoiNuocExport Tinh=ThongKeDauNoiNuocExport===");
		ThongKeDauNoiNuoc result = new ThongKeDauNoiNuoc();
		
		ThongKeDauNoiNuocDanhSach thongKeDauNoiNuocDanhSach = null;
		List<ThongKeDauNoiNuocDanhSach> lstThongKeDauNoiNuocDanhSach = null;
		
		String tenTinhValue = "";
		String namValue = "";
		
		namValue = nam;		
		tenTinhValue = NuocSachUtils.getNameTinh(maTinh);
		
		List<TramCapNuoc> lstTramCapNuoc = TramCapBusiness.getTramCapJoinKeHoachNuocBaoCaoThongKeDNN(nam, maTinh, null, null, null);
		lstThongKeDauNoiNuocDanhSach = new ArrayList<ThongKeDauNoiNuocDanhSach>();
		if(Validator.isNotNull(lstTramCapNuoc) && lstTramCapNuoc.size() > 0){
			log.info("--lstTramCapNuoc--"+lstTramCapNuoc.size()+"==");
			for (TramCapNuoc tramCapNuoc : lstTramCapNuoc) {
				thongKeDauNoiNuocDanhSach = result.new ThongKeDauNoiNuocDanhSach();
				
				String tramCapValue = "";
				String huyenValue = "";
				String xaValue = "";
				int soDauNoiTrongKeHoachValue = 0;
				int soDauNoiDatValue = 0;
				int soDauNoiKoDatValue = 0;
				int soTongDaKetThucDieuTraValue = 0;
				int soChuaKiemDemValue = 0;
				int soDangKiemDemValue = 0;
				int soTongDangDieuTraValue = 0;
				
				tramCapValue =  Validator.isNotNull(tramCapNuoc.getTenTram()) ? tramCapNuoc.getTenTram() : "";
				huyenValue = Validator.isNotNull(tramCapNuoc.getMaHuyen()) ? NuocSachUtils.getNameHuyen(null, tramCapNuoc.getMaHuyen()) : "";
				xaValue = Validator.isNotNull(tramCapNuoc.getMaXa()) ? NuocSachUtils.getNameXa( tramCapNuoc.getMaXa()) : "";
				soDauNoiTrongKeHoachValue = DauNoiNuocBusiness.countDNNBaoCaoThongKeDNN(nam, maTinh, null, null, ConvertUtil.parseLongToString(tramCapNuoc.getId()), null, 1, 0, 0, 0, 0);
				soDauNoiDatValue = DauNoiNuocBusiness.countDNNBaoCaoThongKeDNN(nam, maTinh, null, null, ConvertUtil.parseLongToString(tramCapNuoc.getId()), null, 0, 1, 0, 0, 0);
				soDauNoiKoDatValue = DauNoiNuocBusiness.countDNNBaoCaoThongKeDNN(nam, maTinh, null, null, ConvertUtil.parseLongToString(tramCapNuoc.getId()), null, 0, 0, 1, 0, 0);
				
				soTongDaKetThucDieuTraValue = soDauNoiDatValue + soDauNoiKoDatValue ;
				
				soChuaKiemDemValue = DauNoiNuocBusiness.countDNNBaoCaoThongKeDNN(nam, maTinh, null, null, ConvertUtil.parseLongToString(tramCapNuoc.getId()), null, 0, 0, 0, 1, 0);
				soDangKiemDemValue = DauNoiNuocBusiness.countDNNBaoCaoThongKeDNN(nam, maTinh, null, null, ConvertUtil.parseLongToString(tramCapNuoc.getId()), null, 0, 0, 0, 0, 1);
				soTongDangDieuTraValue = soChuaKiemDemValue + soDangKiemDemValue;
				
				thongKeDauNoiNuocDanhSach.setTramCap(tramCapValue);
				thongKeDauNoiNuocDanhSach.setHuyen(huyenValue);
				thongKeDauNoiNuocDanhSach.setXa(xaValue);
				thongKeDauNoiNuocDanhSach.setSoDauNoiTrongKeHoach(soDauNoiTrongKeHoachValue);
				thongKeDauNoiNuocDanhSach.setSoDauNoiDat(soDauNoiDatValue);
				thongKeDauNoiNuocDanhSach.setSoDauNoiKoDat(soDauNoiKoDatValue);
				thongKeDauNoiNuocDanhSach.setSoTongDaKetThucDieuTra(soTongDaKetThucDieuTraValue);
				thongKeDauNoiNuocDanhSach.setSoChuaKiemDem(soChuaKiemDemValue);
				thongKeDauNoiNuocDanhSach.setSoDangKiemDem(soDangKiemDemValue);
				thongKeDauNoiNuocDanhSach.setSoTongDangDieuTra(soTongDangDieuTraValue);
				lstThongKeDauNoiNuocDanhSach.add(thongKeDauNoiNuocDanhSach);
			}
		}
		
		result.setTenTinh(tenTinhValue);
		result.setNam(namValue);
		result.setLstThongKeDauNoiNuocDanhSach(lstThongKeDauNoiNuocDanhSach);
		log.info("==END ThongKeDauNoiNuocExport Tinh=ThongKeDauNoiNuocExport===");
		return result;
	}
}
