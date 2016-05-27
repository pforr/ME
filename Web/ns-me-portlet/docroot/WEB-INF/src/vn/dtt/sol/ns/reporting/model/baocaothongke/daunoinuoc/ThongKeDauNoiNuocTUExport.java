package vn.dtt.sol.ns.reporting.model.baocaothongke.daunoinuoc;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.reporting.model.baocaothongke.daunoinuoc.ThongKeDauNoiNuocTU.ThongKeDauNoiNuocTUDanhSach;
import vn.dtt.sol.ns.tramcap.business.DauNoiNuocBusiness;
import vn.dtt.sol.ns.tramcap.business.TramCapBusiness;
import vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.util.format.ConvertUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class ThongKeDauNoiNuocTUExport {
	private static Log log = LogFactoryUtil.getLog(ThongKeDauNoiNuocTUExport.class);
	public static ThongKeDauNoiNuocTU getModel(String nam){
		log.info("==START=ThongKeDauNoiNuocTUExport===");
		ThongKeDauNoiNuocTU result =  new ThongKeDauNoiNuocTU();
		
		ThongKeDauNoiNuocTUDanhSach thongKeDauNoiNuocTUDanhSach = null;
		List<ThongKeDauNoiNuocTUDanhSach> lstThongKeDauNoiNuocTUDanhSach = null;
		
		String namValue = "";
		
		namValue = nam;	
		
		
		List<TramCapNuoc> lstTramCapNuoc = TramCapBusiness.getTramCapJoinKeHoachNuocBaoCaoThongKeDNN(nam, null, null, null, null);
		lstThongKeDauNoiNuocTUDanhSach = new ArrayList<ThongKeDauNoiNuocTUDanhSach>();
		if(Validator.isNotNull(lstTramCapNuoc) && lstTramCapNuoc.size() > 0){
			log.info("--lstTramCapNuoc--"+lstTramCapNuoc.size()+"==");
			for (TramCapNuoc tramCapNuoc : lstTramCapNuoc) {
				thongKeDauNoiNuocTUDanhSach = result.new ThongKeDauNoiNuocTUDanhSach();
				
				String tenTinhValue = "";
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
				
				tenTinhValue = NuocSachUtils.getNameTinh(tramCapNuoc.getMaTinh());
				tramCapValue =  Validator.isNotNull(tramCapNuoc.getTenTram()) ? tramCapNuoc.getTenTram() : "";
				huyenValue = Validator.isNotNull(tramCapNuoc.getMaHuyen()) ? NuocSachUtils.getNameHuyen(null, tramCapNuoc.getMaHuyen()) : "";
				xaValue = Validator.isNotNull(tramCapNuoc.getMaXa()) ? NuocSachUtils.getNameXa( tramCapNuoc.getMaXa()) : "";
				soDauNoiTrongKeHoachValue = DauNoiNuocBusiness.countDNNBaoCaoThongKeDNN(nam, tramCapNuoc.getMaTinh(), null, null, ConvertUtil.parseLongToString(tramCapNuoc.getId()), null, 1, 0, 0, 0, 0);
				soDauNoiDatValue = DauNoiNuocBusiness.countDNNBaoCaoThongKeDNN(nam, tramCapNuoc.getMaTinh(), null, null, ConvertUtil.parseLongToString(tramCapNuoc.getId()), null, 0, 1, 0, 0, 0);
				soDauNoiKoDatValue = DauNoiNuocBusiness.countDNNBaoCaoThongKeDNN(nam, tramCapNuoc.getMaTinh(), null, null, ConvertUtil.parseLongToString(tramCapNuoc.getId()), null, 0, 0, 1, 0, 0);
				
				soTongDaKetThucDieuTraValue = soDauNoiDatValue + soDauNoiKoDatValue ;
				
				soChuaKiemDemValue = DauNoiNuocBusiness.countDNNBaoCaoThongKeDNN(nam, tramCapNuoc.getMaTinh(), null, null, ConvertUtil.parseLongToString(tramCapNuoc.getId()), null, 0, 0, 0, 1, 0);
				soDangKiemDemValue = DauNoiNuocBusiness.countDNNBaoCaoThongKeDNN(nam, tramCapNuoc.getMaTinh(), null, null, ConvertUtil.parseLongToString(tramCapNuoc.getId()), null, 0, 0, 0, 0, 1);
				soTongDangDieuTraValue = soChuaKiemDemValue + soDangKiemDemValue;
				
				thongKeDauNoiNuocTUDanhSach.setTenTinh(tenTinhValue);
				thongKeDauNoiNuocTUDanhSach.setTramCap(tramCapValue);
				thongKeDauNoiNuocTUDanhSach.setHuyen(huyenValue);
				thongKeDauNoiNuocTUDanhSach.setXa(xaValue);
				thongKeDauNoiNuocTUDanhSach.setSoDauNoiTrongKeHoach(soDauNoiTrongKeHoachValue);
				thongKeDauNoiNuocTUDanhSach.setSoDauNoiDat(soDauNoiDatValue);
				thongKeDauNoiNuocTUDanhSach.setSoDauNoiKoDat(soDauNoiKoDatValue);
				thongKeDauNoiNuocTUDanhSach.setSoTongDaKetThucDieuTra(soTongDaKetThucDieuTraValue);
				thongKeDauNoiNuocTUDanhSach.setSoChuaKiemDem(soChuaKiemDemValue);
				thongKeDauNoiNuocTUDanhSach.setSoDangKiemDem(soDangKiemDemValue);
				thongKeDauNoiNuocTUDanhSach.setSoTongDangDieuTra(soTongDangDieuTraValue);
				lstThongKeDauNoiNuocTUDanhSach.add(thongKeDauNoiNuocTUDanhSach);
			}
		}
		
		result.setNam(namValue);
		result.setLstThongKeDauNoiNuocTUDanhSach(lstThongKeDauNoiNuocTUDanhSach);
		log.info("==END=ThongKeDauNoiNuocTUExport===");
		return result;
	}
}
