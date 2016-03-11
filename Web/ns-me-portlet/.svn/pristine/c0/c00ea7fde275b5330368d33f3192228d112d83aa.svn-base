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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.dtt.cmon.dm.dao.NoSuchDM_THONXOMException;
import vn.dtt.cmon.dm.dao.model.DM_THONXOM;
import vn.dtt.cmon.dm.dao.model.impl.DM_THONXOMImpl;
import vn.dtt.cmon.dm.dao.model.impl.DM_THONXOMModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the d m_ t h o n x o m service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoa.vu
 * @see DM_THONXOMPersistence
 * @see DM_THONXOMUtil
 * @generated
 */
public class DM_THONXOMPersistenceImpl extends BasePersistenceImpl<DM_THONXOM>
	implements DM_THONXOMPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DM_THONXOMUtil} to access the d m_ t h o n x o m persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DM_THONXOMImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DM_THONXOMModelImpl.ENTITY_CACHE_ENABLED,
			DM_THONXOMModelImpl.FINDER_CACHE_ENABLED, DM_THONXOMImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DM_THONXOMModelImpl.ENTITY_CACHE_ENABLED,
			DM_THONXOMModelImpl.FINDER_CACHE_ENABLED, DM_THONXOMImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DM_THONXOMModelImpl.ENTITY_CACHE_ENABLED,
			DM_THONXOMModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public DM_THONXOMPersistenceImpl() {
		setModelClass(DM_THONXOM.class);
	}

	/**
	 * Caches the d m_ t h o n x o m in the entity cache if it is enabled.
	 *
	 * @param dm_thonxom the d m_ t h o n x o m
	 */
	@Override
	public void cacheResult(DM_THONXOM dm_thonxom) {
		EntityCacheUtil.putResult(DM_THONXOMModelImpl.ENTITY_CACHE_ENABLED,
			DM_THONXOMImpl.class, dm_thonxom.getPrimaryKey(), dm_thonxom);

		dm_thonxom.resetOriginalValues();
	}

	/**
	 * Caches the d m_ t h o n x o ms in the entity cache if it is enabled.
	 *
	 * @param dm_thonxoms the d m_ t h o n x o ms
	 */
	@Override
	public void cacheResult(List<DM_THONXOM> dm_thonxoms) {
		for (DM_THONXOM dm_thonxom : dm_thonxoms) {
			if (EntityCacheUtil.getResult(
						DM_THONXOMModelImpl.ENTITY_CACHE_ENABLED,
						DM_THONXOMImpl.class, dm_thonxom.getPrimaryKey()) == null) {
				cacheResult(dm_thonxom);
			}
			else {
				dm_thonxom.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all d m_ t h o n x o ms.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DM_THONXOMImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DM_THONXOMImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the d m_ t h o n x o m.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DM_THONXOM dm_thonxom) {
		EntityCacheUtil.removeResult(DM_THONXOMModelImpl.ENTITY_CACHE_ENABLED,
			DM_THONXOMImpl.class, dm_thonxom.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DM_THONXOM> dm_thonxoms) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DM_THONXOM dm_thonxom : dm_thonxoms) {
			EntityCacheUtil.removeResult(DM_THONXOMModelImpl.ENTITY_CACHE_ENABLED,
				DM_THONXOMImpl.class, dm_thonxom.getPrimaryKey());
		}
	}

	/**
	 * Creates a new d m_ t h o n x o m with the primary key. Does not add the d m_ t h o n x o m to the database.
	 *
	 * @param id the primary key for the new d m_ t h o n x o m
	 * @return the new d m_ t h o n x o m
	 */
	@Override
	public DM_THONXOM create(long id) {
		DM_THONXOM dm_thonxom = new DM_THONXOMImpl();

		dm_thonxom.setNew(true);
		dm_thonxom.setPrimaryKey(id);

		return dm_thonxom;
	}

	/**
	 * Removes the d m_ t h o n x o m with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the d m_ t h o n x o m
	 * @return the d m_ t h o n x o m that was removed
	 * @throws vn.dtt.cmon.dm.dao.NoSuchDM_THONXOMException if a d m_ t h o n x o m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DM_THONXOM remove(long id)
		throws NoSuchDM_THONXOMException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the d m_ t h o n x o m with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the d m_ t h o n x o m
	 * @return the d m_ t h o n x o m that was removed
	 * @throws vn.dtt.cmon.dm.dao.NoSuchDM_THONXOMException if a d m_ t h o n x o m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DM_THONXOM remove(Serializable primaryKey)
		throws NoSuchDM_THONXOMException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DM_THONXOM dm_thonxom = (DM_THONXOM)session.get(DM_THONXOMImpl.class,
					primaryKey);

			if (dm_thonxom == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDM_THONXOMException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dm_thonxom);
		}
		catch (NoSuchDM_THONXOMException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DM_THONXOM removeImpl(DM_THONXOM dm_thonxom)
		throws SystemException {
		dm_thonxom = toUnwrappedModel(dm_thonxom);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dm_thonxom)) {
				dm_thonxom = (DM_THONXOM)session.get(DM_THONXOMImpl.class,
						dm_thonxom.getPrimaryKeyObj());
			}

			if (dm_thonxom != null) {
				session.delete(dm_thonxom);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dm_thonxom != null) {
			clearCache(dm_thonxom);
		}

		return dm_thonxom;
	}

	@Override
	public DM_THONXOM updateImpl(vn.dtt.cmon.dm.dao.model.DM_THONXOM dm_thonxom)
		throws SystemException {
		dm_thonxom = toUnwrappedModel(dm_thonxom);

		boolean isNew = dm_thonxom.isNew();

		Session session = null;

		try {
			session = openSession();

			if (dm_thonxom.isNew()) {
				session.save(dm_thonxom);

				dm_thonxom.setNew(false);
			}
			else {
				session.merge(dm_thonxom);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(DM_THONXOMModelImpl.ENTITY_CACHE_ENABLED,
			DM_THONXOMImpl.class, dm_thonxom.getPrimaryKey(), dm_thonxom);

		return dm_thonxom;
	}

	protected DM_THONXOM toUnwrappedModel(DM_THONXOM dm_thonxom) {
		if (dm_thonxom instanceof DM_THONXOMImpl) {
			return dm_thonxom;
		}

		DM_THONXOMImpl dm_thonxomImpl = new DM_THONXOMImpl();

		dm_thonxomImpl.setNew(dm_thonxom.isNew());
		dm_thonxomImpl.setPrimaryKey(dm_thonxom.getPrimaryKey());

		dm_thonxomImpl.setId(dm_thonxom.getId());
		dm_thonxomImpl.setMaTinh(dm_thonxom.getMaTinh());
		dm_thonxomImpl.setMaHuyen(dm_thonxom.getMaHuyen());
		dm_thonxomImpl.setMaXa(dm_thonxom.getMaXa());
		dm_thonxomImpl.setThonXom(dm_thonxom.getThonXom());

		return dm_thonxomImpl;
	}

	/**
	 * Returns the d m_ t h o n x o m with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the d m_ t h o n x o m
	 * @return the d m_ t h o n x o m
	 * @throws vn.dtt.cmon.dm.dao.NoSuchDM_THONXOMException if a d m_ t h o n x o m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DM_THONXOM findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDM_THONXOMException, SystemException {
		DM_THONXOM dm_thonxom = fetchByPrimaryKey(primaryKey);

		if (dm_thonxom == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDM_THONXOMException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dm_thonxom;
	}

	/**
	 * Returns the d m_ t h o n x o m with the primary key or throws a {@link vn.dtt.cmon.dm.dao.NoSuchDM_THONXOMException} if it could not be found.
	 *
	 * @param id the primary key of the d m_ t h o n x o m
	 * @return the d m_ t h o n x o m
	 * @throws vn.dtt.cmon.dm.dao.NoSuchDM_THONXOMException if a d m_ t h o n x o m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DM_THONXOM findByPrimaryKey(long id)
		throws NoSuchDM_THONXOMException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the d m_ t h o n x o m with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the d m_ t h o n x o m
	 * @return the d m_ t h o n x o m, or <code>null</code> if a d m_ t h o n x o m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DM_THONXOM fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DM_THONXOM dm_thonxom = (DM_THONXOM)EntityCacheUtil.getResult(DM_THONXOMModelImpl.ENTITY_CACHE_ENABLED,
				DM_THONXOMImpl.class, primaryKey);

		if (dm_thonxom == _nullDM_THONXOM) {
			return null;
		}

		if (dm_thonxom == null) {
			Session session = null;

			try {
				session = openSession();

				dm_thonxom = (DM_THONXOM)session.get(DM_THONXOMImpl.class,
						primaryKey);

				if (dm_thonxom != null) {
					cacheResult(dm_thonxom);
				}
				else {
					EntityCacheUtil.putResult(DM_THONXOMModelImpl.ENTITY_CACHE_ENABLED,
						DM_THONXOMImpl.class, primaryKey, _nullDM_THONXOM);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DM_THONXOMModelImpl.ENTITY_CACHE_ENABLED,
					DM_THONXOMImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dm_thonxom;
	}

	/**
	 * Returns the d m_ t h o n x o m with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the d m_ t h o n x o m
	 * @return the d m_ t h o n x o m, or <code>null</code> if a d m_ t h o n x o m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DM_THONXOM fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the d m_ t h o n x o ms.
	 *
	 * @return the d m_ t h o n x o ms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DM_THONXOM> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the d m_ t h o n x o ms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DM_THONXOMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of d m_ t h o n x o ms
	 * @param end the upper bound of the range of d m_ t h o n x o ms (not inclusive)
	 * @return the range of d m_ t h o n x o ms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DM_THONXOM> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the d m_ t h o n x o ms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.cmon.dm.dao.model.impl.DM_THONXOMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of d m_ t h o n x o ms
	 * @param end the upper bound of the range of d m_ t h o n x o ms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of d m_ t h o n x o ms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DM_THONXOM> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<DM_THONXOM> list = (List<DM_THONXOM>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DM_THONXOM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DM_THONXOM;

				if (pagination) {
					sql = sql.concat(DM_THONXOMModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DM_THONXOM>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DM_THONXOM>(list);
				}
				else {
					list = (List<DM_THONXOM>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the d m_ t h o n x o ms from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DM_THONXOM dm_thonxom : findAll()) {
			remove(dm_thonxom);
		}
	}

	/**
	 * Returns the number of d m_ t h o n x o ms.
	 *
	 * @return the number of d m_ t h o n x o ms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DM_THONXOM);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the d m_ t h o n x o m persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.dtt.cmon.dm.dao.model.DM_THONXOM")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DM_THONXOM>> listenersList = new ArrayList<ModelListener<DM_THONXOM>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DM_THONXOM>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(DM_THONXOMImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DM_THONXOM = "SELECT dm_thonxom FROM DM_THONXOM dm_thonxom";
	private static final String _SQL_COUNT_DM_THONXOM = "SELECT COUNT(dm_thonxom) FROM DM_THONXOM dm_thonxom";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dm_thonxom.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DM_THONXOM exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DM_THONXOMPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"maTinh", "maHuyen", "maXa", "thonXom"
			});
	private static DM_THONXOM _nullDM_THONXOM = new DM_THONXOMImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DM_THONXOM> toCacheModel() {
				return _nullDM_THONXOMCacheModel;
			}
		};

	private static CacheModel<DM_THONXOM> _nullDM_THONXOMCacheModel = new CacheModel<DM_THONXOM>() {
			@Override
			public DM_THONXOM toEntityModel() {
				return _nullDM_THONXOM;
			}
		};
}