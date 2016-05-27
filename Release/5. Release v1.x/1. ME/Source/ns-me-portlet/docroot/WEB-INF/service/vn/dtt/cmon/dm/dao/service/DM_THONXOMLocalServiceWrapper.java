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

package vn.dtt.cmon.dm.dao.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DM_THONXOMLocalService}.
 *
 * @author khoa.vu
 * @see DM_THONXOMLocalService
 * @generated
 */
public class DM_THONXOMLocalServiceWrapper implements DM_THONXOMLocalService,
	ServiceWrapper<DM_THONXOMLocalService> {
	public DM_THONXOMLocalServiceWrapper(
		DM_THONXOMLocalService dm_thonxomLocalService) {
		_dm_thonxomLocalService = dm_thonxomLocalService;
	}

	/**
	* Adds the d m_ t h o n x o m to the database. Also notifies the appropriate model listeners.
	*
	* @param dm_thonxom the d m_ t h o n x o m
	* @return the d m_ t h o n x o m that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.cmon.dm.dao.model.DM_THONXOM addDM_THONXOM(
		vn.dtt.cmon.dm.dao.model.DM_THONXOM dm_thonxom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dm_thonxomLocalService.addDM_THONXOM(dm_thonxom);
	}

	/**
	* Creates a new d m_ t h o n x o m with the primary key. Does not add the d m_ t h o n x o m to the database.
	*
	* @param id the primary key for the new d m_ t h o n x o m
	* @return the new d m_ t h o n x o m
	*/
	@Override
	public vn.dtt.cmon.dm.dao.model.DM_THONXOM createDM_THONXOM(long id) {
		return _dm_thonxomLocalService.createDM_THONXOM(id);
	}

	/**
	* Deletes the d m_ t h o n x o m with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the d m_ t h o n x o m
	* @return the d m_ t h o n x o m that was removed
	* @throws PortalException if a d m_ t h o n x o m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.cmon.dm.dao.model.DM_THONXOM deleteDM_THONXOM(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dm_thonxomLocalService.deleteDM_THONXOM(id);
	}

	/**
	* Deletes the d m_ t h o n x o m from the database. Also notifies the appropriate model listeners.
	*
	* @param dm_thonxom the d m_ t h o n x o m
	* @return the d m_ t h o n x o m that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.cmon.dm.dao.model.DM_THONXOM deleteDM_THONXOM(
		vn.dtt.cmon.dm.dao.model.DM_THONXOM dm_thonxom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dm_thonxomLocalService.deleteDM_THONXOM(dm_thonxom);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dm_thonxomLocalService.dynamicQuery();
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
		return _dm_thonxomLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DM_THONXOMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dm_thonxomLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DM_THONXOMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dm_thonxomLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _dm_thonxomLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dm_thonxomLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.dtt.cmon.dm.dao.model.DM_THONXOM fetchDM_THONXOM(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dm_thonxomLocalService.fetchDM_THONXOM(id);
	}

	/**
	* Returns the d m_ t h o n x o m with the primary key.
	*
	* @param id the primary key of the d m_ t h o n x o m
	* @return the d m_ t h o n x o m
	* @throws PortalException if a d m_ t h o n x o m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.cmon.dm.dao.model.DM_THONXOM getDM_THONXOM(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dm_thonxomLocalService.getDM_THONXOM(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dm_thonxomLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the d m_ t h o n x o ms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DM_THONXOMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of d m_ t h o n x o ms
	* @param end the upper bound of the range of d m_ t h o n x o ms (not inclusive)
	* @return the range of d m_ t h o n x o ms
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.dtt.cmon.dm.dao.model.DM_THONXOM> getDM_THONXOMs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dm_thonxomLocalService.getDM_THONXOMs(start, end);
	}

	/**
	* Returns the number of d m_ t h o n x o ms.
	*
	* @return the number of d m_ t h o n x o ms
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDM_THONXOMsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dm_thonxomLocalService.getDM_THONXOMsCount();
	}

	/**
	* Updates the d m_ t h o n x o m in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dm_thonxom the d m_ t h o n x o m
	* @return the d m_ t h o n x o m that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.cmon.dm.dao.model.DM_THONXOM updateDM_THONXOM(
		vn.dtt.cmon.dm.dao.model.DM_THONXOM dm_thonxom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dm_thonxomLocalService.updateDM_THONXOM(dm_thonxom);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _dm_thonxomLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dm_thonxomLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dm_thonxomLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DM_THONXOMLocalService getWrappedDM_THONXOMLocalService() {
		return _dm_thonxomLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDM_THONXOMLocalService(
		DM_THONXOMLocalService dm_thonxomLocalService) {
		_dm_thonxomLocalService = dm_thonxomLocalService;
	}

	@Override
	public DM_THONXOMLocalService getWrappedService() {
		return _dm_thonxomLocalService;
	}

	@Override
	public void setWrappedService(DM_THONXOMLocalService dm_thonxomLocalService) {
		_dm_thonxomLocalService = dm_thonxomLocalService;
	}

	private DM_THONXOMLocalService _dm_thonxomLocalService;
}