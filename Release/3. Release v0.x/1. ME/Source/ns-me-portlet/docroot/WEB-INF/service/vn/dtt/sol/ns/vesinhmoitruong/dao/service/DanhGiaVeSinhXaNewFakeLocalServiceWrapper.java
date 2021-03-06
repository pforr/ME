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

package vn.dtt.sol.ns.vesinhmoitruong.dao.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DanhGiaVeSinhXaNewFakeLocalService}.
 *
 * @author BinhTH
 * @see DanhGiaVeSinhXaNewFakeLocalService
 * @generated
 */
public class DanhGiaVeSinhXaNewFakeLocalServiceWrapper
	implements DanhGiaVeSinhXaNewFakeLocalService,
		ServiceWrapper<DanhGiaVeSinhXaNewFakeLocalService> {
	public DanhGiaVeSinhXaNewFakeLocalServiceWrapper(
		DanhGiaVeSinhXaNewFakeLocalService danhGiaVeSinhXaNewFakeLocalService) {
		_danhGiaVeSinhXaNewFakeLocalService = danhGiaVeSinhXaNewFakeLocalService;
	}

	/**
	* Adds the danh gia ve sinh xa new fake to the database. Also notifies the appropriate model listeners.
	*
	* @param danhGiaVeSinhXaNewFake the danh gia ve sinh xa new fake
	* @return the danh gia ve sinh xa new fake that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake addDanhGiaVeSinhXaNewFake(
		vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake danhGiaVeSinhXaNewFake)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhGiaVeSinhXaNewFakeLocalService.addDanhGiaVeSinhXaNewFake(danhGiaVeSinhXaNewFake);
	}

	/**
	* Creates a new danh gia ve sinh xa new fake with the primary key. Does not add the danh gia ve sinh xa new fake to the database.
	*
	* @param id the primary key for the new danh gia ve sinh xa new fake
	* @return the new danh gia ve sinh xa new fake
	*/
	@Override
	public vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake createDanhGiaVeSinhXaNewFake(
		int id) {
		return _danhGiaVeSinhXaNewFakeLocalService.createDanhGiaVeSinhXaNewFake(id);
	}

	/**
	* Deletes the danh gia ve sinh xa new fake with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the danh gia ve sinh xa new fake
	* @return the danh gia ve sinh xa new fake that was removed
	* @throws PortalException if a danh gia ve sinh xa new fake with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake deleteDanhGiaVeSinhXaNewFake(
		int id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _danhGiaVeSinhXaNewFakeLocalService.deleteDanhGiaVeSinhXaNewFake(id);
	}

	/**
	* Deletes the danh gia ve sinh xa new fake from the database. Also notifies the appropriate model listeners.
	*
	* @param danhGiaVeSinhXaNewFake the danh gia ve sinh xa new fake
	* @return the danh gia ve sinh xa new fake that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake deleteDanhGiaVeSinhXaNewFake(
		vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake danhGiaVeSinhXaNewFake)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhGiaVeSinhXaNewFakeLocalService.deleteDanhGiaVeSinhXaNewFake(danhGiaVeSinhXaNewFake);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _danhGiaVeSinhXaNewFakeLocalService.dynamicQuery();
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
		return _danhGiaVeSinhXaNewFakeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl.DanhGiaVeSinhXaNewFakeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _danhGiaVeSinhXaNewFakeLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl.DanhGiaVeSinhXaNewFakeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _danhGiaVeSinhXaNewFakeLocalService.dynamicQuery(dynamicQuery,
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhGiaVeSinhXaNewFakeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _danhGiaVeSinhXaNewFakeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake fetchDanhGiaVeSinhXaNewFake(
		int id) throws com.liferay.portal.kernel.exception.SystemException {
		return _danhGiaVeSinhXaNewFakeLocalService.fetchDanhGiaVeSinhXaNewFake(id);
	}

	/**
	* Returns the danh gia ve sinh xa new fake with the primary key.
	*
	* @param id the primary key of the danh gia ve sinh xa new fake
	* @return the danh gia ve sinh xa new fake
	* @throws PortalException if a danh gia ve sinh xa new fake with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake getDanhGiaVeSinhXaNewFake(
		int id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _danhGiaVeSinhXaNewFakeLocalService.getDanhGiaVeSinhXaNewFake(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _danhGiaVeSinhXaNewFakeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the danh gia ve sinh xa new fakes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl.DanhGiaVeSinhXaNewFakeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of danh gia ve sinh xa new fakes
	* @param end the upper bound of the range of danh gia ve sinh xa new fakes (not inclusive)
	* @return the range of danh gia ve sinh xa new fakes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake> getDanhGiaVeSinhXaNewFakes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhGiaVeSinhXaNewFakeLocalService.getDanhGiaVeSinhXaNewFakes(start,
			end);
	}

	/**
	* Returns the number of danh gia ve sinh xa new fakes.
	*
	* @return the number of danh gia ve sinh xa new fakes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDanhGiaVeSinhXaNewFakesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhGiaVeSinhXaNewFakeLocalService.getDanhGiaVeSinhXaNewFakesCount();
	}

	/**
	* Updates the danh gia ve sinh xa new fake in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhGiaVeSinhXaNewFake the danh gia ve sinh xa new fake
	* @return the danh gia ve sinh xa new fake that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake updateDanhGiaVeSinhXaNewFake(
		vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake danhGiaVeSinhXaNewFake)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhGiaVeSinhXaNewFakeLocalService.updateDanhGiaVeSinhXaNewFake(danhGiaVeSinhXaNewFake);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _danhGiaVeSinhXaNewFakeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_danhGiaVeSinhXaNewFakeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _danhGiaVeSinhXaNewFakeLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public int countListDanhGiaVeSinhXaInsert(java.lang.String maTinh,
		java.lang.String maHuyen, int nam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhGiaVeSinhXaNewFakeLocalService.countListDanhGiaVeSinhXaInsert(maTinh,
			maHuyen, nam);
	}

	@Override
	public java.util.List<vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake> getListDanhGiaVeSinhXaInsert(
		java.lang.String maTinh, java.lang.String maHuyen, int nam, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _danhGiaVeSinhXaNewFakeLocalService.getListDanhGiaVeSinhXaInsert(maTinh,
			maHuyen, nam, start, end);
	}

	@Override
	public int countListDanhGiaVeSinhXaFakeList(java.lang.String maTinh,
		java.lang.String maHuyen, int nam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhGiaVeSinhXaNewFakeLocalService.countListDanhGiaVeSinhXaFakeList(maTinh,
			maHuyen, nam);
	}

	@Override
	public java.util.List<vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake> getListDanhGiaVeSinhXaFakeList(
		java.lang.String maTinh, java.lang.String maHuyen, int nam, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _danhGiaVeSinhXaNewFakeLocalService.getListDanhGiaVeSinhXaFakeList(maTinh,
			maHuyen, nam, start, end);
	}

	@Override
	public java.util.List<vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake> getListDanhGiaVeSinhXaSearch(
		java.lang.String maTinh, java.lang.String nam, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhGiaVeSinhXaNewFakeLocalService.getListDanhGiaVeSinhXaSearch(maTinh,
			nam, start, end);
	}

	@Override
	public int countListDanhGiaVeSinhXaSearch(java.lang.String maTinh,
		java.lang.String nam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhGiaVeSinhXaNewFakeLocalService.countListDanhGiaVeSinhXaSearch(maTinh,
			nam);
	}

	@Override
	public int countListDanhGiaVeSinhXaSearchHuyen(java.lang.String maTinh,
		java.lang.String nam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danhGiaVeSinhXaNewFakeLocalService.countListDanhGiaVeSinhXaSearchHuyen(maTinh,
			nam);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DanhGiaVeSinhXaNewFakeLocalService getWrappedDanhGiaVeSinhXaNewFakeLocalService() {
		return _danhGiaVeSinhXaNewFakeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDanhGiaVeSinhXaNewFakeLocalService(
		DanhGiaVeSinhXaNewFakeLocalService danhGiaVeSinhXaNewFakeLocalService) {
		_danhGiaVeSinhXaNewFakeLocalService = danhGiaVeSinhXaNewFakeLocalService;
	}

	@Override
	public DanhGiaVeSinhXaNewFakeLocalService getWrappedService() {
		return _danhGiaVeSinhXaNewFakeLocalService;
	}

	@Override
	public void setWrappedService(
		DanhGiaVeSinhXaNewFakeLocalService danhGiaVeSinhXaNewFakeLocalService) {
		_danhGiaVeSinhXaNewFakeLocalService = danhGiaVeSinhXaNewFakeLocalService;
	}

	private DanhGiaVeSinhXaNewFakeLocalService _danhGiaVeSinhXaNewFakeLocalService;
}