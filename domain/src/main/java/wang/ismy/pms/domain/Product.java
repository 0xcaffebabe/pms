package wang.ismy.pms.domain;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author MY
 * @date 2019/8/26 13:48
 */
@Data
public class Product {

    private String id; // 主键
    private String productNum; // 编号 唯一
    private String productName; // 名称
    private String cityName; // 出发城市
    private LocalDateTime departureTime; // 出发时间
    private String departureTimeStr;
    private double productPrice; // 产品价格
    private String productDesc; // 产品描述
    private Integer productStatus; // 状态 0 关闭 1 开启
    private String productStatusStr;

    public String getProductStatusStr() {
        if (productStatus == 0){
            return "关闭";
        }else{
            return "开启";
        }
    }

    public String getDepartureTimeStr() {
        return departureTime.toString();
    }
}
