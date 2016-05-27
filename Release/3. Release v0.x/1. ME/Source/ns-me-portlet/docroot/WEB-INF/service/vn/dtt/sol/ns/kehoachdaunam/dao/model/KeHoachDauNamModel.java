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

package vn.dtt.sol.ns.kehoachdaunam.dao.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the KeHoachDauNam service. Represents a row in the &quot;ME_KEHOACHNUOCSACH&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.dtt.sol.ns.kehoachdaunam.dao.model.impl.KeHoachDauNamModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.dtt.sol.ns.kehoachdaunam.dao.model.impl.KeHoachDauNamImpl}.
 * </p>
 *
 * @author HANT
 * @see KeHoachDauNam
 * @see vn.dtt.sol.ns.kehoachdaunam.dao.model.impl.KeHoachDauNamImpl
 * @see vn.dtt.sol.ns.kehoachdaunam.dao.model.impl.KeHoachDauNamModelImpl
 * @generated
 */
public interface KeHoachDauNamModel extends BaseModel<KeHoachDauNam> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ke hoach dau nam model instance should use the {@link KeHoachDauNam} interface instead.
	 */

	/**
	 * Returns the primary key of this ke hoach dau nam.
	 *
	 * @return the primary key of this ke hoach dau nam
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ke hoach dau nam.
	 *
	 * @param primaryKey the primary key of this ke hoach dau nam
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this ke hoach dau nam.
	 *
	 * @return the ID of this ke hoach dau nam
	 */
	public long getId();

	/**
	 * Sets the ID of this ke hoach dau nam.
	 *
	 * @param id the ID of this ke hoach dau nam
	 */
	public void setId(long id);

	/**
	 * Returns the tram cap nuoc ID of this ke hoach dau nam.
	 *
	 * @return the tram cap nuoc ID of this ke hoach dau nam
	 */
	public long getTramCapNuocId();

	/**
	 * Sets the tram cap nuoc ID of this ke hoach dau nam.
	 *
	 * @param tramCapNuocId the tram cap nuoc ID of this ke hoach dau nam
	 */
	public void setTramCapNuocId(long tramCapNuocId);

	/**
	 * Returns the nam of this ke hoach dau nam.
	 *
	 * @return the nam of this ke hoach dau nam
	 */
	public long getNam();

	/**
	 * Sets the nam of this ke hoach dau nam.
	 *
	 * @param nam the nam of this ke hoach dau nam
	 */
	public void setNam(long nam);

	/**
	 * Returns the so dau noi moi of this ke hoach dau nam.
	 *
	 * @return the so dau noi moi of this ke hoach dau nam
	 */
	public long getSoDauNoiMoi();

	/**
	 * Sets the so dau noi moi of this ke hoach dau nam.
	 *
	 * @param soDauNoiMoi the so dau noi moi of this ke hoach dau nam
	 */
	public void setSoDauNoiMoi(long soDauNoiMoi);

	/**
	 * Returns the so ho huong loi of this ke hoach dau nam.
	 *
	 * @return the so ho huong loi of this ke hoach dau nam
	 */
	public long getSoHoHuongLoi();

	/**
	 * Sets the so ho huong loi of this ke hoach dau nam.
	 *
	 * @param soHoHuongLoi the so ho huong loi of this ke hoach dau nam
	 */
	public void setSoHoHuongLoi(long soHoHuongLoi);

	/**
	 * Returns the so nguoi huong loi of this ke hoach dau nam.
	 *
	 * @return the so nguoi huong loi of this ke hoach dau nam
	 */
	public long getSoNguoiHuongLoi();

	/**
	 * Sets the so nguoi huong loi of this ke hoach dau nam.
	 *
	 * @param soNguoiHuongLoi the so nguoi huong loi of this ke hoach dau nam
	 */
	public void setSoNguoiHuongLoi(long soNguoiHuongLoi);

	/**
	 * Returns the ghi chu of this ke hoach dau nam.
	 *
	 * @return the ghi chu of this ke hoach dau nam
	 */
	@AutoEscape
	public String getGhiChu();

	/**
	 * Sets the ghi chu of this ke hoach dau nam.
	 *
	 * @param ghiChu the ghi chu of this ke hoach dau nam
	 */
	public void setGhiChu(String ghiChu);

	/**
	 * Returns the bao cao d l i of this ke hoach dau nam.
	 *
	 * @return the bao cao d l i of this ke hoach dau nam
	 */
	public long getBaoCaoDLI();

	/**
	 * Sets the bao cao d l i of this ke hoach dau nam.
	 *
	 * @param baoCaoDLI the bao cao d l i of this ke hoach dau nam
	 */
	public void setBaoCaoDLI(long baoCaoDLI);

	/**
	 * Returns the ngay tao of this ke hoach dau nam.
	 *
	 * @return the ngay tao of this ke hoach dau nam
	 */
	public Date getNgayTao();

	/**
	 * Sets the ngay tao of this ke hoach dau nam.
	 *
	 * @param ngayTao the ngay tao of this ke hoach dau nam
	 */
	public void setNgayTao(Date ngayTao);

	/**
	 * Returns the id nguoi tao of this ke hoach dau nam.
	 *
	 * @return the id nguoi tao of this ke hoach dau nam
	 */
	public long getIdNguoiTao();

	/**
	 * Sets the id nguoi tao of this ke hoach dau nam.
	 *
	 * @param idNguoiTao the id nguoi tao of this ke hoach dau nam
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
	public int compareTo(KeHoachDauNam keHoachDauNam);

	@Override
	public int hashCode();

	@Override
	public CacheModel<KeHoachDauNam> toCacheModel();

	@Override
	public KeHoachDauNam toEscapedModel();

	@Override
	public KeHoachDauNam toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}