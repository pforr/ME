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

package vn.dtt.cmon.dm.dao.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import vn.dtt.cmon.dm.dao.service.ClpSerializer;
import vn.dtt.cmon.dm.dao.service.DM_THONXOMLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author khoa.vu
 */
public class DM_THONXOMClp extends BaseModelImpl<DM_THONXOM>
	implements DM_THONXOM {
	public DM_THONXOMClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DM_THONXOM.class;
	}

	@Override
	public String getModelClassName() {
		return DM_THONXOM.class.getName();
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
		attributes.put("maTinh", getMaTinh());
		attributes.put("maHuyen", getMaHuyen());
		attributes.put("maXa", getMaXa());
		attributes.put("thonXom", getThonXom());

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
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_dm_thonxomRemoteModel != null) {
			try {
				Class<?> clazz = _dm_thonxomRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_dm_thonxomRemoteModel, id);
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

		if (_dm_thonxomRemoteModel != null) {
			try {
				Class<?> clazz = _dm_thonxomRemoteModel.getClass();

				Method method = clazz.getMethod("setMaTinh", String.class);

				method.invoke(_dm_thonxomRemoteModel, maTinh);
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

		if (_dm_thonxomRemoteModel != null) {
			try {
				Class<?> clazz = _dm_thonxomRemoteModel.getClass();

				Method method = clazz.getMethod("setMaHuyen", String.class);

				method.invoke(_dm_thonxomRemoteModel, maHuyen);
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

		if (_dm_thonxomRemoteModel != null) {
			try {
				Class<?> clazz = _dm_thonxomRemoteModel.getClass();

				Method method = clazz.getMethod("setMaXa", String.class);

				method.invoke(_dm_thonxomRemoteModel, maXa);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getThonXom() {
		return _thonXom;
	}

	@Override
	public void setThonXom(String thonXom) {
		_thonXom = thonXom;

		if (_dm_thonxomRemoteModel != null) {
			try {
				Class<?> clazz = _dm_thonxomRemoteModel.getClass();

				Method method = clazz.getMethod("setThonXom", String.class);

				method.invoke(_dm_thonxomRemoteModel, thonXom);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDM_THONXOMRemoteModel() {
		return _dm_thonxomRemoteModel;
	}

	public void setDM_THONXOMRemoteModel(BaseModel<?> dm_thonxomRemoteModel) {
		_dm_thonxomRemoteModel = dm_thonxomRemoteModel;
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

		Class<?> remoteModelClass = _dm_thonxomRemoteModel.getClass();

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

		Object returnValue = method.invoke(_dm_thonxomRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DM_THONXOMLocalServiceUtil.addDM_THONXOM(this);
		}
		else {
			DM_THONXOMLocalServiceUtil.updateDM_THONXOM(this);
		}
	}

	@Override
	public DM_THONXOM toEscapedModel() {
		return (DM_THONXOM)ProxyUtil.newProxyInstance(DM_THONXOM.class.getClassLoader(),
			new Class[] { DM_THONXOM.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DM_THONXOMClp clone = new DM_THONXOMClp();

		clone.setId(getId());
		clone.setMaTinh(getMaTinh());
		clone.setMaHuyen(getMaHuyen());
		clone.setMaXa(getMaXa());
		clone.setThonXom(getThonXom());

		return clone;
	}

	@Override
	public int compareTo(DM_THONXOM dm_thonxom) {
		long primaryKey = dm_thonxom.getPrimaryKey();

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

		if (!(obj instanceof DM_THONXOMClp)) {
			return false;
		}

		DM_THONXOMClp dm_thonxom = (DM_THONXOMClp)obj;

		long primaryKey = dm_thonxom.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", maTinh=");
		sb.append(getMaTinh());
		sb.append(", maHuyen=");
		sb.append(getMaHuyen());
		sb.append(", maXa=");
		sb.append(getMaXa());
		sb.append(", thonXom=");
		sb.append(getThonXom());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.cmon.dm.dao.model.DM_THONXOM");
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _maTinh;
	private String _maHuyen;
	private String _maXa;
	private String _thonXom;
	private BaseModel<?> _dm_thonxomRemoteModel;
}