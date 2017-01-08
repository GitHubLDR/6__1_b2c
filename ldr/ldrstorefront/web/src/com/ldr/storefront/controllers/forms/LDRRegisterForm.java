/**
 *
 */
package com.ldr.storefront.controllers.forms;

import de.hybris.platform.acceleratorstorefrontcommons.forms.RegisterForm;


/**
 * @author lmr_pad
 *
 */
public class LDRRegisterForm extends RegisterForm
{
	private String line1;
	private String line2;
	private String town;
	private String countryIso;
	private String postalCode;

	/**
	 * @return the line1
	 */
	public String getLine1()
	{
		return line1;
	}

	/**
	 * @param line1
	 *           the line1 to set
	 */
	public void setLine1(final String line1)
	{
		this.line1 = line1;
	}

	/**
	 * @return the line2
	 */
	public String getLine2()
	{
		return line2;
	}

	/**
	 * @param line2
	 *           the line2 to set
	 */
	public void setLine2(final String line2)
	{
		this.line2 = line2;
	}

	/**
	 * @return the town
	 */
	public String getTown()
	{
		return town;
	}

	/**
	 * @param town
	 *           the town to set
	 */
	public void setTown(final String town)
	{
		this.town = town;
	}



	/**
	 * @return the postalCode
	 */
	public String getPostalCode()
	{
		return postalCode;
	}

	/**
	 * @param postalCode
	 *           the postalCode to set
	 */
	public void setPostalCode(final String postalCode)
	{
		this.postalCode = postalCode;
	}

	/**
	 * @return the countryIso
	 */
	public String getCountryIso()
	{
		return countryIso;
	}

	/**
	 * @param countryIso
	 *           the countryIso to set
	 */
	public void setCountryIso(final String countryIso)
	{
		this.countryIso = countryIso;
	}
}
