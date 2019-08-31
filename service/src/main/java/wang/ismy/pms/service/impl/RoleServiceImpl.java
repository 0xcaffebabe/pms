package wang.ismy.pms.service.impl;

import org.springframework.stereotype.Service;
import wang.ismy.pms.dao.RoleDao;
import wang.ismy.pms.domain.Role;
import wang.ismy.pms.service.RoleService;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/31 14:28
 */
@Service
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
