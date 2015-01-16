<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${not empty requestScope.errors}">
<ul>
<c:forEach items="${requestScope.errors}" var="e">
  <li>${e}</li>
</c:forEach>
</ul>
</c:if>
