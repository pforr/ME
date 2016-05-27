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

package vn.dtt.cmon.user.dao.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserTULocalService}.
 *
 * @author khoa.vu
 * @see UserTULocalService
 * @generated
 */
public class UserTULocalServiceWrapper implements UserTULocalService,
	ServiceWrapper<UserTULocalService> {
	public UserTULocalServiceWrapper(UserTULocalService userTULocalService) {
		_userTULocalService = userTULocalService;
	}

	/**
	* Adds the user t u to the database. Also notifies the appropriate model listeners.
	*
	* @param userTU the user t u
	* @return the user t u that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.cmon.user.dao.model.UserTU addUserTU(
		vn.dtt.cmon.user.dao.model.UserTU userTU)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTULocalService.addUserTU(userTU);
	}

	/**
	* Creates a new user t u with the primary key. Does not add the user t u to the database.
	*
	* @param id the primary key for the new user t u
	* @return the new user t u
	*/
	@Override
	public vn.dtt.cmon.user.dao.model.UserTU createUserTU(long id) {
		return _userTULocalService.createUserTU(id);
	}

	/**
	* Deletes the user t u with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the user t u
	* @return the user t u that was removed
	* @throws PortalException if a user t u with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.cmon.user.dao.model.UserTU deleteUserTU(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userTULocalService.deleteUserTU(id);
	}

	/**
	* Deletes the user t u from the database. Also notifies the appropriate model listeners.
	*
	* @param userTU the user t u
	* @return the user t u that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.cmon.user.dao.model.UserTU deleteUserTU(
		vn.dtt.cmon.user.dao.model.UserTU userTU)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTULocalService.deleteUserTU(userTU);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userTULocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTULocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.user.dao.model.impl.UserTUModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _userTULocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.user.dao.model.impl.UserTUModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTULocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTULocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTULocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public vn.dtt.cmon.user.dao.model.UserTU fetchUserTU(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTULocalService.fetchUserTU(id);
	}

	/**
	* Returns the user t u with the primary key.
	*
	* @param id the primary key of the user t u
	* @return the user t u
	* @throws PortalException if a user t u with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.cmon.user.dao.model.UserTU getUserTU(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userTULocalService.getUserTU(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userTULocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the user t us.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.user.dao.model.impl.UserTUModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user t us
	* @param end the upper bound of the range of user t us (not inclusive)
	* @return the range of user t us
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.dtt.cmon.user.dao.model.UserTU> getUserTUs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTULocalService.getUserTUs(start, end);
	}

	/**
	* Returns the number of user t us.
	*
	* @return the number of user t us
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUserTUsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTULocalService.getUserTUsCount();
	}

	/**
	* Updates the user t u in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userTU the user t u
	* @return the user t u that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.cmon.user.dao.model.UserTU updateUserTU(
		vn.dtt.cmon.user.dao.model.UserTU userTU)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTULocalService.updateUserTU(userTU);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userTULocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userTULocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userTULocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void addDiaBanTUByUser(long userId, long[] lsMaTinh)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userTULocalService.addDiaBanTUByUser(userId, lsMaTinh);
	}

	@Override
	public java.util.List<vn.dtt.cmon.user.dao.model.UserTU> getTinhByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userTULocalService.getTinhByUserId(userId);
	}

	@Override
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> getTinhTUByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userTULocalService.getTinhTUByUser(userId, start, end);
	}

	@Override
	public int countTinhTUByUser(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userTULocalService.countTinhTUByUser(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserTULocalService getWrappedUserTULocalService() {
		return _userTULocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserTULocalService(
		UserTULocalService userTULocalService) {
		_userTULocalService = userTULocalService;
	}

	@Override
	public UserTULocalService getWrappedService() {
		return _userTULocalService;
	}

	@Override
	public void setWrappedService(UserTULocalService userTULocalService) {
		_userTULocalService = userTULocalService;
	}

	private UserTULocalService _userTULocalService;
}