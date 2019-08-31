package wang.ismy.pms.service.impl;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;
import wang.ismy.pms.dao.PermissionDao;
import wang.ismy.pms.domain.Permission;
import wang.ismy.pms.service.PermissionService;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/31 15:08
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    private PermissionDao permissionDao;

    public PermissionServiceImpl(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
