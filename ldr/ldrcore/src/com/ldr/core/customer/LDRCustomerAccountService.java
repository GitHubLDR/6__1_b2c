/**
 *
 */
package com.ldr.core.customer;

import de.hybris.platform.commerceservices.customer.CustomerAccountService;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.core.model.user.CustomerModel;


/**
 * @author lmr_pad
 *
 */
public interface LDRCustomerAccountService extends CustomerAccountService
{
	public void saveAddressEntryWhileRegistring(final CustomerModel customerModel, final AddressModel addressModel);
}
