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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc;
import vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuocModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the DauNoiNuoc service. Represents a row in the &quot;ME_DAUNOINUOC&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuocModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DauNoiNuocImpl}.
 * </p>
 *
 * @author khoa.vu
 * @see DauNoiNuocImpl
 * @see vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc
 * @see vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuocModel
 * @generated
 */
public class DauNoiNuocModelImpl extends BaseModelImpl<DauNoiNuoc>
	implements DauNoiNuocModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dau noi nuoc model instance should use the {@link vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc} interface instead.
	 */
	public static final String TABLE_NAME = "ME_DAUNOINUOC";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.BIGINT },
			{ "TRAMCAPNUOCID", Types.INTEGER },
			{ "MATINH", Types.VARCHAR },
			{ "MAHUYEN", Types.VARCHAR },
			{ "MAXA", Types.VARCHAR },
			{ "THONXOM", Types.VARCHAR },
			{ "TENCHUHO", Types.VARCHAR },
			{ "GIOITINH", Types.INTEGER },
			{ "NGAYDAUNOIHOPDONG", Types.TIMESTAMP },
			{ "TRANGTHAI", Types.INTEGER },
			{ "NAMBAOCAO", Types.INTEGER },
			{ "GHICHU", Types.VARCHAR },
			{ "NGAYTAO", Types.TIMESTAMP },
			{ "IDNGUOITAO", Types.INTEGER },
			{ "SONGUOITRONGHO", Types.INTEGER },
			{ "THANHPHANHOGIADINH", Types.INTEGER },
			{ "TONGDOANHTHU", Types.INTEGER },
			{ "KINHDO", Types.VARCHAR },
			{ "VIDO", Types.VARCHAR },
			{ "NGAYDAUNOITHUCTE", Types.TIMESTAMP },
			{ "SOSERYDONGHO", Types.VARCHAR },
			{ "DANHGIANUOCHVS", Types.VARCHAR },
			{ "NGAYKIEMDEM", Types.TIMESTAMP },
			{ "NGAYDANHGIA", Types.TIMESTAMP },
			{ "IDNGUOIDANHGIA", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table ME_DAUNOINUOC (ID LONG not null primary key,TRAMCAPNUOCID INTEGER,MATINH VARCHAR(75) null,MAHUYEN VARCHAR(75) null,MAXA VARCHAR(75) null,THONXOM VARCHAR(75) null,TENCHUHO VARCHAR(75) null,GIOITINH INTEGER,NGAYDAUNOIHOPDONG DATE null,TRANGTHAI INTEGER,NAMBAOCAO INTEGER,GHICHU VARCHAR(75) null,NGAYTAO DATE null,IDNGUOITAO INTEGER,SONGUOITRONGHO INTEGER,THANHPHANHOGIADINH INTEGER,TONGDOANHTHU INTEGER,KINHDO VARCHAR(75) null,VIDO VARCHAR(75) null,NGAYDAUNOITHUCTE DATE null,SOSERYDONGHO VARCHAR(75) null,DANHGIANUOCHVS VARCHAR(75) null,NGAYKIEMDEM DATE null,NGAYDANHGIA DATE null,IDNGUOIDANHGIA INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table ME_DAUNOINUOC";
	public static final String ORDER_BY_JPQL = " ORDER BY dauNoiNuoc.maTinh ASC, dauNoiNuoc.maHuyen ASC, dauNoiNuoc.maXa ASC, dauNoiNuoc.thonXom ASC, dauNoiNuoc.tramCapNuocId ASC, dauNoiNuoc.tenChuHo ASC, dauNoiNuoc.trangThai ASC, dauNoiNuoc.namBaoCao ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ME_DAUNOINUOC.MATINH ASC, ME_DAUNOINUOC.MAHUYEN ASC, ME_DAUNOINUOC.MAXA ASC, ME_DAUNOINUOC.THONXOM ASC, ME_DAUNOINUOC.TRAMCAPNUOCID ASC, ME_DAUNOINUOC.TENCHUHO ASC, ME_DAUNOINUOC.TRANGTHAI ASC, ME_DAUNOINUOC.NAMBAOCAO ASC";
	public static final String DATA_SOURCE = "dmDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc"),
			true);
	public static long IDNGUOIDANHGIA_COLUMN_BITMASK = 1L;
	public static long IDNGUOITAO_COLUMN_BITMASK = 2L;
	public static long MAHUYEN_COLUMN_BITMASK = 4L;
	public static long MATINH_COLUMN_BITMASK = 8L;
	public static long MAXA_COLUMN_BITMASK = 16L;
	public static long TENCHUHO_COLUMN_BITMASK = 32L;
	public static long THONXOM_COLUMN_BITMASK = 64L;
	public static long TRAMCAPNUOCID_COLUMN_BITMASK = 128L;
	public static long TRANGTHAI_COLUMN_BITMASK = 256L;
	public static long NAMBAOCAO_COLUMN_BITMASK = 512L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc"));

	public DauNoiNuocModelImpl() {
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
		return DauNoiNuoc.class;
	}

	@Override
	public String getModelClassName() {
		return DauNoiNuoc.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("tramCapNuocId", getTramCapNuocId());
		attributes.put("maTinh", getMaTinh());
		attributes.put("maHuyen", getMaHuyen());
		attributes.put("maXa", getMaXa());
		attributes.put("thonXom", getThonXom());
		attributes.put("tenChuHo", getTenChuHo());
		attributes.put("gioiTinh", getGioiTinh());
		attributes.put("ngayDauNoiHopDong", getNgayDauNoiHopDong());
		attributes.put("trangThai", getTrangThai());
		attributes.put("namBaoCao", getNamBaoCao());
		attributes.put("ghiChu", getGhiChu());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("idNguoiTao", getIdNguoiTao());
		attributes.put("soNguoiTrongHo", getSoNguoiTrongHo());
		attributes.put("thanhPhanHoGiaDinh", getThanhPhanHoGiaDinh());
		attributes.put("tongDoanhThu", getTongDoanhThu());
		attributes.put("kinhDo", getKinhDo());
		attributes.put("viDo", getViDo());
		attributes.put("ngayDauNoiThucTe", getNgayDauNoiThucTe());
		attributes.put("soSeryDongHo", getSoSeryDongHo());
		attributes.put("danhGiaNuocHVS", getDanhGiaNuocHVS());
		attributes.put("ngayKiemDem", getNgayKiemDem());
		attributes.put("ngayDanhGia", getNgayDanhGia());
		attributes.put("idNguoiDanhGia", getIdNguoiDanhGia());

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

		String maTinh = (String)attributes.get("maTinh");

		if (maTinh != null) {
			setMaTinh(maTinh);
		}

		String maHuyen = (String)attributes.get("maHuyen");

		if (maHuyen != null) {
			setMaHuyen(maHuyen);
		}

		String maXa = (String)attributes.get("maXa");

		if (maXa != null) {
			setMaXa(maXa);
		}

		String thonXom = (String)attributes.get("thonXom");

		if (thonXom != null) {
			setThonXom(thonXom);
		}

		String tenChuHo = (String)attributes.get("tenChuHo");

		if (tenChuHo != null) {
			setTenChuHo(tenChuHo);
		}

		Integer gioiTinh = (Integer)attributes.get("gioiTinh");

		if (gioiTinh != null) {
			setGioiTinh(gioiTinh);
		}

		Date ngayDauNoiHopDong = (Date)attributes.get("ngayDauNoiHopDong");

		if (ngayDauNoiHopDong != null) {
			setNgayDauNoiHopDong(ngayDauNoiHopDong);
		}

		Integer trangThai = (Integer)attributes.get("trangThai");

		if (trangThai != null) {
			setTrangThai(trangThai);
		}

		Integer namBaoCao = (Integer)attributes.get("namBaoCao");

		if (namBaoCao != null) {
			setNamBaoCao(namBaoCao);
		}

		String ghiChu = (String)attributes.get("ghiChu");

		if (ghiChu != null) {
			setGhiChu(ghiChu);
		}

		Date ngayTao = (Date)attributes.get("ngayTao");

		if (ngayTao != null) {
			setNgayTao(ngayTao);
		}

		Integer idNguoiTao = (Integer)attributes.get("idNguoiTao");

		if (idNguoiTao != null) {
			setIdNguoiTao(idNguoiTao);
		}

		Integer soNguoiTrongHo = (Integer)attributes.get("soNguoiTrongHo");

		if (soNguoiTrongHo != null) {
			setSoNguoiTrongHo(soNguoiTrongHo);
		}

		Integer thanhPhanHoGiaDinh = (Integer)attributes.get(
				"thanhPhanHoGiaDinh");

		if (thanhPhanHoGiaDinh != null) {
			setThanhPhanHoGiaDinh(thanhPhanHoGiaDinh);
		}

		Integer tongDoanhThu = (Integer)attributes.get("tongDoanhThu");

		if (tongDoanhThu != null) {
			setTongDoanhThu(tongDoanhThu);
		}

		String kinhDo = (String)attributes.get("kinhDo");

		if (kinhDo != null) {
			setKinhDo(kinhDo);
		}

		String viDo = (String)attributes.get("viDo");

		if (viDo != null) {
			setViDo(viDo);
		}

		Date ngayDauNoiThucTe = (Date)attributes.get("ngayDauNoiThucTe");

		if (ngayDauNoiThucTe != null) {
			setNgayDauNoiThucTe(ngayDauNoiThucTe);
		}

		String soSeryDongHo = (String)attributes.get("soSeryDongHo");

		if (soSeryDongHo != null) {
			setSoSeryDongHo(soSeryDongHo);
		}

		String danhGiaNuocHVS = (String)attributes.get("danhGiaNuocHVS");

		if (danhGiaNuocHVS != null) {
			setDanhGiaNuocHVS(danhGiaNuocHVS);
		}

		Date ngayKiemDem = (Date)attributes.get("ngayKiemDem");

		if (ngayKiemDem != null) {
			setNgayKiemDem(ngayKiemDem);
		}

		Date ngayDanhGia = (Date)attributes.get("ngayDanhGia");

		if (ngayDanhGia != null) {
			setNgayDanhGia(ngayDanhGia);
		}

		Integer idNguoiDanhGia = (Integer)attributes.get("idNguoiDanhGia");

		if (idNguoiDanhGia != null) {
			setIdNguoiDanhGia(idNguoiDanhGia);
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
		_columnBitmask = -1L;

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
		_columnBitmask = -1L;

		if (_originalMaTinh == null) {
			_originalMaTinh = _maTinh;
		}

		_maTinh = maTinh;
	}

	public String getOriginalMaTinh() {
		return GetterUtil.getString(_originalMaTinh);
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
		_columnBitmask = -1L;

		if (_originalMaHuyen == null) {
			_originalMaHuyen = _maHuyen;
		}

		_maHuyen = maHuyen;
	}

	public String getOriginalMaHuyen() {
		return GetterUtil.getString(_originalMaHuyen);
	}

	@Override
	public String getMaXa() {
		if (_maXa == null) {
			return StringPool.BLANK;
		}
		else {
			return _maXa;
		}
	}

	@Override
	public void setMaXa(String maXa) {
		_columnBitmask = -1L;

		if (_originalMaXa == null) {
			_originalMaXa = _maXa;
		}

		_maXa = maXa;
	}

	public String getOriginalMaXa() {
		return GetterUtil.getString(_originalMaXa);
	}

	@Override
	public String getThonXom() {
		if (_thonXom == null) {
			return StringPool.BLANK;
		}
		else {
			return _thonXom;
		}
	}

	@Override
	public void setThonXom(String thonXom) {
		_columnBitmask = -1L;

		if (_originalThonXom == null) {
			_originalThonXom = _thonXom;
		}

		_thonXom = thonXom;
	}

	public String getOriginalThonXom() {
		return GetterUtil.getString(_originalThonXom);
	}

	@Override
	public String getTenChuHo() {
		if (_tenChuHo == null) {
			return StringPool.BLANK;
		}
		else {
			return _tenChuHo;
		}
	}

	@Override
	public void setTenChuHo(String tenChuHo) {
		_columnBitmask = -1L;

		if (_originalTenChuHo == null) {
			_originalTenChuHo = _tenChuHo;
		}

		_tenChuHo = tenChuHo;
	}

	public String getOriginalTenChuHo() {
		return GetterUtil.getString(_originalTenChuHo);
	}

	@Override
	public int getGioiTinh() {
		return _gioiTinh;
	}

	@Override
	public void setGioiTinh(int gioiTinh) {
		_gioiTinh = gioiTinh;
	}

	@Override
	public Date getNgayDauNoiHopDong() {
		return _ngayDauNoiHopDong;
	}

	@Override
	public void setNgayDauNoiHopDong(Date ngayDauNoiHopDong) {
		_ngayDauNoiHopDong = ngayDauNoiHopDong;
	}

	@Override
	public int getTrangThai() {
		return _trangThai;
	}

	@Override
	public void setTrangThai(int trangThai) {
		_columnBitmask = -1L;

		_trangThai = trangThai;
	}

	@Override
	public int getNamBaoCao() {
		return _namBaoCao;
	}

	@Override
	public void setNamBaoCao(int namBaoCao) {
		_columnBitmask = -1L;

		_namBaoCao = namBaoCao;
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
		_columnBitmask |= IDNGUOITAO_COLUMN_BITMASK;

		if (!_setOriginalIdNguoiTao) {
			_setOriginalIdNguoiTao = true;

			_originalIdNguoiTao = _idNguoiTao;
		}

		_idNguoiTao = idNguoiTao;
	}

	public int getOriginalIdNguoiTao() {
		return _originalIdNguoiTao;
	}

	@Override
	public int getSoNguoiTrongHo() {
		return _soNguoiTrongHo;
	}

	@Override
	public void setSoNguoiTrongHo(int soNguoiTrongHo) {
		_soNguoiTrongHo = soNguoiTrongHo;
	}

	@Override
	public int getThanhPhanHoGiaDinh() {
		return _thanhPhanHoGiaDinh;
	}

	@Override
	public void setThanhPhanHoGiaDinh(int thanhPhanHoGiaDinh) {
		_thanhPhanHoGiaDinh = thanhPhanHoGiaDinh;
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
	public String getKinhDo() {
		if (_kinhDo == null) {
			return StringPool.BLANK;
		}
		else {
			return _kinhDo;
		}
	}

	@Override
	public void setKinhDo(String kinhDo) {
		_kinhDo = kinhDo;
	}

	@Override
	public String getViDo() {
		if (_viDo == null) {
			return StringPool.BLANK;
		}
		else {
			return _viDo;
		}
	}

	@Override
	public void setViDo(String viDo) {
		_viDo = viDo;
	}

	@Override
	public Date getNgayDauNoiThucTe() {
		return _ngayDauNoiThucTe;
	}

	@Override
	public void setNgayDauNoiThucTe(Date ngayDauNoiThucTe) {
		_ngayDauNoiThucTe = ngayDauNoiThucTe;
	}

	@Override
	public String getSoSeryDongHo() {
		if (_soSeryDongHo == null) {
			return StringPool.BLANK;
		}
		else {
			return _soSeryDongHo;
		}
	}

	@Override
	public void setSoSeryDongHo(String soSeryDongHo) {
		_soSeryDongHo = soSeryDongHo;
	}

	@Override
	public String getDanhGiaNuocHVS() {
		if (_danhGiaNuocHVS == null) {
			return StringPool.BLANK;
		}
		else {
			return _danhGiaNuocHVS;
		}
	}

	@Override
	public void setDanhGiaNuocHVS(String danhGiaNuocHVS) {
		_danhGiaNuocHVS = danhGiaNuocHVS;
	}

	@Override
	public Date getNgayKiemDem() {
		return _ngayKiemDem;
	}

	@Override
	public void setNgayKiemDem(Date ngayKiemDem) {
		_ngayKiemDem = ngayKiemDem;
	}

	@Override
	public Date getNgayDanhGia() {
		return _ngayDanhGia;
	}

	@Override
	public void setNgayDanhGia(Date ngayDanhGia) {
		_ngayDanhGia = ngayDanhGia;
	}

	@Override
	public int getIdNguoiDanhGia() {
		return _idNguoiDanhGia;
	}

	@Override
	public void setIdNguoiDanhGia(int idNguoiDanhGia) {
		_columnBitmask |= IDNGUOIDANHGIA_COLUMN_BITMASK;

		if (!_setOriginalIdNguoiDanhGia) {
			_setOriginalIdNguoiDanhGia = true;

			_originalIdNguoiDanhGia = _idNguoiDanhGia;
		}

		_idNguoiDanhGia = idNguoiDanhGia;
	}

	public int getOriginalIdNguoiDanhGia() {
		return _originalIdNguoiDanhGia;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			DauNoiNuoc.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DauNoiNuoc toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DauNoiNuoc)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DauNoiNuocImpl dauNoiNuocImpl = new DauNoiNuocImpl();

		dauNoiNuocImpl.setId(getId());
		dauNoiNuocImpl.setTramCapNuocId(getTramCapNuocId());
		dauNoiNuocImpl.setMaTinh(getMaTinh());
		dauNoiNuocImpl.setMaHuyen(getMaHuyen());
		dauNoiNuocImpl.setMaXa(getMaXa());
		dauNoiNuocImpl.setThonXom(getThonXom());
		dauNoiNuocImpl.setTenChuHo(getTenChuHo());
		dauNoiNuocImpl.setGioiTinh(getGioiTinh());
		dauNoiNuocImpl.setNgayDauNoiHopDong(getNgayDauNoiHopDong());
		dauNoiNuocImpl.setTrangThai(getTrangThai());
		dauNoiNuocImpl.setNamBaoCao(getNamBaoCao());
		dauNoiNuocImpl.setGhiChu(getGhiChu());
		dauNoiNuocImpl.setNgayTao(getNgayTao());
		dauNoiNuocImpl.setIdNguoiTao(getIdNguoiTao());
		dauNoiNuocImpl.setSoNguoiTrongHo(getSoNguoiTrongHo());
		dauNoiNuocImpl.setThanhPhanHoGiaDinh(getThanhPhanHoGiaDinh());
		dauNoiNuocImpl.setTongDoanhThu(getTongDoanhThu());
		dauNoiNuocImpl.setKinhDo(getKinhDo());
		dauNoiNuocImpl.setViDo(getViDo());
		dauNoiNuocImpl.setNgayDauNoiThucTe(getNgayDauNoiThucTe());
		dauNoiNuocImpl.setSoSeryDongHo(getSoSeryDongHo());
		dauNoiNuocImpl.setDanhGiaNuocHVS(getDanhGiaNuocHVS());
		dauNoiNuocImpl.setNgayKiemDem(getNgayKiemDem());
		dauNoiNuocImpl.setNgayDanhGia(getNgayDanhGia());
		dauNoiNuocImpl.setIdNguoiDanhGia(getIdNguoiDanhGia());

		dauNoiNuocImpl.resetOriginalValues();

		return dauNoiNuocImpl;
	}

	@Override
	public int compareTo(DauNoiNuoc dauNoiNuoc) {
		int value = 0;

		value = getMaTinh().compareTo(dauNoiNuoc.getMaTinh());

		if (value != 0) {
			return value;
		}

		value = getMaHuyen().compareTo(dauNoiNuoc.getMaHuyen());

		if (value != 0) {
			return value;
		}

		value = getMaXa().compareTo(dauNoiNuoc.getMaXa());

		if (value != 0) {
			return value;
		}

		value = getThonXom().compareTo(dauNoiNuoc.getThonXom());

		if (value != 0) {
			return value;
		}

		if (getTramCapNuocId() < dauNoiNuoc.getTramCapNuocId()) {
			value = -1;
		}
		else if (getTramCapNuocId() > dauNoiNuoc.getTramCapNuocId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getTenChuHo().compareTo(dauNoiNuoc.getTenChuHo());

		if (value != 0) {
			return value;
		}

		if (getTrangThai() < dauNoiNuoc.getTrangThai()) {
			value = -1;
		}
		else if (getTrangThai() > dauNoiNuoc.getTrangThai()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getNamBaoCao() < dauNoiNuoc.getNamBaoCao()) {
			value = -1;
		}
		else if (getNamBaoCao() > dauNoiNuoc.getNamBaoCao()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof DauNoiNuoc)) {
			return false;
		}

		DauNoiNuoc dauNoiNuoc = (DauNoiNuoc)obj;

		long primaryKey = dauNoiNuoc.getPrimaryKey();

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
		DauNoiNuocModelImpl dauNoiNuocModelImpl = this;

		dauNoiNuocModelImpl._originalTramCapNuocId = dauNoiNuocModelImpl._tramCapNuocId;

		dauNoiNuocModelImpl._setOriginalTramCapNuocId = false;

		dauNoiNuocModelImpl._originalMaTinh = dauNoiNuocModelImpl._maTinh;

		dauNoiNuocModelImpl._originalMaHuyen = dauNoiNuocModelImpl._maHuyen;

		dauNoiNuocModelImpl._originalMaXa = dauNoiNuocModelImpl._maXa;

		dauNoiNuocModelImpl._originalThonXom = dauNoiNuocModelImpl._thonXom;

		dauNoiNuocModelImpl._originalTenChuHo = dauNoiNuocModelImpl._tenChuHo;

		dauNoiNuocModelImpl._originalIdNguoiTao = dauNoiNuocModelImpl._idNguoiTao;

		dauNoiNuocModelImpl._setOriginalIdNguoiTao = false;

		dauNoiNuocModelImpl._originalIdNguoiDanhGia = dauNoiNuocModelImpl._idNguoiDanhGia;

		dauNoiNuocModelImpl._setOriginalIdNguoiDanhGia = false;

		dauNoiNuocModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DauNoiNuoc> toCacheModel() {
		DauNoiNuocCacheModel dauNoiNuocCacheModel = new DauNoiNuocCacheModel();

		dauNoiNuocCacheModel.id = getId();

		dauNoiNuocCacheModel.tramCapNuocId = getTramCapNuocId();

		dauNoiNuocCacheModel.maTinh = getMaTinh();

		String maTinh = dauNoiNuocCacheModel.maTinh;

		if ((maTinh != null) && (maTinh.length() == 0)) {
			dauNoiNuocCacheModel.maTinh = null;
		}

		dauNoiNuocCacheModel.maHuyen = getMaHuyen();

		String maHuyen = dauNoiNuocCacheModel.maHuyen;

		if ((maHuyen != null) && (maHuyen.length() == 0)) {
			dauNoiNuocCacheModel.maHuyen = null;
		}

		dauNoiNuocCacheModel.maXa = getMaXa();

		String maXa = dauNoiNuocCacheModel.maXa;

		if ((maXa != null) && (maXa.length() == 0)) {
			dauNoiNuocCacheModel.maXa = null;
		}

		dauNoiNuocCacheModel.thonXom = getThonXom();

		String thonXom = dauNoiNuocCacheModel.thonXom;

		if ((thonXom != null) && (thonXom.length() == 0)) {
			dauNoiNuocCacheModel.thonXom = null;
		}

		dauNoiNuocCacheModel.tenChuHo = getTenChuHo();

		String tenChuHo = dauNoiNuocCacheModel.tenChuHo;

		if ((tenChuHo != null) && (tenChuHo.length() == 0)) {
			dauNoiNuocCacheModel.tenChuHo = null;
		}

		dauNoiNuocCacheModel.gioiTinh = getGioiTinh();

		Date ngayDauNoiHopDong = getNgayDauNoiHopDong();

		if (ngayDauNoiHopDong != null) {
			dauNoiNuocCacheModel.ngayDauNoiHopDong = ngayDauNoiHopDong.getTime();
		}
		else {
			dauNoiNuocCacheModel.ngayDauNoiHopDong = Long.MIN_VALUE;
		}

		dauNoiNuocCacheModel.trangThai = getTrangThai();

		dauNoiNuocCacheModel.namBaoCao = getNamBaoCao();

		dauNoiNuocCacheModel.ghiChu = getGhiChu();

		String ghiChu = dauNoiNuocCacheModel.ghiChu;

		if ((ghiChu != null) && (ghiChu.length() == 0)) {
			dauNoiNuocCacheModel.ghiChu = null;
		}

		Date ngayTao = getNgayTao();

		if (ngayTao != null) {
			dauNoiNuocCacheModel.ngayTao = ngayTao.getTime();
		}
		else {
			dauNoiNuocCacheModel.ngayTao = Long.MIN_VALUE;
		}

		dauNoiNuocCacheModel.idNguoiTao = getIdNguoiTao();

		dauNoiNuocCacheModel.soNguoiTrongHo = getSoNguoiTrongHo();

		dauNoiNuocCacheModel.thanhPhanHoGiaDinh = getThanhPhanHoGiaDinh();

		dauNoiNuocCacheModel.tongDoanhThu = getTongDoanhThu();

		dauNoiNuocCacheModel.kinhDo = getKinhDo();

		String kinhDo = dauNoiNuocCacheModel.kinhDo;

		if ((kinhDo != null) && (kinhDo.length() == 0)) {
			dauNoiNuocCacheModel.kinhDo = null;
		}

		dauNoiNuocCacheModel.viDo = getViDo();

		String viDo = dauNoiNuocCacheModel.viDo;

		if ((viDo != null) && (viDo.length() == 0)) {
			dauNoiNuocCacheModel.viDo = null;
		}

		Date ngayDauNoiThucTe = getNgayDauNoiThucTe();

		if (ngayDauNoiThucTe != null) {
			dauNoiNuocCacheModel.ngayDauNoiThucTe = ngayDauNoiThucTe.getTime();
		}
		else {
			dauNoiNuocCacheModel.ngayDauNoiThucTe = Long.MIN_VALUE;
		}

		dauNoiNuocCacheModel.soSeryDongHo = getSoSeryDongHo();

		String soSeryDongHo = dauNoiNuocCacheModel.soSeryDongHo;

		if ((soSeryDongHo != null) && (soSeryDongHo.length() == 0)) {
			dauNoiNuocCacheModel.soSeryDongHo = null;
		}

		dauNoiNuocCacheModel.danhGiaNuocHVS = getDanhGiaNuocHVS();

		String danhGiaNuocHVS = dauNoiNuocCacheModel.danhGiaNuocHVS;

		if ((danhGiaNuocHVS != null) && (danhGiaNuocHVS.length() == 0)) {
			dauNoiNuocCacheModel.danhGiaNuocHVS = null;
		}

		Date ngayKiemDem = getNgayKiemDem();

		if (ngayKiemDem != null) {
			dauNoiNuocCacheModel.ngayKiemDem = ngayKiemDem.getTime();
		}
		else {
			dauNoiNuocCacheModel.ngayKiemDem = Long.MIN_VALUE;
		}

		Date ngayDanhGia = getNgayDanhGia();

		if (ngayDanhGia != null) {
			dauNoiNuocCacheModel.ngayDanhGia = ngayDanhGia.getTime();
		}
		else {
			dauNoiNuocCacheModel.ngayDanhGia = Long.MIN_VALUE;
		}

		dauNoiNuocCacheModel.idNguoiDanhGia = getIdNguoiDanhGia();

		return dauNoiNuocCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", tramCapNuocId=");
		sb.append(getTramCapNuocId());
		sb.append(", maTinh=");
		sb.append(getMaTinh());
		sb.append(", maHuyen=");
		sb.append(getMaHuyen());
		sb.append(", maXa=");
		sb.append(getMaXa());
		sb.append(", thonXom=");
		sb.append(getThonXom());
		sb.append(", tenChuHo=");
		sb.append(getTenChuHo());
		sb.append(", gioiTinh=");
		sb.append(getGioiTinh());
		sb.append(", ngayDauNoiHopDong=");
		sb.append(getNgayDauNoiHopDong());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append(", namBaoCao=");
		sb.append(getNamBaoCao());
		sb.append(", ghiChu=");
		sb.append(getGhiChu());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", idNguoiTao=");
		sb.append(getIdNguoiTao());
		sb.append(", soNguoiTrongHo=");
		sb.append(getSoNguoiTrongHo());
		sb.append(", thanhPhanHoGiaDinh=");
		sb.append(getThanhPhanHoGiaDinh());
		sb.append(", tongDoanhThu=");
		sb.append(getTongDoanhThu());
		sb.append(", kinhDo=");
		sb.append(getKinhDo());
		sb.append(", viDo=");
		sb.append(getViDo());
		sb.append(", ngayDauNoiThucTe=");
		sb.append(getNgayDauNoiThucTe());
		sb.append(", soSeryDongHo=");
		sb.append(getSoSeryDongHo());
		sb.append(", danhGiaNuocHVS=");
		sb.append(getDanhGiaNuocHVS());
		sb.append(", ngayKiemDem=");
		sb.append(getNgayKiemDem());
		sb.append(", ngayDanhGia=");
		sb.append(getNgayDanhGia());
		sb.append(", idNguoiDanhGia=");
		sb.append(getIdNguoiDanhGia());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(79);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.sol.ns.tramcap.dao.model.DauNoiNuoc");
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
			"<column><column-name>maTinh</column-name><column-value><![CDATA[");
		sb.append(getMaTinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maHuyen</column-name><column-value><![CDATA[");
		sb.append(getMaHuyen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maXa</column-name><column-value><![CDATA[");
		sb.append(getMaXa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thonXom</column-name><column-value><![CDATA[");
		sb.append(getThonXom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenChuHo</column-name><column-value><![CDATA[");
		sb.append(getTenChuHo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gioiTinh</column-name><column-value><![CDATA[");
		sb.append(getGioiTinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayDauNoiHopDong</column-name><column-value><![CDATA[");
		sb.append(getNgayDauNoiHopDong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>namBaoCao</column-name><column-value><![CDATA[");
		sb.append(getNamBaoCao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ghiChu</column-name><column-value><![CDATA[");
		sb.append(getGhiChu());
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
			"<column><column-name>soNguoiTrongHo</column-name><column-value><![CDATA[");
		sb.append(getSoNguoiTrongHo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thanhPhanHoGiaDinh</column-name><column-value><![CDATA[");
		sb.append(getThanhPhanHoGiaDinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tongDoanhThu</column-name><column-value><![CDATA[");
		sb.append(getTongDoanhThu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kinhDo</column-name><column-value><![CDATA[");
		sb.append(getKinhDo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viDo</column-name><column-value><![CDATA[");
		sb.append(getViDo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayDauNoiThucTe</column-name><column-value><![CDATA[");
		sb.append(getNgayDauNoiThucTe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soSeryDongHo</column-name><column-value><![CDATA[");
		sb.append(getSoSeryDongHo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>danhGiaNuocHVS</column-name><column-value><![CDATA[");
		sb.append(getDanhGiaNuocHVS());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayKiemDem</column-name><column-value><![CDATA[");
		sb.append(getNgayKiemDem());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayDanhGia</column-name><column-value><![CDATA[");
		sb.append(getNgayDanhGia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idNguoiDanhGia</column-name><column-value><![CDATA[");
		sb.append(getIdNguoiDanhGia());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DauNoiNuoc.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			DauNoiNuoc.class
		};
	private long _id;
	private int _tramCapNuocId;
	private int _originalTramCapNuocId;
	private boolean _setOriginalTramCapNuocId;
	private String _maTinh;
	private String _originalMaTinh;
	private String _maHuyen;
	private String _originalMaHuyen;
	private String _maXa;
	private String _originalMaXa;
	private String _thonXom;
	private String _originalThonXom;
	private String _tenChuHo;
	private String _originalTenChuHo;
	private int _gioiTinh;
	private Date _ngayDauNoiHopDong;
	private int _trangThai;
	private int _namBaoCao;
	private String _ghiChu;
	private Date _ngayTao;
	private int _idNguoiTao;
	private int _originalIdNguoiTao;
	private boolean _setOriginalIdNguoiTao;
	private int _soNguoiTrongHo;
	private int _thanhPhanHoGiaDinh;
	private int _tongDoanhThu;
	private String _kinhDo;
	private String _viDo;
	private Date _ngayDauNoiThucTe;
	private String _soSeryDongHo;
	private String _danhGiaNuocHVS;
	private Date _ngayKiemDem;
	private Date _ngayDanhGia;
	private int _idNguoiDanhGia;
	private int _originalIdNguoiDanhGia;
	private boolean _setOriginalIdNguoiDanhGia;
	private long _columnBitmask;
	private DauNoiNuoc _escapedModel;
}