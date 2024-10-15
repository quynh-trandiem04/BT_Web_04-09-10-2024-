<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Video</title>
</head>
<body>
    <h1>Add New Video</h1>

    <form action="${pageContext.request.contextPath}/admin/video/save" method="POST">
        <label for="title">Video Title:</label>
        <input type="text" id="title" name="title" required><br>

        <label for="url">Video URL:</label>
        <input type="text" id="url" name="url" required><br>

        <label for="description">Description:</label>
        <textarea id="description" name="description"></textarea><br>

        <label for="poster">Poster:</label>
        <input type="text" id="poster" name="poster" required><br>

        <label for="views">Views:</label>
        <input type="number" id="views" name="views" required><br>

        <label for="active">Active:</label>
        <input type="checkbox" id="active" name="active"><br>

        <button type="submit">Add Video</button>
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/admin/video">Back to Video List</a>
</body>
</html>
