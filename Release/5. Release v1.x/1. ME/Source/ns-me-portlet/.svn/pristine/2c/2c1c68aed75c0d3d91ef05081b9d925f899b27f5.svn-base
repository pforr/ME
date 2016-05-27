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

package vn.dtt.sol.ns.danhgiavesinh.dao.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author khoa.vu
 */
public class DANHGIAVESINHXAFinderUtil {
	public static java.util.List<vn.dtt.sol.ns.danhgiavesinh.dao.model.DANHGIAVESINHXA> getDanhGiaVeSinhXaBaoCao(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String namBaoCao,
		java.lang.String ketLuanVSTX)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getDanhGiaVeSinhXaBaoCao(maTinh, maHuyen, maXa, namBaoCao,
			ketLuanVSTX);
	}

	public static int sumSoNguoiHuongLoiByMaTinh(java.lang.String maTinh,
		java.lang.String namBaoCao) {
		return getFinder().sumSoNguoiHuongLoiByMaTinh(maTinh, namBaoCao);
	}

	public static java.util.List<vn.dtt.sol.ns.danhgiavesinh.dao.model.DANHGIAVESINHXA> getDanhGiaVeSinhXaGroupByMaTinhTW(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String namBaoCao,
		java.lang.String ketLuanVSTX)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getDanhGiaVeSinhXaGroupByMaTinhTW(maTinh, maHuyen, maXa,
			namBaoCao, ketLuanVSTX);
	}

	public static java.util.List<vn.dtt.sol.ns.danhgiavesinh.dao.model.DANHGIAVESINHXA> getDanhGiaVeSinhXaGroupByMaHuyenMaXaTW(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String namBaoCao,
		java.lang.String ketLuanVSTX)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getDanhGiaVeSinhXaGroupByMaHuyenMaXaTW(maTinh, maHuyen,
			maXa, namBaoCao, ketLuanVSTX);
	}

	public static double getDanhGiaVeSinhXaTyLeAllTW(java.lang.String maTinh,
		java.lang.String namBaoCao, java.lang.String ketLuanVSTX,
		int isSumSoXa, int isCoNhaTieuHVS, int isCoNhaTieu,
		int isCoTyLeTruongHoc, int isCoTyLeTramYTe, int isSumSoNguoiHuongLoi) {
		return getFinder()
				   .getDanhGiaVeSinhXaTyLeAllTW(maTinh, namBaoCao, ketLuanVSTX,
			isSumSoXa, isCoNhaTieuHVS, isCoNhaTieu, isCoTyLeTruongHoc,
			isCoTyLeTramYTe, isSumSoNguoiHuongLoi);
	}

	public static java.util.List<vn.dtt.sol.ns.danhgiavesinh.dao.model.DANHGIAVESINHXA> getDanhGiaVeSinhXaGroupByMaHuyenMaXaBaoCaoHopNhat(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, int namBaoCao, int namToiThieu,
		java.lang.String ketLuanVSTX)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getDanhGiaVeSinhXaGroupByMaHuyenMaXaBaoCaoHopNhat(maTinh,
			maHuyen, maXa, namBaoCao, namToiThieu, ketLuanVSTX);
	}

	public static double getDanhGiaVeSinhXaTyLeAllBaoCaoHopNhat(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, int namBaoCao, int namToiThieu,
		java.lang.String ketLuanVSTX, int isSumSoXa, int isCoNhaTieuHVS,
		int isCoNhaTieu, int isCoTyLeTruongHoc, int isCoTyLeTramYTe,
		int isSumSoNguoiHuongLoi) {
		return getFinder()
				   .getDanhGiaVeSinhXaTyLeAllBaoCaoHopNhat(maTinh, maHuyen,
			maXa, namBaoCao, namToiThieu, ketLuanVSTX, isSumSoXa,
			isCoNhaTieuHVS, isCoNhaTieu, isCoTyLeTruongHoc, isCoTyLeTramYTe,
			isSumSoNguoiHuongLoi);
	}

	public static DANHGIAVESINHXAFinder getFinder() {
		if (_finder == null) {
			_finder = (DANHGIAVESINHXAFinder)PortletBeanLocatorUtil.locate(vn.dtt.sol.ns.danhgiavesinh.dao.service.ClpSerializer.getServletContextName(),
					DANHGIAVESINHXAFinder.class.getName());

			ReferenceRegistry.registerReference(DANHGIAVESINHXAFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(DANHGIAVESINHXAFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(DANHGIAVESINHXAFinderUtil.class,
			"_finder");
	}

	private static DANHGIAVESINHXAFinder _finder;
}