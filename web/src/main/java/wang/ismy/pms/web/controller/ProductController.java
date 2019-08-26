package wang.ismy.pms.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import wang.ismy.pms.domain.Product;
import wang.ismy.pms.service.ProductService;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/26 14:30
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/list")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> all = productService.findAll();
        modelAndView.setViewName("product-list");
        modelAndView.addObject("productList",all);
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Product product){

        productService.save(product);
        return "redirect:/product/list";
    }
}
