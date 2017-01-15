/**
 *
 */
package com.ldrbackoffice.widgets;


import java.util.List;

import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.hybris.cockpitng.annotations.ViewEvent;
import com.hybris.cockpitng.util.DefaultWidgetController;
import com.ldrbackoffice.services.SearchService;


/**
 * @author lmr_pad
 *
 */
public class MySearchController extends DefaultWidgetController
{
	private Textbox searchInput;

	@WireVariable
	private SearchService searchService;

	@ViewEvent(componentID = "searchBtn", eventName = Events.ON_CLICK)
	public void doSearch() throws InterruptedException
	{
		final List<String> result = searchService.search(searchInput.getText());
		Messagebox.show(result.get(0));
	}
}