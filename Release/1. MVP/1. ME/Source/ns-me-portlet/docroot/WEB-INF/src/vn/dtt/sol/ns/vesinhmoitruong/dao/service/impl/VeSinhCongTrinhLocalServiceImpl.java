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

package vn.dtt.sol.ns.vesinhmoitruong.dao.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhCongTrinh;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhGiaDinh;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.base.VeSinhCongTrinhLocalServiceBaseImpl;

/**
 * The implementation of the ve sinh cong trinh local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.sol.ns.vesinhmoitruong.dao.service.VeSinhCongTrinhLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author BinhTH
 * @see vn.dtt.sol.ns.vesinhmoitruong.dao.service.base.VeSinhCongTrinhLocalServiceBaseImpl
 * @see vn.dtt.sol.ns.vesinhmoitruong.dao.service.VeSinhCongTrinhLocalServiceUtil
 */
public class VeSinhCongTrinhLocalServiceImpl
	extends VeSinhCongTrinhLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.dtt.sol.ns.vesinhmoitruong.dao.service.VeSinhCongTrinhLocalServiceUtil} to access the ve sinh cong trinh local service.
	 */
	public int countVeSinhCongTrinhSearch(String maTinh,String maHuyen,String maXa,String loaiNhaTieuId, String loaiCongTrinh,String trangThai,String namBaoCao) throws SystemException {
		return veSinhCongTrinhFinder.countVeSinhCongTrinhSearch(maTinh, maHuyen, maXa, loaiNhaTieuId, loaiCongTrinh, trangThai, namBaoCao);
	}
	public List<VeSinhCongTrinh> getVeSinhCongTrinhSearch(String maTinh,String maHuyen,String maXa,String loaiNhaTieuId, String loaiCongTrinh,String trangThai,String namBaoCao,int start,int end) throws SystemException {
		return veSinhCongTrinhFinder.getVeSinhCongTrinhSearch(maTinh, maHuyen, maXa, loaiNhaTieuId, loaiCongTrinh, trangThai, namBaoCao, start, end);
	}
}