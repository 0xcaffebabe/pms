package wang.ismy.pms.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author MY
 * @date 2019/9/1 16:11
 */
@Data
public class SysLog {
    private String id;
    private Date visitTime;
    private String visitTimeStr;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;
}
