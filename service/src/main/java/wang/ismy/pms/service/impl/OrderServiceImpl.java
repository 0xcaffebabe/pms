package wang.ismy.pms.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import wang.ismy.pms.dao.OrderDao;
import wang.ismy.pms.domain.Order;
import wang.ismy.pms.service.OrderService;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/27 9:28
 */
@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order findById(String id) {
        return orderDao.findById(id);
    }

    @Override
    public List<Order> findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return orderDao.findAll();
    }
}
