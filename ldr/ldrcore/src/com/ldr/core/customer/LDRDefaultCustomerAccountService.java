/**
 *
 */
package com.ldr.core.customer;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;

import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.commerceservices.customer.PasswordMismatchException;
import de.hybris.platform.commerceservices.customer.impl.DefaultCustomerAccountService;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.workflow.WorkflowProcessingService;
import de.hybris.platform.workflow.WorkflowService;
import de.hybris.platform.workflow.WorkflowTemplateService;
import de.hybris.platform.workflow.model.WorkflowActionModel;
import de.hybris.platform.workflow.model.WorkflowModel;
import de.hybris.platform.workflow.model.WorkflowTemplateModel;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;


/**
 * @author lmr_pad
 *
 */
public class LDRDefaultCustomerAccountService extends DefaultCustomerAccountService implements LDRCustomerAccountService
{

	private final Logger LOG = Logger.getLogger(LDRDefaultCustomerAccountService.class);

	@Resource(name = "newestWorkflowService")
	private WorkflowService workflowService;

	@Resource
	private WorkflowTemplateService workflowTemplateService;

	@Resource
	private WorkflowProcessingService workflowProcessingService;

	@Resource
	private UserService userService;

	@Resource
	private ModelService modelService;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.platform.commerceservices.customer.impl.DefaultCustomerAccountService#internalSaveCustomer(de.hybris
	 * .platform.core.model.user.CustomerModel)
	 */
	@Override
	protected void internalSaveCustomer(final CustomerModel customerModel) throws DuplicateUidException
	{
		// YTODO Auto-generated method stub
		final CustomerModel customerModel1 = customerModel;

		super.internalSaveCustomer(customerModel);

		final WorkflowTemplateModel workflowTemplate = this.workflowTemplateService
				.getWorkflowTemplateForCode("NewCustomerActivationWorkFlow");

		final WorkflowModel workflow = this.workflowService.createWorkflow(workflowTemplate, customerModel1,
				userService.getAdminUser());
		modelService.save(workflow);
		for (final WorkflowActionModel action : workflow.getActions())
		{
			modelService.save(action);
		}

		this.workflowProcessingService.startWorkflow(workflow);
	}


	@Override
	public void saveAddressEntryWhileRegistring(final CustomerModel customerModel, final AddressModel addressModel)
	{
		validateParameterNotNull(customerModel, "Customer model cannot be null");
		validateParameterNotNull(addressModel, "Address model cannot be null");
		final List<AddressModel> customerAddresses = new ArrayList<AddressModel>();
		customerAddresses.addAll(customerModel.getAddresses());
		if (customerModel.getAddresses().contains(addressModel))
		{
			getModelService().save(addressModel);
		}
		else
		{
			addressModel.setOwner(customerModel);
			getModelService().save(addressModel);
			getModelService().refresh(addressModel);
			customerAddresses.add(addressModel);
		}
		customerModel.setAddresses(customerAddresses);
		customerModel.setDefaultShipmentAddress(addressModel);
		customerModel.setDefaultPaymentAddress(addressModel);

		getModelService().save(customerModel);
		getModelService().refresh(customerModel);
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see com.ldr.core.customer.LDRCustomerAccountService#changeMobile(java.lang.String, java.lang.String)
	 */
	@Override
	public void changeMobile(final String newMobile, final String currentPassword)
	{
		// YTODO Auto-generated method stub

		Assert.hasText(newMobile, "The field [newMobile] cannot be empty");
		Assert.hasText(currentPassword, "The field [currentPassword] cannot be empty");

		final CustomerModel currentUser = (CustomerModel) getUserService().getCurrentUser();
		currentUser.setMobileNumber(newMobile);

		try
		{
			if (!getPasswordEncoderService().isValid(currentUser, currentPassword))
			{
				throw new PasswordMismatchException(currentUser.getUid());
			}

			getModelService().save(currentUser);

			// Update the password
			getUserService().setPassword(currentUser, currentPassword, currentUser.getPasswordEncoding());
			getModelService().save(currentUser);
		}
		catch (final PasswordMismatchException e)
		{
			// YTODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
