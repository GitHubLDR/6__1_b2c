/**
 *
 */
package com.ldr.core.feedback.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

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

	@Resource
	FeedBackDao feedBackDao;

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
