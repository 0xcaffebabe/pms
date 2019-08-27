package wang.ismy.pms.service;

import wang.ismy.pms.domain.Order;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/27 9:28
 */
public interface OrderService {

    Order findById(String id);

    List<Order> findAll(Integer page, Integer size);

}
