package wang.ismy.pms.web.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import wang.ismy.pms.domain.Order;
import wang.ismy.pms.service.OrderService;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/27 9:23
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/id/{id}")
    public ModelAndView findById(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView();
        Order order = orderService.findById(id);
        modelAndView.setViewName("order-show");
        modelAndView.addObject("orders",order);
        return modelAndView;
    }

    @RequestMapping("/list")
    public ModelAndView list(@RequestParam("page") Integer page,@RequestParam("size") Integer size){
        List<Order> list = orderService.findAll(page,size);
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order-list");
        modelAndView.addObject("ordersList",pageInfo);



        return modelAndView;
    }
}
