/**
 *
 */
package com.ldr.core.feedback.dao.impl;

import de.hybris.platform.servicelayer.model.ModelService;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.ldr.core.feedback.dao.FeedBackDao;
import com.ldr.core.model.FeedBackModel;


/**
 * @author lmr_pad
 *
 */
public class FeedBackDaoImpl implements FeedBackDao
{
	protected static final Logger LOG = Logger.getLogger(FeedBackDaoImpl.class);
	@Resource
	ModelService modelService;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ldr.core.feedback.dao.impl.FeedBackDao#getFeedBackData(com.ldr.core.model.FeedBackModel)
	 */
	@Override
	public void getFeedBackData(final FeedBackModel feedBackModel)
	{
		LOG.debug("FeedBackDaoImpl==getFeedBackData()==STARTED");
		// YTODO Auto-generated method stub
		modelService.save(feedBackModel);
	}

}
