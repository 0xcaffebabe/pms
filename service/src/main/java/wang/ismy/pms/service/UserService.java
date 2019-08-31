package wang.ismy.pms.service;

import wang.ismy.pms.domain.User;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/31 10:57
 */
public interface UserService {


    List<User> findAll();

    void save(User user);

    User findById(String id);
}
