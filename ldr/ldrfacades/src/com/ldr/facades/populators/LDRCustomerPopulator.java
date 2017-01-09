/**
 *
 */
package com.ldr.facades.populators;

import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.converter.Populator;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;


/**
 * @author lmr_pad
 *
 */
@SuppressWarnings("deprecation")
public class LDRCustomerPopulator implements Populator<CustomerModel, CustomerData>
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.converters.Populator#populate(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void populate(final CustomerModel source, final CustomerData target) throws ConversionException
	{
		// YTODO Auto-generated method stub
		target.setMobileNumber(source.getMobileNumber());
	}
}
