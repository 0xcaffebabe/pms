package wang.ismy.pms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import wang.ismy.pms.domain.Role;
import wang.ismy.pms.service.RoleService;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/31 14:26
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();

        List<Role> list = roleService.findAll();

        modelAndView.addObject("roleList",list);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:list";
    }
}
