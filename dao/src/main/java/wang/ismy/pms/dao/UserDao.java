package wang.ismy.pms.dao;

import org.apache.ibatis.annotations.*;
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

    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(String username);
}
