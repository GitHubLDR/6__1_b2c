/**
 *
 */
package com.ldr.storefront.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ldr.storefront.controllers.forms.FeedBackForm;




/**
 * @author lmr_pad
 *
 */
@Component("feedBackFormValidator")
public class FeedBackFormValidator implements Validator
{
	Logger LOG = Logger.getLogger(FeedBackFormValidator.class);
	public static final Pattern EMAIL_REGEX = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(final Class<?> arg0)
	{
		// YTODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(final Object object, final Errors errors)
	{
		// YTODO Auto-generated method stub
		LOG.info("====FeedBackFormValidator====validate()====STARETED");

		final FeedBackForm feedBackForm = (FeedBackForm) object;
		final String name = feedBackForm.getName();
		final String email = feedBackForm.getEmail();
		final String comments = feedBackForm.getCommment();

		if (StringUtils.isEmpty(name) || StringUtils.length(name) > 24)
		{
			errors.rejectValue("name", "form.feedback.error.name");
		}
		if (StringUtils.isEmpty(comments) || StringUtils.length(comments) > 50)
		{
			errors.rejectValue("commment", "form.feedback.error.comments");
		}

		validateEmail(errors, email);

	}

	protected void validateEmail(final Errors errors, final String email)
	{
		if (StringUtils.isEmpty(email))
		{
			errors.rejectValue("email", "form.feedback.error.email.invalid");
		}
		else if (StringUtils.length(email) > 255 || !validateEmailAddress(email))
		{
			errors.rejectValue("email", "form.feedback.error.email.length.invalid");
		}
	}

	public boolean validateEmailAddress(final String email)
	{
		final Matcher matcher = EMAIL_REGEX.matcher(email);
		return matcher.matches();
	}

}
