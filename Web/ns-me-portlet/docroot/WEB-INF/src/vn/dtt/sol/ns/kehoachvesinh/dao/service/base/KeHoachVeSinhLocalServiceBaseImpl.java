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

package vn.dtt.sol.ns.kehoachvesinh.dao.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import vn.dtt.sol.ns.kehoachvesinh.dao.model.KeHoachVeSinh;
import vn.dtt.sol.ns.kehoachvesinh.dao.service.KeHoachVeSinhLocalService;
import vn.dtt.sol.ns.kehoachvesinh.dao.service.persistence.KeHoachVeSinhFinder;
import vn.dtt.sol.ns.kehoachvesinh.dao.service.persistence.KeHoachVeSinhPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the ke hoach ve sinh local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link vn.dtt.sol.ns.kehoachvesinh.dao.service.impl.KeHoachVeSinhLocalServiceImpl}.
 * </p>
 *
 * @author HANT
 * @see vn.dtt.sol.ns.kehoachvesinh.dao.service.impl.KeHoachVeSinhLocalServiceImpl
 * @see vn.dtt.sol.ns.kehoachvesinh.dao.service.KeHoachVeSinhLocalServiceUtil
 * @generated
 */
public abstract class KeHoachVeSinhLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements KeHoachVeSinhLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link vn.dtt.sol.ns.kehoachvesinh.dao.service.KeHoachVeSinhLocalServiceUtil} to access the ke hoach ve sinh local service.
	 */

	/**
	 * Adds the ke hoach ve sinh to the database. Also notifies the appropriate model listeners.
	 *
	 * @param keHoachVeSinh the ke hoach ve sinh
	 * @return the ke hoach ve sinh that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public KeHoachVeSinh addKeHoachVeSinh(KeHoachVeSinh keHoachVeSinh)
		throws SystemException {
		keHoachVeSinh.setNew(true);

		return keHoachVeSinhPersistence.update(keHoachVeSinh);
	}

	/**
	 * Creates a new ke hoach ve sinh with the primary key. Does not add the ke hoach ve sinh to the database.
	 *
	 * @param id the primary key for the new ke hoach ve sinh
	 * @return the new ke hoach ve sinh
	 */
	@Override
	public KeHoachVeSinh createKeHoachVeSinh(long id) {
		return keHoachVeSinhPersistence.create(id);
	}

	/**
	 * Deletes the ke hoach ve sinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ke hoach ve sinh
	 * @return the ke hoach ve sinh that was removed
	 * @throws PortalException if a ke hoach ve sinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public KeHoachVeSinh deleteKeHoachVeSinh(long id)
		throws PortalException, SystemException {
		return keHoachVeSinhPersistence.remove(id);
	}

	/**
	 * Deletes the ke hoach ve sinh from the database. Also notifies the appropriate model listeners.
	 *
	 * @param keHoachVeSinh the ke hoach ve sinh
	 * @return the ke hoach ve sinh that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public KeHoachVeSinh deleteKeHoachVeSinh(KeHoachVeSinh keHoachVeSinh)
		throws SystemException {
		return keHoachVeSinhPersistence.remove(keHoachVeSinh);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(KeHoachVeSinh.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return keHoachVeSinhPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.kehoachvesinh.dao.model.impl.KeHoachVeSinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return keHoachVeSinhPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.kehoachvesinh.dao.model.impl.KeHoachVeSinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return keHoachVeSinhPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return keHoachVeSinhPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return keHoachVeSinhPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public KeHoachVeSinh fetchKeHoachVeSinh(long id) throws SystemException {
		return keHoachVeSinhPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the ke hoach ve sinh with the primary key.
	 *
	 * @param id the primary key of the ke hoach ve sinh
	 * @return the ke hoach ve sinh
	 * @throws PortalException if a ke hoach ve sinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KeHoachVeSinh getKeHoachVeSinh(long id)
		throws PortalException, SystemException {
		return keHoachVeSinhPersistence.findByPrimaryKey(id);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return keHoachVeSinhPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the ke hoach ve sinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.kehoachvesinh.dao.model.impl.KeHoachVeSinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ke hoach ve sinhs
	 * @param end the upper bound of the range of ke hoach ve sinhs (not inclusive)
	 * @return the range of ke hoach ve sinhs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KeHoachVeSinh> getKeHoachVeSinhs(int start, int end)
		throws SystemException {
		return keHoachVeSinhPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of ke hoach ve sinhs.
	 *
	 * @return the number of ke hoach ve sinhs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getKeHoachVeSinhsCount() throws SystemException {
		return keHoachVeSinhPersistence.countAll();
	}

	/**
	 * Updates the ke hoach ve sinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param keHoachVeSinh the ke hoach ve sinh
	 * @return the ke hoach ve sinh that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public KeHoachVeSinh updateKeHoachVeSinh(KeHoachVeSinh keHoachVeSinh)
		throws SystemException {
		return keHoachVeSinhPersistence.update(keHoachVeSinh);
	}

	/**
	 * Returns the ke hoach ve sinh local service.
	 *
	 * @return the ke hoach ve sinh local service
	 */
	public vn.dtt.sol.ns.kehoachvesinh.dao.service.KeHoachVeSinhLocalService getKeHoachVeSinhLocalService() {
		return keHoachVeSinhLocalService;
	}

	/**
	 * Sets the ke hoach ve sinh local service.
	 *
	 * @param keHoachVeSinhLocalService the ke hoach ve sinh local service
	 */
	public void setKeHoachVeSinhLocalService(
		vn.dtt.sol.ns.kehoachvesinh.dao.service.KeHoachVeSinhLocalService keHoachVeSinhLocalService) {
		this.keHoachVeSinhLocalService = keHoachVeSinhLocalService;
	}

	/**
	 * Returns the ke hoach ve sinh persistence.
	 *
	 * @return the ke hoach ve sinh persistence
	 */
	public KeHoachVeSinhPersistence getKeHoachVeSinhPersistence() {
		return keHoachVeSinhPersistence;
	}

	/**
	 * Sets the ke hoach ve sinh persistence.
	 *
	 * @param keHoachVeSinhPersistence the ke hoach ve sinh persistence
	 */
	public void setKeHoachVeSinhPersistence(
		KeHoachVeSinhPersistence keHoachVeSinhPersistence) {
		this.keHoachVeSinhPersistence = keHoachVeSinhPersistence;
	}

	/**
	 * Returns the ke hoach ve sinh finder.
	 *
	 * @return the ke hoach ve sinh finder
	 */
	public KeHoachVeSinhFinder getKeHoachVeSinhFinder() {
		return keHoachVeSinhFinder;
	}

	/**
	 * Sets the ke hoach ve sinh finder.
	 *
	 * @param keHoachVeSinhFinder the ke hoach ve sinh finder
	 */
	public void setKeHoachVeSinhFinder(KeHoachVeSinhFinder keHoachVeSinhFinder) {
		this.keHoachVeSinhFinder = keHoachVeSinhFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("vn.dtt.sol.ns.kehoachvesinh.dao.model.KeHoachVeSinh",
			keHoachVeSinhLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"vn.dtt.sol.ns.kehoachvesinh.dao.model.KeHoachVeSinh");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return KeHoachVeSinh.class;
	}

	protected String getModelClassName() {
		return KeHoachVeSinh.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = keHoachVeSinhPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = vn.dtt.sol.ns.kehoachvesinh.dao.service.KeHoachVeSinhLocalService.class)
	protected vn.dtt.sol.ns.kehoachvesinh.dao.service.KeHoachVeSinhLocalService keHoachVeSinhLocalService;
	@BeanReference(type = KeHoachVeSinhPersistence.class)
	protected KeHoachVeSinhPersistence keHoachVeSinhPersistence;
	@BeanReference(type = KeHoachVeSinhFinder.class)
	protected KeHoachVeSinhFinder keHoachVeSinhFinder;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private KeHoachVeSinhLocalServiceClpInvoker _clpInvoker = new KeHoachVeSinhLocalServiceClpInvoker();
}