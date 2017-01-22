/**
 *
 */
package com.ldr.storefront.giftcard.controller;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ldr.facades.giftcard.facade.GiftCardFacade;


/**
 * @author lmr_pad
 *
 */
@Controller
public class GiftCardController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(GiftCardController.class);

	@Resource
	GiftCardFacade giftCardFacade;

	private static final String GIFT_CARD_PAGE = "GiftCardPage";

	@RequestMapping(value = "giftcards")
	public String getGiftCards(final Model model, final HttpServletRequest request, final HttpServletResponse response,
			final HttpSession session) throws CMSItemNotFoundException
	{
		LOG.info("==> GiftCardController.getGiftCards()==== called");
		model.addAttribute("giftCards", giftCardFacade.getGiftCards());
		storeCmsPageInModel(model, getContentPageForLabelOrId(GIFT_CARD_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(GIFT_CARD_PAGE));
		return getViewForPage(model);
	}
}
