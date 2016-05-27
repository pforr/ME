package vn.dtt.sol.ns.reporting.model.dli22pl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import vn.dtt.sol.ns.danhgiavesinh.business.DANHGIAVESINHXABusiness;
import vn.dtt.sol.ns.danhgiavesinh.dao.model.DANHGIAVESINHXA;
import vn.dtt.sol.ns.reporting.model.dli22pl.BaoCaoVSTX_PL5_4_1.DuLieuDong;
import vn.dtt.sol.ns.reporting.utils.ReportFunction;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.util.format.FormatData;
import vn.dtt.sol.ns.vesinhmoitruong.business.VeSinhGiaDinhBusiness;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhGiaDinh;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;


public class BaoCaoVSTX_PL5_4_1_Export {
	
	private static Log log = LogFactoryUtil.getLog(BaoCaoVSTX_PL5_4_1_Export.class);
	
	/**
	 * @author tailt
	 * @param namBaoCao
	 * @param maTinh
	 * @param soBaoCao
	 * @param ngayBaoCao
	 * @param nguoiLap
	 * @param nguoiDuyet
	 * @return
	 */
	
	public static BaoCaoVSTX_PL5_4_1 getModel(String namBaoCao, String maTinh, String soBaoCao, String ngayBaoCao, String nguoiLap, String nguoiDuyet,String donViBaoCao) {
		
		log.info("==START DLI 2.2---PL5_4_1=BaoCaoVSTX_PL5_4_1===");
		log.info("--getModel==namBaoCao==" + namBaoCao + "==soBaoCao--" + soBaoCao + "==ngayBaoCao--" + ngayBaoCao + "==maTinh--" + maTinh);
		
		
		BaoCaoVSTX_PL5_4_1 result = new BaoCaoVSTX_PL5_4_1();
		
		List<BaoCaoVSTX_PL5_4_1.DuLieuDong> lstDuLieuDong = null;
		DuLieuDong duLieuDong = null;
		
		String KETLUANVSTX = "1"; // 1 la co vstx
//		String[] TRANGTHAI = {"2","3","4"}; // 2 nha tieu hvs xay moi, 3 nha tieu hvs, 4 nha tieu khong hvs
		/**
		 * 0. Không có kết quả, 1. Có nhà tiêu HVS xây mới. 2. Có nhà tiêu HVS xây cũ. 3. Có nhà tiêu không HVS, 4. Không có nhà tiêu
		 * */
		String[] danhGiaKiemDem = {"1","2","3"};
		
		String namValue = "";
		String tenTinhValue = "";
		String baoCaoSoValue = "";
		String baoCaoNgayThangNamValue = "";
		String nguoiLapValue = "";
		String nguoiDuyetValue = "";
		String donViBaoCaoValue = "";
		
		String xaValue = "";
		String huyenValue = "";
		String kiemTraHVS = "";
		String kiemTraKhongHVS = "";
		int countKhongHVS = 0;
		int countHVS = 0;
		int stt = 0; 
		
		
		namValue = namBaoCao;
		tenTinhValue = NuocSachUtils.getNameTinh(maTinh);
		baoCaoSoValue = Validator.isNotNull(soBaoCao) ? soBaoCao : "";
		
		if (Validator.isNotNull(ngayBaoCao)) {
			Date dateNgayBaoCao = FormatData.parseStringToDateTypeDDMMYYYY(ngayBaoCao.trim());
			baoCaoNgayThangNamValue = ReportFunction.parserDateToString4(dateNgayBaoCao);
		}
		nguoiLapValue = nguoiLap;
		nguoiDuyet = nguoiDuyetValue;
		donViBaoCaoValue = donViBaoCao;
		
		lstDuLieuDong = new ArrayList<DuLieuDong>();
		List<DANHGIAVESINHXA> lstDanhgiavesinhxa = DANHGIAVESINHXABusiness.getDanhGiaVeSinhXaBaoCao(maTinh, null, null, namBaoCao,KETLUANVSTX);
		if (Validator.isNotNull(lstDanhgiavesinhxa) && lstDanhgiavesinhxa.size() > 0) {
			for (DANHGIAVESINHXA danhgiavesinhxa : lstDanhgiavesinhxa) {
				
				//--------------Xã------------
				xaValue = Validator.isNotNull(danhgiavesinhxa.getMaXa()) ? NuocSachUtils.getNameXa(danhgiavesinhxa.getMaXa()) : StringPool.BLANK;
				huyenValue = Validator.isNotNull(danhgiavesinhxa.getMaHuyen()) ? NuocSachUtils.getNameHuyen("", danhgiavesinhxa.getMaHuyen()) : StringPool.BLANK; 
				
				duLieuDong = result.new DuLieuDong(StringPool.BLANK, "<b>Xã " + xaValue + "-Huyện " + huyenValue + "</b>", StringPool.BLANK, StringPool.BLANK, StringPool.BLANK);
				lstDuLieuDong.add(duLieuDong);
				
				//List<VeSinhGiaDinh> lstVeSinhGiaDinh = VeSinhGiaDinhBusiness.getVeSinhGiaDinhMauNgauNhien(maTinh, null, danhgiavesinhxa.getMaXa(), null, danhGiaKiemDem, namBaoCao, namBaoCao);
				HashMap<VeSinhGiaDinh,Integer> veSinhGiaDinhThoiGianThuc = VeSinhGiaDinhBusiness.getVeSinhGiaDinhThoiGianThuc(maTinh, null, danhgiavesinhxa.getMaXa(), null, danhGiaKiemDem, namBaoCao, namBaoCao);
				
				VeSinhGiaDinh temp = null;
				int danhGia = 0;
				
				if (Validator.isNotNull(veSinhGiaDinhThoiGianThuc) && veSinhGiaDinhThoiGianThuc.size() > 0) {
					for (Entry<VeSinhGiaDinh,Integer> entry : veSinhGiaDinhThoiGianThuc.entrySet()) {
						temp = entry.getKey();
						danhGia = entry.getValue();
						//--------Họ và tên chủ hộ-------set du lieu
						stt = stt + 1;
						if (danhGia == 1 || danhGia == 2) {
							kiemTraHVS = "x";
							countHVS = countHVS + 1;
						} else if (danhGia == 3) {
							kiemTraKhongHVS = "x";
							countKhongHVS = countKhongHVS + 1;
						}
						
						duLieuDong = result.new DuLieuDong(stt + StringPool.BLANK, temp.getTenChuHo(), kiemTraKhongHVS, kiemTraHVS, temp.getGhiChu());
						lstDuLieuDong.add(duLieuDong);
						kiemTraKhongHVS = StringPool.BLANK;
						kiemTraHVS = StringPool.BLANK;
					}
					
					//------Tong ket
					duLieuDong = result.new DuLieuDong(StringPool.BLANK, StringPool.BLANK, countKhongHVS + StringPool.BLANK, countHVS + StringPool.BLANK, StringPool.BLANK);
					lstDuLieuDong.add(duLieuDong);
					
					/**
					 * https://www.branah.com/unicode-converter
					 * Tổng số: =======>\u0054\u1ed5\u006e\u0067 \u0073\u1ed1\u003a 
					 *  hộ gia đình========> \u0068\u1ed9 \u0067\u0069\u0061 \u0111\u00ec\u006e\u0068
					 * 
					 * */
					duLieuDong = result.new DuLieuDong("", "<b>\u0054\u1ed5\u006e\u0067 \u0073\u1ed1\u003a " + stt + " \u0068\u1ed9 \u0067\u0069\u0061 \u0111\u00ec\u006e\u0068</b>", StringPool.BLANK, StringPool.BLANK, StringPool.BLANK);
					lstDuLieuDong.add(duLieuDong);
					stt = 0;
					countKhongHVS = 0;
					countHVS = 0;
				}
				
			}
		}
		
		log.info("===BaoCaoVSTX_PL5_4_1Export===getModel--result--==lstDanhgiavesinhxa--" + lstDanhgiavesinhxa.size());
		result.setNam(namValue);
		result.setNam(baoCaoNgayThangNamValue);
		result.setTenTinh(tenTinhValue);
		result.setBaoCaoSo(baoCaoSoValue);
//		result.setBaoCaoNgayThangNam(baoCaoNgayThangNamValue);
//		result.setNguoiLap(nguoiLapValue);
//		result.setNguoiDuyet(nguoiDuyetValue);
		result.setLstDuLieuDong(lstDuLieuDong);
		result.setDonViBaoCao(donViBaoCaoValue);
		log.info("==END BaoCaoVSTX_PL5_4_1===");
		return result;
		
	}
	
	

	
}
