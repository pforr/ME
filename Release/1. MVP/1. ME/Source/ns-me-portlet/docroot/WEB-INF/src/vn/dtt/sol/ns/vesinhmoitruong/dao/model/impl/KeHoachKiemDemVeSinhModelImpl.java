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

package vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import vn.dtt.sol.ns.vesinhmoitruong.dao.model.KeHoachKiemDemVeSinh;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.KeHoachKiemDemVeSinhModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the KeHoachKiemDemVeSinh service. Represents a row in the &quot;ME_KEHOACHKIEMDEMVESINH&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.dtt.sol.ns.vesinhmoitruong.dao.model.KeHoachKiemDemVeSinhModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KeHoachKiemDemVeSinhImpl}.
 * </p>
 *
 * @author BinhTH
 * @see KeHoachKiemDemVeSinhImpl
 * @see vn.dtt.sol.ns.vesinhmoitruong.dao.model.KeHoachKiemDemVeSinh
 * @see vn.dtt.sol.ns.vesinhmoitruong.dao.model.KeHoachKiemDemVeSinhModel
 * @generated
 */
public class KeHoachKiemDemVeSinhModelImpl extends BaseModelImpl<KeHoachKiemDemVeSinh>
	implements KeHoachKiemDemVeSinhModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ke hoach kiem dem ve sinh model instance should use the {@link vn.dtt.sol.ns.vesinhmoitruong.dao.model.KeHoachKiemDemVeSinh} interface instead.
	 */
	public static final String TABLE_NAME = "ME_KEHOACHKIEMDEMVESINH";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.INTEGER },
			{ "NAM", Types.INTEGER },
			{ "MATINH", Types.VARCHAR },
			{ "MAHUYEN", Types.VARCHAR },
			{ "KIEMDEMVIENID", Types.INTEGER },
			{ "NGAYBATDAU", Types.TIMESTAMP },
			{ "NGAYKETTHUC", Types.TIMESTAMP },
			{ "MOTA", Types.VARCHAR },
			{ "NGAYTAO", Types.TIMESTAMP },
			{ "IDNGUOITAO", Types.INTEGER },
			{ "NGAYXUATBAN", Types.TIMESTAMP },
			{ "IDNGUOIXUATBAN", Types.INTEGER },
			{ "TABLEID", Types.VARCHAR },
			{ "NGAYDONG", Types.TIMESTAMP },
			{ "IDNGUOIDONG", Types.INTEGER },
			{ "LASTSAVEPOINT", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table ME_KEHOACHKIEMDEMVESINH (ID INTEGER not null primary key,NAM INTEGER,MATINH VARCHAR(75) null,MAHUYEN VARCHAR(75) null,KIEMDEMVIENID INTEGER,NGAYBATDAU DATE null,NGAYKETTHUC DATE null,MOTA VARCHAR(75) null,NGAYTAO DATE null,IDNGUOITAO INTEGER,NGAYXUATBAN DATE null,IDNGUOIXUATBAN INTEGER,TABLEID VARCHAR(75) null,NGAYDONG DATE null,IDNGUOIDONG INTEGER,LASTSAVEPOINT DATE null)";
	public static final String TABLE_SQL_DROP = "drop table ME_KEHOACHKIEMDEMVESINH";
	public static final String ORDER_BY_JPQL = " ORDER BY keHoachKiemDemVeSinh.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ME_KEHOACHKIEMDEMVESINH.ID ASC";
	public static final String DATA_SOURCE = "dmDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.dtt.sol.ns.vesinhmoitruong.dao.model.KeHoachKiemDemVeSinh"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.dtt.sol.ns.vesinhmoitruong.dao.model.KeHoachKiemDemVeSinh"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.dtt.sol.ns.vesinhmoitruong.dao.model.KeHoachKiemDemVeSinh"));

	public KeHoachKiemDemVeSinhModelImpl() {
	}

	@Override
	public int getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Class<?> getModelClass() {
		return KeHoachKiemDemVeSinh.class;
	}

	@Override
	public String getModelClassName() {
		return KeHoachKiemDemVeSinh.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nam", getNam());
		attributes.put("maTinh", getMaTinh());
		attributes.put("maHuyen", getMaHuyen());
		attributes.put("kiemDemVienID", getKiemDemVienID());
		attributes.put("ngayBatDau", getNgayBatDau());
		attributes.put("ngayKetThuc", getNgayKetThuc());
		attributes.put("moTa", getMoTa());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("idNguoiTao", getIdNguoiTao());
		attributes.put("ngayXuatBan", getNgayXuatBan());
		attributes.put("idNguoiXuatBan", getIdNguoiXuatBan());
		attributes.put("tableId", getTableId());
		attributes.put("ngayDong", getNgayDong());
		attributes.put("idNguoiDong", getIdNguoiDong());
		attributes.put("lastSavePoint", getLastSavePoint());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Integer nam = (Integer)attributes.get("nam");

		if (nam != null) {
			setNam(nam);
		}

		String maTinh = (String)attributes.get("maTinh");

		if (maTinh != null) {
			setMaTinh(maTinh);
		}

		String maHuyen = (String)attributes.get("maHuyen");

		if (maHuyen != null) {
			setMaHuyen(maHuyen);
		}

		Integer kiemDemVienID = (Integer)attributes.get("kiemDemVienID");

		if (kiemDemVienID != null) {
			setKiemDemVienID(kiemDemVienID);
		}

		Date ngayBatDau = (Date)attributes.get("ngayBatDau");

		if (ngayBatDau != null) {
			setNgayBatDau(ngayBatDau);
		}

		Date ngayKetThuc = (Date)attributes.get("ngayKetThuc");

		if (ngayKetThuc != null) {
			setNgayKetThuc(ngayKetThuc);
		}

		String moTa = (String)attributes.get("moTa");

		if (moTa != null) {
			setMoTa(moTa);
		}

		Date ngayTao = (Date)attributes.get("ngayTao");

		if (ngayTao != null) {
			setNgayTao(ngayTao);
		}

		Integer idNguoiTao = (Integer)attributes.get("idNguoiTao");

		if (idNguoiTao != null) {
			setIdNguoiTao(idNguoiTao);
		}

		Date ngayXuatBan = (Date)attributes.get("ngayXuatBan");

		if (ngayXuatBan != null) {
			setNgayXuatBan(ngayXuatBan);
		}

		Integer idNguoiXuatBan = (Integer)attributes.get("idNguoiXuatBan");

		if (idNguoiXuatBan != null) {
			setIdNguoiXuatBan(idNguoiXuatBan);
		}

		String tableId = (String)attributes.get("tableId");

		if (tableId != null) {
			setTableId(tableId);
		}

		Date ngayDong = (Date)attributes.get("ngayDong");

		if (ngayDong != null) {
			setNgayDong(ngayDong);
		}

		Integer idNguoiDong = (Integer)attributes.get("idNguoiDong");

		if (idNguoiDong != null) {
			setIdNguoiDong(idNguoiDong);
		}

		Date lastSavePoint = (Date)attributes.get("lastSavePoint");

		if (lastSavePoint != null) {
			setLastSavePoint(lastSavePoint);
		}
	}

	@Override
	public int getId() {
		return _id;
	}

	@Override
	public void setId(int id) {
		_id = id;
	}

	@Override
	public int getNam() {
		return _nam;
	}

	@Override
	public void setNam(int nam) {
		_nam = nam;
	}

	@Override
	public String getMaTinh() {
		if (_maTinh == null) {
			return StringPool.BLANK;
		}
		else {
			return _maTinh;
		}
	}

	@Override
	public void setMaTinh(String maTinh) {
		_maTinh = maTinh;
	}

	@Override
	public String getMaHuyen() {
		if (_maHuyen == null) {
			return StringPool.BLANK;
		}
		else {
			return _maHuyen;
		}
	}

	@Override
	public void setMaHuyen(String maHuyen) {
		_maHuyen = maHuyen;
	}

	@Override
	public int getKiemDemVienID() {
		return _kiemDemVienID;
	}

	@Override
	public void setKiemDemVienID(int kiemDemVienID) {
		_kiemDemVienID = kiemDemVienID;
	}

	@Override
	public Date getNgayBatDau() {
		return _ngayBatDau;
	}

	@Override
	public void setNgayBatDau(Date ngayBatDau) {
		_ngayBatDau = ngayBatDau;
	}

	@Override
	public Date getNgayKetThuc() {
		return _ngayKetThuc;
	}

	@Override
	public void setNgayKetThuc(Date ngayKetThuc) {
		_ngayKetThuc = ngayKetThuc;
	}

	@Override
	public String getMoTa() {
		if (_moTa == null) {
			return StringPool.BLANK;
		}
		else {
			return _moTa;
		}
	}

	@Override
	public void setMoTa(String moTa) {
		_moTa = moTa;
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
	public int getIdNguoiTao() {
		return _idNguoiTao;
	}

	@Override
	public void setIdNguoiTao(int idNguoiTao) {
		_idNguoiTao = idNguoiTao;
	}

	@Override
	public Date getNgayXuatBan() {
		return _ngayXuatBan;
	}

	@Override
	public void setNgayXuatBan(Date ngayXuatBan) {
		_ngayXuatBan = ngayXuatBan;
	}

	@Override
	public int getIdNguoiXuatBan() {
		return _idNguoiXuatBan;
	}

	@Override
	public void setIdNguoiXuatBan(int idNguoiXuatBan) {
		_idNguoiXuatBan = idNguoiXuatBan;
	}

	@Override
	public String getTableId() {
		if (_tableId == null) {
			return StringPool.BLANK;
		}
		else {
			return _tableId;
		}
	}

	@Override
	public void setTableId(String tableId) {
		_tableId = tableId;
	}

	@Override
	public Date getNgayDong() {
		return _ngayDong;
	}

	@Override
	public void setNgayDong(Date ngayDong) {
		_ngayDong = ngayDong;
	}

	@Override
	public int getIdNguoiDong() {
		return _idNguoiDong;
	}

	@Override
	public void setIdNguoiDong(int idNguoiDong) {
		_idNguoiDong = idNguoiDong;
	}

	@Override
	public Date getLastSavePoint() {
		return _lastSavePoint;
	}

	@Override
	public void setLastSavePoint(Date lastSavePoint) {
		_lastSavePoint = lastSavePoint;
	}

	@Override
	public KeHoachKiemDemVeSinh toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (KeHoachKiemDemVeSinh)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		KeHoachKiemDemVeSinhImpl keHoachKiemDemVeSinhImpl = new KeHoachKiemDemVeSinhImpl();

		keHoachKiemDemVeSinhImpl.setId(getId());
		keHoachKiemDemVeSinhImpl.setNam(getNam());
		keHoachKiemDemVeSinhImpl.setMaTinh(getMaTinh());
		keHoachKiemDemVeSinhImpl.setMaHuyen(getMaHuyen());
		keHoachKiemDemVeSinhImpl.setKiemDemVienID(getKiemDemVienID());
		keHoachKiemDemVeSinhImpl.setNgayBatDau(getNgayBatDau());
		keHoachKiemDemVeSinhImpl.setNgayKetThuc(getNgayKetThuc());
		keHoachKiemDemVeSinhImpl.setMoTa(getMoTa());
		keHoachKiemDemVeSinhImpl.setNgayTao(getNgayTao());
		keHoachKiemDemVeSinhImpl.setIdNguoiTao(getIdNguoiTao());
		keHoachKiemDemVeSinhImpl.setNgayXuatBan(getNgayXuatBan());
		keHoachKiemDemVeSinhImpl.setIdNguoiXuatBan(getIdNguoiXuatBan());
		keHoachKiemDemVeSinhImpl.setTableId(getTableId());
		keHoachKiemDemVeSinhImpl.setNgayDong(getNgayDong());
		keHoachKiemDemVeSinhImpl.setIdNguoiDong(getIdNguoiDong());
		keHoachKiemDemVeSinhImpl.setLastSavePoint(getLastSavePoint());

		keHoachKiemDemVeSinhImpl.resetOriginalValues();

		return keHoachKiemDemVeSinhImpl;
	}

	@Override
	public int compareTo(KeHoachKiemDemVeSinh keHoachKiemDemVeSinh) {
		int primaryKey = keHoachKiemDemVeSinh.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KeHoachKiemDemVeSinh)) {
			return false;
		}

		KeHoachKiemDemVeSinh keHoachKiemDemVeSinh = (KeHoachKiemDemVeSinh)obj;

		int primaryKey = keHoachKiemDemVeSinh.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<KeHoachKiemDemVeSinh> toCacheModel() {
		KeHoachKiemDemVeSinhCacheModel keHoachKiemDemVeSinhCacheModel = new KeHoachKiemDemVeSinhCacheModel();

		keHoachKiemDemVeSinhCacheModel.id = getId();

		keHoachKiemDemVeSinhCacheModel.nam = getNam();

		keHoachKiemDemVeSinhCacheModel.maTinh = getMaTinh();

		String maTinh = keHoachKiemDemVeSinhCacheModel.maTinh;

		if ((maTinh != null) && (maTinh.length() == 0)) {
			keHoachKiemDemVeSinhCacheModel.maTinh = null;
		}

		keHoachKiemDemVeSinhCacheModel.maHuyen = getMaHuyen();

		String maHuyen = keHoachKiemDemVeSinhCacheModel.maHuyen;

		if ((maHuyen != null) && (maHuyen.length() == 0)) {
			keHoachKiemDemVeSinhCacheModel.maHuyen = null;
		}

		keHoachKiemDemVeSinhCacheModel.kiemDemVienID = getKiemDemVienID();

		Date ngayBatDau = getNgayBatDau();

		if (ngayBatDau != null) {
			keHoachKiemDemVeSinhCacheModel.ngayBatDau = ngayBatDau.getTime();
		}
		else {
			keHoachKiemDemVeSinhCacheModel.ngayBatDau = Long.MIN_VALUE;
		}

		Date ngayKetThuc = getNgayKetThuc();

		if (ngayKetThuc != null) {
			keHoachKiemDemVeSinhCacheModel.ngayKetThuc = ngayKetThuc.getTime();
		}
		else {
			keHoachKiemDemVeSinhCacheModel.ngayKetThuc = Long.MIN_VALUE;
		}

		keHoachKiemDemVeSinhCacheModel.moTa = getMoTa();

		String moTa = keHoachKiemDemVeSinhCacheModel.moTa;

		if ((moTa != null) && (moTa.length() == 0)) {
			keHoachKiemDemVeSinhCacheModel.moTa = null;
		}

		Date ngayTao = getNgayTao();

		if (ngayTao != null) {
			keHoachKiemDemVeSinhCacheModel.ngayTao = ngayTao.getTime();
		}
		else {
			keHoachKiemDemVeSinhCacheModel.ngayTao = Long.MIN_VALUE;
		}

		keHoachKiemDemVeSinhCacheModel.idNguoiTao = getIdNguoiTao();

		Date ngayXuatBan = getNgayXuatBan();

		if (ngayXuatBan != null) {
			keHoachKiemDemVeSinhCacheModel.ngayXuatBan = ngayXuatBan.getTime();
		}
		else {
			keHoachKiemDemVeSinhCacheModel.ngayXuatBan = Long.MIN_VALUE;
		}

		keHoachKiemDemVeSinhCacheModel.idNguoiXuatBan = getIdNguoiXuatBan();

		keHoachKiemDemVeSinhCacheModel.tableId = getTableId();

		String tableId = keHoachKiemDemVeSinhCacheModel.tableId;

		if ((tableId != null) && (tableId.length() == 0)) {
			keHoachKiemDemVeSinhCacheModel.tableId = null;
		}

		Date ngayDong = getNgayDong();

		if (ngayDong != null) {
			keHoachKiemDemVeSinhCacheModel.ngayDong = ngayDong.getTime();
		}
		else {
			keHoachKiemDemVeSinhCacheModel.ngayDong = Long.MIN_VALUE;
		}

		keHoachKiemDemVeSinhCacheModel.idNguoiDong = getIdNguoiDong();

		Date lastSavePoint = getLastSavePoint();

		if (lastSavePoint != null) {
			keHoachKiemDemVeSinhCacheModel.lastSavePoint = lastSavePoint.getTime();
		}
		else {
			keHoachKiemDemVeSinhCacheModel.lastSavePoint = Long.MIN_VALUE;
		}

		return keHoachKiemDemVeSinhCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", nam=");
		sb.append(getNam());
		sb.append(", maTinh=");
		sb.append(getMaTinh());
		sb.append(", maHuyen=");
		sb.append(getMaHuyen());
		sb.append(", kiemDemVienID=");
		sb.append(getKiemDemVienID());
		sb.append(", ngayBatDau=");
		sb.append(getNgayBatDau());
		sb.append(", ngayKetThuc=");
		sb.append(getNgayKetThuc());
		sb.append(", moTa=");
		sb.append(getMoTa());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", idNguoiTao=");
		sb.append(getIdNguoiTao());
		sb.append(", ngayXuatBan=");
		sb.append(getNgayXuatBan());
		sb.append(", idNguoiXuatBan=");
		sb.append(getIdNguoiXuatBan());
		sb.append(", tableId=");
		sb.append(getTableId());
		sb.append(", ngayDong=");
		sb.append(getNgayDong());
		sb.append(", idNguoiDong=");
		sb.append(getIdNguoiDong());
		sb.append(", lastSavePoint=");
		sb.append(getLastSavePoint());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append(
			"vn.dtt.sol.ns.vesinhmoitruong.dao.model.KeHoachKiemDemVeSinh");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nam</column-name><column-value><![CDATA[");
		sb.append(getNam());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maTinh</column-name><column-value><![CDATA[");
		sb.append(getMaTinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maHuyen</column-name><column-value><![CDATA[");
		sb.append(getMaHuyen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kiemDemVienID</column-name><column-value><![CDATA[");
		sb.append(getKiemDemVienID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayBatDau</column-name><column-value><![CDATA[");
		sb.append(getNgayBatDau());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayKetThuc</column-name><column-value><![CDATA[");
		sb.append(getNgayKetThuc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moTa</column-name><column-value><![CDATA[");
		sb.append(getMoTa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idNguoiTao</column-name><column-value><![CDATA[");
		sb.append(getIdNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayXuatBan</column-name><column-value><![CDATA[");
		sb.append(getNgayXuatBan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idNguoiXuatBan</column-name><column-value><![CDATA[");
		sb.append(getIdNguoiXuatBan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tableId</column-name><column-value><![CDATA[");
		sb.append(getTableId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayDong</column-name><column-value><![CDATA[");
		sb.append(getNgayDong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idNguoiDong</column-name><column-value><![CDATA[");
		sb.append(getIdNguoiDong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastSavePoint</column-name><column-value><![CDATA[");
		sb.append(getLastSavePoint());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = KeHoachKiemDemVeSinh.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			KeHoachKiemDemVeSinh.class
		};
	private int _id;
	private int _nam;
	private String _maTinh;
	private String _maHuyen;
	private int _kiemDemVienID;
	private Date _ngayBatDau;
	private Date _ngayKetThuc;
	private String _moTa;
	private Date _ngayTao;
	private int _idNguoiTao;
	private Date _ngayXuatBan;
	private int _idNguoiXuatBan;
	private String _tableId;
	private Date _ngayDong;
	private int _idNguoiDong;
	private Date _lastSavePoint;
	private KeHoachKiemDemVeSinh _escapedModel;
}