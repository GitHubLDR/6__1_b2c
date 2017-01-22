package com.ldr.facades.product.converters.populator;

import de.hybris.platform.commercefacades.product.converters.populator.VariantFullPopulator;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.apache.log4j.Logger;

import com.ldr.core.model.ApparelSizeVariantProductModel;
import com.ldr.core.model.ApparelStyleVariantProductModel;


/**
 * @author lmr_pad
 *
 */
public class LDRVariantFullPopulator extends VariantFullPopulator
{
	private final Logger LOG = Logger.getLogger(LDRVariantFullPopulator.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hybris.platform.commercefacades.product.converters.populator.VariantFullPopulator#populate(de.hybris.platform
	 * .core.model.product.ProductModel, de.hybris.platform.commercefacades.product.data.ProductData)
	 */
	@Override
	public void populate(final ProductModel productModel, final ProductData productData) throws ConversionException
	{
		// YTODO Auto-generated method stub
		LOG.info("+++++LDRVariantFullPopulator+++++PRODUCT+++++++populate()");
		super.populate(productModel, productData);

		if (productModel instanceof ApparelStyleVariantProductModel)
		{
			LOG.info("+++++LDRVariantFullPopulator++++++STYLE++++++populate()");
			productData.setIsSizeGuide(((ApparelStyleVariantProductModel) productModel).getIsSizeGuide());
		}

		if (productModel instanceof ApparelSizeVariantProductModel)
		{
			LOG.info("+++++LDRVariantFullPopulator++++++SIZE+++++populate()");
			productData.setSizeText(((ApparelSizeVariantProductModel) productModel).getSizeText());
		}

	}

}
