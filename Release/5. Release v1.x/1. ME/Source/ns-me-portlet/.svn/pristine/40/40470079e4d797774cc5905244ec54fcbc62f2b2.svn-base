package vn.dtt.sol.ns.danhgiavesinh.business;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.danhgiavesinh.dao.model.DANHGIAVESINHXA;
import vn.dtt.sol.ns.danhgiavesinh.dao.service.DANHGIAVESINHXALocalServiceUtil;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.VeSinhGiaDinhLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class DANHGIAVESINHXABusiness {
	private static Log _log = LogFactoryUtil.getLog(DANHGIAVESINHXABusiness.class);
	
	/**
	 * @author tailt
	 * @param maTinh
	 * @param maHuyen
	 * @param maXa
	 * @param namBaoCao
	 * @return
	 */
	public static List<DANHGIAVESINHXA> getDanhGiaVeSinhXaBaoCao(String maTinh,String maHuyen,String maXa,String namBaoCao,String ketLuanVSTX){
		List<DANHGIAVESINHXA> ls = new ArrayList<DANHGIAVESINHXA>();
		
		try{
			ls = DANHGIAVESINHXALocalServiceUtil.getDanhGiaVeSinhXaBaoCao(maTinh, maHuyen, maXa,  namBaoCao,ketLuanVSTX);
		}catch(Exception e){
			_log.error(e);
		}
		
		return ls;
	}
	public static int sumSoNguoiHuongLoiByMaTinh(String maTinh, String namBaoCao){
		int count = 0;
		try{
			count = DANHGIAVESINHXALocalServiceUtil.sumSoNguoiHuongLoiByMaTinh(maTinh,namBaoCao);
		}catch(Exception e){
			_log.error(e);
		}
		return count;
	}
	
	public static List<DANHGIAVESINHXA> getDanhGiaVeSinhXaGroupByMaTinhTW(String maTinh,String maHuyen,String maXa,String namBaoCao,String ketLuanVSTX){
		List<DANHGIAVESINHXA> ls = new ArrayList<DANHGIAVESINHXA>();
		
		try{
			ls = DANHGIAVESINHXALocalServiceUtil.getDanhGiaVeSinhXaGroupByMaTinhTW(maTinh,maHuyen,maXa,namBaoCao,ketLuanVSTX);
		}catch(Exception e){
			_log.error(e);
		}
		
		return ls;
	}
	
	public static List<DANHGIAVESINHXA> getDanhGiaVeSinhXaGroupByMaHuyenMaXaTW(String maTinh,String maHuyen,String maXa,String namBaoCao,String ketLuanVSTX){
		List<DANHGIAVESINHXA> ls = new ArrayList<DANHGIAVESINHXA>();
		
		try{
			ls = DANHGIAVESINHXALocalServiceUtil.getDanhGiaVeSinhXaGroupByMaHuyenMaXaTW(maTinh,maHuyen,maXa,namBaoCao,ketLuanVSTX);
		}catch(Exception e){
			_log.error(e);
		}
		
		return ls;
	}
	
	public static double getDanhGiaVeSinhXaTyLeAllTW(String maTinh, String namBaoCao,String ketLuanVSTX, int isSumSoXa, int isCoNhaTieuHVS,int isCoNhaTieu,int isCoTyLeTruongHoc, int isCoTyLeTramYTe, int isSumSoNguoiHuongLoi) {
		double count = 0 ;
		try{
			count = DANHGIAVESINHXALocalServiceUtil.getDanhGiaVeSinhXaTyLeAllTW( maTinh,  namBaoCao,ketLuanVSTX,  isSumSoXa,  isCoNhaTieuHVS, isCoNhaTieu, isCoTyLeTruongHoc,  isCoTyLeTramYTe,  isSumSoNguoiHuongLoi);
		}catch(Exception e){
			_log.error(e);
		}
		return count;
	}
	
	
	public static List<DANHGIAVESINHXA> getDanhGiaVeSinhXaGroupByMaHuyenMaXaBaoCaoHopNhat(String maTinh,String maHuyen,String maXa,int namBaoCao, int namToiThieu, String ketLuanVSTX){
		List<DANHGIAVESINHXA> ls = new ArrayList<DANHGIAVESINHXA>();
		
		try{
			ls = DANHGIAVESINHXALocalServiceUtil.getDanhGiaVeSinhXaGroupByMaHuyenMaXaBaoCaoHopNhat( maTinh, maHuyen, maXa, namBaoCao,  namToiThieu,  ketLuanVSTX);
		}catch(Exception e){
			_log.error(e);
		}
		
		return ls;
	}
	
	public static double getDanhGiaVeSinhXaTyLeAllBaoCaoHopNhat(String maTinh,String maHuyen,String maXa, int namBaoCao,int namToiThieu,String ketLuanVSTX, int isSumSoXa, int isCoNhaTieuHVS,int isCoNhaTieu,int isCoTyLeTruongHoc, int isCoTyLeTramYTe, int isSumSoNguoiHuongLoi) {
		double count = 0 ;
		try{
			count = DANHGIAVESINHXALocalServiceUtil.getDanhGiaVeSinhXaTyLeAllBaoCaoHopNhat( maTinh, maHuyen, maXa,  namBaoCao, namToiThieu, ketLuanVSTX,  isSumSoXa,  isCoNhaTieuHVS, isCoNhaTieu, isCoTyLeTruongHoc,  isCoTyLeTramYTe,  isSumSoNguoiHuongLoi);
		}catch(Exception e){
			_log.error(e);
		}
		return count;
	}
}
