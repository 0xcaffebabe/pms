package wang.ismy.pms.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author MY
 * @date 2019/8/27 9:13
 */
@Data
public class Order {
    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private int orderStatus;
    private String orderStatusStr;

    private int peopleCount;
    private Product product;
    private List<Traveller> travellers;
    private Member member;
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;

    public String getOrderStatusStr() {
        if (orderStatus == 0){
            return "未支付";
        }else{
            return "已支付";
        }
    }

    public String getOrderTimeStr() {
        return orderTime.toString();
    }
}
