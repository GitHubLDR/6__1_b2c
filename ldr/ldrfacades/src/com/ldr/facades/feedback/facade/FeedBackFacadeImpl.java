/**
 *
 */
package com.ldr.facades.feedback.facade;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.model.ModelService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

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


	private Converter<FeedBackData, FeedBackModel> feedBackReverseConverter;

	private FeedBackService feedBackService;

	private ModelService modelService;

	/**
	 * @return the feedBackReverseConverter
	 */
	protected Converter<FeedBackData, FeedBackModel> getFeedBackReverseConverter()
	{
		return feedBackReverseConverter;
	}

	/**
	 * @return the feedBackService
	 */
	protected FeedBackService getFeedBackService()
	{
		return feedBackService;
	}

	/**
	 * @return the modelService
	 */
	protected ModelService getModelService()
	{
		return modelService;
	}

	/**
	 * @param feedBackReverseConverter
	 *           the feedBackReverseConverter to set
	 */
	@Required
	public void setFeedBackReverseConverter(final Converter<FeedBackData, FeedBackModel> feedBackReverseConverter)
	{
		this.feedBackReverseConverter = feedBackReverseConverter;
	}

	/**
	 * @param feedBackService
	 *           the feedBackService to set
	 */
	@Required
	public void setFeedBackService(final FeedBackService feedBackService)
	{
		this.feedBackService = feedBackService;
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
	 * @see com.ldr.facades.feedback.facade.FeedBackFacade#getFeedBackData(com.ldr.facades.feedback.data.FeedBackData)
	 */
	@Override
	public void getFeedBackData(final FeedBackData feedBackData)
	{
		LOG.info("FeedBackFacadeImpl==getFeedBackData==STARTED");
		// YTODO Auto-generated method stub
		final FeedBackModel feedBackModel = getModelService().create(FeedBackModel.class);
		getFeedBackReverseConverter().convert(feedBackData, feedBackModel);
		getFeedBackService().getFeedBackData(feedBackModel);
	}
}
