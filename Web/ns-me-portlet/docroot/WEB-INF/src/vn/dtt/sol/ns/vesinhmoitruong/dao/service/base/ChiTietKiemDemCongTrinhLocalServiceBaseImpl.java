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

package vn.dtt.sol.ns.vesinhmoitruong.dao.service.base;

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

import vn.dtt.sol.ns.vesinhmoitruong.dao.model.ChiTietKiemDemCongTrinh;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.ChiTietKiemDemCongTrinhLocalService;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence.ChiTietKiemDemCongTrinhPersistence;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence.DanhGiaVeSinhXaNewFakeFinder;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence.DanhGiaVeSinhXaNewFakePersistence;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence.DanhGiaVeSinhXaNewPersistence;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence.KeHoachKiemDemVeSinhFinder;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence.KeHoachKiemDemVeSinhPersistence;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence.ThongTinKiemDemCongTrinhFinder;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence.ThongTinKiemDemCongTrinhPersistence;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence.ThongTinKiemDemHoGDFinder;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence.ThongTinKiemDemHoGDPersistence;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence.VeSinhCongTrinhFinder;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence.VeSinhCongTrinhPersistence;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence.VeSinhGiaDinhFinder;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence.VeSinhGiaDinhPersistence;
import vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence.keHoachVeSinhXaNewPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the chi tiet kiem dem cong trinh local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link vn.dtt.sol.ns.vesinhmoitruong.dao.service.impl.ChiTietKiemDemCongTrinhLocalServiceImpl}.
 * </p>
 *
 * @author BinhTH
 * @see vn.dtt.sol.ns.vesinhmoitruong.dao.service.impl.ChiTietKiemDemCongTrinhLocalServiceImpl
 * @see vn.dtt.sol.ns.vesinhmoitruong.dao.service.ChiTietKiemDemCongTrinhLocalServiceUtil
 * @generated
 */
public abstract class ChiTietKiemDemCongTrinhLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ChiTietKiemDemCongTrinhLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link vn.dtt.sol.ns.vesinhmoitruong.dao.service.ChiTietKiemDemCongTrinhLocalServiceUtil} to access the chi tiet kiem dem cong trinh local service.
	 */

	/**
	 * Adds the chi tiet kiem dem cong trinh to the database. Also notifies the appropriate model listeners.
	 *
	 * @param chiTietKiemDemCongTrinh the chi tiet kiem dem cong trinh
	 * @return the chi tiet kiem dem cong trinh that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ChiTietKiemDemCongTrinh addChiTietKiemDemCongTrinh(
		ChiTietKiemDemCongTrinh chiTietKiemDemCongTrinh)
		throws SystemException {
		chiTietKiemDemCongTrinh.setNew(true);

		return chiTietKiemDemCongTrinhPersistence.update(chiTietKiemDemCongTrinh);
	}

	/**
	 * Creates a new chi tiet kiem dem cong trinh with the primary key. Does not add the chi tiet kiem dem cong trinh to the database.
	 *
	 * @param id the primary key for the new chi tiet kiem dem cong trinh
	 * @return the new chi tiet kiem dem cong trinh
	 */
	@Override
	public ChiTietKiemDemCongTrinh createChiTietKiemDemCongTrinh(int id) {
		return chiTietKiemDemCongTrinhPersistence.create(id);
	}

	/**
	 * Deletes the chi tiet kiem dem cong trinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chi tiet kiem dem cong trinh
	 * @return the chi tiet kiem dem cong trinh that was removed
	 * @throws PortalException if a chi tiet kiem dem cong trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ChiTietKiemDemCongTrinh deleteChiTietKiemDemCongTrinh(int id)
		throws PortalException, SystemException {
		return chiTietKiemDemCongTrinhPersistence.remove(id);
	}

	/**
	 * Deletes the chi tiet kiem dem cong trinh from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chiTietKiemDemCongTrinh the chi tiet kiem dem cong trinh
	 * @return the chi tiet kiem dem cong trinh that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ChiTietKiemDemCongTrinh deleteChiTietKiemDemCongTrinh(
		ChiTietKiemDemCongTrinh chiTietKiemDemCongTrinh)
		throws SystemException {
		return chiTietKiemDemCongTrinhPersistence.remove(chiTietKiemDemCongTrinh);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ChiTietKiemDemCongTrinh.class,
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
		return chiTietKiemDemCongTrinhPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl.ChiTietKiemDemCongTrinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return chiTietKiemDemCongTrinhPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl.ChiTietKiemDemCongTrinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return chiTietKiemDemCongTrinhPersistence.findWithDynamicQuery(dynamicQuery,
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
		return chiTietKiemDemCongTrinhPersistence.countWithDynamicQuery(dynamicQuery);
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
		return chiTietKiemDemCongTrinhPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ChiTietKiemDemCongTrinh fetchChiTietKiemDemCongTrinh(int id)
		throws SystemException {
		return chiTietKiemDemCongTrinhPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the chi tiet kiem dem cong trinh with the primary key.
	 *
	 * @param id the primary key of the chi tiet kiem dem cong trinh
	 * @return the chi tiet kiem dem cong trinh
	 * @throws PortalException if a chi tiet kiem dem cong trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietKiemDemCongTrinh getChiTietKiemDemCongTrinh(int id)
		throws PortalException, SystemException {
		return chiTietKiemDemCongTrinhPersistence.findByPrimaryKey(id);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return chiTietKiemDemCongTrinhPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the chi tiet kiem dem cong trinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl.ChiTietKiemDemCongTrinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chi tiet kiem dem cong trinhs
	 * @param end the upper bound of the range of chi tiet kiem dem cong trinhs (not inclusive)
	 * @return the range of chi tiet kiem dem cong trinhs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChiTietKiemDemCongTrinh> getChiTietKiemDemCongTrinhs(
		int start, int end) throws SystemException {
		return chiTietKiemDemCongTrinhPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of chi tiet kiem dem cong trinhs.
	 *
	 * @return the number of chi tiet kiem dem cong trinhs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getChiTietKiemDemCongTrinhsCount() throws SystemException {
		return chiTietKiemDemCongTrinhPersistence.countAll();
	}

	/**
	 * Updates the chi tiet kiem dem cong trinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param chiTietKiemDemCongTrinh the chi tiet kiem dem cong trinh
	 * @return the chi tiet kiem dem cong trinh that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ChiTietKiemDemCongTrinh updateChiTietKiemDemCongTrinh(
		ChiTietKiemDemCongTrinh chiTietKiemDemCongTrinh)
		throws SystemException {
		return chiTietKiemDemCongTrinhPersistence.update(chiTietKiemDemCongTrinh);
	}

	/**
	 * Returns the chi tiet kiem dem cong trinh local service.
	 *
	 * @return the chi tiet kiem dem cong trinh local service
	 */
	public vn.dtt.sol.ns.vesinhmoitruong.dao.service.ChiTietKiemDemCongTrinhLocalService getChiTietKiemDemCongTrinhLocalService() {
		return chiTietKiemDemCongTrinhLocalService;
	}

	/**
	 * Sets the chi tiet kiem dem cong trinh local service.
	 *
	 * @param chiTietKiemDemCongTrinhLocalService the chi tiet kiem dem cong trinh local service
	 */
	public void setChiTietKiemDemCongTrinhLocalService(
		vn.dtt.sol.ns.vesinhmoitruong.dao.service.ChiTietKiemDemCongTrinhLocalService chiTietKiemDemCongTrinhLocalService) {
		this.chiTietKiemDemCongTrinhLocalService = chiTietKiemDemCongTrinhLocalService;
	}

	/**
	 * Returns the chi tiet kiem dem cong trinh persistence.
	 *
	 * @return the chi tiet kiem dem cong trinh persistence
	 */
	public ChiTietKiemDemCongTrinhPersistence getChiTietKiemDemCongTrinhPersistence() {
		return chiTietKiemDemCongTrinhPersistence;
	}

	/**
	 * Sets the chi tiet kiem dem cong trinh persistence.
	 *
	 * @param chiTietKiemDemCongTrinhPersistence the chi tiet kiem dem cong trinh persistence
	 */
	public void setChiTietKiemDemCongTrinhPersistence(
		ChiTietKiemDemCongTrinhPersistence chiTietKiemDemCongTrinhPersistence) {
		this.chiTietKiemDemCongTrinhPersistence = chiTietKiemDemCongTrinhPersistence;
	}

	/**
	 * Returns the danh gia ve sinh xa new local service.
	 *
	 * @return the danh gia ve sinh xa new local service
	 */
	public vn.dtt.sol.ns.vesinhmoitruong.dao.service.DanhGiaVeSinhXaNewLocalService getDanhGiaVeSinhXaNewLocalService() {
		return danhGiaVeSinhXaNewLocalService;
	}

	/**
	 * Sets the danh gia ve sinh xa new local service.
	 *
	 * @param danhGiaVeSinhXaNewLocalService the danh gia ve sinh xa new local service
	 */
	public void setDanhGiaVeSinhXaNewLocalService(
		vn.dtt.sol.ns.vesinhmoitruong.dao.service.DanhGiaVeSinhXaNewLocalService danhGiaVeSinhXaNewLocalService) {
		this.danhGiaVeSinhXaNewLocalService = danhGiaVeSinhXaNewLocalService;
	}

	/**
	 * Returns the danh gia ve sinh xa new persistence.
	 *
	 * @return the danh gia ve sinh xa new persistence
	 */
	public DanhGiaVeSinhXaNewPersistence getDanhGiaVeSinhXaNewPersistence() {
		return danhGiaVeSinhXaNewPersistence;
	}

	/**
	 * Sets the danh gia ve sinh xa new persistence.
	 *
	 * @param danhGiaVeSinhXaNewPersistence the danh gia ve sinh xa new persistence
	 */
	public void setDanhGiaVeSinhXaNewPersistence(
		DanhGiaVeSinhXaNewPersistence danhGiaVeSinhXaNewPersistence) {
		this.danhGiaVeSinhXaNewPersistence = danhGiaVeSinhXaNewPersistence;
	}

	/**
	 * Returns the danh gia ve sinh xa new fake local service.
	 *
	 * @return the danh gia ve sinh xa new fake local service
	 */
	public vn.dtt.sol.ns.vesinhmoitruong.dao.service.DanhGiaVeSinhXaNewFakeLocalService getDanhGiaVeSinhXaNewFakeLocalService() {
		return danhGiaVeSinhXaNewFakeLocalService;
	}

	/**
	 * Sets the danh gia ve sinh xa new fake local service.
	 *
	 * @param danhGiaVeSinhXaNewFakeLocalService the danh gia ve sinh xa new fake local service
	 */
	public void setDanhGiaVeSinhXaNewFakeLocalService(
		vn.dtt.sol.ns.vesinhmoitruong.dao.service.DanhGiaVeSinhXaNewFakeLocalService danhGiaVeSinhXaNewFakeLocalService) {
		this.danhGiaVeSinhXaNewFakeLocalService = danhGiaVeSinhXaNewFakeLocalService;
	}

	/**
	 * Returns the danh gia ve sinh xa new fake persistence.
	 *
	 * @return the danh gia ve sinh xa new fake persistence
	 */
	public DanhGiaVeSinhXaNewFakePersistence getDanhGiaVeSinhXaNewFakePersistence() {
		return danhGiaVeSinhXaNewFakePersistence;
	}

	/**
	 * Sets the danh gia ve sinh xa new fake persistence.
	 *
	 * @param danhGiaVeSinhXaNewFakePersistence the danh gia ve sinh xa new fake persistence
	 */
	public void setDanhGiaVeSinhXaNewFakePersistence(
		DanhGiaVeSinhXaNewFakePersistence danhGiaVeSinhXaNewFakePersistence) {
		this.danhGiaVeSinhXaNewFakePersistence = danhGiaVeSinhXaNewFakePersistence;
	}

	/**
	 * Returns the danh gia ve sinh xa new fake finder.
	 *
	 * @return the danh gia ve sinh xa new fake finder
	 */
	public DanhGiaVeSinhXaNewFakeFinder getDanhGiaVeSinhXaNewFakeFinder() {
		return danhGiaVeSinhXaNewFakeFinder;
	}

	/**
	 * Sets the danh gia ve sinh xa new fake finder.
	 *
	 * @param danhGiaVeSinhXaNewFakeFinder the danh gia ve sinh xa new fake finder
	 */
	public void setDanhGiaVeSinhXaNewFakeFinder(
		DanhGiaVeSinhXaNewFakeFinder danhGiaVeSinhXaNewFakeFinder) {
		this.danhGiaVeSinhXaNewFakeFinder = danhGiaVeSinhXaNewFakeFinder;
	}

	/**
	 * Returns the ke hoach kiem dem ve sinh local service.
	 *
	 * @return the ke hoach kiem dem ve sinh local service
	 */
	public vn.dtt.sol.ns.vesinhmoitruong.dao.service.KeHoachKiemDemVeSinhLocalService getKeHoachKiemDemVeSinhLocalService() {
		return keHoachKiemDemVeSinhLocalService;
	}

	/**
	 * Sets the ke hoach kiem dem ve sinh local service.
	 *
	 * @param keHoachKiemDemVeSinhLocalService the ke hoach kiem dem ve sinh local service
	 */
	public void setKeHoachKiemDemVeSinhLocalService(
		vn.dtt.sol.ns.vesinhmoitruong.dao.service.KeHoachKiemDemVeSinhLocalService keHoachKiemDemVeSinhLocalService) {
		this.keHoachKiemDemVeSinhLocalService = keHoachKiemDemVeSinhLocalService;
	}

	/**
	 * Returns the ke hoach kiem dem ve sinh persistence.
	 *
	 * @return the ke hoach kiem dem ve sinh persistence
	 */
	public KeHoachKiemDemVeSinhPersistence getKeHoachKiemDemVeSinhPersistence() {
		return keHoachKiemDemVeSinhPersistence;
	}

	/**
	 * Sets the ke hoach kiem dem ve sinh persistence.
	 *
	 * @param keHoachKiemDemVeSinhPersistence the ke hoach kiem dem ve sinh persistence
	 */
	public void setKeHoachKiemDemVeSinhPersistence(
		KeHoachKiemDemVeSinhPersistence keHoachKiemDemVeSinhPersistence) {
		this.keHoachKiemDemVeSinhPersistence = keHoachKiemDemVeSinhPersistence;
	}

	/**
	 * Returns the ke hoach kiem dem ve sinh finder.
	 *
	 * @return the ke hoach kiem dem ve sinh finder
	 */
	public KeHoachKiemDemVeSinhFinder getKeHoachKiemDemVeSinhFinder() {
		return keHoachKiemDemVeSinhFinder;
	}

	/**
	 * Sets the ke hoach kiem dem ve sinh finder.
	 *
	 * @param keHoachKiemDemVeSinhFinder the ke hoach kiem dem ve sinh finder
	 */
	public void setKeHoachKiemDemVeSinhFinder(
		KeHoachKiemDemVeSinhFinder keHoachKiemDemVeSinhFinder) {
		this.keHoachKiemDemVeSinhFinder = keHoachKiemDemVeSinhFinder;
	}

	/**
	 * Returns the ke hoach ve sinh xa new local service.
	 *
	 * @return the ke hoach ve sinh xa new local service
	 */
	public vn.dtt.sol.ns.vesinhmoitruong.dao.service.keHoachVeSinhXaNewLocalService getkeHoachVeSinhXaNewLocalService() {
		return keHoachVeSinhXaNewLocalService;
	}

	/**
	 * Sets the ke hoach ve sinh xa new local service.
	 *
	 * @param keHoachVeSinhXaNewLocalService the ke hoach ve sinh xa new local service
	 */
	public void setkeHoachVeSinhXaNewLocalService(
		vn.dtt.sol.ns.vesinhmoitruong.dao.service.keHoachVeSinhXaNewLocalService keHoachVeSinhXaNewLocalService) {
		this.keHoachVeSinhXaNewLocalService = keHoachVeSinhXaNewLocalService;
	}

	/**
	 * Returns the ke hoach ve sinh xa new persistence.
	 *
	 * @return the ke hoach ve sinh xa new persistence
	 */
	public keHoachVeSinhXaNewPersistence getkeHoachVeSinhXaNewPersistence() {
		return keHoachVeSinhXaNewPersistence;
	}

	/**
	 * Sets the ke hoach ve sinh xa new persistence.
	 *
	 * @param keHoachVeSinhXaNewPersistence the ke hoach ve sinh xa new persistence
	 */
	public void setkeHoachVeSinhXaNewPersistence(
		keHoachVeSinhXaNewPersistence keHoachVeSinhXaNewPersistence) {
		this.keHoachVeSinhXaNewPersistence = keHoachVeSinhXaNewPersistence;
	}

	/**
	 * Returns the thong tin kiem dem cong trinh local service.
	 *
	 * @return the thong tin kiem dem cong trinh local service
	 */
	public vn.dtt.sol.ns.vesinhmoitruong.dao.service.ThongTinKiemDemCongTrinhLocalService getThongTinKiemDemCongTrinhLocalService() {
		return thongTinKiemDemCongTrinhLocalService;
	}

	/**
	 * Sets the thong tin kiem dem cong trinh local service.
	 *
	 * @param thongTinKiemDemCongTrinhLocalService the thong tin kiem dem cong trinh local service
	 */
	public void setThongTinKiemDemCongTrinhLocalService(
		vn.dtt.sol.ns.vesinhmoitruong.dao.service.ThongTinKiemDemCongTrinhLocalService thongTinKiemDemCongTrinhLocalService) {
		this.thongTinKiemDemCongTrinhLocalService = thongTinKiemDemCongTrinhLocalService;
	}

	/**
	 * Returns the thong tin kiem dem cong trinh persistence.
	 *
	 * @return the thong tin kiem dem cong trinh persistence
	 */
	public ThongTinKiemDemCongTrinhPersistence getThongTinKiemDemCongTrinhPersistence() {
		return thongTinKiemDemCongTrinhPersistence;
	}

	/**
	 * Sets the thong tin kiem dem cong trinh persistence.
	 *
	 * @param thongTinKiemDemCongTrinhPersistence the thong tin kiem dem cong trinh persistence
	 */
	public void setThongTinKiemDemCongTrinhPersistence(
		ThongTinKiemDemCongTrinhPersistence thongTinKiemDemCongTrinhPersistence) {
		this.thongTinKiemDemCongTrinhPersistence = thongTinKiemDemCongTrinhPersistence;
	}

	/**
	 * Returns the thong tin kiem dem cong trinh finder.
	 *
	 * @return the thong tin kiem dem cong trinh finder
	 */
	public ThongTinKiemDemCongTrinhFinder getThongTinKiemDemCongTrinhFinder() {
		return thongTinKiemDemCongTrinhFinder;
	}

	/**
	 * Sets the thong tin kiem dem cong trinh finder.
	 *
	 * @param thongTinKiemDemCongTrinhFinder the thong tin kiem dem cong trinh finder
	 */
	public void setThongTinKiemDemCongTrinhFinder(
		ThongTinKiemDemCongTrinhFinder thongTinKiemDemCongTrinhFinder) {
		this.thongTinKiemDemCongTrinhFinder = thongTinKiemDemCongTrinhFinder;
	}

	/**
	 * Returns the thong tin kiem dem ho g d local service.
	 *
	 * @return the thong tin kiem dem ho g d local service
	 */
	public vn.dtt.sol.ns.vesinhmoitruong.dao.service.ThongTinKiemDemHoGDLocalService getThongTinKiemDemHoGDLocalService() {
		return thongTinKiemDemHoGDLocalService;
	}

	/**
	 * Sets the thong tin kiem dem ho g d local service.
	 *
	 * @param thongTinKiemDemHoGDLocalService the thong tin kiem dem ho g d local service
	 */
	public void setThongTinKiemDemHoGDLocalService(
		vn.dtt.sol.ns.vesinhmoitruong.dao.service.ThongTinKiemDemHoGDLocalService thongTinKiemDemHoGDLocalService) {
		this.thongTinKiemDemHoGDLocalService = thongTinKiemDemHoGDLocalService;
	}

	/**
	 * Returns the thong tin kiem dem ho g d persistence.
	 *
	 * @return the thong tin kiem dem ho g d persistence
	 */
	public ThongTinKiemDemHoGDPersistence getThongTinKiemDemHoGDPersistence() {
		return thongTinKiemDemHoGDPersistence;
	}

	/**
	 * Sets the thong tin kiem dem ho g d persistence.
	 *
	 * @param thongTinKiemDemHoGDPersistence the thong tin kiem dem ho g d persistence
	 */
	public void setThongTinKiemDemHoGDPersistence(
		ThongTinKiemDemHoGDPersistence thongTinKiemDemHoGDPersistence) {
		this.thongTinKiemDemHoGDPersistence = thongTinKiemDemHoGDPersistence;
	}

	/**
	 * Returns the thong tin kiem dem ho g d finder.
	 *
	 * @return the thong tin kiem dem ho g d finder
	 */
	public ThongTinKiemDemHoGDFinder getThongTinKiemDemHoGDFinder() {
		return thongTinKiemDemHoGDFinder;
	}

	/**
	 * Sets the thong tin kiem dem ho g d finder.
	 *
	 * @param thongTinKiemDemHoGDFinder the thong tin kiem dem ho g d finder
	 */
	public void setThongTinKiemDemHoGDFinder(
		ThongTinKiemDemHoGDFinder thongTinKiemDemHoGDFinder) {
		this.thongTinKiemDemHoGDFinder = thongTinKiemDemHoGDFinder;
	}

	/**
	 * Returns the ve sinh cong trinh local service.
	 *
	 * @return the ve sinh cong trinh local service
	 */
	public vn.dtt.sol.ns.vesinhmoitruong.dao.service.VeSinhCongTrinhLocalService getVeSinhCongTrinhLocalService() {
		return veSinhCongTrinhLocalService;
	}

	/**
	 * Sets the ve sinh cong trinh local service.
	 *
	 * @param veSinhCongTrinhLocalService the ve sinh cong trinh local service
	 */
	public void setVeSinhCongTrinhLocalService(
		vn.dtt.sol.ns.vesinhmoitruong.dao.service.VeSinhCongTrinhLocalService veSinhCongTrinhLocalService) {
		this.veSinhCongTrinhLocalService = veSinhCongTrinhLocalService;
	}

	/**
	 * Returns the ve sinh cong trinh persistence.
	 *
	 * @return the ve sinh cong trinh persistence
	 */
	public VeSinhCongTrinhPersistence getVeSinhCongTrinhPersistence() {
		return veSinhCongTrinhPersistence;
	}

	/**
	 * Sets the ve sinh cong trinh persistence.
	 *
	 * @param veSinhCongTrinhPersistence the ve sinh cong trinh persistence
	 */
	public void setVeSinhCongTrinhPersistence(
		VeSinhCongTrinhPersistence veSinhCongTrinhPersistence) {
		this.veSinhCongTrinhPersistence = veSinhCongTrinhPersistence;
	}

	/**
	 * Returns the ve sinh cong trinh finder.
	 *
	 * @return the ve sinh cong trinh finder
	 */
	public VeSinhCongTrinhFinder getVeSinhCongTrinhFinder() {
		return veSinhCongTrinhFinder;
	}

	/**
	 * Sets the ve sinh cong trinh finder.
	 *
	 * @param veSinhCongTrinhFinder the ve sinh cong trinh finder
	 */
	public void setVeSinhCongTrinhFinder(
		VeSinhCongTrinhFinder veSinhCongTrinhFinder) {
		this.veSinhCongTrinhFinder = veSinhCongTrinhFinder;
	}

	/**
	 * Returns the ve sinh gia dinh local service.
	 *
	 * @return the ve sinh gia dinh local service
	 */
	public vn.dtt.sol.ns.vesinhmoitruong.dao.service.VeSinhGiaDinhLocalService getVeSinhGiaDinhLocalService() {
		return veSinhGiaDinhLocalService;
	}

	/**
	 * Sets the ve sinh gia dinh local service.
	 *
	 * @param veSinhGiaDinhLocalService the ve sinh gia dinh local service
	 */
	public void setVeSinhGiaDinhLocalService(
		vn.dtt.sol.ns.vesinhmoitruong.dao.service.VeSinhGiaDinhLocalService veSinhGiaDinhLocalService) {
		this.veSinhGiaDinhLocalService = veSinhGiaDinhLocalService;
	}

	/**
	 * Returns the ve sinh gia dinh persistence.
	 *
	 * @return the ve sinh gia dinh persistence
	 */
	public VeSinhGiaDinhPersistence getVeSinhGiaDinhPersistence() {
		return veSinhGiaDinhPersistence;
	}

	/**
	 * Sets the ve sinh gia dinh persistence.
	 *
	 * @param veSinhGiaDinhPersistence the ve sinh gia dinh persistence
	 */
	public void setVeSinhGiaDinhPersistence(
		VeSinhGiaDinhPersistence veSinhGiaDinhPersistence) {
		this.veSinhGiaDinhPersistence = veSinhGiaDinhPersistence;
	}

	/**
	 * Returns the ve sinh gia dinh finder.
	 *
	 * @return the ve sinh gia dinh finder
	 */
	public VeSinhGiaDinhFinder getVeSinhGiaDinhFinder() {
		return veSinhGiaDinhFinder;
	}

	/**
	 * Sets the ve sinh gia dinh finder.
	 *
	 * @param veSinhGiaDinhFinder the ve sinh gia dinh finder
	 */
	public void setVeSinhGiaDinhFinder(VeSinhGiaDinhFinder veSinhGiaDinhFinder) {
		this.veSinhGiaDinhFinder = veSinhGiaDinhFinder;
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

		PersistedModelLocalServiceRegistryUtil.register("vn.dtt.sol.ns.vesinhmoitruong.dao.model.ChiTietKiemDemCongTrinh",
			chiTietKiemDemCongTrinhLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"vn.dtt.sol.ns.vesinhmoitruong.dao.model.ChiTietKiemDemCongTrinh");
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
		return ChiTietKiemDemCongTrinh.class;
	}

	protected String getModelClassName() {
		return ChiTietKiemDemCongTrinh.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = chiTietKiemDemCongTrinhPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = vn.dtt.sol.ns.vesinhmoitruong.dao.service.ChiTietKiemDemCongTrinhLocalService.class)
	protected vn.dtt.sol.ns.vesinhmoitruong.dao.service.ChiTietKiemDemCongTrinhLocalService chiTietKiemDemCongTrinhLocalService;
	@BeanReference(type = ChiTietKiemDemCongTrinhPersistence.class)
	protected ChiTietKiemDemCongTrinhPersistence chiTietKiemDemCongTrinhPersistence;
	@BeanReference(type = vn.dtt.sol.ns.vesinhmoitruong.dao.service.DanhGiaVeSinhXaNewLocalService.class)
	protected vn.dtt.sol.ns.vesinhmoitruong.dao.service.DanhGiaVeSinhXaNewLocalService danhGiaVeSinhXaNewLocalService;
	@BeanReference(type = DanhGiaVeSinhXaNewPersistence.class)
	protected DanhGiaVeSinhXaNewPersistence danhGiaVeSinhXaNewPersistence;
	@BeanReference(type = vn.dtt.sol.ns.vesinhmoitruong.dao.service.DanhGiaVeSinhXaNewFakeLocalService.class)
	protected vn.dtt.sol.ns.vesinhmoitruong.dao.service.DanhGiaVeSinhXaNewFakeLocalService danhGiaVeSinhXaNewFakeLocalService;
	@BeanReference(type = DanhGiaVeSinhXaNewFakePersistence.class)
	protected DanhGiaVeSinhXaNewFakePersistence danhGiaVeSinhXaNewFakePersistence;
	@BeanReference(type = DanhGiaVeSinhXaNewFakeFinder.class)
	protected DanhGiaVeSinhXaNewFakeFinder danhGiaVeSinhXaNewFakeFinder;
	@BeanReference(type = vn.dtt.sol.ns.vesinhmoitruong.dao.service.KeHoachKiemDemVeSinhLocalService.class)
	protected vn.dtt.sol.ns.vesinhmoitruong.dao.service.KeHoachKiemDemVeSinhLocalService keHoachKiemDemVeSinhLocalService;
	@BeanReference(type = KeHoachKiemDemVeSinhPersistence.class)
	protected KeHoachKiemDemVeSinhPersistence keHoachKiemDemVeSinhPersistence;
	@BeanReference(type = KeHoachKiemDemVeSinhFinder.class)
	protected KeHoachKiemDemVeSinhFinder keHoachKiemDemVeSinhFinder;
	@BeanReference(type = vn.dtt.sol.ns.vesinhmoitruong.dao.service.keHoachVeSinhXaNewLocalService.class)
	protected vn.dtt.sol.ns.vesinhmoitruong.dao.service.keHoachVeSinhXaNewLocalService keHoachVeSinhXaNewLocalService;
	@BeanReference(type = keHoachVeSinhXaNewPersistence.class)
	protected keHoachVeSinhXaNewPersistence keHoachVeSinhXaNewPersistence;
	@BeanReference(type = vn.dtt.sol.ns.vesinhmoitruong.dao.service.ThongTinKiemDemCongTrinhLocalService.class)
	protected vn.dtt.sol.ns.vesinhmoitruong.dao.service.ThongTinKiemDemCongTrinhLocalService thongTinKiemDemCongTrinhLocalService;
	@BeanReference(type = ThongTinKiemDemCongTrinhPersistence.class)
	protected ThongTinKiemDemCongTrinhPersistence thongTinKiemDemCongTrinhPersistence;
	@BeanReference(type = ThongTinKiemDemCongTrinhFinder.class)
	protected ThongTinKiemDemCongTrinhFinder thongTinKiemDemCongTrinhFinder;
	@BeanReference(type = vn.dtt.sol.ns.vesinhmoitruong.dao.service.ThongTinKiemDemHoGDLocalService.class)
	protected vn.dtt.sol.ns.vesinhmoitruong.dao.service.ThongTinKiemDemHoGDLocalService thongTinKiemDemHoGDLocalService;
	@BeanReference(type = ThongTinKiemDemHoGDPersistence.class)
	protected ThongTinKiemDemHoGDPersistence thongTinKiemDemHoGDPersistence;
	@BeanReference(type = ThongTinKiemDemHoGDFinder.class)
	protected ThongTinKiemDemHoGDFinder thongTinKiemDemHoGDFinder;
	@BeanReference(type = vn.dtt.sol.ns.vesinhmoitruong.dao.service.VeSinhCongTrinhLocalService.class)
	protected vn.dtt.sol.ns.vesinhmoitruong.dao.service.VeSinhCongTrinhLocalService veSinhCongTrinhLocalService;
	@BeanReference(type = VeSinhCongTrinhPersistence.class)
	protected VeSinhCongTrinhPersistence veSinhCongTrinhPersistence;
	@BeanReference(type = VeSinhCongTrinhFinder.class)
	protected VeSinhCongTrinhFinder veSinhCongTrinhFinder;
	@BeanReference(type = vn.dtt.sol.ns.vesinhmoitruong.dao.service.VeSinhGiaDinhLocalService.class)
	protected vn.dtt.sol.ns.vesinhmoitruong.dao.service.VeSinhGiaDinhLocalService veSinhGiaDinhLocalService;
	@BeanReference(type = VeSinhGiaDinhPersistence.class)
	protected VeSinhGiaDinhPersistence veSinhGiaDinhPersistence;
	@BeanReference(type = VeSinhGiaDinhFinder.class)
	protected VeSinhGiaDinhFinder veSinhGiaDinhFinder;
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
	private ChiTietKiemDemCongTrinhLocalServiceClpInvoker _clpInvoker = new ChiTietKiemDemCongTrinhLocalServiceClpInvoker();
}