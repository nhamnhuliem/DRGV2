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

package drg.moh.service.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import drg.moh.service.model.RpDashboardCphd;
import drg.moh.service.model.RpDashboardCphdModel;
import drg.moh.service.model.RpDashboardCphdSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the RpDashboardCphd service. Represents a row in the &quot;rp_dashboard_cphd&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>RpDashboardCphdModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RpDashboardCphdImpl}.
 * </p>
 *
 * @author SON
 * @see RpDashboardCphdImpl
 * @generated
 */
@JSON(strict = true)
public class RpDashboardCphdModelImpl
	extends BaseModelImpl<RpDashboardCphd> implements RpDashboardCphdModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a rp dashboard cphd model instance should use the <code>RpDashboardCphd</code> interface instead.
	 */
	public static final String TABLE_NAME = "rp_dashboard_cphd";

	public static final Object[][] TABLE_COLUMNS = {
		{"_id", Types.BIGINT}, {"_ten_tinh", Types.VARCHAR},
		{"_chiphi", Types.DOUBLE}, {"_dinhsuat", Types.DOUBLE},
		{"_drg", Types.DOUBLE}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("_ten_tinh", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("_chiphi", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("_dinhsuat", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("_drg", Types.DOUBLE);
	}

	public static final String TABLE_SQL_CREATE =
		"create table rp_dashboard_cphd (_id LONG not null primary key,_ten_tinh VARCHAR(75) null,_chiphi DOUBLE,_dinhsuat DOUBLE,_drg DOUBLE)";

	public static final String TABLE_SQL_DROP = "drop table rp_dashboard_cphd";

	public static final String ORDER_BY_JPQL =
		" ORDER BY rpDashboardCphd.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY rp_dashboard_cphd._id ASC";

	public static final String DATA_SOURCE = "drgDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean ENTITY_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean FINDER_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean COLUMN_BITMASK_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ID_COLUMN_BITMASK = 1L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static RpDashboardCphd toModel(RpDashboardCphdSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		RpDashboardCphd model = new RpDashboardCphdImpl();

		model.setId(soapModel.getId());
		model.setTenTinh(soapModel.getTenTinh());
		model.setChiPhi(soapModel.getChiPhi());
		model.setDinhSuat(soapModel.getDinhSuat());
		model.setDrg(soapModel.getDrg());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<RpDashboardCphd> toModels(
		RpDashboardCphdSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<RpDashboardCphd> models = new ArrayList<RpDashboardCphd>(
			soapModels.length);

		for (RpDashboardCphdSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		drg.moh.service.service.util.ServiceProps.get(
			"lock.expiration.time.drg.moh.service.model.RpDashboardCphd"));

	public RpDashboardCphdModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return RpDashboardCphd.class;
	}

	@Override
	public String getModelClassName() {
		return RpDashboardCphd.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<RpDashboardCphd, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<RpDashboardCphd, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RpDashboardCphd, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((RpDashboardCphd)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<RpDashboardCphd, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<RpDashboardCphd, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(RpDashboardCphd)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<RpDashboardCphd, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<RpDashboardCphd, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, RpDashboardCphd>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			RpDashboardCphd.class.getClassLoader(), RpDashboardCphd.class,
			ModelWrapper.class);

		try {
			Constructor<RpDashboardCphd> constructor =
				(Constructor<RpDashboardCphd>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<RpDashboardCphd, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<RpDashboardCphd, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<RpDashboardCphd, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<RpDashboardCphd, Object>>();
		Map<String, BiConsumer<RpDashboardCphd, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<RpDashboardCphd, ?>>();

		attributeGetterFunctions.put("id", RpDashboardCphd::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<RpDashboardCphd, Long>)RpDashboardCphd::setId);
		attributeGetterFunctions.put("tenTinh", RpDashboardCphd::getTenTinh);
		attributeSetterBiConsumers.put(
			"tenTinh",
			(BiConsumer<RpDashboardCphd, String>)RpDashboardCphd::setTenTinh);
		attributeGetterFunctions.put("chiPhi", RpDashboardCphd::getChiPhi);
		attributeSetterBiConsumers.put(
			"chiPhi",
			(BiConsumer<RpDashboardCphd, Double>)RpDashboardCphd::setChiPhi);
		attributeGetterFunctions.put("dinhSuat", RpDashboardCphd::getDinhSuat);
		attributeSetterBiConsumers.put(
			"dinhSuat",
			(BiConsumer<RpDashboardCphd, Double>)RpDashboardCphd::setDinhSuat);
		attributeGetterFunctions.put("drg", RpDashboardCphd::getDrg);
		attributeSetterBiConsumers.put(
			"drg",
			(BiConsumer<RpDashboardCphd, Double>)RpDashboardCphd::setDrg);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_id = id;
	}

	@JSON
	@Override
	public String getTenTinh() {
		if (_tenTinh == null) {
			return "";
		}
		else {
			return _tenTinh;
		}
	}

	@Override
	public void setTenTinh(String tenTinh) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_tenTinh = tenTinh;
	}

	@JSON
	@Override
	public double getChiPhi() {
		return _chiPhi;
	}

	@Override
	public void setChiPhi(double chiPhi) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_chiPhi = chiPhi;
	}

	@JSON
	@Override
	public double getDinhSuat() {
		return _dinhSuat;
	}

	@Override
	public void setDinhSuat(double dinhSuat) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dinhSuat = dinhSuat;
	}

	@JSON
	@Override
	public double getDrg() {
		return _drg;
	}

	@Override
	public void setDrg(double drg) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_drg = drg;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (entry.getValue() != getColumnValue(entry.getKey())) {
				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, RpDashboardCphd.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RpDashboardCphd toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, RpDashboardCphd>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RpDashboardCphdImpl rpDashboardCphdImpl = new RpDashboardCphdImpl();

		rpDashboardCphdImpl.setId(getId());
		rpDashboardCphdImpl.setTenTinh(getTenTinh());
		rpDashboardCphdImpl.setChiPhi(getChiPhi());
		rpDashboardCphdImpl.setDinhSuat(getDinhSuat());
		rpDashboardCphdImpl.setDrg(getDrg());

		rpDashboardCphdImpl.resetOriginalValues();

		return rpDashboardCphdImpl;
	}

	@Override
	public int compareTo(RpDashboardCphd rpDashboardCphd) {
		long primaryKey = rpDashboardCphd.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RpDashboardCphd)) {
			return false;
		}

		RpDashboardCphd rpDashboardCphd = (RpDashboardCphd)object;

		long primaryKey = rpDashboardCphd.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<RpDashboardCphd> toCacheModel() {
		RpDashboardCphdCacheModel rpDashboardCphdCacheModel =
			new RpDashboardCphdCacheModel();

		rpDashboardCphdCacheModel.id = getId();

		rpDashboardCphdCacheModel.tenTinh = getTenTinh();

		String tenTinh = rpDashboardCphdCacheModel.tenTinh;

		if ((tenTinh != null) && (tenTinh.length() == 0)) {
			rpDashboardCphdCacheModel.tenTinh = null;
		}

		rpDashboardCphdCacheModel.chiPhi = getChiPhi();

		rpDashboardCphdCacheModel.dinhSuat = getDinhSuat();

		rpDashboardCphdCacheModel.drg = getDrg();

		return rpDashboardCphdCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<RpDashboardCphd, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<RpDashboardCphd, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RpDashboardCphd, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((RpDashboardCphd)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<RpDashboardCphd, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<RpDashboardCphd, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RpDashboardCphd, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((RpDashboardCphd)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, RpDashboardCphd>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _id;
	private String _tenTinh;
	private double _chiPhi;
	private double _dinhSuat;
	private double _drg;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<RpDashboardCphd, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((RpDashboardCphd)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("_id", _id);
		_columnOriginalValues.put("_ten_tinh", _tenTinh);
		_columnOriginalValues.put("_chiphi", _chiPhi);
		_columnOriginalValues.put("_dinhsuat", _dinhSuat);
		_columnOriginalValues.put("_drg", _drg);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("_id", "id");
		attributeNames.put("_ten_tinh", "tenTinh");
		attributeNames.put("_chiphi", "chiPhi");
		attributeNames.put("_dinhsuat", "dinhSuat");
		attributeNames.put("_drg", "drg");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("_id", 1L);

		columnBitmasks.put("_ten_tinh", 2L);

		columnBitmasks.put("_chiphi", 4L);

		columnBitmasks.put("_dinhsuat", 8L);

		columnBitmasks.put("_drg", 16L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private RpDashboardCphd _escapedModel;

}