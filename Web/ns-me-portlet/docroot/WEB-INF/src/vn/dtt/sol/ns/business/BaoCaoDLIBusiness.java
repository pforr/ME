package vn.dtt.sol.ns.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import vn.dtt.cmon.dm.dao.model.DATAITEM;
import vn.dtt.sol.ns.baocaodli.dao.NamBaoCaoException;
import vn.dtt.sol.ns.baocaodli.dao.NoSuchBaoCaoDLIException;
import vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLI;
import vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHop;
import vn.dtt.sol.ns.baocaodli.dao.service.BaoCaoDLILocalServiceUtil;
import vn.dtt.sol.ns.baocaodli.dao.service.BaoCaoDLIServiceUtil;
import vn.dtt.sol.ns.baocaodli.dao.service.BaoCaoDLITongHopLocalServiceUtil;
import vn.dtt.sol.ns.baocaodli.util.DLIUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

public class BaoCaoDLIBusiness {

	public static void initBaoCaoDLITongHop() {
		_log.info("--Vao initBaoCaoDLITongHop--");
		try {
			boolean hasInit = BaoCaoDLILocalServiceUtil.hasInitBaoCaoTongHop();
			
			Date now = new Date();

			Calendar cal = Calendar.getInstance();
			cal.setTime(now);

			int nam = cal.get(Calendar.YEAR);
			_log.info("--nam--"+nam);
			/*if (!hasInit) {*/
				List<DATAITEM> lsTinh = DataItemBusiness.getInLevel1(1);
				
				DLIUtils util = new DLIUtils();
				
				for (DATAITEM dataItem : lsTinh) {
					_log.info("--lsTinh.size--"+lsTinh.size()+"==");
					String maTinh = dataItem.getNode1();
					
					//DLI 1.1
					int soDauNoiTheoKeHoach = util.getSoDauNoiTheoKeHoach(maTinh, nam);
					int soDauNoiMoi = util.getSoDauNoiMoi(maTinh, nam);
					//DLI 1.2
					int soNhaTieuHVSTheoKH = util.getSoNhaTieuHVSTheoKH(maTinh, nam);
					int soNhaTieuHVSMoi = util.getSoNhaTieuHVSMoi(maTinh, nam);
					//DLI 2.1
					int soNguoiHuongLoiNuocSach = util.getSoNguoiHuongLoiNuocSach(maTinh, nam); // Thuc te
					
					//DLI 2.2
					int soNguoiHuongLoiVSTX = util.getSoNguoiHuongLoiVSTX(maTinh, nam); // Thuc Te
					
					int soXa = util.getSoXa(maTinh, nam);
					int tiLeHGDCoNhaTieu = util.getTiLeHGDCoNhaTieu(maTinh, nam);
					int tiLeHGDCoNhaTieuHVS = util.getTiLeHGDCoNhaTieuHVS(maTinh, nam);
					int tiLeTruongHocHVS = util.getTiLeTruongHocHVS(maTinh, nam);
					int tiLeTramYTeHVS = util.getTiLeTramYTeHVS(maTinh, nam);
					
					String keHoachPheDuyet = util.getKeHoachPheDuyet(maTinh, nam);
					
	
						
					BaoCaoDLITongHopLocalServiceUtil.addBaoCaoTH(maTinh, nam,
							soDauNoiTheoKeHoach, soDauNoiMoi,
							soNhaTieuHVSTheoKH, soNhaTieuHVSMoi,
							soNguoiHuongLoiNuocSach, soXa, tiLeHGDCoNhaTieu,
							tiLeHGDCoNhaTieuHVS, tiLeTruongHocHVS,
							tiLeTramYTeHVS, soNguoiHuongLoiVSTX,
							keHoachPheDuyet);
				}
			//}

		} catch (Exception se) {
			_log.error(se);
		}
	}

	public static void initBaoCaoDLITongHopNam(int namBaoCao) {
		_log.info("--Vao initBaoCaoDLITongHopNam--");
		
		try {
			/*
			boolean hasInit = BaoCaoDLILocalServiceUtil.hasInitBaoCaoTongHop();
			
			Date now = new Date();

			Calendar cal = Calendar.getInstance();
			cal.setTime(now);
			*/
			Date now = new Date();

			Calendar cal = Calendar.getInstance();
			cal.setTime(now);
			
			int nam = cal.get(Calendar.YEAR);
			if(namBaoCao > 0){
				nam = namBaoCao;
			}
			_log.info("--nam--initBaoCaoDLITongHopNam--"+nam);
			/*if (!hasInit) {*/
				List<DATAITEM> lsTinh = DataItemBusiness.getInLevel1(1);
				
				DLIUtils util = new DLIUtils();
				
				for (DATAITEM dataItem : lsTinh) {
					_log.info("--lsTinh.size--"+lsTinh.size()+"==");
					String maTinh = dataItem.getNode1();
					
					//DLI 1.1
					int soDauNoiTheoKeHoach = util.getSoDauNoiTheoKeHoach(maTinh, nam);
					int soDauNoiMoi = util.getSoDauNoiMoi(maTinh, nam);
					//DLI 1.2
					int soNhaTieuHVSTheoKH = util.getSoNhaTieuHVSTheoKH(maTinh, nam);
					int soNhaTieuHVSMoi = util.getSoNhaTieuHVSMoi(maTinh, nam);
					//DLI 2.1
					int soNguoiHuongLoiNuocSach = util.getSoNguoiHuongLoiNuocSach(maTinh, nam); // Thuc te
					
					//DLI 2.2
					int soNguoiHuongLoiVSTX = util.getSoNguoiHuongLoiVSTX(maTinh, nam); // Thuc Te
					
					int soXa = util.getSoXa(maTinh, nam);
					int tiLeHGDCoNhaTieu = util.getTiLeHGDCoNhaTieu(maTinh, nam);
					int tiLeHGDCoNhaTieuHVS = util.getTiLeHGDCoNhaTieuHVS(maTinh, nam);
					int tiLeTruongHocHVS = util.getTiLeTruongHocHVS(maTinh, nam);
					int tiLeTramYTeHVS = util.getTiLeTramYTeHVS(maTinh, nam);
					
					String keHoachPheDuyet = util.getKeHoachPheDuyet(maTinh, nam);
					
	
						
					BaoCaoDLITongHopLocalServiceUtil.addBaoCaoTH(maTinh, nam,
							soDauNoiTheoKeHoach, soDauNoiMoi,
							soNhaTieuHVSTheoKH, soNhaTieuHVSMoi,
							soNguoiHuongLoiNuocSach, soXa, tiLeHGDCoNhaTieu,
							tiLeHGDCoNhaTieuHVS, tiLeTruongHocHVS,
							tiLeTramYTeHVS, soNguoiHuongLoiVSTX,
							keHoachPheDuyet);
				}
			//}

		} catch (Exception se) {
			_log.error(se);
		}
		
		
	}
	/**
	 * Tao san du lieu trong nam cho cac bao cao dli
	 */
	public static void initBaoCaoDLI() {
		try {
			BaoCaoDLIServiceUtil.initBaoCaoDLI();
		} catch (SystemException se) {
			_log.error(se);
		}
	}

	public static BaoCaoDLI getBaoCaoDLI(long baoCaoDLIId) {
		BaoCaoDLI baoCaoDLI = null;

		if (baoCaoDLIId > 0) {
			try {
				baoCaoDLI = BaoCaoDLILocalServiceUtil.getBaoCaoDLI(baoCaoDLIId);
			} catch (Exception e) {
				if (!(e instanceof NoSuchBaoCaoDLIException)) {
					_log.error(e);
				}
			}
		}

		return baoCaoDLI;
	}
	
	
	public static BaoCaoDLITongHop getBaoCaoDLITongHop(long baoCaoDLIId) {
		BaoCaoDLITongHop baoCaoDLI = null;

		if (baoCaoDLIId > 0) {
			try {
				baoCaoDLI = BaoCaoDLITongHopLocalServiceUtil.getBaoCaoDLITongHop(baoCaoDLIId);
			} catch (Exception e) {
				if (!(e instanceof NoSuchBaoCaoDLIException)) {
					_log.error(e);
				}
			}
		}

		return baoCaoDLI;
	}
	
	public static List<BaoCaoDLITongHop> searchDLITH(int userType, String namBaoCao, String maTinh, int start, int end) {
		List<BaoCaoDLITongHop> lsBCTH = new ArrayList<BaoCaoDLITongHop>();
		
		BaoCaoDLITongHop bcth = null;
		
		try {
			_log.info("--userType--"+userType);
			if (userType == 1) {
				lsBCTH = BaoCaoDLITongHopLocalServiceUtil.getListBaoCaoDLITongHopByNamTW(namBaoCao);
			} else if (userType == 2) {
				bcth = BaoCaoDLITongHopLocalServiceUtil.getBaoCaoDLITongHopByTinhVaNam(maTinh, namBaoCao);
			}
			
			if (Validator.isNotNull(bcth)) {
				lsBCTH.add(bcth);
			}
			
		} catch (Exception e) {
		}
		_log.info("lsBCTH.size()--"+lsBCTH.size()+"==");
		return lsBCTH;
	}

	public static List<BaoCaoDLI> search(String maTinh, int loaiBaoCao,
			int nam, Integer trangThai, int start, int end,
			OrderByComparator obc) {

		List<BaoCaoDLI> results = new ArrayList<BaoCaoDLI>();

		try {
			results = BaoCaoDLILocalServiceUtil.search(maTinh, loaiBaoCao, nam,
					trangThai, start, end, obc);
		} catch (SystemException se) {
			_log.error(se);
		}

		return results;
	}

	public static int searchCount(String maTinh, int loaiBaoCao, int nam,
			Integer trangThai) {

		int count = 0;

		try {
			count = BaoCaoDLILocalServiceUtil.searchCount(maTinh, loaiBaoCao,
					nam, trangThai);
		} catch (SystemException se) {
			_log.error(se);
		}

		return count;
	}

	public static List<BaoCaoDLI> search(String maTinh, int nam,
			Integer trangThai, int start, int end, OrderByComparator obc) {

		List<BaoCaoDLI> results = new ArrayList<BaoCaoDLI>();

		try {
			results = BaoCaoDLILocalServiceUtil.search(maTinh, nam, trangThai,
					start, end, obc);
		} catch (SystemException se) {
			_log.error(se);
		}

		return results;
	}

	public static int searchCount(String maTinh, int nam, Integer trangThai) {

		int count = 0;

		try {
			count = BaoCaoDLILocalServiceUtil.searchCount(maTinh, nam,
					trangThai);
		} catch (SystemException se) {
			_log.error(se);
		}

		return count;
	}

	private static final Log _log = LogFactoryUtil.getLog(BaoCaoDLIBusiness.class);
}
