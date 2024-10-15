<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h1>User List</h1>

    <!-- Tìm kiếm -->
    <form action="${pageContext.request.contextPath}/admin/user/search" method="GET">
        <input type="text" name="keyword" placeholder="Search user..." value="${param.keyword}">
        <button type="submit">Search</button>
    </form>

    <!-- Hiển thị danh sách user -->
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Role</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.role}</td>
                    <td>${user.status ? 'Active' : 'Inactive'}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/user/edit?id=${user.userId}">Edit</a> | 
                        <a href="${pageContext.request.contextPath}/admin/user/delete?id=${user.userId}" 
                           onclick="return confirm('Are you sure you want to delete this user?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <br>
    <a href="${pageContext.request.contextPath}/admin/user/add">Add New User</a>
</body>
</html>
