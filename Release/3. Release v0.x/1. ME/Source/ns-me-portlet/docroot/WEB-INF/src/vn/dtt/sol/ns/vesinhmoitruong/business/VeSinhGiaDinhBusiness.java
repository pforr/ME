package vn.dtt.sol.ns.vesinhmoitruong.business;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhGiaDinh;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.VeSinhGiaDinhLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class VeSinhGiaDinhBusiness {
	private static Log _log = LogFactoryUtil.getLog(VeSinhGiaDinhBusiness.class);
	
	/**
	 * @param maTinh
	 * @param maHuyen
	 * @param maXa
	 * @param loaiNhaTieuId
	 * @param trangThai
	 * @param namBaoCao
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<VeSinhGiaDinh> getVeSinhGiaDinhSearch(String maTinh,String maHuyen,String maXa,String loaiNhaTieuId,String trangThai,String namBaoCao,int start,int end){
		List<VeSinhGiaDinh> lstVeSinhGiaDinh = new ArrayList<VeSinhGiaDinh>();
		try{
			lstVeSinhGiaDinh = VeSinhGiaDinhLocalServiceUtil.getVeSinhGiaDinhSearch(maTinh, maHuyen, maXa, loaiNhaTieuId, trangThai, namBaoCao,"", start, end);
		}catch(Exception e){
			_log.error(e);
		}
		return lstVeSinhGiaDinh;
	}
	
	/**
	 * @author tailt
	 * @param maTinh
	 * @param maHuyen
	 * @param maXa
	 * @param loaiNhaTieuId
	 * @param trangThai
	 * @param namBaoCao
	 * @return
	 */
	public static List<VeSinhGiaDinh> getVeSinhGiaDinhGroupByMaHuyen(String maTinh,String maHuyen,String maXa,String loaiNhaTieuId,String trangThai,String namBaoCao){
		List<VeSinhGiaDinh> lstVeSinhGiaDinh = new ArrayList<VeSinhGiaDinh>();
		try{
			lstVeSinhGiaDinh = VeSinhGiaDinhLocalServiceUtil.getVeSinhGiaDinhGroupByMaHuyen(maTinh, maHuyen, maXa, loaiNhaTieuId, trangThai, namBaoCao);
		}catch(Exception e){
			_log.error(e);
		}
		return lstVeSinhGiaDinh;
	}
	
	/**
	 * @param maTinh
	 * @param maHuyen
	 * @param maXa
	 * @param loaiNhaTieuId
	 * @param trangThai
	 * @param namBaoCao
	 * @return
	 */
	public static int countVeSinhGiaDinhSearch(String maTinh,String maHuyen,String maXa,String loaiNhaTieuId,String trangThai,String namBaoCao) {
		int count = 0;
		try{
			count = VeSinhGiaDinhLocalServiceUtil.countVeSinhGiaDinhSearch(maTinh, maHuyen, maXa, loaiNhaTieuId, trangThai, namBaoCao,"");
		}catch(Exception e){
			_log.error(e);
		}
		return count;
	}
}
