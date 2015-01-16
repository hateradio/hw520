<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Golden Eagle Flight Plan: Add Checkpoint</title>
    <c:import url="../header.jsp"></c:import>
</head>
<body>
<h2>Golden Eagle Flight Plan</h2>

<h3><a href="gefp">Golden Eagle Flight Plan</a> - Add A Check Point</h3>
<div class="region">
    <form action="${applicationScope.homePath}gefp/addCheckpoint" method="post">
<c:forEach items="${requestScope.errors}" var="e">
    <li>${e}</li>
</c:forEach>
    <table>
        <tbody>
        <tr>
            <th scope="row">Runway:</th>
            <td>
                <select name="runway">
<c:forEach items="${applicationScope.runways}" var="runway">
                        <option>${runway}</option>
</c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th scope="row">Stage:</th>
            <td>
                <select name="stage">
<c:if test="${empty sessionScope.stages}">
                        <option disabled>(Please add a stage!)</option>
</c:if>
<c:forEach items="${sessionScope.stages}" var="stage">
                        <option>${stage}</option>
</c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th scope="row">Check Point:</th>
            <td><input name="checkpoint" type="text" /></td>
        </tr>
        <tr>
            <td colspan="2" scope="row"><input name="add" type="submit" value="Add" /></td>
        </tr>
        </tbody>
    </table>
    </form>
</div>

</body>
</html>
