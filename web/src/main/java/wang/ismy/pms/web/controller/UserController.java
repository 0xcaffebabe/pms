package wang.ismy.pms.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import wang.ismy.pms.domain.Role;
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
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
    public ModelAndView findById(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-show");
        User user = userService.findById(id);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam("id") String userId){
        User user = userService.findById(userId);

        List<Role> otherRole = userService.findOtherRole(userId);

        ModelAndView mv = new ModelAndView();

        mv.addObject("user",user);
        mv.addObject("roleList",otherRole);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser")
    public String addRole(@RequestParam("userId")String userId,@RequestParam("ids") String[] ids){
        userService.addRole(userId,ids);
        return "redirect:list";
    }
}
