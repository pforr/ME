package vn.dtt.cmon.kiemdemvien.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien;
import vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;


public class KiemDemVienAction{
	
	public void addKiemDemVien(ActionRequest actionRequest, ActionResponse actionResponse){

		String hoVaTen = ParamUtil.getString(actionRequest, "hoVaTen");
		String taiKhoan = ParamUtil.getString(actionRequest, "taiKhoan");
		String matKhau = ParamUtil.getString(actionRequest, "matKhau");
		String diaChi = ParamUtil.getString(actionRequest, "diaChi");
		String chungMinhThu = ParamUtil.getString(actionRequest, "chungMinhThu");
		String dienThoai = ParamUtil.getString(actionRequest, "dienThoai");
		int idNguoiTao = ParamUtil.getInteger(actionRequest, "userId");
		
		int capHoatDong = ParamUtil.getInteger(actionRequest, "capHoatDong");
		String maTinh = ParamUtil.getString(actionRequest, "maTinh");
		String maHuyen = ParamUtil.getString(actionRequest, "maHuyen");
		String maTram = ParamUtil.getString(actionRequest, "maTram");
		String imei = ParamUtil.getString(actionRequest, "imei");
		
		try {
			if(capHoatDong==1){
				KiemDemVienLocalServiceUtil.addKiemDemVien(hoVaTen, taiKhoan, matKhau, capHoatDong,
						maTinh, StringPool.BLANK, diaChi, chungMinhThu, dienThoai, imei, idNguoiTao);
			} else if(capHoatDong==2){
				KiemDemVienLocalServiceUtil.addKiemDemVien(hoVaTen, taiKhoan, matKhau, capHoatDong,
						maTinh, maHuyen, diaChi, chungMinhThu, dienThoai, imei, idNguoiTao);
			} else if(capHoatDong==3){
				KiemDemVienLocalServiceUtil.addKiemDemVien(hoVaTen, taiKhoan, matKhau, capHoatDong,
						maTinh, maTram, diaChi, chungMinhThu, dienThoai, imei, idNguoiTao);
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	public void deleteKiemDemVien(ActionRequest actionRequest, ActionResponse actionResponse){
		long id = ParamUtil.getLong(actionRequest, "id");
		
		try {
			KiemDemVienLocalServiceUtil.deleteKiemDemVien(id);
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	public void chuyenTrangThai(ActionRequest actionRequest, ActionResponse actionResponse){
		long id = ParamUtil.getLong(actionRequest, "id");
		
		try {
			KiemDemVienLocalServiceUtil.chuyenTrangThai(id);
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	public void editKiemDemVien(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException{
		long id = ParamUtil.getLong(actionRequest, "id");
		
		String hoVaTen = ParamUtil.getString(actionRequest, "hoVaTen");
		String taiKhoan = ParamUtil.getString(actionRequest, "taiKhoan");
		String matKhau = ParamUtil.getString(actionRequest, "matKhau");
		String diaChi = ParamUtil.getString(actionRequest, "diaChi");
		String chungMinhThu = ParamUtil.getString(actionRequest, "chungMinhThu");
		String dienThoai = ParamUtil.getString(actionRequest, "dienThoai");
		
		int capHoatDong = ParamUtil.getInteger(actionRequest, "capHoatDong");
		String maTinh = ParamUtil.getString(actionRequest, "maTinh");
		String maHuyen = ParamUtil.getString(actionRequest, "maHuyen");
		String maTram = ParamUtil.getString(actionRequest, "maTram");
		String imei = ParamUtil.getString(actionRequest, "imei");
		
		String orgCode1 = StringPool.BLANK;
		String orgCode2 = StringPool.BLANK;
		
		if(capHoatDong==1){
			orgCode1 = maTinh;
			orgCode2 = StringPool.BLANK;
			
		} else if(capHoatDong==2){
			orgCode1 = maTinh;
			orgCode2 = maHuyen;
			
		} else if(capHoatDong==3){
			orgCode1 = maTinh;
			orgCode2 = maTram;
		}
		
		KiemDemVien kiemDemVien = KiemDemVienLocalServiceUtil.getKiemDemVien(id);
		kiemDemVien.setHoVaTen(hoVaTen);
		kiemDemVien.setTaiKhoan(taiKhoan);
		kiemDemVien.setCapHoatDong(capHoatDong);
		kiemDemVien.setOrgCode1(orgCode1);
		kiemDemVien.setOrgCode2(orgCode2);
		kiemDemVien.setDiaChi(diaChi);
		kiemDemVien.setDienThoai(dienThoai);
		kiemDemVien.setChungMinhThu(chungMinhThu);
		kiemDemVien.setImei(imei);
		
		if(matKhau!=StringPool.BLANK){
			kiemDemVien.setMatKhau(matKhau);
		}
		
		try {
			KiemDemVienLocalServiceUtil.updateKiemDemVien(kiemDemVien);
		} catch (Exception e) {
			_log.error(e);
		}
	}
	private static final Log _log = LogFactoryUtil.getLog(KiemDemVienAction.class);
}