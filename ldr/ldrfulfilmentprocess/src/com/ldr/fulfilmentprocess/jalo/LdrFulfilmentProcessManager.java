/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *  
 */
package com.ldr.fulfilmentprocess.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import com.ldr.fulfilmentprocess.constants.LdrFulfilmentProcessConstants;

@SuppressWarnings("PMD")
public class LdrFulfilmentProcessManager extends GeneratedLdrFulfilmentProcessManager
{
	public static final LdrFulfilmentProcessManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (LdrFulfilmentProcessManager) em.getExtension(LdrFulfilmentProcessConstants.EXTENSIONNAME);
	}
	
}
