<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="formElement"	tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:url value="/feedback"  var="formurl"/>
<p>
	<h3><spring:theme code="feedback.tittle" /></h3>
</p>
<p>
	<spring:theme code="feedback.description" />
</p>

<form:form method="post" commandName="feedBackForm" action="${formurl}">
	
	<formElement:formInputBox idKey="feedback.name"
		labelKey="form.feedback.lable.name" path="name" inputCSS="form-control"
		mandatory="true" />
	
	<formElement:formInputBox idKey="feedback.email"
		labelKey="form.feedback.lable.email" path="email" inputCSS="form-control"
		mandatory="true" />
	<formElement:formInputBox idKey="feedback.comment"
		labelKey="form.feedback.lable.comment" path="commment" inputCSS="form-control"
		mandatory="true" />
	<div class="form-actions clearfix">
		<ycommerce:testId code="register_Register_button">
			<button type="submit" class="btn btn-default btn-block">
				<spring:theme code='feedback.submit.button' text="Submit" />
			</button>
		</ycommerce:testId>
	</div>
</form:form>
