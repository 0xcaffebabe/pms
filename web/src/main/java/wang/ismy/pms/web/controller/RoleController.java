package wang.ismy.pms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import wang.ismy.pms.domain.Permission;
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

    @RequestMapping("/id/{id}")
    public ModelAndView id(@PathVariable("id") String roleId){
        ModelAndView mv = new ModelAndView();

        Role role = roleService.findById(roleId);
        List<Permission> permission = roleService.findOtherPermission(roleId);
        mv.setViewName("role-permission-add");
        mv.addObject("role",role);
        mv.addObject("permissionList",permission);
        return mv;
    }

    @RequestMapping("/addPermission")
    public String addPermission(@RequestParam("roleId") String role,@RequestParam("ids") String[] ids){
        roleService.addPermission(role,ids);
        return "redirect:list";
    }
}
