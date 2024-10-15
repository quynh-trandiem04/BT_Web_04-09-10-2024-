package vn.iotstar.controllers.admin;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.entity.User;
import vn.iotstar.service.IUserService;
import vn.iotstar.service.impl.UserService;

@WebServlet(urlPatterns = {"/admin/users", "/admin/user/add", "/admin/user/edit", "/admin/user/delete", "/admin/user/search"})
public class UserController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();

        if (url.contains("/admin/users")) {
            List<User> users = userService.getAllUsers();
            req.setAttribute("users", users);
            req.getRequestDispatcher("/views/admin/user-list.jsp").forward(req, resp);
        } else if (url.contains("/admin/user/add")) {
            req.getRequestDispatcher("/views/admin/user-add.jsp").forward(req, resp);
        } else if (url.contains("/admin/user/edit")) {
            String userId = req.getParameter("id");
            User user = userService.getUserById(userId);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/views/admin/user-edit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        
        if (url.contains("/admin/user/add")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String role = req.getParameter("role");
            boolean status = req.getParameter("status") != null;

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setRole(role);
            user.setStatus(status);
            
            userService.saveUser(user);
            resp.sendRedirect(req.getContextPath() + "/admin/users");
        } else if (url.contains("/admin/user/edit")) {
            String userId = req.getParameter("id");
            User user = userService.getUserById(userId);
            
            user.setUsername(req.getParameter("username"));
            user.setPassword(req.getParameter("password"));
            user.setEmail(req.getParameter("email"));
            user.setRole(req.getParameter("role"));
            user.setStatus(req.getParameter("status") != null);
            
            userService.saveUser(user);
            resp.sendRedirect(req.getContextPath() + "/admin/users");
        } else if (url.contains("/admin/user/delete")) {
            String userId = req.getParameter("id");
            userService.deleteUser(userId);
            resp.sendRedirect(req.getContextPath() + "/admin/users");
        }
    }
}
