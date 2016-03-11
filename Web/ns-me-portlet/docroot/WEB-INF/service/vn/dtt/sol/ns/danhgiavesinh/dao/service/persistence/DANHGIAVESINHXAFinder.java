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

/**
 * @author khoa.vu
 */
public interface DANHGIAVESINHXAFinder {
	public java.util.List<vn.dtt.sol.ns.danhgiavesinh.dao.model.DANHGIAVESINHXA> getDanhGiaVeSinhXaBaoCao(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String namBaoCao,
		java.lang.String ketLuanVSTX)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int sumSoNguoiHuongLoiByMaTinh(java.lang.String maTinh,
		java.lang.String namBaoCao);

	public java.util.List<vn.dtt.sol.ns.danhgiavesinh.dao.model.DANHGIAVESINHXA> getDanhGiaVeSinhXaGroupByMaTinhTW(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String namBaoCao,
		java.lang.String ketLuanVSTX)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.dtt.sol.ns.danhgiavesinh.dao.model.DANHGIAVESINHXA> getDanhGiaVeSinhXaGroupByMaHuyenMaXaTW(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String namBaoCao,
		java.lang.String ketLuanVSTX)
		throws com.liferay.portal.kernel.exception.SystemException;

	public double getDanhGiaVeSinhXaTyLeAllTW(java.lang.String maTinh,
		java.lang.String namBaoCao, java.lang.String ketLuanVSTX,
		int isSumSoXa, int isCoNhaTieuHVS, int isCoNhaTieu,
		int isCoTyLeTruongHoc, int isCoTyLeTramYTe, int isSumSoNguoiHuongLoi);

	public java.util.List<vn.dtt.sol.ns.danhgiavesinh.dao.model.DANHGIAVESINHXA> getDanhGiaVeSinhXaGroupByMaHuyenMaXaBaoCaoHopNhat(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, int namBaoCao, int namToiThieu,
		java.lang.String ketLuanVSTX)
		throws com.liferay.portal.kernel.exception.SystemException;

	public double getDanhGiaVeSinhXaTyLeAllBaoCaoHopNhat(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, int namBaoCao, int namToiThieu,
		java.lang.String ketLuanVSTX, int isSumSoXa, int isCoNhaTieuHVS,
		int isCoNhaTieu, int isCoTyLeTruongHoc, int isCoTyLeTramYTe,
		int isSumSoNguoiHuongLoi);
}