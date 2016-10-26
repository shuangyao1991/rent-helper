package renthelper.tipdialog.tasks;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import renthelper.core.model.RentInfo;
import renthelper.core.service.RentInfoService;
import renthelper.core.service.RentLogService;
import renthelper.core.service.RenterService;
import renthelper.core.utils.GuiUtil;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with by shuangyao on 2016/10/21.
 */
public class Action{

    private static final Logger logger = LoggerFactory.getLogger(Action.class);

    public static void main(String[] args) {
        logger.debug("Start initializing...");
        System.setProperty("spring.profiles.active", "test");
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath*:/spring-context.xml");
        System.setProperty("spring.profile.active", "test");
        GuiUtil.setDefaultLookAndFeel();
        logger.debug("End initializing...");
        query(ac);
    }

    public static void query(ApplicationContext ac) {
        final RenterService renterService = ac.getBean(RenterService.class);
        final RentInfoService rentInfoService = ac.getBean(RentInfoService.class);
        final RentLogService rentLogService = ac.getBean(RentLogService.class);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(
                5);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Querying...");
                List<RentInfo> rentInfos = rentInfoService.getExpireInfo();
                if (rentInfos == null || rentInfos.size() == 0) {
                    return;
                }

                for (final RentInfo rentInfo : rentInfos) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            GuiTask.startTipDialog(rentInfo.getIid(),
                                    renterService, rentInfoService, rentLogService);
                        }
                    }).start();
                }
            }
        }, 3, 15, TimeUnit.SECONDS);
    }



}
