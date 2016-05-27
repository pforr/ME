package vn.dtt.sol.ns.reporting.model.dli22pl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import vn.dtt.sol.ns.danhgiavesinh.business.DANHGIAVESINHXABusiness;
import vn.dtt.sol.ns.danhgiavesinh.dao.model.DANHGIAVESINHXA;
import vn.dtt.sol.ns.reporting.utils.ReportFunction;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.util.format.FormatData;
import vn.dtt.sol.ns.vesinhmoitruong.business.VeSinhGiaDinhBusiness;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhGiaDinh;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;


public class BaoCaoVSTX_PL5_4_2_Export {
	
	private static Log log = LogFactoryUtil.getLog(BaoCaoVSTX_PL5_4_2_Export.class);
	
	public static BaoCaoVSTX_PL5_4_2 getModel(String namBaoCao, String maTinh, String soBaoCao, String ngayBaoCao, String nguoiLap, String nguoiDuyet,String donViBaoCao){
		
		log.info("===BaoCaoVSTX_PL5_4_2===");
		log.info("--getModel==namBaoCao=="+namBaoCao+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao+"==maTinh--"+maTinh);
		
		String KETLUANVSTX = "1"; // 1 la co vstx
//		String DAKETTHUCDIEUTRA = "1";
//		String[] DANHGIAKIEMDEM = {"1","2"};
		//String[] TRANGTHAI = {"2","3"}; // 2 nha tieu hvs xay moi, 3 nha tieu hvs, 4 nha tieu khong hvs
//		String[] TRANGTHAI = {"2","3","4"}; // 2 nha tieu hvs xay moi, 3 nha tieu hvs, 4 nha tieu khong hvs	
		
		/**
		 * 0. Không có kết quả, 1. Có nhà tiêu HVS xây mới. 2. Có nhà tiêu HVS xây cũ. 3. Có nhà tiêu không HVS, 4. Không có nhà tiêu
		 * */
		String[] danhGiaKiemDem = {"1","2","3"};
		
		BaoCaoVSTX_PL5_4_2 result = new BaoCaoVSTX_PL5_4_2();
		
		List<BaoCaoVSTX_PL5_4_2.DuLieuDong> lstDuLieuDong = null;
		BaoCaoVSTX_PL5_4_2.DuLieuDong duLieuDong = null;
		
		
		String namValue = "";
		String tenTinhValue = "";
		String baoCaoSoValue = "";
		
		String baoCaoNgayThangNamValue = "";
		String nguoiLapValue = "";
		String nguoiDuyetValue = "";
		String donViBaoCaoValue = "";
		
		namValue = Validator.isNotNull(namBaoCao) ? namBaoCao : "";
		tenTinhValue = NuocSachUtils.getNameTinh(maTinh);
		baoCaoSoValue = Validator.isNotNull(soBaoCao) ? soBaoCao : "";
		
		if (Validator.isNotNull(ngayBaoCao)) {
			Date dateNgayBaoCao = FormatData.parseStringToDateTypeDDMMYYYY(ngayBaoCao.trim());
			baoCaoNgayThangNamValue = ReportFunction.parserDateToString4(dateNgayBaoCao);
		}
		if(Validator.isNotNull(nguoiLap)){
			nguoiLapValue = nguoiLap;
		}
		if(Validator.isNotNull(nguoiDuyet)){
			nguoiDuyetValue = nguoiDuyet;
		}
		donViBaoCaoValue = donViBaoCao;
		
		String xaValue = "";
		String huyenValue = "";
//		String thonValue = "";
		
		String hoNgheoVal = "";
		String nhaHvsVal = "";
		String thVal = "";
		String tdVal = "";
		String hnVal = "";
		String chimVal = "";
		String khacVal = "";
		
		String troCapVal = "";
		String vayVonVal = "";
		String tuXayVal = "";
		
		String namThangHoanThanh = "";
		
		int stt = 0;

		
		lstDuLieuDong = new ArrayList<BaoCaoVSTX_PL5_4_2.DuLieuDong>();
		List<DANHGIAVESINHXA> lstDanhGiaVeSinhXa = DANHGIAVESINHXABusiness.getDanhGiaVeSinhXaBaoCao(maTinh, null, null, namBaoCao, KETLUANVSTX);
		
		int countXa = 0;
		int totalXa = lstDanhGiaVeSinhXa.size();
		
//		List<String> lstDanhGiaThon = new ArrayList<String>();
//		List<VeSinhGiaDinh> lstVeSinhGiaDinh = new ArrayList<VeSinhGiaDinh>();
		
		HashMap<VeSinhGiaDinh,Integer> veSinhGiaDinhThoiGianThuc = new HashMap<VeSinhGiaDinh,Integer>();
		VeSinhGiaDinh giaDinh = null;
		int danhGia = 0;
//		
		if (Validator.isNotNull(lstDanhGiaVeSinhXa) && lstDanhGiaVeSinhXa.size() > 0) {
			log.info("====lstVeSinhGiaDinh==" + lstDanhGiaVeSinhXa.size());
			
			//--------------------XA--------------------
			for (DANHGIAVESINHXA veSinhXa : lstDanhGiaVeSinhXa) {
				
				// lttai vua bo sung
//				lstVeSinhGiaDinh = VeSinhGiaDinhBusiness.getVeSinhGiaDinhMauNgauNhien(maTinh, null, veSinhXa.getMaXa(), null, danhGiaKiemDem, namBaoCao, namBaoCao);
				veSinhGiaDinhThoiGianThuc = VeSinhGiaDinhBusiness.getVeSinhGiaDinhThoiGianThuc(maTinh, null, veSinhXa.getMaXa(), null, danhGiaKiemDem, namBaoCao, namBaoCao);
				
				//
				
				xaValue = Validator.isNotNull(veSinhXa.getMaXa()) ? NuocSachUtils.getNameXa(veSinhXa.getMaXa()) : "";
				huyenValue = Validator.isNotNull(veSinhXa.getMaHuyen()) ? NuocSachUtils.getNameHuyen("", veSinhXa.getMaHuyen()) : StringPool.BLANK;
				
				duLieuDong = result.new DuLieuDong("", "<b>Xã " + xaValue + "-Huyện " + huyenValue + "</b>", "", "", "", "", "", "", "", "", "", "", "", "");
				lstDuLieuDong.add(duLieuDong);
				
				
				
//				//------------------THON----------------
//				for (String thon : lstDanhGiaThon) {
//					thon = "";
//					duLieuDong = result.new DuLieuDong("", xaValue, "", "", "", "", "", "", "", "", "", "", "", "");
//					lstDuLieuDong.add(duLieuDong);
					
					
					//------------------------GIA DINH----------------------
//					for (VeSinhGiaDinh giaDinh : lstVeSinhGiaDinh) {
					for (Entry<VeSinhGiaDinh,Integer> entry : veSinhGiaDinhThoiGianThuc.entrySet()) {
						
						giaDinh = entry.getKey();
						danhGia = entry.getValue();
						
						// lttai vua bo sung
						
						 
						
//						ThongTinKiemDemHoGD thongTinKiemDemHoGD = ThongTinKiemDemHoGDBusiness.getThongTinKiemDemHGDVSTXByVeSinhGiaDinhID(maTinh, null, veSinhXa.getMaXa(), String.valueOf(giaDinh.getId()), DANHGIAKIEMDEM, DAKETTHUCDIEUTRA);
						
						// lttai vua bo sung
						stt = stt + 1;
						
						//1 la ngheo; 0 la ko ngheo
						hoNgheoVal = (giaDinh.getThanhPhanHoGD() == 1) ? "1" : "";
						
						//2 nha tieu hvs xay moi, 3 nha tieu hvs, 4 nha tieu khong hvs
//						if (giaDinh.getTrangThai() == 2 || giaDinh.getTrangThai() == 3) {
						if (danhGia == 1 || danhGia == 2) {
							nhaHvsVal = "x";
						} else {
							nhaHvsVal = "";
						}
						
						//loai nha tieu
						if ("04".equals(giaDinh.getLoaiNhaTieu())) { thVal = "x";
						} else if ("05".equals(giaDinh.getLoaiNhaTieu())) { tdVal = "x";
						} else if ("02".equals(giaDinh.getLoaiNhaTieu())) { hnVal = "x";
						} else if ("03".equals(giaDinh.getLoaiNhaTieu())) { chimVal = "x";
						} else { khacVal = "x"; }
						
						//xay dung tu nguon
						if (1 == (giaDinh.getNguonVon())) { troCapVal = "x";
						} else if (2 == (giaDinh.getNguonVon())) { vayVonVal = "x";
						} else if (3 == (giaDinh.getNguonVon())) { tuXayVal = "x"; }
						
						//hoan thanh
						namThangHoanThanh = (giaDinh.getThangXayDung() == 0  &&  giaDinh.getNamXayDung() == 0) ? "" : giaDinh.getThangXayDung() + " / " + giaDinh.getNamXayDung();
						
						
						duLieuDong = result.new DuLieuDong(stt + "", giaDinh.getTenChuHo(), hoNgheoVal, nhaHvsVal, thVal, tdVal, hnVal, chimVal, khacVal, troCapVal, vayVonVal, tuXayVal, namThangHoanThanh, giaDinh.getGhiChu());
						thVal = ""; tdVal = ""; hnVal = ""; chimVal = ""; khacVal = "";
						troCapVal = ""; vayVonVal = ""; tuXayVal = "";
						namThangHoanThanh = "";
						lstDuLieuDong.add(duLieuDong);
					}
//				}
				
					
					//
				
				duLieuDong = result.new DuLieuDong("", "<b>\u0054\u1ed5\u006e\u0067 \u0073\u1ed1\u003a " + stt + " \u0068\u1ed9 \u0067\u0069\u0061 \u0111\u00ec\u006e\u0068</b>", "", "", "", "", "", "", "", "", "", "", "", "");
				lstDuLieuDong.add(duLieuDong);
				
				countXa = countXa + 1;
				
				if (countXa < totalXa) {
					duLieuDong = result.new DuLieuDong("", "", "", "", "", "", "", "", "", "", "", "", "", "");
					lstDuLieuDong.add(duLieuDong);
				}
				
				//chay xong thon, reset
				stt = 0;
			}
		}
//		
		result.setNam(namValue);
		result.setNam(baoCaoNgayThangNamValue);
		result.setTenTinh(tenTinhValue);
		result.setBaoCaoSo(baoCaoSoValue);
//		result.setBaoCaoNgayThangNam(baoCaoNgayThangNamValue);
//		result.setNguoiLap(nguoiLapValue);
//		result.setNguoiDuyet(nguoiDuyetValue);
		result.setLstDuLieuDong(lstDuLieuDong);
		result.setDonViBaoCao(donViBaoCaoValue);
		return result;
	}
}
