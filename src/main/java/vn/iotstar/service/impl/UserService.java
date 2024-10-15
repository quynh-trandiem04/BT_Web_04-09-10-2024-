package vn.iotstar.service.impl;

import java.util.List;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDao;
import vn.iotstar.entity.User;
import vn.iotstar.service.IUserService;

public class UserService implements IUserService {

    private IUserDao userDao = new UserDao();

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(String userId) {
        return userDao.findById(userId);
    }

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        userDao.deleteById(userId);
    }

    @Override
    public List<User> searchUsers(String keyword) {
        return userDao.searchByUsername(keyword);
    }
}
