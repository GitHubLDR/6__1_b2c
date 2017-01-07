/**
 *
 */
package com.ldr.facades.feedback.facade;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.model.ModelService;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.ldr.core.feedback.service.FeedBackService;
import com.ldr.core.model.FeedBackModel;
import com.ldr.facades.feedback.data.FeedBackData;



/**
 * @author lmr_pad
 *
 */
public class FeedBackFacadeImpl implements FeedBackFacade
{
	protected static final Logger LOG = Logger.getLogger(FeedBackFacadeImpl.class);


	@Resource
	private Converter<FeedBackData, FeedBackModel> feedBackReverseConverter;

	@Resource
	private FeedBackService feedBackService;

	@Resource
	ModelService modelService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ldr.facades.feedback.facade.FeedBackFacade#getFeedBackData(com.ldr.facades.feedback.data.FeedBackData)
	 */
	@Override
	public void getFeedBackData(final FeedBackData feedBackData)
	{
		LOG.info("FeedBackFacadeImpl==getFeedBackData==STARTED");
		// YTODO Auto-generated method stub
		final FeedBackModel feedBackModel = modelService.create(FeedBackModel.class);
		feedBackReverseConverter.convert(feedBackData, feedBackModel);
		feedBackService.getFeedBackData(feedBackModel);
	}
}
