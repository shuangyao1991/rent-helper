//package renthelper.tipdialog.tasks;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//import renthelper.core.model.RentInfo;
//import renthelper.core.service.RentInfoService;
//import renthelper.core.service.RentLogService;
//import renthelper.core.service.RenterService;
//
//import java.util.List;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by flyig.
// * Date: 2016/10/22.
// */
//@Service
//public class QueryTask {
//
//    @Autowired
//    private RentInfoService rentInfoService;
//
//    @Autowired
//    private RenterService renterService;
//
//    @Autowired
//    private RentLogService rentLogService;
//
//
//    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(
//            5);
//
//    @Scheduled(cron = "0/5 * * * * ?")
//    public void query() {
//        System.out.println("Scheduled....");
//        List<RentInfo> rentInfos = rentInfoService.getExpireInfo();
//        if (rentInfos == null || rentInfos.size() == 0) {
//            return;
//        }
//
//        for (final RentInfo rentInfo : rentInfos) {
//            scheduledExecutorService.schedule(new Runnable() {
//                @Override
//                public void run() {
//                    GuiTask.startTipDialog(rentInfo.getIid(),
//                            renterService, rentInfoService, rentLogService);
//                }
//            }, 5, TimeUnit.SECONDS);
//
//        }
//    }
//
//}
