package wang.ismy.pms.service;

import wang.ismy.pms.domain.SysLog;

import java.util.List;

/**
 * @author MY
 * @date 2019/9/1 16:32
 */
public interface SysLogService {

    void save(SysLog log);

    List<SysLog> findAll();
}
