/**
 *
 */
package com.ldr.facades.giftcard.facade.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.ldr.core.giftcard.service.GiftCardService;
import com.ldr.core.model.GiftCardModel;
import com.ldr.facades.giftcard.facade.GiftCardFacade;
import com.ldr.facades.giftcards.data.GiftCardData;


/**
 * @author lmr_pad
 *
 */
public class GiftCardFacadeImpl implements GiftCardFacade
{
	private static final Logger LOG = Logger.getLogger(GiftCardFacadeImpl.class);
	/**
	 * Convert which converts the GiftCardModel into GiftCardData
	 */
	@Resource
	private Converter<GiftCardModel, GiftCardData> giftCardConverter;

	@Resource
	GiftCardService giftCardService;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ldr.facades.giftcard.facade.GiftCardFacade#getGiftCards()
	 */
	@Override
	public List<GiftCardData> getGiftCards()
	{
		LOG.info("==> GiftCardFacadeImpl.getGiftCards()==== called");
		// YTODO Auto-generated method stub
		final List<GiftCardData> listOfGiftCardData = new ArrayList<GiftCardData>();
		if (null != giftCardService.getGiftCards())
		{
			for (final GiftCardModel giftCardModel : giftCardService.getGiftCards())
			{
				final GiftCardData giftCardData = new GiftCardData();
				listOfGiftCardData.add(giftCardConverter.convert(giftCardModel, giftCardData));
			}
			return listOfGiftCardData;
		}
		return null;
	}

}
