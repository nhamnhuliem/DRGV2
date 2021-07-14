/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package drg.moh.service.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import drg.moh.service.exception.NoSuchRpDashboardDstcException;
import drg.moh.service.model.RpDashboardDstc;
import drg.moh.service.model.RpDashboardDstcTable;
import drg.moh.service.model.impl.RpDashboardDstcImpl;
import drg.moh.service.model.impl.RpDashboardDstcModelImpl;
import drg.moh.service.service.persistence.RpDashboardDstcPersistence;

import java.io.Serializable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;

/**
 * The persistence implementation for the rp dashboard dstc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SON
 * @generated
 */
public class RpDashboardDstcPersistenceImpl
	extends BasePersistenceImpl<RpDashboardDstc>
	implements RpDashboardDstcPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RpDashboardDstcUtil</code> to access the rp dashboard dstc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RpDashboardDstcImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public RpDashboardDstcPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "_id");
		dbColumnNames.put("tenTinh", "_ten_tinh");
		dbColumnNames.put("thang", "_thang");
		dbColumnNames.put("soLuot", "_soluot");
		dbColumnNames.put("chiPhi", "_chiphi");
		dbColumnNames.put("quyDs", "_quyds");

		setDBColumnNames(dbColumnNames);

		setModelClass(RpDashboardDstc.class);

		setModelImplClass(RpDashboardDstcImpl.class);
		setModelPKClass(String.class);

		setTable(RpDashboardDstcTable.INSTANCE);
	}

	/**
	 * Caches the rp dashboard dstc in the entity cache if it is enabled.
	 *
	 * @param rpDashboardDstc the rp dashboard dstc
	 */
	@Override
	public void cacheResult(RpDashboardDstc rpDashboardDstc) {
		entityCache.putResult(
			RpDashboardDstcImpl.class, rpDashboardDstc.getPrimaryKey(),
			rpDashboardDstc);
	}

	/**
	 * Caches the rp dashboard dstcs in the entity cache if it is enabled.
	 *
	 * @param rpDashboardDstcs the rp dashboard dstcs
	 */
	@Override
	public void cacheResult(List<RpDashboardDstc> rpDashboardDstcs) {
		for (RpDashboardDstc rpDashboardDstc : rpDashboardDstcs) {
			if (entityCache.getResult(
					RpDashboardDstcImpl.class,
					rpDashboardDstc.getPrimaryKey()) == null) {

				cacheResult(rpDashboardDstc);
			}
		}
	}

	/**
	 * Clears the cache for all rp dashboard dstcs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RpDashboardDstcImpl.class);

		finderCache.clearCache(RpDashboardDstcImpl.class);
	}

	/**
	 * Clears the cache for the rp dashboard dstc.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RpDashboardDstc rpDashboardDstc) {
		entityCache.removeResult(RpDashboardDstcImpl.class, rpDashboardDstc);
	}

	@Override
	public void clearCache(List<RpDashboardDstc> rpDashboardDstcs) {
		for (RpDashboardDstc rpDashboardDstc : rpDashboardDstcs) {
			entityCache.removeResult(
				RpDashboardDstcImpl.class, rpDashboardDstc);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RpDashboardDstcImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RpDashboardDstcImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new rp dashboard dstc with the primary key. Does not add the rp dashboard dstc to the database.
	 *
	 * @param id the primary key for the new rp dashboard dstc
	 * @return the new rp dashboard dstc
	 */
	@Override
	public RpDashboardDstc create(String id) {
		RpDashboardDstc rpDashboardDstc = new RpDashboardDstcImpl();

		rpDashboardDstc.setNew(true);
		rpDashboardDstc.setPrimaryKey(id);

		return rpDashboardDstc;
	}

	/**
	 * Removes the rp dashboard dstc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the rp dashboard dstc
	 * @return the rp dashboard dstc that was removed
	 * @throws NoSuchRpDashboardDstcException if a rp dashboard dstc with the primary key could not be found
	 */
	@Override
	public RpDashboardDstc remove(String id)
		throws NoSuchRpDashboardDstcException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the rp dashboard dstc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rp dashboard dstc
	 * @return the rp dashboard dstc that was removed
	 * @throws NoSuchRpDashboardDstcException if a rp dashboard dstc with the primary key could not be found
	 */
	@Override
	public RpDashboardDstc remove(Serializable primaryKey)
		throws NoSuchRpDashboardDstcException {

		Session session = null;

		try {
			session = openSession();

			RpDashboardDstc rpDashboardDstc = (RpDashboardDstc)session.get(
				RpDashboardDstcImpl.class, primaryKey);

			if (rpDashboardDstc == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRpDashboardDstcException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rpDashboardDstc);
		}
		catch (NoSuchRpDashboardDstcException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected RpDashboardDstc removeImpl(RpDashboardDstc rpDashboardDstc) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rpDashboardDstc)) {
				rpDashboardDstc = (RpDashboardDstc)session.get(
					RpDashboardDstcImpl.class,
					rpDashboardDstc.getPrimaryKeyObj());
			}

			if (rpDashboardDstc != null) {
				session.delete(rpDashboardDstc);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (rpDashboardDstc != null) {
			clearCache(rpDashboardDstc);
		}

		return rpDashboardDstc;
	}

	@Override
	public RpDashboardDstc updateImpl(RpDashboardDstc rpDashboardDstc) {
		boolean isNew = rpDashboardDstc.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(rpDashboardDstc);
			}
			else {
				rpDashboardDstc = (RpDashboardDstc)session.merge(
					rpDashboardDstc);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RpDashboardDstcImpl.class, rpDashboardDstc, false, true);

		if (isNew) {
			rpDashboardDstc.setNew(false);
		}

		rpDashboardDstc.resetOriginalValues();

		return rpDashboardDstc;
	}

	/**
	 * Returns the rp dashboard dstc with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rp dashboard dstc
	 * @return the rp dashboard dstc
	 * @throws NoSuchRpDashboardDstcException if a rp dashboard dstc with the primary key could not be found
	 */
	@Override
	public RpDashboardDstc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRpDashboardDstcException {

		RpDashboardDstc rpDashboardDstc = fetchByPrimaryKey(primaryKey);

		if (rpDashboardDstc == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRpDashboardDstcException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rpDashboardDstc;
	}

	/**
	 * Returns the rp dashboard dstc with the primary key or throws a <code>NoSuchRpDashboardDstcException</code> if it could not be found.
	 *
	 * @param id the primary key of the rp dashboard dstc
	 * @return the rp dashboard dstc
	 * @throws NoSuchRpDashboardDstcException if a rp dashboard dstc with the primary key could not be found
	 */
	@Override
	public RpDashboardDstc findByPrimaryKey(String id)
		throws NoSuchRpDashboardDstcException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the rp dashboard dstc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the rp dashboard dstc
	 * @return the rp dashboard dstc, or <code>null</code> if a rp dashboard dstc with the primary key could not be found
	 */
	@Override
	public RpDashboardDstc fetchByPrimaryKey(String id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the rp dashboard dstcs.
	 *
	 * @return the rp dashboard dstcs
	 */
	@Override
	public List<RpDashboardDstc> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rp dashboard dstcs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RpDashboardDstcModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rp dashboard dstcs
	 * @param end the upper bound of the range of rp dashboard dstcs (not inclusive)
	 * @return the range of rp dashboard dstcs
	 */
	@Override
	public List<RpDashboardDstc> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rp dashboard dstcs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RpDashboardDstcModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rp dashboard dstcs
	 * @param end the upper bound of the range of rp dashboard dstcs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rp dashboard dstcs
	 */
	@Override
	public List<RpDashboardDstc> findAll(
		int start, int end,
		OrderByComparator<RpDashboardDstc> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rp dashboard dstcs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RpDashboardDstcModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rp dashboard dstcs
	 * @param end the upper bound of the range of rp dashboard dstcs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rp dashboard dstcs
	 */
	@Override
	public List<RpDashboardDstc> findAll(
		int start, int end,
		OrderByComparator<RpDashboardDstc> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<RpDashboardDstc> list = null;

		if (useFinderCache) {
			list = (List<RpDashboardDstc>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RPDASHBOARDDSTC);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RPDASHBOARDDSTC;

				sql = sql.concat(RpDashboardDstcModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RpDashboardDstc>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the rp dashboard dstcs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RpDashboardDstc rpDashboardDstc : findAll()) {
			remove(rpDashboardDstc);
		}
	}

	/**
	 * Returns the number of rp dashboard dstcs.
	 *
	 * @return the number of rp dashboard dstcs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RPDASHBOARDDSTC);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RPDASHBOARDDSTC;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RpDashboardDstcModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rp dashboard dstc persistence.
	 */
	public void afterPropertiesSet() {
		Bundle bundle = FrameworkUtil.getBundle(
			RpDashboardDstcPersistenceImpl.class);

		_bundleContext = bundle.getBundleContext();

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new RpDashboardDstcModelArgumentsResolver(),
			new HashMapDictionary<>());

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);
	}

	public void destroy() {
		entityCache.removeCache(RpDashboardDstcImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();
	}

	private BundleContext _bundleContext;

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_RPDASHBOARDDSTC =
		"SELECT rpDashboardDstc FROM RpDashboardDstc rpDashboardDstc";

	private static final String _SQL_COUNT_RPDASHBOARDDSTC =
		"SELECT COUNT(rpDashboardDstc) FROM RpDashboardDstc rpDashboardDstc";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rpDashboardDstc.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RpDashboardDstc exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		RpDashboardDstcPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "tenTinh", "thang", "soLuot", "chiPhi", "quyDs"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class RpDashboardDstcModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			RpDashboardDstcModelImpl rpDashboardDstcModelImpl =
				(RpDashboardDstcModelImpl)baseModel;

			long columnBitmask = rpDashboardDstcModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					rpDashboardDstcModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						rpDashboardDstcModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					rpDashboardDstcModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return RpDashboardDstcImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return RpDashboardDstcTable.INSTANCE.getTableName();
		}

		private Object[] _getValue(
			RpDashboardDstcModelImpl rpDashboardDstcModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						rpDashboardDstcModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = rpDashboardDstcModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}