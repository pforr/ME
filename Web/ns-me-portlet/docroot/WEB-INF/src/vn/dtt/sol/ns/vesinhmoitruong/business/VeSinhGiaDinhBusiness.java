package vn.dtt.sol.ns.vesinhmoitruong.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhGiaDinh;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.VeSinhGiaDinhLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

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
	public static List<VeSinhGiaDinh> getVeSinhGiaDinhGroupByMaHuyen(String maTinh,String maHuyen, String maXa, String loaiNhaTieuId, String[] trangThai, String namBaoCao){
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
	
	public static int countGioiTinhChuHo(String maTinh, String namBaoCao, String namXayDung, String gioiTinhChuHo, String trangThai) {
		int count = 0;
		try{
			count = VeSinhGiaDinhLocalServiceUtil.countGioiTinhChuHo( maTinh,  namBaoCao,  namXayDung,  gioiTinhChuHo,  trangThai);
		}catch(Exception e){
			_log.error(e);
		}
		return count;
	}
	
	public static List<VeSinhGiaDinh> getVeSinhGiaDinhGroupByMaTinhTW(String maTinh,String maHuyen, String maXa, String loaiNhaTieuId,String[] trangThai, String namBaoCao){
		List<VeSinhGiaDinh> lstVeSinhGiaDinh = new ArrayList<VeSinhGiaDinh>();
		try{
			lstVeSinhGiaDinh = VeSinhGiaDinhLocalServiceUtil.getVeSinhGiaDinhGroupByMaTinhTW(maTinh,maHuyen,maXa,loaiNhaTieuId,trangThai,namBaoCao);
		}catch(Exception e){
			_log.error(e);
		}
		return lstVeSinhGiaDinh;
	}
	public static List<VeSinhGiaDinh> getVeSinhGiaDinhGroupByMaHuyenMaXaAndMaXaNotInTW(String maTinh, String[] trangThai, String namBaoCao, String dangKyVSTX){
		List<VeSinhGiaDinh> lstVeSinhGiaDinh = new ArrayList<VeSinhGiaDinh>();
		try{
			lstVeSinhGiaDinh = VeSinhGiaDinhLocalServiceUtil.getVeSinhGiaDinhGroupByMaHuyenMaXaAndMaXaNotInTW(maTinh,trangThai,namBaoCao,dangKyVSTX);
		}catch(Exception e){
			_log.error(e);
		}
		return lstVeSinhGiaDinh;
	}
	public static int countVeSinhGiaDinhGroupByMaHuyen(String maTinh, String maHuyen,
			String maXa, String[] trangThai,
			String namBaoCao){
		int count = 0;
		try{
			count = VeSinhGiaDinhLocalServiceUtil.countVeSinhGiaDinhGroupByMaHuyen( maTinh,  maHuyen, maXa,  trangThai, namBaoCao);
		}catch(Exception e){
			_log.error(e);
		}
		return count;
	}
	
	public static List<VeSinhGiaDinh> getVeSinhGiaDinhThoiGianChot(String maTinh,String maHuyen, String maXa, String loaiNhaTieuId,String[] trangThai, String namBaoCao){
		List<VeSinhGiaDinh> lstVeSinhGiaDinh = new ArrayList<VeSinhGiaDinh>();
		try{
			lstVeSinhGiaDinh = VeSinhGiaDinhLocalServiceUtil.getVeSinhGiaDinhThoiGianChot( maTinh, maHuyen,  maXa,  loaiNhaTieuId, trangThai,  namBaoCao);
		}catch(Exception e){
			_log.error(e);
		}
		return lstVeSinhGiaDinh;
	}
	public static List<VeSinhGiaDinh> getVeSinhGiaDinhGroupByMaHuyenBaoCaoHopNhat(String maTinh,String maHuyen, String maXa, String loaiNhaTieuId,String[] trangThai, int namBaoCao, int namToiThieu) {
		List<VeSinhGiaDinh> lstVeSinhGiaDinh = new ArrayList<VeSinhGiaDinh>();
		try{
			lstVeSinhGiaDinh = VeSinhGiaDinhLocalServiceUtil.getVeSinhGiaDinhGroupByMaHuyenBaoCaoHopNhat( maTinh, maHuyen,  maXa,  loaiNhaTieuId, trangThai,  namBaoCao,  namToiThieu);
		}catch(Exception e){
			_log.error(e);
		}
		return lstVeSinhGiaDinh;
	}
	
	public static int countVeSinhGiaDinhGroupByMaHuyenBaoCaoHopNhat(String maTinh, String maHuyen,String maXa, String[] trangThai, int namBaoCao, int namToiThieu){
		int count = 0;
		try{
			count = VeSinhGiaDinhLocalServiceUtil.countVeSinhGiaDinhGroupByMaHuyenBaoCaoHopNhat( maTinh,  maHuyen, maXa,  trangThai,  namBaoCao,  namToiThieu);
		}catch(Exception e){
			_log.error(e);
		}
		return count;
	}
	public static List<VeSinhGiaDinh>  getVeSinhGiaDinhMauNgauNhienOnlySVRaSoat(String maTinh,
			String maHuyen, String maXa, String loaiNhaTieuId,
			String trangThai, String namBaoCao, String namBaoCaoVstx,
			int start, int end){
		List<VeSinhGiaDinh> lstVeSinhGiaDinh = new ArrayList<VeSinhGiaDinh>();
		try{
			lstVeSinhGiaDinh = VeSinhGiaDinhLocalServiceUtil.getVeSinhGiaDinhMauNgauNhienOnlySVRaSoat( maTinh,
					 maHuyen,  maXa,  loaiNhaTieuId,
					 trangThai,  namBaoCao,  namBaoCaoVstx,
					 start,  end);
		}catch(Exception e){
			_log.error(e);
		}
		return lstVeSinhGiaDinh;
	}
	public static int countVeSinhGiaDinhMauNgauNhienOnlySVRaSoat(String maTinh, String maHuyen,
			String maXa, String loaiNhaTieuId, String trangThai,
			String namBaoCao, String namBaoCaoVstx){
		int count = 0;
		try{
			count = VeSinhGiaDinhLocalServiceUtil.countVeSinhGiaDinhMauNgauNhienOnlySVRaSoat( maTinh,  maHuyen,
					 maXa,  loaiNhaTieuId,  trangThai,
					 namBaoCao,  namBaoCaoVstx);
		}catch(Exception e){
			_log.error(e);
		}
		return count;
	}
	public static List<VeSinhGiaDinh>   getVeSinhGiaDinhGroupByMaTinhBaoCaoHopNhatTU(
			String maTinh, String maHuyen, String maXa, String loaiNhaTieuId,
			String[] trangThai, int namBaoCao, int namToiThieu){
		List<VeSinhGiaDinh> lstVeSinhGiaDinh = new ArrayList<VeSinhGiaDinh>();
		try{
			lstVeSinhGiaDinh = VeSinhGiaDinhLocalServiceUtil.getVeSinhGiaDinhGroupByMaTinhBaoCaoHopNhatTU(
					 maTinh,  maHuyen,  maXa,  loaiNhaTieuId,
					 trangThai,  namBaoCao, namToiThieu);
		}catch(Exception e){
			_log.error(e);
		}
		return lstVeSinhGiaDinh;
	}
	
	public static List<VeSinhGiaDinh>   getVeSinhGiaDinhMauNgauNhien(String maTinh,String maHuyen, String maXa, String loaiNhaTieuId,String[] trangThai, String namBaoCao, String namBaoCaoVstx){
		List<VeSinhGiaDinh> lstVeSinhGiaDinh = new ArrayList<VeSinhGiaDinh>();
		try {
			lstVeSinhGiaDinh = VeSinhGiaDinhLocalServiceUtil.getVeSinhGiaDinhMauNgauNhien( maTinh, maHuyen,  maXa,  loaiNhaTieuId, trangThai,  namBaoCao,  namBaoCaoVstx);
		} catch (Exception e) {
			_log.error(e);
		}
		return lstVeSinhGiaDinh;
	}
	
	public static HashMap<VeSinhGiaDinh, Integer> getVeSinhGiaDinhThoiGianThuc(String maTinh,String maHuyen, String maXa, String loaiNhaTieuId,String[] trangThai, String namBaoCao, String namBaoCaoVstx) {
		HashMap<VeSinhGiaDinh, Integer> lstVeSinhGiaDinh = new HashMap<VeSinhGiaDinh, Integer>();
		try {
			lstVeSinhGiaDinh = VeSinhGiaDinhLocalServiceUtil.getVeSinhGiaDinhThoiGianThuc( maTinh, maHuyen,  maXa,  loaiNhaTieuId, trangThai,  namBaoCao,  namBaoCaoVstx);
		} catch (Exception e) {
			_log.error(e);
		}
		return lstVeSinhGiaDinh;
	}
	
	public static List<VeSinhGiaDinh>  getVeSinhGiaDinhDLI12GroupByMaHuyen(String maTinh,
			String maHuyen, String maXa, String namBaoCao, String danhgiakiemdem){
		List<VeSinhGiaDinh> lstVeSinhGiaDinh = new ArrayList<VeSinhGiaDinh>();
		try{
			lstVeSinhGiaDinh = VeSinhGiaDinhLocalServiceUtil.getVeSinhGiaDinhDLI12GroupByMaHuyen( maTinh,
					 maHuyen,  maXa,  namBaoCao,  danhgiakiemdem);
		}catch(Exception e){
			_log.error(e);
		}
		return lstVeSinhGiaDinh;
	}
	
	public static int countVeSinhGiaDinhDLI12GroupByMaHuyen(String maTinh,
			String maHuyen, String maXa, String namBaoCao, String danhgiakiemdem){
		int count = 0;
		try{
			count = VeSinhGiaDinhLocalServiceUtil.countVeSinhGiaDinhDLI12GroupByMaHuyen( maTinh,
					 maHuyen,  maXa,  namBaoCao,  danhgiakiemdem);
		}catch(Exception e){
			_log.error(e);
		}
		return count;
	}
	
	public static List<VeSinhGiaDinh> getVeSinhGiaDinhDLI12ChiTiet(String maTinh,
			String maHuyen, String maXa, String namBaoCao, String danhgiakiemdem){
		List<VeSinhGiaDinh> lstVeSinhGiaDinh = new ArrayList<VeSinhGiaDinh>();
		try{
			lstVeSinhGiaDinh = VeSinhGiaDinhLocalServiceUtil.getVeSinhGiaDinhDLI12ChiTiet( maTinh,
					 maHuyen,  maXa,  namBaoCao,  danhgiakiemdem);
		}catch(Exception e){
			_log.error(e);
		}
		return lstVeSinhGiaDinh;
	}
	public static List<VeSinhGiaDinh> searchVeSinhGiaDinhAll(String maTinh, String maHuyen, String maXa, String thonXom, String trangThai, String danhGiaKiemDem, String tkKiemDemVien, String tkGiamSatVien, String ngayKiemDem, String namBaoCao,
			String namBaoCaoVstx, String idNguoiTao, String ngayTao, String advText){
		List<VeSinhGiaDinh> lstVeSinhGiaDinh = new ArrayList<VeSinhGiaDinh>();
		try{
			lstVeSinhGiaDinh = VeSinhGiaDinhLocalServiceUtil.searchVeSinhGiaDinh( maTinh, maHuyen, maXa, thonXom, trangThai,
					danhGiaKiemDem, tkKiemDemVien, tkGiamSatVien, ngayKiemDem, namBaoCao, namBaoCaoVstx, idNguoiTao, ngayTao, advText, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
		}catch(Exception e){
			_log.error(e);
		}
		return lstVeSinhGiaDinh;
	}
}
