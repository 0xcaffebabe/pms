package wang.ismy.pms.service.impl;

import org.springframework.stereotype.Service;
import wang.ismy.pms.dao.SysLogDao;
import wang.ismy.pms.domain.SysLog;
import wang.ismy.pms.service.SysLogService;

import java.util.List;

/**
 * @author MY
 * @date 2019/9/1 16:33
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    private SysLogDao sysLogDao;

    public SysLogServiceImpl(SysLogDao sysLogDao) {
        this.sysLogDao = sysLogDao;
    }

    @Override
    public void save(SysLog log) {
        sysLogDao.save(log);
    }

    @Override
    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}
