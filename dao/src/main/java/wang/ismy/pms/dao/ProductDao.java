package wang.ismy.pms.dao;

import org.apache.ibatis.annotations.Select;
import wang.ismy.pms.domain.Product;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/26 13:50
 */
public interface ProductDao {

    @Select("SELECT * FROM product")
    List<Product> findAll();
}
