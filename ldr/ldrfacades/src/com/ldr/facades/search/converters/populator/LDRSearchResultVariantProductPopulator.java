/**
 *
 */
package com.ldr.facades.search.converters.populator;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.converters.populator.SearchResultVariantProductPopulator;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;

import org.apache.log4j.Logger;


/**
 * @author lmr_pad
 *
 */
public class LDRSearchResultVariantProductPopulator extends SearchResultVariantProductPopulator
{
	Logger LOG = Logger.getLogger(LDRSearchResultVariantProductPopulator.class);

	@Override
	public void populate(final SearchResultValueData source, final ProductData target)
	{
		LOG.info("===============LDRSearchResultVariantProductPopulator============STARTED=====populate()");
		super.populate(source, target);

		target.setFacteAttribute(this.<String> getValue(source, "facteAttribute"));
		target.setIsSizeGuide(this.<Boolean> getValue(source, "isSizeGuide"));
		target.setSizeText(this.<String> getValue(source, "sizeText"));

	}
}
