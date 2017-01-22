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
	/**
	 * @param customerModel
	 * @param addressModel
	 */
	public void saveAddressEntryWhileRegistring(final CustomerModel customerModel, final AddressModel addressModel);

	/**
	 * @param newMobile
	 * @param currentPassword
	 */
	public void changeMobile(String newMobile, String currentPassword);
}
