/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package vn.dtt.sol.ns.vesinhmoitruong.dao.service.base;

import vn.dtt.sol.ns.vesinhmoitruong.dao.service.ThongTinKiemDemHoGDLocalServiceUtil;

import java.util.Arrays;

/**
 * @author BinhTH
 * @generated
 */
public class ThongTinKiemDemHoGDLocalServiceClpInvoker {
	public ThongTinKiemDemHoGDLocalServiceClpInvoker() {
		_methodName0 = "addThongTinKiemDemHoGD";

		_methodParameterTypes0 = new String[] {
				"vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemHoGD"
			};

		_methodName1 = "createThongTinKiemDemHoGD";

		_methodParameterTypes1 = new String[] { "int" };

		_methodName2 = "deleteThongTinKiemDemHoGD";

		_methodParameterTypes2 = new String[] { "int" };

		_methodName3 = "deleteThongTinKiemDemHoGD";

		_methodParameterTypes3 = new String[] {
				"vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemHoGD"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchThongTinKiemDemHoGD";

		_methodParameterTypes10 = new String[] { "int" };

		_methodName11 = "getThongTinKiemDemHoGD";

		_methodParameterTypes11 = new String[] { "int" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getThongTinKiemDemHoGDs";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getThongTinKiemDemHoGDsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateThongTinKiemDemHoGD";

		_methodParameterTypes15 = new String[] {
				"vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemHoGD"
			};

		_methodName74 = "getBeanIdentifier";

		_methodParameterTypes74 = new String[] {  };

		_methodName75 = "setBeanIdentifier";

		_methodParameterTypes75 = new String[] { "java.lang.String" };

		_methodName80 = "getListThongTinKiemDemHoGiaDinhByGDID";

		_methodParameterTypes80 = new String[] { "int", "int", "int" };

		_methodName81 = "getCountGiaDinhBykeHoachId";

		_methodParameterTypes81 = new String[] { "int", "int" };

		_methodName82 = "getCountGiaDinhBykeHoachIdDanhGiaKiemDem";

		_methodParameterTypes82 = new String[] { "int", "int" };

		_methodName83 = "getCountCoNhaVeSinh";

		_methodParameterTypes83 = new String[] { "int" };

		_methodName84 = "getCountcoHVS";

		_methodParameterTypes84 = new String[] { "int" };

		_methodName85 = "getCountcoHVSXayMoi";

		_methodParameterTypes85 = new String[] { "int" };

		_methodName86 = "getSumHDGBykeHoachKiemDemVsId";

		_methodParameterTypes86 = new String[] { "int" };

		_methodName87 = "getThongTinKiemDemHGDThoiGianThucGroupBy";

		_methodParameterTypes87 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName88 = "countThongTinKiemDemHGDThoiGianThucGroupBy";

		_methodParameterTypes88 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName89 = "getThongTinKiemDemHGDThoiGianThuc";

		_methodParameterTypes89 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.addThongTinKiemDemHoGD((vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemHoGD)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.createThongTinKiemDemHoGD(((Integer)arguments[0]).intValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.deleteThongTinKiemDemHoGD(((Integer)arguments[0]).intValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.deleteThongTinKiemDemHoGD((vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemHoGD)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.fetchThongTinKiemDemHoGD(((Integer)arguments[0]).intValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.getThongTinKiemDemHoGD(((Integer)arguments[0]).intValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.getThongTinKiemDemHoGDs(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.getThongTinKiemDemHoGDsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.updateThongTinKiemDemHoGD((vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemHoGD)arguments[0]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			ThongTinKiemDemHoGDLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.getListThongTinKiemDemHoGiaDinhByGDID(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.getCountGiaDinhBykeHoachId(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.getCountGiaDinhBykeHoachIdDanhGiaKiemDem(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.getCountCoNhaVeSinh(((Integer)arguments[0]).intValue());
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.getCountcoHVS(((Integer)arguments[0]).intValue());
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.getCountcoHVSXayMoi(((Integer)arguments[0]).intValue());
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.getSumHDGBykeHoachKiemDemVsId(((Integer)arguments[0]).intValue());
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.getThongTinKiemDemHGDThoiGianThucGroupBy((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.countThongTinKiemDemHGDThoiGianThucGroupBy((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4]);
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return ThongTinKiemDemHoGDLocalServiceUtil.getThongTinKiemDemHGDThoiGianThuc((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName84;
	private String[] _methodParameterTypes84;
	private String _methodName85;
	private String[] _methodParameterTypes85;
	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName87;
	private String[] _methodParameterTypes87;
	private String _methodName88;
	private String[] _methodParameterTypes88;
	private String _methodName89;
	private String[] _methodParameterTypes89;
}