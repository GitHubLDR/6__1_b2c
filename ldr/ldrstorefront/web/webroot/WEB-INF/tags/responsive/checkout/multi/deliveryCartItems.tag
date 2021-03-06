<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="cartData" required="true" type="de.hybris.platform.commercefacades.order.data.CartData" %>
<%@ attribute name="showDeliveryAddress" required="true" type="java.lang.Boolean" %>
<%@ attribute name="showPotentialPromotions" required="false" type="java.lang.Boolean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>

<c:set var="hasShippedItems" value="${cartData.deliveryItemsQuantity > 0}" />
<c:set var="deliveryAddress" value="${cartData.deliveryAddress}"/>

<c:if test="${not hasShippedItems}">
	<spring:theme code="checkout.pickup.no.delivery.required"/>
</c:if>

<ul class="checkout-order-summary-list">
<c:if test="${hasShippedItems}">
	<li class="checkout-order-summary-list-heading">
		<c:choose>
			<c:when test="${showDeliveryAddress and not empty deliveryAddress}">
				<div class="title"><spring:theme code="checkout.pickup.items.to.be.shipped" text="Ship To:"/></div>
				<div class="address">
					${fn:escapeXml(deliveryAddress.title)}&nbsp;${fn:escapeXml(deliveryAddress.firstName)}&nbsp;${fn:escapeXml(deliveryAddress.lastName)}
					<br>
					<c:if test="${ not empty deliveryAddress.line1 }">
						${fn:escapeXml(deliveryAddress.line1)},&nbsp;
					</c:if>
					<c:if test="${ not empty deliveryAddress.line2 }">
						${fn:escapeXml(deliveryAddress.line2)},&nbsp;
					</c:if>
					<c:if test="${not empty deliveryAddress.town }">
						${fn:escapeXml(deliveryAddress.town)},&nbsp;
					</c:if>
					<c:if test="${ not empty deliveryAddress.region.name }">
						${fn:escapeXml(deliveryAddress.region.name)},&nbsp;
					</c:if>
					<c:if test="${ not empty deliveryAddress.postalCode }">
						${fn:escapeXml(deliveryAddress.postalCode)},&nbsp;
					</c:if>
					<c:if test="${ not empty deliveryAddress.country.name }">
						${fn:escapeXml(deliveryAddress.country.name)}
					</c:if>
                    <br/>
					<c:if test="${ not empty deliveryAddress.phone }">
						${fn:escapeXml(deliveryAddress.phone)}
					</c:if>
				</div>
			</c:when>
			<c:otherwise>
				<spring:theme code="checkout.pickup.items.to.be.delivered" />
			</c:otherwise>
		</c:choose>
		
	</li>
</c:if>

<c:forEach items="${cartData.entries}" var="entry" varStatus="loop">
	<c:if test="${entry.deliveryPointOfService == null}">
		<c:url value="${entry.product.url}" var="productUrl"/>
		<li class="checkout-order-summary-list-items">
			<div class="thumb">
				<a href="${productUrl}">
					<product:productPrimaryImage product="${entry.product}" format="thumbnail"/>
				</a>
			</div>
			<div class="price"><format:price priceData="${entry.totalPrice}" displayFreeForZero="true"/></div>
			<div class="details">
				<div class="name"><a href="${productUrl}">${entry.product.name}</a></div>
				<div>
    				<spring:theme code="order.itemPrice" />:&nbsp;
					<c:if test="${entry.product.multidimensional}">
						<!-- if product is multidimensional with different prices, show range, else, show unique price -->
						<c:choose>
							<c:when test="${entry.product.priceRange.minPrice.value ne entry.product.priceRange.maxPrice.value}">
								<format:price priceData="${entry.product.priceRange.minPrice}" /> - <format:price priceData="${entry.product.priceRange.maxPrice}" />
							</c:when>
							<c:otherwise>
								<format:price priceData="${entry.product.price}" />
							</c:otherwise>
						</c:choose>
					</c:if>
					<c:if test="${! entry.product.multidimensional}">
						<format:price priceData="${entry.basePrice}" displayFreeForZero="true" />
					</c:if>
				</div>
				<div class="qty"><spring:theme code="basket.page.qty"/>:&nbsp;${entry.quantity}</div>
				<div>
					<c:forEach items="${entry.product.baseOptions}" var="option">
						<c:if test="${not empty option.selected and option.selected.url eq entry.product.url}">
							<c:forEach items="${option.selected.variantOptionQualifiers}" var="selectedOption">
								<div>${selectedOption.name}: ${selectedOption.value}</div>
							</c:forEach>
						</c:if>
					</c:forEach>
					
					<c:if test="${ycommerce:doesPotentialPromotionExistForOrderEntry(cartData, entry.entryNumber) && showPotentialPromotions}">
                        <c:forEach items="${cartData.potentialProductPromotions}" var="promotion">
                            <c:set var="displayed" value="false"/>
                            <c:forEach items="${promotion.consumedEntries}" var="consumedEntry">
                                <c:if test="${not displayed && consumedEntry.orderEntryNumber == entry.entryNumber}">
                                    <c:set var="displayed" value="true"/>
                                    <span class="promotion">${promotion.description}</span>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
					</c:if>
					
					<c:if test="${ycommerce:doesAppliedPromotionExistForOrderEntry(cartData, entry.entryNumber)}">
                        <c:forEach items="${cartData.appliedProductPromotions}" var="promotion">
                            <c:set var="displayed" value="false"/>
                            <c:forEach items="${promotion.consumedEntries}" var="consumedEntry">
                                <c:if test="${not displayed && consumedEntry.orderEntryNumber == entry.entryNumber}">
                                    <c:set var="displayed" value="true"/>
                                    <span class="promotion">${promotion.description}</span>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
					</c:if>
				</div>
				<c:if test="${entry.product.multidimensional}" >
					<a href="#" id="QuantityProductToggle" data-index="${loop.index}" class="showQuantityProductOverlay updateQuantityProduct-toggle">
						<span><spring:theme code="order.product.seeDetails"/></span>
					</a>
				</c:if>
				
				<div id="ajaxGrid${loop.index}" style="display: none"></div>
				<c:if test="${entry.product.multidimensional}" >
					<c:forEach items="${entry.entries}" var="currentEntry" varStatus="stat">
						<c:set var="subEntries" value="${stat.first ? '' : subEntries}${currentEntry.product.code}:${currentEntry.quantity},"/>
						<c:set var="productName" value="${currentEntry.product.name}"/>
					</c:forEach>

					<div style="display:none" id="grid${loop.index}" data-sub-entries="${subEntries}" data-product-name="${fn:escapeXml(productName)}">
					</div>
				</c:if>
			</div>
		</li>
	</c:if>
</c:forEach>

</ul>