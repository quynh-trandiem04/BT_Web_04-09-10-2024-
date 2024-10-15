package vn.iotstar.controllers.admin;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.entity.Video;
import vn.iotstar.service.IVideoService;
import vn.iotstar.service.impl.VideoService;

@WebServlet(urlPatterns = {"/admin/videos", "/admin/video/add", "/admin/video/edit", "/admin/video/delete", "/admin/video/search"})
public class VideoController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private IVideoService videoService = new VideoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();

        if (url.contains("/admin/videos")) {
            List<Video> videos = videoService.getAllVideos();
            req.setAttribute("videos", videos);
            req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);
        } else if (url.contains("/admin/video/add")) {
            req.getRequestDispatcher("/views/admin/video-add.jsp").forward(req, resp);
        } else if (url.contains("/admin/video/edit")) {
            String videoId = req.getParameter("id");
            Video video = videoService.getVideoById(videoId);
            req.setAttribute("video", video);
            req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        
        if (url.contains("/admin/video/add")) {
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            String poster = req.getParameter("poster");
            int views = Integer.parseInt(req.getParameter("views"));
            boolean active = req.getParameter("active") != null;
            
            Video video = new Video();
            video.setTitle(title);
            video.setDescription(description);
            video.setPoster(poster);
            video.setViews(views);
            video.setActive(active);
            
            videoService.saveVideo(video);
            resp.sendRedirect(req.getContextPath() + "/admin/videos");
        } else if (url.contains("/admin/video/edit")) {
            String videoId = req.getParameter("id");
            Video video = videoService.getVideoById(videoId);
            
            video.setTitle(req.getParameter("title"));
            video.setDescription(req.getParameter("description"));
            video.setPoster(req.getParameter("poster"));
            video.setViews(Integer.parseInt(req.getParameter("views")));
            video.setActive(req.getParameter("active") != null);
            
            videoService.saveVideo(video);
            resp.sendRedirect(req.getContextPath() + "/admin/videos");
        } else if (url.contains("/admin/video/delete")) {
            String videoId = req.getParameter("id");
            videoService.deleteVideo(videoId);
            resp.sendRedirect(req.getContextPath() + "/admin/videos");
        }
    }
}
