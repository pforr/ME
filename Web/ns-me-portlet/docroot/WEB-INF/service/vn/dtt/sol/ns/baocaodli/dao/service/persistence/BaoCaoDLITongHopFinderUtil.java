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

package vn.dtt.sol.ns.baocaodli.dao.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author HuyMQ
 */
public class BaoCaoDLITongHopFinderUtil {
	public static vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHop getBaoCaoDLITongHopByTinhVaNam(
		java.lang.String maTinh, java.lang.String namBaoCao) {
		return getFinder().getBaoCaoDLITongHopByTinhVaNam(maTinh, namBaoCao);
	}

	public static java.util.List<vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHop> getListBaoCaoDLITongHopByNamTW(
		java.lang.String namBaoCao) {
		return getFinder().getListBaoCaoDLITongHopByNamTW(namBaoCao);
	}

	public static int sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(
		java.lang.String maTinh, int namBaoCao, int namToiThieu,
		int is11TheoKeHoach, int is11ThucTe, int is12TheoKeHoach,
		int is12ThucTe, int is21TheoKeHoach, int is22TheoKeHoach,
		int is31TheoKeHoach, int is31ThucTe, int is32TheoKeHoach, int is32ThucTe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(maTinh,
			namBaoCao, namToiThieu, is11TheoKeHoach, is11ThucTe,
			is12TheoKeHoach, is12ThucTe, is21TheoKeHoach, is22TheoKeHoach,
			is31TheoKeHoach, is31ThucTe, is32TheoKeHoach, is32ThucTe);
	}

	public static BaoCaoDLITongHopFinder getFinder() {
		if (_finder == null) {
			_finder = (BaoCaoDLITongHopFinder)PortletBeanLocatorUtil.locate(vn.dtt.sol.ns.baocaodli.dao.service.ClpSerializer.getServletContextName(),
					BaoCaoDLITongHopFinder.class.getName());

			ReferenceRegistry.registerReference(BaoCaoDLITongHopFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(BaoCaoDLITongHopFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(BaoCaoDLITongHopFinderUtil.class,
			"_finder");
	}

	private static BaoCaoDLITongHopFinder _finder;
}