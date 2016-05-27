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

package vn.dtt.cmon.kiemdemvien.dao.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien;
import vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalServiceUtil;
import vn.dtt.cmon.kiemdemvien.dao.service.base.KiemDemVienLocalServiceBaseImpl;
import vn.dtt.cmon.kiemdemvien.dao.service.persistence.KiemDemVienFinderImpl;
import vn.dtt.cmon.kiemdemvien.dao.service.persistence.KiemDemVienPersistence;

/**
 * The implementation of the kiem dem vien local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author HANT
 * @see vn.dtt.cmon.kiemdemvien.dao.service.base.KiemDemVienLocalServiceBaseImpl
 * @see vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalServiceUtil
 */
public class KiemDemVienLocalServiceImpl extends
		KiemDemVienLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalServiceUtil} to
	 * access the kiem dem vien local service.
	 */
	public int countAll() throws PortalException, SystemException {
		return kiemDemVienPersistence.countAll();
	}

	public List<KiemDemVien> findAll() throws PortalException, SystemException {
		return kiemDemVienPersistence.findAll();
	}

	public void addKiemDemVien(String hoVaTen, String taiKhoan, String matKhau,
			int capHoatDong, String orgCode1, String orgCode2, String diaChi,
			String chungMinhThu, String dienThoai, String imei, int idNguoiTao)
			throws PortalException, SystemException {

		kiemDemVienFinder.addKiemDemVien(hoVaTen, taiKhoan, matKhau,
				capHoatDong, orgCode1, orgCode2, diaChi, chungMinhThu,
				dienThoai, imei, idNguoiTao);
	}

	public void chuyenTrangThai(long id) throws PortalException, SystemException{
		kiemDemVienFinder.chuyenTrangThai(id);
	}
	
	public List<KiemDemVien> find(String capHoatDong, String orgCode2, int start, int end) 
			throws PortalException, SystemException{
		return kiemDemVienFinder.find(capHoatDong, orgCode2, start, end);
	}
	
	public long count(String capHoatDong, String orgCode2)
			throws PortalException, SystemException{
		return kiemDemVienFinder.count(capHoatDong, orgCode2);
	}
	
	public List<KiemDemVien> findKiemDemVien(String capHoatDong, String orgCode) 
			throws PortalException, SystemException{
		return kiemDemVienFinder.findKiemDemVien(capHoatDong, orgCode);
	}
	
	public KiemDemVien getByTaiKhoan(String taiKhoan)
			throws PortalException, SystemException{
		return kiemDemVienPersistence.findByTK(taiKhoan);
	}
}