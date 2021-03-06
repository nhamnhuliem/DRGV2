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

package drg.moh.service.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the RpDashboardCphd service. Represents a row in the &quot;rp_dashboard_cphd&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>drg.moh.service.model.impl.RpDashboardCphdModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>drg.moh.service.model.impl.RpDashboardCphdImpl</code>.
 * </p>
 *
 * @author SON
 * @see RpDashboardCphd
 * @generated
 */
@ProviderType
public interface RpDashboardCphdModel extends BaseModel<RpDashboardCphd> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a rp dashboard cphd model instance should use the {@link RpDashboardCphd} interface instead.
	 */

	/**
	 * Returns the primary key of this rp dashboard cphd.
	 *
	 * @return the primary key of this rp dashboard cphd
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this rp dashboard cphd.
	 *
	 * @param primaryKey the primary key of this rp dashboard cphd
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this rp dashboard cphd.
	 *
	 * @return the ID of this rp dashboard cphd
	 */
	public long getId();

	/**
	 * Sets the ID of this rp dashboard cphd.
	 *
	 * @param id the ID of this rp dashboard cphd
	 */
	public void setId(long id);

	/**
	 * Returns the ten tinh of this rp dashboard cphd.
	 *
	 * @return the ten tinh of this rp dashboard cphd
	 */
	@AutoEscape
	public String getTenTinh();

	/**
	 * Sets the ten tinh of this rp dashboard cphd.
	 *
	 * @param tenTinh the ten tinh of this rp dashboard cphd
	 */
	public void setTenTinh(String tenTinh);

	/**
	 * Returns the chi phi of this rp dashboard cphd.
	 *
	 * @return the chi phi of this rp dashboard cphd
	 */
	public double getChiPhi();

	/**
	 * Sets the chi phi of this rp dashboard cphd.
	 *
	 * @param chiPhi the chi phi of this rp dashboard cphd
	 */
	public void setChiPhi(double chiPhi);

	/**
	 * Returns the dinh suat of this rp dashboard cphd.
	 *
	 * @return the dinh suat of this rp dashboard cphd
	 */
	public double getDinhSuat();

	/**
	 * Sets the dinh suat of this rp dashboard cphd.
	 *
	 * @param dinhSuat the dinh suat of this rp dashboard cphd
	 */
	public void setDinhSuat(double dinhSuat);

	/**
	 * Returns the drg of this rp dashboard cphd.
	 *
	 * @return the drg of this rp dashboard cphd
	 */
	public double getDrg();

	/**
	 * Sets the drg of this rp dashboard cphd.
	 *
	 * @param drg the drg of this rp dashboard cphd
	 */
	public void setDrg(double drg);

}