package vn.dtt.sol.ns.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import vn.dtt.cmon.kiemdemvien.action.KiemDemVienAction;
import vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien;
import vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class KiemDemVienPortlet extends MVCPortlet {
	
	public void addKiemDemVien(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		
		String hoVaTen = ParamUtil.getString(actionRequest, "hoVaTen");
		String taiKhoan = ParamUtil.getString(actionRequest, "taiKhoan");
		String diaChi = ParamUtil.getString(actionRequest, "diaChi");
		String chungMinhThu = ParamUtil.getString(actionRequest, "chungMinhThu");
		String dienThoai = ParamUtil.getString(actionRequest, "dienThoai");
		String imei = ParamUtil.getString(actionRequest, "imei");
		boolean check = false;
		
		try {
			List<KiemDemVien> listAll = KiemDemVienLocalServiceUtil.findAll();
			for(KiemDemVien kdv : listAll){
				if(taiKhoan.equals(kdv.getTaiKhoan())){
					check=true;
					break;
					
				} 
			}
		} catch (Exception e) {
			_log.error(e);
		}
		
		if (check==true){
			actionResponse.setRenderParameter("jspPage", "/html/portlet/kiemdemvien/add_kiemdemvien.jsp");
			actionResponse.setRenderParameter("hoVaTen", hoVaTen);
			actionResponse.setRenderParameter("taiKhoan", taiKhoan);
			actionResponse.setRenderParameter("diaChi", diaChi);
			actionResponse.setRenderParameter("chungMinhThu", chungMinhThu);
			actionResponse.setRenderParameter("dienThoai", dienThoai);
			actionResponse.setRenderParameter("imei", imei);
			
			SessionErrors.add(actionRequest, "tai-khoan-da-ton-tai");
			
		} else {
			
			try {
				
				KiemDemVienAction action = new KiemDemVienAction();
				action.addKiemDemVien(actionRequest, actionResponse);
				
			} catch (Exception e) {
				_log.error(e);
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			
			sendCustomRedirect(actionRequest, actionResponse);
		}
		
	}
	
	public void editKiemDemVien(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException{
		try {
			
			KiemDemVienAction action = new KiemDemVienAction();
			action.editKiemDemVien(actionRequest, actionResponse);
			
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		
		sendCustomRedirect(actionRequest, actionResponse);
	}

	public void deleteKiemDemVien(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException{
		try {
					
			KiemDemVienAction action = new KiemDemVienAction();
			action.deleteKiemDemVien(actionRequest, actionResponse);
			
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		
		sendCustomRedirect(actionRequest, actionResponse);
	}
	
	public void chuyenTrangThai(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException{
		try {
			
			KiemDemVienAction action = new KiemDemVienAction();
			action.chuyenTrangThai(actionRequest, actionResponse);
			
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		
		sendCustomRedirect(actionRequest, actionResponse);
	}
	
	public void search(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws IOException, PortalException, SystemException{

		String capHoatDong = ParamUtil.getString(actionRequest, "capHoatDong");
		String maTinh = ParamUtil.getString(actionRequest, "maTinh");
		String maHuyen = ParamUtil.getString(actionRequest, "maHuyen");
		String maTram = ParamUtil.getString(actionRequest, "maTram");
		String orgCode = StringPool.BLANK;
		
		if(capHoatDong.equals("1")){
			orgCode = maTinh;
		} else if(capHoatDong.equals("2")){
			orgCode = maHuyen;
		} else if(capHoatDong.equals("3")){
			orgCode = maTram;
		}
		
		System.out.println("orgCode="+orgCode);
		
		actionResponse.setRenderParameter("jspPage", "/html/portlet/kiemdemvien/view.jsp");
		actionResponse.setRenderParameter("capHoatDong", capHoatDong);
		actionResponse.setRenderParameter("maTinh", maTinh);
		actionResponse.setRenderParameter("orgCode", orgCode);
	
	}
	
	private void sendCustomRedirect(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {

		if (!SessionErrors.isEmpty(actionRequest)) {
			String errorURL = ParamUtil.getString(actionRequest, "onpageError");
			SessionMessages
					.add(actionRequest,
							PortalUtil.getPortletId(actionRequest)
									+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

			if (Validator.isNotNull(errorURL)) {
				actionResponse.sendRedirect(errorURL);
			}
		} else {
			String successURL = ParamUtil.getString(actionRequest, "onpageSuccess");
			SessionMessages
					.add(actionRequest,
							PortalUtil.getPortletId(actionRequest)
									+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

			if (Validator.isNotNull(successURL)) {
				actionResponse.sendRedirect(successURL);
			}
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(KiemDemVienPortlet.class);

}
