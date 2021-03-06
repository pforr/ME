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

package vn.dtt.sol.ns.tramcap.dao.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import vn.dtt.sol.ns.tramcap.dao.model.DanhGiaBenVung;
import vn.dtt.sol.ns.tramcap.dao.model.DanhGiaBenVungModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the DanhGiaBenVung service. Represents a row in the &quot;ME_DANHGIABENVUNG&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.dtt.sol.ns.tramcap.dao.model.DanhGiaBenVungModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DanhGiaBenVungImpl}.
 * </p>
 *
 * @author khoa.vu
 * @see DanhGiaBenVungImpl
 * @see vn.dtt.sol.ns.tramcap.dao.model.DanhGiaBenVung
 * @see vn.dtt.sol.ns.tramcap.dao.model.DanhGiaBenVungModel
 * @generated
 */
public class DanhGiaBenVungModelImpl extends BaseModelImpl<DanhGiaBenVung>
	implements DanhGiaBenVungModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a danh gia ben vung model instance should use the {@link vn.dtt.sol.ns.tramcap.dao.model.DanhGiaBenVung} interface instead.
	 */
	public static final String TABLE_NAME = "ME_DANHGIABENVUNG";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.BIGINT },
			{ "TRAMCAPNUOCID", Types.INTEGER },
			{ "NAM", Types.INTEGER },
			{ "TRANGTHAICAPNUOC", Types.INTEGER },
			{ "CONGXUATTHUCTE", Types.INTEGER },
			{ "TONGDAUNOIMOI", Types.INTEGER },
			{ "TONGDAUNOITHUCTE", Types.INTEGER },
			{ "SONGUOICAPTHUCTE", Types.INTEGER },
			{ "NUOCTHATTHOAT", Types.INTEGER },
			{ "NUOCDATTIEUCHUAN", Types.INTEGER },
			{ "NUOCCOASEN", Types.INTEGER },
			{ "TONGCHIPHI", Types.INTEGER },
			{ "TONGDOANHTHU", Types.INTEGER },
			{ "NGAYTAO", Types.TIMESTAMP },
			{ "idNguoiTao", Types.INTEGER },
			{ "GHICHU", Types.VARCHAR },
			{ "KETQUADANHGIA", Types.INTEGER },
			{ "BAOCAODLI", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table ME_DANHGIABENVUNG (ID LONG not null primary key,TRAMCAPNUOCID INTEGER,NAM INTEGER,TRANGTHAICAPNUOC INTEGER,CONGXUATTHUCTE INTEGER,TONGDAUNOIMOI INTEGER,TONGDAUNOITHUCTE INTEGER,SONGUOICAPTHUCTE INTEGER,NUOCTHATTHOAT INTEGER,NUOCDATTIEUCHUAN INTEGER,NUOCCOASEN INTEGER,TONGCHIPHI INTEGER,TONGDOANHTHU INTEGER,NGAYTAO DATE null,idNguoiTao INTEGER,GHICHU VARCHAR(75) null,KETQUADANHGIA INTEGER,BAOCAODLI INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table ME_DANHGIABENVUNG";
	public static final String ORDER_BY_JPQL = " ORDER BY danhGiaBenVung.ngayTao DESC";
	public static final String ORDER_BY_SQL = " ORDER BY ME_DANHGIABENVUNG.NGAYTAO DESC";
	public static final String DATA_SOURCE = "dmDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.dtt.sol.ns.tramcap.dao.model.DanhGiaBenVung"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.dtt.sol.ns.tramcap.dao.model.DanhGiaBenVung"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.dtt.sol.ns.tramcap.dao.model.DanhGiaBenVung"),
			true);
	public static long NAM_COLUMN_BITMASK = 1L;
	public static long TRAMCAPNUOCID_COLUMN_BITMASK = 2L;
	public static long NGAYTAO_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.dtt.sol.ns.tramcap.dao.model.DanhGiaBenVung"));

	public DanhGiaBenVungModelImpl() {
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
		return DanhGiaBenVung.class;
	}

	@Override
	public String getModelClassName() {
		return DanhGiaBenVung.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("tramCapNuocId", getTramCapNuocId());
		attributes.put("nam", getNam());
		attributes.put("trangThaiCapNuoc", getTrangThaiCapNuoc());
		attributes.put("congXuatThucTe", getCongXuatThucTe());
		attributes.put("tongDauNoiMoi", getTongDauNoiMoi());
		attributes.put("tongDauNoiThucTe", getTongDauNoiThucTe());
		attributes.put("soNguoiCapThucTe", getSoNguoiCapThucTe());
		attributes.put("nuocThatThoat", getNuocThatThoat());
		attributes.put("nuocDatTieuChuan", getNuocDatTieuChuan());
		attributes.put("nuocCoAsen", getNuocCoAsen());
		attributes.put("tongChiPhi", getTongChiPhi());
		attributes.put("tongDoanhThu", getTongDoanhThu());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("idNguoiTao", getIdNguoiTao());
		attributes.put("ghiChu", getGhiChu());
		attributes.put("ketQuaDanhGia", getKetQuaDanhGia());
		attributes.put("baoCaoDLI", getBaoCaoDLI());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Integer tramCapNuocId = (Integer)attributes.get("tramCapNuocId");

		if (tramCapNuocId != null) {
			setTramCapNuocId(tramCapNuocId);
		}

		Integer nam = (Integer)attributes.get("nam");

		if (nam != null) {
			setNam(nam);
		}

		Integer trangThaiCapNuoc = (Integer)attributes.get("trangThaiCapNuoc");

		if (trangThaiCapNuoc != null) {
			setTrangThaiCapNuoc(trangThaiCapNuoc);
		}

		Integer congXuatThucTe = (Integer)attributes.get("congXuatThucTe");

		if (congXuatThucTe != null) {
			setCongXuatThucTe(congXuatThucTe);
		}

		Integer tongDauNoiMoi = (Integer)attributes.get("tongDauNoiMoi");

		if (tongDauNoiMoi != null) {
			setTongDauNoiMoi(tongDauNoiMoi);
		}

		Integer tongDauNoiThucTe = (Integer)attributes.get("tongDauNoiThucTe");

		if (tongDauNoiThucTe != null) {
			setTongDauNoiThucTe(tongDauNoiThucTe);
		}

		Integer soNguoiCapThucTe = (Integer)attributes.get("soNguoiCapThucTe");

		if (soNguoiCapThucTe != null) {
			setSoNguoiCapThucTe(soNguoiCapThucTe);
		}

		Integer nuocThatThoat = (Integer)attributes.get("nuocThatThoat");

		if (nuocThatThoat != null) {
			setNuocThatThoat(nuocThatThoat);
		}

		Integer nuocDatTieuChuan = (Integer)attributes.get("nuocDatTieuChuan");

		if (nuocDatTieuChuan != null) {
			setNuocDatTieuChuan(nuocDatTieuChuan);
		}

		Integer nuocCoAsen = (Integer)attributes.get("nuocCoAsen");

		if (nuocCoAsen != null) {
			setNuocCoAsen(nuocCoAsen);
		}

		Integer tongChiPhi = (Integer)attributes.get("tongChiPhi");

		if (tongChiPhi != null) {
			setTongChiPhi(tongChiPhi);
		}

		Integer tongDoanhThu = (Integer)attributes.get("tongDoanhThu");

		if (tongDoanhThu != null) {
			setTongDoanhThu(tongDoanhThu);
		}

		Date ngayTao = (Date)attributes.get("ngayTao");

		if (ngayTao != null) {
			setNgayTao(ngayTao);
		}

		Integer idNguoiTao = (Integer)attributes.get("idNguoiTao");

		if (idNguoiTao != null) {
			setIdNguoiTao(idNguoiTao);
		}

		String ghiChu = (String)attributes.get("ghiChu");

		if (ghiChu != null) {
			setGhiChu(ghiChu);
		}

		Integer ketQuaDanhGia = (Integer)attributes.get("ketQuaDanhGia");

		if (ketQuaDanhGia != null) {
			setKetQuaDanhGia(ketQuaDanhGia);
		}

		Integer baoCaoDLI = (Integer)attributes.get("baoCaoDLI");

		if (baoCaoDLI != null) {
			setBaoCaoDLI(baoCaoDLI);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public int getTramCapNuocId() {
		return _tramCapNuocId;
	}

	@Override
	public void setTramCapNuocId(int tramCapNuocId) {
		_columnBitmask |= TRAMCAPNUOCID_COLUMN_BITMASK;

		if (!_setOriginalTramCapNuocId) {
			_setOriginalTramCapNuocId = true;

			_originalTramCapNuocId = _tramCapNuocId;
		}

		_tramCapNuocId = tramCapNuocId;
	}

	public int getOriginalTramCapNuocId() {
		return _originalTramCapNuocId;
	}

	@Override
	public int getNam() {
		return _nam;
	}

	@Override
	public void setNam(int nam) {
		_columnBitmask |= NAM_COLUMN_BITMASK;

		if (!_setOriginalNam) {
			_setOriginalNam = true;

			_originalNam = _nam;
		}

		_nam = nam;
	}

	public int getOriginalNam() {
		return _originalNam;
	}

	@Override
	public int getTrangThaiCapNuoc() {
		return _trangThaiCapNuoc;
	}

	@Override
	public void setTrangThaiCapNuoc(int trangThaiCapNuoc) {
		_trangThaiCapNuoc = trangThaiCapNuoc;
	}

	@Override
	public int getCongXuatThucTe() {
		return _congXuatThucTe;
	}

	@Override
	public void setCongXuatThucTe(int congXuatThucTe) {
		_congXuatThucTe = congXuatThucTe;
	}

	@Override
	public int getTongDauNoiMoi() {
		return _tongDauNoiMoi;
	}

	@Override
	public void setTongDauNoiMoi(int tongDauNoiMoi) {
		_tongDauNoiMoi = tongDauNoiMoi;
	}

	@Override
	public int getTongDauNoiThucTe() {
		return _tongDauNoiThucTe;
	}

	@Override
	public void setTongDauNoiThucTe(int tongDauNoiThucTe) {
		_tongDauNoiThucTe = tongDauNoiThucTe;
	}

	@Override
	public int getSoNguoiCapThucTe() {
		return _soNguoiCapThucTe;
	}

	@Override
	public void setSoNguoiCapThucTe(int soNguoiCapThucTe) {
		_soNguoiCapThucTe = soNguoiCapThucTe;
	}

	@Override
	public int getNuocThatThoat() {
		return _nuocThatThoat;
	}

	@Override
	public void setNuocThatThoat(int nuocThatThoat) {
		_nuocThatThoat = nuocThatThoat;
	}

	@Override
	public int getNuocDatTieuChuan() {
		return _nuocDatTieuChuan;
	}

	@Override
	public void setNuocDatTieuChuan(int nuocDatTieuChuan) {
		_nuocDatTieuChuan = nuocDatTieuChuan;
	}

	@Override
	public int getNuocCoAsen() {
		return _nuocCoAsen;
	}

	@Override
	public void setNuocCoAsen(int nuocCoAsen) {
		_nuocCoAsen = nuocCoAsen;
	}

	@Override
	public int getTongChiPhi() {
		return _tongChiPhi;
	}

	@Override
	public void setTongChiPhi(int tongChiPhi) {
		_tongChiPhi = tongChiPhi;
	}

	@Override
	public int getTongDoanhThu() {
		return _tongDoanhThu;
	}

	@Override
	public void setTongDoanhThu(int tongDoanhThu) {
		_tongDoanhThu = tongDoanhThu;
	}

	@Override
	public Date getNgayTao() {
		return _ngayTao;
	}

	@Override
	public void setNgayTao(Date ngayTao) {
		_columnBitmask = -1L;

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
	public String getGhiChu() {
		if (_ghiChu == null) {
			return StringPool.BLANK;
		}
		else {
			return _ghiChu;
		}
	}

	@Override
	public void setGhiChu(String ghiChu) {
		_ghiChu = ghiChu;
	}

	@Override
	public int getKetQuaDanhGia() {
		return _ketQuaDanhGia;
	}

	@Override
	public void setKetQuaDanhGia(int ketQuaDanhGia) {
		_ketQuaDanhGia = ketQuaDanhGia;
	}

	@Override
	public int getBaoCaoDLI() {
		return _baoCaoDLI;
	}

	@Override
	public void setBaoCaoDLI(int baoCaoDLI) {
		_baoCaoDLI = baoCaoDLI;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			DanhGiaBenVung.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DanhGiaBenVung toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DanhGiaBenVung)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DanhGiaBenVungImpl danhGiaBenVungImpl = new DanhGiaBenVungImpl();

		danhGiaBenVungImpl.setId(getId());
		danhGiaBenVungImpl.setTramCapNuocId(getTramCapNuocId());
		danhGiaBenVungImpl.setNam(getNam());
		danhGiaBenVungImpl.setTrangThaiCapNuoc(getTrangThaiCapNuoc());
		danhGiaBenVungImpl.setCongXuatThucTe(getCongXuatThucTe());
		danhGiaBenVungImpl.setTongDauNoiMoi(getTongDauNoiMoi());
		danhGiaBenVungImpl.setTongDauNoiThucTe(getTongDauNoiThucTe());
		danhGiaBenVungImpl.setSoNguoiCapThucTe(getSoNguoiCapThucTe());
		danhGiaBenVungImpl.setNuocThatThoat(getNuocThatThoat());
		danhGiaBenVungImpl.setNuocDatTieuChuan(getNuocDatTieuChuan());
		danhGiaBenVungImpl.setNuocCoAsen(getNuocCoAsen());
		danhGiaBenVungImpl.setTongChiPhi(getTongChiPhi());
		danhGiaBenVungImpl.setTongDoanhThu(getTongDoanhThu());
		danhGiaBenVungImpl.setNgayTao(getNgayTao());
		danhGiaBenVungImpl.setIdNguoiTao(getIdNguoiTao());
		danhGiaBenVungImpl.setGhiChu(getGhiChu());
		danhGiaBenVungImpl.setKetQuaDanhGia(getKetQuaDanhGia());
		danhGiaBenVungImpl.setBaoCaoDLI(getBaoCaoDLI());

		danhGiaBenVungImpl.resetOriginalValues();

		return danhGiaBenVungImpl;
	}

	@Override
	public int compareTo(DanhGiaBenVung danhGiaBenVung) {
		int value = 0;

		value = DateUtil.compareTo(getNgayTao(), danhGiaBenVung.getNgayTao());

		value = value * -1;

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

		if (!(obj instanceof DanhGiaBenVung)) {
			return false;
		}

		DanhGiaBenVung danhGiaBenVung = (DanhGiaBenVung)obj;

		long primaryKey = danhGiaBenVung.getPrimaryKey();

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
		DanhGiaBenVungModelImpl danhGiaBenVungModelImpl = this;

		danhGiaBenVungModelImpl._originalTramCapNuocId = danhGiaBenVungModelImpl._tramCapNuocId;

		danhGiaBenVungModelImpl._setOriginalTramCapNuocId = false;

		danhGiaBenVungModelImpl._originalNam = danhGiaBenVungModelImpl._nam;

		danhGiaBenVungModelImpl._setOriginalNam = false;

		danhGiaBenVungModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DanhGiaBenVung> toCacheModel() {
		DanhGiaBenVungCacheModel danhGiaBenVungCacheModel = new DanhGiaBenVungCacheModel();

		danhGiaBenVungCacheModel.id = getId();

		danhGiaBenVungCacheModel.tramCapNuocId = getTramCapNuocId();

		danhGiaBenVungCacheModel.nam = getNam();

		danhGiaBenVungCacheModel.trangThaiCapNuoc = getTrangThaiCapNuoc();

		danhGiaBenVungCacheModel.congXuatThucTe = getCongXuatThucTe();

		danhGiaBenVungCacheModel.tongDauNoiMoi = getTongDauNoiMoi();

		danhGiaBenVungCacheModel.tongDauNoiThucTe = getTongDauNoiThucTe();

		danhGiaBenVungCacheModel.soNguoiCapThucTe = getSoNguoiCapThucTe();

		danhGiaBenVungCacheModel.nuocThatThoat = getNuocThatThoat();

		danhGiaBenVungCacheModel.nuocDatTieuChuan = getNuocDatTieuChuan();

		danhGiaBenVungCacheModel.nuocCoAsen = getNuocCoAsen();

		danhGiaBenVungCacheModel.tongChiPhi = getTongChiPhi();

		danhGiaBenVungCacheModel.tongDoanhThu = getTongDoanhThu();

		Date ngayTao = getNgayTao();

		if (ngayTao != null) {
			danhGiaBenVungCacheModel.ngayTao = ngayTao.getTime();
		}
		else {
			danhGiaBenVungCacheModel.ngayTao = Long.MIN_VALUE;
		}

		danhGiaBenVungCacheModel.idNguoiTao = getIdNguoiTao();

		danhGiaBenVungCacheModel.ghiChu = getGhiChu();

		String ghiChu = danhGiaBenVungCacheModel.ghiChu;

		if ((ghiChu != null) && (ghiChu.length() == 0)) {
			danhGiaBenVungCacheModel.ghiChu = null;
		}

		danhGiaBenVungCacheModel.ketQuaDanhGia = getKetQuaDanhGia();

		danhGiaBenVungCacheModel.baoCaoDLI = getBaoCaoDLI();

		return danhGiaBenVungCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", tramCapNuocId=");
		sb.append(getTramCapNuocId());
		sb.append(", nam=");
		sb.append(getNam());
		sb.append(", trangThaiCapNuoc=");
		sb.append(getTrangThaiCapNuoc());
		sb.append(", congXuatThucTe=");
		sb.append(getCongXuatThucTe());
		sb.append(", tongDauNoiMoi=");
		sb.append(getTongDauNoiMoi());
		sb.append(", tongDauNoiThucTe=");
		sb.append(getTongDauNoiThucTe());
		sb.append(", soNguoiCapThucTe=");
		sb.append(getSoNguoiCapThucTe());
		sb.append(", nuocThatThoat=");
		sb.append(getNuocThatThoat());
		sb.append(", nuocDatTieuChuan=");
		sb.append(getNuocDatTieuChuan());
		sb.append(", nuocCoAsen=");
		sb.append(getNuocCoAsen());
		sb.append(", tongChiPhi=");
		sb.append(getTongChiPhi());
		sb.append(", tongDoanhThu=");
		sb.append(getTongDoanhThu());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", idNguoiTao=");
		sb.append(getIdNguoiTao());
		sb.append(", ghiChu=");
		sb.append(getGhiChu());
		sb.append(", ketQuaDanhGia=");
		sb.append(getKetQuaDanhGia());
		sb.append(", baoCaoDLI=");
		sb.append(getBaoCaoDLI());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.sol.ns.tramcap.dao.model.DanhGiaBenVung");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tramCapNuocId</column-name><column-value><![CDATA[");
		sb.append(getTramCapNuocId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nam</column-name><column-value><![CDATA[");
		sb.append(getNam());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThaiCapNuoc</column-name><column-value><![CDATA[");
		sb.append(getTrangThaiCapNuoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>congXuatThucTe</column-name><column-value><![CDATA[");
		sb.append(getCongXuatThucTe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tongDauNoiMoi</column-name><column-value><![CDATA[");
		sb.append(getTongDauNoiMoi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tongDauNoiThucTe</column-name><column-value><![CDATA[");
		sb.append(getTongDauNoiThucTe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soNguoiCapThucTe</column-name><column-value><![CDATA[");
		sb.append(getSoNguoiCapThucTe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuocThatThoat</column-name><column-value><![CDATA[");
		sb.append(getNuocThatThoat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuocDatTieuChuan</column-name><column-value><![CDATA[");
		sb.append(getNuocDatTieuChuan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nuocCoAsen</column-name><column-value><![CDATA[");
		sb.append(getNuocCoAsen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tongChiPhi</column-name><column-value><![CDATA[");
		sb.append(getTongChiPhi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tongDoanhThu</column-name><column-value><![CDATA[");
		sb.append(getTongDoanhThu());
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
			"<column><column-name>ghiChu</column-name><column-value><![CDATA[");
		sb.append(getGhiChu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ketQuaDanhGia</column-name><column-value><![CDATA[");
		sb.append(getKetQuaDanhGia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>baoCaoDLI</column-name><column-value><![CDATA[");
		sb.append(getBaoCaoDLI());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DanhGiaBenVung.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			DanhGiaBenVung.class
		};
	private long _id;
	private int _tramCapNuocId;
	private int _originalTramCapNuocId;
	private boolean _setOriginalTramCapNuocId;
	private int _nam;
	private int _originalNam;
	private boolean _setOriginalNam;
	private int _trangThaiCapNuoc;
	private int _congXuatThucTe;
	private int _tongDauNoiMoi;
	private int _tongDauNoiThucTe;
	private int _soNguoiCapThucTe;
	private int _nuocThatThoat;
	private int _nuocDatTieuChuan;
	private int _nuocCoAsen;
	private int _tongChiPhi;
	private int _tongDoanhThu;
	private Date _ngayTao;
	private int _idNguoiTao;
	private String _ghiChu;
	private int _ketQuaDanhGia;
	private int _baoCaoDLI;
	private long _columnBitmask;
	private DanhGiaBenVung _escapedModel;
}