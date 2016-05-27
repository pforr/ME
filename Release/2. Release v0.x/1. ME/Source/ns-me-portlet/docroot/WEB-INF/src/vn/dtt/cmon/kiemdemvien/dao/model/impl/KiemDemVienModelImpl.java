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

package vn.dtt.cmon.kiemdemvien.dao.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien;
import vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVienModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the KiemDemVien service. Represents a row in the &quot;ME_KIEMDEMVIEN&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVienModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KiemDemVienImpl}.
 * </p>
 *
 * @author HANT
 * @see KiemDemVienImpl
 * @see vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien
 * @see vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVienModel
 * @generated
 */
public class KiemDemVienModelImpl extends BaseModelImpl<KiemDemVien>
	implements KiemDemVienModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kiem dem vien model instance should use the {@link vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien} interface instead.
	 */
	public static final String TABLE_NAME = "ME_KIEMDEMVIEN";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.BIGINT },
			{ "HOVATEN", Types.VARCHAR },
			{ "TAIKHOAN", Types.VARCHAR },
			{ "MATKHAU", Types.VARCHAR },
			{ "CAPHOATDONG", Types.BIGINT },
			{ "ORGCODE1", Types.VARCHAR },
			{ "ORGCODE2", Types.VARCHAR },
			{ "DIACHI", Types.VARCHAR },
			{ "CHUNGMINHTHU", Types.VARCHAR },
			{ "DIENTHOAI", Types.VARCHAR },
			{ "IMEI", Types.VARCHAR },
			{ "TRANGTHAI", Types.BIGINT },
			{ "NGAYTAO", Types.TIMESTAMP },
			{ "IDNGUOITAO", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table ME_KIEMDEMVIEN (ID LONG not null primary key,HOVATEN VARCHAR(75) null,TAIKHOAN VARCHAR(75) null,MATKHAU VARCHAR(75) null,CAPHOATDONG LONG,ORGCODE1 VARCHAR(75) null,ORGCODE2 VARCHAR(75) null,DIACHI VARCHAR(75) null,CHUNGMINHTHU VARCHAR(75) null,DIENTHOAI VARCHAR(75) null,IMEI VARCHAR(75) null,TRANGTHAI LONG,NGAYTAO DATE null,IDNGUOITAO LONG)";
	public static final String TABLE_SQL_DROP = "drop table ME_KIEMDEMVIEN";
	public static final String ORDER_BY_JPQL = " ORDER BY kiemDemVien.hoVaTen ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ME_KIEMDEMVIEN.HOVATEN ASC";
	public static final String DATA_SOURCE = "dmDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien"),
			true);
	public static long CAPHOATDONG_COLUMN_BITMASK = 1L;
	public static long HOVATEN_COLUMN_BITMASK = 2L;
	public static long ID_COLUMN_BITMASK = 4L;
	public static long IDNGUOITAO_COLUMN_BITMASK = 8L;
	public static long ORGCODE1_COLUMN_BITMASK = 16L;
	public static long ORGCODE2_COLUMN_BITMASK = 32L;
	public static long TAIKHOAN_COLUMN_BITMASK = 64L;
	public static long TRANGTHAI_COLUMN_BITMASK = 128L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien"));

	public KiemDemVienModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return KiemDemVien.class;
	}

	@Override
	public String getModelClassName() {
		return KiemDemVien.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("hoVaTen", getHoVaTen());
		attributes.put("taiKhoan", getTaiKhoan());
		attributes.put("matKhau", getMatKhau());
		attributes.put("capHoatDong", getCapHoatDong());
		attributes.put("orgCode1", getOrgCode1());
		attributes.put("orgCode2", getOrgCode2());
		attributes.put("diaChi", getDiaChi());
		attributes.put("chungMinhThu", getChungMinhThu());
		attributes.put("dienThoai", getDienThoai());
		attributes.put("imei", getImei());
		attributes.put("trangThai", getTrangThai());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("idNguoiTao", getIdNguoiTao());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String hoVaTen = (String)attributes.get("hoVaTen");

		if (hoVaTen != null) {
			setHoVaTen(hoVaTen);
		}

		String taiKhoan = (String)attributes.get("taiKhoan");

		if (taiKhoan != null) {
			setTaiKhoan(taiKhoan);
		}

		String matKhau = (String)attributes.get("matKhau");

		if (matKhau != null) {
			setMatKhau(matKhau);
		}

		Long capHoatDong = (Long)attributes.get("capHoatDong");

		if (capHoatDong != null) {
			setCapHoatDong(capHoatDong);
		}

		String orgCode1 = (String)attributes.get("orgCode1");

		if (orgCode1 != null) {
			setOrgCode1(orgCode1);
		}

		String orgCode2 = (String)attributes.get("orgCode2");

		if (orgCode2 != null) {
			setOrgCode2(orgCode2);
		}

		String diaChi = (String)attributes.get("diaChi");

		if (diaChi != null) {
			setDiaChi(diaChi);
		}

		String chungMinhThu = (String)attributes.get("chungMinhThu");

		if (chungMinhThu != null) {
			setChungMinhThu(chungMinhThu);
		}

		String dienThoai = (String)attributes.get("dienThoai");

		if (dienThoai != null) {
			setDienThoai(dienThoai);
		}

		String imei = (String)attributes.get("imei");

		if (imei != null) {
			setImei(imei);
		}

		Long trangThai = (Long)attributes.get("trangThai");

		if (trangThai != null) {
			setTrangThai(trangThai);
		}

		Date ngayTao = (Date)attributes.get("ngayTao");

		if (ngayTao != null) {
			setNgayTao(ngayTao);
		}

		Long idNguoiTao = (Long)attributes.get("idNguoiTao");

		if (idNguoiTao != null) {
			setIdNguoiTao(idNguoiTao);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_columnBitmask |= ID_COLUMN_BITMASK;

		if (!_setOriginalId) {
			_setOriginalId = true;

			_originalId = _id;
		}

		_id = id;
	}

	public long getOriginalId() {
		return _originalId;
	}

	@Override
	public String getHoVaTen() {
		if (_hoVaTen == null) {
			return StringPool.BLANK;
		}
		else {
			return _hoVaTen;
		}
	}

	@Override
	public void setHoVaTen(String hoVaTen) {
		_columnBitmask = -1L;

		if (_originalHoVaTen == null) {
			_originalHoVaTen = _hoVaTen;
		}

		_hoVaTen = hoVaTen;
	}

	public String getOriginalHoVaTen() {
		return GetterUtil.getString(_originalHoVaTen);
	}

	@Override
	public String getTaiKhoan() {
		if (_taiKhoan == null) {
			return StringPool.BLANK;
		}
		else {
			return _taiKhoan;
		}
	}

	@Override
	public void setTaiKhoan(String taiKhoan) {
		_columnBitmask |= TAIKHOAN_COLUMN_BITMASK;

		if (_originalTaiKhoan == null) {
			_originalTaiKhoan = _taiKhoan;
		}

		_taiKhoan = taiKhoan;
	}

	public String getOriginalTaiKhoan() {
		return GetterUtil.getString(_originalTaiKhoan);
	}

	@Override
	public String getMatKhau() {
		if (_matKhau == null) {
			return StringPool.BLANK;
		}
		else {
			return _matKhau;
		}
	}

	@Override
	public void setMatKhau(String matKhau) {
		_matKhau = matKhau;
	}

	@Override
	public long getCapHoatDong() {
		return _capHoatDong;
	}

	@Override
	public void setCapHoatDong(long capHoatDong) {
		_columnBitmask |= CAPHOATDONG_COLUMN_BITMASK;

		if (!_setOriginalCapHoatDong) {
			_setOriginalCapHoatDong = true;

			_originalCapHoatDong = _capHoatDong;
		}

		_capHoatDong = capHoatDong;
	}

	public long getOriginalCapHoatDong() {
		return _originalCapHoatDong;
	}

	@Override
	public String getOrgCode1() {
		if (_orgCode1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _orgCode1;
		}
	}

	@Override
	public void setOrgCode1(String orgCode1) {
		_columnBitmask |= ORGCODE1_COLUMN_BITMASK;

		if (_originalOrgCode1 == null) {
			_originalOrgCode1 = _orgCode1;
		}

		_orgCode1 = orgCode1;
	}

	public String getOriginalOrgCode1() {
		return GetterUtil.getString(_originalOrgCode1);
	}

	@Override
	public String getOrgCode2() {
		if (_orgCode2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _orgCode2;
		}
	}

	@Override
	public void setOrgCode2(String orgCode2) {
		_columnBitmask |= ORGCODE2_COLUMN_BITMASK;

		if (_originalOrgCode2 == null) {
			_originalOrgCode2 = _orgCode2;
		}

		_orgCode2 = orgCode2;
	}

	public String getOriginalOrgCode2() {
		return GetterUtil.getString(_originalOrgCode2);
	}

	@Override
	public String getDiaChi() {
		if (_diaChi == null) {
			return StringPool.BLANK;
		}
		else {
			return _diaChi;
		}
	}

	@Override
	public void setDiaChi(String diaChi) {
		_diaChi = diaChi;
	}

	@Override
	public String getChungMinhThu() {
		if (_chungMinhThu == null) {
			return StringPool.BLANK;
		}
		else {
			return _chungMinhThu;
		}
	}

	@Override
	public void setChungMinhThu(String chungMinhThu) {
		_chungMinhThu = chungMinhThu;
	}

	@Override
	public String getDienThoai() {
		if (_dienThoai == null) {
			return StringPool.BLANK;
		}
		else {
			return _dienThoai;
		}
	}

	@Override
	public void setDienThoai(String dienThoai) {
		_dienThoai = dienThoai;
	}

	@Override
	public String getImei() {
		if (_imei == null) {
			return StringPool.BLANK;
		}
		else {
			return _imei;
		}
	}

	@Override
	public void setImei(String imei) {
		_imei = imei;
	}

	@Override
	public long getTrangThai() {
		return _trangThai;
	}

	@Override
	public void setTrangThai(long trangThai) {
		_columnBitmask |= TRANGTHAI_COLUMN_BITMASK;

		if (!_setOriginalTrangThai) {
			_setOriginalTrangThai = true;

			_originalTrangThai = _trangThai;
		}

		_trangThai = trangThai;
	}

	public long getOriginalTrangThai() {
		return _originalTrangThai;
	}

	@Override
	public Date getNgayTao() {
		return _ngayTao;
	}

	@Override
	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	@Override
	public long getIdNguoiTao() {
		return _idNguoiTao;
	}

	@Override
	public void setIdNguoiTao(long idNguoiTao) {
		_columnBitmask |= IDNGUOITAO_COLUMN_BITMASK;

		if (!_setOriginalIdNguoiTao) {
			_setOriginalIdNguoiTao = true;

			_originalIdNguoiTao = _idNguoiTao;
		}

		_idNguoiTao = idNguoiTao;
	}

	public long getOriginalIdNguoiTao() {
		return _originalIdNguoiTao;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			KiemDemVien.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public KiemDemVien toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (KiemDemVien)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		KiemDemVienImpl kiemDemVienImpl = new KiemDemVienImpl();

		kiemDemVienImpl.setId(getId());
		kiemDemVienImpl.setHoVaTen(getHoVaTen());
		kiemDemVienImpl.setTaiKhoan(getTaiKhoan());
		kiemDemVienImpl.setMatKhau(getMatKhau());
		kiemDemVienImpl.setCapHoatDong(getCapHoatDong());
		kiemDemVienImpl.setOrgCode1(getOrgCode1());
		kiemDemVienImpl.setOrgCode2(getOrgCode2());
		kiemDemVienImpl.setDiaChi(getDiaChi());
		kiemDemVienImpl.setChungMinhThu(getChungMinhThu());
		kiemDemVienImpl.setDienThoai(getDienThoai());
		kiemDemVienImpl.setImei(getImei());
		kiemDemVienImpl.setTrangThai(getTrangThai());
		kiemDemVienImpl.setNgayTao(getNgayTao());
		kiemDemVienImpl.setIdNguoiTao(getIdNguoiTao());

		kiemDemVienImpl.resetOriginalValues();

		return kiemDemVienImpl;
	}

	@Override
	public int compareTo(KiemDemVien kiemDemVien) {
		int value = 0;

		value = getHoVaTen().compareTo(kiemDemVien.getHoVaTen());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KiemDemVien)) {
			return false;
		}

		KiemDemVien kiemDemVien = (KiemDemVien)obj;

		long primaryKey = kiemDemVien.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		KiemDemVienModelImpl kiemDemVienModelImpl = this;

		kiemDemVienModelImpl._originalId = kiemDemVienModelImpl._id;

		kiemDemVienModelImpl._setOriginalId = false;

		kiemDemVienModelImpl._originalHoVaTen = kiemDemVienModelImpl._hoVaTen;

		kiemDemVienModelImpl._originalTaiKhoan = kiemDemVienModelImpl._taiKhoan;

		kiemDemVienModelImpl._originalCapHoatDong = kiemDemVienModelImpl._capHoatDong;

		kiemDemVienModelImpl._setOriginalCapHoatDong = false;

		kiemDemVienModelImpl._originalOrgCode1 = kiemDemVienModelImpl._orgCode1;

		kiemDemVienModelImpl._originalOrgCode2 = kiemDemVienModelImpl._orgCode2;

		kiemDemVienModelImpl._originalTrangThai = kiemDemVienModelImpl._trangThai;

		kiemDemVienModelImpl._setOriginalTrangThai = false;

		kiemDemVienModelImpl._originalIdNguoiTao = kiemDemVienModelImpl._idNguoiTao;

		kiemDemVienModelImpl._setOriginalIdNguoiTao = false;

		kiemDemVienModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<KiemDemVien> toCacheModel() {
		KiemDemVienCacheModel kiemDemVienCacheModel = new KiemDemVienCacheModel();

		kiemDemVienCacheModel.id = getId();

		kiemDemVienCacheModel.hoVaTen = getHoVaTen();

		String hoVaTen = kiemDemVienCacheModel.hoVaTen;

		if ((hoVaTen != null) && (hoVaTen.length() == 0)) {
			kiemDemVienCacheModel.hoVaTen = null;
		}

		kiemDemVienCacheModel.taiKhoan = getTaiKhoan();

		String taiKhoan = kiemDemVienCacheModel.taiKhoan;

		if ((taiKhoan != null) && (taiKhoan.length() == 0)) {
			kiemDemVienCacheModel.taiKhoan = null;
		}

		kiemDemVienCacheModel.matKhau = getMatKhau();

		String matKhau = kiemDemVienCacheModel.matKhau;

		if ((matKhau != null) && (matKhau.length() == 0)) {
			kiemDemVienCacheModel.matKhau = null;
		}

		kiemDemVienCacheModel.capHoatDong = getCapHoatDong();

		kiemDemVienCacheModel.orgCode1 = getOrgCode1();

		String orgCode1 = kiemDemVienCacheModel.orgCode1;

		if ((orgCode1 != null) && (orgCode1.length() == 0)) {
			kiemDemVienCacheModel.orgCode1 = null;
		}

		kiemDemVienCacheModel.orgCode2 = getOrgCode2();

		String orgCode2 = kiemDemVienCacheModel.orgCode2;

		if ((orgCode2 != null) && (orgCode2.length() == 0)) {
			kiemDemVienCacheModel.orgCode2 = null;
		}

		kiemDemVienCacheModel.diaChi = getDiaChi();

		String diaChi = kiemDemVienCacheModel.diaChi;

		if ((diaChi != null) && (diaChi.length() == 0)) {
			kiemDemVienCacheModel.diaChi = null;
		}

		kiemDemVienCacheModel.chungMinhThu = getChungMinhThu();

		String chungMinhThu = kiemDemVienCacheModel.chungMinhThu;

		if ((chungMinhThu != null) && (chungMinhThu.length() == 0)) {
			kiemDemVienCacheModel.chungMinhThu = null;
		}

		kiemDemVienCacheModel.dienThoai = getDienThoai();

		String dienThoai = kiemDemVienCacheModel.dienThoai;

		if ((dienThoai != null) && (dienThoai.length() == 0)) {
			kiemDemVienCacheModel.dienThoai = null;
		}

		kiemDemVienCacheModel.imei = getImei();

		String imei = kiemDemVienCacheModel.imei;

		if ((imei != null) && (imei.length() == 0)) {
			kiemDemVienCacheModel.imei = null;
		}

		kiemDemVienCacheModel.trangThai = getTrangThai();

		Date ngayTao = getNgayTao();

		if (ngayTao != null) {
			kiemDemVienCacheModel.ngayTao = ngayTao.getTime();
		}
		else {
			kiemDemVienCacheModel.ngayTao = Long.MIN_VALUE;
		}

		kiemDemVienCacheModel.idNguoiTao = getIdNguoiTao();

		return kiemDemVienCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", hoVaTen=");
		sb.append(getHoVaTen());
		sb.append(", taiKhoan=");
		sb.append(getTaiKhoan());
		sb.append(", matKhau=");
		sb.append(getMatKhau());
		sb.append(", capHoatDong=");
		sb.append(getCapHoatDong());
		sb.append(", orgCode1=");
		sb.append(getOrgCode1());
		sb.append(", orgCode2=");
		sb.append(getOrgCode2());
		sb.append(", diaChi=");
		sb.append(getDiaChi());
		sb.append(", chungMinhThu=");
		sb.append(getChungMinhThu());
		sb.append(", dienThoai=");
		sb.append(getDienThoai());
		sb.append(", imei=");
		sb.append(getImei());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", idNguoiTao=");
		sb.append(getIdNguoiTao());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoVaTen</column-name><column-value><![CDATA[");
		sb.append(getHoVaTen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taiKhoan</column-name><column-value><![CDATA[");
		sb.append(getTaiKhoan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>matKhau</column-name><column-value><![CDATA[");
		sb.append(getMatKhau());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>capHoatDong</column-name><column-value><![CDATA[");
		sb.append(getCapHoatDong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgCode1</column-name><column-value><![CDATA[");
		sb.append(getOrgCode1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgCode2</column-name><column-value><![CDATA[");
		sb.append(getOrgCode2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChi</column-name><column-value><![CDATA[");
		sb.append(getDiaChi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chungMinhThu</column-name><column-value><![CDATA[");
		sb.append(getChungMinhThu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dienThoai</column-name><column-value><![CDATA[");
		sb.append(getDienThoai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imei</column-name><column-value><![CDATA[");
		sb.append(getImei());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idNguoiTao</column-name><column-value><![CDATA[");
		sb.append(getIdNguoiTao());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = KiemDemVien.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			KiemDemVien.class
		};
	private long _id;
	private long _originalId;
	private boolean _setOriginalId;
	private String _hoVaTen;
	private String _originalHoVaTen;
	private String _taiKhoan;
	private String _originalTaiKhoan;
	private String _matKhau;
	private long _capHoatDong;
	private long _originalCapHoatDong;
	private boolean _setOriginalCapHoatDong;
	private String _orgCode1;
	private String _originalOrgCode1;
	private String _orgCode2;
	private String _originalOrgCode2;
	private String _diaChi;
	private String _chungMinhThu;
	private String _dienThoai;
	private String _imei;
	private long _trangThai;
	private long _originalTrangThai;
	private boolean _setOriginalTrangThai;
	private Date _ngayTao;
	private long _idNguoiTao;
	private long _originalIdNguoiTao;
	private boolean _setOriginalIdNguoiTao;
	private long _columnBitmask;
	private KiemDemVien _escapedModel;
}