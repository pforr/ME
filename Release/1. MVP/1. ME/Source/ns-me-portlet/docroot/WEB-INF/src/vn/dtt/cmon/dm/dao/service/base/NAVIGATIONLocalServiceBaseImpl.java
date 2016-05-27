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

package vn.dtt.cmon.dm.dao.service.base;

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

import vn.dtt.cmon.dm.dao.model.NAVIGATION;
import vn.dtt.cmon.dm.dao.service.NAVIGATIONLocalService;
import vn.dtt.cmon.dm.dao.service.persistence.DATAGROUPPersistence;
import vn.dtt.cmon.dm.dao.service.persistence.DATAITEMFinder;
import vn.dtt.cmon.dm.dao.service.persistence.DATAITEMPersistence;
import vn.dtt.cmon.dm.dao.service.persistence.NAVIGATIONPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the n a v i g a t i o n local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link vn.dtt.cmon.dm.dao.service.impl.NAVIGATIONLocalServiceImpl}.
 * </p>
 *
 * @author khoa.vu
 * @see vn.dtt.cmon.dm.dao.service.impl.NAVIGATIONLocalServiceImpl
 * @see vn.dtt.cmon.dm.dao.service.NAVIGATIONLocalServiceUtil
 * @generated
 */
public abstract class NAVIGATIONLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements NAVIGATIONLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link vn.dtt.cmon.dm.dao.service.NAVIGATIONLocalServiceUtil} to access the n a v i g a t i o n local service.
	 */

	/**
	 * Adds the n a v i g a t i o n to the database. Also notifies the appropriate model listeners.
	 *
	 * @param navigation the n a v i g a t i o n
	 * @return the n a v i g a t i o n that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public NAVIGATION addNAVIGATION(NAVIGATION navigation)
		throws SystemException {
		navigation.setNew(true);

		return navigationPersistence.update(navigation);
	}

	/**
	 * Creates a new n a v i g a t i o n with the primary key. Does not add the n a v i g a t i o n to the database.
	 *
	 * @param id the primary key for the new n a v i g a t i o n
	 * @return the new n a v i g a t i o n
	 */
	@Override
	public NAVIGATION createNAVIGATION(long id) {
		return navigationPersistence.create(id);
	}

	/**
	 * Deletes the n a v i g a t i o n with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the n a v i g a t i o n
	 * @return the n a v i g a t i o n that was removed
	 * @throws PortalException if a n a v i g a t i o n with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public NAVIGATION deleteNAVIGATION(long id)
		throws PortalException, SystemException {
		return navigationPersistence.remove(id);
	}

	/**
	 * Deletes the n a v i g a t i o n from the database. Also notifies the appropriate model listeners.
	 *
	 * @param navigation the n a v i g a t i o n
	 * @return the n a v i g a t i o n that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public NAVIGATION deleteNAVIGATION(NAVIGATION navigation)
		throws SystemException {
		return navigationPersistence.remove(navigation);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(NAVIGATION.class,
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
		return navigationPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.NAVIGATIONModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return navigationPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.NAVIGATIONModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return navigationPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return navigationPersistence.countWithDynamicQuery(dynamicQuery);
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
		return navigationPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public NAVIGATION fetchNAVIGATION(long id) throws SystemException {
		return navigationPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the n a v i g a t i o n with the primary key.
	 *
	 * @param id the primary key of the n a v i g a t i o n
	 * @return the n a v i g a t i o n
	 * @throws PortalException if a n a v i g a t i o n with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NAVIGATION getNAVIGATION(long id)
		throws PortalException, SystemException {
		return navigationPersistence.findByPrimaryKey(id);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return navigationPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the n a v i g a t i o ns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.NAVIGATIONModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of n a v i g a t i o ns
	 * @param end the upper bound of the range of n a v i g a t i o ns (not inclusive)
	 * @return the range of n a v i g a t i o ns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NAVIGATION> getNAVIGATIONs(int start, int end)
		throws SystemException {
		return navigationPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of n a v i g a t i o ns.
	 *
	 * @return the number of n a v i g a t i o ns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getNAVIGATIONsCount() throws SystemException {
		return navigationPersistence.countAll();
	}

	/**
	 * Updates the n a v i g a t i o n in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param navigation the n a v i g a t i o n
	 * @return the n a v i g a t i o n that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public NAVIGATION updateNAVIGATION(NAVIGATION navigation)
		throws SystemException {
		return navigationPersistence.update(navigation);
	}

	/**
	 * Returns the d a t a g r o u p local service.
	 *
	 * @return the d a t a g r o u p local service
	 */
	public vn.dtt.cmon.dm.dao.service.DATAGROUPLocalService getDATAGROUPLocalService() {
		return datagroupLocalService;
	}

	/**
	 * Sets the d a t a g r o u p local service.
	 *
	 * @param datagroupLocalService the d a t a g r o u p local service
	 */
	public void setDATAGROUPLocalService(
		vn.dtt.cmon.dm.dao.service.DATAGROUPLocalService datagroupLocalService) {
		this.datagroupLocalService = datagroupLocalService;
	}

	/**
	 * Returns the d a t a g r o u p persistence.
	 *
	 * @return the d a t a g r o u p persistence
	 */
	public DATAGROUPPersistence getDATAGROUPPersistence() {
		return datagroupPersistence;
	}

	/**
	 * Sets the d a t a g r o u p persistence.
	 *
	 * @param datagroupPersistence the d a t a g r o u p persistence
	 */
	public void setDATAGROUPPersistence(
		DATAGROUPPersistence datagroupPersistence) {
		this.datagroupPersistence = datagroupPersistence;
	}

	/**
	 * Returns the d a t a i t e m local service.
	 *
	 * @return the d a t a i t e m local service
	 */
	public vn.dtt.cmon.dm.dao.service.DATAITEMLocalService getDATAITEMLocalService() {
		return dataitemLocalService;
	}

	/**
	 * Sets the d a t a i t e m local service.
	 *
	 * @param dataitemLocalService the d a t a i t e m local service
	 */
	public void setDATAITEMLocalService(
		vn.dtt.cmon.dm.dao.service.DATAITEMLocalService dataitemLocalService) {
		this.dataitemLocalService = dataitemLocalService;
	}

	/**
	 * Returns the d a t a i t e m persistence.
	 *
	 * @return the d a t a i t e m persistence
	 */
	public DATAITEMPersistence getDATAITEMPersistence() {
		return dataitemPersistence;
	}

	/**
	 * Sets the d a t a i t e m persistence.
	 *
	 * @param dataitemPersistence the d a t a i t e m persistence
	 */
	public void setDATAITEMPersistence(DATAITEMPersistence dataitemPersistence) {
		this.dataitemPersistence = dataitemPersistence;
	}

	/**
	 * Returns the d a t a i t e m finder.
	 *
	 * @return the d a t a i t e m finder
	 */
	public DATAITEMFinder getDATAITEMFinder() {
		return dataitemFinder;
	}

	/**
	 * Sets the d a t a i t e m finder.
	 *
	 * @param dataitemFinder the d a t a i t e m finder
	 */
	public void setDATAITEMFinder(DATAITEMFinder dataitemFinder) {
		this.dataitemFinder = dataitemFinder;
	}

	/**
	 * Returns the n a v i g a t i o n local service.
	 *
	 * @return the n a v i g a t i o n local service
	 */
	public vn.dtt.cmon.dm.dao.service.NAVIGATIONLocalService getNAVIGATIONLocalService() {
		return navigationLocalService;
	}

	/**
	 * Sets the n a v i g a t i o n local service.
	 *
	 * @param navigationLocalService the n a v i g a t i o n local service
	 */
	public void setNAVIGATIONLocalService(
		vn.dtt.cmon.dm.dao.service.NAVIGATIONLocalService navigationLocalService) {
		this.navigationLocalService = navigationLocalService;
	}

	/**
	 * Returns the n a v i g a t i o n persistence.
	 *
	 * @return the n a v i g a t i o n persistence
	 */
	public NAVIGATIONPersistence getNAVIGATIONPersistence() {
		return navigationPersistence;
	}

	/**
	 * Sets the n a v i g a t i o n persistence.
	 *
	 * @param navigationPersistence the n a v i g a t i o n persistence
	 */
	public void setNAVIGATIONPersistence(
		NAVIGATIONPersistence navigationPersistence) {
		this.navigationPersistence = navigationPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("vn.dtt.cmon.dm.dao.model.NAVIGATION",
			navigationLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"vn.dtt.cmon.dm.dao.model.NAVIGATION");
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
		return NAVIGATION.class;
	}

	protected String getModelClassName() {
		return NAVIGATION.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = navigationPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = vn.dtt.cmon.dm.dao.service.DATAGROUPLocalService.class)
	protected vn.dtt.cmon.dm.dao.service.DATAGROUPLocalService datagroupLocalService;
	@BeanReference(type = DATAGROUPPersistence.class)
	protected DATAGROUPPersistence datagroupPersistence;
	@BeanReference(type = vn.dtt.cmon.dm.dao.service.DATAITEMLocalService.class)
	protected vn.dtt.cmon.dm.dao.service.DATAITEMLocalService dataitemLocalService;
	@BeanReference(type = DATAITEMPersistence.class)
	protected DATAITEMPersistence dataitemPersistence;
	@BeanReference(type = DATAITEMFinder.class)
	protected DATAITEMFinder dataitemFinder;
	@BeanReference(type = vn.dtt.cmon.dm.dao.service.NAVIGATIONLocalService.class)
	protected vn.dtt.cmon.dm.dao.service.NAVIGATIONLocalService navigationLocalService;
	@BeanReference(type = NAVIGATIONPersistence.class)
	protected NAVIGATIONPersistence navigationPersistence;
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
	private NAVIGATIONLocalServiceClpInvoker _clpInvoker = new NAVIGATIONLocalServiceClpInvoker();
}