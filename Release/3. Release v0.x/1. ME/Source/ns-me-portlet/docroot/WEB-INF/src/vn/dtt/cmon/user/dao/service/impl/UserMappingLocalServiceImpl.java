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

package vn.dtt.cmon.user.dao.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import vn.dtt.cmon.user.dao.model.UserMapping;
import vn.dtt.cmon.user.dao.service.base.UserMappingLocalServiceBaseImpl;

/**
 * The implementation of the user mapping local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.dtt.sol.cmon.user.dao.service.UserMappingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author khoa.vu
 * @see vn.dtt.sol.cmon.user.dao.service.base.UserMappingLocalServiceBaseImpl
 * @see vn.dtt.sol.cmon.user.dao.service.UserMappingLocalServiceUtil
 */
public class UserMappingLocalServiceImpl extends
		UserMappingLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.dtt.sol.cmon.user.dao.service.UserMappingLocalServiceUtil} to access
	 * the user mapping local service.
	 */

	public int count(String keyword, int userType, String orgCode1,
			String orgCode2) throws PortalException, SystemException {
		return userMappingFinder.count(keyword, userType, orgCode1, orgCode2);
	}

	public List<UserMapping> find(String keyword, int userType,
			String orgCode1, String orgCode2, int start, int end)
			throws PortalException, SystemException {
		return userMappingFinder.find(keyword, userType, orgCode1, orgCode2,
				start, end);
	}

	public UserMapping getByUserId(long userId) throws PortalException,
			SystemException {
		return userMappingPersistence.findByU_M(userId);
	}

	public List<UserMapping> getByOrg1_Org2(String orgCode1, String orgCode2)
			throws PortalException, SystemException {
		return userMappingPersistence.findByO_C_1_O_C_2(orgCode1, orgCode2);
	}

	public List<UserMapping> getByOrg1(String orgCode1) throws PortalException,
			SystemException {
		return userMappingPersistence.findByO_C_1(orgCode1);
	}

	public List<UserMapping> getByOrg2(String orgCode2) throws PortalException,
			SystemException {
		return userMappingPersistence.findByO_C_1(orgCode2);
	}

	public List<UserMapping> getByTypeOrg1(int userType, String orgCode1)
			throws PortalException, SystemException {
		return userMappingPersistence.findByT_O_C_1(userType, orgCode1);
	}

	public List<UserMapping> getByTypeOrg2(int userType, String orgCode1,
			String orgCode2) throws PortalException, SystemException {
		return userMappingPersistence.findByT_O_C_2(userType, orgCode1,
				orgCode2);
	}

	public List<UserMapping> getByUserType(int userType)
			throws PortalException, SystemException {
		return userMappingPersistence.findByU_T(userType);
	}

	public UserMapping addUserMapping(long id, String name, long userId,
			int userType, String orgCode1, String orgCode2)
			throws PortalException, SystemException {
		UserMapping userMapping = null;

		if (id > 0) {
			userMapping = userMappingPersistence.findByPrimaryKey(id);
		} else {
			id = counterLocalService.increment(UserMapping.class.getName());

			userMapping = userMappingPersistence.create(id);
			
			userMapping.setUserType(userType);
			userMapping.setUserId(userId);
			userMapping.setOrgCode1(orgCode1);
			userMapping.setOrgCode2(orgCode2);

		}

		userMapping.setName(name);

		userMappingPersistence.update(userMapping);

		userMappingPersistence.clearCache();

		return userMapping;
	}

	public UserMapping addUserMapping(long id, long userId, int userType,
			String orgCode1, String orgCode2) throws PortalException,
			SystemException {
		UserMapping userMapping = null;

		if (id > 0) {
			userMapping = userMappingPersistence.findByPrimaryKey(id);
		} else {
			id = counterLocalService.increment(UserMapping.class.getName());

			userMapping = userMappingPersistence.create(id);
		}

		userMapping.setUserType(userType);
		userMapping.setUserId(userId);
		userMapping.setOrgCode1(orgCode1);
		userMapping.setOrgCode2(orgCode2);

		userMappingPersistence.update(userMapping);

		userMappingPersistence.clearCache();

		return userMapping;
	}

}