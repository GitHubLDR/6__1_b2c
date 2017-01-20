/**
 *
 */
package com.ldr.storefront.form.validations;

import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.RegistrationValidator;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.ldr.storefront.controllers.forms.LDRRegisterForm;


/**
 * @author lmr_pad
 *
 */
@Component("ldrRegistrationValidator")
public class LDRRegistrationValidator extends RegistrationValidator
{


	@Override
	public boolean supports(final Class<?> aClass)
	{
		return LDRRegisterForm.class.equals(aClass);
	}

	@Override
	public void validate(final Object object, final Errors errors)
	{
		final LDRRegisterForm registerForm = (LDRRegisterForm) object;
		final String titleCode = registerForm.getTitleCode();
		final String firstName = registerForm.getFirstName();
		final String lastName = registerForm.getLastName();
		final String email = registerForm.getEmail();
		final String pwd = registerForm.getPwd();
		final String checkPwd = registerForm.getCheckPwd();
		final String mobileNumber = registerForm.getMobileNumber();
		final String line1 = registerForm.getLine1();
		final String line2 = registerForm.getLine2();
		final String town = registerForm.getTown();
		final String countryIso = registerForm.getCountryIso();
		final String postalCode = registerForm.getPostalCode();

		validateTitleCode(errors, titleCode);
		validateName(errors, firstName, "firstName", "register.firstName.invalid");
		validateName(errors, lastName, "lastName", "register.lastName.invalid");

		if (StringUtils.length(firstName) + StringUtils.length(lastName) > 255)
		{
			errors.rejectValue("lastName", "register.name.invalid");
			errors.rejectValue("firstName", "register.name.invalid");
		}

		validateEmail(errors, email);
		validatePassword(errors, pwd);
		comparePasswords(errors, pwd, checkPwd);

		if (StringUtils.isEmpty(mobileNumber))
		{
			errors.rejectValue("mobileNumber", "form.feedback.error.email.invalid");
		}
		if (StringUtils.isEmpty(line1))
		{
			errors.rejectValue("line1", "form.feedback.error.email.invalid");
		}
		if (StringUtils.isEmpty(line2))
		{
			errors.rejectValue("line2", "form.feedback.error.email.invalid");
		}
		if (StringUtils.isEmpty(town))
		{
			errors.rejectValue("town", "form.feedback.error.email.invalid");
		}
		if (StringUtils.isEmpty(countryIso))
		{
			errors.rejectValue("countryIso", "form.feedback.error.email.invalid");
		}
		if (StringUtils.isEmpty(postalCode))
		{
			errors.rejectValue("postalCode", "form.feedback.error.email.invalid");
		}
	}
}
