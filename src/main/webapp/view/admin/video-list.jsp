<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Video List</title>
</head>
<body>
    <h1>Video List</h1>

    <!-- Tìm kiếm -->
    <form action="${pageContext.request.contextPath}/admin/video/search" method="GET">
        <input type="text" name="keyword" placeholder="Search video..." value="${param.keyword}">
        <button type="submit">Search</button>
    </form>

    <!-- Hiển thị danh sách video -->
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Views</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="video" items="${videos}">
                <tr>
                    <td>${video.videoId}</td>
                    <td>${video.title}</td>
                    <td>${video.description}</td>
                    <td>${video.views}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/video/edit/${video.videoId}">Edit</a> | 
                        <a href="${pageContext.request.contextPath}/admin/video/delete/${video.videoId}" 
                           onclick="return confirm('Are you sure you want to delete this video?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <br>
    <a href="${pageContext.request.contextPath}/admin/video/add">Add New Video</a>
</body>
</html>
