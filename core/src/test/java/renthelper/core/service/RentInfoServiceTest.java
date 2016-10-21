package renthelper.core.service;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import renthelper.core.BaseUnitTest;
import renthelper.core.model.RentInfo;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static renthelper.core.utils.PrintUtil.*;
/**
 * Created with by shuangyao on 2016/10/21.
 */
public class RentInfoServiceTest extends BaseUnitTest {

    @Resource
    private RentInfoService rentInfoService;

    @Test
    public void testSave() throws Exception {
        RentInfo rentInfo = new RentInfo();
        rentInfo.setUid(3);
        rentInfo.setCreateTime(new Date());
        rentInfo.setStartTime(DateUtils.addDays(new Date(), -5));
        rentInfo.setEndTime(DateUtils.addDays(new Date(), 10));
        rentInfo.setRid(3);
        rentInfo.setRentalPerMonth(100);
        rentInfo.setRenterNumber(2);
        rentInfo.setRentalExpireTime(new SimpleDateFormat("yyyy-MM-dd").parse("2016-10-20"));
        rentInfoService.save(rentInfo);
    }

    @Test
    public void testUpdateExpireTime() throws Exception {
        rentInfoService.updateExpireTime(new Date(), 2);
    }

    @Test
    public void testGetExpireInfo() throws Exception {
        List<RentInfo> rentInfos = rentInfoService.getExpireInfo();
        if (rentInfos == null || rentInfos.size() == 0) {
            println("No info found.");
        }

        for (RentInfo rentInfo : rentInfos) {
            println(rentInfo);
        }

    }
}
