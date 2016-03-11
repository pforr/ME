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

package vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import vn.dtt.sol.ns.vesinhmoitruong.dao.model.keHoachVeSinhXaNew;

/**
 * The persistence interface for the ke hoach ve sinh xa new service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhTH
 * @see keHoachVeSinhXaNewPersistenceImpl
 * @see keHoachVeSinhXaNewUtil
 * @generated
 */
public interface keHoachVeSinhXaNewPersistence extends BasePersistence<keHoachVeSinhXaNew> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link keHoachVeSinhXaNewUtil} to access the ke hoach ve sinh xa new persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ke hoach ve sinh xa new in the entity cache if it is enabled.
	*
	* @param keHoachVeSinhXaNew the ke hoach ve sinh xa new
	*/
	public void cacheResult(
		vn.dtt.sol.ns.vesinhmoitruong.dao.model.keHoachVeSinhXaNew keHoachVeSinhXaNew);

	/**
	* Caches the ke hoach ve sinh xa news in the entity cache if it is enabled.
	*
	* @param keHoachVeSinhXaNews the ke hoach ve sinh xa news
	*/
	public void cacheResult(
		java.util.List<vn.dtt.sol.ns.vesinhmoitruong.dao.model.keHoachVeSinhXaNew> keHoachVeSinhXaNews);

	/**
	* Creates a new ke hoach ve sinh xa new with the primary key. Does not add the ke hoach ve sinh xa new to the database.
	*
	* @param id the primary key for the new ke hoach ve sinh xa new
	* @return the new ke hoach ve sinh xa new
	*/
	public vn.dtt.sol.ns.vesinhmoitruong.dao.model.keHoachVeSinhXaNew create(
		int id);

	/**
	* Removes the ke hoach ve sinh xa new with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ke hoach ve sinh xa new
	* @return the ke hoach ve sinh xa new that was removed
	* @throws vn.dtt.sol.ns.vesinhmoitruong.dao.NoSuchkeHoachVeSinhXaNewException if a ke hoach ve sinh xa new with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.sol.ns.vesinhmoitruong.dao.model.keHoachVeSinhXaNew remove(
		int id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.sol.ns.vesinhmoitruong.dao.NoSuchkeHoachVeSinhXaNewException;

	public vn.dtt.sol.ns.vesinhmoitruong.dao.model.keHoachVeSinhXaNew updateImpl(
		vn.dtt.sol.ns.vesinhmoitruong.dao.model.keHoachVeSinhXaNew keHoachVeSinhXaNew)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ke hoach ve sinh xa new with the primary key or throws a {@link vn.dtt.sol.ns.vesinhmoitruong.dao.NoSuchkeHoachVeSinhXaNewException} if it could not be found.
	*
	* @param id the primary key of the ke hoach ve sinh xa new
	* @return the ke hoach ve sinh xa new
	* @throws vn.dtt.sol.ns.vesinhmoitruong.dao.NoSuchkeHoachVeSinhXaNewException if a ke hoach ve sinh xa new with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.sol.ns.vesinhmoitruong.dao.model.keHoachVeSinhXaNew findByPrimaryKey(
		int id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.sol.ns.vesinhmoitruong.dao.NoSuchkeHoachVeSinhXaNewException;

	/**
	* Returns the ke hoach ve sinh xa new with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ke hoach ve sinh xa new
	* @return the ke hoach ve sinh xa new, or <code>null</code> if a ke hoach ve sinh xa new with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.sol.ns.vesinhmoitruong.dao.model.keHoachVeSinhXaNew fetchByPrimaryKey(
		int id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ke hoach ve sinh xa news.
	*
	* @return the ke hoach ve sinh xa news
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.sol.ns.vesinhmoitruong.dao.model.keHoachVeSinhXaNew> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ke hoach ve sinh xa news.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl.keHoachVeSinhXaNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ke hoach ve sinh xa news
	* @param end the upper bound of the range of ke hoach ve sinh xa news (not inclusive)
	* @return the range of ke hoach ve sinh xa news
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.sol.ns.vesinhmoitruong.dao.model.keHoachVeSinhXaNew> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ke hoach ve sinh xa news.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl.keHoachVeSinhXaNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ke hoach ve sinh xa news
	* @param end the upper bound of the range of ke hoach ve sinh xa news (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ke hoach ve sinh xa news
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.sol.ns.vesinhmoitruong.dao.model.keHoachVeSinhXaNew> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ke hoach ve sinh xa news from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ke hoach ve sinh xa news.
	*
	* @return the number of ke hoach ve sinh xa news
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}