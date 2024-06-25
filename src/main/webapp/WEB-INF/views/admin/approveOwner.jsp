<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Approve Owners</title>
</head>
<body>
    <h1>Owner Approval List</h1>
    <table border="1">
        <tr>
            <th>No</th>
            <th>ID</th>
            <th>Nick</th>
            <th>Name</th>
            <th>Approve</th>
        </tr>
        <c:forEach var="owner" items="${ownerList}">
            <tr>
                <td>${owner.no}</td>
                <td>${owner.id}</td>
                <td>${owner.nick}</td>
                <td>${owner.name}</td>
                <td>
                    <form action="approveOwner" method="post">
                        <input type="hidden" name="no" value="${owner.no}"/>
                        <input type="submit" value="Approve"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
