package wang.ismy.pms.domain;

import lombok.Data;

/**
 * @author MY
 * @date 2019/8/27 9:21
 */
@Data
public class Traveller {
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;
    private String credentialsTypeStr;
    private String credentialsNum;
    private Integer travellerType;
    private String travellerTypeStr;

    public String getCredentialsTypeStr() {
        if (credentialsType == 0){
            return "身份证";
        }

        if (credentialsType == 1){
            return "护照";
        }else{
            return "军官证";
        }

    }

    public String getTravellerTypeStr() {
        if (travellerType == 0){
            return "成人";
        }else{
            return "儿童";
        }
    }
}
