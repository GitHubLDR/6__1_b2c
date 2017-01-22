/**
 *
 */
package com.ldr.workflow.customer;

import de.hybris.platform.commerceservices.event.AbstractCommerceUserEvent;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.site.BaseSiteService;
import de.hybris.platform.store.services.BaseStoreService;
import de.hybris.platform.workflow.jobs.AutomatedWorkflowTemplateJob;
import de.hybris.platform.workflow.model.WorkflowActionModel;
import de.hybris.platform.workflow.model.WorkflowDecisionModel;

import java.util.List;

import javax.annotation.Resource;


/**
 * @author lmr_pad
 *
 */
public class DefaultNewCustomerRegistrationActivation implements AutomatedWorkflowTemplateJob
{
	@Resource
	private ModelService modelService;

	@Resource
	private EventService eventService;

	@Resource
	private BaseStoreService baseStoreService;

	@Resource
	private BaseSiteService baseSiteService;

	@Resource
	private CommonI18NService commonI18NService;

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
			}
		}
		if (!customerModel.getIsUserActive())
		{
			customerModel.setIsUserActive(true);
			modelService.save(customerModel);
		}
		//	eventService.publishEvent(initializeEvent(new RegisterEvent(), customerModel));
		for (final WorkflowDecisionModel decision : action.getDecisions())
		{
			return decision;
		}
		return null;
	}

	protected AbstractCommerceUserEvent initializeEvent(final AbstractCommerceUserEvent event, final CustomerModel customerModel)
	{
		event.setBaseStore(baseStoreService.getCurrentBaseStore());
		event.setSite(baseSiteService.getCurrentBaseSite());
		event.setCustomer(customerModel);
		event.setLanguage(commonI18NService.getCurrentLanguage());
		event.setCurrency(commonI18NService.getCurrentCurrency());
		return event;
	}
}
