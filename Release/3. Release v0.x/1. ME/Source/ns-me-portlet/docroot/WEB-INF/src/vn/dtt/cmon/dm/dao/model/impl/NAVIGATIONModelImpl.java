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

package vn.dtt.cmon.dm.dao.model.impl;

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

import vn.dtt.cmon.dm.dao.model.NAVIGATION;
import vn.dtt.cmon.dm.dao.model.NAVIGATIONModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the NAVIGATION service. Represents a row in the &quot;DM_NAVIGATION&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.dtt.cmon.dm.dao.model.NAVIGATIONModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NAVIGATIONImpl}.
 * </p>
 *
 * @author khoa.vu
 * @see NAVIGATIONImpl
 * @see vn.dtt.cmon.dm.dao.model.NAVIGATION
 * @see vn.dtt.cmon.dm.dao.model.NAVIGATIONModel
 * @generated
 */
public class NAVIGATIONModelImpl extends BaseModelImpl<NAVIGATION>
	implements NAVIGATIONModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a n a v i g a t i o n model instance should use the {@link vn.dtt.cmon.dm.dao.model.NAVIGATION} interface instead.
	 */
	public static final String TABLE_NAME = "DM_NAVIGATION";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.BIGINT },
			{ "NAME", Types.VARCHAR },
			{ "NAVSUB", Types.VARCHAR },
			{ "NAVSUBOWNER", Types.VARCHAR },
			{ "ROLEOWNER", Types.VARCHAR },
			{ "PERMISSIONOWNER", Types.VARCHAR },
			{ "PARENTID", Types.BIGINT },
			{ "HIDDEN", Types.BIGINT },
			{ "ORDER", Types.BIGINT },
			{ "THONGKE", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table DM_NAVIGATION (ID LONG not null primary key,NAME VARCHAR(75) null,NAVSUB VARCHAR(75) null,NAVSUBOWNER VARCHAR(75) null,ROLEOWNER VARCHAR(75) null,PERMISSIONOWNER VARCHAR(75) null,PARENTID LONG,HIDDEN LONG,ORDER LONG,THONGKE VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table DM_NAVIGATION";
	public static final String ORDER_BY_JPQL = " ORDER BY navigation.order ASC";
	public static final String ORDER_BY_SQL = " ORDER BY DM_NAVIGATION.ORDER ASC";
	public static final String DATA_SOURCE = "dmDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.dtt.cmon.dm.dao.model.NAVIGATION"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.dtt.cmon.dm.dao.model.NAVIGATION"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.dtt.cmon.dm.dao.model.NAVIGATION"),
			true);
	public static long HIDDEN_COLUMN_BITMASK = 1L;
	public static long PARENTID_COLUMN_BITMASK = 2L;
	public static long ORDER_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.dtt.cmon.dm.dao.model.NAVIGATION"));

	public NAVIGATIONModelImpl() {
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
		return NAVIGATION.class;
	}

	@Override
	public String getModelClassName() {
		return NAVIGATION.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());
		attributes.put("navSub", getNavSub());
		attributes.put("navSubOwner", getNavSubOwner());
		attributes.put("roleOwner", getRoleOwner());
		attributes.put("permissionOwner", getPermissionOwner());
		attributes.put("parentId", getParentId());
		attributes.put("hidden", getHidden());
		attributes.put("order", getOrder());
		attributes.put("thongKe", getThongKe());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String navSub = (String)attributes.get("navSub");

		if (navSub != null) {
			setNavSub(navSub);
		}

		String navSubOwner = (String)attributes.get("navSubOwner");

		if (navSubOwner != null) {
			setNavSubOwner(navSubOwner);
		}

		String roleOwner = (String)attributes.get("roleOwner");

		if (roleOwner != null) {
			setRoleOwner(roleOwner);
		}

		String permissionOwner = (String)attributes.get("permissionOwner");

		if (permissionOwner != null) {
			setPermissionOwner(permissionOwner);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		Long hidden = (Long)attributes.get("hidden");

		if (hidden != null) {
			setHidden(hidden);
		}

		Long order = (Long)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		String thongKe = (String)attributes.get("thongKe");

		if (thongKe != null) {
			setThongKe(thongKe);
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
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public String getNavSub() {
		if (_navSub == null) {
			return StringPool.BLANK;
		}
		else {
			return _navSub;
		}
	}

	@Override
	public void setNavSub(String navSub) {
		_navSub = navSub;
	}

	@Override
	public String getNavSubOwner() {
		if (_navSubOwner == null) {
			return StringPool.BLANK;
		}
		else {
			return _navSubOwner;
		}
	}

	@Override
	public void setNavSubOwner(String navSubOwner) {
		_navSubOwner = navSubOwner;
	}

	@Override
	public String getRoleOwner() {
		if (_roleOwner == null) {
			return StringPool.BLANK;
		}
		else {
			return _roleOwner;
		}
	}

	@Override
	public void setRoleOwner(String roleOwner) {
		_roleOwner = roleOwner;
	}

	@Override
	public String getPermissionOwner() {
		if (_permissionOwner == null) {
			return StringPool.BLANK;
		}
		else {
			return _permissionOwner;
		}
	}

	@Override
	public void setPermissionOwner(String permissionOwner) {
		_permissionOwner = permissionOwner;
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_columnBitmask |= PARENTID_COLUMN_BITMASK;

		if (!_setOriginalParentId) {
			_setOriginalParentId = true;

			_originalParentId = _parentId;
		}

		_parentId = parentId;
	}

	public long getOriginalParentId() {
		return _originalParentId;
	}

	@Override
	public long getHidden() {
		return _hidden;
	}

	@Override
	public void setHidden(long hidden) {
		_columnBitmask |= HIDDEN_COLUMN_BITMASK;

		if (!_setOriginalHidden) {
			_setOriginalHidden = true;

			_originalHidden = _hidden;
		}

		_hidden = hidden;
	}

	public long getOriginalHidden() {
		return _originalHidden;
	}

	@Override
	public long getOrder() {
		return _order;
	}

	@Override
	public void setOrder(long order) {
		_columnBitmask = -1L;

		_order = order;
	}

	@Override
	public String getThongKe() {
		if (_thongKe == null) {
			return StringPool.BLANK;
		}
		else {
			return _thongKe;
		}
	}

	@Override
	public void setThongKe(String thongKe) {
		_thongKe = thongKe;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			NAVIGATION.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public NAVIGATION toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (NAVIGATION)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		NAVIGATIONImpl navigationImpl = new NAVIGATIONImpl();

		navigationImpl.setId(getId());
		navigationImpl.setName(getName());
		navigationImpl.setNavSub(getNavSub());
		navigationImpl.setNavSubOwner(getNavSubOwner());
		navigationImpl.setRoleOwner(getRoleOwner());
		navigationImpl.setPermissionOwner(getPermissionOwner());
		navigationImpl.setParentId(getParentId());
		navigationImpl.setHidden(getHidden());
		navigationImpl.setOrder(getOrder());
		navigationImpl.setThongKe(getThongKe());

		navigationImpl.resetOriginalValues();

		return navigationImpl;
	}

	@Override
	public int compareTo(NAVIGATION navigation) {
		int value = 0;

		if (getOrder() < navigation.getOrder()) {
			value = -1;
		}
		else if (getOrder() > navigation.getOrder()) {
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

		if (!(obj instanceof NAVIGATION)) {
			return false;
		}

		NAVIGATION navigation = (NAVIGATION)obj;

		long primaryKey = navigation.getPrimaryKey();

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
		NAVIGATIONModelImpl navigationModelImpl = this;

		navigationModelImpl._originalParentId = navigationModelImpl._parentId;

		navigationModelImpl._setOriginalParentId = false;

		navigationModelImpl._originalHidden = navigationModelImpl._hidden;

		navigationModelImpl._setOriginalHidden = false;

		navigationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<NAVIGATION> toCacheModel() {
		NAVIGATIONCacheModel navigationCacheModel = new NAVIGATIONCacheModel();

		navigationCacheModel.id = getId();

		navigationCacheModel.name = getName();

		String name = navigationCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			navigationCacheModel.name = null;
		}

		navigationCacheModel.navSub = getNavSub();

		String navSub = navigationCacheModel.navSub;

		if ((navSub != null) && (navSub.length() == 0)) {
			navigationCacheModel.navSub = null;
		}

		navigationCacheModel.navSubOwner = getNavSubOwner();

		String navSubOwner = navigationCacheModel.navSubOwner;

		if ((navSubOwner != null) && (navSubOwner.length() == 0)) {
			navigationCacheModel.navSubOwner = null;
		}

		navigationCacheModel.roleOwner = getRoleOwner();

		String roleOwner = navigationCacheModel.roleOwner;

		if ((roleOwner != null) && (roleOwner.length() == 0)) {
			navigationCacheModel.roleOwner = null;
		}

		navigationCacheModel.permissionOwner = getPermissionOwner();

		String permissionOwner = navigationCacheModel.permissionOwner;

		if ((permissionOwner != null) && (permissionOwner.length() == 0)) {
			navigationCacheModel.permissionOwner = null;
		}

		navigationCacheModel.parentId = getParentId();

		navigationCacheModel.hidden = getHidden();

		navigationCacheModel.order = getOrder();

		navigationCacheModel.thongKe = getThongKe();

		String thongKe = navigationCacheModel.thongKe;

		if ((thongKe != null) && (thongKe.length() == 0)) {
			navigationCacheModel.thongKe = null;
		}

		return navigationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", navSub=");
		sb.append(getNavSub());
		sb.append(", navSubOwner=");
		sb.append(getNavSubOwner());
		sb.append(", roleOwner=");
		sb.append(getRoleOwner());
		sb.append(", permissionOwner=");
		sb.append(getPermissionOwner());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", hidden=");
		sb.append(getHidden());
		sb.append(", order=");
		sb.append(getOrder());
		sb.append(", thongKe=");
		sb.append(getThongKe());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.cmon.dm.dao.model.NAVIGATION");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>navSub</column-name><column-value><![CDATA[");
		sb.append(getNavSub());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>navSubOwner</column-name><column-value><![CDATA[");
		sb.append(getNavSubOwner());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleOwner</column-name><column-value><![CDATA[");
		sb.append(getRoleOwner());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>permissionOwner</column-name><column-value><![CDATA[");
		sb.append(getPermissionOwner());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hidden</column-name><column-value><![CDATA[");
		sb.append(getHidden());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>order</column-name><column-value><![CDATA[");
		sb.append(getOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thongKe</column-name><column-value><![CDATA[");
		sb.append(getThongKe());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = NAVIGATION.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			NAVIGATION.class
		};
	private long _id;
	private String _name;
	private String _navSub;
	private String _navSubOwner;
	private String _roleOwner;
	private String _permissionOwner;
	private long _parentId;
	private long _originalParentId;
	private boolean _setOriginalParentId;
	private long _hidden;
	private long _originalHidden;
	private boolean _setOriginalHidden;
	private long _order;
	private String _thongKe;
	private long _columnBitmask;
	private NAVIGATION _escapedModel;
}