package wang.ismy.pms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import wang.ismy.pms.domain.User;
import wang.ismy.pms.service.UserService;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/31 10:59
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-list");
        modelAndView.addObject("userList",userService.findAll());
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(User user){
        userService.save(user);
        return "redirect:list";
    }

    @RequestMapping("/id/{id}")
    public ModelAndView findById(String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-show");
        modelAndView.addObject("user",userService.findById(id));
        return modelAndView;
    }
}
