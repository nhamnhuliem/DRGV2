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

import drg.moh.service.model.ThongKeBaoCao;
import drg.moh.service.model.ThongKeBaoCaoModel;
import drg.moh.service.model.ThongKeBaoCaoSoap;

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
 * The base model implementation for the ThongKeBaoCao service. Represents a row in the &quot;dashboard_thongke_1&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ThongKeBaoCaoModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ThongKeBaoCaoImpl}.
 * </p>
 *
 * @author SON
 * @see ThongKeBaoCaoImpl
 * @generated
 */
@JSON(strict = true)
public class ThongKeBaoCaoModelImpl
	extends BaseModelImpl<ThongKeBaoCao> implements ThongKeBaoCaoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a thong ke bao cao model instance should use the <code>ThongKeBaoCao</code> interface instead.
	 */
	public static final String TABLE_NAME = "dashboard_thongke_1";

	public static final Object[][] TABLE_COLUMNS = {
		{"id", Types.BIGINT}, {"nam", Types.INTEGER}, {"thang", Types.INTEGER},
		{"tong_hoso", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("nam", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("thang", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("tong_hoso", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table dashboard_thongke_1 (id LONG not null primary key,nam INTEGER,thang INTEGER,tong_hoso LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table dashboard_thongke_1";

	public static final String ORDER_BY_JPQL = " ORDER BY thongKeBaoCao.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY dashboard_thongke_1.id ASC";

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
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NAM_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static ThongKeBaoCao toModel(ThongKeBaoCaoSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ThongKeBaoCao model = new ThongKeBaoCaoImpl();

		model.setId(soapModel.getId());
		model.setNam(soapModel.getNam());
		model.setThang(soapModel.getThang());
		model.setTongHoSo(soapModel.getTongHoSo());

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
	public static List<ThongKeBaoCao> toModels(ThongKeBaoCaoSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ThongKeBaoCao> models = new ArrayList<ThongKeBaoCao>(
			soapModels.length);

		for (ThongKeBaoCaoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		drg.moh.service.service.util.ServiceProps.get(
			"lock.expiration.time.drg.moh.service.model.ThongKeBaoCao"));

	public ThongKeBaoCaoModelImpl() {
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
		return ThongKeBaoCao.class;
	}

	@Override
	public String getModelClassName() {
		return ThongKeBaoCao.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ThongKeBaoCao, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ThongKeBaoCao, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ThongKeBaoCao, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ThongKeBaoCao)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ThongKeBaoCao, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ThongKeBaoCao, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ThongKeBaoCao)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ThongKeBaoCao, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ThongKeBaoCao, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ThongKeBaoCao>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ThongKeBaoCao.class.getClassLoader(), ThongKeBaoCao.class,
			ModelWrapper.class);

		try {
			Constructor<ThongKeBaoCao> constructor =
				(Constructor<ThongKeBaoCao>)proxyClass.getConstructor(
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

	private static final Map<String, Function<ThongKeBaoCao, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ThongKeBaoCao, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ThongKeBaoCao, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<ThongKeBaoCao, Object>>();
		Map<String, BiConsumer<ThongKeBaoCao, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ThongKeBaoCao, ?>>();

		attributeGetterFunctions.put("id", ThongKeBaoCao::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<ThongKeBaoCao, Long>)ThongKeBaoCao::setId);
		attributeGetterFunctions.put("nam", ThongKeBaoCao::getNam);
		attributeSetterBiConsumers.put(
			"nam", (BiConsumer<ThongKeBaoCao, Integer>)ThongKeBaoCao::setNam);
		attributeGetterFunctions.put("thang", ThongKeBaoCao::getThang);
		attributeSetterBiConsumers.put(
			"thang",
			(BiConsumer<ThongKeBaoCao, Integer>)ThongKeBaoCao::setThang);
		attributeGetterFunctions.put("tongHoSo", ThongKeBaoCao::getTongHoSo);
		attributeSetterBiConsumers.put(
			"tongHoSo",
			(BiConsumer<ThongKeBaoCao, Long>)ThongKeBaoCao::setTongHoSo);

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
	public int getNam() {
		return _nam;
	}

	@Override
	public void setNam(int nam) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nam = nam;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public int getOriginalNam() {
		return GetterUtil.getInteger(
			this.<Integer>getColumnOriginalValue("nam"));
	}

	@JSON
	@Override
	public int getThang() {
		return _thang;
	}

	@Override
	public void setThang(int thang) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_thang = thang;
	}

	@JSON
	@Override
	public long getTongHoSo() {
		return _tongHoSo;
	}

	@Override
	public void setTongHoSo(long tongHoSo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_tongHoSo = tongHoSo;
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
			0, ThongKeBaoCao.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ThongKeBaoCao toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ThongKeBaoCao>
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
		ThongKeBaoCaoImpl thongKeBaoCaoImpl = new ThongKeBaoCaoImpl();

		thongKeBaoCaoImpl.setId(getId());
		thongKeBaoCaoImpl.setNam(getNam());
		thongKeBaoCaoImpl.setThang(getThang());
		thongKeBaoCaoImpl.setTongHoSo(getTongHoSo());

		thongKeBaoCaoImpl.resetOriginalValues();

		return thongKeBaoCaoImpl;
	}

	@Override
	public int compareTo(ThongKeBaoCao thongKeBaoCao) {
		int value = 0;

		if (getId() < thongKeBaoCao.getId()) {
			value = -1;
		}
		else if (getId() > thongKeBaoCao.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ThongKeBaoCao)) {
			return false;
		}

		ThongKeBaoCao thongKeBaoCao = (ThongKeBaoCao)object;

		long primaryKey = thongKeBaoCao.getPrimaryKey();

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
	public CacheModel<ThongKeBaoCao> toCacheModel() {
		ThongKeBaoCaoCacheModel thongKeBaoCaoCacheModel =
			new ThongKeBaoCaoCacheModel();

		thongKeBaoCaoCacheModel.id = getId();

		thongKeBaoCaoCacheModel.nam = getNam();

		thongKeBaoCaoCacheModel.thang = getThang();

		thongKeBaoCaoCacheModel.tongHoSo = getTongHoSo();

		return thongKeBaoCaoCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ThongKeBaoCao, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ThongKeBaoCao, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ThongKeBaoCao, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ThongKeBaoCao)this));
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
		Map<String, Function<ThongKeBaoCao, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ThongKeBaoCao, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ThongKeBaoCao, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ThongKeBaoCao)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ThongKeBaoCao>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _id;
	private int _nam;
	private int _thang;
	private long _tongHoSo;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ThongKeBaoCao, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ThongKeBaoCao)this);
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

		_columnOriginalValues.put("id", _id);
		_columnOriginalValues.put("nam", _nam);
		_columnOriginalValues.put("thang", _thang);
		_columnOriginalValues.put("tong_hoso", _tongHoSo);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("tong_hoso", "tongHoSo");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("id", 1L);

		columnBitmasks.put("nam", 2L);

		columnBitmasks.put("thang", 4L);

		columnBitmasks.put("tong_hoso", 8L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ThongKeBaoCao _escapedModel;

}