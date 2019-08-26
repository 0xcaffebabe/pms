package wang.ismy.pms.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wang.ismy.pms.dao.ProductDao;
import wang.ismy.pms.domain.Product;
import wang.ismy.pms.service.ProductService;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/26 13:52
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }
}
