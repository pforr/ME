package vn.dtt.sol.ns.tramcap.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;

import vn.dtt.sol.ns.maungaunhien.dao.model.MAUKIEMDEM;
import vn.dtt.sol.ns.maungaunhien.dao.service.MAUKIEMDEMLocalServiceUtil;
import vn.dtt.sol.ns.tramcap.business.MauNgauNhienBusiness;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhGiaDinh;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.VeSinhGiaDinhLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;

public class MauNgauNhienAction {

	/**
	 * @param request
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public MAUKIEMDEM updateMauNgauNhien(ActionRequest request)
			throws PortalException, SystemException {

		ServiceContext context = ServiceContextFactory.getInstance(request);

		MAUKIEMDEM mauKiemDem = null;

		long id = 0;

		// ParamUtil.getLong(request, "id");

		String maTinh = ParamUtil.getString(request, "maTinh");
		String maHuyen = ParamUtil.getString(request, "maHuyen");
		String maXa = ParamUtil.getString(request, "maXa");
		int nam = ParamUtil.getInteger(request, "nam");
		int tongSoHGD = ParamUtil.getInteger(request, "tongSoHGD");
		int tongSoMau = ParamUtil.getInteger(request, "tongSoMau");
		int soMauDuPhong = ParamUtil.getInteger(request, "soMauDuPhong");
		int soMauNgauNhien = ParamUtil.getInteger(request, "soMauNgauNhien");

		// int soMauHVS = ParamUtil.getInteger(request, "soMauHVS");
		// int soMauCoNhaTieu = ParamUtil.getInteger(request, "soMauCoNhaTieu");
		// int soMauKiemDem = ParamUtil.getInteger(request, "soMauKiemDem");

		MAUKIEMDEM mkd = MauNgauNhienBusiness.getMauKiemDemByTHXN(maTinh,
				maHuyen, maXa, nam);

		if (Validator.isNotNull(mkd)) {
			id = mkd.getId();
		}

		mauKiemDem = MAUKIEMDEMLocalServiceUtil.updateMauKiemDem(id, maTinh,
				maHuyen, maXa, nam, tongSoHGD, tongSoMau, soMauNgauNhien,
				soMauDuPhong, context);

		List<VeSinhGiaDinh> lsMauGiaDinh = randomMauKiemDem(request);

		List<VeSinhGiaDinh> lsVeSinhGiaDinh = MauNgauNhienBusiness
				.getVSDGByTHXMNN(maTinh, maHuyen, maXa, nam);

		// reset mau gia dinh
		for (VeSinhGiaDinh vsgd : lsVeSinhGiaDinh) {
			VeSinhGiaDinhLocalServiceUtil.updateVeSinhHoGiaDinhChonMau(
					vsgd.getId(), 0);
		}

		// cap nhat mau ngau nhien
		for (VeSinhGiaDinh vsgd : lsMauGiaDinh) {
			VeSinhGiaDinhLocalServiceUtil.updateVeSinhHoGiaDinhChonMau(
					vsgd.getId(), nam);
		}

		return mauKiemDem;
	}

	/**
	 * @param request
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteMauKiemDem(ActionRequest request) throws PortalException,
			SystemException {
		long id = ParamUtil.getLong(request, "id");

		MAUKIEMDEM mauKiemDem = null;

		try {
			mauKiemDem = MAUKIEMDEMLocalServiceUtil.fetchMAUKIEMDEM(id);
		} catch (Exception e) {
			_log.error(e);
		}

		if (Validator.isNotNull(mauKiemDem)) {
			MAUKIEMDEMLocalServiceUtil.deleteMAUKIEMDEM(mauKiemDem);
		}
	}

	/**
	 * @param request
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<VeSinhGiaDinh> randomMauKiemDem(ActionRequest request)
			throws PortalException, SystemException {

		String maTinh = ParamUtil.getString(request, "maTinh");
		String maHuyen = ParamUtil.getString(request, "maHuyen");
		String maXa = ParamUtil.getString(request, "maXa");

		int tongSoMau = ParamUtil.getInteger(request, "tongSoMau");

		List<VeSinhGiaDinh> lsVeSinhGiaDinh = new ArrayList<VeSinhGiaDinh>();

		try {
			lsVeSinhGiaDinh = VeSinhGiaDinhLocalServiceUtil
					.getVeSinhGiaDinhSearch(maTinh, maHuyen, maXa,
							StringPool.BLANK, StringPool.BLANK,
							StringPool.BLANK,StringPool.BLANK, QueryUtil.ALL_POS,
							QueryUtil.ALL_POS);

		} catch (Exception e) {
			_log.error(e);
		}

		List<VeSinhGiaDinh> copyLs = new ArrayList<VeSinhGiaDinh>();

		for (VeSinhGiaDinh vs : lsVeSinhGiaDinh) {
			copyLs.add(vs);
		}

		Collections.shuffle(copyLs);

		List<VeSinhGiaDinh> randomMau = copyLs.subList(0, tongSoMau);

		return randomMau;
	}

	private static Log _log = LogFactoryUtil.getLog(MauNgauNhienAction.class);
}
