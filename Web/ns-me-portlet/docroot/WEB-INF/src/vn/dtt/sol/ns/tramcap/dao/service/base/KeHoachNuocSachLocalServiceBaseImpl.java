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

package vn.dtt.sol.ns.tramcap.dao.service.base;

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

import vn.dtt.sol.ns.tramcap.dao.model.KeHoachNuocSach;
import vn.dtt.sol.ns.tramcap.dao.service.KeHoachNuocSachLocalService;
import vn.dtt.sol.ns.tramcap.dao.service.persistence.DanhGiaBenVungFinder;
import vn.dtt.sol.ns.tramcap.dao.service.persistence.DanhGiaBenVungPersistence;
import vn.dtt.sol.ns.tramcap.dao.service.persistence.DanhGiaVanHanhFinder;
import vn.dtt.sol.ns.tramcap.dao.service.persistence.DanhGiaVanHanhPersistence;
import vn.dtt.sol.ns.tramcap.dao.service.persistence.DauNoiNuocFinder;
import vn.dtt.sol.ns.tramcap.dao.service.persistence.DauNoiNuocPersistence;
import vn.dtt.sol.ns.tramcap.dao.service.persistence.KeHoachKiemDemNuocFinder;
import vn.dtt.sol.ns.tramcap.dao.service.persistence.KeHoachKiemDemNuocPersistence;
import vn.dtt.sol.ns.tramcap.dao.service.persistence.KeHoachNuocSachPersistence;
import vn.dtt.sol.ns.tramcap.dao.service.persistence.THONGTINKIEMDEMNUOCFinder;
import vn.dtt.sol.ns.tramcap.dao.service.persistence.THONGTINKIEMDEMNUOCPersistence;
import vn.dtt.sol.ns.tramcap.dao.service.persistence.TramCapNuocFinder;
import vn.dtt.sol.ns.tramcap.dao.service.persistence.TramCapNuocPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the ke hoach nuoc sach local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link vn.dtt.sol.ns.tramcap.dao.service.impl.KeHoachNuocSachLocalServiceImpl}.
 * </p>
 *
 * @author khoa.vu
 * @see vn.dtt.sol.ns.tramcap.dao.service.impl.KeHoachNuocSachLocalServiceImpl
 * @see vn.dtt.sol.ns.tramcap.dao.service.KeHoachNuocSachLocalServiceUtil
 * @generated
 */
public abstract class KeHoachNuocSachLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements KeHoachNuocSachLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link vn.dtt.sol.ns.tramcap.dao.service.KeHoachNuocSachLocalServiceUtil} to access the ke hoach nuoc sach local service.
	 */

	/**
	 * Adds the ke hoach nuoc sach to the database. Also notifies the appropriate model listeners.
	 *
	 * @param keHoachNuocSach the ke hoach nuoc sach
	 * @return the ke hoach nuoc sach that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public KeHoachNuocSach addKeHoachNuocSach(KeHoachNuocSach keHoachNuocSach)
		throws SystemException {
		keHoachNuocSach.setNew(true);

		return keHoachNuocSachPersistence.update(keHoachNuocSach);
	}

	/**
	 * Creates a new ke hoach nuoc sach with the primary key. Does not add the ke hoach nuoc sach to the database.
	 *
	 * @param id the primary key for the new ke hoach nuoc sach
	 * @return the new ke hoach nuoc sach
	 */
	@Override
	public KeHoachNuocSach createKeHoachNuocSach(long id) {
		return keHoachNuocSachPersistence.create(id);
	}

	/**
	 * Deletes the ke hoach nuoc sach with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ke hoach nuoc sach
	 * @return the ke hoach nuoc sach that was removed
	 * @throws PortalException if a ke hoach nuoc sach with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public KeHoachNuocSach deleteKeHoachNuocSach(long id)
		throws PortalException, SystemException {
		return keHoachNuocSachPersistence.remove(id);
	}

	/**
	 * Deletes the ke hoach nuoc sach from the database. Also notifies the appropriate model listeners.
	 *
	 * @param keHoachNuocSach the ke hoach nuoc sach
	 * @return the ke hoach nuoc sach that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public KeHoachNuocSach deleteKeHoachNuocSach(
		KeHoachNuocSach keHoachNuocSach) throws SystemException {
		return keHoachNuocSachPersistence.remove(keHoachNuocSach);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(KeHoachNuocSach.class,
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
		return keHoachNuocSachPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.tramcap.dao.model.impl.KeHoachNuocSachModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return keHoachNuocSachPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.tramcap.dao.model.impl.KeHoachNuocSachModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return keHoachNuocSachPersistence.findWithDynamicQuery(dynamicQuery,
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
		return keHoachNuocSachPersistence.countWithDynamicQuery(dynamicQuery);
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
		return keHoachNuocSachPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public KeHoachNuocSach fetchKeHoachNuocSach(long id)
		throws SystemException {
		return keHoachNuocSachPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the ke hoach nuoc sach with the primary key.
	 *
	 * @param id the primary key of the ke hoach nuoc sach
	 * @return the ke hoach nuoc sach
	 * @throws PortalException if a ke hoach nuoc sach with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KeHoachNuocSach getKeHoachNuocSach(long id)
		throws PortalException, SystemException {
		return keHoachNuocSachPersistence.findByPrimaryKey(id);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return keHoachNuocSachPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the ke hoach nuoc sachs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.tramcap.dao.model.impl.KeHoachNuocSachModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ke hoach nuoc sachs
	 * @param end the upper bound of the range of ke hoach nuoc sachs (not inclusive)
	 * @return the range of ke hoach nuoc sachs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KeHoachNuocSach> getKeHoachNuocSachs(int start, int end)
		throws SystemException {
		return keHoachNuocSachPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of ke hoach nuoc sachs.
	 *
	 * @return the number of ke hoach nuoc sachs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getKeHoachNuocSachsCount() throws SystemException {
		return keHoachNuocSachPersistence.countAll();
	}

	/**
	 * Updates the ke hoach nuoc sach in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param keHoachNuocSach the ke hoach nuoc sach
	 * @return the ke hoach nuoc sach that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public KeHoachNuocSach updateKeHoachNuocSach(
		KeHoachNuocSach keHoachNuocSach) throws SystemException {
		return keHoachNuocSachPersistence.update(keHoachNuocSach);
	}

	/**
	 * Returns the danh gia ben vung local service.
	 *
	 * @return the danh gia ben vung local service
	 */
	public vn.dtt.sol.ns.tramcap.dao.service.DanhGiaBenVungLocalService getDanhGiaBenVungLocalService() {
		return danhGiaBenVungLocalService;
	}

	/**
	 * Sets the danh gia ben vung local service.
	 *
	 * @param danhGiaBenVungLocalService the danh gia ben vung local service
	 */
	public void setDanhGiaBenVungLocalService(
		vn.dtt.sol.ns.tramcap.dao.service.DanhGiaBenVungLocalService danhGiaBenVungLocalService) {
		this.danhGiaBenVungLocalService = danhGiaBenVungLocalService;
	}

	/**
	 * Returns the danh gia ben vung persistence.
	 *
	 * @return the danh gia ben vung persistence
	 */
	public DanhGiaBenVungPersistence getDanhGiaBenVungPersistence() {
		return danhGiaBenVungPersistence;
	}

	/**
	 * Sets the danh gia ben vung persistence.
	 *
	 * @param danhGiaBenVungPersistence the danh gia ben vung persistence
	 */
	public void setDanhGiaBenVungPersistence(
		DanhGiaBenVungPersistence danhGiaBenVungPersistence) {
		this.danhGiaBenVungPersistence = danhGiaBenVungPersistence;
	}

	/**
	 * Returns the danh gia ben vung finder.
	 *
	 * @return the danh gia ben vung finder
	 */
	public DanhGiaBenVungFinder getDanhGiaBenVungFinder() {
		return danhGiaBenVungFinder;
	}

	/**
	 * Sets the danh gia ben vung finder.
	 *
	 * @param danhGiaBenVungFinder the danh gia ben vung finder
	 */
	public void setDanhGiaBenVungFinder(
		DanhGiaBenVungFinder danhGiaBenVungFinder) {
		this.danhGiaBenVungFinder = danhGiaBenVungFinder;
	}

	/**
	 * Returns the danh gia van hanh local service.
	 *
	 * @return the danh gia van hanh local service
	 */
	public vn.dtt.sol.ns.tramcap.dao.service.DanhGiaVanHanhLocalService getDanhGiaVanHanhLocalService() {
		return danhGiaVanHanhLocalService;
	}

	/**
	 * Sets the danh gia van hanh local service.
	 *
	 * @param danhGiaVanHanhLocalService the danh gia van hanh local service
	 */
	public void setDanhGiaVanHanhLocalService(
		vn.dtt.sol.ns.tramcap.dao.service.DanhGiaVanHanhLocalService danhGiaVanHanhLocalService) {
		this.danhGiaVanHanhLocalService = danhGiaVanHanhLocalService;
	}

	/**
	 * Returns the danh gia van hanh persistence.
	 *
	 * @return the danh gia van hanh persistence
	 */
	public DanhGiaVanHanhPersistence getDanhGiaVanHanhPersistence() {
		return danhGiaVanHanhPersistence;
	}

	/**
	 * Sets the danh gia van hanh persistence.
	 *
	 * @param danhGiaVanHanhPersistence the danh gia van hanh persistence
	 */
	public void setDanhGiaVanHanhPersistence(
		DanhGiaVanHanhPersistence danhGiaVanHanhPersistence) {
		this.danhGiaVanHanhPersistence = danhGiaVanHanhPersistence;
	}

	/**
	 * Returns the danh gia van hanh finder.
	 *
	 * @return the danh gia van hanh finder
	 */
	public DanhGiaVanHanhFinder getDanhGiaVanHanhFinder() {
		return danhGiaVanHanhFinder;
	}

	/**
	 * Sets the danh gia van hanh finder.
	 *
	 * @param danhGiaVanHanhFinder the danh gia van hanh finder
	 */
	public void setDanhGiaVanHanhFinder(
		DanhGiaVanHanhFinder danhGiaVanHanhFinder) {
		this.danhGiaVanHanhFinder = danhGiaVanHanhFinder;
	}

	/**
	 * Returns the dau noi nuoc local service.
	 *
	 * @return the dau noi nuoc local service
	 */
	public vn.dtt.sol.ns.tramcap.dao.service.DauNoiNuocLocalService getDauNoiNuocLocalService() {
		return dauNoiNuocLocalService;
	}

	/**
	 * Sets the dau noi nuoc local service.
	 *
	 * @param dauNoiNuocLocalService the dau noi nuoc local service
	 */
	public void setDauNoiNuocLocalService(
		vn.dtt.sol.ns.tramcap.dao.service.DauNoiNuocLocalService dauNoiNuocLocalService) {
		this.dauNoiNuocLocalService = dauNoiNuocLocalService;
	}

	/**
	 * Returns the dau noi nuoc persistence.
	 *
	 * @return the dau noi nuoc persistence
	 */
	public DauNoiNuocPersistence getDauNoiNuocPersistence() {
		return dauNoiNuocPersistence;
	}

	/**
	 * Sets the dau noi nuoc persistence.
	 *
	 * @param dauNoiNuocPersistence the dau noi nuoc persistence
	 */
	public void setDauNoiNuocPersistence(
		DauNoiNuocPersistence dauNoiNuocPersistence) {
		this.dauNoiNuocPersistence = dauNoiNuocPersistence;
	}

	/**
	 * Returns the dau noi nuoc finder.
	 *
	 * @return the dau noi nuoc finder
	 */
	public DauNoiNuocFinder getDauNoiNuocFinder() {
		return dauNoiNuocFinder;
	}

	/**
	 * Sets the dau noi nuoc finder.
	 *
	 * @param dauNoiNuocFinder the dau noi nuoc finder
	 */
	public void setDauNoiNuocFinder(DauNoiNuocFinder dauNoiNuocFinder) {
		this.dauNoiNuocFinder = dauNoiNuocFinder;
	}

	/**
	 * Returns the ke hoach kiem dem nuoc local service.
	 *
	 * @return the ke hoach kiem dem nuoc local service
	 */
	public vn.dtt.sol.ns.tramcap.dao.service.KeHoachKiemDemNuocLocalService getKeHoachKiemDemNuocLocalService() {
		return keHoachKiemDemNuocLocalService;
	}

	/**
	 * Sets the ke hoach kiem dem nuoc local service.
	 *
	 * @param keHoachKiemDemNuocLocalService the ke hoach kiem dem nuoc local service
	 */
	public void setKeHoachKiemDemNuocLocalService(
		vn.dtt.sol.ns.tramcap.dao.service.KeHoachKiemDemNuocLocalService keHoachKiemDemNuocLocalService) {
		this.keHoachKiemDemNuocLocalService = keHoachKiemDemNuocLocalService;
	}

	/**
	 * Returns the ke hoach kiem dem nuoc persistence.
	 *
	 * @return the ke hoach kiem dem nuoc persistence
	 */
	public KeHoachKiemDemNuocPersistence getKeHoachKiemDemNuocPersistence() {
		return keHoachKiemDemNuocPersistence;
	}

	/**
	 * Sets the ke hoach kiem dem nuoc persistence.
	 *
	 * @param keHoachKiemDemNuocPersistence the ke hoach kiem dem nuoc persistence
	 */
	public void setKeHoachKiemDemNuocPersistence(
		KeHoachKiemDemNuocPersistence keHoachKiemDemNuocPersistence) {
		this.keHoachKiemDemNuocPersistence = keHoachKiemDemNuocPersistence;
	}

	/**
	 * Returns the ke hoach kiem dem nuoc finder.
	 *
	 * @return the ke hoach kiem dem nuoc finder
	 */
	public KeHoachKiemDemNuocFinder getKeHoachKiemDemNuocFinder() {
		return keHoachKiemDemNuocFinder;
	}

	/**
	 * Sets the ke hoach kiem dem nuoc finder.
	 *
	 * @param keHoachKiemDemNuocFinder the ke hoach kiem dem nuoc finder
	 */
	public void setKeHoachKiemDemNuocFinder(
		KeHoachKiemDemNuocFinder keHoachKiemDemNuocFinder) {
		this.keHoachKiemDemNuocFinder = keHoachKiemDemNuocFinder;
	}

	/**
	 * Returns the ke hoach nuoc sach local service.
	 *
	 * @return the ke hoach nuoc sach local service
	 */
	public vn.dtt.sol.ns.tramcap.dao.service.KeHoachNuocSachLocalService getKeHoachNuocSachLocalService() {
		return keHoachNuocSachLocalService;
	}

	/**
	 * Sets the ke hoach nuoc sach local service.
	 *
	 * @param keHoachNuocSachLocalService the ke hoach nuoc sach local service
	 */
	public void setKeHoachNuocSachLocalService(
		vn.dtt.sol.ns.tramcap.dao.service.KeHoachNuocSachLocalService keHoachNuocSachLocalService) {
		this.keHoachNuocSachLocalService = keHoachNuocSachLocalService;
	}

	/**
	 * Returns the ke hoach nuoc sach persistence.
	 *
	 * @return the ke hoach nuoc sach persistence
	 */
	public KeHoachNuocSachPersistence getKeHoachNuocSachPersistence() {
		return keHoachNuocSachPersistence;
	}

	/**
	 * Sets the ke hoach nuoc sach persistence.
	 *
	 * @param keHoachNuocSachPersistence the ke hoach nuoc sach persistence
	 */
	public void setKeHoachNuocSachPersistence(
		KeHoachNuocSachPersistence keHoachNuocSachPersistence) {
		this.keHoachNuocSachPersistence = keHoachNuocSachPersistence;
	}

	/**
	 * Returns the t h o n g t i n k i e m d e m n u o c local service.
	 *
	 * @return the t h o n g t i n k i e m d e m n u o c local service
	 */
	public vn.dtt.sol.ns.tramcap.dao.service.THONGTINKIEMDEMNUOCLocalService getTHONGTINKIEMDEMNUOCLocalService() {
		return thongtinkiemdemnuocLocalService;
	}

	/**
	 * Sets the t h o n g t i n k i e m d e m n u o c local service.
	 *
	 * @param thongtinkiemdemnuocLocalService the t h o n g t i n k i e m d e m n u o c local service
	 */
	public void setTHONGTINKIEMDEMNUOCLocalService(
		vn.dtt.sol.ns.tramcap.dao.service.THONGTINKIEMDEMNUOCLocalService thongtinkiemdemnuocLocalService) {
		this.thongtinkiemdemnuocLocalService = thongtinkiemdemnuocLocalService;
	}

	/**
	 * Returns the t h o n g t i n k i e m d e m n u o c persistence.
	 *
	 * @return the t h o n g t i n k i e m d e m n u o c persistence
	 */
	public THONGTINKIEMDEMNUOCPersistence getTHONGTINKIEMDEMNUOCPersistence() {
		return thongtinkiemdemnuocPersistence;
	}

	/**
	 * Sets the t h o n g t i n k i e m d e m n u o c persistence.
	 *
	 * @param thongtinkiemdemnuocPersistence the t h o n g t i n k i e m d e m n u o c persistence
	 */
	public void setTHONGTINKIEMDEMNUOCPersistence(
		THONGTINKIEMDEMNUOCPersistence thongtinkiemdemnuocPersistence) {
		this.thongtinkiemdemnuocPersistence = thongtinkiemdemnuocPersistence;
	}

	/**
	 * Returns the t h o n g t i n k i e m d e m n u o c finder.
	 *
	 * @return the t h o n g t i n k i e m d e m n u o c finder
	 */
	public THONGTINKIEMDEMNUOCFinder getTHONGTINKIEMDEMNUOCFinder() {
		return thongtinkiemdemnuocFinder;
	}

	/**
	 * Sets the t h o n g t i n k i e m d e m n u o c finder.
	 *
	 * @param thongtinkiemdemnuocFinder the t h o n g t i n k i e m d e m n u o c finder
	 */
	public void setTHONGTINKIEMDEMNUOCFinder(
		THONGTINKIEMDEMNUOCFinder thongtinkiemdemnuocFinder) {
		this.thongtinkiemdemnuocFinder = thongtinkiemdemnuocFinder;
	}

	/**
	 * Returns the tram cap nuoc local service.
	 *
	 * @return the tram cap nuoc local service
	 */
	public vn.dtt.sol.ns.tramcap.dao.service.TramCapNuocLocalService getTramCapNuocLocalService() {
		return tramCapNuocLocalService;
	}

	/**
	 * Sets the tram cap nuoc local service.
	 *
	 * @param tramCapNuocLocalService the tram cap nuoc local service
	 */
	public void setTramCapNuocLocalService(
		vn.dtt.sol.ns.tramcap.dao.service.TramCapNuocLocalService tramCapNuocLocalService) {
		this.tramCapNuocLocalService = tramCapNuocLocalService;
	}

	/**
	 * Returns the tram cap nuoc persistence.
	 *
	 * @return the tram cap nuoc persistence
	 */
	public TramCapNuocPersistence getTramCapNuocPersistence() {
		return tramCapNuocPersistence;
	}

	/**
	 * Sets the tram cap nuoc persistence.
	 *
	 * @param tramCapNuocPersistence the tram cap nuoc persistence
	 */
	public void setTramCapNuocPersistence(
		TramCapNuocPersistence tramCapNuocPersistence) {
		this.tramCapNuocPersistence = tramCapNuocPersistence;
	}

	/**
	 * Returns the tram cap nuoc finder.
	 *
	 * @return the tram cap nuoc finder
	 */
	public TramCapNuocFinder getTramCapNuocFinder() {
		return tramCapNuocFinder;
	}

	/**
	 * Sets the tram cap nuoc finder.
	 *
	 * @param tramCapNuocFinder the tram cap nuoc finder
	 */
	public void setTramCapNuocFinder(TramCapNuocFinder tramCapNuocFinder) {
		this.tramCapNuocFinder = tramCapNuocFinder;
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

		PersistedModelLocalServiceRegistryUtil.register("vn.dtt.sol.ns.tramcap.dao.model.KeHoachNuocSach",
			keHoachNuocSachLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"vn.dtt.sol.ns.tramcap.dao.model.KeHoachNuocSach");
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
		return KeHoachNuocSach.class;
	}

	protected String getModelClassName() {
		return KeHoachNuocSach.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = keHoachNuocSachPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = vn.dtt.sol.ns.tramcap.dao.service.DanhGiaBenVungLocalService.class)
	protected vn.dtt.sol.ns.tramcap.dao.service.DanhGiaBenVungLocalService danhGiaBenVungLocalService;
	@BeanReference(type = DanhGiaBenVungPersistence.class)
	protected DanhGiaBenVungPersistence danhGiaBenVungPersistence;
	@BeanReference(type = DanhGiaBenVungFinder.class)
	protected DanhGiaBenVungFinder danhGiaBenVungFinder;
	@BeanReference(type = vn.dtt.sol.ns.tramcap.dao.service.DanhGiaVanHanhLocalService.class)
	protected vn.dtt.sol.ns.tramcap.dao.service.DanhGiaVanHanhLocalService danhGiaVanHanhLocalService;
	@BeanReference(type = DanhGiaVanHanhPersistence.class)
	protected DanhGiaVanHanhPersistence danhGiaVanHanhPersistence;
	@BeanReference(type = DanhGiaVanHanhFinder.class)
	protected DanhGiaVanHanhFinder danhGiaVanHanhFinder;
	@BeanReference(type = vn.dtt.sol.ns.tramcap.dao.service.DauNoiNuocLocalService.class)
	protected vn.dtt.sol.ns.tramcap.dao.service.DauNoiNuocLocalService dauNoiNuocLocalService;
	@BeanReference(type = DauNoiNuocPersistence.class)
	protected DauNoiNuocPersistence dauNoiNuocPersistence;
	@BeanReference(type = DauNoiNuocFinder.class)
	protected DauNoiNuocFinder dauNoiNuocFinder;
	@BeanReference(type = vn.dtt.sol.ns.tramcap.dao.service.KeHoachKiemDemNuocLocalService.class)
	protected vn.dtt.sol.ns.tramcap.dao.service.KeHoachKiemDemNuocLocalService keHoachKiemDemNuocLocalService;
	@BeanReference(type = KeHoachKiemDemNuocPersistence.class)
	protected KeHoachKiemDemNuocPersistence keHoachKiemDemNuocPersistence;
	@BeanReference(type = KeHoachKiemDemNuocFinder.class)
	protected KeHoachKiemDemNuocFinder keHoachKiemDemNuocFinder;
	@BeanReference(type = vn.dtt.sol.ns.tramcap.dao.service.KeHoachNuocSachLocalService.class)
	protected vn.dtt.sol.ns.tramcap.dao.service.KeHoachNuocSachLocalService keHoachNuocSachLocalService;
	@BeanReference(type = KeHoachNuocSachPersistence.class)
	protected KeHoachNuocSachPersistence keHoachNuocSachPersistence;
	@BeanReference(type = vn.dtt.sol.ns.tramcap.dao.service.THONGTINKIEMDEMNUOCLocalService.class)
	protected vn.dtt.sol.ns.tramcap.dao.service.THONGTINKIEMDEMNUOCLocalService thongtinkiemdemnuocLocalService;
	@BeanReference(type = THONGTINKIEMDEMNUOCPersistence.class)
	protected THONGTINKIEMDEMNUOCPersistence thongtinkiemdemnuocPersistence;
	@BeanReference(type = THONGTINKIEMDEMNUOCFinder.class)
	protected THONGTINKIEMDEMNUOCFinder thongtinkiemdemnuocFinder;
	@BeanReference(type = vn.dtt.sol.ns.tramcap.dao.service.TramCapNuocLocalService.class)
	protected vn.dtt.sol.ns.tramcap.dao.service.TramCapNuocLocalService tramCapNuocLocalService;
	@BeanReference(type = TramCapNuocPersistence.class)
	protected TramCapNuocPersistence tramCapNuocPersistence;
	@BeanReference(type = TramCapNuocFinder.class)
	protected TramCapNuocFinder tramCapNuocFinder;
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
	private KeHoachNuocSachLocalServiceClpInvoker _clpInvoker = new KeHoachNuocSachLocalServiceClpInvoker();
}