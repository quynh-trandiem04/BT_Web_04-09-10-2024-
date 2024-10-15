<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
    <h1>Add New User</h1>

    <form action="${pageContext.request.contextPath}/admin/user/add" method="POST">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="role">Role:</label>
        <input type="text" id="role" name="role" required><br>

        <label for="status">Active:</label>
        <input type="checkbox" id="status" name="status"><br>

        <button type="submit">Add User</button>
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/admin/users">Back to User List</a>
</body>
</html>
