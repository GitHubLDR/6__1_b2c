/**
 *
 */
package com.ldr.workflow.customer;

import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.workflow.jobs.AutomatedWorkflowTemplateJob;
import de.hybris.platform.workflow.model.WorkflowActionModel;

import java.util.List;

import javax.annotation.Resource;


/**
 * @author lmr_pad
 *
 */
public abstract class AbstractNewCustomerActivation implements AutomatedWorkflowTemplateJob
{
	@Resource
	private ModelService modelService;

	public CustomerModel getCustomer(final WorkflowActionModel action)
	{
		final List<ItemModel> items = action.getAttachmentItems();
		for (final ItemModel itemModel : items)
		{
			if (itemModel instanceof CustomerModel)
			{
				return (CustomerModel) itemModel;
			}
		}
		return null;

	}



}
