package vn.dtt.sol.ns.portlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import vn.dtt.sol.ns.baocaodli.dao.NamBaoCaoException;
import vn.dtt.sol.ns.baocaodli.dao.NgayBaoCaoException;
import vn.dtt.sol.ns.baocaodli.dao.NguoiDuyetException;
import vn.dtt.sol.ns.baocaodli.dao.NguoiLapException;
import vn.dtt.sol.ns.baocaodli.dao.NoSuchBaoCaoDLIException;
import vn.dtt.sol.ns.baocaodli.dao.SoBaoCaoException;
import vn.dtt.sol.ns.baocaodli.dao.UpdateChotBaoCaoException;
import vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLI;
import vn.dtt.sol.ns.baocaodli.dao.service.BaoCaoDLILocalServiceUtil;
import vn.dtt.sol.ns.baocaodli.util.BaoCaoDLIConstants;
import vn.dtt.sol.ns.business.BaoCaoDLIBusiness;
import vn.dtt.sol.ns.reporting.utils.ReportBusinessUtils;
import vn.dtt.sol.ns.reporting.utils.ReportConstant;
import vn.dtt.sol.ns.reporting.utils.ReportUtils;
import vn.dtt.sol.ns.util.WebKeys;
import vn.dtt.sol.ns.util.format.ConvertUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class BaoCaoDLIPortlet extends MVCPortlet {
	
	public void deleteBaoCaoDLI(ActionRequest actionRequest, ActionResponse actionResponse) 
		throws Exception {
		
		long baoCaoDLIId = ParamUtil.getLong(actionRequest, "baoCaoDLIId");
		
		try {
			BaoCaoDLILocalServiceUtil.deleteBaoCao(baoCaoDLIId);
			
			SessionMessages.add(actionRequest, "success-xoa-bao-cao-thanh-cong");
		} catch(Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		
		sendCustomRedirect(actionRequest, actionResponse);
	}
	
	public void updateBaoCaoDLI(ActionRequest actionRequest, ActionResponse actionResponse) 
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		
		long baoCaoDLIId = ParamUtil.getLong(actionRequest, "baoCaoDLIId");
		long folderId = ParamUtil.getLong(actionRequest, "folderId");
		
		int nam = ParamUtil.getInteger(actionRequest, "nam");
		int trangThai = ParamUtil.getInteger(actionRequest, "trangThai");

		String maTinh = ParamUtil.getString(actionRequest, "maTinh");
		
		String donViBaoCao = ParamUtil.getString(actionRequest, "donViBaoCao");
		String soBaoCao = ParamUtil.getString(actionRequest, "soBaoCao");
		String nguoiLap = ParamUtil.getString(actionRequest, "nguoiLapTxt");
		String nguoiDuyet = ParamUtil.getString(actionRequest, "nguoiDuyet");
		
		String keHoachNam = ParamUtil.getString(actionRequest, "keHoachNam");
		Date ngayPheDuyet = ParamUtil.getDate(actionRequest, "ngayPheDuyet",ConvertUtil.formatDateShort);
		String baoCaoChuongTrinh = ParamUtil.getString(actionRequest, "baoCaoChuongTrinh");
		Date ngayDang = ParamUtil.getDate(actionRequest, "ngayDang",ConvertUtil.formatDateShort);
		
		
		int ngayBaoCaoMonth = ParamUtil.getInteger(actionRequest, "ngayBaoCaoMonth");
		int ngayBaoCaoDay = ParamUtil.getInteger(actionRequest, "ngayBaoCaoDay");
		int ngayBaoCaoYear = ParamUtil.getInteger(actionRequest, "ngayBaoCaoYear");
		
		int typeDLI = ParamUtil.getInteger(actionRequest, "typeDLI");
		
		String fileNameTH = getNameFile(typeDLI, true, false);
		String fileNameCT = getNameFile(typeDLI, false, false);
		String fileNameCT1 = getNameFile(typeDLI, false, true);
		
		if(!cmd.equals(Constants.UPDATE) || 
				(trangThai != BaoCaoDLIConstants.TRANG_THAI_DANG_LAP 
					&& trangThai != BaoCaoDLIConstants.TRANG_THAI_DA_CHOT)) {
			
			return;
		}
		
		File luuTruPDF1 = null;
		File luuTruPDF2 = null;
		File luuTruPDF3 = null;
		
		if(trangThai == BaoCaoDLIConstants.TRANG_THAI_DA_CHOT) {
			try {
				HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
				ServletContext servletContext = request.getSession().getServletContext();
				
				if(typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_1_1 ||  typeDLI == BaoCaoDLIConstants.BAO_CAO_DLI_1_2)
				{
					luuTruPDF1 = new File(servletContext.getRealPath("/" + ReportUtils.PATH_FILE_EXPORT + "/" + nam + "_"+ maTinh + "_" +  fileNameTH + "_chot.pdf"));				
					luuTruPDF2 = new File(servletContext.getRealPath("/" + ReportUtils.PATH_FILE_EXPORT + "/" + nam + "_"+ maTinh + "_" + fileNameCT + "_chot.pdf"));	
					luuTruPDF3 = new File(servletContext.getRealPath("/" + ReportUtils.PATH_FILE_EXPORT + "/" + nam + "_"+ maTinh + "_" + fileNameCT1 + "_chot.pdf"));
				}else{	
					luuTruPDF1 = new File(servletContext.getRealPath("/" + ReportUtils.PATH_FILE_EXPORT + "/" + nam + "_"+ maTinh + "_" +  fileNameTH + ".pdf"));				
					luuTruPDF2 = new File(servletContext.getRealPath("/" + ReportUtils.PATH_FILE_EXPORT + "/" + nam + "_"+ maTinh + "_" + fileNameCT + ".pdf"));	
					luuTruPDF3 = new File(servletContext.getRealPath("/" + ReportUtils.PATH_FILE_EXPORT + "/" + nam + "_"+ maTinh + "_" + fileNameCT1 + ".pdf"));
				}
			} catch(Exception e) {
				_log.error(e);
			}
		}
		
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			
			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);
			
			BaoCaoDLILocalServiceUtil.updateBaoCao(themeDisplay.getUserId(),
				themeDisplay.getScopeGroupId(), baoCaoDLIId, nam, maTinh,
				donViBaoCao,soBaoCao, nguoiLap, nguoiDuyet, ngayBaoCaoMonth,
				ngayBaoCaoDay, ngayBaoCaoYear, folderId, luuTruPDF1,
				luuTruPDF2, luuTruPDF3, null, null, null, trangThai,
				keHoachNam,ngayPheDuyet,baoCaoChuongTrinh,ngayDang, serviceContext);
			
			SessionMessages.add(actionRequest, "success-chot-bao-cao-thanh-cong");
		} catch(Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		
		sendCustomRedirect(actionRequest, actionResponse);
	}
	
	private String getNameFile(int typeDLI, boolean isTonghop, boolean isChiTiet1) {
		String fileName = StringPool.BLANK;
		
		if (typeDLI == 1) { // 1.1
			if (isTonghop) {
				fileName = ReportConstant.GIAY_DLI1_1_TH_EXPORT;
			} else {
				fileName = ReportConstant.GIAY_DLI1_1_CT_EXPORT;
			}
		} else if (typeDLI == 2) { // 1.2
			if (isTonghop) {
				fileName = ReportConstant.GIAY_DLI1_2_TH_EXPORT;
			} else {
				fileName = ReportConstant.GIAY_DLI1_2_CT_EXPORT;
			}
		} else if (typeDLI == 3) { // 2.1
			if (isTonghop) {
				fileName = ReportConstant.GIAY_DLI2_1_EXPORT;
			} else {
				
			}
		} else if (typeDLI == 4) { // 2.2
			if (isTonghop) {
				fileName = ReportConstant.GIAY_DLI2_2_EXPORT;
			} else {				
				if(isChiTiet1){
					fileName = ReportConstant.GIAY_DLI2_2_PL2_EXPORT;
				}else{
					fileName = ReportConstant.GIAY_DLI2_2_PL1_EXPORT;
				}				
			}
		}else if (typeDLI == 5) { // 3
			if (isTonghop) {
				fileName = ReportConstant.GIAY_DLI3_EXPORT;
			} else {				
				if(isChiTiet1){
					fileName = ReportConstant.GIAY_THDK_NTHVSXM_EXPORT;
				}else{
					fileName = ReportConstant.GIAY_THDK_DNSDN_EXPORT;
				}
			}
		}else if (typeDLI == 6) { // th
			if (isTonghop) {
				fileName = ReportConstant.GIAY_DLI_TH_EXPORT;
			} else {
				
			}
		}
		
		return fileName;
	}
	
	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) 
		throws PortletException, IOException {
		
		try {
			
			long baoCaoDLIId = ParamUtil.getLong(renderRequest, "baoCaoDLIId");
			
			BaoCaoDLI baoCao = BaoCaoDLIBusiness.getBaoCaoDLI(baoCaoDLIId);
			
			renderRequest.setAttribute(WebKeys.BAO_CAO_DLI, baoCao);
		} catch (Exception e) {
			if (e instanceof NoSuchBaoCaoDLIException
					|| e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass().getName());

				SessionMessages.add(
					renderRequest,
					PortalUtil.getPortletId(renderRequest) +
						SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			} else {
				throw new PortletException(e);
			}
		}

		super.render(renderRequest, renderResponse);
	}
	
	@Override
	protected void doDispatch(RenderRequest renderRequest,
			RenderResponse renderResponse) 
	throws PortletException, IOException {

		if (SessionErrors.contains(renderRequest,
				NoSuchBaoCaoDLIException.class.getName())
					|| SessionErrors.contains(renderRequest,
							UpdateChotBaoCaoException.class.getName())
					|| SessionErrors.contains(renderRequest,
							PrincipalException.class.getName())) {

			include(templatePath + "error.jsp", renderRequest, renderResponse);
		} else {
			super.doDispatch(renderRequest, renderResponse);
		}
	}

	@Override
	protected boolean isSessionErrorException(Throwable cause) {

		if (cause instanceof NoSuchBaoCaoDLIException
				|| cause instanceof UpdateChotBaoCaoException
				|| cause instanceof NamBaoCaoException
				|| cause instanceof SoBaoCaoException
				|| cause instanceof NgayBaoCaoException
				|| cause instanceof NguoiLapException
				|| cause instanceof NguoiDuyetException
				|| cause instanceof PrincipalException) {

			return true;
		}

		return false;
	}
	
	private void sendCustomRedirect(ActionRequest actionRequest,
			ActionResponse actionResponse) 
		throws IOException {

		if (!SessionErrors.isEmpty(actionRequest)) {
			String backURL = ParamUtil.getString(actionRequest, "backURL");

			SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest)
					+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

			if (Validator.isNotNull(backURL)) {
				actionResponse.sendRedirect(backURL);
			}
		} else {
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest)
						+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		}
	}
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		_log.info("----serveResource---vao inbaocao");
		ReportBusinessUtils.inBaoCaoDLI(resourceRequest,resourceResponse);
		//super.serveResource(resourceRequest, resourceResponse);
	}
	private static final Log _log = LogFactoryUtil.getLog(BaoCaoDLIPortlet.class);
}
