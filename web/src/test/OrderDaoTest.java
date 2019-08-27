/**
 * @author MY
 * @date 2019/8/27 9:41
 */
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wang.ismy.pms.dao.OrderDao;
import wang.ismy.pms.domain.Order;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:context.xml")
public class OrderDaoTest {

    @Autowired
    OrderDao orderDao;

    @Test
    public void findById() {
        Order order = orderDao.findById("3FE27DF2A4E44A6DBC5D0FE4651D3D3E");

        assertEquals(2,order.getTravellers().size());
    }
}
