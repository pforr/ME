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

package vn.dtt.sol.ns.kehoachdaunam.dao.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link KeHoachDauNamLocalService}.
 *
 * @author HANT
 * @see KeHoachDauNamLocalService
 * @generated
 */
public class KeHoachDauNamLocalServiceWrapper
	implements KeHoachDauNamLocalService,
		ServiceWrapper<KeHoachDauNamLocalService> {
	public KeHoachDauNamLocalServiceWrapper(
		KeHoachDauNamLocalService keHoachDauNamLocalService) {
		_keHoachDauNamLocalService = keHoachDauNamLocalService;
	}

	/**
	* Adds the ke hoach dau nam to the database. Also notifies the appropriate model listeners.
	*
	* @param keHoachDauNam the ke hoach dau nam
	* @return the ke hoach dau nam that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.sol.ns.kehoachdaunam.dao.model.KeHoachDauNam addKeHoachDauNam(
		vn.dtt.sol.ns.kehoachdaunam.dao.model.KeHoachDauNam keHoachDauNam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _keHoachDauNamLocalService.addKeHoachDauNam(keHoachDauNam);
	}

	/**
	* Creates a new ke hoach dau nam with the primary key. Does not add the ke hoach dau nam to the database.
	*
	* @param id the primary key for the new ke hoach dau nam
	* @return the new ke hoach dau nam
	*/
	@Override
	public vn.dtt.sol.ns.kehoachdaunam.dao.model.KeHoachDauNam createKeHoachDauNam(
		long id) {
		return _keHoachDauNamLocalService.createKeHoachDauNam(id);
	}

	/**
	* Deletes the ke hoach dau nam with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ke hoach dau nam
	* @return the ke hoach dau nam that was removed
	* @throws PortalException if a ke hoach dau nam with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.sol.ns.kehoachdaunam.dao.model.KeHoachDauNam deleteKeHoachDauNam(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _keHoachDauNamLocalService.deleteKeHoachDauNam(id);
	}

	/**
	* Deletes the ke hoach dau nam from the database. Also notifies the appropriate model listeners.
	*
	* @param keHoachDauNam the ke hoach dau nam
	* @return the ke hoach dau nam that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.sol.ns.kehoachdaunam.dao.model.KeHoachDauNam deleteKeHoachDauNam(
		vn.dtt.sol.ns.kehoachdaunam.dao.model.KeHoachDauNam keHoachDauNam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _keHoachDauNamLocalService.deleteKeHoachDauNam(keHoachDauNam);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _keHoachDauNamLocalService.dynamicQuery();
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
		return _keHoachDauNamLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.kehoachdaunam.dao.model.impl.KeHoachDauNamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _keHoachDauNamLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.kehoachdaunam.dao.model.impl.KeHoachDauNamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _keHoachDauNamLocalService.dynamicQuery(dynamicQuery, start,
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _keHoachDauNamLocalService.dynamicQueryCount(dynamicQuery);
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
		return _keHoachDauNamLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.dtt.sol.ns.kehoachdaunam.dao.model.KeHoachDauNam fetchKeHoachDauNam(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _keHoachDauNamLocalService.fetchKeHoachDauNam(id);
	}

	/**
	* Returns the ke hoach dau nam with the primary key.
	*
	* @param id the primary key of the ke hoach dau nam
	* @return the ke hoach dau nam
	* @throws PortalException if a ke hoach dau nam with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.sol.ns.kehoachdaunam.dao.model.KeHoachDauNam getKeHoachDauNam(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _keHoachDauNamLocalService.getKeHoachDauNam(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _keHoachDauNamLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the ke hoach dau nams.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.kehoachdaunam.dao.model.impl.KeHoachDauNamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ke hoach dau nams
	* @param end the upper bound of the range of ke hoach dau nams (not inclusive)
	* @return the range of ke hoach dau nams
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.dtt.sol.ns.kehoachdaunam.dao.model.KeHoachDauNam> getKeHoachDauNams(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _keHoachDauNamLocalService.getKeHoachDauNams(start, end);
	}

	/**
	* Returns the number of ke hoach dau nams.
	*
	* @return the number of ke hoach dau nams
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getKeHoachDauNamsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _keHoachDauNamLocalService.getKeHoachDauNamsCount();
	}

	/**
	* Updates the ke hoach dau nam in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param keHoachDauNam the ke hoach dau nam
	* @return the ke hoach dau nam that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.sol.ns.kehoachdaunam.dao.model.KeHoachDauNam updateKeHoachDauNam(
		vn.dtt.sol.ns.kehoachdaunam.dao.model.KeHoachDauNam keHoachDauNam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _keHoachDauNamLocalService.updateKeHoachDauNam(keHoachDauNam);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _keHoachDauNamLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_keHoachDauNamLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _keHoachDauNamLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.dtt.sol.ns.kehoachdaunam.dao.model.KeHoachDauNam> searchByNamAndTinh(
		long namKeHoach, java.lang.String maTinh, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _keHoachDauNamLocalService.searchByNamAndTinh(namKeHoach,
			maTinh, start, end);
	}

	@Override
	public int countByNamAndTinh(long namKeHoach, java.lang.String maTinh)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _keHoachDauNamLocalService.countByNamAndTinh(namKeHoach, maTinh);
	}

	@Override
	public java.util.List<vn.dtt.sol.ns.kehoachdaunam.dao.model.KeHoachDauNam> searchByNamAndTram(
		long namKeHoach, java.lang.String maTram, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _keHoachDauNamLocalService.searchByNamAndTram(namKeHoach,
			maTram, start, end);
	}

	@Override
	public int countByNamAndTram(long namKeHoach, java.lang.String maTram)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _keHoachDauNamLocalService.countByNamAndTram(namKeHoach, maTram);
	}

	@Override
	public int countSoNguoiHuongLoiCapNcBenVung(java.lang.String nam,
		java.lang.String maTinh)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _keHoachDauNamLocalService.countSoNguoiHuongLoiCapNcBenVung(nam,
			maTinh);
	}

	@Override
	public java.util.List<vn.dtt.sol.ns.kehoachdaunam.dao.model.KeHoachDauNam> searchByNamAndMaTinh(
		java.lang.String nam, java.lang.String maTinh)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _keHoachDauNamLocalService.searchByNamAndMaTinh(nam, maTinh);
	}

	@Override
	public int sumSoDauNoiMoiTW(java.lang.String namBaoCao,
		java.lang.String maTinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _keHoachDauNamLocalService.sumSoDauNoiMoiTW(namBaoCao, maTinh);
	}

	@Override
	public int sumSoNguoiHuongLoiCapNcBenVungBaoCaoHopNhat(
		java.lang.String maTinh, int nam, int namToiThieu)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _keHoachDauNamLocalService.sumSoNguoiHuongLoiCapNcBenVungBaoCaoHopNhat(maTinh,
			nam, namToiThieu);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public KeHoachDauNamLocalService getWrappedKeHoachDauNamLocalService() {
		return _keHoachDauNamLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedKeHoachDauNamLocalService(
		KeHoachDauNamLocalService keHoachDauNamLocalService) {
		_keHoachDauNamLocalService = keHoachDauNamLocalService;
	}

	@Override
	public KeHoachDauNamLocalService getWrappedService() {
		return _keHoachDauNamLocalService;
	}

	@Override
	public void setWrappedService(
		KeHoachDauNamLocalService keHoachDauNamLocalService) {
		_keHoachDauNamLocalService = keHoachDauNamLocalService;
	}

	private KeHoachDauNamLocalService _keHoachDauNamLocalService;
}