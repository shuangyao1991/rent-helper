package renthelper.tipdialog.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import renthelper.core.model.RentInfo;
import renthelper.core.model.RentLog;
import renthelper.core.model.Renter;
import renthelper.core.service.RentInfoService;
import renthelper.core.service.RentLogService;
import renthelper.core.service.RenterService;

import java.util.List;

/**
 * Created by flyig.
 * Date: 2016/10/22.
 */
@Service
public class QueryTask {

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private RentInfoService rentInfoService;

    @Autowired
    private RenterService renterService;

    @Autowired
    private RentLogService rentLogService;

    @Scheduled(fixedRate = 50000)
    public void query() {
        System.out.println("Scheduled....");
        List<RentInfo> rentInfos = rentInfoService.getExpireInfo();
        if (rentInfos == null || rentInfos.size() == 0) {
            return;
        }

        for (final RentInfo rentInfo : rentInfos) {
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    GuiTask.startTipDialog(rentInfo.getIid(),
                            renterService, rentInfoService, rentLogService);
                }
            });
        }
    }

}
