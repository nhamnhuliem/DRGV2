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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;DRG_RpDashboardTrungBinh&quot; database table.
 *
 * @author SON
 * @see RpDashboardTrungBinh
 * @generated
 */
public class RpDashboardTrungBinhTable
	extends BaseTable<RpDashboardTrungBinhTable> {

	public static final RpDashboardTrungBinhTable INSTANCE =
		new RpDashboardTrungBinhTable();

	public final Column<RpDashboardTrungBinhTable, String> data = createColumn(
		"data_", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);

	private RpDashboardTrungBinhTable() {
		super("DRG_RpDashboardTrungBinh", RpDashboardTrungBinhTable::new);
	}

}