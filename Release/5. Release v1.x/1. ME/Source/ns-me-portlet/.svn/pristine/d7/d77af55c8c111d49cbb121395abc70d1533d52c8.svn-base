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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for DM_THONXOM. This utility wraps
 * {@link vn.dtt.cmon.dm.dao.service.impl.DM_THONXOMLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoa.vu
 * @see DM_THONXOMLocalService
 * @see vn.dtt.cmon.dm.dao.service.base.DM_THONXOMLocalServiceBaseImpl
 * @see vn.dtt.cmon.dm.dao.service.impl.DM_THONXOMLocalServiceImpl
 * @generated
 */
public class DM_THONXOMLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.dtt.cmon.dm.dao.service.impl.DM_THONXOMLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the d m_ t h o n x o m to the database. Also notifies the appropriate model listeners.
	*
	* @param dm_thonxom the d m_ t h o n x o m
	* @return the d m_ t h o n x o m that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dm.dao.model.DM_THONXOM addDM_THONXOM(
		vn.dtt.cmon.dm.dao.model.DM_THONXOM dm_thonxom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDM_THONXOM(dm_thonxom);
	}

	/**
	* Creates a new d m_ t h o n x o m with the primary key. Does not add the d m_ t h o n x o m to the database.
	*
	* @param id the primary key for the new d m_ t h o n x o m
	* @return the new d m_ t h o n x o m
	*/
	public static vn.dtt.cmon.dm.dao.model.DM_THONXOM createDM_THONXOM(long id) {
		return getService().createDM_THONXOM(id);
	}

	/**
	* Deletes the d m_ t h o n x o m with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the d m_ t h o n x o m
	* @return the d m_ t h o n x o m that was removed
	* @throws PortalException if a d m_ t h o n x o m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dm.dao.model.DM_THONXOM deleteDM_THONXOM(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDM_THONXOM(id);
	}

	/**
	* Deletes the d m_ t h o n x o m from the database. Also notifies the appropriate model listeners.
	*
	* @param dm_thonxom the d m_ t h o n x o m
	* @return the d m_ t h o n x o m that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dm.dao.model.DM_THONXOM deleteDM_THONXOM(
		vn.dtt.cmon.dm.dao.model.DM_THONXOM dm_thonxom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDM_THONXOM(dm_thonxom);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static vn.dtt.cmon.dm.dao.model.DM_THONXOM fetchDM_THONXOM(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDM_THONXOM(id);
	}

	/**
	* Returns the d m_ t h o n x o m with the primary key.
	*
	* @param id the primary key of the d m_ t h o n x o m
	* @return the d m_ t h o n x o m
	* @throws PortalException if a d m_ t h o n x o m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dm.dao.model.DM_THONXOM getDM_THONXOM(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDM_THONXOM(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<vn.dtt.cmon.dm.dao.model.DM_THONXOM> getDM_THONXOMs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDM_THONXOMs(start, end);
	}

	/**
	* Returns the number of d m_ t h o n x o ms.
	*
	* @return the number of d m_ t h o n x o ms
	* @throws SystemException if a system exception occurred
	*/
	public static int getDM_THONXOMsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDM_THONXOMsCount();
	}

	/**
	* Updates the d m_ t h o n x o m in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dm_thonxom the d m_ t h o n x o m
	* @return the d m_ t h o n x o m that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dm.dao.model.DM_THONXOM updateDM_THONXOM(
		vn.dtt.cmon.dm.dao.model.DM_THONXOM dm_thonxom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDM_THONXOM(dm_thonxom);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static DM_THONXOMLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DM_THONXOMLocalService.class.getName());

			if (invokableLocalService instanceof DM_THONXOMLocalService) {
				_service = (DM_THONXOMLocalService)invokableLocalService;
			}
			else {
				_service = new DM_THONXOMLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(DM_THONXOMLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(DM_THONXOMLocalService service) {
	}

	private static DM_THONXOMLocalService _service;
}