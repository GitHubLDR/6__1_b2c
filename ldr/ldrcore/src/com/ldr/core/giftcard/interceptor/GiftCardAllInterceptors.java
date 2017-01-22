/**
 *
 */
package com.ldr.core.giftcard.interceptor;

import de.hybris.platform.servicelayer.interceptor.InitDefaultsInterceptor;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.LoadInterceptor;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import de.hybris.platform.servicelayer.interceptor.RemoveInterceptor;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;

import org.apache.log4j.Logger;

import com.ldr.core.model.GiftCardModel;


/**
 * @author lmr_pad
 *
 */
public class GiftCardAllInterceptors implements LoadInterceptor<GiftCardModel>, ValidateInterceptor<GiftCardModel>,
		InitDefaultsInterceptor<GiftCardModel>, RemoveInterceptor<GiftCardModel>, PrepareInterceptor<GiftCardModel>
{

	private static final Logger LOG = Logger.getLogger(GiftCardAllInterceptors.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.interceptor.PrepareInterceptor#onPrepare(java.lang.Object,
	 * de.hybris.platform.servicelayer.interceptor.InterceptorContext)
	 */
	@Override
	public void onPrepare(final GiftCardModel arg0, final InterceptorContext arg1) throws InterceptorException
	{
		// YTODO Auto-generated method stub
		LOG.info("PrepareInterceptor :: GiftCardAllInterceptors.onPrepare()=== called");

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.interceptor.RemoveInterceptor#onRemove(java.lang.Object,
	 * de.hybris.platform.servicelayer.interceptor.InterceptorContext)
	 */
	@Override
	public void onRemove(final GiftCardModel arg0, final InterceptorContext arg1) throws InterceptorException
	{
		// YTODO Auto-generated method stub
		LOG.info("RemoveInterceptor :: GiftCardAllInterceptors.onRemove()=== called");

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.interceptor.InitDefaultsInterceptor#onInitDefaults(java.lang.Object,
	 * de.hybris.platform.servicelayer.interceptor.InterceptorContext)
	 */
	@Override
	public void onInitDefaults(final GiftCardModel arg0, final InterceptorContext arg1) throws InterceptorException
	{
		// YTODO Auto-generated method stub
		LOG.info("InitDefaultsInterceptor :: GiftCardAllInterceptors.onInitDefaults()=== called");

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.interceptor.ValidateInterceptor#onValidate(java.lang.Object,
	 * de.hybris.platform.servicelayer.interceptor.InterceptorContext)
	 */
	@Override
	public void onValidate(final GiftCardModel arg0, final InterceptorContext arg1) throws InterceptorException
	{
		// YTODO Auto-generated method stub
		LOG.info("ValidateInterceptor :: GiftCardAllInterceptors.onValidate()=== called");

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.interceptor.LoadInterceptor#onLoad(java.lang.Object,
	 * de.hybris.platform.servicelayer.interceptor.InterceptorContext)
	 */
	@Override
	public void onLoad(final GiftCardModel arg0, final InterceptorContext arg1) throws InterceptorException
	{
		// YTODO Auto-generated method stub
		LOG.info("LoadInterceptor :: GiftCardAllInterceptors.onLoad()=== called");

	}

}
