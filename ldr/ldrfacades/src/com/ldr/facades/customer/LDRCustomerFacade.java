/**
 *
 */
package com.ldr.facades.customer;

import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.exceptions.PasswordMismatchException;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;


/**
 * @author lmr_pad
 *
 */
public interface LDRCustomerFacade extends CustomerFacade
{
	public void changeMobile(final String nnewMobile, final String currentPassword) throws DuplicateUidException,
			PasswordMismatchException;

}
