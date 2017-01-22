/**
 *
 */
package com.ldr.core.solr.query;

import de.hybris.platform.solrfacetsearch.search.SearchQuery;
import de.hybris.platform.solrfacetsearch.search.SolrQueryPostProcessor;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;


/**
 * @author lmr_pad
 *
 */
@SuppressWarnings("deprecation")
public class LDRSolrQueryPostProcessor implements SolrQueryPostProcessor
{

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.platform.solrfacetsearch.search.SolrQueryPostProcessor#process(org.apache.solr.client.solrj.SolrQuery,
	 * de.hybris.platform.solrfacetsearch.search.SearchQuery)
	 */
	@Override
	public SolrQuery process(final SolrQuery solrQuery, final SearchQuery searchQuery)
	{
		// YTODO Auto-generated method stub
		System.out.println("===solrQuery====" + solrQuery.getQuery());
		System.out.println("===searchQuery====" + searchQuery.getUserQuery());
		solrQuery.setSort("id", ORDER.asc);
		solrQuery.setStart(Integer.valueOf(0));
		solrQuery.setRows(Integer.valueOf(10));
		return solrQuery;

	}
}
