package wang.ismy.pms.service;

import wang.ismy.pms.domain.Permission;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/31 15:08
 */
public interface PermissionService {

    List<Permission> findAll();

    void save(Permission permission);
}
