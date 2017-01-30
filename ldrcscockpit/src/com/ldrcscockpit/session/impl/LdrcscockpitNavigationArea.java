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
package com.ldrcscockpit.session.impl;

import de.hybris.platform.cockpit.components.sectionpanel.SectionPanelModel;
import de.hybris.platform.cockpit.session.impl.BaseUICockpitNavigationArea;

import org.apache.log4j.Logger;

import com.ldrcscockpit.components.navigationarea.LdrcscockpitNavigationAreaModel;


/**
 * Ldrcscockpit navigation area.
 */
public class LdrcscockpitNavigationArea extends BaseUICockpitNavigationArea
{
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(LdrcscockpitNavigationArea.class);

	@Override
	public SectionPanelModel getSectionModel()
	{
		if (super.getSectionModel() == null)
		{
			final LdrcscockpitNavigationAreaModel model = new LdrcscockpitNavigationAreaModel(this);
			model.initialize();
			super.setSectionModel(model);
		}
		return super.getSectionModel();
	}
}
