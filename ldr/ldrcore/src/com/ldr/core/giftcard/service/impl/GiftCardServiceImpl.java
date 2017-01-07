/**
 *
 */
package com.ldr.core.giftcard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ldr.core.giftcard.dao.GiftCardDao;
import com.ldr.core.giftcard.service.GiftCardService;
import com.ldr.core.model.GiftCardModel;


/**
 * @author lmr_pad
 *
 */
public class GiftCardServiceImpl implements GiftCardService
{
	@Resource
	GiftCardDao giftCardDao;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ldr.core.giftcard.service.GiftCardService#getGiftCards()
	 */
	@Override
	public List<GiftCardModel> getGiftCards()
	{
		// YTODO Auto-generated method stub

		/*
		 * if (null != listOfGiftCardModels) { return listOfGiftCardModels; }
		 */

		return giftCardDao.getGiftCards();
	}
}
