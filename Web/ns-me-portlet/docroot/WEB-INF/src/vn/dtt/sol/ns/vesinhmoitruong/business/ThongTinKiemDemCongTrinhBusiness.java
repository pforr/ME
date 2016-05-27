package vn.dtt.sol.ns.vesinhmoitruong.business;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemCongTrinh;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.ThongTinKiemDemCongTrinhLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ThongTinKiemDemCongTrinhBusiness {
	
	public static List<ThongTinKiemDemCongTrinh> getListThongTinKiemDemCongTrinhByKeHoachId(int keHoachId) {
		List<ThongTinKiemDemCongTrinh> lstThongTinKiemDemCongTrinh = new ArrayList<ThongTinKiemDemCongTrinh>();
		try{
			lstThongTinKiemDemCongTrinh = ThongTinKiemDemCongTrinhLocalServiceUtil.getListThongTinKiemDemCongTrinhByKeHoachId(keHoachId);
		}catch(Exception e){
			_log.error(e);
		}
		return lstThongTinKiemDemCongTrinh;
	}
	public static ThongTinKiemDemCongTrinh getThongTinKiemDemCongTrinhByVeSinhCTID(String VESINHCONGTRINHID){
		ThongTinKiemDemCongTrinh thongTinKiemDemCongTrinh = null;
		try{
			thongTinKiemDemCongTrinh = ThongTinKiemDemCongTrinhLocalServiceUtil.getThongTinKiemDemCongTrinhByVeSinhCTID(VESINHCONGTRINHID);
		}catch(Exception e){
			_log.error(e);
		}
		return thongTinKiemDemCongTrinh;
	}
	public static List<ThongTinKiemDemCongTrinh> getListGroupByBaoCaoThongKeCTCC(String nam,String maTinh,String maHuyen,String maXa) {
		List<ThongTinKiemDemCongTrinh> lstThongTinKiemDemCongTrinh = new ArrayList<ThongTinKiemDemCongTrinh>();
		try{
			lstThongTinKiemDemCongTrinh = ThongTinKiemDemCongTrinhLocalServiceUtil.getListGroupByBaoCaoThongKeCTCC( nam, maTinh, maHuyen, maXa);
		}catch(Exception e){
			_log.error(e);
		}
		return lstThongTinKiemDemCongTrinh;
	}
	
	public static int countCTCCBaoCaoThongKeCTCC(String nam,String maTinh,String maHuyen,String maXa,int isHVS,int isKoHVS,int isChuaKiemDem,int isDangKiemDem) {
		int count = 0;
		try{
			count = ThongTinKiemDemCongTrinhLocalServiceUtil.countCTCCBaoCaoThongKeCTCC( nam, maTinh, maHuyen, maXa, isHVS, isKoHVS, isChuaKiemDem, isDangKiemDem);
		}catch(Exception e){
			_log.error(e);
		}
		return count;
	}
	private static Log _log = LogFactoryUtil.getLog(ThongTinKiemDemCongTrinhBusiness.class);
}
