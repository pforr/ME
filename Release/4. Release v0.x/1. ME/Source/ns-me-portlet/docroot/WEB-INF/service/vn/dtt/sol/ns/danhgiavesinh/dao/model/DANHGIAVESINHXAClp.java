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

package vn.dtt.sol.ns.danhgiavesinh.dao.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import vn.dtt.sol.ns.danhgiavesinh.dao.service.ClpSerializer;
import vn.dtt.sol.ns.danhgiavesinh.dao.service.DANHGIAVESINHXALocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author khoa.vu
 */
public class DANHGIAVESINHXAClp extends BaseModelImpl<DANHGIAVESINHXA>
	implements DANHGIAVESINHXA {
	public DANHGIAVESINHXAClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DANHGIAVESINHXA.class;
	}

	@Override
	public String getModelClassName() {
		return DANHGIAVESINHXA.class.getName();
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("maXa", getMaXa());
		attributes.put("maTinh", getMaTinh());
		attributes.put("maHuyen", getMaHuyen());
		attributes.put("nam", getNam());
		attributes.put("soDan", getSoDan());
		attributes.put("tiLeHGDCoNhaTieu", getTiLeHGDCoNhaTieu());
		attributes.put("tiLeHGDCoNhaTieuHVS", getTiLeHGDCoNhaTieuHVS());
		attributes.put("tiLeTruongHocHVS", getTiLeTruongHocHVS());
		attributes.put("tiLeTramYTeHVS", getTiLeTramYTeHVS());
		attributes.put("ketLuanVSTX", getKetLuanVSTX());
		attributes.put("ghiChu", getGhiChu());
		attributes.put("baoCaoDLI", getBaoCaoDLI());
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

		String maXa = (String)attributes.get("maXa");

		if (maXa != null) {
			setMaXa(maXa);
		}

		String maTinh = (String)attributes.get("maTinh");

		if (maTinh != null) {
			setMaTinh(maTinh);
		}

		String maHuyen = (String)attributes.get("maHuyen");

		if (maHuyen != null) {
			setMaHuyen(maHuyen);
		}

		Integer nam = (Integer)attributes.get("nam");

		if (nam != null) {
			setNam(nam);
		}

		Integer soDan = (Integer)attributes.get("soDan");

		if (soDan != null) {
			setSoDan(soDan);
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

		Integer ketLuanVSTX = (Integer)attributes.get("ketLuanVSTX");

		if (ketLuanVSTX != null) {
			setKetLuanVSTX(ketLuanVSTX);
		}

		Long ghiChu = (Long)attributes.get("ghiChu");

		if (ghiChu != null) {
			setGhiChu(ghiChu);
		}

		Integer baoCaoDLI = (Integer)attributes.get("baoCaoDLI");

		if (baoCaoDLI != null) {
			setBaoCaoDLI(baoCaoDLI);
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
		_id = id;

		if (_danhgiavesinhxaRemoteModel != null) {
			try {
				Class<?> clazz = _danhgiavesinhxaRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_danhgiavesinhxaRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaXa() {
		return _maXa;
	}

	@Override
	public void setMaXa(String maXa) {
		_maXa = maXa;

		if (_danhgiavesinhxaRemoteModel != null) {
			try {
				Class<?> clazz = _danhgiavesinhxaRemoteModel.getClass();

				Method method = clazz.getMethod("setMaXa", String.class);

				method.invoke(_danhgiavesinhxaRemoteModel, maXa);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaTinh() {
		return _maTinh;
	}

	@Override
	public void setMaTinh(String maTinh) {
		_maTinh = maTinh;

		if (_danhgiavesinhxaRemoteModel != null) {
			try {
				Class<?> clazz = _danhgiavesinhxaRemoteModel.getClass();

				Method method = clazz.getMethod("setMaTinh", String.class);

				method.invoke(_danhgiavesinhxaRemoteModel, maTinh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaHuyen() {
		return _maHuyen;
	}

	@Override
	public void setMaHuyen(String maHuyen) {
		_maHuyen = maHuyen;

		if (_danhgiavesinhxaRemoteModel != null) {
			try {
				Class<?> clazz = _danhgiavesinhxaRemoteModel.getClass();

				Method method = clazz.getMethod("setMaHuyen", String.class);

				method.invoke(_danhgiavesinhxaRemoteModel, maHuyen);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNam() {
		return _nam;
	}

	@Override
	public void setNam(int nam) {
		_nam = nam;

		if (_danhgiavesinhxaRemoteModel != null) {
			try {
				Class<?> clazz = _danhgiavesinhxaRemoteModel.getClass();

				Method method = clazz.getMethod("setNam", int.class);

				method.invoke(_danhgiavesinhxaRemoteModel, nam);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSoDan() {
		return _soDan;
	}

	@Override
	public void setSoDan(int soDan) {
		_soDan = soDan;

		if (_danhgiavesinhxaRemoteModel != null) {
			try {
				Class<?> clazz = _danhgiavesinhxaRemoteModel.getClass();

				Method method = clazz.getMethod("setSoDan", int.class);

				method.invoke(_danhgiavesinhxaRemoteModel, soDan);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTiLeHGDCoNhaTieu() {
		return _tiLeHGDCoNhaTieu;
	}

	@Override
	public void setTiLeHGDCoNhaTieu(int tiLeHGDCoNhaTieu) {
		_tiLeHGDCoNhaTieu = tiLeHGDCoNhaTieu;

		if (_danhgiavesinhxaRemoteModel != null) {
			try {
				Class<?> clazz = _danhgiavesinhxaRemoteModel.getClass();

				Method method = clazz.getMethod("setTiLeHGDCoNhaTieu", int.class);

				method.invoke(_danhgiavesinhxaRemoteModel, tiLeHGDCoNhaTieu);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTiLeHGDCoNhaTieuHVS() {
		return _tiLeHGDCoNhaTieuHVS;
	}

	@Override
	public void setTiLeHGDCoNhaTieuHVS(int tiLeHGDCoNhaTieuHVS) {
		_tiLeHGDCoNhaTieuHVS = tiLeHGDCoNhaTieuHVS;

		if (_danhgiavesinhxaRemoteModel != null) {
			try {
				Class<?> clazz = _danhgiavesinhxaRemoteModel.getClass();

				Method method = clazz.getMethod("setTiLeHGDCoNhaTieuHVS",
						int.class);

				method.invoke(_danhgiavesinhxaRemoteModel, tiLeHGDCoNhaTieuHVS);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTiLeTruongHocHVS() {
		return _tiLeTruongHocHVS;
	}

	@Override
	public void setTiLeTruongHocHVS(int tiLeTruongHocHVS) {
		_tiLeTruongHocHVS = tiLeTruongHocHVS;

		if (_danhgiavesinhxaRemoteModel != null) {
			try {
				Class<?> clazz = _danhgiavesinhxaRemoteModel.getClass();

				Method method = clazz.getMethod("setTiLeTruongHocHVS", int.class);

				method.invoke(_danhgiavesinhxaRemoteModel, tiLeTruongHocHVS);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTiLeTramYTeHVS() {
		return _tiLeTramYTeHVS;
	}

	@Override
	public void setTiLeTramYTeHVS(int tiLeTramYTeHVS) {
		_tiLeTramYTeHVS = tiLeTramYTeHVS;

		if (_danhgiavesinhxaRemoteModel != null) {
			try {
				Class<?> clazz = _danhgiavesinhxaRemoteModel.getClass();

				Method method = clazz.getMethod("setTiLeTramYTeHVS", int.class);

				method.invoke(_danhgiavesinhxaRemoteModel, tiLeTramYTeHVS);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getKetLuanVSTX() {
		return _ketLuanVSTX;
	}

	@Override
	public void setKetLuanVSTX(int ketLuanVSTX) {
		_ketLuanVSTX = ketLuanVSTX;

		if (_danhgiavesinhxaRemoteModel != null) {
			try {
				Class<?> clazz = _danhgiavesinhxaRemoteModel.getClass();

				Method method = clazz.getMethod("setKetLuanVSTX", int.class);

				method.invoke(_danhgiavesinhxaRemoteModel, ketLuanVSTX);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGhiChu() {
		return _ghiChu;
	}

	@Override
	public void setGhiChu(long ghiChu) {
		_ghiChu = ghiChu;

		if (_danhgiavesinhxaRemoteModel != null) {
			try {
				Class<?> clazz = _danhgiavesinhxaRemoteModel.getClass();

				Method method = clazz.getMethod("setGhiChu", long.class);

				method.invoke(_danhgiavesinhxaRemoteModel, ghiChu);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getBaoCaoDLI() {
		return _baoCaoDLI;
	}

	@Override
	public void setBaoCaoDLI(int baoCaoDLI) {
		_baoCaoDLI = baoCaoDLI;

		if (_danhgiavesinhxaRemoteModel != null) {
			try {
				Class<?> clazz = _danhgiavesinhxaRemoteModel.getClass();

				Method method = clazz.getMethod("setBaoCaoDLI", int.class);

				method.invoke(_danhgiavesinhxaRemoteModel, baoCaoDLI);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getNgayTao() {
		return _ngayTao;
	}

	@Override
	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;

		if (_danhgiavesinhxaRemoteModel != null) {
			try {
				Class<?> clazz = _danhgiavesinhxaRemoteModel.getClass();

				Method method = clazz.getMethod("setNgayTao", Date.class);

				method.invoke(_danhgiavesinhxaRemoteModel, ngayTao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdNguoiTao() {
		return _idNguoiTao;
	}

	@Override
	public void setIdNguoiTao(long idNguoiTao) {
		_idNguoiTao = idNguoiTao;

		if (_danhgiavesinhxaRemoteModel != null) {
			try {
				Class<?> clazz = _danhgiavesinhxaRemoteModel.getClass();

				Method method = clazz.getMethod("setIdNguoiTao", long.class);

				method.invoke(_danhgiavesinhxaRemoteModel, idNguoiTao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDANHGIAVESINHXARemoteModel() {
		return _danhgiavesinhxaRemoteModel;
	}

	public void setDANHGIAVESINHXARemoteModel(
		BaseModel<?> danhgiavesinhxaRemoteModel) {
		_danhgiavesinhxaRemoteModel = danhgiavesinhxaRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _danhgiavesinhxaRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_danhgiavesinhxaRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DANHGIAVESINHXALocalServiceUtil.addDANHGIAVESINHXA(this);
		}
		else {
			DANHGIAVESINHXALocalServiceUtil.updateDANHGIAVESINHXA(this);
		}
	}

	@Override
	public DANHGIAVESINHXA toEscapedModel() {
		return (DANHGIAVESINHXA)ProxyUtil.newProxyInstance(DANHGIAVESINHXA.class.getClassLoader(),
			new Class[] { DANHGIAVESINHXA.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DANHGIAVESINHXAClp clone = new DANHGIAVESINHXAClp();

		clone.setId(getId());
		clone.setMaXa(getMaXa());
		clone.setMaTinh(getMaTinh());
		clone.setMaHuyen(getMaHuyen());
		clone.setNam(getNam());
		clone.setSoDan(getSoDan());
		clone.setTiLeHGDCoNhaTieu(getTiLeHGDCoNhaTieu());
		clone.setTiLeHGDCoNhaTieuHVS(getTiLeHGDCoNhaTieuHVS());
		clone.setTiLeTruongHocHVS(getTiLeTruongHocHVS());
		clone.setTiLeTramYTeHVS(getTiLeTramYTeHVS());
		clone.setKetLuanVSTX(getKetLuanVSTX());
		clone.setGhiChu(getGhiChu());
		clone.setBaoCaoDLI(getBaoCaoDLI());
		clone.setNgayTao(getNgayTao());
		clone.setIdNguoiTao(getIdNguoiTao());

		return clone;
	}

	@Override
	public int compareTo(DANHGIAVESINHXA danhgiavesinhxa) {
		int value = 0;

		if (getNam() < danhgiavesinhxa.getNam()) {
			value = -1;
		}
		else if (getNam() > danhgiavesinhxa.getNam()) {
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

		if (!(obj instanceof DANHGIAVESINHXAClp)) {
			return false;
		}

		DANHGIAVESINHXAClp danhgiavesinhxa = (DANHGIAVESINHXAClp)obj;

		long primaryKey = danhgiavesinhxa.getPrimaryKey();

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
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", maXa=");
		sb.append(getMaXa());
		sb.append(", maTinh=");
		sb.append(getMaTinh());
		sb.append(", maHuyen=");
		sb.append(getMaHuyen());
		sb.append(", nam=");
		sb.append(getNam());
		sb.append(", soDan=");
		sb.append(getSoDan());
		sb.append(", tiLeHGDCoNhaTieu=");
		sb.append(getTiLeHGDCoNhaTieu());
		sb.append(", tiLeHGDCoNhaTieuHVS=");
		sb.append(getTiLeHGDCoNhaTieuHVS());
		sb.append(", tiLeTruongHocHVS=");
		sb.append(getTiLeTruongHocHVS());
		sb.append(", tiLeTramYTeHVS=");
		sb.append(getTiLeTramYTeHVS());
		sb.append(", ketLuanVSTX=");
		sb.append(getKetLuanVSTX());
		sb.append(", ghiChu=");
		sb.append(getGhiChu());
		sb.append(", baoCaoDLI=");
		sb.append(getBaoCaoDLI());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", idNguoiTao=");
		sb.append(getIdNguoiTao());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.sol.ns.danhgiavesinh.dao.model.DANHGIAVESINHXA");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maXa</column-name><column-value><![CDATA[");
		sb.append(getMaXa());
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
			"<column><column-name>nam</column-name><column-value><![CDATA[");
		sb.append(getNam());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soDan</column-name><column-value><![CDATA[");
		sb.append(getSoDan());
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
			"<column><column-name>ketLuanVSTX</column-name><column-value><![CDATA[");
		sb.append(getKetLuanVSTX());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ghiChu</column-name><column-value><![CDATA[");
		sb.append(getGhiChu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>baoCaoDLI</column-name><column-value><![CDATA[");
		sb.append(getBaoCaoDLI());
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

	private long _id;
	private String _maXa;
	private String _maTinh;
	private String _maHuyen;
	private int _nam;
	private int _soDan;
	private int _tiLeHGDCoNhaTieu;
	private int _tiLeHGDCoNhaTieuHVS;
	private int _tiLeTruongHocHVS;
	private int _tiLeTramYTeHVS;
	private int _ketLuanVSTX;
	private long _ghiChu;
	private int _baoCaoDLI;
	private Date _ngayTao;
	private long _idNguoiTao;
	private BaseModel<?> _danhgiavesinhxaRemoteModel;
}