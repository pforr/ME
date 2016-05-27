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

package vn.dtt.cmon.dm.dao.service.base;

import vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil;

import java.util.Arrays;

/**
 * @author khoa.vu
 * @generated
 */
public class DATAITEMLocalServiceClpInvoker {
	public DATAITEMLocalServiceClpInvoker() {
		_methodName0 = "addDATAITEM";

		_methodParameterTypes0 = new String[] {
				"vn.dtt.cmon.dm.dao.model.DATAITEM"
			};

		_methodName1 = "createDATAITEM";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteDATAITEM";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteDATAITEM";

		_methodParameterTypes3 = new String[] {
				"vn.dtt.cmon.dm.dao.model.DATAITEM"
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

		_methodName10 = "fetchDATAITEM";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getDATAITEM";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getDATAITEMs";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getDATAITEMsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateDATAITEM";

		_methodParameterTypes15 = new String[] {
				"vn.dtt.cmon.dm.dao.model.DATAITEM"
			};

		_methodName50 = "getBeanIdentifier";

		_methodParameterTypes50 = new String[] {  };

		_methodName51 = "setBeanIdentifier";

		_methodParameterTypes51 = new String[] { "java.lang.String" };

		_methodName56 = "getDataItem";

		_methodParameterTypes56 = new String[] { "int", "int", "java.lang.String" };

		_methodName57 = "getNode3";

		_methodParameterTypes57 = new String[] { "long", "java.lang.String" };

		_methodName58 = "getNode2";

		_methodParameterTypes58 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName59 = "getNode1";

		_methodParameterTypes59 = new String[] { "long", "java.lang.String" };

		_methodName60 = "getByDataGroupId";

		_methodParameterTypes60 = new String[] { "long" };

		_methodName61 = "getByDataGroupId";

		_methodParameterTypes61 = new String[] { "long", "int", "int" };

		_methodName62 = "countByDataGroupId";

		_methodParameterTypes62 = new String[] { "long" };

		_methodName63 = "getByDataGroupLevel1";

		_methodParameterTypes63 = new String[] { "long" };

		_methodName64 = "getByDataGroupLevel1";

		_methodParameterTypes64 = new String[] { "long", "int", "int" };

		_methodName65 = "countByDataGroupLevel1";

		_methodParameterTypes65 = new String[] { "long" };

		_methodName66 = "getByDataGroupLevel2";

		_methodParameterTypes66 = new String[] { "long", "java.lang.String" };

		_methodName67 = "getByDataGroupLevel2";

		_methodParameterTypes67 = new String[] {
				"long", "java.lang.String", "int", "int"
			};

		_methodName68 = "countByDataGroupLevel2";

		_methodParameterTypes68 = new String[] { "long", "java.lang.String" };

		_methodName69 = "getByDataGroupLevel3";

		_methodParameterTypes69 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName70 = "getByDataGroupLevel3";

		_methodParameterTypes70 = new String[] {
				"long", "java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName71 = "getDATAITEMByTen";

		_methodParameterTypes71 = new String[] { "java.lang.String" };

		_methodName72 = "countByDataGroupLevel3";

		_methodParameterTypes72 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName73 = "findDataItemByName";

		_methodParameterTypes73 = new String[] {
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName74 = "getDATAITEMByDataGroupIdAndLevel";

		_methodParameterTypes74 = new String[] { "long", "int" };

		_methodName75 = "getListHuyenGS";

		_methodParameterTypes75 = new String[] {
				"com.liferay.portal.model.User", "java.lang.String", "int",
				"int"
			};

		_methodName76 = "countHuyenByUser";

		_methodParameterTypes76 = new String[] {
				"com.liferay.portal.model.User", "java.lang.String"
			};

		_methodName77 = "findHuyenDuocChonByUser";

		_methodParameterTypes77 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "int"
			};

		_methodName78 = "findHuyenChonByUser";

		_methodParameterTypes78 = new String[] {
				"java.lang.String", "long", "int", "int"
			};

		_methodName79 = "findXaTrongHuyenChonByUser";

		_methodParameterTypes79 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "int"
			};

		_methodName80 = "getTinh";

		_methodParameterTypes80 = new String[] {
				"com.liferay.portal.model.User", "boolean", "int", "int"
			};

		_methodName81 = "getHuyen";

		_methodParameterTypes81 = new String[] {
				"com.liferay.portal.model.User", "java.lang.String", "long",
				"boolean", "int", "int"
			};

		_methodName82 = "getXa";

		_methodParameterTypes82 = new String[] {
				"com.liferay.portal.model.User", "java.lang.String",
				"java.lang.String", "long", "boolean", "int", "int"
			};

		_methodName83 = "getTramCap";

		_methodParameterTypes83 = new String[] {
				"com.liferay.portal.model.User", "java.lang.String", "boolean",
				"int", "int"
			};

		_methodName84 = "findXaKhongInHuyenInTramByUser";

		_methodParameterTypes84 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long", "int",
				"int"
			};

		_methodName85 = "findXaInHuyenInTramByUser";

		_methodParameterTypes85 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long", "int",
				"int"
			};

		_methodName86 = "findHuyenInTramByUser";

		_methodParameterTypes86 = new String[] {
				"java.lang.String", "long", "long", "int", "int"
			};

		_methodName87 = "coutHuyenDaChonByUser";

		_methodParameterTypes87 = new String[] { "java.lang.String", "long" };

		_methodName88 = "coutXaTrongHuyenDaChonByUser";

		_methodParameterTypes88 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName89 = "checkTinhContains";

		_methodParameterTypes89 = new String[] {
				"java.lang.String", "java.util.List"
			};

		_methodName90 = "getHuyenSelectByTinhUser";

		_methodParameterTypes90 = new String[] {
				"java.lang.String", "long", "int", "int"
			};

		_methodName91 = "getListTinhTU";

		_methodParameterTypes91 = new String[] {
				"com.liferay.portal.model.User", "boolean", "int", "int"
			};

		_methodName92 = "countListTinhTU";

		_methodParameterTypes92 = new String[] {
				"com.liferay.portal.model.User", "boolean"
			};

		_methodName93 = "getGSVInHuyen";

		_methodParameterTypes93 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName94 = "getUserInTramCap";

		_methodParameterTypes94 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName95 = "getListTramCap";

		_methodParameterTypes95 = new String[] {
				"com.liferay.portal.model.User", "java.lang.String", "int",
				"int"
			};

		_methodName96 = "getHuyenInTramCap";

		_methodParameterTypes96 = new String[] {
				"java.lang.String", "long", "int", "int"
			};

		_methodName97 = "getXaInHuyenAndTramCap";

		_methodParameterTypes97 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "int"
			};

		_methodName98 = "countTramCapByUser";

		_methodParameterTypes98 = new String[] {
				"com.liferay.portal.model.User", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return DATAITEMLocalServiceUtil.addDATAITEM((vn.dtt.cmon.dm.dao.model.DATAITEM)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return DATAITEMLocalServiceUtil.createDATAITEM(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return DATAITEMLocalServiceUtil.deleteDATAITEM(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return DATAITEMLocalServiceUtil.deleteDATAITEM((vn.dtt.cmon.dm.dao.model.DATAITEM)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return DATAITEMLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return DATAITEMLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return DATAITEMLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return DATAITEMLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return DATAITEMLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return DATAITEMLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return DATAITEMLocalServiceUtil.fetchDATAITEM(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getDATAITEM(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getDATAITEMs(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getDATAITEMsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return DATAITEMLocalServiceUtil.updateDATAITEM((vn.dtt.cmon.dm.dao.model.DATAITEM)arguments[0]);
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			DATAITEMLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getDataItem(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getNode3(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getNode2(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getNode1(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getByDataGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getByDataGroupId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return DATAITEMLocalServiceUtil.countByDataGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getByDataGroupLevel1(((Long)arguments[0]).longValue());
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getByDataGroupLevel1(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return DATAITEMLocalServiceUtil.countByDataGroupLevel1(((Long)arguments[0]).longValue());
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getByDataGroupLevel2(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getByDataGroupLevel2(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return DATAITEMLocalServiceUtil.countByDataGroupLevel2(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getByDataGroupLevel3(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getByDataGroupLevel3(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getDATAITEMByTen((java.lang.String)arguments[0]);
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return DATAITEMLocalServiceUtil.countByDataGroupLevel3(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return DATAITEMLocalServiceUtil.findDataItemByName((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getDATAITEMByDataGroupIdAndLevel(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getListHuyenGS((com.liferay.portal.model.User)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return DATAITEMLocalServiceUtil.countHuyenByUser((com.liferay.portal.model.User)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return DATAITEMLocalServiceUtil.findHuyenDuocChonByUser((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return DATAITEMLocalServiceUtil.findHuyenChonByUser((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return DATAITEMLocalServiceUtil.findXaTrongHuyenChonByUser((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getTinh((com.liferay.portal.model.User)arguments[0],
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getHuyen((com.liferay.portal.model.User)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Boolean)arguments[3]).booleanValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getXa((com.liferay.portal.model.User)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Boolean)arguments[4]).booleanValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getTramCap((com.liferay.portal.model.User)arguments[0],
				(java.lang.String)arguments[1],
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return DATAITEMLocalServiceUtil.findXaKhongInHuyenInTramByUser((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return DATAITEMLocalServiceUtil.findXaInHuyenInTramByUser((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return DATAITEMLocalServiceUtil.findHuyenInTramByUser((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return DATAITEMLocalServiceUtil.coutHuyenDaChonByUser((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return DATAITEMLocalServiceUtil.coutXaTrongHuyenDaChonByUser((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return DATAITEMLocalServiceUtil.checkTinhContains((java.lang.String)arguments[0],
				(java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM>)arguments[1]);
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getHuyenSelectByTinhUser((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getListTinhTU((com.liferay.portal.model.User)arguments[0],
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return DATAITEMLocalServiceUtil.countListTinhTU((com.liferay.portal.model.User)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getGSVInHuyen((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getUserInTramCap((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getListTramCap((com.liferay.portal.model.User)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getHuyenInTramCap((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return DATAITEMLocalServiceUtil.getXaInHuyenAndTramCap((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return DATAITEMLocalServiceUtil.countTramCapByUser((com.liferay.portal.model.User)arguments[0],
				(java.lang.String)arguments[1]);
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
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
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
	private String _methodName90;
	private String[] _methodParameterTypes90;
	private String _methodName91;
	private String[] _methodParameterTypes91;
	private String _methodName92;
	private String[] _methodParameterTypes92;
	private String _methodName93;
	private String[] _methodParameterTypes93;
	private String _methodName94;
	private String[] _methodParameterTypes94;
	private String _methodName95;
	private String[] _methodParameterTypes95;
	private String _methodName96;
	private String[] _methodParameterTypes96;
	private String _methodName97;
	private String[] _methodParameterTypes97;
	private String _methodName98;
	private String[] _methodParameterTypes98;
}