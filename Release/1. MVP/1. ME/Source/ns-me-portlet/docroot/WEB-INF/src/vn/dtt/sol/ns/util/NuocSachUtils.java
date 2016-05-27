package vn.dtt.sol.ns.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

import vn.dtt.cmon.dm.dao.model.DATAITEM;
import vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil;
import vn.dtt.cmon.user.dao.model.UserMapping;
import vn.dtt.sol.ns.business.UserMappingBusiness;
import vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc;
import vn.dtt.sol.ns.tramcap.dao.service.TramCapNuocLocalServiceUtil;
import vn.dtt.sol.ns.util.format.ConvertUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

public class NuocSachUtils {

	/**
	 * @param source
	 * @return
	 */
	public static String formatNumber(int source) {
		String pattern = "###,###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);

		String format = decimalFormat.format(source);

		return format;
	}

	/**
	 * @param source
	 * @return
	 */
	public static int formatPrice(String source) {
		DecimalFormat priceFormat = new DecimalFormat();
		DecimalFormatSymbols dfs = priceFormat.getDecimalFormatSymbols();

		dfs.setDecimalSeparator(',');
		dfs.setGroupingSeparator('.');
		priceFormat.setMinimumFractionDigits(0);
		priceFormat.setDecimalFormatSymbols(dfs);

		int price = 0;

		try {
			price = priceFormat.parse(source).intValue();
		} catch (Exception e) {
			_log.error(e);
		}

		return price;
	}

	/**
	 * @param user
	 * @param level
	 * @return
	 */
	public static String getInitLevel(User user, int level) {
		String initValue = StringPool.BLANK;

		UserMapping userMapping = UserMappingBusiness.getUserMapping(user);

		if (Validator.isNotNull(userMapping)) {
			if (level == 2) {
				initValue = userMapping.getOrgCode1();
			} else if (level == 3 || level == 4) {
				initValue = userMapping.getOrgCode2();
			}
		}

		return initValue;
	}

	/**
	 * @param tramCapId
	 * @return
	 */
	public static TramCapNuoc getTramCap(long tramCapId) {
		TramCapNuoc tramCap = null;

		try {
			tramCap = TramCapNuocLocalServiceUtil.fetchTramCapNuoc(tramCapId);
		} catch (Exception e) {
			_log.error(e);
		}

		return tramCap;
	}

	public static List<DATAITEM> getListHuyen(User user) {

		List<DATAITEM> lsHuyen = new ArrayList<DATAITEM>();

		UserMapping um = UserMappingBusiness.getUserMapping(user);

		int userType = 0;

		if (Validator.isNotNull(um)) {
			userType = um.getUserType();
		}

		if (userType == 1) {
			try {
				lsHuyen = DATAITEMLocalServiceUtil.getByDataGroupLevel2(
						WebKeys.DATAGROUPID_DONVIHANHCHINH, um.getOrgCode1());
			} catch (Exception e) {
				_log.error(e);
			}
		} else {
			DATAITEM di = null;
			try {
				di = getDataItem((int) WebKeys.DATAGROUPID_DONVIHANHCHINH, 2,
						um.getOrgCode2());
			} catch (Exception e) {
				_log.error(e);
			}

			if (Validator.isNotNull(di)) {
				lsHuyen.add(di);
			}
		}

		return lsHuyen;
	}

	/**
	 * @param user
	 * @return
	 */
	public static List<DATAITEM> getListTinh(User user) {

		List<DATAITEM> lsTinh = new ArrayList<DATAITEM>();

		UserMapping um = UserMappingBusiness.getUserMapping(user);

		int userType = 0;

		if (Validator.isNotNull(um)) {
			userType = um.getUserType();
		}

		if (userType == 1) {
			try {
				lsTinh = DATAITEMLocalServiceUtil
						.getByDataGroupLevel1(WebKeys.DATAGROUPID_DONVIHANHCHINH);
			} catch (Exception e) {
				_log.error(e);
			}
		} else {
			DATAITEM di = null;
			try {
				di = getDataItem((int) WebKeys.DATAGROUPID_DONVIHANHCHINH, 1,
						um.getOrgCode1());
			} catch (Exception e) {
				_log.error(e);
			}

			if (Validator.isNotNull(di)) {
				lsTinh.add(di);
			}
		}

		return lsTinh;
	}

	/**
	 * @param maTramCap
	 * @return
	 */
	public static String getTinhByTram(String maTramCap) {
		String tinh = StringPool.BLANK;
		try {
			TramCapNuoc tramCap = TramCapNuocLocalServiceUtil
					.fetchTramCapNuoc(Long.parseLong(maTramCap));

			if (Validator.isNotNull(tramCap)) {
				tinh = getNameTinh(tramCap.getMaTinh());
			}

		} catch (Exception e) {
			_log.error(e);
		}

		return tinh;
	}

	public static String getTenTram(String maTram) {
		String tenTram = StringPool.BLANK;
		/*
		 * if(Validator.isNotNull(maTram)){ try { TramCapNuoc tramCapNuocTenTram
		 * = TramCapNuocLocalServiceUtil. tenTram =
		 * tramCapNuocTenTram.getTenTram(); } catch (SystemException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); _log.error(e); }
		 * 
		 * }
		 */
		return tenTram;
	}

	/**
	 * Author: tailt
	 * 
	 * @param tramId
	 * @return
	 */
	public static String getTenTramByTramId(String tramId) {
		String tenTram = StringPool.BLANK;
		if (Validator.isNotNull(tramId)) {
			try {
				TramCapNuoc tramCapNuocTenTram = TramCapNuocLocalServiceUtil
						.fetchTramCapNuoc(ConvertUtil.convertToLong(tramId));
				if(Validator.isNotNull(tramCapNuocTenTram)) {
					tenTram = tramCapNuocTenTram.getTenTram(); 
				}
			} catch (SystemException e) {
				e.printStackTrace();
				_log.error(e);
			}

		}
		return tenTram;
	}

	/**
	 * @param userMapping
	 * @return
	 */
	public static String getEmailUser(UserMapping userMapping) {
		String email = StringPool.BLANK;

		User user = UserMappingBusiness.getUser(userMapping.getId());

		if (Validator.isNotNull(user))
			email = user.getEmailAddress();

		return email;
	}

	public static String getNameXa(String orgCode3) {

		String nameXa = StringPool.DASH;

		try {
			DATAITEM xa = DATAITEMLocalServiceUtil.getDataItem(
					(int) WebKeys.DATAGROUPID_DONVIHANHCHINH, 3, orgCode3);

			if (Validator.isNotNull(xa)) {
				nameXa = xa.getName();
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return nameXa;
	}

	public static DATAITEM getDataItem(int dataGroupId, int level, String node) {
		DATAITEM dataItem = null;

		try {
			dataItem = DATAITEMLocalServiceUtil.getDataItem(dataGroupId, level,
					node);
		} catch (Exception e) {
			_log.error(e);
		}

		return dataItem;
	}

	/**
	 * @param orgCode2
	 * @return
	 */
	public static String getNameHuyen(String orgCode1, String orgCode2) {

		String nameHuyen = StringPool.DASH;

		try {
			DATAITEM huyen = DATAITEMLocalServiceUtil.getDataItem(
					(int) WebKeys.DATAGROUPID_DONVIHANHCHINH, 2, orgCode2);

			if (Validator.isNotNull(huyen)) {
				nameHuyen = huyen.getName();
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return nameHuyen;
	}

	/**
	 * @param orgCode1
	 * @return
	 */
	public static String getNameTinh(String orgCode1) {
		String nameTinh = StringPool.DASH;

		DATAITEM tinh = null;

		try {
			tinh = DATAITEMLocalServiceUtil.getDataItem(
					(int) WebKeys.DATAGROUPID_DONVIHANHCHINH, 1, orgCode1);

			if (Validator.isNotNull(tinh)) {
				nameTinh = tinh.getName();
			} else {

			}
		} catch (Exception e) {
			_log.error(e);
		}

		return nameTinh;
	}

	/**
	 * @param orgCode2
	 * @return
	 */
	public static DATAITEM getDATAITEMHuyen(String orgCode1, String orgCode2) {

		DATAITEM huyen = null;

		try {
			huyen = DATAITEMLocalServiceUtil.getDataItem(
					(int) WebKeys.DATAGROUPID_DONVIHANHCHINH, 2, orgCode2);
		} catch (Exception e) {
			_log.error(e);
		}

		return huyen;
	}

	/**
	 * @param orgCode1
	 * @return
	 */
	public static DATAITEM getDATAITEMTinh(String orgCode1) {

		DATAITEM tinh = null;

		try {
			tinh = DATAITEMLocalServiceUtil.getDataItem(
					(int) WebKeys.DATAGROUPID_DONVIHANHCHINH, 1, orgCode1);
		} catch (Exception e) {
			_log.error(e);
		}

		return tinh;
	}

	/**
	 * @param user
	 * @return
	 */
	public static List<Organization> getOrgOfUser(User user) {

		List<Organization> orgs = new ArrayList<Organization>();
		if (user.getUserId() != 0) {
			try {
				orgs = OrganizationLocalServiceUtil.getUserOrganizations(user
						.getUserId());
			} catch (Exception e) {
				_log.error(e);
			}

		}

		return orgs;
	}

	private static Log _log = LogFactoryUtil.getLog(NuocSachUtils.class);
}
