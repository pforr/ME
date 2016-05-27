package vn.dtt.sol.ns.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import vn.dtt.cmon.dm.dao.model.DATAITEM;
import vn.dtt.cmon.user.action.UserMappingAction;
import vn.dtt.sol.ns.business.DataItemBusiness;
import vn.dtt.sol.ns.tramcap.business.TramCapBusiness;
import vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class UserMappingPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		super.serveResource(resourceRequest, resourceResponse);

		String capTinhId = ParamUtil.getString(resourceRequest, "capTinhId");

		int userType = ParamUtil.getInteger(resourceRequest, "userType");

		List<DATAITEM> lsHuyen = DataItemBusiness.getInLevel2(
				vn.dtt.sol.ns.util.WebKeys.DATAGROUPID_DONVIHANHCHINH,
				capTinhId);

		List<TramCapNuoc> lsTramCap = TramCapBusiness.getByTinh(capTinhId);

		JSONObject jsonHuyen = null;
		JSONObject jsonTramCap = null;

		JSONArray huyenJsonArray = JSONFactoryUtil.createJSONArray();
		JSONArray tramCapJsonArray = JSONFactoryUtil.createJSONArray();

		try {
			if (userType == 3) {
				for (DATAITEM huyen : lsHuyen) {

					jsonHuyen = JSONFactoryUtil.createJSONObject();

					jsonHuyen.put("idHuyen", huyen.getNode2());

					jsonHuyen.put("nameHuyen", huyen.getName());

					huyenJsonArray.put(jsonHuyen);
				}

				PrintWriter out = resourceResponse.getWriter();
				out.write(huyenJsonArray.toString());

			} else {

				for (TramCapNuoc tramCap : lsTramCap) {
					jsonTramCap = JSONFactoryUtil.createJSONObject();

					jsonTramCap
							.put("idTramCap", Long.toString(tramCap.getId()));

					jsonTramCap.put("nameTramCap", tramCap.getTenTram());

					tramCapJsonArray.put(jsonTramCap);

				}

				PrintWriter out = resourceResponse.getWriter();
				out.write(tramCapJsonArray.toString());
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void addUserMapping(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {

		try {
			UserMappingAction action = new UserMappingAction();
			action.addUserMapping(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}

		sendCustomRedirect(actionRequest, actionResponse);

	}

	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
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

	private static Log _log = LogFactoryUtil.getLog(UserMappingPortlet.class);

}
