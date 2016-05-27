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

package vn.dtt.cmon.kiemdemvien.dao.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the KiemDemVien service. Represents a row in the &quot;ME_KIEMDEMVIEN&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.dtt.cmon.kiemdemvien.dao.model.impl.KiemDemVienModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.dtt.cmon.kiemdemvien.dao.model.impl.KiemDemVienImpl}.
 * </p>
 *
 * @author HANT
 * @see KiemDemVien
 * @see vn.dtt.cmon.kiemdemvien.dao.model.impl.KiemDemVienImpl
 * @see vn.dtt.cmon.kiemdemvien.dao.model.impl.KiemDemVienModelImpl
 * @generated
 */
public interface KiemDemVienModel extends BaseModel<KiemDemVien> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a kiem dem vien model instance should use the {@link KiemDemVien} interface instead.
	 */

	/**
	 * Returns the primary key of this kiem dem vien.
	 *
	 * @return the primary key of this kiem dem vien
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this kiem dem vien.
	 *
	 * @param primaryKey the primary key of this kiem dem vien
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this kiem dem vien.
	 *
	 * @return the ID of this kiem dem vien
	 */
	public long getId();

	/**
	 * Sets the ID of this kiem dem vien.
	 *
	 * @param id the ID of this kiem dem vien
	 */
	public void setId(long id);

	/**
	 * Returns the ho va ten of this kiem dem vien.
	 *
	 * @return the ho va ten of this kiem dem vien
	 */
	@AutoEscape
	public String getHoVaTen();

	/**
	 * Sets the ho va ten of this kiem dem vien.
	 *
	 * @param hoVaTen the ho va ten of this kiem dem vien
	 */
	public void setHoVaTen(String hoVaTen);

	/**
	 * Returns the tai khoan of this kiem dem vien.
	 *
	 * @return the tai khoan of this kiem dem vien
	 */
	@AutoEscape
	public String getTaiKhoan();

	/**
	 * Sets the tai khoan of this kiem dem vien.
	 *
	 * @param taiKhoan the tai khoan of this kiem dem vien
	 */
	public void setTaiKhoan(String taiKhoan);

	/**
	 * Returns the mat khau of this kiem dem vien.
	 *
	 * @return the mat khau of this kiem dem vien
	 */
	@AutoEscape
	public String getMatKhau();

	/**
	 * Sets the mat khau of this kiem dem vien.
	 *
	 * @param matKhau the mat khau of this kiem dem vien
	 */
	public void setMatKhau(String matKhau);

	/**
	 * Returns the cap hoat dong of this kiem dem vien.
	 *
	 * @return the cap hoat dong of this kiem dem vien
	 */
	public long getCapHoatDong();

	/**
	 * Sets the cap hoat dong of this kiem dem vien.
	 *
	 * @param capHoatDong the cap hoat dong of this kiem dem vien
	 */
	public void setCapHoatDong(long capHoatDong);

	/**
	 * Returns the org code1 of this kiem dem vien.
	 *
	 * @return the org code1 of this kiem dem vien
	 */
	@AutoEscape
	public String getOrgCode1();

	/**
	 * Sets the org code1 of this kiem dem vien.
	 *
	 * @param orgCode1 the org code1 of this kiem dem vien
	 */
	public void setOrgCode1(String orgCode1);

	/**
	 * Returns the org code2 of this kiem dem vien.
	 *
	 * @return the org code2 of this kiem dem vien
	 */
	@AutoEscape
	public String getOrgCode2();

	/**
	 * Sets the org code2 of this kiem dem vien.
	 *
	 * @param orgCode2 the org code2 of this kiem dem vien
	 */
	public void setOrgCode2(String orgCode2);

	/**
	 * Returns the dia chi of this kiem dem vien.
	 *
	 * @return the dia chi of this kiem dem vien
	 */
	@AutoEscape
	public String getDiaChi();

	/**
	 * Sets the dia chi of this kiem dem vien.
	 *
	 * @param diaChi the dia chi of this kiem dem vien
	 */
	public void setDiaChi(String diaChi);

	/**
	 * Returns the chung minh thu of this kiem dem vien.
	 *
	 * @return the chung minh thu of this kiem dem vien
	 */
	@AutoEscape
	public String getChungMinhThu();

	/**
	 * Sets the chung minh thu of this kiem dem vien.
	 *
	 * @param chungMinhThu the chung minh thu of this kiem dem vien
	 */
	public void setChungMinhThu(String chungMinhThu);

	/**
	 * Returns the dien thoai of this kiem dem vien.
	 *
	 * @return the dien thoai of this kiem dem vien
	 */
	@AutoEscape
	public String getDienThoai();

	/**
	 * Sets the dien thoai of this kiem dem vien.
	 *
	 * @param dienThoai the dien thoai of this kiem dem vien
	 */
	public void setDienThoai(String dienThoai);

	/**
	 * Returns the imei of this kiem dem vien.
	 *
	 * @return the imei of this kiem dem vien
	 */
	@AutoEscape
	public String getImei();

	/**
	 * Sets the imei of this kiem dem vien.
	 *
	 * @param imei the imei of this kiem dem vien
	 */
	public void setImei(String imei);

	/**
	 * Returns the trang thai of this kiem dem vien.
	 *
	 * @return the trang thai of this kiem dem vien
	 */
	public long getTrangThai();

	/**
	 * Sets the trang thai of this kiem dem vien.
	 *
	 * @param trangThai the trang thai of this kiem dem vien
	 */
	public void setTrangThai(long trangThai);

	/**
	 * Returns the ngay tao of this kiem dem vien.
	 *
	 * @return the ngay tao of this kiem dem vien
	 */
	public Date getNgayTao();

	/**
	 * Sets the ngay tao of this kiem dem vien.
	 *
	 * @param ngayTao the ngay tao of this kiem dem vien
	 */
	public void setNgayTao(Date ngayTao);

	/**
	 * Returns the id nguoi tao of this kiem dem vien.
	 *
	 * @return the id nguoi tao of this kiem dem vien
	 */
	public long getIdNguoiTao();

	/**
	 * Sets the id nguoi tao of this kiem dem vien.
	 *
	 * @param idNguoiTao the id nguoi tao of this kiem dem vien
	 */
	public void setIdNguoiTao(long idNguoiTao);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(KiemDemVien kiemDemVien);

	@Override
	public int hashCode();

	@Override
	public CacheModel<KiemDemVien> toCacheModel();

	@Override
	public KiemDemVien toEscapedModel();

	@Override
	public KiemDemVien toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}