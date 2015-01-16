<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Golden Eagle Flight Plan: Edit Checkpoint</title>
  <c:import url="../style.jsp"></c:import>
</head>
<body>
<h2>Golden Eagle Flight Plan</h2>

<h3><a href="/gefp">Golden Eagle Flight Plan</a> - Edit Check Point</h3>



<div class="region">
<c:import url="../errors.jsp"></c:import>

<c:if test="${not empty requestScope.checkpoint}">


  <form method="post" action="/gefp/editCheckpoint">
  <table>
    <tbody>
    <tr>
      <th scope="row">Runway:</th>
      <td>${requestScope.checkpoint.runway}</td>
    </tr>
    <tr>
      <th scope="row">Stage:</th>
      <td>${requestScope.checkpoint.stage}</td>
    </tr>
    <tr>
      <th scope="row">Check Point:</th>
      <td><input name="checkpoint" type="text" value="${requestScope.checkpoint.name}" /></td>
    </tr>
    <tr>
      <td colspan="2" scope="row">
        <input type="hidden" name="fid" value="${param.fid}" />
        <input name="Save" type="submit" value="Save" />
        <input name="Delete" type="submit" value="Delete" />
      </td>
    </tr>
    </tbody>
  </table>
  </form>

</c:if>

</div>
</body>
</html>
