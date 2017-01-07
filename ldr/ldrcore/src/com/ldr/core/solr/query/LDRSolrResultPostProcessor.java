/**
 *
 */
package com.ldr.core.solr.query;

import de.hybris.platform.solrfacetsearch.search.SearchResult;
import de.hybris.platform.solrfacetsearch.search.SolrResultPostProcessor;


/**
 * @author lmr_pad
 *
 */
@SuppressWarnings("deprecation")
public class LDRSolrResultPostProcessor implements SolrResultPostProcessor
{

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.platform.solrfacetsearch.search.SolrResultPostProcessor#process(de.hybris.platform.solrfacetsearch.search
	 * .SearchResult)
	 */
	@Override
	public SearchResult process(final SearchResult paramSearchResult)
	{
		// YTODO Auto-generated method stub
		System.out.println("==============" + paramSearchResult.getSolrObject().getFacetQuery());
		return paramSearchResult;
	}
}