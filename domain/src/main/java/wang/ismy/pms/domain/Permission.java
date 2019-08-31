package wang.ismy.pms.domain;

import lombok.Data;

import java.util.List;

/**
 * @author MY
 * @date 2019/8/31 11:07
 */
@Data
public class Permission {
    private String id;
    private String permissionName;
    private String url;
    private List<Role> roles;
}
