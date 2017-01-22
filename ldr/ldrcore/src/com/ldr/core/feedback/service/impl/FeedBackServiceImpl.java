/**
 *
 */
package com.ldr.core.feedback.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import com.ldr.core.feedback.dao.FeedBackDao;
import com.ldr.core.feedback.service.FeedBackService;
import com.ldr.core.model.FeedBackModel;


/**
 * @author lmr_pad
 *
 */
public class FeedBackServiceImpl implements FeedBackService
{
	protected static final Logger LOG = Logger.getLogger(FeedBackServiceImpl.class);

	private FeedBackDao feedBackDao;

	/**
	 * @return the feedBackDao
	 */
	protected FeedBackDao getFeedBackDao()
	{
		return feedBackDao;
	}

	/**
	 * @param feedBackDao
	 *           the feedBackDao to set
	 */
	@Required
	public void setFeedBackDao(final FeedBackDao feedBackDao)
	{
		this.feedBackDao = feedBackDao;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ldr.core.feedback.service.FeedBackService#getFeedBackData(com.ldr.core.model.FeedBackModel)
	 */
	@Override
	public void getFeedBackData(final FeedBackModel feedBackModel)
	{
		LOG.info("FeedBackServiceImpl==getFeedBackData()==STARTED");
		// YTODO Auto-generated method stub
		feedBackDao.getFeedBackData(feedBackModel);
	}


}
