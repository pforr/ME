package vn.dtt.sol.ns.baocaodli.util;

import java.util.List;

import vn.dtt.sol.ns.business.KeHoachVeSinhBusiness;
import vn.dtt.sol.ns.danhgiavesinh.business.DANHGIAVESINHXABusiness;
import vn.dtt.sol.ns.danhgiavesinh.dao.model.DANHGIAVESINHXA;
import vn.dtt.sol.ns.kehoachdaunam.dao.model.KeHoachDauNam;
import vn.dtt.sol.ns.kehoachdaunam.dao.service.KeHoachDauNamLocalServiceUtil;
import vn.dtt.sol.ns.kehoachvesinh.dao.service.KeHoachVeSinhLocalServiceUtil;
import vn.dtt.sol.ns.reporting.model.dli22.SoNgDcTiepCanVsDienVSTXDanhSach;
import vn.dtt.sol.ns.tramcap.business.DanhGiaBenVungBussiness;
import vn.dtt.sol.ns.tramcap.business.TramCapBusiness;
import vn.dtt.sol.ns.tramcap.dao.model.DanhGiaBenVung;
import vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc;
import vn.dtt.sol.ns.tramcap.dao.service.DauNoiNuocLocalServiceUtil;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.util.format.ConvertUtil;
import vn.dtt.sol.ns.vesinhmoitruong.business.VeSinhGiaDinhBusiness;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class DLIUtils {

	/**
	 * @param maTinh
	 * @param nam
	 * @return so dau noi theo ke hoach
	 */
	public int getSoDauNoiTheoKeHoach(String maTinh, int nam) {
		int soDauNoiTheoKeHoach = 0;
		try {
			List<KeHoachDauNam> lsKeHoach = KeHoachDauNamLocalServiceUtil
					.searchByNamAndTinh(nam, maTinh, QueryUtil.ALL_POS,
							QueryUtil.ALL_POS);

			for (KeHoachDauNam keHoach : lsKeHoach) {
				soDauNoiTheoKeHoach = soDauNoiTheoKeHoach
						+ (int) keHoach.getSoDauNoiMoi();
			}

		} catch (Exception e) {
			_log.error(e);
		}

		return soDauNoiTheoKeHoach;
	}

	/**
	 * @param maTinh
	 * @param nam
	 * @return so dau noi moi trong mot nam
	 */
	public int getSoDauNoiMoi(String maTinh, int nam) {
		//int soDauNoiMoi = DauNoiNuocLocalServiceUtil.countDauNoiByMaTinhTramIdTrangThaiAndNam(maTinh,
		//				StringPool.BLANK, "2", Integer.toString(nam));
		
		// danhGiaKiemDem = "1"; Dat

		int soDauNoiMoi = 0;
		try {
			soDauNoiMoi = DauNoiNuocLocalServiceUtil.countDauNoiDLI1ChiTiet( maTinh, null, null, null, Integer.toString(nam), "1");
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return soDauNoiMoi;
	}

	/**
	 * @param maTinh
	 * @param nam
	 * @return So nha tieu hop ve sinh theo ke hoach
	 */
	public int getSoNhaTieuHVSTheoKH(String maTinh, int nam) {
		int soNhaTieuHVSTheoKH = 0;

		try {
			soNhaTieuHVSTheoKH = KeHoachVeSinhBusiness.sumSoNhaTieuHVSMoitheoKH(String.valueOf(nam), maTinh, null, null, null);
		} catch (Exception e) {
			_log.error(e);
		}

		return soNhaTieuHVSTheoKH;
	}

	public int getSoNguoiHuongLoiNuocSach(String maTinh, int nam) {
		String DANHGIABENVUNG = "1";
		// DANHGIABENVUNG, ketquadanhgia = 1 : ben vung
		int soNguoiHuongLoiNuocSach = 0;
		int soNguoiHuongLoiValueTemp = 0;
		//
		List<TramCapNuoc> lstTramCapNuoc = TramCapBusiness.getTramCapNuocByDanhGiaBenVung(maTinh, String.valueOf(nam), DANHGIABENVUNG);
		if(Validator.isNotNull(lstTramCapNuoc) && lstTramCapNuoc.size() > 0){
			for (TramCapNuoc tramCapNuoc : lstTramCapNuoc) {
				
				DanhGiaBenVung danhGiaBenVungSoNgHuongLoi = Validator.isNotNull(String.valueOf(nam)) ?
						DanhGiaBenVungBussiness.getDanhGiaBenVungByTramCapNuocAndNam(tramCapNuoc.getId(), String.valueOf(nam), DANHGIABENVUNG) : null;
						
						if(Validator.isNotNull(danhGiaBenVungSoNgHuongLoi)){
							soNguoiHuongLoiValueTemp = 
									Validator.isNotNull(danhGiaBenVungSoNgHuongLoi.getSoNguoiCapThucTe()) ? danhGiaBenVungSoNgHuongLoi.getSoNguoiCapThucTe() : 0 ;
						}
						
				soNguoiHuongLoiNuocSach = soNguoiHuongLoiNuocSach + soNguoiHuongLoiValueTemp;
				
			}
		}
		
		return soNguoiHuongLoiNuocSach;
	}

	public int getSoXa(String maTinh, int nam) {
		int soXa = 0;

		return soXa;
	}

	public int getTiLeHGDCoNhaTieu(String maTinh, int nam) {
		int tiLeHGDCoNhaTieu = 0;

		return tiLeHGDCoNhaTieu;
	}

	public int getTiLeHGDCoNhaTieuHVS(String maTinh, int nam) {
		int tiLeHGDCoNhaTieuHVS = 0;

		return tiLeHGDCoNhaTieuHVS;
	}

	public int getTiLeTruongHocHVS(String maTinh, int nam) {
		int tiLeTruongHocHVS = 0;

		return tiLeTruongHocHVS;
	}

	public int getTiLeTramYTeHVS(String maTinh, int nam) {
		int tiLeTramYTeHVS = 0;

		return tiLeTramYTeHVS;
	}

	public int getSoNguoiHuongLoiVSTX(String maTinh, int nam) {
		String KETLUANVSTX = "1";
		// ketluanvstx = 1 tuc la co ve siinh toan xa
		int soNguoiHuongLoiVSTX = 0;
		List<DANHGIAVESINHXA> lstDanhgiavesinhxa = DANHGIAVESINHXABusiness.getDanhGiaVeSinhXaBaoCao(maTinh, null, null, Integer.toString(nam),KETLUANVSTX);
		
		if(Validator.isNotNull(lstDanhgiavesinhxa) && lstDanhgiavesinhxa.size() > 0){
			
			for(DANHGIAVESINHXA danhgiavesinhxa : lstDanhgiavesinhxa){
				if (danhgiavesinhxa.getKetLuanVSTX() ==1) {
					soNguoiHuongLoiVSTX = soNguoiHuongLoiVSTX + danhgiavesinhxa.getSoDan();
				}
				
			}
		}

		
		return soNguoiHuongLoiVSTX;
	}

	public String getKeHoachPheDuyet(String maTinh, int nam) {
		String keHoachPheDuyet = StringPool.BLANK;

		return keHoachPheDuyet;
	}

	public int getSoNhaTieuHVSMoi(String maTinh, int nam) {
		//int getSoNhaTieuHVSMoi = 0;
		int getSoNhaTieuHVSMoi = VeSinhGiaDinhBusiness.countVeSinhGiaDinhDLI12GroupByMaHuyen(maTinh, null, null, Integer.toString(nam), "1");

		return getSoNhaTieuHVSMoi;
	}

	private static Log _log = LogFactoryUtil.getLog(DLIUtils.class);
}
