package wang.ismy.pms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import wang.ismy.pms.domain.Permission;
import wang.ismy.pms.service.PermissionService;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/31 15:07
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {


    private PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();

        List<Permission> list = permissionService.findAll();

        modelAndView.setViewName("permission-list");
        modelAndView.addObject("permissionList",list);
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:list";
    }
}
