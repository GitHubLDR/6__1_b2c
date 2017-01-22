/**
 *
 */
package com.ldr.core.giftcard.dao.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.ldr.core.giftcard.dao.GiftCardDao;
import com.ldr.core.model.GiftCardModel;


/**
 * @author lmr_pad
 *
 */
public class GiftCardDaoImpl implements GiftCardDao
{

	private static final Logger LOG = Logger.getLogger(GiftCardDaoImpl.class);

	@Resource
	FlexibleSearchService flexibleSearchService;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ldr.core.giftcard.dao.GiftCardDao#getGiftCards()
	 */
	@Override
	public List<GiftCardModel> getGiftCards()
	{
		LOG.info("===> GiftCardDaoImpl.getGiftCards() starteed");
		// YTODO Auto-generated method stub
		final String queryString = "SELECT {pk} FROM {GiftCard}";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

		return flexibleSearchService.<GiftCardModel> search(query).getResult();
	}
}
