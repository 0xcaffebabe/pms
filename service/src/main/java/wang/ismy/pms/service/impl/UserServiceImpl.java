package wang.ismy.pms.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import wang.ismy.pms.dao.UserDao;
import wang.ismy.pms.domain.User;
import wang.ismy.pms.service.UserService;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/31 10:57
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }
}
