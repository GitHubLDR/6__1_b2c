<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="actionNameKey" required="true"
	type="java.lang.String"%>
<%@ attribute name="action" required="true" type="java.lang.String"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement"
	tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<div class="headline">
	<spring:theme code="register.new.customer" />
</div>
<p>
	<spring:theme code="register.description" />
</p>

<form:form method="post" commandName="ldrRegisterForm" action="${action}">
	<formElement:formSelectBox idKey="register.title"
		labelKey="register.title" selectCSSClass="form-control"
		path="titleCode" mandatory="true" skipBlank="false"
		skipBlankMessageKey="form.select.empty" items="${titles}" />
	<formElement:formInputBox idKey="register.firstName"
		labelKey="register.firstName" path="firstName" inputCSS="form-control"
		mandatory="true" />
	<formElement:formInputBox idKey="register.lastName"
		labelKey="register.lastName" path="lastName" inputCSS="form-control"
		mandatory="true" />
	<formElement:formInputBox idKey="register.email"
		labelKey="register.email" path="email" inputCSS="form-control"
		mandatory="true" />
	<formElement:formPasswordBox idKey="password" labelKey="register.pwd"
		path="pwd" inputCSS="form-control password-strength" mandatory="true" />
	<formElement:formPasswordBox idKey="register.checkPwd"
		labelKey="register.checkPwd" path="checkPwd" inputCSS="form-control"
		mandatory="true" />
	<formElement:formInputBox idKey="register.mobileNumber"
		labelKey="register.mobileNumber" path="mobileNumber" inputCSS="form-control"
		mandatory="true" />
	<formElement:formInputBox idKey="register.line1"
		labelKey="register.line1" path="line1" inputCSS="form-control"
		mandatory="true" />
	<formElement:formInputBox idKey="register.line2"
		labelKey="register.line2" path="line2" inputCSS="form-control"
		mandatory="true" />
	<formElement:formInputBox idKey="register.town"
		labelKey="register.town" path="town" inputCSS="form-control"
		mandatory="true" />
		<formElement:formSelectBox idKey="register.countryIso"
				labelKey="register.countryIso" path="countryIso" mandatory="true"
				skipBlank="false" skipBlankMessageKey="Country"
				items="${countries}" itemValue="isocode" selectCSSClass="form-control" />
		<formElement:formInputBox idKey="register.postalCode"
		labelKey="register.postalCode" path="postalCode" inputCSS="form-control"
		mandatory="true" />
	<input type="hidden" id="recaptchaChallangeAnswered"
		value="${requestScope.recaptchaChallangeAnswered}" />
	<div class="form_field-elements control-group js-recaptcha-captchaaddon"></div>
	<div class="form-actions clearfix">
		<ycommerce:testId code="register_Register_button">
			<button type="submit" class="btn btn-default btn-block">
				<spring:theme code='${actionNameKey}' />
			</button>
		</ycommerce:testId>
	</div>
</form:form>
