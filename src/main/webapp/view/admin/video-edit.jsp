<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Video</title>
</head>
<body>
    <h1>Edit Video</h1>

    <form action="${pageContext.request.contextPath}/admin/video/save" method="POST">
        <input type="hidden" name="id" value="${video.videoId}">

        <label for="title">Video Title:</label>
        <input type="text" id="title" name="title" value="${video.title}" required><br>

        <label for="url">Video URL:</label>
        <input type="text" id="url" name="url" value="${video.url}" required><br>

        <label for="description">Description:</label>
        <textarea id="description" name="description">${video.description}</textarea><br>

        <label for="poster">Poster:</label>
        <input type="text" id="poster" name="poster" value="${video.poster}" required><br>

        <label for="views">Views:</label>
        <input type="number" id="views" name="views" value="${video.views}" required><br>

        <label for="active">Active:</label>
        <input type="checkbox" id="active" name="active" ${video.active ? 'checked' : ''}><br>

        <button type="submit">Save Changes</button>
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/admin/video">Back to Video List</a>
</body>
</html>
