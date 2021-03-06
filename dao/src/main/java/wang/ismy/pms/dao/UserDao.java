package wang.ismy.pms.dao;

import org.apache.ibatis.annotations.*;
import wang.ismy.pms.domain.Role;
import wang.ismy.pms.domain.User;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/31 10:57
 */
public interface UserDao {

    @Select("SELECT * FROM users")
    List<User> findAll();

    @Insert("INSERT INTO users(email,username,password,phoneNum,status) VALUES(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(User user);

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({@Result(id = true, property = "id", column = "id"), @Result(column = "username",
            property = "username"),
            @Result(column = "email", property = "email"), @Result(column =
            "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"), @Result(column =
            "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many =
            @Many(select = "wang.ismy.pms.dao.RoleDao.findRoleByUserId"))})
    User findById(String id);

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many =
            @Many(select = "wang.ismy.pms.dao.RoleDao.findRoleByUserId")) })
    User findByUsername(String username);

    @Select("SELECT * FROM role WHERE id NOT IN (SELECT roleId FROM users_role WHERE userId = #{user})")
    List<Role> findOtherRole(String userId);

    @Insert("INSERT INTO users_role(userId,roleId) VALUES(#{user},#{role})")
    void addRole(@Param("user") String userId,@Param("role") String id);
}
