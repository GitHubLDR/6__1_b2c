/**
 *
 */
package com.ldr.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.apache.log4j.Logger;

import com.ldr.core.model.GiftCardModel;
import com.ldr.facades.giftcards.data.GiftCardData;


/**
 * @author lmr_pad
 *
 */
public class GiftCardPopulator1 implements Populator<GiftCardModel, GiftCardData>
{
	private static final Logger LOG = Logger.getLogger(GiftCardPopulator1.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.converters.Populator#populate(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void populate(final GiftCardModel source, final GiftCardData target) throws ConversionException
	{
		LOG.info("==> GiftCardPopulator1.populate()  called===");
		// YTODO Auto-generated method stub
		target.setUid(source.getUid());
		target.setName(source.getName());
	}
}
