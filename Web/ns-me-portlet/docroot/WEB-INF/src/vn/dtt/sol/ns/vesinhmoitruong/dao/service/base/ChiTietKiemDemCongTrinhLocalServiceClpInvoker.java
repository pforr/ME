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

import vn.dtt.sol.ns.vesinhmoitruong.dao.service.ChiTietKiemDemCongTrinhLocalServiceUtil;

import java.util.Arrays;

/**
 * @author BinhTH
 * @generated
 */
public class ChiTietKiemDemCongTrinhLocalServiceClpInvoker {
	public ChiTietKiemDemCongTrinhLocalServiceClpInvoker() {
		_methodName0 = "addChiTietKiemDemCongTrinh";

		_methodParameterTypes0 = new String[] {
				"vn.dtt.sol.ns.vesinhmoitruong.dao.model.ChiTietKiemDemCongTrinh"
			};

		_methodName1 = "createChiTietKiemDemCongTrinh";

		_methodParameterTypes1 = new String[] { "int" };

		_methodName2 = "deleteChiTietKiemDemCongTrinh";

		_methodParameterTypes2 = new String[] { "int" };

		_methodName3 = "deleteChiTietKiemDemCongTrinh";

		_methodParameterTypes3 = new String[] {
				"vn.dtt.sol.ns.vesinhmoitruong.dao.model.ChiTietKiemDemCongTrinh"
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

		_methodName10 = "fetchChiTietKiemDemCongTrinh";

		_methodParameterTypes10 = new String[] { "int" };

		_methodName11 = "getChiTietKiemDemCongTrinh";

		_methodParameterTypes11 = new String[] { "int" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getChiTietKiemDemCongTrinhs";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getChiTietKiemDemCongTrinhsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateChiTietKiemDemCongTrinh";

		_methodParameterTypes15 = new String[] {
				"vn.dtt.sol.ns.vesinhmoitruong.dao.model.ChiTietKiemDemCongTrinh"
			};

		_methodName76 = "getBeanIdentifier";

		_methodParameterTypes76 = new String[] {  };

		_methodName77 = "setBeanIdentifier";

		_methodParameterTypes77 = new String[] { "java.lang.String" };

		_methodName82 = "getListDetailCongTrinhByKeHoachId";

		_methodParameterTypes82 = new String[] { "int" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ChiTietKiemDemCongTrinhLocalServiceUtil.addChiTietKiemDemCongTrinh((vn.dtt.sol.ns.vesinhmoitruong.dao.model.ChiTietKiemDemCongTrinh)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ChiTietKiemDemCongTrinhLocalServiceUtil.createChiTietKiemDemCongTrinh(((Integer)arguments[0]).intValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ChiTietKiemDemCongTrinhLocalServiceUtil.deleteChiTietKiemDemCongTrinh(((Integer)arguments[0]).intValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ChiTietKiemDemCongTrinhLocalServiceUtil.deleteChiTietKiemDemCongTrinh((vn.dtt.sol.ns.vesinhmoitruong.dao.model.ChiTietKiemDemCongTrinh)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ChiTietKiemDemCongTrinhLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ChiTietKiemDemCongTrinhLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ChiTietKiemDemCongTrinhLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ChiTietKiemDemCongTrinhLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ChiTietKiemDemCongTrinhLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ChiTietKiemDemCongTrinhLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ChiTietKiemDemCongTrinhLocalServiceUtil.fetchChiTietKiemDemCongTrinh(((Integer)arguments[0]).intValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ChiTietKiemDemCongTrinhLocalServiceUtil.getChiTietKiemDemCongTrinh(((Integer)arguments[0]).intValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ChiTietKiemDemCongTrinhLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ChiTietKiemDemCongTrinhLocalServiceUtil.getChiTietKiemDemCongTrinhs(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ChiTietKiemDemCongTrinhLocalServiceUtil.getChiTietKiemDemCongTrinhsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ChiTietKiemDemCongTrinhLocalServiceUtil.updateChiTietKiemDemCongTrinh((vn.dtt.sol.ns.vesinhmoitruong.dao.model.ChiTietKiemDemCongTrinh)arguments[0]);
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return ChiTietKiemDemCongTrinhLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			ChiTietKiemDemCongTrinhLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return ChiTietKiemDemCongTrinhLocalServiceUtil.getListDetailCongTrinhByKeHoachId(((Integer)arguments[0]).intValue());
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
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName82;
	private String[] _methodParameterTypes82;
}