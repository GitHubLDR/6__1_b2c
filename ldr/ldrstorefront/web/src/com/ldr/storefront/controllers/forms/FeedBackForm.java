/**
 *
 */
package com.ldr.storefront.controllers.forms;

/**
 * @author lmr_pad
 *
 */
public class FeedBackForm
{
	private String name;
	private String email;
	private String commment;

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *           the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email
	 *           the email to set
	 */
	public void setEmail(final String email)
	{
		this.email = email;
	}

	/**
	 * @return the commment
	 */
	public String getCommment()
	{
		return commment;
	}

	/**
	 * @param commment the commment to set
	 */
	public void setCommment(String commment)
	{
		this.commment = commment;
	}



}
