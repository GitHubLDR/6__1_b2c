/**
 *
 */
package com.ldr.core.feedback.service.impl;

import de.hybris.bootstrap.annotations.UnitTest;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ldr.core.feedback.dao.FeedBackDao;


/**
 * @author lmr_pad
 *
 */
@UnitTest
public class FeedBackServiceImplTest
{

	@Mock
	private FeedBackDao feedBackDao;

	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
	}

	/* @Test */




}
