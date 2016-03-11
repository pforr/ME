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

package vn.dtt.cmon.user.dao.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import vn.dtt.cmon.user.dao.model.UserTinh;
import vn.dtt.cmon.user.dao.service.UserTinhLocalServiceUtil;

/**
 * The extended model base implementation for the UserTinh service. Represents a row in the &quot;ME_DIABANQLY_TINH&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserTinhImpl}.
 * </p>
 *
 * @author khoa.vu
 * @see UserTinhImpl
 * @see vn.dtt.cmon.user.dao.model.UserTinh
 * @generated
 */
public abstract class UserTinhBaseImpl extends UserTinhModelImpl
	implements UserTinh {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user tinh model instance should use the {@link UserTinh} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserTinhLocalServiceUtil.addUserTinh(this);
		}
		else {
			UserTinhLocalServiceUtil.updateUserTinh(this);
		}
	}
}