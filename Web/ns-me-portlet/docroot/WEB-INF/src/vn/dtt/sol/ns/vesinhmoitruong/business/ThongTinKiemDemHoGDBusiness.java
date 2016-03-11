package vn.dtt.sol.ns.vesinhmoitruong.business;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemHoGD;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.ThongTinKiemDemHoGDLocalServiceUtil;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.VeSinhGiaDinhLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ThongTinKiemDemHoGDBusiness {
	
	private static Log _log = LogFactoryUtil.getLog(ThongTinKiemDemHoGDBusiness.class);
	
	
	
	public static List<ThongTinKiemDemHoGD> getThongTinKiemDemHGDThoiGianThucGroupBy(String maTinh, String namBaoCao, String[] danhgiakiemdem, String daketthucdieutra) {
		List<ThongTinKiemDemHoGD> lstThongTinKiemDemHoGD = new ArrayList<ThongTinKiemDemHoGD>();
		try{
			lstThongTinKiemDemHoGD = ThongTinKiemDemHoGDLocalServiceUtil.getThongTinKiemDemHGDThoiGianThucGroupBy(maTinh,namBaoCao,danhgiakiemdem,daketthucdieutra);
		}catch(Exception e){
			_log.error(e);
		}
		return lstThongTinKiemDemHoGD;
	}
	
	public static int countThongTinKiemDemHGDThoiGianThucGroupBy(String maTinh, String namBaoCao, String[] danhgiakiemdem, String maHuyen, String maXa, String daketthucdieutra ) {
		int count = 0;
		try{
			count = ThongTinKiemDemHoGDLocalServiceUtil.countThongTinKiemDemHGDThoiGianThucGroupBy(maTinh,namBaoCao,danhgiakiemdem,maHuyen,maXa,daketthucdieutra);
		}catch(Exception e){
			_log.error(e);
		}
		return count;
	}
	
	public static List<ThongTinKiemDemHoGD> getThongTinKiemDemHGDThoiGianThuc(String maTinh, String namBaoCao, String[] danhgiakiemdem, String daketthucdieutra) {
		List<ThongTinKiemDemHoGD> lstThongTinKiemDemHoGD = new ArrayList<ThongTinKiemDemHoGD>();
		try{
			lstThongTinKiemDemHoGD = ThongTinKiemDemHoGDLocalServiceUtil.getThongTinKiemDemHGDThoiGianThuc( maTinh,  namBaoCao,  danhgiakiemdem,  daketthucdieutra);
		}catch(Exception e){
			_log.error(e);
		}
		return lstThongTinKiemDemHoGD;
	}
	
	public static List<ThongTinKiemDemHoGD> getListThongTinKiemDemHoGiaDinhByKeHoachId(int keHoachId) {
		List<ThongTinKiemDemHoGD> lstThongTinKiemDemHoGD = new ArrayList<ThongTinKiemDemHoGD>();
		try{
			lstThongTinKiemDemHoGD = ThongTinKiemDemHoGDLocalServiceUtil.getListThongTinKiemDemHoGiaDinhByKeHoachId(keHoachId);
		}catch(Exception e){
			_log.error(e);
		}
		return lstThongTinKiemDemHoGD;
	}
	
	public static int countGioiTinhChuHo(String maTinh,  String namBaoCao, String gioiTinhChuHo, String[] danhGiaKiemDem, String daKetThucDieuTra) {
		int count = 0;
		try{
			count = ThongTinKiemDemHoGDLocalServiceUtil.countGioiTinhChuHo(  maTinh,  namBaoCao,  gioiTinhChuHo,danhGiaKiemDem,  daKetThucDieuTra);
		}catch(Exception e){
			_log.error(e);
		}
		return count;
	}
	public static int countGioiTinhChuHoByMauNNVSTXJoinVSGD(String maTinh, String mauNgauNhien, String gioiTinhChuHo){
		int count = 0;
		try{
			count = ThongTinKiemDemHoGDLocalServiceUtil.countGioiTinhChuHoByMauNNVSTXJoinVSGD(maTinh,mauNgauNhien,gioiTinhChuHo);
		}catch(Exception e){
			_log.error(e);
		}
		return count;
	}
	public static int countGioiTinhChuHoBaoCaoHopNhat(String maTinh, int namBaoCao,int namToiThieu, String gioiTinhChuHo, String[] danhGiaKiemDem, String daKetThucDieuTra){
		int count = 0;
		try{
			count = ThongTinKiemDemHoGDLocalServiceUtil.countGioiTinhChuHoBaoCaoHopNhat( maTinh,  namBaoCao, namToiThieu,  gioiTinhChuHo,  danhGiaKiemDem,  daKetThucDieuTra);
		}catch(Exception e){
			_log.error(e);
		}
		return count;
	}
	
	public static int countGioiTinhChuHoByMauNNVSTXJoinVSGDBaoCaoHopNhat(String maTinh, int namMauNgauNhien,int namToiThieu, String gioiTinhChuHo, String[] danhGiaKiemDem, String daKetThucDieuTra){
		int count = 0;
		try{
			count = ThongTinKiemDemHoGDLocalServiceUtil.countGioiTinhChuHoByMauNNVSTXJoinVSGDBaoCaoHopNhat( maTinh,  namMauNgauNhien, namToiThieu,  gioiTinhChuHo, danhGiaKiemDem,  daKetThucDieuTra);
		}catch(Exception e){
			_log.error(e);
		}
		return count;
	}
	public static List<ThongTinKiemDemHoGD> getThongTinKiemDemHGDTVGGroupByMatinh(String maTinh, String namBaoCao, String gioiTinhChuHo, String[] danhGiaKiemDem, String daKetThucDieuTra) {
		List<ThongTinKiemDemHoGD> lstThongTinKiemDemHoGD = new ArrayList<ThongTinKiemDemHoGD>();
		try{
			lstThongTinKiemDemHoGD = ThongTinKiemDemHoGDLocalServiceUtil.getThongTinKiemDemHGDTVGGroupByMatinh( maTinh,  namBaoCao,  gioiTinhChuHo,  danhGiaKiemDem,  daKetThucDieuTra);
		}catch(Exception e){
			_log.error(e);
		}
		return lstThongTinKiemDemHoGD;
	}
	public static List<ThongTinKiemDemHoGD> getThongTinKiemDemHGDVSTXTVGGroupByMatinh(String maTinh, String namMauNgauNhien, String gioiTinhChuHo, String[] danhGiaKiemDem, String daKetThucDieuTra) {
		List<ThongTinKiemDemHoGD> lstThongTinKiemDemHoGD = new ArrayList<ThongTinKiemDemHoGD>();
		try{
			lstThongTinKiemDemHoGD = ThongTinKiemDemHoGDLocalServiceUtil.getThongTinKiemDemHGDVSTXTVGGroupByMatinh( maTinh,  namMauNgauNhien,  gioiTinhChuHo,  danhGiaKiemDem,  daKetThucDieuTra);
		}catch(Exception e){
			_log.error(e);
		}
		return lstThongTinKiemDemHoGD;
	}
}
