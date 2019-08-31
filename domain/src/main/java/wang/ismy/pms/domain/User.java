package wang.ismy.pms.domain;

import lombok.Data;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/31 11:00
 */
@Data
public class User {

    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private String statusStr;
    private List<Role> roles;

    public String getStatusStr() {
        if (status == 0){
            return "未开启";
        }else{
            return "开启";
        }
    }
}
