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

package vn.dtt.cmon.kiemdemvien.dao.service.base;

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

import vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien;
import vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalService;
import vn.dtt.cmon.kiemdemvien.dao.service.persistence.KiemDemVienFinder;
import vn.dtt.cmon.kiemdemvien.dao.service.persistence.KiemDemVienPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the kiem dem vien local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link vn.dtt.cmon.kiemdemvien.dao.service.impl.KiemDemVienLocalServiceImpl}.
 * </p>
 *
 * @author HANT
 * @see vn.dtt.cmon.kiemdemvien.dao.service.impl.KiemDemVienLocalServiceImpl
 * @see vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalServiceUtil
 * @generated
 */
public abstract class KiemDemVienLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements KiemDemVienLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalServiceUtil} to access the kiem dem vien local service.
	 */

	/**
	 * Adds the kiem dem vien to the database. Also notifies the appropriate model listeners.
	 *
	 * @param kiemDemVien the kiem dem vien
	 * @return the kiem dem vien that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public KiemDemVien addKiemDemVien(KiemDemVien kiemDemVien)
		throws SystemException {
		kiemDemVien.setNew(true);

		return kiemDemVienPersistence.update(kiemDemVien);
	}

	/**
	 * Creates a new kiem dem vien with the primary key. Does not add the kiem dem vien to the database.
	 *
	 * @param id the primary key for the new kiem dem vien
	 * @return the new kiem dem vien
	 */
	@Override
	public KiemDemVien createKiemDemVien(long id) {
		return kiemDemVienPersistence.create(id);
	}

	/**
	 * Deletes the kiem dem vien with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the kiem dem vien
	 * @return the kiem dem vien that was removed
	 * @throws PortalException if a kiem dem vien with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public KiemDemVien deleteKiemDemVien(long id)
		throws PortalException, SystemException {
		return kiemDemVienPersistence.remove(id);
	}

	/**
	 * Deletes the kiem dem vien from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kiemDemVien the kiem dem vien
	 * @return the kiem dem vien that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public KiemDemVien deleteKiemDemVien(KiemDemVien kiemDemVien)
		throws SystemException {
		return kiemDemVienPersistence.remove(kiemDemVien);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(KiemDemVien.class,
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
		return kiemDemVienPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.kiemdemvien.dao.model.impl.KiemDemVienModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return kiemDemVienPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.kiemdemvien.dao.model.impl.KiemDemVienModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return kiemDemVienPersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return kiemDemVienPersistence.countWithDynamicQuery(dynamicQuery);
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
		return kiemDemVienPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public KiemDemVien fetchKiemDemVien(long id) throws SystemException {
		return kiemDemVienPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the kiem dem vien with the primary key.
	 *
	 * @param id the primary key of the kiem dem vien
	 * @return the kiem dem vien
	 * @throws PortalException if a kiem dem vien with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KiemDemVien getKiemDemVien(long id)
		throws PortalException, SystemException {
		return kiemDemVienPersistence.findByPrimaryKey(id);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return kiemDemVienPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the kiem dem viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.kiemdemvien.dao.model.impl.KiemDemVienModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kiem dem viens
	 * @param end the upper bound of the range of kiem dem viens (not inclusive)
	 * @return the range of kiem dem viens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KiemDemVien> getKiemDemViens(int start, int end)
		throws SystemException {
		return kiemDemVienPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of kiem dem viens.
	 *
	 * @return the number of kiem dem viens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getKiemDemViensCount() throws SystemException {
		return kiemDemVienPersistence.countAll();
	}

	/**
	 * Updates the kiem dem vien in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param kiemDemVien the kiem dem vien
	 * @return the kiem dem vien that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public KiemDemVien updateKiemDemVien(KiemDemVien kiemDemVien)
		throws SystemException {
		return kiemDemVienPersistence.update(kiemDemVien);
	}

	/**
	 * Returns the kiem dem vien local service.
	 *
	 * @return the kiem dem vien local service
	 */
	public vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalService getKiemDemVienLocalService() {
		return kiemDemVienLocalService;
	}

	/**
	 * Sets the kiem dem vien local service.
	 *
	 * @param kiemDemVienLocalService the kiem dem vien local service
	 */
	public void setKiemDemVienLocalService(
		vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalService kiemDemVienLocalService) {
		this.kiemDemVienLocalService = kiemDemVienLocalService;
	}

	/**
	 * Returns the kiem dem vien persistence.
	 *
	 * @return the kiem dem vien persistence
	 */
	public KiemDemVienPersistence getKiemDemVienPersistence() {
		return kiemDemVienPersistence;
	}

	/**
	 * Sets the kiem dem vien persistence.
	 *
	 * @param kiemDemVienPersistence the kiem dem vien persistence
	 */
	public void setKiemDemVienPersistence(
		KiemDemVienPersistence kiemDemVienPersistence) {
		this.kiemDemVienPersistence = kiemDemVienPersistence;
	}

	/**
	 * Returns the kiem dem vien finder.
	 *
	 * @return the kiem dem vien finder
	 */
	public KiemDemVienFinder getKiemDemVienFinder() {
		return kiemDemVienFinder;
	}

	/**
	 * Sets the kiem dem vien finder.
	 *
	 * @param kiemDemVienFinder the kiem dem vien finder
	 */
	public void setKiemDemVienFinder(KiemDemVienFinder kiemDemVienFinder) {
		this.kiemDemVienFinder = kiemDemVienFinder;
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

		PersistedModelLocalServiceRegistryUtil.register("vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien",
			kiemDemVienLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"vn.dtt.cmon.kiemdemvien.dao.model.KiemDemVien");
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
		return KiemDemVien.class;
	}

	protected String getModelClassName() {
		return KiemDemVien.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = kiemDemVienPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalService.class)
	protected vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalService kiemDemVienLocalService;
	@BeanReference(type = KiemDemVienPersistence.class)
	protected KiemDemVienPersistence kiemDemVienPersistence;
	@BeanReference(type = KiemDemVienFinder.class)
	protected KiemDemVienFinder kiemDemVienFinder;
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
	private KiemDemVienLocalServiceClpInvoker _clpInvoker = new KiemDemVienLocalServiceClpInvoker();
}