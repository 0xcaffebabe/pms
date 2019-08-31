package wang.ismy.pms.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import wang.ismy.pms.domain.Permission;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/31 13:32
 */
public interface PermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findByRoleId(String id);

    @Select("SELECT * FROM permission")
    List<Permission> findAll();

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);
}
