/**
 *
 */
package com.ldrbackoffice.extended.explorertree.ldrexplorertree;

import org.apache.log4j.Logger;

import com.hybris.backoffice.navigation.NavigationTree;
import com.hybris.cockpitng.config.explorertree.jaxb.ExplorerTree;
import com.hybris.cockpitng.core.config.CockpitConfigurationException;
import com.hybris.cockpitng.core.config.CockpitConfigurationNotFoundException;
import com.hybris.cockpitng.core.config.impl.DefaultConfigContext;
import com.hybris.cockpitng.widgets.common.explorertree.ExplorerTreeController;


/**
 * @author lmr_pad
 *
 */
public class LDRExplorerTree extends ExplorerTreeController
{
	Logger LOG = Logger.getLogger(LDRExplorerTree.class);

	@Override
	protected NavigationTree createNavigationTree()
	{
		LOG.info("====================hitted1");
		NavigationTree ret = null;

		try
		{
			LOG.info("====================hitted2");

			final String e = this.getWidgetSettings().getString("explorerTreeConfigCtx");
			final ExplorerTree explorerConfig = this.getWidgetInstanceManager().loadConfiguration(new DefaultConfigContext(e),
					ExplorerTree.class);
			if (explorerConfig == null)
			{
				LOG.warn("Cannot retrieve explorer tree widget configuration");
			}
			else
			{
				ret = this.getNavigationTreeFactory().createNavigationTree(explorerConfig);
				this.traverseTreeAndCalculateUiLabel(ret);
			}
		}
		catch (final CockpitConfigurationNotFoundException arg3)
		{
			if (LOG.isDebugEnabled())
			{
				LOG.debug("Cannot retrive explorer tree widget configuration", arg3);
			}
		}
		catch (final CockpitConfigurationException arg4)
		{
			LOG.warn("Cannot retrieve explorer tree widget configuration", arg4);
		}

		return ret;
	}

}
