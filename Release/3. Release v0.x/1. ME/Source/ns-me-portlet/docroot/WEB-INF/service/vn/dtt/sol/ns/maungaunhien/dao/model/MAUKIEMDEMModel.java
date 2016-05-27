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

package vn.dtt.sol.ns.maungaunhien.dao.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the MAUKIEMDEM service. Represents a row in the &quot;ME_MAUKIEMDEM&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.dtt.sol.ns.maungaunhien.dao.model.impl.MAUKIEMDEMModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.dtt.sol.ns.maungaunhien.dao.model.impl.MAUKIEMDEMImpl}.
 * </p>
 *
 * @author khoa.vu
 * @see MAUKIEMDEM
 * @see vn.dtt.sol.ns.maungaunhien.dao.model.impl.MAUKIEMDEMImpl
 * @see vn.dtt.sol.ns.maungaunhien.dao.model.impl.MAUKIEMDEMModelImpl
 * @generated
 */
public interface MAUKIEMDEMModel extends BaseModel<MAUKIEMDEM> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a m a u k i e m d e m model instance should use the {@link MAUKIEMDEM} interface instead.
	 */

	/**
	 * Returns the primary key of this m a u k i e m d e m.
	 *
	 * @return the primary key of this m a u k i e m d e m
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this m a u k i e m d e m.
	 *
	 * @param primaryKey the primary key of this m a u k i e m d e m
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this m a u k i e m d e m.
	 *
	 * @return the ID of this m a u k i e m d e m
	 */
	public long getId();

	/**
	 * Sets the ID of this m a u k i e m d e m.
	 *
	 * @param id the ID of this m a u k i e m d e m
	 */
	public void setId(long id);

	/**
	 * Returns the ma xa of this m a u k i e m d e m.
	 *
	 * @return the ma xa of this m a u k i e m d e m
	 */
	@AutoEscape
	public String getMaXa();

	/**
	 * Sets the ma xa of this m a u k i e m d e m.
	 *
	 * @param maXa the ma xa of this m a u k i e m d e m
	 */
	public void setMaXa(String maXa);

	/**
	 * Returns the ma tinh of this m a u k i e m d e m.
	 *
	 * @return the ma tinh of this m a u k i e m d e m
	 */
	@AutoEscape
	public String getMaTinh();

	/**
	 * Sets the ma tinh of this m a u k i e m d e m.
	 *
	 * @param maTinh the ma tinh of this m a u k i e m d e m
	 */
	public void setMaTinh(String maTinh);

	/**
	 * Returns the ma huyen of this m a u k i e m d e m.
	 *
	 * @return the ma huyen of this m a u k i e m d e m
	 */
	@AutoEscape
	public String getMaHuyen();

	/**
	 * Sets the ma huyen of this m a u k i e m d e m.
	 *
	 * @param maHuyen the ma huyen of this m a u k i e m d e m
	 */
	public void setMaHuyen(String maHuyen);

	/**
	 * Returns the nam of this m a u k i e m d e m.
	 *
	 * @return the nam of this m a u k i e m d e m
	 */
	public int getNam();

	/**
	 * Sets the nam of this m a u k i e m d e m.
	 *
	 * @param nam the nam of this m a u k i e m d e m
	 */
	public void setNam(int nam);

	/**
	 * Returns the tong so h g d of this m a u k i e m d e m.
	 *
	 * @return the tong so h g d of this m a u k i e m d e m
	 */
	public int getTongSoHGD();

	/**
	 * Sets the tong so h g d of this m a u k i e m d e m.
	 *
	 * @param tongSoHGD the tong so h g d of this m a u k i e m d e m
	 */
	public void setTongSoHGD(int tongSoHGD);

	/**
	 * Returns the so mau ngau nhien of this m a u k i e m d e m.
	 *
	 * @return the so mau ngau nhien of this m a u k i e m d e m
	 */
	public int getSoMauNgauNhien();

	/**
	 * Sets the so mau ngau nhien of this m a u k i e m d e m.
	 *
	 * @param soMauNgauNhien the so mau ngau nhien of this m a u k i e m d e m
	 */
	public void setSoMauNgauNhien(int soMauNgauNhien);

	/**
	 * Returns the so mau du phong of this m a u k i e m d e m.
	 *
	 * @return the so mau du phong of this m a u k i e m d e m
	 */
	public int getSoMauDuPhong();

	/**
	 * Sets the so mau du phong of this m a u k i e m d e m.
	 *
	 * @param soMauDuPhong the so mau du phong of this m a u k i e m d e m
	 */
	public void setSoMauDuPhong(int soMauDuPhong);

	/**
	 * Returns the tong so mau of this m a u k i e m d e m.
	 *
	 * @return the tong so mau of this m a u k i e m d e m
	 */
	public int getTongSoMau();

	/**
	 * Sets the tong so mau of this m a u k i e m d e m.
	 *
	 * @param tongSoMau the tong so mau of this m a u k i e m d e m
	 */
	public void setTongSoMau(int tongSoMau);

	/**
	 * Returns the so mau h v s of this m a u k i e m d e m.
	 *
	 * @return the so mau h v s of this m a u k i e m d e m
	 */
	public int getSoMauHVS();

	/**
	 * Sets the so mau h v s of this m a u k i e m d e m.
	 *
	 * @param soMauHVS the so mau h v s of this m a u k i e m d e m
	 */
	public void setSoMauHVS(int soMauHVS);

	/**
	 * Returns the so mau co nha tieu of this m a u k i e m d e m.
	 *
	 * @return the so mau co nha tieu of this m a u k i e m d e m
	 */
	public int getSoMauCoNhaTieu();

	/**
	 * Sets the so mau co nha tieu of this m a u k i e m d e m.
	 *
	 * @param soMauCoNhaTieu the so mau co nha tieu of this m a u k i e m d e m
	 */
	public void setSoMauCoNhaTieu(int soMauCoNhaTieu);

	/**
	 * Returns the so mau kiem dem of this m a u k i e m d e m.
	 *
	 * @return the so mau kiem dem of this m a u k i e m d e m
	 */
	public int getSoMauKiemDem();

	/**
	 * Sets the so mau kiem dem of this m a u k i e m d e m.
	 *
	 * @param soMauKiemDem the so mau kiem dem of this m a u k i e m d e m
	 */
	public void setSoMauKiemDem(int soMauKiemDem);

	/**
	 * Returns the ngay tao of this m a u k i e m d e m.
	 *
	 * @return the ngay tao of this m a u k i e m d e m
	 */
	public Date getNgayTao();

	/**
	 * Sets the ngay tao of this m a u k i e m d e m.
	 *
	 * @param ngayTao the ngay tao of this m a u k i e m d e m
	 */
	public void setNgayTao(Date ngayTao);

	/**
	 * Returns the user ID of this m a u k i e m d e m.
	 *
	 * @return the user ID of this m a u k i e m d e m
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this m a u k i e m d e m.
	 *
	 * @param userId the user ID of this m a u k i e m d e m
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this m a u k i e m d e m.
	 *
	 * @return the user uuid of this m a u k i e m d e m
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this m a u k i e m d e m.
	 *
	 * @param userUuid the user uuid of this m a u k i e m d e m
	 */
	public void setUserUuid(String userUuid);

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
	public int compareTo(MAUKIEMDEM maukiemdem);

	@Override
	public int hashCode();

	@Override
	public CacheModel<MAUKIEMDEM> toCacheModel();

	@Override
	public MAUKIEMDEM toEscapedModel();

	@Override
	public MAUKIEMDEM toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}