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

import drg.moh.service.model.DashboardChiPhiThanhPhan;
import drg.moh.service.model.DashboardChiPhiThanhPhanModel;
import drg.moh.service.model.DashboardChiPhiThanhPhanSoap;

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
 * The base model implementation for the DashboardChiPhiThanhPhan service. Represents a row in the &quot;rp_dashboard_chiphi_thanhphan&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DashboardChiPhiThanhPhanModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DashboardChiPhiThanhPhanImpl}.
 * </p>
 *
 * @author SON
 * @see DashboardChiPhiThanhPhanImpl
 * @generated
 */
@JSON(strict = true)
public class DashboardChiPhiThanhPhanModelImpl
	extends BaseModelImpl<DashboardChiPhiThanhPhan>
	implements DashboardChiPhiThanhPhanModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dashboard chi phi thanh phan model instance should use the <code>DashboardChiPhiThanhPhan</code> interface instead.
	 */
	public static final String TABLE_NAME = "rp_dashboard_chiphi_thanhphan";

	public static final Object[][] TABLE_COLUMNS = {
		{"id", Types.BIGINT}, {"muc_bc", Types.INTEGER}, {"nam", Types.INTEGER},
		{"organization_id", Types.BIGINT}, {"organization_name", Types.VARCHAR},
		{"phi", Types.DOUBLE}, {"dinhsuat", Types.DOUBLE}, {"drg", Types.DOUBLE}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("muc_bc", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("nam", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("organization_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("organization_name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("phi", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("dinhsuat", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("drg", Types.DOUBLE);
	}

	public static final String TABLE_SQL_CREATE =
		"create table rp_dashboard_chiphi_thanhphan (id LONG not null primary key,muc_bc INTEGER,nam INTEGER,organization_id LONG,organization_name VARCHAR(75) null,phi DOUBLE,dinhsuat DOUBLE,drg DOUBLE)";

	public static final String TABLE_SQL_DROP =
		"drop table rp_dashboard_chiphi_thanhphan";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dashboardChiPhiThanhPhan.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY rp_dashboard_chiphi_thanhphan.id ASC";

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
	public static final long MUCBC_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NAM_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ORGID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static DashboardChiPhiThanhPhan toModel(
		DashboardChiPhiThanhPhanSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		DashboardChiPhiThanhPhan model = new DashboardChiPhiThanhPhanImpl();

		model.setId(soapModel.getId());
		model.setMucBc(soapModel.getMucBc());
		model.setNam(soapModel.getNam());
		model.setOrgId(soapModel.getOrgId());
		model.setOrgName(soapModel.getOrgName());
		model.setPhi(soapModel.getPhi());
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
	public static List<DashboardChiPhiThanhPhan> toModels(
		DashboardChiPhiThanhPhanSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<DashboardChiPhiThanhPhan> models =
			new ArrayList<DashboardChiPhiThanhPhan>(soapModels.length);

		for (DashboardChiPhiThanhPhanSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		drg.moh.service.service.util.ServiceProps.get(
			"lock.expiration.time.drg.moh.service.model.DashboardChiPhiThanhPhan"));

	public DashboardChiPhiThanhPhanModelImpl() {
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
		return DashboardChiPhiThanhPhan.class;
	}

	@Override
	public String getModelClassName() {
		return DashboardChiPhiThanhPhan.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DashboardChiPhiThanhPhan, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DashboardChiPhiThanhPhan, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DashboardChiPhiThanhPhan, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DashboardChiPhiThanhPhan)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DashboardChiPhiThanhPhan, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DashboardChiPhiThanhPhan, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DashboardChiPhiThanhPhan)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DashboardChiPhiThanhPhan, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DashboardChiPhiThanhPhan, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DashboardChiPhiThanhPhan>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DashboardChiPhiThanhPhan.class.getClassLoader(),
			DashboardChiPhiThanhPhan.class, ModelWrapper.class);

		try {
			Constructor<DashboardChiPhiThanhPhan> constructor =
				(Constructor<DashboardChiPhiThanhPhan>)
					proxyClass.getConstructor(InvocationHandler.class);

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

	private static final Map<String, Function<DashboardChiPhiThanhPhan, Object>>
		_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<DashboardChiPhiThanhPhan, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<DashboardChiPhiThanhPhan, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<DashboardChiPhiThanhPhan, Object>>();
		Map<String, BiConsumer<DashboardChiPhiThanhPhan, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<DashboardChiPhiThanhPhan, ?>>();

		attributeGetterFunctions.put("id", DashboardChiPhiThanhPhan::getId);
		attributeSetterBiConsumers.put(
			"id",
			(BiConsumer<DashboardChiPhiThanhPhan, Long>)
				DashboardChiPhiThanhPhan::setId);
		attributeGetterFunctions.put(
			"mucBc", DashboardChiPhiThanhPhan::getMucBc);
		attributeSetterBiConsumers.put(
			"mucBc",
			(BiConsumer<DashboardChiPhiThanhPhan, Integer>)
				DashboardChiPhiThanhPhan::setMucBc);
		attributeGetterFunctions.put("nam", DashboardChiPhiThanhPhan::getNam);
		attributeSetterBiConsumers.put(
			"nam",
			(BiConsumer<DashboardChiPhiThanhPhan, Integer>)
				DashboardChiPhiThanhPhan::setNam);
		attributeGetterFunctions.put(
			"orgId", DashboardChiPhiThanhPhan::getOrgId);
		attributeSetterBiConsumers.put(
			"orgId",
			(BiConsumer<DashboardChiPhiThanhPhan, Long>)
				DashboardChiPhiThanhPhan::setOrgId);
		attributeGetterFunctions.put(
			"orgName", DashboardChiPhiThanhPhan::getOrgName);
		attributeSetterBiConsumers.put(
			"orgName",
			(BiConsumer<DashboardChiPhiThanhPhan, String>)
				DashboardChiPhiThanhPhan::setOrgName);
		attributeGetterFunctions.put("phi", DashboardChiPhiThanhPhan::getPhi);
		attributeSetterBiConsumers.put(
			"phi",
			(BiConsumer<DashboardChiPhiThanhPhan, Double>)
				DashboardChiPhiThanhPhan::setPhi);
		attributeGetterFunctions.put(
			"dinhSuat", DashboardChiPhiThanhPhan::getDinhSuat);
		attributeSetterBiConsumers.put(
			"dinhSuat",
			(BiConsumer<DashboardChiPhiThanhPhan, Double>)
				DashboardChiPhiThanhPhan::setDinhSuat);
		attributeGetterFunctions.put("drg", DashboardChiPhiThanhPhan::getDrg);
		attributeSetterBiConsumers.put(
			"drg",
			(BiConsumer<DashboardChiPhiThanhPhan, Double>)
				DashboardChiPhiThanhPhan::setDrg);

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
	public int getMucBc() {
		return _mucBc;
	}

	@Override
	public void setMucBc(int mucBc) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mucBc = mucBc;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public int getOriginalMucBc() {
		return GetterUtil.getInteger(
			this.<Integer>getColumnOriginalValue("muc_bc"));
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
	public long getOrgId() {
		return _orgId;
	}

	@Override
	public void setOrgId(long orgId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_orgId = orgId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalOrgId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("organization_id"));
	}

	@JSON
	@Override
	public String getOrgName() {
		if (_orgName == null) {
			return "";
		}
		else {
			return _orgName;
		}
	}

	@Override
	public void setOrgName(String orgName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_orgName = orgName;
	}

	@JSON
	@Override
	public double getPhi() {
		return _phi;
	}

	@Override
	public void setPhi(double phi) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_phi = phi;
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
			0, DashboardChiPhiThanhPhan.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DashboardChiPhiThanhPhan toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DashboardChiPhiThanhPhan>
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
		DashboardChiPhiThanhPhanImpl dashboardChiPhiThanhPhanImpl =
			new DashboardChiPhiThanhPhanImpl();

		dashboardChiPhiThanhPhanImpl.setId(getId());
		dashboardChiPhiThanhPhanImpl.setMucBc(getMucBc());
		dashboardChiPhiThanhPhanImpl.setNam(getNam());
		dashboardChiPhiThanhPhanImpl.setOrgId(getOrgId());
		dashboardChiPhiThanhPhanImpl.setOrgName(getOrgName());
		dashboardChiPhiThanhPhanImpl.setPhi(getPhi());
		dashboardChiPhiThanhPhanImpl.setDinhSuat(getDinhSuat());
		dashboardChiPhiThanhPhanImpl.setDrg(getDrg());

		dashboardChiPhiThanhPhanImpl.resetOriginalValues();

		return dashboardChiPhiThanhPhanImpl;
	}

	@Override
	public int compareTo(DashboardChiPhiThanhPhan dashboardChiPhiThanhPhan) {
		long primaryKey = dashboardChiPhiThanhPhan.getPrimaryKey();

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

		if (!(object instanceof DashboardChiPhiThanhPhan)) {
			return false;
		}

		DashboardChiPhiThanhPhan dashboardChiPhiThanhPhan =
			(DashboardChiPhiThanhPhan)object;

		long primaryKey = dashboardChiPhiThanhPhan.getPrimaryKey();

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
	public CacheModel<DashboardChiPhiThanhPhan> toCacheModel() {
		DashboardChiPhiThanhPhanCacheModel dashboardChiPhiThanhPhanCacheModel =
			new DashboardChiPhiThanhPhanCacheModel();

		dashboardChiPhiThanhPhanCacheModel.id = getId();

		dashboardChiPhiThanhPhanCacheModel.mucBc = getMucBc();

		dashboardChiPhiThanhPhanCacheModel.nam = getNam();

		dashboardChiPhiThanhPhanCacheModel.orgId = getOrgId();

		dashboardChiPhiThanhPhanCacheModel.orgName = getOrgName();

		String orgName = dashboardChiPhiThanhPhanCacheModel.orgName;

		if ((orgName != null) && (orgName.length() == 0)) {
			dashboardChiPhiThanhPhanCacheModel.orgName = null;
		}

		dashboardChiPhiThanhPhanCacheModel.phi = getPhi();

		dashboardChiPhiThanhPhanCacheModel.dinhSuat = getDinhSuat();

		dashboardChiPhiThanhPhanCacheModel.drg = getDrg();

		return dashboardChiPhiThanhPhanCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DashboardChiPhiThanhPhan, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DashboardChiPhiThanhPhan, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DashboardChiPhiThanhPhan, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((DashboardChiPhiThanhPhan)this));
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
		Map<String, Function<DashboardChiPhiThanhPhan, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DashboardChiPhiThanhPhan, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DashboardChiPhiThanhPhan, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((DashboardChiPhiThanhPhan)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, DashboardChiPhiThanhPhan>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private long _id;
	private int _mucBc;
	private int _nam;
	private long _orgId;
	private String _orgName;
	private double _phi;
	private double _dinhSuat;
	private double _drg;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<DashboardChiPhiThanhPhan, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DashboardChiPhiThanhPhan)this);
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
		_columnOriginalValues.put("muc_bc", _mucBc);
		_columnOriginalValues.put("nam", _nam);
		_columnOriginalValues.put("organization_id", _orgId);
		_columnOriginalValues.put("organization_name", _orgName);
		_columnOriginalValues.put("phi", _phi);
		_columnOriginalValues.put("dinhsuat", _dinhSuat);
		_columnOriginalValues.put("drg", _drg);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("muc_bc", "mucBc");
		attributeNames.put("organization_id", "orgId");
		attributeNames.put("organization_name", "orgName");
		attributeNames.put("dinhsuat", "dinhSuat");

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

		columnBitmasks.put("muc_bc", 2L);

		columnBitmasks.put("nam", 4L);

		columnBitmasks.put("organization_id", 8L);

		columnBitmasks.put("organization_name", 16L);

		columnBitmasks.put("phi", 32L);

		columnBitmasks.put("dinhsuat", 64L);

		columnBitmasks.put("drg", 128L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DashboardChiPhiThanhPhan _escapedModel;

}