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
import renthelper.core.service.RenterService;
import renthelper.tipdialog.gui.ConfirmDialog;
import renthelper.tipdialog.gui.TipDialog;

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

    private TaskExecutor taskExecutor;

    private RenterService renterService;

    private RentInfoService rentInfoService;

    public TipDialogListener(TaskExecutor taskExecutor, RenterService renterService, RentInfoService rentInfoService) {
        this.taskExecutor = taskExecutor;
        this.renterService = renterService;
        this.rentInfoService = rentInfoService;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getName().equals("ok")) {
            String eventKey = tipDialog.getEventKey();
            final int iid = Integer.valueOf(eventKey);
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    confirmInfo(iid);
                }
            });
        }
        tipDialog.close();
    }

    public void confirmInfo(int iid) {
        RentInfo rentInfo = rentInfoService.getById(iid);
        if (rentInfo == null) {
            logger.debug("Can not find the rent information for iid={}", iid);
            JOptionPane.showMessageDialog(null,
                    "获取不到该项信息！",
                    "警告",
                    JOptionPane.OK_OPTION);
            return;
        }

        Renter renter = renterService.getById(rentInfo.getUid());
        if (rentInfo == null) {
            logger.debug("Can not find the rent information for iid={}", iid);
            JOptionPane.showMessageDialog(null,
                    "获取不到该项信息！",
                    "警告",
                    JOptionPane.OK_OPTION);
            return;
        }

        RentTypeEnum rentType = RentTypeEnum.getByDesc(rentInfo.getType());
        int money = rentType.getMonths() * rentInfo.getRentalPerMonth();
        new ConfirmDialog(renter.getName(), renter.getMobile(), rentInfo.getRid(),
                rentType.getMonths(), money, "title");
    }

    public TipDialog getTipDialog() {
        return tipDialog;
    }

    public void setTipDialog(TipDialog tipDialog) {
        this.tipDialog = tipDialog;
    }
}
