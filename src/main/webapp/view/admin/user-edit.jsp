<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <h1>Edit User</h1>

    <form action="${pageContext.request.contextPath}/admin/user/edit" method="POST">
        <input type="hidden" name="id" value="${user.userId}">

        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${user.username}" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value="${user.password}" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${user.email}" required><br>

        <label for="role">Role:</label>
        <input type="text" id="role" name="role" value="${user.role}" required><br>

        <label for="status">Active:</label>
        <input type="checkbox" id="status" name="status" ${user.status ? 'checked' : ''}><br>

        <button type="submit">Save Changes</button>
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/admin/users">Back to User Lis
