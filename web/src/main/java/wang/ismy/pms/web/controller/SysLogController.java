package wang.ismy.pms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import wang.ismy.pms.domain.SysLog;
import wang.ismy.pms.service.SysLogService;

import java.util.List;

/**
 * @author MY
 * @date 2019/9/1 16:30
 */
@Controller
@RequestMapping("/log")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/list")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll();
        mv.addObject("sysLogs", sysLogs);
        mv.setViewName("syslog-list");
        return mv;
    }
}
