<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>Golden Eagle Flight Plan</title>
    <c:import url="../style.jsp"></c:import>
</head>
<body>

<h2>Golden Eagle Flight Plan</h2>

<h3><a href="/gefp/addStage">Add A Stage</a> | <a href="/gefp/addCheckpoint">Add A Check Point</a></h3>

<%--
${manager.getList()}


<c:forEach items="${manager.filter()}" var="c">
    <p>${c}</p>
</c:forEach>

--%>

<div class="region">
    <table>
        <thead>
        <tr>
            <th scope="row">&nbsp;</th>
            <th scope="col">Academics</th>
            <th scope="col">Career Preparation</th>
            <th scope="col">Leadership and Community Engagement</th>
        </tr>
        </thead>
        <tbody>

<c:if test="${not empty sessionScope.checkpoints}">
<c:forEach items="${sessionScope.stages}" var="stage">
    <tr>
        <th scope="row">${stage}</th>
<c:forEach items="${applicationScope.runways}" var="runway">
        <td>
<c:forEach items="${requestScope.manager.filter(runway, stage)}" var="ch">
            <p><label><input type="checkbox" value="${ch.fid}"> ${ch.name}</label> <a href="/gefp/editCheckpoint?fid=${ch.fid}">[Edit]</a></p>
</c:forEach>
        </td>
</c:forEach>
    </tr>
</c:forEach>
</c:if>

<c:if test="${empty sessionScope.checkpoints}">
    <tr>
        <th></td>
        <td colspan=3><span class="error">No Stages/Checkpoints Found.</span></td>
    </tr>
</c:if>

        </tbody>
    </table>
</div>


</body>
</html>
