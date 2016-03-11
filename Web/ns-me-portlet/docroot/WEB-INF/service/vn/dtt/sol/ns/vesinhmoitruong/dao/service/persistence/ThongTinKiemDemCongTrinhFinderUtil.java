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

package vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author BinhTH
 */
public class ThongTinKiemDemCongTrinhFinderUtil {
	public static java.util.List<vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemCongTrinh> getListThongTinKiemDemCongTrinhByKeHoachId(
		int keHoachId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getListThongTinKiemDemCongTrinhByKeHoachId(keHoachId);
	}

	public static vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemCongTrinh getThongTinKiemDemCongTrinhByVeSinhCTID(
		java.lang.String VESINHCONGTRINHID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getThongTinKiemDemCongTrinhByVeSinhCTID(VESINHCONGTRINHID);
	}

	public static ThongTinKiemDemCongTrinhFinder getFinder() {
		if (_finder == null) {
			_finder = (ThongTinKiemDemCongTrinhFinder)PortletBeanLocatorUtil.locate(vn.dtt.sol.ns.vesinhmoitruong.dao.service.ClpSerializer.getServletContextName(),
					ThongTinKiemDemCongTrinhFinder.class.getName());

			ReferenceRegistry.registerReference(ThongTinKiemDemCongTrinhFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ThongTinKiemDemCongTrinhFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ThongTinKiemDemCongTrinhFinderUtil.class,
			"_finder");
	}

	private static ThongTinKiemDemCongTrinhFinder _finder;
}