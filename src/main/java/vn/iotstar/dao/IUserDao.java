package vn.iotstar.dao;

import java.util.List;
import vn.iotstar.entity.User;

public interface IUserDao {
    List<User> findAll();
    User findById(String userId);
    User save(User user);
    void deleteById(String userId);
    List<User> searchByUsername(String keyword);
}
