package wang.ismy.pms.dao;

import org.apache.ibatis.annotations.Select;
import wang.ismy.pms.domain.Traveller;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/27 9:56
 */
public interface TravellerDao {

    @Select("SELECT * FROM traveller WHERE id IN (SELECT travellerId FROM order_traveller WHERE orderId = #{id})")
    List<Traveller> findByOrder(String id);
}
