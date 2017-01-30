/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 SAP SE or an SAP affiliate company.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package com.ldrcscockpit.components.navigationarea;

import de.hybris.platform.cockpit.components.navigationarea.DefaultNavigationAreaModel;
import de.hybris.platform.cockpit.session.impl.AbstractUINavigationArea;

import com.ldrcscockpit.session.impl.LdrcscockpitNavigationArea;


/**
 * Ldrcscockpit navigation area model.
 */
public class LdrcscockpitNavigationAreaModel extends DefaultNavigationAreaModel
{
	public LdrcscockpitNavigationAreaModel()
	{
		super();
	}

	public LdrcscockpitNavigationAreaModel(final AbstractUINavigationArea area)
	{
		super(area);
	}

	@Override
	public LdrcscockpitNavigationArea getNavigationArea()
	{
		return (LdrcscockpitNavigationArea) super.getNavigationArea();
	}
}
