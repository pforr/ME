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

package vn.dtt.sol.ns.baocaodli.dao.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHop;
import vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHopModel;
import vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHopSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the BaoCaoDLITongHop service. Represents a row in the &quot;ME_TONGHOPDLI&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHopModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BaoCaoDLITongHopImpl}.
 * </p>
 *
 * @author HuyMQ
 * @see BaoCaoDLITongHopImpl
 * @see vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHop
 * @see vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHopModel
 * @generated
 */
@JSON(strict = true)
public class BaoCaoDLITongHopModelImpl extends BaseModelImpl<BaoCaoDLITongHop>
	implements BaoCaoDLITongHopModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a bao cao d l i tong hop model instance should use the {@link vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHop} interface instead.
	 */
	public static final String TABLE_NAME = "ME_TONGHOPDLI";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.BIGINT },
			{ "MATINH", Types.VARCHAR },
			{ "NAM", Types.INTEGER },
			{ "SODAUNOITHEOKEHOACH", Types.INTEGER },
			{ "SODAUNOIMOI", Types.INTEGER },
			{ "SONHATIEUHVSTHEOKEHOACH", Types.INTEGER },
			{ "SONNHATIEUHVSMOI", Types.INTEGER },
			{ "SONGUOIHUONGLOINUOCSACH", Types.INTEGER },
			{ "SOXA", Types.INTEGER },
			{ "TILEHGDCONHATIEU", Types.INTEGER },
			{ "TILEHGDCONHATIEUHVS", Types.INTEGER },
			{ "TILETRUONGHOCHVS", Types.INTEGER },
			{ "TILETRAMYTEHVS", Types.INTEGER },
			{ "SONGUOIHUONGLOIVSTX", Types.INTEGER },
			{ "KEHOACHPHEDUYET", Types.VARCHAR },
			{ "NGAYDUYETKEHOACH", Types.TIMESTAMP },
			{ "BAOCAOCHUONGTRINH", Types.VARCHAR },
			{ "NGAYDANGTAI", Types.TIMESTAMP },
			{ "NGUOILAP", Types.VARCHAR },
			{ "NGUOIDUYET", Types.VARCHAR },
			{ "SOBAOCAO", Types.VARCHAR },
			{ "NGAYBAOCAO", Types.TIMESTAMP },
			{ "TRANGTHAI", Types.INTEGER },
			{ "LUUTRUPDFTH", Types.INTEGER },
			{ "LUUTRUPDF", Types.INTEGER },
			{ "LUUTRUCSV", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table ME_TONGHOPDLI (ID LONG not null primary key,MATINH VARCHAR(75) null,NAM INTEGER,SODAUNOITHEOKEHOACH INTEGER,SODAUNOIMOI INTEGER,SONHATIEUHVSTHEOKEHOACH INTEGER,SONNHATIEUHVSMOI INTEGER,SONGUOIHUONGLOINUOCSACH INTEGER,SOXA INTEGER,TILEHGDCONHATIEU INTEGER,TILEHGDCONHATIEUHVS INTEGER,TILETRUONGHOCHVS INTEGER,TILETRAMYTEHVS INTEGER,SONGUOIHUONGLOIVSTX INTEGER,KEHOACHPHEDUYET VARCHAR(75) null,NGAYDUYETKEHOACH DATE null,BAOCAOCHUONGTRINH VARCHAR(75) null,NGAYDANGTAI DATE null,NGUOILAP VARCHAR(75) null,NGUOIDUYET VARCHAR(75) null,SOBAOCAO VARCHAR(75) null,NGAYBAOCAO DATE null,TRANGTHAI INTEGER,LUUTRUPDFTH INTEGER,LUUTRUPDF INTEGER,LUUTRUCSV INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table ME_TONGHOPDLI";
	public static final String ORDER_BY_JPQL = " ORDER BY baoCaoDLITongHop.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ME_TONGHOPDLI.ID ASC";
	public static final String DATA_SOURCE = "dmDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHop"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHop"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHop"),
			true);
	public static long MATINH_COLUMN_BITMASK = 1L;
	public static long NAM_COLUMN_BITMASK = 2L;
	public static long ID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static BaoCaoDLITongHop toModel(BaoCaoDLITongHopSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		BaoCaoDLITongHop model = new BaoCaoDLITongHopImpl();

		model.setId(soapModel.getId());
		model.setMaTinh(soapModel.getMaTinh());
		model.setNam(soapModel.getNam());
		model.setSoDauNoiTheoKeHoach(soapModel.getSoDauNoiTheoKeHoach());
		model.setSoDauNoiMoi(soapModel.getSoDauNoiMoi());
		model.setSoNhaTieuHVSTheoKH(soapModel.getSoNhaTieuHVSTheoKH());
		model.setSoNhaTieuHVSMoi(soapModel.getSoNhaTieuHVSMoi());
		model.setSoNguoiHuongLoiNuocSach(soapModel.getSoNguoiHuongLoiNuocSach());
		model.setSoXa(soapModel.getSoXa());
		model.setTiLeHGDCoNhaTieu(soapModel.getTiLeHGDCoNhaTieu());
		model.setTiLeHGDCoNhaTieuHVS(soapModel.getTiLeHGDCoNhaTieuHVS());
		model.setTiLeTruongHocHVS(soapModel.getTiLeTruongHocHVS());
		model.setTiLeTramYTeHVS(soapModel.getTiLeTramYTeHVS());
		model.setSoNguoiHuongLoiVSTX(soapModel.getSoNguoiHuongLoiVSTX());
		model.setKeHoachPheDuyet(soapModel.getKeHoachPheDuyet());
		model.setNgayDuyetKeHoach(soapModel.getNgayDuyetKeHoach());
		model.setBaoCaoChuongTrinh(soapModel.getBaoCaoChuongTrinh());
		model.setNgayDangTai(soapModel.getNgayDangTai());
		model.setNguoiLap(soapModel.getNguoiLap());
		model.setNguoiDuyet(soapModel.getNguoiDuyet());
		model.setSoBaoCao(soapModel.getSoBaoCao());
		model.setNgayBaoCao(soapModel.getNgayBaoCao());
		model.setTrangThai(soapModel.getTrangThai());
		model.setLuuTruPdfTH(soapModel.getLuuTruPdfTH());
		model.setLuuTruPdf(soapModel.getLuuTruPdf());
		model.setLuuTruCsv(soapModel.getLuuTruCsv());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<BaoCaoDLITongHop> toModels(
		BaoCaoDLITongHopSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<BaoCaoDLITongHop> models = new ArrayList<BaoCaoDLITongHop>(soapModels.length);

		for (BaoCaoDLITongHopSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHop"));

	public BaoCaoDLITongHopModelImpl() {
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
		return BaoCaoDLITongHop.class;
	}

	@Override
	public String getModelClassName() {
		return BaoCaoDLITongHop.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("maTinh", getMaTinh());
		attributes.put("nam", getNam());
		attributes.put("soDauNoiTheoKeHoach", getSoDauNoiTheoKeHoach());
		attributes.put("soDauNoiMoi", getSoDauNoiMoi());
		attributes.put("soNhaTieuHVSTheoKH", getSoNhaTieuHVSTheoKH());
		attributes.put("soNhaTieuHVSMoi", getSoNhaTieuHVSMoi());
		attributes.put("soNguoiHuongLoiNuocSach", getSoNguoiHuongLoiNuocSach());
		attributes.put("soXa", getSoXa());
		attributes.put("tiLeHGDCoNhaTieu", getTiLeHGDCoNhaTieu());
		attributes.put("tiLeHGDCoNhaTieuHVS", getTiLeHGDCoNhaTieuHVS());
		attributes.put("tiLeTruongHocHVS", getTiLeTruongHocHVS());
		attributes.put("tiLeTramYTeHVS", getTiLeTramYTeHVS());
		attributes.put("soNguoiHuongLoiVSTX", getSoNguoiHuongLoiVSTX());
		attributes.put("keHoachPheDuyet", getKeHoachPheDuyet());
		attributes.put("ngayDuyetKeHoach", getNgayDuyetKeHoach());
		attributes.put("baoCaoChuongTrinh", getBaoCaoChuongTrinh());
		attributes.put("ngayDangTai", getNgayDangTai());
		attributes.put("nguoiLap", getNguoiLap());
		attributes.put("nguoiDuyet", getNguoiDuyet());
		attributes.put("soBaoCao", getSoBaoCao());
		attributes.put("ngayBaoCao", getNgayBaoCao());
		attributes.put("trangThai", getTrangThai());
		attributes.put("luuTruPdfTH", getLuuTruPdfTH());
		attributes.put("luuTruPdf", getLuuTruPdf());
		attributes.put("luuTruCsv", getLuuTruCsv());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String maTinh = (String)attributes.get("maTinh");

		if (maTinh != null) {
			setMaTinh(maTinh);
		}

		Integer nam = (Integer)attributes.get("nam");

		if (nam != null) {
			setNam(nam);
		}

		Integer soDauNoiTheoKeHoach = (Integer)attributes.get(
				"soDauNoiTheoKeHoach");

		if (soDauNoiTheoKeHoach != null) {
			setSoDauNoiTheoKeHoach(soDauNoiTheoKeHoach);
		}

		Integer soDauNoiMoi = (Integer)attributes.get("soDauNoiMoi");

		if (soDauNoiMoi != null) {
			setSoDauNoiMoi(soDauNoiMoi);
		}

		Integer soNhaTieuHVSTheoKH = (Integer)attributes.get(
				"soNhaTieuHVSTheoKH");

		if (soNhaTieuHVSTheoKH != null) {
			setSoNhaTieuHVSTheoKH(soNhaTieuHVSTheoKH);
		}

		Integer soNhaTieuHVSMoi = (Integer)attributes.get("soNhaTieuHVSMoi");

		if (soNhaTieuHVSMoi != null) {
			setSoNhaTieuHVSMoi(soNhaTieuHVSMoi);
		}

		Integer soNguoiHuongLoiNuocSach = (Integer)attributes.get(
				"soNguoiHuongLoiNuocSach");

		if (soNguoiHuongLoiNuocSach != null) {
			setSoNguoiHuongLoiNuocSach(soNguoiHuongLoiNuocSach);
		}

		Integer soXa = (Integer)attributes.get("soXa");

		if (soXa != null) {
			setSoXa(soXa);
		}

		Integer tiLeHGDCoNhaTieu = (Integer)attributes.get("tiLeHGDCoNhaTieu");

		if (tiLeHGDCoNhaTieu != null) {
			setTiLeHGDCoNhaTieu(tiLeHGDCoNhaTieu);
		}

		Integer tiLeHGDCoNhaTieuHVS = (Integer)attributes.get(
				"tiLeHGDCoNhaTieuHVS");

		if (tiLeHGDCoNhaTieuHVS != null) {
			setTiLeHGDCoNhaTieuHVS(tiLeHGDCoNhaTieuHVS);
		}

		Integer tiLeTruongHocHVS = (Integer)attributes.get("tiLeTruongHocHVS");

		if (tiLeTruongHocHVS != null) {
			setTiLeTruongHocHVS(tiLeTruongHocHVS);
		}

		Integer tiLeTramYTeHVS = (Integer)attributes.get("tiLeTramYTeHVS");

		if (tiLeTramYTeHVS != null) {
			setTiLeTramYTeHVS(tiLeTramYTeHVS);
		}

		Integer soNguoiHuongLoiVSTX = (Integer)attributes.get(
				"soNguoiHuongLoiVSTX");

		if (soNguoiHuongLoiVSTX != null) {
			setSoNguoiHuongLoiVSTX(soNguoiHuongLoiVSTX);
		}

		String keHoachPheDuyet = (String)attributes.get("keHoachPheDuyet");

		if (keHoachPheDuyet != null) {
			setKeHoachPheDuyet(keHoachPheDuyet);
		}

		Date ngayDuyetKeHoach = (Date)attributes.get("ngayDuyetKeHoach");

		if (ngayDuyetKeHoach != null) {
			setNgayDuyetKeHoach(ngayDuyetKeHoach);
		}

		String baoCaoChuongTrinh = (String)attributes.get("baoCaoChuongTrinh");

		if (baoCaoChuongTrinh != null) {
			setBaoCaoChuongTrinh(baoCaoChuongTrinh);
		}

		Date ngayDangTai = (Date)attributes.get("ngayDangTai");

		if (ngayDangTai != null) {
			setNgayDangTai(ngayDangTai);
		}

		String nguoiLap = (String)attributes.get("nguoiLap");

		if (nguoiLap != null) {
			setNguoiLap(nguoiLap);
		}

		String nguoiDuyet = (String)attributes.get("nguoiDuyet");

		if (nguoiDuyet != null) {
			setNguoiDuyet(nguoiDuyet);
		}

		String soBaoCao = (String)attributes.get("soBaoCao");

		if (soBaoCao != null) {
			setSoBaoCao(soBaoCao);
		}

		Date ngayBaoCao = (Date)attributes.get("ngayBaoCao");

		if (ngayBaoCao != null) {
			setNgayBaoCao(ngayBaoCao);
		}

		Integer trangThai = (Integer)attributes.get("trangThai");

		if (trangThai != null) {
			setTrangThai(trangThai);
		}

		Integer luuTruPdfTH = (Integer)attributes.get("luuTruPdfTH");

		if (luuTruPdfTH != null) {
			setLuuTruPdfTH(luuTruPdfTH);
		}

		Integer luuTruPdf = (Integer)attributes.get("luuTruPdf");

		if (luuTruPdf != null) {
			setLuuTruPdf(luuTruPdf);
		}

		Integer luuTruCsv = (Integer)attributes.get("luuTruCsv");

		if (luuTruCsv != null) {
			setLuuTruCsv(luuTruCsv);
		}
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@JSON
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
		_columnBitmask |= MATINH_COLUMN_BITMASK;

		if (_originalMaTinh == null) {
			_originalMaTinh = _maTinh;
		}

		_maTinh = maTinh;
	}

	public String getOriginalMaTinh() {
		return GetterUtil.getString(_originalMaTinh);
	}

	@JSON
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

	@JSON
	@Override
	public int getSoDauNoiTheoKeHoach() {
		return _soDauNoiTheoKeHoach;
	}

	@Override
	public void setSoDauNoiTheoKeHoach(int soDauNoiTheoKeHoach) {
		_soDauNoiTheoKeHoach = soDauNoiTheoKeHoach;
	}

	@JSON
	@Override
	public int getSoDauNoiMoi() {
		return _soDauNoiMoi;
	}

	@Override
	public void setSoDauNoiMoi(int soDauNoiMoi) {
		_soDauNoiMoi = soDauNoiMoi;
	}

	@JSON
	@Override
	public int getSoNhaTieuHVSTheoKH() {
		return _soNhaTieuHVSTheoKH;
	}

	@Override
	public void setSoNhaTieuHVSTheoKH(int soNhaTieuHVSTheoKH) {
		_soNhaTieuHVSTheoKH = soNhaTieuHVSTheoKH;
	}

	@JSON
	@Override
	public int getSoNhaTieuHVSMoi() {
		return _soNhaTieuHVSMoi;
	}

	@Override
	public void setSoNhaTieuHVSMoi(int soNhaTieuHVSMoi) {
		_soNhaTieuHVSMoi = soNhaTieuHVSMoi;
	}

	@JSON
	@Override
	public int getSoNguoiHuongLoiNuocSach() {
		return _soNguoiHuongLoiNuocSach;
	}

	@Override
	public void setSoNguoiHuongLoiNuocSach(int soNguoiHuongLoiNuocSach) {
		_soNguoiHuongLoiNuocSach = soNguoiHuongLoiNuocSach;
	}

	@JSON
	@Override
	public int getSoXa() {
		return _soXa;
	}

	@Override
	public void setSoXa(int soXa) {
		_soXa = soXa;
	}

	@JSON
	@Override
	public int getTiLeHGDCoNhaTieu() {
		return _tiLeHGDCoNhaTieu;
	}

	@Override
	public void setTiLeHGDCoNhaTieu(int tiLeHGDCoNhaTieu) {
		_tiLeHGDCoNhaTieu = tiLeHGDCoNhaTieu;
	}

	@JSON
	@Override
	public int getTiLeHGDCoNhaTieuHVS() {
		return _tiLeHGDCoNhaTieuHVS;
	}

	@Override
	public void setTiLeHGDCoNhaTieuHVS(int tiLeHGDCoNhaTieuHVS) {
		_tiLeHGDCoNhaTieuHVS = tiLeHGDCoNhaTieuHVS;
	}

	@JSON
	@Override
	public int getTiLeTruongHocHVS() {
		return _tiLeTruongHocHVS;
	}

	@Override
	public void setTiLeTruongHocHVS(int tiLeTruongHocHVS) {
		_tiLeTruongHocHVS = tiLeTruongHocHVS;
	}

	@JSON
	@Override
	public int getTiLeTramYTeHVS() {
		return _tiLeTramYTeHVS;
	}

	@Override
	public void setTiLeTramYTeHVS(int tiLeTramYTeHVS) {
		_tiLeTramYTeHVS = tiLeTramYTeHVS;
	}

	@JSON
	@Override
	public int getSoNguoiHuongLoiVSTX() {
		return _soNguoiHuongLoiVSTX;
	}

	@Override
	public void setSoNguoiHuongLoiVSTX(int soNguoiHuongLoiVSTX) {
		_soNguoiHuongLoiVSTX = soNguoiHuongLoiVSTX;
	}

	@JSON
	@Override
	public String getKeHoachPheDuyet() {
		if (_keHoachPheDuyet == null) {
			return StringPool.BLANK;
		}
		else {
			return _keHoachPheDuyet;
		}
	}

	@Override
	public void setKeHoachPheDuyet(String keHoachPheDuyet) {
		_keHoachPheDuyet = keHoachPheDuyet;
	}

	@JSON
	@Override
	public Date getNgayDuyetKeHoach() {
		return _ngayDuyetKeHoach;
	}

	@Override
	public void setNgayDuyetKeHoach(Date ngayDuyetKeHoach) {
		_ngayDuyetKeHoach = ngayDuyetKeHoach;
	}

	@JSON
	@Override
	public String getBaoCaoChuongTrinh() {
		if (_baoCaoChuongTrinh == null) {
			return StringPool.BLANK;
		}
		else {
			return _baoCaoChuongTrinh;
		}
	}

	@Override
	public void setBaoCaoChuongTrinh(String baoCaoChuongTrinh) {
		_baoCaoChuongTrinh = baoCaoChuongTrinh;
	}

	@JSON
	@Override
	public Date getNgayDangTai() {
		return _ngayDangTai;
	}

	@Override
	public void setNgayDangTai(Date ngayDangTai) {
		_ngayDangTai = ngayDangTai;
	}

	@JSON
	@Override
	public String getNguoiLap() {
		if (_nguoiLap == null) {
			return StringPool.BLANK;
		}
		else {
			return _nguoiLap;
		}
	}

	@Override
	public void setNguoiLap(String nguoiLap) {
		_nguoiLap = nguoiLap;
	}

	@JSON
	@Override
	public String getNguoiDuyet() {
		if (_nguoiDuyet == null) {
			return StringPool.BLANK;
		}
		else {
			return _nguoiDuyet;
		}
	}

	@Override
	public void setNguoiDuyet(String nguoiDuyet) {
		_nguoiDuyet = nguoiDuyet;
	}

	@JSON
	@Override
	public String getSoBaoCao() {
		if (_soBaoCao == null) {
			return StringPool.BLANK;
		}
		else {
			return _soBaoCao;
		}
	}

	@Override
	public void setSoBaoCao(String soBaoCao) {
		_soBaoCao = soBaoCao;
	}

	@JSON
	@Override
	public Date getNgayBaoCao() {
		return _ngayBaoCao;
	}

	@Override
	public void setNgayBaoCao(Date ngayBaoCao) {
		_ngayBaoCao = ngayBaoCao;
	}

	@JSON
	@Override
	public int getTrangThai() {
		return _trangThai;
	}

	@Override
	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	@JSON
	@Override
	public int getLuuTruPdfTH() {
		return _luuTruPdfTH;
	}

	@Override
	public void setLuuTruPdfTH(int luuTruPdfTH) {
		_luuTruPdfTH = luuTruPdfTH;
	}

	@JSON
	@Override
	public int getLuuTruPdf() {
		return _luuTruPdf;
	}

	@Override
	public void setLuuTruPdf(int luuTruPdf) {
		_luuTruPdf = luuTruPdf;
	}

	@JSON
	@Override
	public int getLuuTruCsv() {
		return _luuTruCsv;
	}

	@Override
	public void setLuuTruCsv(int luuTruCsv) {
		_luuTruCsv = luuTruCsv;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			BaoCaoDLITongHop.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BaoCaoDLITongHop toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (BaoCaoDLITongHop)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BaoCaoDLITongHopImpl baoCaoDLITongHopImpl = new BaoCaoDLITongHopImpl();

		baoCaoDLITongHopImpl.setId(getId());
		baoCaoDLITongHopImpl.setMaTinh(getMaTinh());
		baoCaoDLITongHopImpl.setNam(getNam());
		baoCaoDLITongHopImpl.setSoDauNoiTheoKeHoach(getSoDauNoiTheoKeHoach());
		baoCaoDLITongHopImpl.setSoDauNoiMoi(getSoDauNoiMoi());
		baoCaoDLITongHopImpl.setSoNhaTieuHVSTheoKH(getSoNhaTieuHVSTheoKH());
		baoCaoDLITongHopImpl.setSoNhaTieuHVSMoi(getSoNhaTieuHVSMoi());
		baoCaoDLITongHopImpl.setSoNguoiHuongLoiNuocSach(getSoNguoiHuongLoiNuocSach());
		baoCaoDLITongHopImpl.setSoXa(getSoXa());
		baoCaoDLITongHopImpl.setTiLeHGDCoNhaTieu(getTiLeHGDCoNhaTieu());
		baoCaoDLITongHopImpl.setTiLeHGDCoNhaTieuHVS(getTiLeHGDCoNhaTieuHVS());
		baoCaoDLITongHopImpl.setTiLeTruongHocHVS(getTiLeTruongHocHVS());
		baoCaoDLITongHopImpl.setTiLeTramYTeHVS(getTiLeTramYTeHVS());
		baoCaoDLITongHopImpl.setSoNguoiHuongLoiVSTX(getSoNguoiHuongLoiVSTX());
		baoCaoDLITongHopImpl.setKeHoachPheDuyet(getKeHoachPheDuyet());
		baoCaoDLITongHopImpl.setNgayDuyetKeHoach(getNgayDuyetKeHoach());
		baoCaoDLITongHopImpl.setBaoCaoChuongTrinh(getBaoCaoChuongTrinh());
		baoCaoDLITongHopImpl.setNgayDangTai(getNgayDangTai());
		baoCaoDLITongHopImpl.setNguoiLap(getNguoiLap());
		baoCaoDLITongHopImpl.setNguoiDuyet(getNguoiDuyet());
		baoCaoDLITongHopImpl.setSoBaoCao(getSoBaoCao());
		baoCaoDLITongHopImpl.setNgayBaoCao(getNgayBaoCao());
		baoCaoDLITongHopImpl.setTrangThai(getTrangThai());
		baoCaoDLITongHopImpl.setLuuTruPdfTH(getLuuTruPdfTH());
		baoCaoDLITongHopImpl.setLuuTruPdf(getLuuTruPdf());
		baoCaoDLITongHopImpl.setLuuTruCsv(getLuuTruCsv());

		baoCaoDLITongHopImpl.resetOriginalValues();

		return baoCaoDLITongHopImpl;
	}

	@Override
	public int compareTo(BaoCaoDLITongHop baoCaoDLITongHop) {
		long primaryKey = baoCaoDLITongHop.getPrimaryKey();

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

		if (!(obj instanceof BaoCaoDLITongHop)) {
			return false;
		}

		BaoCaoDLITongHop baoCaoDLITongHop = (BaoCaoDLITongHop)obj;

		long primaryKey = baoCaoDLITongHop.getPrimaryKey();

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
		BaoCaoDLITongHopModelImpl baoCaoDLITongHopModelImpl = this;

		baoCaoDLITongHopModelImpl._originalMaTinh = baoCaoDLITongHopModelImpl._maTinh;

		baoCaoDLITongHopModelImpl._originalNam = baoCaoDLITongHopModelImpl._nam;

		baoCaoDLITongHopModelImpl._setOriginalNam = false;

		baoCaoDLITongHopModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<BaoCaoDLITongHop> toCacheModel() {
		BaoCaoDLITongHopCacheModel baoCaoDLITongHopCacheModel = new BaoCaoDLITongHopCacheModel();

		baoCaoDLITongHopCacheModel.id = getId();

		baoCaoDLITongHopCacheModel.maTinh = getMaTinh();

		String maTinh = baoCaoDLITongHopCacheModel.maTinh;

		if ((maTinh != null) && (maTinh.length() == 0)) {
			baoCaoDLITongHopCacheModel.maTinh = null;
		}

		baoCaoDLITongHopCacheModel.nam = getNam();

		baoCaoDLITongHopCacheModel.soDauNoiTheoKeHoach = getSoDauNoiTheoKeHoach();

		baoCaoDLITongHopCacheModel.soDauNoiMoi = getSoDauNoiMoi();

		baoCaoDLITongHopCacheModel.soNhaTieuHVSTheoKH = getSoNhaTieuHVSTheoKH();

		baoCaoDLITongHopCacheModel.soNhaTieuHVSMoi = getSoNhaTieuHVSMoi();

		baoCaoDLITongHopCacheModel.soNguoiHuongLoiNuocSach = getSoNguoiHuongLoiNuocSach();

		baoCaoDLITongHopCacheModel.soXa = getSoXa();

		baoCaoDLITongHopCacheModel.tiLeHGDCoNhaTieu = getTiLeHGDCoNhaTieu();

		baoCaoDLITongHopCacheModel.tiLeHGDCoNhaTieuHVS = getTiLeHGDCoNhaTieuHVS();

		baoCaoDLITongHopCacheModel.tiLeTruongHocHVS = getTiLeTruongHocHVS();

		baoCaoDLITongHopCacheModel.tiLeTramYTeHVS = getTiLeTramYTeHVS();

		baoCaoDLITongHopCacheModel.soNguoiHuongLoiVSTX = getSoNguoiHuongLoiVSTX();

		baoCaoDLITongHopCacheModel.keHoachPheDuyet = getKeHoachPheDuyet();

		String keHoachPheDuyet = baoCaoDLITongHopCacheModel.keHoachPheDuyet;

		if ((keHoachPheDuyet != null) && (keHoachPheDuyet.length() == 0)) {
			baoCaoDLITongHopCacheModel.keHoachPheDuyet = null;
		}

		Date ngayDuyetKeHoach = getNgayDuyetKeHoach();

		if (ngayDuyetKeHoach != null) {
			baoCaoDLITongHopCacheModel.ngayDuyetKeHoach = ngayDuyetKeHoach.getTime();
		}
		else {
			baoCaoDLITongHopCacheModel.ngayDuyetKeHoach = Long.MIN_VALUE;
		}

		baoCaoDLITongHopCacheModel.baoCaoChuongTrinh = getBaoCaoChuongTrinh();

		String baoCaoChuongTrinh = baoCaoDLITongHopCacheModel.baoCaoChuongTrinh;

		if ((baoCaoChuongTrinh != null) && (baoCaoChuongTrinh.length() == 0)) {
			baoCaoDLITongHopCacheModel.baoCaoChuongTrinh = null;
		}

		Date ngayDangTai = getNgayDangTai();

		if (ngayDangTai != null) {
			baoCaoDLITongHopCacheModel.ngayDangTai = ngayDangTai.getTime();
		}
		else {
			baoCaoDLITongHopCacheModel.ngayDangTai = Long.MIN_VALUE;
		}

		baoCaoDLITongHopCacheModel.nguoiLap = getNguoiLap();

		String nguoiLap = baoCaoDLITongHopCacheModel.nguoiLap;

		if ((nguoiLap != null) && (nguoiLap.length() == 0)) {
			baoCaoDLITongHopCacheModel.nguoiLap = null;
		}

		baoCaoDLITongHopCacheModel.nguoiDuyet = getNguoiDuyet();

		String nguoiDuyet = baoCaoDLITongHopCacheModel.nguoiDuyet;

		if ((nguoiDuyet != null) && (nguoiDuyet.length() == 0)) {
			baoCaoDLITongHopCacheModel.nguoiDuyet = null;
		}

		baoCaoDLITongHopCacheModel.soBaoCao = getSoBaoCao();

		String soBaoCao = baoCaoDLITongHopCacheModel.soBaoCao;

		if ((soBaoCao != null) && (soBaoCao.length() == 0)) {
			baoCaoDLITongHopCacheModel.soBaoCao = null;
		}

		Date ngayBaoCao = getNgayBaoCao();

		if (ngayBaoCao != null) {
			baoCaoDLITongHopCacheModel.ngayBaoCao = ngayBaoCao.getTime();
		}
		else {
			baoCaoDLITongHopCacheModel.ngayBaoCao = Long.MIN_VALUE;
		}

		baoCaoDLITongHopCacheModel.trangThai = getTrangThai();

		baoCaoDLITongHopCacheModel.luuTruPdfTH = getLuuTruPdfTH();

		baoCaoDLITongHopCacheModel.luuTruPdf = getLuuTruPdf();

		baoCaoDLITongHopCacheModel.luuTruCsv = getLuuTruCsv();

		return baoCaoDLITongHopCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", maTinh=");
		sb.append(getMaTinh());
		sb.append(", nam=");
		sb.append(getNam());
		sb.append(", soDauNoiTheoKeHoach=");
		sb.append(getSoDauNoiTheoKeHoach());
		sb.append(", soDauNoiMoi=");
		sb.append(getSoDauNoiMoi());
		sb.append(", soNhaTieuHVSTheoKH=");
		sb.append(getSoNhaTieuHVSTheoKH());
		sb.append(", soNhaTieuHVSMoi=");
		sb.append(getSoNhaTieuHVSMoi());
		sb.append(", soNguoiHuongLoiNuocSach=");
		sb.append(getSoNguoiHuongLoiNuocSach());
		sb.append(", soXa=");
		sb.append(getSoXa());
		sb.append(", tiLeHGDCoNhaTieu=");
		sb.append(getTiLeHGDCoNhaTieu());
		sb.append(", tiLeHGDCoNhaTieuHVS=");
		sb.append(getTiLeHGDCoNhaTieuHVS());
		sb.append(", tiLeTruongHocHVS=");
		sb.append(getTiLeTruongHocHVS());
		sb.append(", tiLeTramYTeHVS=");
		sb.append(getTiLeTramYTeHVS());
		sb.append(", soNguoiHuongLoiVSTX=");
		sb.append(getSoNguoiHuongLoiVSTX());
		sb.append(", keHoachPheDuyet=");
		sb.append(getKeHoachPheDuyet());
		sb.append(", ngayDuyetKeHoach=");
		sb.append(getNgayDuyetKeHoach());
		sb.append(", baoCaoChuongTrinh=");
		sb.append(getBaoCaoChuongTrinh());
		sb.append(", ngayDangTai=");
		sb.append(getNgayDangTai());
		sb.append(", nguoiLap=");
		sb.append(getNguoiLap());
		sb.append(", nguoiDuyet=");
		sb.append(getNguoiDuyet());
		sb.append(", soBaoCao=");
		sb.append(getSoBaoCao());
		sb.append(", ngayBaoCao=");
		sb.append(getNgayBaoCao());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append(", luuTruPdfTH=");
		sb.append(getLuuTruPdfTH());
		sb.append(", luuTruPdf=");
		sb.append(getLuuTruPdf());
		sb.append(", luuTruCsv=");
		sb.append(getLuuTruCsv());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(82);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHop");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maTinh</column-name><column-value><![CDATA[");
		sb.append(getMaTinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nam</column-name><column-value><![CDATA[");
		sb.append(getNam());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soDauNoiTheoKeHoach</column-name><column-value><![CDATA[");
		sb.append(getSoDauNoiTheoKeHoach());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soDauNoiMoi</column-name><column-value><![CDATA[");
		sb.append(getSoDauNoiMoi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soNhaTieuHVSTheoKH</column-name><column-value><![CDATA[");
		sb.append(getSoNhaTieuHVSTheoKH());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soNhaTieuHVSMoi</column-name><column-value><![CDATA[");
		sb.append(getSoNhaTieuHVSMoi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soNguoiHuongLoiNuocSach</column-name><column-value><![CDATA[");
		sb.append(getSoNguoiHuongLoiNuocSach());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soXa</column-name><column-value><![CDATA[");
		sb.append(getSoXa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tiLeHGDCoNhaTieu</column-name><column-value><![CDATA[");
		sb.append(getTiLeHGDCoNhaTieu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tiLeHGDCoNhaTieuHVS</column-name><column-value><![CDATA[");
		sb.append(getTiLeHGDCoNhaTieuHVS());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tiLeTruongHocHVS</column-name><column-value><![CDATA[");
		sb.append(getTiLeTruongHocHVS());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tiLeTramYTeHVS</column-name><column-value><![CDATA[");
		sb.append(getTiLeTramYTeHVS());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soNguoiHuongLoiVSTX</column-name><column-value><![CDATA[");
		sb.append(getSoNguoiHuongLoiVSTX());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>keHoachPheDuyet</column-name><column-value><![CDATA[");
		sb.append(getKeHoachPheDuyet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayDuyetKeHoach</column-name><column-value><![CDATA[");
		sb.append(getNgayDuyetKeHoach());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>baoCaoChuongTrinh</column-name><column-value><![CDATA[");
		sb.append(getBaoCaoChuongTrinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayDangTai</column-name><column-value><![CDATA[");
		sb.append(getNgayDangTai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiLap</column-name><column-value><![CDATA[");
		sb.append(getNguoiLap());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiDuyet</column-name><column-value><![CDATA[");
		sb.append(getNguoiDuyet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soBaoCao</column-name><column-value><![CDATA[");
		sb.append(getSoBaoCao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayBaoCao</column-name><column-value><![CDATA[");
		sb.append(getNgayBaoCao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>luuTruPdfTH</column-name><column-value><![CDATA[");
		sb.append(getLuuTruPdfTH());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>luuTruPdf</column-name><column-value><![CDATA[");
		sb.append(getLuuTruPdf());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>luuTruCsv</column-name><column-value><![CDATA[");
		sb.append(getLuuTruCsv());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = BaoCaoDLITongHop.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			BaoCaoDLITongHop.class
		};
	private long _id;
	private String _maTinh;
	private String _originalMaTinh;
	private int _nam;
	private int _originalNam;
	private boolean _setOriginalNam;
	private int _soDauNoiTheoKeHoach;
	private int _soDauNoiMoi;
	private int _soNhaTieuHVSTheoKH;
	private int _soNhaTieuHVSMoi;
	private int _soNguoiHuongLoiNuocSach;
	private int _soXa;
	private int _tiLeHGDCoNhaTieu;
	private int _tiLeHGDCoNhaTieuHVS;
	private int _tiLeTruongHocHVS;
	private int _tiLeTramYTeHVS;
	private int _soNguoiHuongLoiVSTX;
	private String _keHoachPheDuyet;
	private Date _ngayDuyetKeHoach;
	private String _baoCaoChuongTrinh;
	private Date _ngayDangTai;
	private String _nguoiLap;
	private String _nguoiDuyet;
	private String _soBaoCao;
	private Date _ngayBaoCao;
	private int _trangThai;
	private int _luuTruPdfTH;
	private int _luuTruPdf;
	private int _luuTruCsv;
	private long _columnBitmask;
	private BaoCaoDLITongHop _escapedModel;
}