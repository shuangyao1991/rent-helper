package renthelper.tipdialog.listerners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;
import renthelper.core.constants.RentTypeEnum;
import renthelper.core.model.RentInfo;
import renthelper.core.model.Renter;
import renthelper.core.service.RentInfoService;
import renthelper.core.service.RentLogService;
import renthelper.core.service.RenterService;
import renthelper.tipdialog.gui.ConfirmDialog;
import renthelper.tipdialog.gui.TipDialog;
import renthelper.tipdialog.tasks.GuiTask;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with by shuangyao on 2016/10/20.
 */

public class TipDialogListener implements ActionListener {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private TipDialog tipDialog;

    private RenterService renterService;

    private RentInfoService rentInfoService;

    private RentLogService rentLogService;

    public TipDialogListener(RenterService renterService,
                             RentInfoService rentInfoService,
                             RentLogService rentLogService) {
        this.renterService = renterService;
        this.rentInfoService = rentInfoService;
        this.rentLogService = rentLogService;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tipDialog.setVisible(false);
        JButton button = (JButton) e.getSource();
        if (button.getName().equals("ok")) {
            String eventKey = tipDialog.getEventKey();
            final int iid = Integer.valueOf(eventKey);
            GuiTask.startConfirmDialog(iid, renterService,
                    rentInfoService, rentLogService);
        }
        tipDialog.close();
    }

    public void setTipDialog(TipDialog tipDialog) {
        this.tipDialog = tipDialog;
    }
}
