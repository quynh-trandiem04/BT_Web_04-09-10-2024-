package vn.iotstar.service;

import java.util.List;
import vn.iotstar.entity.User;

public interface IUserService {
    List<User> getAllUsers();
    User getUserById(String userId);
    User saveUser(User user);
    void deleteUser(String userId);
    List<User> searchUsers(String keyword);
}
