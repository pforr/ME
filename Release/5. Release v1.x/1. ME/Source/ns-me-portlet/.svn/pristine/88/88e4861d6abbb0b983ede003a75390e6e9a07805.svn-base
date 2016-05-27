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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author khoa.vu
 * @generated
 */
public class DM_THONXOMSoap implements Serializable {
	public static DM_THONXOMSoap toSoapModel(DM_THONXOM model) {
		DM_THONXOMSoap soapModel = new DM_THONXOMSoap();

		soapModel.setId(model.getId());
		soapModel.setMaTinh(model.getMaTinh());
		soapModel.setMaHuyen(model.getMaHuyen());
		soapModel.setMaXa(model.getMaXa());
		soapModel.setThonXom(model.getThonXom());

		return soapModel;
	}

	public static DM_THONXOMSoap[] toSoapModels(DM_THONXOM[] models) {
		DM_THONXOMSoap[] soapModels = new DM_THONXOMSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DM_THONXOMSoap[][] toSoapModels(DM_THONXOM[][] models) {
		DM_THONXOMSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DM_THONXOMSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DM_THONXOMSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DM_THONXOMSoap[] toSoapModels(List<DM_THONXOM> models) {
		List<DM_THONXOMSoap> soapModels = new ArrayList<DM_THONXOMSoap>(models.size());

		for (DM_THONXOM model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DM_THONXOMSoap[soapModels.size()]);
	}

	public DM_THONXOMSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getMaTinh() {
		return _maTinh;
	}

	public void setMaTinh(String maTinh) {
		_maTinh = maTinh;
	}

	public String getMaHuyen() {
		return _maHuyen;
	}

	public void setMaHuyen(String maHuyen) {
		_maHuyen = maHuyen;
	}

	public String getMaXa() {
		return _maXa;
	}

	public void setMaXa(String maXa) {
		_maXa = maXa;
	}

	public String getThonXom() {
		return _thonXom;
	}

	public void setThonXom(String thonXom) {
		_thonXom = thonXom;
	}

	private long _id;
	private String _maTinh;
	private String _maHuyen;
	private String _maXa;
	private String _thonXom;
}