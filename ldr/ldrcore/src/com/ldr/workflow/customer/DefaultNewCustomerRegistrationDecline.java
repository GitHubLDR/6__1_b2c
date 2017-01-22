/**
 *
 */
package com.ldr.workflow.customer;

import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.workflow.jobs.AutomatedWorkflowTemplateJob;
import de.hybris.platform.workflow.model.WorkflowActionModel;
import de.hybris.platform.workflow.model.WorkflowDecisionModel;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;


/**
 * @author lmr_pad
 *
 */
public class DefaultNewCustomerRegistrationDecline implements AutomatedWorkflowTemplateJob
{
	private final Logger LOG = Logger.getLogger(DefaultNewCustomerRegistrationDecline.class);

	@Resource
	private ModelService modelService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.workflow.jobs.AutomatedWorkflowTemplateJob#perform(de.hybris.platform.workflow.model.
	 * WorkflowActionModel)
	 */
	@SuppressWarnings("boxing")
	@Override
	public WorkflowDecisionModel perform(final WorkflowActionModel action)
	{
		// YTODO Auto-generated method stub

		CustomerModel customerModel = null;

		final List<ItemModel> items = action.getAttachmentItems();
		for (final ItemModel itemModel : items)
		{
			if (itemModel instanceof CustomerModel)
			{
				customerModel = (CustomerModel) itemModel;
				LOG.info(customerModel.getUid() + "=====================");

			}
		}

		if (!customerModel.getIsUserActive())
		{
			customerModel.setIsUserActive(false);
			modelService.save(customerModel);
		}

		for (final WorkflowDecisionModel decision : action.getDecisions())
		{
			return decision;
		}
		return null;
	}
}