package renthelper.core.service;

import org.junit.Test;
import renthelper.core.BaseUnitTest;
import renthelper.core.model.RentLog;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created with by shuangyao on 2016/10/21.
 */
public class RentLogServiceTest extends BaseUnitTest {

    @Resource
    private RentLogService rentLogService;

    @Test
    public void testSave() throws Exception {
        RentLog rentLog = new RentLog();
        rentLog.setUid(1);
        rentLog.setRid(1);
        rentLog.setPay(100);
        rentLog.setRentalExpireTime(new Date());
        rentLogService.save(rentLog);
    }
}
