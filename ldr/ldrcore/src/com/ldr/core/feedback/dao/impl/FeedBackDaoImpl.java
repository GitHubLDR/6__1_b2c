/**
 *
 */
package com.ldr.core.feedback.dao.impl;

import de.hybris.platform.servicelayer.model.ModelService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import com.ldr.core.feedback.dao.FeedBackDao;
import com.ldr.core.model.FeedBackModel;


/**
 * @author lmr_pad
 *
 */
public class FeedBackDaoImpl implements FeedBackDao
{
	protected static final Logger LOG = Logger.getLogger(FeedBackDaoImpl.class);


	private ModelService modelService;

	/**
	 * @return the modelService
	 */
	protected ModelService getModelService()
	{
		return modelService;
	}

	/**
	 * @param modelService
	 *           the modelService to set
	 */
	@Required
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

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
