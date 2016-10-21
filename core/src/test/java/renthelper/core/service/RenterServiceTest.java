package renthelper.core.service;

import org.junit.Test;
import renthelper.core.BaseUnitTest;
import renthelper.core.model.Renter;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static renthelper.core.utils.PrintUtil.*;
/**
 * Created with by shuangyao on 2016/10/21.
 */
public class RenterServiceTest extends BaseUnitTest {

    @Resource
    private RenterService renterService;

    @Test
    public void testSave() throws Exception {
        Renter renter = new Renter();
        renter.setUid(1);
        renter.setName("test");
        renter.setMobile("123");
        renter.setAge(10);
        renter.setBirthday(new Date());
        renterService.save(renter);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Renter> renters = renterService.getAll();
        if (renters == null || renters.size() == 0) {
            println("No renter.");
        }

        for (Renter renter : renters) {
            println(renter);
        }
    }

    @Test
    public void testGetById() throws Exception {
        println(renterService.getById(1));
    }

    @Test
    public void testGetByName() throws Exception {
        println(renterService.getByName("renter3"));
    }
}
