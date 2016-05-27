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

package vn.dtt.cmon.dm.dao.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import vn.dtt.cmon.dm.dao.model.DATAITEM;

/**
 * The persistence interface for the d a t a i t e m service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoa.vu
 * @see DATAITEMPersistenceImpl
 * @see DATAITEMUtil
 * @generated
 */
public interface DATAITEMPersistence extends BasePersistence<DATAITEM> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DATAITEMUtil} to access the d a t a i t e m persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the d a t a i t e ms where dataGroupId = &#63;.
	*
	* @param dataGroupId the data group ID
	* @return the matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findByD_G(
		long dataGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the d a t a i t e ms where dataGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DATAITEMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataGroupId the data group ID
	* @param start the lower bound of the range of d a t a i t e ms
	* @param end the upper bound of the range of d a t a i t e ms (not inclusive)
	* @return the range of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findByD_G(
		long dataGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the d a t a i t e ms where dataGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DATAITEMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataGroupId the data group ID
	* @param start the lower bound of the range of d a t a i t e ms
	* @param end the upper bound of the range of d a t a i t e ms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findByD_G(
		long dataGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d a t a i t e m in the ordered set where dataGroupId = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM findByD_G_First(long dataGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the first d a t a i t e m in the ordered set where dataGroupId = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d a t a i t e m, or <code>null</code> if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByD_G_First(
		long dataGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d a t a i t e m in the ordered set where dataGroupId = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM findByD_G_Last(long dataGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the last d a t a i t e m in the ordered set where dataGroupId = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d a t a i t e m, or <code>null</code> if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByD_G_Last(long dataGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d a t a i t e ms before and after the current d a t a i t e m in the ordered set where dataGroupId = &#63;.
	*
	* @param id the primary key of the current d a t a i t e m
	* @param dataGroupId the data group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a d a t a i t e m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM[] findByD_G_PrevAndNext(long id,
		long dataGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Removes all the d a t a i t e ms where dataGroupId = &#63; from the database.
	*
	* @param dataGroupId the data group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByD_G(long dataGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d a t a i t e ms where dataGroupId = &#63;.
	*
	* @param dataGroupId the data group ID
	* @return the number of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public int countByD_G(long dataGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the d a t a i t e ms where dataGroupId = &#63;.
	*
	* @param dataGroupId the data group ID
	* @return the matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findByD_G_L_1(
		long dataGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the d a t a i t e ms where dataGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DATAITEMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataGroupId the data group ID
	* @param start the lower bound of the range of d a t a i t e ms
	* @param end the upper bound of the range of d a t a i t e ms (not inclusive)
	* @return the range of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findByD_G_L_1(
		long dataGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the d a t a i t e ms where dataGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DATAITEMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataGroupId the data group ID
	* @param start the lower bound of the range of d a t a i t e ms
	* @param end the upper bound of the range of d a t a i t e ms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findByD_G_L_1(
		long dataGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d a t a i t e m in the ordered set where dataGroupId = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM findByD_G_L_1_First(
		long dataGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the first d a t a i t e m in the ordered set where dataGroupId = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d a t a i t e m, or <code>null</code> if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByD_G_L_1_First(
		long dataGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d a t a i t e m in the ordered set where dataGroupId = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM findByD_G_L_1_Last(
		long dataGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the last d a t a i t e m in the ordered set where dataGroupId = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d a t a i t e m, or <code>null</code> if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByD_G_L_1_Last(
		long dataGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d a t a i t e ms before and after the current d a t a i t e m in the ordered set where dataGroupId = &#63;.
	*
	* @param id the primary key of the current d a t a i t e m
	* @param dataGroupId the data group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a d a t a i t e m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM[] findByD_G_L_1_PrevAndNext(
		long id, long dataGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Removes all the d a t a i t e ms where dataGroupId = &#63; from the database.
	*
	* @param dataGroupId the data group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByD_G_L_1(long dataGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d a t a i t e ms where dataGroupId = &#63;.
	*
	* @param dataGroupId the data group ID
	* @return the number of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public int countByD_G_L_1(long dataGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the d a t a i t e ms where dataGroupId = &#63; and node1 = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @return the matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findByD_G_L_2(
		long dataGroupId, java.lang.String node1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the d a t a i t e ms where dataGroupId = &#63; and node1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DATAITEMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param start the lower bound of the range of d a t a i t e ms
	* @param end the upper bound of the range of d a t a i t e ms (not inclusive)
	* @return the range of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findByD_G_L_2(
		long dataGroupId, java.lang.String node1, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the d a t a i t e ms where dataGroupId = &#63; and node1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DATAITEMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param start the lower bound of the range of d a t a i t e ms
	* @param end the upper bound of the range of d a t a i t e ms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findByD_G_L_2(
		long dataGroupId, java.lang.String node1, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d a t a i t e m in the ordered set where dataGroupId = &#63; and node1 = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM findByD_G_L_2_First(
		long dataGroupId, java.lang.String node1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the first d a t a i t e m in the ordered set where dataGroupId = &#63; and node1 = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d a t a i t e m, or <code>null</code> if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByD_G_L_2_First(
		long dataGroupId, java.lang.String node1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d a t a i t e m in the ordered set where dataGroupId = &#63; and node1 = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM findByD_G_L_2_Last(
		long dataGroupId, java.lang.String node1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the last d a t a i t e m in the ordered set where dataGroupId = &#63; and node1 = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d a t a i t e m, or <code>null</code> if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByD_G_L_2_Last(
		long dataGroupId, java.lang.String node1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d a t a i t e ms before and after the current d a t a i t e m in the ordered set where dataGroupId = &#63; and node1 = &#63;.
	*
	* @param id the primary key of the current d a t a i t e m
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a d a t a i t e m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM[] findByD_G_L_2_PrevAndNext(
		long id, long dataGroupId, java.lang.String node1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Removes all the d a t a i t e ms where dataGroupId = &#63; and node1 = &#63; from the database.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @throws SystemException if a system exception occurred
	*/
	public void removeByD_G_L_2(long dataGroupId, java.lang.String node1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d a t a i t e ms where dataGroupId = &#63; and node1 = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @return the number of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public int countByD_G_L_2(long dataGroupId, java.lang.String node1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the d a t a i t e ms where dataGroupId = &#63; and node1 = &#63; and node2 = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param node2 the node2
	* @return the matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findByD_G_L_3(
		long dataGroupId, java.lang.String node1, java.lang.String node2)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the d a t a i t e ms where dataGroupId = &#63; and node1 = &#63; and node2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DATAITEMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param node2 the node2
	* @param start the lower bound of the range of d a t a i t e ms
	* @param end the upper bound of the range of d a t a i t e ms (not inclusive)
	* @return the range of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findByD_G_L_3(
		long dataGroupId, java.lang.String node1, java.lang.String node2,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the d a t a i t e ms where dataGroupId = &#63; and node1 = &#63; and node2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DATAITEMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param node2 the node2
	* @param start the lower bound of the range of d a t a i t e ms
	* @param end the upper bound of the range of d a t a i t e ms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findByD_G_L_3(
		long dataGroupId, java.lang.String node1, java.lang.String node2,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d a t a i t e m in the ordered set where dataGroupId = &#63; and node1 = &#63; and node2 = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param node2 the node2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM findByD_G_L_3_First(
		long dataGroupId, java.lang.String node1, java.lang.String node2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the first d a t a i t e m in the ordered set where dataGroupId = &#63; and node1 = &#63; and node2 = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param node2 the node2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d a t a i t e m, or <code>null</code> if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByD_G_L_3_First(
		long dataGroupId, java.lang.String node1, java.lang.String node2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d a t a i t e m in the ordered set where dataGroupId = &#63; and node1 = &#63; and node2 = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param node2 the node2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM findByD_G_L_3_Last(
		long dataGroupId, java.lang.String node1, java.lang.String node2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the last d a t a i t e m in the ordered set where dataGroupId = &#63; and node1 = &#63; and node2 = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param node2 the node2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d a t a i t e m, or <code>null</code> if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByD_G_L_3_Last(
		long dataGroupId, java.lang.String node1, java.lang.String node2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d a t a i t e ms before and after the current d a t a i t e m in the ordered set where dataGroupId = &#63; and node1 = &#63; and node2 = &#63;.
	*
	* @param id the primary key of the current d a t a i t e m
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param node2 the node2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a d a t a i t e m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM[] findByD_G_L_3_PrevAndNext(
		long id, long dataGroupId, java.lang.String node1,
		java.lang.String node2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Removes all the d a t a i t e ms where dataGroupId = &#63; and node1 = &#63; and node2 = &#63; from the database.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param node2 the node2
	* @throws SystemException if a system exception occurred
	*/
	public void removeByD_G_L_3(long dataGroupId, java.lang.String node1,
		java.lang.String node2)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d a t a i t e ms where dataGroupId = &#63; and node1 = &#63; and node2 = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param node2 the node2
	* @return the number of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public int countByD_G_L_3(long dataGroupId, java.lang.String node1,
		java.lang.String node2)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d a t a i t e m where dataGroupId = &#63; and node1 = &#63; or throws a {@link vn.dtt.cmon.dm.dao.NoSuchDATAITEMException} if it could not be found.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @return the matching d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM findByENTRY_NODE_1(
		long dataGroupId, java.lang.String node1)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the d a t a i t e m where dataGroupId = &#63; and node1 = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @return the matching d a t a i t e m, or <code>null</code> if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByENTRY_NODE_1(
		long dataGroupId, java.lang.String node1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d a t a i t e m where dataGroupId = &#63; and node1 = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching d a t a i t e m, or <code>null</code> if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByENTRY_NODE_1(
		long dataGroupId, java.lang.String node1, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the d a t a i t e m where dataGroupId = &#63; and node1 = &#63; from the database.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @return the d a t a i t e m that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM removeByENTRY_NODE_1(
		long dataGroupId, java.lang.String node1)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the number of d a t a i t e ms where dataGroupId = &#63; and node1 = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @return the number of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public int countByENTRY_NODE_1(long dataGroupId, java.lang.String node1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d a t a i t e m where dataGroupId = &#63; and node1 = &#63; and node2 = &#63; or throws a {@link vn.dtt.cmon.dm.dao.NoSuchDATAITEMException} if it could not be found.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param node2 the node2
	* @return the matching d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM findByENTRY_NODE_2(
		long dataGroupId, java.lang.String node1, java.lang.String node2)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the d a t a i t e m where dataGroupId = &#63; and node1 = &#63; and node2 = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param node2 the node2
	* @return the matching d a t a i t e m, or <code>null</code> if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByENTRY_NODE_2(
		long dataGroupId, java.lang.String node1, java.lang.String node2)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d a t a i t e m where dataGroupId = &#63; and node1 = &#63; and node2 = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param node2 the node2
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching d a t a i t e m, or <code>null</code> if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByENTRY_NODE_2(
		long dataGroupId, java.lang.String node1, java.lang.String node2,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the d a t a i t e m where dataGroupId = &#63; and node1 = &#63; and node2 = &#63; from the database.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param node2 the node2
	* @return the d a t a i t e m that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM removeByENTRY_NODE_2(
		long dataGroupId, java.lang.String node1, java.lang.String node2)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the number of d a t a i t e ms where dataGroupId = &#63; and node1 = &#63; and node2 = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param node1 the node1
	* @param node2 the node2
	* @return the number of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public int countByENTRY_NODE_2(long dataGroupId, java.lang.String node1,
		java.lang.String node2)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d a t a i t e m where dataGroupId = &#63; and node3 = &#63; or throws a {@link vn.dtt.cmon.dm.dao.NoSuchDATAITEMException} if it could not be found.
	*
	* @param dataGroupId the data group ID
	* @param node3 the node3
	* @return the matching d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM findByENTRY_NODE_3(
		long dataGroupId, java.lang.String node3)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the d a t a i t e m where dataGroupId = &#63; and node3 = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dataGroupId the data group ID
	* @param node3 the node3
	* @return the matching d a t a i t e m, or <code>null</code> if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByENTRY_NODE_3(
		long dataGroupId, java.lang.String node3)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d a t a i t e m where dataGroupId = &#63; and node3 = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dataGroupId the data group ID
	* @param node3 the node3
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching d a t a i t e m, or <code>null</code> if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByENTRY_NODE_3(
		long dataGroupId, java.lang.String node3, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the d a t a i t e m where dataGroupId = &#63; and node3 = &#63; from the database.
	*
	* @param dataGroupId the data group ID
	* @param node3 the node3
	* @return the d a t a i t e m that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM removeByENTRY_NODE_3(
		long dataGroupId, java.lang.String node3)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the number of d a t a i t e ms where dataGroupId = &#63; and node3 = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param node3 the node3
	* @return the number of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public int countByENTRY_NODE_3(long dataGroupId, java.lang.String node3)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the d a t a i t e ms where name = &#63;.
	*
	* @param name the name
	* @return the matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findByENTRY_NAME(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the d a t a i t e ms where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DATAITEMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of d a t a i t e ms
	* @param end the upper bound of the range of d a t a i t e ms (not inclusive)
	* @return the range of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findByENTRY_NAME(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the d a t a i t e ms where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DATAITEMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of d a t a i t e ms
	* @param end the upper bound of the range of d a t a i t e ms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findByENTRY_NAME(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d a t a i t e m in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM findByENTRY_NAME_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the first d a t a i t e m in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d a t a i t e m, or <code>null</code> if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByENTRY_NAME_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d a t a i t e m in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM findByENTRY_NAME_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the last d a t a i t e m in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d a t a i t e m, or <code>null</code> if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByENTRY_NAME_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d a t a i t e ms before and after the current d a t a i t e m in the ordered set where name = &#63;.
	*
	* @param id the primary key of the current d a t a i t e m
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a d a t a i t e m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM[] findByENTRY_NAME_PrevAndNext(
		long id, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Removes all the d a t a i t e ms where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByENTRY_NAME(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d a t a i t e ms where name = &#63;.
	*
	* @param name the name
	* @return the number of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public int countByENTRY_NAME(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the d a t a i t e ms where dataGroupId = &#63; and level = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param level the level
	* @return the matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findByDataGroupIdAndLevel(
		long dataGroupId, int level)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the d a t a i t e ms where dataGroupId = &#63; and level = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DATAITEMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataGroupId the data group ID
	* @param level the level
	* @param start the lower bound of the range of d a t a i t e ms
	* @param end the upper bound of the range of d a t a i t e ms (not inclusive)
	* @return the range of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findByDataGroupIdAndLevel(
		long dataGroupId, int level, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the d a t a i t e ms where dataGroupId = &#63; and level = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DATAITEMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataGroupId the data group ID
	* @param level the level
	* @param start the lower bound of the range of d a t a i t e ms
	* @param end the upper bound of the range of d a t a i t e ms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findByDataGroupIdAndLevel(
		long dataGroupId, int level, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d a t a i t e m in the ordered set where dataGroupId = &#63; and level = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM findByDataGroupIdAndLevel_First(
		long dataGroupId, int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the first d a t a i t e m in the ordered set where dataGroupId = &#63; and level = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d a t a i t e m, or <code>null</code> if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByDataGroupIdAndLevel_First(
		long dataGroupId, int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d a t a i t e m in the ordered set where dataGroupId = &#63; and level = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM findByDataGroupIdAndLevel_Last(
		long dataGroupId, int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the last d a t a i t e m in the ordered set where dataGroupId = &#63; and level = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d a t a i t e m, or <code>null</code> if a matching d a t a i t e m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByDataGroupIdAndLevel_Last(
		long dataGroupId, int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d a t a i t e ms before and after the current d a t a i t e m in the ordered set where dataGroupId = &#63; and level = &#63;.
	*
	* @param id the primary key of the current d a t a i t e m
	* @param dataGroupId the data group ID
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a d a t a i t e m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM[] findByDataGroupIdAndLevel_PrevAndNext(
		long id, long dataGroupId, int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Removes all the d a t a i t e ms where dataGroupId = &#63; and level = &#63; from the database.
	*
	* @param dataGroupId the data group ID
	* @param level the level
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDataGroupIdAndLevel(long dataGroupId, int level)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d a t a i t e ms where dataGroupId = &#63; and level = &#63;.
	*
	* @param dataGroupId the data group ID
	* @param level the level
	* @return the number of matching d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public int countByDataGroupIdAndLevel(long dataGroupId, int level)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the d a t a i t e m in the entity cache if it is enabled.
	*
	* @param dataitem the d a t a i t e m
	*/
	public void cacheResult(vn.dtt.cmon.dm.dao.model.DATAITEM dataitem);

	/**
	* Caches the d a t a i t e ms in the entity cache if it is enabled.
	*
	* @param dataitems the d a t a i t e ms
	*/
	public void cacheResult(
		java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> dataitems);

	/**
	* Creates a new d a t a i t e m with the primary key. Does not add the d a t a i t e m to the database.
	*
	* @param id the primary key for the new d a t a i t e m
	* @return the new d a t a i t e m
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM create(long id);

	/**
	* Removes the d a t a i t e m with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the d a t a i t e m
	* @return the d a t a i t e m that was removed
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a d a t a i t e m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	public vn.dtt.cmon.dm.dao.model.DATAITEM updateImpl(
		vn.dtt.cmon.dm.dao.model.DATAITEM dataitem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d a t a i t e m with the primary key or throws a {@link vn.dtt.cmon.dm.dao.NoSuchDATAITEMException} if it could not be found.
	*
	* @param id the primary key of the d a t a i t e m
	* @return the d a t a i t e m
	* @throws vn.dtt.cmon.dm.dao.NoSuchDATAITEMException if a d a t a i t e m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dm.dao.NoSuchDATAITEMException;

	/**
	* Returns the d a t a i t e m with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the d a t a i t e m
	* @return the d a t a i t e m, or <code>null</code> if a d a t a i t e m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dm.dao.model.DATAITEM fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the d a t a i t e ms.
	*
	* @return the d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the d a t a i t e ms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DATAITEMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of d a t a i t e ms
	* @param end the upper bound of the range of d a t a i t e ms (not inclusive)
	* @return the range of d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the d a t a i t e ms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DATAITEMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of d a t a i t e ms
	* @param end the upper bound of the range of d a t a i t e ms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dm.dao.model.DATAITEM> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the d a t a i t e ms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d a t a i t e ms.
	*
	* @return the number of d a t a i t e ms
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}