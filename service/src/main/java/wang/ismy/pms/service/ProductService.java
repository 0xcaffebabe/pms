package wang.ismy.pms.service;

import wang.ismy.pms.domain.Product;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/26 13:51
 */
public interface ProductService {

    List<Product> findAll();

    void save(Product product);
}
