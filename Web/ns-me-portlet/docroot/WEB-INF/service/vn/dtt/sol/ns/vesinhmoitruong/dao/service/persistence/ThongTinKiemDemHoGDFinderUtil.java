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
public class ThongTinKiemDemHoGDFinderUtil {
	public static java.util.List<vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemHoGD> getThongTinKiemDemHGDThoiGianThucGroupBy(
		java.lang.String maTinh, java.lang.String namBaoCao,
		java.lang.String[] danhgiakiemdem, java.lang.String daketthucdieutra)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getThongTinKiemDemHGDThoiGianThucGroupBy(maTinh, namBaoCao,
			danhgiakiemdem, daketthucdieutra);
	}

	public static int countThongTinKiemDemHGDThoiGianThucGroupBy(
		java.lang.String maTinh, java.lang.String namBaoCao,
		java.lang.String[] danhgiakiemdem, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String daketthucdieutra)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countThongTinKiemDemHGDThoiGianThucGroupBy(maTinh,
			namBaoCao, danhgiakiemdem, maHuyen, maXa, daketthucdieutra);
	}

	public static java.util.List<vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemHoGD> getThongTinKiemDemHGDThoiGianThuc(
		java.lang.String maTinh, java.lang.String namBaoCao,
		java.lang.String[] danhgiakiemdem, java.lang.String daketthucdieutra)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getThongTinKiemDemHGDThoiGianThuc(maTinh, namBaoCao,
			danhgiakiemdem, daketthucdieutra);
	}

	public static java.util.List<vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemHoGD> getListThongTinKiemDemHoGiaDinhByKeHoachId(
		int keHoachId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getListThongTinKiemDemHoGiaDinhByKeHoachId(keHoachId);
	}

	public static int countGioiTinhChuHo(java.lang.String maTinh,
		java.lang.String namBaoCao, java.lang.String gioiTinhChuHo,
		java.lang.String[] danhGiaKiemDem, java.lang.String daKetThucDieuTra)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countGioiTinhChuHo(maTinh, namBaoCao, gioiTinhChuHo,
			danhGiaKiemDem, daKetThucDieuTra);
	}

	public static int countGioiTinhChuHoByMauNNVSTXJoinVSGD(
		java.lang.String maTinh, java.lang.String mauNgauNhien,
		java.lang.String gioiTinhChuHo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countGioiTinhChuHoByMauNNVSTXJoinVSGD(maTinh, mauNgauNhien,
			gioiTinhChuHo);
	}

	public static int countGioiTinhChuHoBaoCaoHopNhat(java.lang.String maTinh,
		int namBaoCao, int namToiThieu, java.lang.String gioiTinhChuHo,
		java.lang.String[] danhGiaKiemDem, java.lang.String daKetThucDieuTra)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countGioiTinhChuHoBaoCaoHopNhat(maTinh, namBaoCao,
			namToiThieu, gioiTinhChuHo, danhGiaKiemDem, daKetThucDieuTra);
	}

	public static int countGioiTinhChuHoByMauNNVSTXJoinVSGDBaoCaoHopNhat(
		java.lang.String maTinh, int namMauNgauNhien, int namToiThieu,
		java.lang.String gioiTinhChuHo, java.lang.String[] danhGiaKiemDem,
		java.lang.String daKetThucDieuTra)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countGioiTinhChuHoByMauNNVSTXJoinVSGDBaoCaoHopNhat(maTinh,
			namMauNgauNhien, namToiThieu, gioiTinhChuHo, danhGiaKiemDem,
			daKetThucDieuTra);
	}

	public static ThongTinKiemDemHoGDFinder getFinder() {
		if (_finder == null) {
			_finder = (ThongTinKiemDemHoGDFinder)PortletBeanLocatorUtil.locate(vn.dtt.sol.ns.vesinhmoitruong.dao.service.ClpSerializer.getServletContextName(),
					ThongTinKiemDemHoGDFinder.class.getName());

			ReferenceRegistry.registerReference(ThongTinKiemDemHoGDFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ThongTinKiemDemHoGDFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ThongTinKiemDemHoGDFinderUtil.class,
			"_finder");
	}

	private static ThongTinKiemDemHoGDFinder _finder;
}