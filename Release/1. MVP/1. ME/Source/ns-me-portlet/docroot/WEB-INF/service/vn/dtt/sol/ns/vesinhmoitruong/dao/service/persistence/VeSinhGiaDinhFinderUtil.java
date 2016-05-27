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
public class VeSinhGiaDinhFinderUtil {
	public static int countVeSinhGiaDinhSearch(java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.lang.String loaiNhaTieuId, java.lang.String trangThai,
		java.lang.String namBaoCao, java.lang.String namBaoCaoVstx)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countVeSinhGiaDinhSearch(maTinh, maHuyen, maXa,
			loaiNhaTieuId, trangThai, namBaoCao, namBaoCaoVstx);
	}

	public static java.util.List<vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhGiaDinh> getVeSinhGiaDinhSearch(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String loaiNhaTieuId,
		java.lang.String trangThai, java.lang.String namBaoCao,
		java.lang.String namBaoCaoVstx, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getVeSinhGiaDinhSearch(maTinh, maHuyen, maXa,
			loaiNhaTieuId, trangThai, namBaoCao, namBaoCaoVstx, start, end);
	}

	public static java.util.List<vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhGiaDinh> getVeSinhGiaDinhGroupByMaHuyen(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String loaiNhaTieuId,
		java.lang.String trangThai, java.lang.String namBaoCao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getVeSinhGiaDinhGroupByMaHuyen(maTinh, maHuyen, maXa,
			loaiNhaTieuId, trangThai, namBaoCao);
	}

	public static VeSinhGiaDinhFinder getFinder() {
		if (_finder == null) {
			_finder = (VeSinhGiaDinhFinder)PortletBeanLocatorUtil.locate(vn.dtt.sol.ns.vesinhmoitruong.dao.service.ClpSerializer.getServletContextName(),
					VeSinhGiaDinhFinder.class.getName());

			ReferenceRegistry.registerReference(VeSinhGiaDinhFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(VeSinhGiaDinhFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VeSinhGiaDinhFinderUtil.class,
			"_finder");
	}

	private static VeSinhGiaDinhFinder _finder;
}