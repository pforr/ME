package vn.dtt.sol.ns.kehoachkiemdemnuoc.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.dtt.cmon.dm.dao.model.DATAITEM;
import vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil;
import vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien;
import vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalServiceUtil;
import vn.dtt.cmon.user.dao.model.UserMapping;
import vn.dtt.cmon.user.dao.model.impl.UserMappingImpl;
import vn.dtt.sol.ns.business.DataItemBusiness;
import vn.dtt.sol.ns.business.KiemDemVienBussiness;
import vn.dtt.sol.ns.business.UserMappingBusiness;
import vn.dtt.sol.ns.daunoinuoc.constant.DauNoiNuocConstantString;
import vn.dtt.sol.ns.daunoinuoc.terms.DauNoiNuocTerms;
import vn.dtt.sol.ns.kehoachkiemdemnuoc.terms.KeHoachKiemDemNuocTerms;
import vn.dtt.sol.ns.tramcap.business.KeHoachKiemDemNuocBusiness;
import vn.dtt.sol.ns.tramcap.business.TramCapBusiness;
import vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc;
import vn.dtt.sol.ns.tramcap.dao.model.KeHoachKiemDemNuoc;
import vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC;
import vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc;
import vn.dtt.sol.ns.tramcap.dao.model.impl.DauNoiNuocImpl;
import vn.dtt.sol.ns.tramcap.dao.model.impl.KeHoachKiemDemNuocImpl;
import vn.dtt.sol.ns.tramcap.dao.model.impl.THONGTINKIEMDEMNUOCImpl;
import vn.dtt.sol.ns.tramcap.dao.service.DauNoiNuocLocalServiceUtil;
import vn.dtt.sol.ns.tramcap.dao.service.KeHoachKiemDemNuocLocalServiceUtil;
import vn.dtt.sol.ns.tramcap.dao.service.THONGTINKIEMDEMNUOCLocalServiceUtil;
import vn.dtt.sol.ns.util.MessageErrors;
import vn.dtt.sol.ns.util.MessageSuccess;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.util.WebKeys;
import vn.dtt.sol.ns.vesinhmoitruong.business.KeHoachKiemDemVeSinhBussiness;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.KeHoachKiemDemVeSinh;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.VeSinhCongTrinhLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class KeHoachKiemDemNuocAction extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		User user = null;
		UserMapping loginUserMapping = new UserMappingImpl();
		String maTinh = ParamUtil.getString(renderRequest, DauNoiNuocTerms.MA_TINH);
		String maHuyen = ParamUtil.getString(renderRequest, DauNoiNuocTerms.MA_HUYEN);
		String maXa = ParamUtil.getString(renderRequest, DauNoiNuocTerms.MA_XA);
		String tramCapNuocId = ParamUtil.getString(renderRequest, KeHoachKiemDemNuocTerms.TRAM_CAP_NUOC_ID);
		String kiemDemVienId = ParamUtil.getString(renderRequest, KeHoachKiemDemNuocTerms.KIEM_DEM_VIEN_ID);
		String trangThai = ParamUtil.getString(renderRequest, "trangThai");
		String daKetThucDieuTra = ParamUtil.getString(renderRequest, "daKetThucDieuTra");
		String danhGiaKiemDem = ParamUtil.getString(renderRequest, "danhGiaKiemDem");
		String nguonDL = ParamUtil.getString(renderRequest, "nguonDL");
		List<DATAITEM> listTinh = new ArrayList<DATAITEM>();
		List<DATAITEM> listHuyen = new ArrayList<DATAITEM>();
		List<DATAITEM> listXa = new ArrayList<DATAITEM>();
		List<TramCapNuoc>  listTramCapNuoc = new ArrayList<TramCapNuoc>();
		List<KiemDemVien>  listKiemDemVien = new ArrayList<KiemDemVien>();
		 try {
			user = PortalUtil.getUser(renderRequest);
			loginUserMapping = UserMappingBusiness.getUserMapping(user);
			KeHoachKiemDemNuoc keHoachKiemDem = null;
			TramCapNuoc tramCapNuoc = null;
			int id = ParamUtil.getInteger(renderRequest, KeHoachKiemDemNuocTerms.ID);
			if(id>0){
				keHoachKiemDem = KeHoachKiemDemNuocBusiness.getKeHoachKiemDemNuocById(id);
				renderRequest.setAttribute("keHoachKiemDem", keHoachKiemDem);
			}
			if(loginUserMapping.getUserType()==DauNoiNuocConstantString.UserMapping.CAP_TU){
				listTinh = DATAITEMLocalServiceUtil.getByDataGroupLevel1(WebKeys.DATAGROUPID_DONVIHANHCHINH);
				if(Validator.isNotNull(maTinh)){
					listTramCapNuoc = TramCapBusiness.findTramCap(maTinh,QueryUtil.ALL_POS, QueryUtil.ALL_POS);
					listKiemDemVien = KiemDemVienBussiness.findByCapHoatDongOrgCode(String.valueOf(WebKeys.KDV_TOAN_TINH), maTinh);
				}else{
					listTramCapNuoc = TramCapBusiness.findTramCap(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
					listKiemDemVien = new ArrayList<KiemDemVien>();
				}
			}else if(loginUserMapping.getUserType()==DauNoiNuocConstantString.UserMapping.CAP_TINH){
				listTinh.add(NuocSachUtils.getDATAITEMTinh(loginUserMapping.getOrgCode1()));
				listTramCapNuoc = TramCapBusiness.getByTinh(loginUserMapping.getOrgCode1());
				listKiemDemVien = KiemDemVienBussiness.findByCapHoatDongOrgCode(String.valueOf(WebKeys.KDV_TOAN_TINH), loginUserMapping.getOrgCode1());
			}else if(loginUserMapping.getUserType()==DauNoiNuocConstantString.UserMapping.CAP_HUYEN){
				listTinh.add(NuocSachUtils.getDATAITEMTinh(loginUserMapping.getOrgCode1()));
				listTramCapNuoc = TramCapBusiness.getByTinh(loginUserMapping.getOrgCode1());
				listKiemDemVien = KiemDemVienBussiness.findByCapHoatDongOrgCode(String.valueOf(WebKeys.KDV_VSHUYEN), loginUserMapping.getOrgCode2());
			}else if(loginUserMapping.getUserType()==DauNoiNuocConstantString.UserMapping.CAP_TRAM){
				TramCapNuoc tramCapUser = null;
				tramCapUser = TramCapBusiness.getTramCap(Long.valueOf(loginUserMapping.getOrgCode2()));
				listTinh.add(NuocSachUtils.getDATAITEMTinh(tramCapUser.getMaTinh()));
				listTramCapNuoc.add(tramCapUser);
				listKiemDemVien = KiemDemVienBussiness.findByCapHoatDongOrgCode(String.valueOf(WebKeys.KDV_TRAMCAP), tramCapUser.getId()+"");
			}
			_log.info("loginUserMapping.getUserType()loginUserMapping.getUserType()"+loginUserMapping.getUserType());
			if(Validator.isNotNull(keHoachKiemDem)){
				tramCapNuoc = TramCapBusiness.getTramCap(keHoachKiemDem.getTramCapNuocId());
				if(Validator.isNotNull(tramCapNuoc)){
					renderRequest.setAttribute("tramCapNuoc", tramCapNuoc);
					maTinh = tramCapNuoc.getMaTinh();
					if(Validator.isNotNull(maTinh)){
						listHuyen = DataItemBusiness.getInLevel2(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh);
					}
					if(Validator.isNotNull(maHuyen)){
						listXa = DataItemBusiness.getInLevel3(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh, maHuyen);
					}
					listTramCapNuoc = new ArrayList<TramCapNuoc>();
					listTramCapNuoc.add(tramCapNuoc);
					listKiemDemVien = KiemDemVienBussiness.findByCapHoatDongOrgCode(String.valueOf(WebKeys.KDV_TOAN_TINH), maTinh);
					renderRequest.setAttribute("listHuyen", listHuyen);
					renderRequest.setAttribute("listXa", listXa);
					
				}
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		renderRequest.setAttribute(DauNoiNuocTerms.MA_TINH, maTinh);
		renderRequest.setAttribute(DauNoiNuocTerms.MA_HUYEN, maHuyen);
		renderRequest.setAttribute(DauNoiNuocTerms.MA_XA, maXa);
		renderRequest.setAttribute(KeHoachKiemDemNuocTerms.TRAM_CAP_NUOC_ID, tramCapNuocId);
		renderRequest.setAttribute(KeHoachKiemDemNuocTerms.KIEM_DEM_VIEN_ID, kiemDemVienId);
		renderRequest.setAttribute("trangThai", trangThai);
		renderRequest.setAttribute("daKetThucDieuTra", daKetThucDieuTra);
		renderRequest.setAttribute("danhGiaKiemDem", danhGiaKiemDem);
		renderRequest.setAttribute("nguonDL", nguonDL);
		renderRequest.setAttribute("loginUserMapping", loginUserMapping);
		renderRequest.setAttribute("listTinh", listTinh);
		renderRequest.setAttribute("listTramCapNuoc", listTramCapNuoc);
		renderRequest.setAttribute("listKiemDemVien", listKiemDemVien);
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
		User user = null;
		UserMapping loginUserMapping = new UserMappingImpl();
		String maTinh = ParamUtil.getString(request, DauNoiNuocTerms.MA_TINH);
		String maHuyen = ParamUtil.getString(request, DauNoiNuocTerms.MA_HUYEN);
		String maXa = ParamUtil.getString(request, DauNoiNuocTerms.MA_XA);
		String tramCapNuocId = ParamUtil.getString(request, KeHoachKiemDemNuocTerms.TRAM_CAP_NUOC_ID);
		String kiemDemVienId = ParamUtil.getString(request, KeHoachKiemDemNuocTerms.KIEM_DEM_VIEN_ID);
		String trangThai = ParamUtil.getString(request, "trangThai");
		String daKetThucDieuTra = ParamUtil.getString(request, "daKetThucDieuTra");
		String danhGiaKiemDem = ParamUtil.getString(request, "danhGiaKiemDem");
		String nguonDL = ParamUtil.getString(request, "nguonDL");
		List<DATAITEM> listTinh = new ArrayList<DATAITEM>();
		List<DATAITEM> listHuyen = new ArrayList<DATAITEM>();
		List<DATAITEM> listXa = new ArrayList<DATAITEM>();
		List<TramCapNuoc>  listTramCapNuoc = new ArrayList<TramCapNuoc>();
		List<KiemDemVien>  listKiemDemVien = new ArrayList<KiemDemVien>();
		 try {
			user = PortalUtil.getUser(request);
			loginUserMapping = UserMappingBusiness.getUserMapping(user);
			KeHoachKiemDemNuoc keHoachKiemDem = null;
			TramCapNuoc tramCapNuoc = null;
			int id = ParamUtil.getInteger(request, KeHoachKiemDemNuocTerms.ID);
			if(id>0){
				keHoachKiemDem = KeHoachKiemDemNuocBusiness.getKeHoachKiemDemNuocById(id);
				request.setAttribute("keHoachKiemDem", keHoachKiemDem);
				
			}
			if(loginUserMapping.getUserType()==DauNoiNuocConstantString.UserMapping.CAP_TU){
				listTinh = DATAITEMLocalServiceUtil.getByDataGroupLevel1(WebKeys.DATAGROUPID_DONVIHANHCHINH);
				if(Validator.isNotNull(maTinh)){
					listTramCapNuoc = TramCapBusiness.findTramCap(maTinh,QueryUtil.ALL_POS, QueryUtil.ALL_POS);
					if(Validator.isNotNull(tramCapNuocId)){
						listKiemDemVien = KiemDemVienBussiness.findByCapHoatDongOrgCode(String.valueOf(WebKeys.KDV_TRAMCAP), tramCapNuocId);
					}else{
						listKiemDemVien = KiemDemVienBussiness.findByCapHoatDongOrgCode(String.valueOf(WebKeys.KDV_TOAN_TINH), maTinh);
					}
					
				}else{
					listTramCapNuoc = TramCapBusiness.findTramCap(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
					listKiemDemVien = new ArrayList<KiemDemVien>();
				}
			}else if(loginUserMapping.getUserType()==DauNoiNuocConstantString.UserMapping.CAP_TINH){
				listTinh.add(NuocSachUtils.getDATAITEMTinh(loginUserMapping.getOrgCode1()));
				listTramCapNuoc = TramCapBusiness.getByTinh(loginUserMapping.getOrgCode1());
				if(Validator.isNotNull(tramCapNuocId)){
					listKiemDemVien = KiemDemVienBussiness.findByCapHoatDongOrgCode(String.valueOf(WebKeys.KDV_TRAMCAP), tramCapNuocId);
				}else{
					listKiemDemVien = KiemDemVienBussiness.findByCapHoatDongOrgCode(String.valueOf(WebKeys.KDV_TOAN_TINH), loginUserMapping.getOrgCode1());
				}
				
			}else if(loginUserMapping.getUserType()==DauNoiNuocConstantString.UserMapping.CAP_HUYEN){
				listTinh.add(NuocSachUtils.getDATAITEMTinh(loginUserMapping.getOrgCode1()));
				listTramCapNuoc = TramCapBusiness.getByTinh(loginUserMapping.getOrgCode1());
				if(Validator.isNotNull(tramCapNuocId)){
					listKiemDemVien = KiemDemVienBussiness.findByCapHoatDongOrgCode(String.valueOf(WebKeys.KDV_TRAMCAP), tramCapNuocId);
				}else{
					listKiemDemVien = KiemDemVienBussiness.findByCapHoatDongOrgCode(String.valueOf(WebKeys.KDV_VSHUYEN), loginUserMapping.getOrgCode2());
				}
				
			}else if(loginUserMapping.getUserType()==DauNoiNuocConstantString.UserMapping.CAP_TRAM){
				TramCapNuoc tramCapUser = null;
				tramCapUser = TramCapBusiness.getTramCap(Long.valueOf(loginUserMapping.getOrgCode2()));
				listTinh.add(NuocSachUtils.getDATAITEMTinh(tramCapUser.getMaTinh()));
				listTramCapNuoc.add(tramCapUser);
				listKiemDemVien = KiemDemVienBussiness.findByCapHoatDongOrgCode(String.valueOf(WebKeys.KDV_TRAMCAP), tramCapUser.getId()+"");
			}
			if(Validator.isNotNull(keHoachKiemDem)){
				tramCapNuoc = TramCapBusiness.getTramCap(keHoachKiemDem.getTramCapNuocId());
				if(Validator.isNotNull(tramCapNuoc)){
					request.setAttribute("tramCapNuoc", tramCapNuoc);
					maTinh = tramCapNuoc.getMaTinh();
					if(Validator.isNotNull(maTinh)){
						listHuyen = DataItemBusiness.getInLevel2(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh);
					}
					if(Validator.isNotNull(maHuyen)){
						listXa = DataItemBusiness.getInLevel3(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh, maHuyen);
					}
					listTramCapNuoc = new ArrayList<TramCapNuoc>();
					listTramCapNuoc.add(tramCapNuoc);
					listKiemDemVien = KiemDemVienBussiness.findByCapHoatDongOrgCode(String.valueOf(WebKeys.KDV_VSHUYEN), tramCapNuoc.getMaHuyen());
					request.setAttribute("listHuyen", listHuyen);
					request.setAttribute("listXa", listXa);
				}
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute(DauNoiNuocTerms.MA_TINH, maTinh);
		request.setAttribute(DauNoiNuocTerms.MA_HUYEN, maHuyen);
		request.setAttribute(DauNoiNuocTerms.MA_XA, maXa);
		request.setAttribute(KeHoachKiemDemNuocTerms.TRAM_CAP_NUOC_ID, tramCapNuocId);
		request.setAttribute(KeHoachKiemDemNuocTerms.KIEM_DEM_VIEN_ID, kiemDemVienId);
		request.setAttribute("trangThai", trangThai);
		request.setAttribute("daKetThucDieuTra", daKetThucDieuTra);
		request.setAttribute("danhGiaKiemDem", danhGiaKiemDem);
		request.setAttribute("nguonDL", nguonDL);
		request.setAttribute("loginUserMapping", loginUserMapping);
		request.setAttribute("listTinh", listTinh);
		request.setAttribute("listTramCapNuoc", listTramCapNuoc);
		request.setAttribute("listKiemDemVien", listKiemDemVien);
		super.render(request, response);
	}
	
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String key=ParamUtil.getString(resourceRequest, "keyExport");
		int idKeHoach = ParamUtil.getInteger(resourceRequest, KeHoachKiemDemNuocTerms.ID);
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		HttpServletResponse respon = PortalUtil.getHttpServletResponse(resourceResponse);
		if(key.equalsIgnoreCase("export_csv_kehoachkiemdemnuoc")){
//			CSV_KeHoachExport.writeCsvFile(resourceRequest,resourceResponse);
			xuatBankeHoachKiemDem(resourceRequest,resourceResponse,idKeHoach);
		}
		
	}
	private void xuatBankeHoachKiemDem(ResourceRequest resourceRequest,ResourceResponse resourceResponse,int idKeHoach){
		KeHoachKiemDemNuoc keHoachKiemDemNuoc = new KeHoachKiemDemNuocImpl();
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		HttpServletResponse respon = PortalUtil.getHttpServletResponse(resourceResponse);
		try {
			keHoachKiemDemNuoc = KeHoachKiemDemNuocLocalServiceUtil.fetchKeHoachKiemDemNuoc(idKeHoach);
			if(Validator.isNotNull(keHoachKiemDemNuoc)){
				keHoachKiemDemNuoc.setNgayXuatBan(new Date());
			}
			KeHoachKiemDemNuocLocalServiceUtil.updateKeHoachKiemDemNuoc(keHoachKiemDemNuoc);
			SessionMessages.add(request, MessageSuccess.XUAT_BAN_KE_HOACH_KIEM_DEM_MESSAGE);
			String successURL = ParamUtil.getString(resourceRequest, "onpageSuccess");
			_log.info("successURL"+successURL);
			respon.sendRedirect(successURL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			SessionErrors.add(request, MessageErrors.XUAT_BAN_KE_HOACH_KIEM_DEM_MESSAGE);
		}
	}
	public void xuatBankeHoachKiemDem(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		KeHoachKiemDemNuoc keHoachKiemDemNuoc = new KeHoachKiemDemNuocImpl();
		try {
			int idKeHoach = ParamUtil.getInteger(actionRequest, KeHoachKiemDemNuocTerms.ID);
			keHoachKiemDemNuoc = KeHoachKiemDemNuocLocalServiceUtil.fetchKeHoachKiemDemNuoc(idKeHoach);
			if(Validator.isNotNull(keHoachKiemDemNuoc)){
				keHoachKiemDemNuoc.setNgayXuatBan(new Date());
			}
			KeHoachKiemDemNuocLocalServiceUtil.updateKeHoachKiemDemNuoc(keHoachKiemDemNuoc);
			SessionMessages.add(actionRequest, MessageSuccess.XUAT_BAN_KE_HOACH_KIEM_DEM_MESSAGE);
			String successURL = ParamUtil.getString(actionRequest, "onpageSuccess");
			_log.info("successURL"+successURL);
			actionResponse.sendRedirect(successURL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			SessionErrors.add(actionRequest, MessageErrors.XUAT_BAN_KE_HOACH_KIEM_DEM_MESSAGE);
		}
	}
	public void dongkeHoachKiemDem(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		boolean isSuccess = false;
		String messageKey = MessageErrors.DONG_KE_HOACH_KIEM_DEM_MESSAGE;
		long userId = PortalUtil.getUserId(actionRequest);
		int id = 0;
		try {
			id = ParamUtil.getInteger(actionRequest, KeHoachKiemDemNuocTerms.ID);
			KeHoachKiemDemNuoc keHoachKiemDemNuoc = new KeHoachKiemDemNuocImpl();
			_log.info("sadfasdfsadfasdfasdfasdfsadf"+id);
			if(id>0){
				keHoachKiemDemNuoc = KeHoachKiemDemNuocLocalServiceUtil.fetchKeHoachKiemDemNuoc(id);
				messageKey = MessageSuccess.DONG_KE_HOACH_KIEM_DEM_MESSAGE;
				_log.info("keHoachKiemDemNuoc"+keHoachKiemDemNuoc);
			
				
			keHoachKiemDemNuoc.setNgayDong(new Date());
			keHoachKiemDemNuoc.setIdNguoiDong(Integer.valueOf(userId+""));
//			//update 
			KeHoachKiemDemNuocLocalServiceUtil.updateKeHoachKiemDemNuoc(keHoachKiemDemNuoc);
//			
			List<THONGTINKIEMDEMNUOC> listTt = new ArrayList<THONGTINKIEMDEMNUOC>();
			listTt = THONGTINKIEMDEMNUOCLocalServiceUtil.getListBykeHoachKiemDemNuocId(keHoachKiemDemNuoc.getId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
//			
			for (THONGTINKIEMDEMNUOC thongtinkiemdemnuoc : listTt) {
				updateStatusDauNoi(thongtinkiemdemnuoc,2);
			}
//			actionResponse.sendRedirect(cuString);
			isSuccess = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(e);
			isSuccess = false;
				messageKey = MessageErrors.DONG_KE_HOACH_KIEM_DEM_MESSAGE;
		}
//		
		if(isSuccess){
			SessionMessages.add(actionRequest, messageKey);
		}else{
			SessionErrors.add(actionRequest, messageKey);
		}
	}
	
	private void updateStatusDauNoi(THONGTINKIEMDEMNUOC thongtinkiemdemnuoc, int type) throws SystemException {
		// TODO Auto-generated method stub
		DauNoiNuoc ettUpdate = new DauNoiNuocImpl();
		ettUpdate = DauNoiNuocLocalServiceUtil.fetchDauNoiNuoc(thongtinkiemdemnuoc.getDauNoiNuocId());
//		_log.info("Validator.isNotNull(ettUpdate)"+Validator.isNotNull(ettUpdate));
//		if(Validator.isNotNull(ettUpdate)){
//		int year = 2013;
//	    int month = 0; // January
//	    int date = 1;
//	    
//	    Calendar cal = Calendar.getInstance();
//	    cal.clear();
//
//	    cal.set(Calendar.YEAR, year);
//	    cal.set(Calendar.MONTH, month);
//	    cal.set(Calendar.DATE, date);
//	    
//	    int numberOfMonth = 1;
//	    Calendar cal1 = Calendar.getInstance();
//	    Calendar cal2 = Calendar.getInstance();
//	    if(Validator.isNotNull(thongtinkiemdemnuoc.getThoiGianDauNoiThucTe())){
//		    cal2.setTime(new Date());
//		    cal1.setTime(thongtinkiemdemnuoc.getThoiGianDauNoiThucTe());
//		    _log.info("cal1"+cal1 + " cal2 "+cal2);
//		    numberOfMonth = cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH);
//	    }else{
//	    	numberOfMonth=1;
//	    }
//	    _log.info("numberOfMonthnumberOfMonthnumberOfMonthnumberOfMonth "+numberOfMonth);
//	    int sumCou = 20;
//	    sumCou = (((thongtinkiemdemnuoc.getSoLanMatNuoc()/numberOfMonth)*thongtinkiemdemnuoc.getSoGioTrungBinh())/(30*24))*100;
//		if(thongtinkiemdemnuoc.getDaKetThucDieuTra() == 0){
//			ettUpdate.setTrangThai(4);
//		}else{
//			ettUpdate.setSoNguoiTrongHo(thongtinkiemdemnuoc.getSoNguoiTrongHo());
//			 ettUpdate.setThanhPhanHoGiaDinh(thongtinkiemdemnuoc.getThanhPhanHoGd());
//			 ettUpdate.setKinhDo(thongtinkiemdemnuoc.getKinhDo());
//			 ettUpdate.setViDo(thongtinkiemdemnuoc.getViDo());
//			 ettUpdate.setNgayDauNoiThucTe(thongtinkiemdemnuoc.getThoiGianDauNoiThucTe());
//			 ettUpdate.setSoSeryDongHo(thongtinkiemdemnuoc.getSoSeRyDongHo());
//			 ettUpdate.setDanhGiaNuocHVS(thongtinkiemdemnuoc.getNuocTrongKhong()==1?"C\u00F3":"Kh\u00F4ng");
//			 ettUpdate.setNgayKiemDem(thongtinkiemdemnuoc.getNgayKiemDem());
//			 if(thongtinkiemdemnuoc.getThoiGianDauNoiThucTe().before(cal.getTime())
//					&& thongtinkiemdemnuoc.getVoiNuocChayKhong()==1
//					&& thongtinkiemdemnuoc.getNuocTrongKhong()==1
//					&& thongtinkiemdemnuoc.getDaTungDucKhong()==1
//					&& thongtinkiemdemnuoc.getDauNoiChua()==1
//					&& thongtinkiemdemnuoc.getCoBeChuaNuoc()==1
//					&& thongtinkiemdemnuoc.getTinhTrangBe()==1
//					&& sumCou <= 10){
//				 
//				 ettUpdate.setTrangThai(2);
//			 }else{
//				 ettUpdate.setTrangThai(3);
//			 }
//		}
		if(thongtinkiemdemnuoc.getDanhGiaKiemDem() == 0){
			ettUpdate.setTrangThai(0);
		}else if(thongtinkiemdemnuoc.getDanhGiaKiemDem() == 1){	
			ettUpdate.setTrangThai(2);
		}else if(thongtinkiemdemnuoc.getDanhGiaKiemDem() == 2){
			ettUpdate.setTrangThai(3);
		}
		if(thongtinkiemdemnuoc.getDanhGiaKiemDem() == 0){
			thongtinkiemdemnuoc.setDaKetThucDieuTra(3);
		}
		if(thongtinkiemdemnuoc.getDaKetThucDieuTra() == 3){
			if(type == 1){
				ettUpdate.setTrangThai(0);
			}else{
				ettUpdate.setTrangThai(8);
			}
			
		}
		ettUpdate.setNgayDauNoiThucTe(thongtinkiemdemnuoc.getThoiGianDauNoiThucTe());
		ettUpdate.setNgayKiemDem(thongtinkiemdemnuoc.getNgayKiemDem());
		if(Validator.isNotNull(thongtinkiemdemnuoc.getSoSeRyDongHo())){
			ettUpdate.setSoSeryDongHo(thongtinkiemdemnuoc.getSoSeRyDongHo());
		}
		ettUpdate.setKinhDo(thongtinkiemdemnuoc.getKinhDo());
		ettUpdate.setViDo(thongtinkiemdemnuoc.getViDo());
		ettUpdate.setSoNguoiTrongHo(thongtinkiemdemnuoc.getSoNguoiTrongHo());
		THONGTINKIEMDEMNUOCLocalServiceUtil.updateTHONGTINKIEMDEMNUOC(thongtinkiemdemnuoc);
		DauNoiNuocLocalServiceUtil.updateDauNoiNuoc(ettUpdate);
//		}
	}
	
	public void addkeHoachKiemDem(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		boolean isSuccess = false;
		String messageKey = MessageErrors.ADD_KE_HOACH_KIEM_DEM_MESSAGE;
		long idReturn = 0;
		KeHoachKiemDemNuocTerms keHoachKiemDemNuocTerm = new KeHoachKiemDemNuocTerms(actionRequest);
		String add = "";
		add = ParamUtil.getString(actionRequest, Constants.CMD);
		long userId = PortalUtil.getUserId(actionRequest);
		try {
			Date fromDate = keHoachKiemDemNuocTerm.getNgayBatDau();
			Date toDate = keHoachKiemDemNuocTerm.getNgayKetThuc();
			_log.info("fromDate"+fromDate + "toDate"+toDate);
			_log.info("fromDate.before(toDate)"+fromDate.before(toDate));
			_log.info("fromDate.after(toDate)"+fromDate.after(toDate));
			if(fromDate.before(toDate)){
			KeHoachKiemDemNuoc keHoachKiemDemNuoc = new KeHoachKiemDemNuocImpl();
			if (add.equals(Constants.ADD)) {
				long id = 0;
				id = CounterLocalServiceUtil.increment(KeHoachKiemDemNuoc.class.getName());
				keHoachKiemDemNuoc = KeHoachKiemDemNuocLocalServiceUtil.createKeHoachKiemDemNuoc(Integer.valueOf(id+""));
				keHoachKiemDemNuoc.setIdNguoiTao(Integer.valueOf(String.valueOf(userId)));
				int year = Calendar.getInstance().get(Calendar.YEAR);
				keHoachKiemDemNuoc.setNam(year);
				keHoachKiemDemNuoc.setNgayXuatBan(null);
				keHoachKiemDemNuoc.setNgayDong(null);
				messageKey = MessageSuccess.ADD_KE_HOACH_KIEM_DEM_MESSAGE;
				idReturn = id;
			} else {
				keHoachKiemDemNuoc = KeHoachKiemDemNuocLocalServiceUtil.fetchKeHoachKiemDemNuoc(keHoachKiemDemNuocTerm.getId());
				messageKey = MessageSuccess.EDIT_KE_HOACH_KIEM_DEM_MESSAGE;
				idReturn=keHoachKiemDemNuocTerm.getId();
			}
			
			keHoachKiemDemNuoc.setTramCapNuocId(keHoachKiemDemNuocTerm.getTramCapNuocId());
			keHoachKiemDemNuoc.setKiemDemVienId(keHoachKiemDemNuocTerm.getKiemDemVienId());
			keHoachKiemDemNuoc.setNgayBatDau(keHoachKiemDemNuocTerm.getNgayBatDau());
			keHoachKiemDemNuoc.setNgayKetThuc(keHoachKiemDemNuocTerm.getNgayKetThuc());
			keHoachKiemDemNuoc.setMoTa(keHoachKiemDemNuocTerm.getMoTa());
			
			//update 
			KeHoachKiemDemNuocLocalServiceUtil.updateKeHoachKiemDemNuoc(keHoachKiemDemNuoc);
//			actionResponse.sendRedirect(cuString);
			isSuccess = true;
			
			}else{
				// Hide default Success Message
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

				// Hide default Error Message
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				messageKey = MessageErrors.ERROR_NGAY_THANG;
				isSuccess = false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(e);
			if (add.equals(Constants.ADD)) {
				messageKey = MessageErrors.ADD_KE_HOACH_KIEM_DEM_MESSAGE;
			}else{
				messageKey = MessageErrors.EDIT_KE_HOACH_KIEM_DEM_MESSAGE;
			}
		}
		sendCustomRedirect(idReturn,isSuccess,messageKey,actionRequest, actionResponse);
	}
	
	public void addDanhGiaLai(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		DauNoiNuocTerms dauNoiNuocTerm = new DauNoiNuocTerms(actionRequest);
		String cuString = ParamUtil.getString(actionRequest, "currentURL");
		String add = "";
		add = ParamUtil.getString(actionRequest, Constants.CMD);
		try {
			DauNoiNuoc dauNoiNuocEtt = new DauNoiNuocImpl();
			if (add.equals(Constants.ADD)) {
			} else {
				dauNoiNuocEtt = DauNoiNuocLocalServiceUtil.fetchDauNoiNuoc(dauNoiNuocTerm.getId());
			}
			dauNoiNuocEtt.setSoNguoiTrongHo(dauNoiNuocTerm.getSoNguoiTrongHo());
			dauNoiNuocEtt.setThanhPhanHoGiaDinh(dauNoiNuocTerm.getThanhPhanHoGiaDinh());
			dauNoiNuocEtt.setDanhGiaNuocHVS(dauNoiNuocTerm.getDanhGiaNuocHVS());
			dauNoiNuocEtt.setSoSeryDongHo(dauNoiNuocTerm.getSoSeryDongHo());
			dauNoiNuocEtt.setNgayDauNoiThucTe(dauNoiNuocTerm.getNgayDauNoiThucTe());
			dauNoiNuocEtt.setTrangThai(dauNoiNuocTerm.getTrangThai());
			//update 
			DauNoiNuocLocalServiceUtil.updateDauNoiNuoc(dauNoiNuocEtt);
			actionResponse.sendRedirect(cuString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteKeHoachKiemDem(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		boolean isSuccess = false;
		String messageKey = MessageErrors.ADD_KE_HOACH_KIEM_DEM_MESSAGE;
		long idReturn = 0;
		long userId = PortalUtil.getUserId(actionRequest);
		KeHoachKiemDemNuocTerms keHoachKiemDemNuocTerms = new KeHoachKiemDemNuocTerms(actionRequest);
		try {
			int id = keHoachKiemDemNuocTerms.getId();
			//cap nhat trang thai
			KeHoachKiemDemNuoc keHoachKiemDemNuoc = new KeHoachKiemDemNuocImpl();
			if(id>0){
				keHoachKiemDemNuoc = KeHoachKiemDemNuocLocalServiceUtil.fetchKeHoachKiemDemNuoc(id);
			keHoachKiemDemNuoc.setNgayDong(new Date());
			keHoachKiemDemNuoc.setIdNguoiDong(Integer.valueOf(userId+""));
//			//update 
			KeHoachKiemDemNuocLocalServiceUtil.updateKeHoachKiemDemNuoc(keHoachKiemDemNuoc);
//			
			List<THONGTINKIEMDEMNUOC> listTt = new ArrayList<THONGTINKIEMDEMNUOC>();
			listTt = THONGTINKIEMDEMNUOCLocalServiceUtil.getListBykeHoachKiemDemNuocId(keHoachKiemDemNuoc.getId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
//			
			for (THONGTINKIEMDEMNUOC thongtinkiemdemnuoc : listTt) {
				updateStatusDauNoi(thongtinkiemdemnuoc,1);
			}
			//
			KeHoachKiemDemNuocLocalServiceUtil.deleteKeHoachKiemDemNuoc(id);
			messageKey = MessageSuccess.XOA_KE_HOACH_KIEM_DEM_MESSAGE;
			isSuccess = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			_log.error(e);
			messageKey = MessageErrors.XOA_KE_HOACH_KIEM_DEM_MESSAGE;
		}
		sendCustomRedirect(idReturn,isSuccess,messageKey,actionRequest, actionResponse);
	}
	
	public void themAllDauNoiToKeHoachKieDemNuoc(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		boolean isSuccess = false;
		String messageKey = MessageErrors.THEM_DAU_NOI_VAO_KE_HOACH_MESSAGE;
		long idReturn = 0;
		KeHoachKiemDemNuocTerms keHoachKiemDemNuocTerm = new KeHoachKiemDemNuocTerms(actionRequest);
		String add = "";
		try {
		List<DauNoiNuoc> listDauNoiByOrgId = new ArrayList<DauNoiNuoc>();
		idReturn = keHoachKiemDemNuocTerm.getId();
		TramCapNuoc ettTramCap = null;
		ettTramCap = TramCapBusiness.getTramCap(keHoachKiemDemNuocTerm.getTramCapNuocId());
		_log.info(ettTramCap.getMaTinh()+"//"+ettTramCap.getMaHuyen()+"//"+ettTramCap.getMaXa()+"//"+ettTramCap.getId());
		listDauNoiByOrgId = DauNoiNuocLocalServiceUtil.getDauNoiSearch(ettTramCap.getMaTinh(), "", "", ettTramCap.getId()+"", "0", "9999",QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		doInsertDauNoiNuocToKeHoach(listDauNoiByOrgId,idReturn);
		messageKey = MessageSuccess.THEM_DAU_NOI_VAO_KE_HOACH_MESSAGE;
		isSuccess = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(e);
				messageKey = MessageErrors.THEM_DAU_NOI_VAO_KE_HOACH_MESSAGE;
		}
		sendCustomRedirect(idReturn,isSuccess,messageKey,actionRequest, actionResponse);
	}
	public void themDauNoiToKeHoachKieDemNuocDauNoiId(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		boolean isSuccess = false;
		String messageKey = MessageErrors.THEM_DAU_NOI_VAO_KE_HOACH_MESSAGE;
		long idReturn = 0;
		String add = "";
		try {
			long[] orgIds = StringUtil.split(
	                ParamUtil.getString(actionRequest, "orgIds"), 0L);
		 long maDotBaoCao = ParamUtil.getLong(actionRequest, "maKeHoachKiemDem");
		 int trangThai = ParamUtil.getInteger(actionRequest, "trangThai");
		 List<DauNoiNuoc> listDauNoiByOrgId = new ArrayList<DauNoiNuoc>();
		 idReturn = maDotBaoCao;
		 DauNoiNuoc ettDauNoi = null;
		 for (long l : orgIds) {
			 ettDauNoi = DauNoiNuocLocalServiceUtil.fetchDauNoiNuoc(l);
			 if(trangThai == 1){
				 listDauNoiByOrgId.add(DauNoiNuocLocalServiceUtil.fetchDauNoiNuoc(l));
			 }else if(Validator.isNotNull(ettDauNoi) && ( ettDauNoi.getTrangThai() == 0 || ettDauNoi.getTrangThai() == 8)){
				 listDauNoiByOrgId.add(DauNoiNuocLocalServiceUtil.fetchDauNoiNuoc(l));
			 }
		}
		 doInsertDauNoiNuocToKeHoach(listDauNoiByOrgId,idReturn);
		 messageKey = MessageSuccess.THEM_DAU_NOI_VAO_KE_HOACH_MESSAGE;
			isSuccess = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(e);
				messageKey = MessageErrors.THEM_DAU_NOI_VAO_KE_HOACH_MESSAGE;
		}
		sendCustomRedirect(idReturn,isSuccess,messageKey,actionRequest, actionResponse);
	}
	private void doInsertDauNoiNuocToKeHoach(List<DauNoiNuoc> listDauNoiByOrgId, long keHoachId) throws SystemException {
		// TODO Auto-generated method stub
		THONGTINKIEMDEMNUOC ettInsert = new THONGTINKIEMDEMNUOCImpl();
		KeHoachKiemDemNuoc keHoach = null;
		keHoach = KeHoachKiemDemNuocLocalServiceUtil.fetchKeHoachKiemDemNuoc(Integer.valueOf(keHoachId+""));
		KiemDemVien kiemDemVien = null;
		String taiKhoan = StringPool.BLANK;
		if(Validator.isNotNull(keHoach)){
			if(Validator.isNotNull(keHoach.getKiemDemVienId())){
				kiemDemVien = KiemDemVienLocalServiceUtil.fetchKiemDemVien(keHoach.getKiemDemVienId());
				taiKhoan = Validator.isNotNull(kiemDemVien)?kiemDemVien.getTaiKhoan():StringPool.BLANK;
			}
		}
		
		for (DauNoiNuoc dauNoiNuoc : listDauNoiByOrgId) {
			dauNoiNuoc.setTrangThai(1);
			DauNoiNuocLocalServiceUtil.updateDauNoiNuoc(dauNoiNuoc);
			ettInsert = new THONGTINKIEMDEMNUOCImpl();
			long id=0;
			id = CounterLocalServiceUtil.increment(THONGTINKIEMDEMNUOC.class.getName());
			ettInsert = THONGTINKIEMDEMNUOCLocalServiceUtil.createTHONGTINKIEMDEMNUOC(id);
			ettInsert.setDauNoiNuocId(dauNoiNuoc.getId());
			ettInsert.setKeHoachKiemDemNuocId(Integer.valueOf(keHoachId+""));
			ettInsert.setMaTinh(dauNoiNuoc.getMaTinh());
			ettInsert.setMaHuyen(dauNoiNuoc.getMaHuyen());
			ettInsert.setMaXa(dauNoiNuoc.getMaXa());
			ettInsert.setThonXom(dauNoiNuoc.getThonXom());
			ettInsert.setTenChuHo(dauNoiNuoc.getTenChuHo());
			ettInsert.setGioiTinhChuHo(dauNoiNuoc.getGioiTinh());
			ettInsert.setThoiGianDauHopDong(dauNoiNuoc.getNgayDauNoiHopDong());
			ettInsert.setDanhGiaKiemDem(0);
			ettInsert.setTaiKhoan(taiKhoan);
			//
			ettInsert.setSoSeRyDongHo(dauNoiNuoc.getSoSeryDongHo());
			ettInsert.setSoNguoiTrongHo(dauNoiNuoc.getSoNguoiTrongHo());
			ettInsert.setThanhPhanHoGd(dauNoiNuoc.getThanhPhanHoGiaDinh());
			ettInsert.setThoiGianDauNoiThucTe(dauNoiNuoc.getNgayDauNoiThucTe());
			
			THONGTINKIEMDEMNUOCLocalServiceUtil.updateTHONGTINKIEMDEMNUOC(ettInsert);
			
			
		}
	}
	public void  phanCongLaiKeHoachKieDemNuocHuyBo(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		boolean isSuccess = false;
		String messageKey = MessageErrors.PHAN_CONG_LAI_DAU_NOI_MESSAGE;
		long idReturn = 0;
		try {
			long[] orgIds = StringUtil.split(
	                ParamUtil.getString(actionRequest, "orgIds"), 0L);
		 long maDotBaoCao = ParamUtil.getLong(actionRequest, "maKeHoachKiemDem");
		 idReturn = maDotBaoCao;
		 DauNoiNuoc ettRevert = null;
		 THONGTINKIEMDEMNUOC ettThongTin = null;
		 	for (long l : orgIds) {
		 		ettThongTin = THONGTINKIEMDEMNUOCLocalServiceUtil.fetchTHONGTINKIEMDEMNUOC(l);
				_log.info("*****"+l);
				ettRevert = new DauNoiNuocImpl();
				if(Validator.isNotNull(ettThongTin)){
					ettRevert = DauNoiNuocLocalServiceUtil.fetchDauNoiNuoc(ettThongTin.getDauNoiNuocId());
					ettRevert.setTrangThai(0);
					DauNoiNuocLocalServiceUtil.updateDauNoiNuoc(ettRevert);
				}
				ettThongTin.setDaKetThucDieuTra(3);
				THONGTINKIEMDEMNUOCLocalServiceUtil.updateTHONGTINKIEMDEMNUOC(ettThongTin);
			}
		 	messageKey = MessageSuccess.PHAN_CONG_LAI_DAU_NOI_MESSAGE;
			isSuccess = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(e);
				messageKey = MessageErrors.PHAN_CONG_LAI_DAU_NOI_MESSAGE;
		}
		sendCustomRedirect(idReturn,isSuccess,messageKey,actionRequest, actionResponse);
	}
	
	public void  phanCongLaiKeHoachKieDemNuoc(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		boolean isSuccess = false;
		String messageKey = MessageErrors.PHAN_CONG_LAI_DAU_NOI_MESSAGE;
		long idReturn = 0;
		try {
			long[] orgIds = StringUtil.split(
	                ParamUtil.getString(actionRequest, "orgIds"), 0L);
		 long maDotBaoCao = ParamUtil.getLong(actionRequest, "maKeHoachKiemDem");
		 idReturn = maDotBaoCao;
		 DauNoiNuoc ettRevert = null;
		 THONGTINKIEMDEMNUOC ettThongTin = null;
		 	for (long l : orgIds) {
		 		ettThongTin = THONGTINKIEMDEMNUOCLocalServiceUtil.fetchTHONGTINKIEMDEMNUOC(l);
				_log.info("*****"+l);
				ettRevert = new DauNoiNuocImpl();
				if(Validator.isNotNull(ettThongTin)){
					ettRevert = DauNoiNuocLocalServiceUtil.fetchDauNoiNuoc(ettThongTin.getDauNoiNuocId());
					ettRevert.setTrangThai(0);
					DauNoiNuocLocalServiceUtil.updateDauNoiNuoc(ettRevert);
				}
				
				THONGTINKIEMDEMNUOCLocalServiceUtil.deleteTHONGTINKIEMDEMNUOC(l);
			}
		 	messageKey = MessageSuccess.PHAN_CONG_LAI_DAU_NOI_MESSAGE;
			isSuccess = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(e);
				messageKey = MessageErrors.PHAN_CONG_LAI_DAU_NOI_MESSAGE;
		}
		sendCustomRedirect(idReturn,isSuccess,messageKey,actionRequest, actionResponse);
	}
	//redirect 
	private void sendCustomRedirect(long id,boolean isSuccess,String messageKey,ActionRequest actionRequest, ActionResponse actionResponse) throws IOException{
		if(isSuccess){
//			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			String successURL = ParamUtil.getString(actionRequest, "onpageSuccess");
			successURL+="&"+actionResponse.getNamespace()+"maTinh="+ParamUtil.getString(actionRequest, "maTinh");
			successURL+="&"+actionResponse.getNamespace()+KeHoachKiemDemNuocTerms.TRAM_CAP_NUOC_ID+"="+ParamUtil.getString(actionRequest, KeHoachKiemDemNuocTerms.TRAM_CAP_NUOC_ID);
			successURL+="&"+actionResponse.getNamespace()+KeHoachKiemDemNuocTerms.KIEM_DEM_VIEN_ID+"="+ParamUtil.getString(actionRequest, KeHoachKiemDemNuocTerms.KIEM_DEM_VIEN_ID);
			successURL+="&"+actionResponse.getNamespace()+"trangThai="+ParamUtil.getString(actionRequest, "trangThai");
			successURL+="&"+actionResponse.getNamespace()+"orgcode="+ParamUtil.getString(actionRequest, "orgcode");
			if(id>0){
				successURL+="&"+actionResponse.getNamespace()+DauNoiNuocTerms.ID+"="+id;
			}
			SessionMessages.add(actionRequest, messageKey);
			if (Validator.isNotNull(successURL)) {
				actionResponse.sendRedirect(successURL);
			}
		}else{
//			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);	
			String errorURL = ParamUtil.getString(actionRequest, "onpageError");
			errorURL+="&"+actionResponse.getNamespace()+"maTinh="+ParamUtil.getString(actionRequest, "maTinh");
			errorURL+="&"+actionResponse.getNamespace()+KeHoachKiemDemNuocTerms.TRAM_CAP_NUOC_ID+"="+ParamUtil.getString(actionRequest, KeHoachKiemDemNuocTerms.TRAM_CAP_NUOC_ID);
			errorURL+="&"+actionResponse.getNamespace()+KeHoachKiemDemNuocTerms.KIEM_DEM_VIEN_ID+"="+ParamUtil.getString(actionRequest, KeHoachKiemDemNuocTerms.KIEM_DEM_VIEN_ID);
			errorURL+="&"+actionResponse.getNamespace()+"trangThai="+ParamUtil.getString(actionRequest, "trangThai");
			errorURL+="&"+actionResponse.getNamespace()+"orgcode="+ParamUtil.getString(actionRequest, "orgcode");
			if(id>0){
				errorURL+="&"+actionResponse.getNamespace()+DauNoiNuocTerms.ID+"="+id;
			}
			SessionErrors.add(actionRequest, messageKey);
			if (Validator.isNotNull(errorURL)) {
				actionResponse.sendRedirect(errorURL);
			}
		}
	}
	private static Log _log = LogFactoryUtil.getLog(KeHoachKiemDemNuocAction.class);
}
