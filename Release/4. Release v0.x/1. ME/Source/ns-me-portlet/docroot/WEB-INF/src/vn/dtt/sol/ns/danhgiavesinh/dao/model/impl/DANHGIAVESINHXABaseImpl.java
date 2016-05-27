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

package vn.dtt.sol.ns.danhgiavesinh.dao.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import vn.dtt.sol.ns.danhgiavesinh.dao.model.DANHGIAVESINHXA;
import vn.dtt.sol.ns.danhgiavesinh.dao.service.DANHGIAVESINHXALocalServiceUtil;

/**
 * The extended model base implementation for the DANHGIAVESINHXA service. Represents a row in the &quot;ME_DANHGIAVESINHXA&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DANHGIAVESINHXAImpl}.
 * </p>
 *
 * @author khoa.vu
 * @see DANHGIAVESINHXAImpl
 * @see vn.dtt.sol.ns.danhgiavesinh.dao.model.DANHGIAVESINHXA
 * @generated
 */
public abstract class DANHGIAVESINHXABaseImpl extends DANHGIAVESINHXAModelImpl
	implements DANHGIAVESINHXA {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a d a n h g i a v e s i n h x a model instance should use the {@link DANHGIAVESINHXA} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DANHGIAVESINHXALocalServiceUtil.addDANHGIAVESINHXA(this);
		}
		else {
			DANHGIAVESINHXALocalServiceUtil.updateDANHGIAVESINHXA(this);
		}
	}
}