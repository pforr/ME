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

package vn.dtt.sol.ns.tramcap.dao.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the KeHoachNuocSach service. Represents a row in the &quot;ME_KEHOACHNUOCSACH&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.dtt.sol.ns.tramcap.dao.model.impl.KeHoachNuocSachModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.dtt.sol.ns.tramcap.dao.model.impl.KeHoachNuocSachImpl}.
 * </p>
 *
 * @author khoa.vu
 * @see KeHoachNuocSach
 * @see vn.dtt.sol.ns.tramcap.dao.model.impl.KeHoachNuocSachImpl
 * @see vn.dtt.sol.ns.tramcap.dao.model.impl.KeHoachNuocSachModelImpl
 * @generated
 */
public interface KeHoachNuocSachModel extends BaseModel<KeHoachNuocSach> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ke hoach nuoc sach model instance should use the {@link KeHoachNuocSach} interface instead.
	 */

	/**
	 * Returns the primary key of this ke hoach nuoc sach.
	 *
	 * @return the primary key of this ke hoach nuoc sach
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ke hoach nuoc sach.
	 *
	 * @param primaryKey the primary key of this ke hoach nuoc sach
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this ke hoach nuoc sach.
	 *
	 * @return the ID of this ke hoach nuoc sach
	 */
	public long getId();

	/**
	 * Sets the ID of this ke hoach nuoc sach.
	 *
	 * @param id the ID of this ke hoach nuoc sach
	 */
	public void setId(long id);

	/**
	 * Returns the tram cap nuoc ID of this ke hoach nuoc sach.
	 *
	 * @return the tram cap nuoc ID of this ke hoach nuoc sach
	 */
	public int getTramCapNuocId();

	/**
	 * Sets the tram cap nuoc ID of this ke hoach nuoc sach.
	 *
	 * @param tramCapNuocId the tram cap nuoc ID of this ke hoach nuoc sach
	 */
	public void setTramCapNuocId(int tramCapNuocId);

	/**
	 * Returns the nam of this ke hoach nuoc sach.
	 *
	 * @return the nam of this ke hoach nuoc sach
	 */
	public int getNam();

	/**
	 * Sets the nam of this ke hoach nuoc sach.
	 *
	 * @param nam the nam of this ke hoach nuoc sach
	 */
	public void setNam(int nam);

	/**
	 * Returns the so dau noi moi of this ke hoach nuoc sach.
	 *
	 * @return the so dau noi moi of this ke hoach nuoc sach
	 */
	public int getSoDauNoiMoi();

	/**
	 * Sets the so dau noi moi of this ke hoach nuoc sach.
	 *
	 * @param soDauNoiMoi the so dau noi moi of this ke hoach nuoc sach
	 */
	public void setSoDauNoiMoi(int soDauNoiMoi);

	/**
	 * Returns the so nguoi huong loi of this ke hoach nuoc sach.
	 *
	 * @return the so nguoi huong loi of this ke hoach nuoc sach
	 */
	public int getSoNguoiHuongLoi();

	/**
	 * Sets the so nguoi huong loi of this ke hoach nuoc sach.
	 *
	 * @param soNguoiHuongLoi the so nguoi huong loi of this ke hoach nuoc sach
	 */
	public void setSoNguoiHuongLoi(int soNguoiHuongLoi);

	/**
	 * Returns the ghi chu of this ke hoach nuoc sach.
	 *
	 * @return the ghi chu of this ke hoach nuoc sach
	 */
	@AutoEscape
	public String getGhiChu();

	/**
	 * Sets the ghi chu of this ke hoach nuoc sach.
	 *
	 * @param ghiChu the ghi chu of this ke hoach nuoc sach
	 */
	public void setGhiChu(String ghiChu);

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
	public int compareTo(KeHoachNuocSach keHoachNuocSach);

	@Override
	public int hashCode();

	@Override
	public CacheModel<KeHoachNuocSach> toCacheModel();

	@Override
	public KeHoachNuocSach toEscapedModel();

	@Override
	public KeHoachNuocSach toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}