package wang.ismy.pms.dao;

import org.apache.ibatis.annotations.*;
import wang.ismy.pms.domain.Member;
import wang.ismy.pms.domain.Order;
import wang.ismy.pms.domain.Product;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/27 9:22
 */
public interface OrderDao {

    @Select("SELECT * FROM orders WHERE id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "wang.ismy.pms.dao.ProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "wang.ismy.pms.dao.MemberDao.findById")),
            @Result(property = "travellers", column = "id", javaType = List.class, many = @Many(select = "wang.ismy.pms.dao.TravellerDao.findByOrder"))
    }
    )
    Order findById(String id);

    @Select("SELECT * FROM orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "wang.ismy.pms.dao.ProductDao.findById"))
    }
    )
    List<Order> findAll();
}
