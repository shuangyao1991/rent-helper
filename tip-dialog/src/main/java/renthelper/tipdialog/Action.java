package renthelper.tipdialog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;
import renthelper.core.constants.GuiLocationEnum;
import renthelper.core.service.RentInfoService;
import renthelper.core.service.RenterService;
import renthelper.core.utils.GuiUtil;
import renthelper.tipdialog.gui.TipDialog;
import renthelper.tipdialog.listerners.TipDialogListener;

/**
 * Created with by shuangyao on 2016/10/21.
 */
public class Action {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "test");
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath*:/spring-context.xml");
        System.setProperty("spring.profile.active", "test");
        TaskExecutor taskExecutor = ac.getBean(TaskExecutor.class);
        RenterService renterService = ac.getBean(RenterService.class);
        RentInfoService rentInfoService = ac.getBean(RentInfoService.class);
        TipDialogListener listener = new TipDialogListener(taskExecutor, renterService, rentInfoService);

        GuiUtil.setDefaultLookAndFeel();
        TipDialog tipDialog = new TipDialog();
        tipDialog.addActionListener(listener);
        GuiUtil.setLocation(tipDialog, GuiLocationEnum.BUTTOM_RIGHT);
        tipDialog.setEventKey("1");
        tipDialog.setVisible(true);
    }
}
