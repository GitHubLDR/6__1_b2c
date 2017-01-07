/**
 *
 */
package com.ldr.core.customer;

import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.commerceservices.customer.impl.DefaultCustomerAccountService;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.workflow.WorkflowProcessingService;
import de.hybris.platform.workflow.WorkflowService;
import de.hybris.platform.workflow.WorkflowTemplateService;
import de.hybris.platform.workflow.model.WorkflowActionModel;
import de.hybris.platform.workflow.model.WorkflowModel;
import de.hybris.platform.workflow.model.WorkflowTemplateModel;

import javax.annotation.Resource;

import org.apache.log4j.Logger;


/**
 * @author lmr_pad
 *
 */
public class LDRDefaultCustomerAccountService extends DefaultCustomerAccountService
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

}
