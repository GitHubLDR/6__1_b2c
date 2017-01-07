<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:forEach var="giftCard" items="${giftCards}">
	<table>
	<tr>
	<td>${giftCard.uid}</td>
	</t>
	<td>${giftCard.name}</td>
	</t>
	<td>${giftCard.isOnline}</td>
	</tr>
	</table>
</c:forEach>
