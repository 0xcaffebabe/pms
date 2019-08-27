import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wang.ismy.pms.dao.ProductDao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

/**
 * @author MY
 * @date 2019/8/26 15:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:context.xml")
public class ProductDaoTest {

    @Autowired
    ProductDao productDao;

    @Test
    public void findAll() {
        assertEquals(3,productDao.findAll().size());
    }

    @Test
    public void findById(){
        assertEquals("a1",productDao.findById("282AE70964BC4CEAB2D1AE637441161A").getProductNum());
    }
}
