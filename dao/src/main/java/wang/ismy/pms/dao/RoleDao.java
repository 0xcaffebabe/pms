package wang.ismy.pms.dao;

import org.apache.ibatis.annotations.*;
import wang.ismy.pms.domain.Permission;
import wang.ismy.pms.domain.Role;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/31 13:30
 */
public interface RoleDao {

    @Select("select * from role where id in( select roleId from users_role where userId=#{userId})")
    @Results(
            {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "roleName", property = "roleName"),
                    @Result(column = "roleDesc", property = "roleDesc"),
                    @Result(column = "id", property = "permissions", javaType = List.class, many = @Many(select = "wang.ismy.pms.dao.PermissionDao.findByRoleId"))
            })
    List<Role> findRoleByUserId(String id);

    @Select("SELECT * FROM role")
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("SELECT * FROM role WHERE id =#{id}")
    Role findById(String roleId);

    @Select("SELECT * FROM permission WHERE id NOT IN (SELECT permissionId FROM role_permission WHERE roleId = #{roleId})")
    List<Permission> findOtherPermission(String roleId);

    @Insert("INSERT INTO role_permission(roleId,permissionId) VALUES(#{role},#{permission})")
    void addPermission(@Param("role") String role,@Param("permission") String id);
}
