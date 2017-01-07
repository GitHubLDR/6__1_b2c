/**
 *
 */
package com.ldr.facades.product.converters.populator;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.apache.log4j.Logger;

import com.ldr.core.model.ApparelProductModel;


/**
 * @author lmr_pad
 *
 */
public class LDRProductPopulator implements Populator<ProductModel, ProductData>
{
	private final Logger LOG = Logger.getLogger(LDRProductPopulator.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.converters.Populator#populate(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void populate(final ProductModel productModel, final ProductData productData) throws ConversionException
	{
		// YTODO Auto-generated method stub
		if (productModel instanceof ApparelProductModel)
		{
			LOG.info("+++++LDRProductPopulator++++++Product++++++populate()");
			productData.setFacteAttribute(((ApparelProductModel) productModel).getFacteAttribute());
		}
	}
}
