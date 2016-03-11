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

package vn.dtt.sol.ns.tramcap.dao.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for THONGTINKIEMDEMNUOC. This utility wraps
 * {@link vn.dtt.sol.ns.tramcap.dao.service.impl.THONGTINKIEMDEMNUOCLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoa.vu
 * @see THONGTINKIEMDEMNUOCLocalService
 * @see vn.dtt.sol.ns.tramcap.dao.service.base.THONGTINKIEMDEMNUOCLocalServiceBaseImpl
 * @see vn.dtt.sol.ns.tramcap.dao.service.impl.THONGTINKIEMDEMNUOCLocalServiceImpl
 * @generated
 */
public class THONGTINKIEMDEMNUOCLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.dtt.sol.ns.tramcap.dao.service.impl.THONGTINKIEMDEMNUOCLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the t h o n g t i n k i e m d e m n u o c to the database. Also notifies the appropriate model listeners.
	*
	* @param thongtinkiemdemnuoc the t h o n g t i n k i e m d e m n u o c
	* @return the t h o n g t i n k i e m d e m n u o c that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC addTHONGTINKIEMDEMNUOC(
		vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC thongtinkiemdemnuoc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTHONGTINKIEMDEMNUOC(thongtinkiemdemnuoc);
	}

	/**
	* Creates a new t h o n g t i n k i e m d e m n u o c with the primary key. Does not add the t h o n g t i n k i e m d e m n u o c to the database.
	*
	* @param id the primary key for the new t h o n g t i n k i e m d e m n u o c
	* @return the new t h o n g t i n k i e m d e m n u o c
	*/
	public static vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC createTHONGTINKIEMDEMNUOC(
		long id) {
		return getService().createTHONGTINKIEMDEMNUOC(id);
	}

	/**
	* Deletes the t h o n g t i n k i e m d e m n u o c with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the t h o n g t i n k i e m d e m n u o c
	* @return the t h o n g t i n k i e m d e m n u o c that was removed
	* @throws PortalException if a t h o n g t i n k i e m d e m n u o c with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC deleteTHONGTINKIEMDEMNUOC(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTHONGTINKIEMDEMNUOC(id);
	}

	/**
	* Deletes the t h o n g t i n k i e m d e m n u o c from the database. Also notifies the appropriate model listeners.
	*
	* @param thongtinkiemdemnuoc the t h o n g t i n k i e m d e m n u o c
	* @return the t h o n g t i n k i e m d e m n u o c that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC deleteTHONGTINKIEMDEMNUOC(
		vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC thongtinkiemdemnuoc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTHONGTINKIEMDEMNUOC(thongtinkiemdemnuoc);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.tramcap.dao.model.impl.THONGTINKIEMDEMNUOCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.tramcap.dao.model.impl.THONGTINKIEMDEMNUOCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC fetchTHONGTINKIEMDEMNUOC(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTHONGTINKIEMDEMNUOC(id);
	}

	/**
	* Returns the t h o n g t i n k i e m d e m n u o c with the primary key.
	*
	* @param id the primary key of the t h o n g t i n k i e m d e m n u o c
	* @return the t h o n g t i n k i e m d e m n u o c
	* @throws PortalException if a t h o n g t i n k i e m d e m n u o c with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC getTHONGTINKIEMDEMNUOC(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTHONGTINKIEMDEMNUOC(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the t h o n g t i n k i e m d e m n u o cs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.tramcap.dao.model.impl.THONGTINKIEMDEMNUOCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of t h o n g t i n k i e m d e m n u o cs
	* @param end the upper bound of the range of t h o n g t i n k i e m d e m n u o cs (not inclusive)
	* @return the range of t h o n g t i n k i e m d e m n u o cs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC> getTHONGTINKIEMDEMNUOCs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTHONGTINKIEMDEMNUOCs(start, end);
	}

	/**
	* Returns the number of t h o n g t i n k i e m d e m n u o cs.
	*
	* @return the number of t h o n g t i n k i e m d e m n u o cs
	* @throws SystemException if a system exception occurred
	*/
	public static int getTHONGTINKIEMDEMNUOCsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTHONGTINKIEMDEMNUOCsCount();
	}

	/**
	* Updates the t h o n g t i n k i e m d e m n u o c in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param thongtinkiemdemnuoc the t h o n g t i n k i e m d e m n u o c
	* @return the t h o n g t i n k i e m d e m n u o c that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC updateTHONGTINKIEMDEMNUOC(
		vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC thongtinkiemdemnuoc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTHONGTINKIEMDEMNUOC(thongtinkiemdemnuoc);
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

	public static java.util.List<vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC> getListByDauNoiId(
		long dauNoiNuocId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getListByDauNoiId(dauNoiNuocId, start, end);
	}

	public static java.util.List<vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC> getListBykeHoachKiemDemNuocId(
		int keHoachKiemDemNuocId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getListBykeHoachKiemDemNuocId(keHoachKiemDemNuocId, start,
			end);
	}

	public static java.util.List<vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC> getThongTinKeHoachKiemDemNuocSearch(
		java.lang.String keHoachId, java.lang.String trangThai,
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String nguonDL,
		java.lang.String danhGiaKiemDem, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getThongTinKeHoachKiemDemNuocSearch(keHoachId, trangThai,
			maTinh, maHuyen, maXa, nguonDL, danhGiaKiemDem, start, end);
	}

	public static java.util.List<java.lang.String> getHuyenXaKeHoachKiemDemNuocSearch(
		java.lang.String keHoachId, java.lang.String trangThai,
		java.lang.String maTinh, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getHuyenXaKeHoachKiemDemNuocSearch(keHoachId, trangThai,
			maTinh, start, end);
	}

	public static int getSumDauNoiBykeHoachKiemDemNuocId(
		int keHoachKiemDemNuocId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSumDauNoiBykeHoachKiemDemNuocId(keHoachKiemDemNuocId);
	}

	public static int getCountDauNoiBykeHoachKiemDemNuocId(
		int keHoachKiemDemNuocId, int daKetThucDieuTra)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCountDauNoiBykeHoachKiemDemNuocId(keHoachKiemDemNuocId,
			daKetThucDieuTra);
	}

	public static int getCountDauNoiBykeHoachKiemDemNuocIdDanhGiaKiemDem(
		int keHoachKiemDemNuocId, int danhGiaKiemDem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCountDauNoiBykeHoachKiemDemNuocIdDanhGiaKiemDem(keHoachKiemDemNuocId,
			danhGiaKiemDem);
	}

	public static java.util.List<vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC> getThongTinDNNThoiGianThuc(
		java.lang.String maTinh, java.lang.String namBaoCao,
		java.lang.String danhgiakiemdem, java.lang.String daketthucdieutra)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getThongTinDNNThoiGianThuc(maTinh, namBaoCao,
			danhgiakiemdem, daketthucdieutra);
	}

	public static java.util.List<vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC> getThongTinKeHoachKiemDemNuocSearch(
		java.lang.String keHoachId, java.lang.String trangThai,
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String nguonDL,
		java.lang.String danhGiaKiemDem, java.lang.String advText, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getThongTinKeHoachKiemDemNuocSearch(keHoachId, trangThai,
			maTinh, maHuyen, maXa, nguonDL, danhGiaKiemDem, advText, start, end);
	}

	public static int countGioiTinhChuHo(java.lang.String maTinh,
		java.lang.String namBaoCao, java.lang.String gioiTinhChuHo,
		java.lang.String danhGiaKiemDem, java.lang.String daKetThucDieuTra) {
		return getService()
				   .countGioiTinhChuHo(maTinh, namBaoCao, gioiTinhChuHo,
			danhGiaKiemDem, daKetThucDieuTra);
	}

	public static int countGioiTinhChuHoBaoCaoHopNhat(java.lang.String maTinh,
		int namBaoCao, int namToiThieu, java.lang.String gioiTinhChuHo,
		java.lang.String danhGiaKiemDem, java.lang.String daKetThucDieuTra) {
		return getService()
				   .countGioiTinhChuHoBaoCaoHopNhat(maTinh, namBaoCao,
			namToiThieu, gioiTinhChuHo, danhGiaKiemDem, daKetThucDieuTra);
	}

	public static void clearService() {
		_service = null;
	}

	public static THONGTINKIEMDEMNUOCLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					THONGTINKIEMDEMNUOCLocalService.class.getName());

			if (invokableLocalService instanceof THONGTINKIEMDEMNUOCLocalService) {
				_service = (THONGTINKIEMDEMNUOCLocalService)invokableLocalService;
			}
			else {
				_service = new THONGTINKIEMDEMNUOCLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(THONGTINKIEMDEMNUOCLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(THONGTINKIEMDEMNUOCLocalService service) {
	}

	private static THONGTINKIEMDEMNUOCLocalService _service;
}