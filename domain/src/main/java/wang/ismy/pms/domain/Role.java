package wang.ismy.pms.domain;

import lombok.Data;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/31 11:07
 */
@Data
public class Role {
    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<User> users;
}
