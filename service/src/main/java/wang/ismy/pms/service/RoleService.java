package wang.ismy.pms.service;

import wang.ismy.pms.domain.Role;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/31 14:28
 */
public interface RoleService {

    List<Role> findAll();

    void save(Role role);
}
