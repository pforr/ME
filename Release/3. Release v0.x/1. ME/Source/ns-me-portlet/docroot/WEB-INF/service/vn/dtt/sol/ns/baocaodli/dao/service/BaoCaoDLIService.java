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

package vn.dtt.sol.ns.baocaodli.dao.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for BaoCaoDLI. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author HuyMQ
 * @see BaoCaoDLIServiceUtil
 * @see vn.dtt.sol.ns.baocaodli.dao.service.base.BaoCaoDLIServiceBaseImpl
 * @see vn.dtt.sol.ns.baocaodli.dao.service.impl.BaoCaoDLIServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface BaoCaoDLIService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BaoCaoDLIServiceUtil} to access the bao cao d l i remote service. Add custom service methods to {@link vn.dtt.sol.ns.baocaodli.dao.service.impl.BaoCaoDLIServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public void initBaoCaoDLI()
		throws com.liferay.portal.kernel.exception.SystemException;

	public void deleteBaoCao(long baoCaoDLIId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLI updateBaoCao(
		long groupId, long baoCaoDLIId, int nam, java.lang.String maTinh,
		java.lang.String soBaoCao, java.lang.String nguoiLap,
		java.lang.String nguoiDuyet, int ngayBaoCaoMonth, int ngayBaoCaoDay,
		int ngayBaoCaoYear, long folderId, java.io.File luuTruPDF1,
		java.io.File luuTruPDF2, java.io.File luuTruCSV1,
		java.io.File luuTruCSV2, int trangThai,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}