<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>

<spring:url value="/my-account/orders" var="orderHistoryUrl"/>

<div class="row">
    <div class="col-xs-12 col-sm-6 col-md-5 col-lg-4">
        <ycommerce:testId code="orderDetails_backToOrderHistory_button">
            <button type="button" class="btn btn-default btn-block orderBackBtn" data-back-to-orders="${orderHistoryUrl}">
                <spring:theme code="text.account.orderDetails.backToOrderHistory"/>
            </button>
        </ycommerce:testId>
    </div>
</div>