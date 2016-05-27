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

package vn.dtt.sol.ns.vesinhmoitruong.dao.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the VeSinhCongTrinh service. Represents a row in the &quot;ME_VESINHCONGTRINH&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl.VeSinhCongTrinhModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl.VeSinhCongTrinhImpl}.
 * </p>
 *
 * @author BinhTH
 * @see VeSinhCongTrinh
 * @see vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl.VeSinhCongTrinhImpl
 * @see vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl.VeSinhCongTrinhModelImpl
 * @generated
 */
public interface VeSinhCongTrinhModel extends BaseModel<VeSinhCongTrinh> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ve sinh cong trinh model instance should use the {@link VeSinhCongTrinh} interface instead.
	 */

	/**
	 * Returns the primary key of this ve sinh cong trinh.
	 *
	 * @return the primary key of this ve sinh cong trinh
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this ve sinh cong trinh.
	 *
	 * @param primaryKey the primary key of this ve sinh cong trinh
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the ID of this ve sinh cong trinh.
	 *
	 * @return the ID of this ve sinh cong trinh
	 */
	public int getId();

	/**
	 * Sets the ID of this ve sinh cong trinh.
	 *
	 * @param id the ID of this ve sinh cong trinh
	 */
	public void setId(int id);

	/**
	 * Returns the ten cong trinh of this ve sinh cong trinh.
	 *
	 * @return the ten cong trinh of this ve sinh cong trinh
	 */
	@AutoEscape
	public String getTenCongTrinh();

	/**
	 * Sets the ten cong trinh of this ve sinh cong trinh.
	 *
	 * @param tenCongTrinh the ten cong trinh of this ve sinh cong trinh
	 */
	public void setTenCongTrinh(String tenCongTrinh);

	/**
	 * Returns the loai cong trinh of this ve sinh cong trinh.
	 *
	 * @return the loai cong trinh of this ve sinh cong trinh
	 */
	public int getLoaiCongTrinh();

	/**
	 * Sets the loai cong trinh of this ve sinh cong trinh.
	 *
	 * @param loaiCongTrinh the loai cong trinh of this ve sinh cong trinh
	 */
	public void setLoaiCongTrinh(int loaiCongTrinh);

	/**
	 * Returns the ma tinh of this ve sinh cong trinh.
	 *
	 * @return the ma tinh of this ve sinh cong trinh
	 */
	@AutoEscape
	public String getMaTinh();

	/**
	 * Sets the ma tinh of this ve sinh cong trinh.
	 *
	 * @param maTinh the ma tinh of this ve sinh cong trinh
	 */
	public void setMaTinh(String maTinh);

	/**
	 * Returns the ma huyen of this ve sinh cong trinh.
	 *
	 * @return the ma huyen of this ve sinh cong trinh
	 */
	@AutoEscape
	public String getMaHuyen();

	/**
	 * Sets the ma huyen of this ve sinh cong trinh.
	 *
	 * @param maHuyen the ma huyen of this ve sinh cong trinh
	 */
	public void setMaHuyen(String maHuyen);

	/**
	 * Returns the ma xa of this ve sinh cong trinh.
	 *
	 * @return the ma xa of this ve sinh cong trinh
	 */
	@AutoEscape
	public String getMaXa();

	/**
	 * Sets the ma xa of this ve sinh cong trinh.
	 *
	 * @param maXa the ma xa of this ve sinh cong trinh
	 */
	public void setMaXa(String maXa);

	/**
	 * Returns the dia chi of this ve sinh cong trinh.
	 *
	 * @return the dia chi of this ve sinh cong trinh
	 */
	@AutoEscape
	public String getDiaChi();

	/**
	 * Sets the dia chi of this ve sinh cong trinh.
	 *
	 * @param diaChi the dia chi of this ve sinh cong trinh
	 */
	public void setDiaChi(String diaChi);

	/**
	 * Returns the trang thai of this ve sinh cong trinh.
	 *
	 * @return the trang thai of this ve sinh cong trinh
	 */
	public int getTrangThai();

	/**
	 * Sets the trang thai of this ve sinh cong trinh.
	 *
	 * @param trangThai the trang thai of this ve sinh cong trinh
	 */
	public void setTrangThai(int trangThai);

	/**
	 * Returns the nam bao cao of this ve sinh cong trinh.
	 *
	 * @return the nam bao cao of this ve sinh cong trinh
	 */
	public int getNamBaoCao();

	/**
	 * Sets the nam bao cao of this ve sinh cong trinh.
	 *
	 * @param namBaoCao the nam bao cao of this ve sinh cong trinh
	 */
	public void setNamBaoCao(int namBaoCao);

	/**
	 * Returns the ghi chu of this ve sinh cong trinh.
	 *
	 * @return the ghi chu of this ve sinh cong trinh
	 */
	@AutoEscape
	public String getGhiChu();

	/**
	 * Sets the ghi chu of this ve sinh cong trinh.
	 *
	 * @param ghiChu the ghi chu of this ve sinh cong trinh
	 */
	public void setGhiChu(String ghiChu);

	/**
	 * Returns the ngay tao of this ve sinh cong trinh.
	 *
	 * @return the ngay tao of this ve sinh cong trinh
	 */
	public Date getNgayTao();

	/**
	 * Sets the ngay tao of this ve sinh cong trinh.
	 *
	 * @param ngayTao the ngay tao of this ve sinh cong trinh
	 */
	public void setNgayTao(Date ngayTao);

	/**
	 * Returns the id nguoi tao of this ve sinh cong trinh.
	 *
	 * @return the id nguoi tao of this ve sinh cong trinh
	 */
	@AutoEscape
	public String getIdNguoiTao();

	/**
	 * Sets the id nguoi tao of this ve sinh cong trinh.
	 *
	 * @param idNguoiTao the id nguoi tao of this ve sinh cong trinh
	 */
	public void setIdNguoiTao(String idNguoiTao);

	/**
	 * Returns the kinh do of this ve sinh cong trinh.
	 *
	 * @return the kinh do of this ve sinh cong trinh
	 */
	@AutoEscape
	public String getKinhDo();

	/**
	 * Sets the kinh do of this ve sinh cong trinh.
	 *
	 * @param kinhDo the kinh do of this ve sinh cong trinh
	 */
	public void setKinhDo(String kinhDo);

	/**
	 * Returns the vi do of this ve sinh cong trinh.
	 *
	 * @return the vi do of this ve sinh cong trinh
	 */
	@AutoEscape
	public String getViDo();

	/**
	 * Sets the vi do of this ve sinh cong trinh.
	 *
	 * @param viDo the vi do of this ve sinh cong trinh
	 */
	public void setViDo(String viDo);

	/**
	 * Returns the loai nguon nuoc of this ve sinh cong trinh.
	 *
	 * @return the loai nguon nuoc of this ve sinh cong trinh
	 */
	@AutoEscape
	public String getLoaiNguonNuoc();

	/**
	 * Sets the loai nguon nuoc of this ve sinh cong trinh.
	 *
	 * @param loaiNguonNuoc the loai nguon nuoc of this ve sinh cong trinh
	 */
	public void setLoaiNguonNuoc(String loaiNguonNuoc);

	/**
	 * Returns the nguon nuoc h v s of this ve sinh cong trinh.
	 *
	 * @return the nguon nuoc h v s of this ve sinh cong trinh
	 */
	public int getNguonNuocHVS();

	/**
	 * Sets the nguon nuoc h v s of this ve sinh cong trinh.
	 *
	 * @param nguonNuocHVS the nguon nuoc h v s of this ve sinh cong trinh
	 */
	public void setNguonNuocHVS(int nguonNuocHVS);

	/**
	 * Returns the loai nha tieu of this ve sinh cong trinh.
	 *
	 * @return the loai nha tieu of this ve sinh cong trinh
	 */
	@AutoEscape
	public String getLoaiNhaTieu();

	/**
	 * Sets the loai nha tieu of this ve sinh cong trinh.
	 *
	 * @param loaiNhaTieu the loai nha tieu of this ve sinh cong trinh
	 */
	public void setLoaiNhaTieu(String loaiNhaTieu);

	/**
	 * Returns the nha tieu h v s of this ve sinh cong trinh.
	 *
	 * @return the nha tieu h v s of this ve sinh cong trinh
	 */
	public int getNhaTieuHVS();

	/**
	 * Sets the nha tieu h v s of this ve sinh cong trinh.
	 *
	 * @param nhaTieuHVS the nha tieu h v s of this ve sinh cong trinh
	 */
	public void setNhaTieuHVS(int nhaTieuHVS);

	/**
	 * Returns the ket luan h v s of this ve sinh cong trinh.
	 *
	 * @return the ket luan h v s of this ve sinh cong trinh
	 */
	public int getKetLuanHVS();

	/**
	 * Sets the ket luan h v s of this ve sinh cong trinh.
	 *
	 * @param ketLuanHVS the ket luan h v s of this ve sinh cong trinh
	 */
	public void setKetLuanHVS(int ketLuanHVS);

	/**
	 * Returns the ngay kiem dem of this ve sinh cong trinh.
	 *
	 * @return the ngay kiem dem of this ve sinh cong trinh
	 */
	public Date getNgayKiemDem();

	/**
	 * Sets the ngay kiem dem of this ve sinh cong trinh.
	 *
	 * @param ngayKiemDem the ngay kiem dem of this ve sinh cong trinh
	 */
	public void setNgayKiemDem(Date ngayKiemDem);

	/**
	 * Returns the ngay danh gia of this ve sinh cong trinh.
	 *
	 * @return the ngay danh gia of this ve sinh cong trinh
	 */
	public Date getNgayDanhGia();

	/**
	 * Sets the ngay danh gia of this ve sinh cong trinh.
	 *
	 * @param ngayDanhGia the ngay danh gia of this ve sinh cong trinh
	 */
	public void setNgayDanhGia(Date ngayDanhGia);

	/**
	 * Returns the id nguoi danh gia of this ve sinh cong trinh.
	 *
	 * @return the id nguoi danh gia of this ve sinh cong trinh
	 */
	public int getIdNguoiDanhGia();

	/**
	 * Sets the id nguoi danh gia of this ve sinh cong trinh.
	 *
	 * @param idNguoiDanhGia the id nguoi danh gia of this ve sinh cong trinh
	 */
	public void setIdNguoiDanhGia(int idNguoiDanhGia);

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
	public int compareTo(VeSinhCongTrinh veSinhCongTrinh);

	@Override
	public int hashCode();

	@Override
	public CacheModel<VeSinhCongTrinh> toCacheModel();

	@Override
	public VeSinhCongTrinh toEscapedModel();

	@Override
	public VeSinhCongTrinh toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}