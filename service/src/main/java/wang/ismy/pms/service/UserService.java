package wang.ismy.pms.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import wang.ismy.pms.domain.Role;
import wang.ismy.pms.domain.User;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/31 10:57
 */
public interface UserService extends UserDetailsService {


    List<User> findAll();

    void save(User user);

    User findById(String id);

    List<Role> findOtherRole(String userId);

    void addRole(String userId, String[] ids);
}
