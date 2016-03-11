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

package vn.dtt.sol.ns.kehoachvesinh.dao.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import vn.dtt.sol.ns.kehoachvesinh.dao.model.KeHoachVeSinh;
import vn.dtt.sol.ns.kehoachvesinh.dao.service.base.KeHoachVeSinhLocalServiceBaseImpl;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhGiaDinh;

/**
 * The implementation of the ke hoach ve sinh local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.dtt.sol.ns.kehoachvesinh.dao.service.KeHoachVeSinhLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author HANT
 * @see vn.dtt.sol.ns.kehoachvesinh.dao.service.base.KeHoachVeSinhLocalServiceBaseImpl
 * @see vn.dtt.sol.ns.kehoachvesinh.dao.service.KeHoachVeSinhLocalServiceUtil
 */
public class KeHoachVeSinhLocalServiceImpl extends
		KeHoachVeSinhLocalServiceBaseImpl {

	public List<VeSinhGiaDinh> finderHGD(String maTinh, String maHuyen,
			String maXa, String loaiNhaTieuId, String trangThai,
			String namBaoCao, String namBaoCaoVstx, String ngayNhap,
			String idNguoiTao, String advText, int start, int end)
			throws PortalException, SystemException {
		return keHoachVeSinhFinder.finderVSGD(maTinh, maHuyen, maXa,
				loaiNhaTieuId, trangThai, namBaoCao, namBaoCaoVstx, ngayNhap,
				idNguoiTao, advText, start, end);
	}

	public int countHGD(String maTinh, String maHuyen, String maXa,
			String loaiNhaTieuId, String trangThai, String namBaoCao,
			String namBaoCaoVstx, String ngayNhap, String idNguoiTao,
			String advText) throws PortalException, SystemException {
		return keHoachVeSinhFinder.countVSGD(maTinh, maHuyen, maXa,
				loaiNhaTieuId, trangThai, namBaoCao, namBaoCaoVstx, ngayNhap,
				idNguoiTao, advText);
	}

	public List<KeHoachVeSinh> search(long nam, String maTinh, String maHuyen,
			int start, int end) throws PortalException, SystemException {
		return keHoachVeSinhFinder.search(nam, maTinh, maHuyen, start, end);
	}

	public int count(long nam, String maTinh, String maHuyen)
			throws PortalException, SystemException {
		return keHoachVeSinhFinder.count(nam, maTinh, maHuyen);
	}

	public int countSoDanHuongLoi(String nam, String maTinh, String dangkyvstx)
			throws PortalException, SystemException {
		return keHoachVeSinhFinder.countSoDanHuongLoi(nam, maTinh, dangkyvstx);
	}

	public List<KeHoachVeSinh> getKeHoachVeSinhByNamTinhDangKyVSTX(String nam,
			String maTinh, String dangkyvstx) throws SystemException {
		return keHoachVeSinhFinder.getKeHoachVeSinhByNamTinhDangKyVSTX(nam,
				maTinh, dangkyvstx);
	}

	public int sumSoNhaTieuHVSMoiTW(String namBaoCao, String maTinh)
			throws SystemException {
		return keHoachVeSinhFinder.sumSoNhaTieuHVSMoiTW(namBaoCao, maTinh);
	}
}