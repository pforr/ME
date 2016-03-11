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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for DanhGiaVeSinhXaNewFake. This utility wraps
 * {@link vn.dtt.sol.ns.vesinhmoitruong.dao.service.impl.DanhGiaVeSinhXaNewFakeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author BinhTH
 * @see DanhGiaVeSinhXaNewFakeLocalService
 * @see vn.dtt.sol.ns.vesinhmoitruong.dao.service.base.DanhGiaVeSinhXaNewFakeLocalServiceBaseImpl
 * @see vn.dtt.sol.ns.vesinhmoitruong.dao.service.impl.DanhGiaVeSinhXaNewFakeLocalServiceImpl
 * @generated
 */
public class DanhGiaVeSinhXaNewFakeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.dtt.sol.ns.vesinhmoitruong.dao.service.impl.DanhGiaVeSinhXaNewFakeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the danh gia ve sinh xa new fake to the database. Also notifies the appropriate model listeners.
	*
	* @param danhGiaVeSinhXaNewFake the danh gia ve sinh xa new fake
	* @return the danh gia ve sinh xa new fake that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake addDanhGiaVeSinhXaNewFake(
		vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake danhGiaVeSinhXaNewFake)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDanhGiaVeSinhXaNewFake(danhGiaVeSinhXaNewFake);
	}

	/**
	* Creates a new danh gia ve sinh xa new fake with the primary key. Does not add the danh gia ve sinh xa new fake to the database.
	*
	* @param id the primary key for the new danh gia ve sinh xa new fake
	* @return the new danh gia ve sinh xa new fake
	*/
	public static vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake createDanhGiaVeSinhXaNewFake(
		int id) {
		return getService().createDanhGiaVeSinhXaNewFake(id);
	}

	/**
	* Deletes the danh gia ve sinh xa new fake with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the danh gia ve sinh xa new fake
	* @return the danh gia ve sinh xa new fake that was removed
	* @throws PortalException if a danh gia ve sinh xa new fake with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake deleteDanhGiaVeSinhXaNewFake(
		int id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDanhGiaVeSinhXaNewFake(id);
	}

	/**
	* Deletes the danh gia ve sinh xa new fake from the database. Also notifies the appropriate model listeners.
	*
	* @param danhGiaVeSinhXaNewFake the danh gia ve sinh xa new fake
	* @return the danh gia ve sinh xa new fake that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake deleteDanhGiaVeSinhXaNewFake(
		vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake danhGiaVeSinhXaNewFake)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDanhGiaVeSinhXaNewFake(danhGiaVeSinhXaNewFake);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl.DanhGiaVeSinhXaNewFakeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake fetchDanhGiaVeSinhXaNewFake(
		int id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDanhGiaVeSinhXaNewFake(id);
	}

	/**
	* Returns the danh gia ve sinh xa new fake with the primary key.
	*
	* @param id the primary key of the danh gia ve sinh xa new fake
	* @return the danh gia ve sinh xa new fake
	* @throws PortalException if a danh gia ve sinh xa new fake with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake getDanhGiaVeSinhXaNewFake(
		int id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDanhGiaVeSinhXaNewFake(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake> getDanhGiaVeSinhXaNewFakes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDanhGiaVeSinhXaNewFakes(start, end);
	}

	/**
	* Returns the number of danh gia ve sinh xa new fakes.
	*
	* @return the number of danh gia ve sinh xa new fakes
	* @throws SystemException if a system exception occurred
	*/
	public static int getDanhGiaVeSinhXaNewFakesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDanhGiaVeSinhXaNewFakesCount();
	}

	/**
	* Updates the danh gia ve sinh xa new fake in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danhGiaVeSinhXaNewFake the danh gia ve sinh xa new fake
	* @return the danh gia ve sinh xa new fake that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake updateDanhGiaVeSinhXaNewFake(
		vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake danhGiaVeSinhXaNewFake)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDanhGiaVeSinhXaNewFake(danhGiaVeSinhXaNewFake);
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

	public static int countSoNguoiTrongXa(java.lang.String maXa)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countSoNguoiTrongXa(maXa);
	}

	public static int countHoGiaDinh(java.lang.String maXa)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countHoGiaDinh(maXa);
	}

	public static int countHoGiaDinhChonMau(java.lang.String maXa, int nam)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countHoGiaDinhChonMau(maXa, nam);
	}

	public static int countHoGiaDinhCoNhaTieu(java.lang.String maXa, int nam)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countHoGiaDinhCoNhaTieu(maXa, nam);
	}

	public static int countHoGiaDinhCoNhaTieuHopVeSinh(java.lang.String maXa,
		int nam)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countHoGiaDinhCoNhaTieuHopVeSinh(maXa, nam);
	}

	public static int countListDanhGiaVeSinhXaInsert(java.lang.String maTinh,
		java.lang.String maHuyen, int nam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countListDanhGiaVeSinhXaInsert(maTinh, maHuyen, nam);
	}

	public static java.util.List<vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake> getListDanhGiaVeSinhXaInsert(
		java.lang.String maTinh, java.lang.String maHuyen, int nam, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getListDanhGiaVeSinhXaInsert(maTinh, maHuyen, nam, start,
			end);
	}

	public static int countListDanhGiaVeSinhXaFakeList(
		java.lang.String maTinh, java.lang.String maHuyen, int nam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countListDanhGiaVeSinhXaFakeList(maTinh, maHuyen, nam);
	}

	public static java.util.List<vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake> getListDanhGiaVeSinhXaFakeList(
		java.lang.String maTinh, java.lang.String maHuyen, int nam, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getListDanhGiaVeSinhXaFakeList(maTinh, maHuyen, nam, start,
			end);
	}

	public static java.util.List<vn.dtt.sol.ns.vesinhmoitruong.dao.model.DanhGiaVeSinhXaNewFake> getListDanhGiaVeSinhXaSearch(
		java.lang.String maTinh, java.lang.String nam, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getListDanhGiaVeSinhXaSearch(maTinh, nam, start, end);
	}

	public static int countListDanhGiaVeSinhXaSearch(java.lang.String maTinh,
		java.lang.String nam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countListDanhGiaVeSinhXaSearch(maTinh, nam);
	}

	public static int countListDanhGiaVeSinhXaSearchHuyen(
		java.lang.String maTinh, java.lang.String nam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countListDanhGiaVeSinhXaSearchHuyen(maTinh, nam);
	}

	public static void clearService() {
		_service = null;
	}

	public static DanhGiaVeSinhXaNewFakeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DanhGiaVeSinhXaNewFakeLocalService.class.getName());

			if (invokableLocalService instanceof DanhGiaVeSinhXaNewFakeLocalService) {
				_service = (DanhGiaVeSinhXaNewFakeLocalService)invokableLocalService;
			}
			else {
				_service = new DanhGiaVeSinhXaNewFakeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(DanhGiaVeSinhXaNewFakeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(DanhGiaVeSinhXaNewFakeLocalService service) {
	}

	private static DanhGiaVeSinhXaNewFakeLocalService _service;
}