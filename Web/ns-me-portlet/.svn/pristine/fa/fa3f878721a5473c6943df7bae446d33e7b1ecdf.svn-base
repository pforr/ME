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

package vn.dtt.sol.ns.tramcap.dao.service.persistence;

/**
 * @author khoa.vu
 */
public interface DanhGiaBenVungFinder {
	public java.util.List<vn.dtt.sol.ns.tramcap.dao.model.DanhGiaBenVung> findDanhGiaBenVung(
		int[] lsTramCap, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int countDanhGia(int[] lsTramCap)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public vn.dtt.sol.ns.tramcap.dao.model.DanhGiaBenVung getDanhGiaBenVungByTramCapNuocAndNam(
		long tramCapNuocId, java.lang.String nam, java.lang.String ketquadanhgia);

	public int sumSoNgHgLoiByMaTinhHuyenXaTramCapId(java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.lang.String namBaoCao, java.lang.String ketquadanhgia,
		java.lang.String tramCapNuocId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public double calcuInDanhGiaBenVungBaoCaoHopNhat(java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa, int namBaoCao,
		int namToiThieu, java.lang.String tramCapNuocId, int isNcThatThoat,
		int isTongDoanhThu, int isTongChiPhi)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}