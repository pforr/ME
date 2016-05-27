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
public interface DauNoiNuocFinder {
	public java.util.List<vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc> findDauNoiNuoc(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, long tramCapId, int trangThaiKiemDem,
		int ketQuaKiemDem, java.lang.String kiemDemVienId, long idQuanLy,
		java.util.Date ngayKiemDem, int namBaoCao, long idNguoiTao,
		java.util.Date ngayTao, java.lang.String tenChuHo, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int countDauNoiNuoc(java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa, long tramCapId,
		int trangThaiKiemDem, int ketQuaKiemDem,
		java.lang.String kiemDemVienId, long idQuanLy,
		java.util.Date ngayKiemDem, int namBaoCao, long idNguoiTao,
		java.util.Date ngayTao, java.lang.String tenChuHo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int countThongKeMenuLeft(java.lang.String tableName,
		int initUserType, java.lang.String orgCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countDauNoiSearch(java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.lang.String tramCapNuocId, java.lang.String trangThai,
		java.lang.String namBaoCao)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc> getDauNoiSearch(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String tramCapNuocId,
		java.lang.String trangThai, java.lang.String namBaoCao, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public int countDataItemSearch(java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> getDataItemSearch(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC> getThongTinKeHoachKiemDemNuocSearch(
		java.lang.String keHoachId, java.lang.String trangThai,
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String nguonDL,
		java.lang.String danhGiaKiemDem, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countDauNoiByMaTinhTramIdTrangThaiAndNam(
		java.lang.String maTinh, java.lang.String tramCapNuocId,
		java.lang.String trangThai, java.lang.String namBaoCao);

	public java.util.List<vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc> getDauNoiByMaTinhTramIdTrangThaiAndNam(
		java.lang.String maTinh, java.lang.String tramCapNuocId,
		java.lang.String trangThai, java.lang.String namBaoCao);

	public java.util.List<java.lang.String> getHuyenXaKeHoachKiemDemNuocSearch(
		java.lang.String keHoachId, java.lang.String trangThai,
		java.lang.String maTinh, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc> getDauNoiByMaTinhTramIdTrangThaiAndNamThoiGianThuc(
		java.lang.String maTinh, java.lang.String danhgiakiemdem,
		java.lang.String namBaoCao);

	public java.util.List<vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc> getDauNoiSearch(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String tramCapNuocId,
		java.lang.String trangThai, java.lang.String namBaoCao,
		java.lang.String ngayNhap, java.lang.String idNguoiTao,
		java.lang.String advText, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countDauNoiSearch(java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.lang.String tramCapNuocId, java.lang.String trangThai,
		java.lang.String namBaoCao, java.lang.String ngayNhap,
		java.lang.String idNguoiTao, java.lang.String advText)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC> getThongTinKeHoachKiemDemNuocSearch(
		java.lang.String keHoachId, java.lang.String trangThai,
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String nguonDL,
		java.lang.String danhGiaKiemDem, java.lang.String advText, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public int countGioiTinhChuHo(java.lang.String maTinh,
		java.lang.String namBaoCao, java.lang.String gioiTinh);

	public java.util.List<vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc> getDauNoiGroupByMaTinhTW(
		java.lang.String namBaoCao);

	public java.util.List<vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc> getDauNoiGroupByTramCapIDTW(
		java.lang.String namBaoCao, java.lang.String trangThai);

	public int countDauNoiMoiByTrangThai(java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.lang.String tramCapNuocId, java.lang.String trangThai,
		java.lang.String namBaoCao)
		throws com.liferay.portal.kernel.exception.SystemException;
}