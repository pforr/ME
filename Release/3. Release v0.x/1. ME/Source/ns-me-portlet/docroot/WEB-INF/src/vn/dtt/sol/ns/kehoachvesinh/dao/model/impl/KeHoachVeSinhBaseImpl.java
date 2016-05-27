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

package vn.dtt.sol.ns.kehoachvesinh.dao.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import vn.dtt.sol.ns.kehoachvesinh.dao.model.KeHoachVeSinh;
import vn.dtt.sol.ns.kehoachvesinh.dao.service.KeHoachVeSinhLocalServiceUtil;

/**
 * The extended model base implementation for the KeHoachVeSinh service. Represents a row in the &quot;ME_KEHOACHVESINHXA&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KeHoachVeSinhImpl}.
 * </p>
 *
 * @author HANT
 * @see KeHoachVeSinhImpl
 * @see vn.dtt.sol.ns.kehoachvesinh.dao.model.KeHoachVeSinh
 * @generated
 */
public abstract class KeHoachVeSinhBaseImpl extends KeHoachVeSinhModelImpl
	implements KeHoachVeSinh {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ke hoach ve sinh model instance should use the {@link KeHoachVeSinh} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			KeHoachVeSinhLocalServiceUtil.addKeHoachVeSinh(this);
		}
		else {
			KeHoachVeSinhLocalServiceUtil.updateKeHoachVeSinh(this);
		}
	}
}