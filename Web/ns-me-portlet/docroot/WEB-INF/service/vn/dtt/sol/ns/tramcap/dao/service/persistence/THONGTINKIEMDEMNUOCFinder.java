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
public interface THONGTINKIEMDEMNUOCFinder {
	public java.util.List<vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC> getThongTinDNNThoiGianThuc(
		java.lang.String maTinh, java.lang.String namBaoCao,
		java.lang.String danhgiakiemdem, java.lang.String daketthucdieutra)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC> getThongTinDNNTHVGGroupByMaTinh(
		java.lang.String maTinh, java.lang.String namDauNoiThucTe,
		java.lang.String danhgiakiemdem, java.lang.String daketthucdieutra)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countGioiTinhChuHo(java.lang.String maTinh,
		java.lang.String namBaoCao, java.lang.String gioiTinhChuHo,
		java.lang.String danhGiaKiemDem, java.lang.String daKetThucDieuTra);

	public int countGioiTinhChuHoBaoCaoHopNhat(java.lang.String maTinh,
		int namBaoCao, int namToiThieu, java.lang.String gioiTinhChuHo,
		java.lang.String danhGiaKiemDem, java.lang.String daKetThucDieuTra);

	public java.util.List<vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC> getThongTinDNNTHVGGroupByMaTinhBaoCaoHopNhatTU(
		java.lang.String maTinh, int namBaoCao, int namToiThieu,
		java.lang.String danhgiakiemdem, java.lang.String daketthucdieutra)
		throws com.liferay.portal.kernel.exception.SystemException;

	public vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC getDauNoiNuocBaoCaoSearchHelp(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String maTramCap,
		java.lang.String dauNoiNuocId)
		throws com.liferay.portal.kernel.exception.SystemException;
}