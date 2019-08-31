package wang.ismy.pms.service.impl;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
@Service("userService")
public class UserServiceImpl implements UserService, AuthenticationProvider {

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

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByUsername(s);

        org.springframework.security.core.userdetails.User u
                = new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),null);

        return u;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        authentication.getAuthorities().
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
