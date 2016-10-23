package renthelper.tipdialog.listerners;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import renthelper.core.model.RentInfo;
import renthelper.core.model.RentLog;
import renthelper.core.service.RentInfoService;
import renthelper.core.service.RentLogService;
import renthelper.tipdialog.gui.ConfirmDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;

/**
 * Created by flyig.
 * Date: 2016/10/22.
 */
public class ConfirmDialogListener implements ActionListener, ItemListener {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private ConfirmDialog confirmDialog;

    private RentInfoService rentInfoService;

    private RentLogService rentLogService;

    public ConfirmDialogListener(RentInfoService rentInfoService, RentLogService rentLogService) {
        this.rentInfoService = rentInfoService;
        this.rentLogService = rentLogService;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getName().equals("ok")) {
            logger.debug("OK button pressed.");
            int iid = confirmDialog.getIid();
            int monthNum = confirmDialog.getMonth();
            RentInfo rentInfo = rentInfoService.getById(iid);
            Date expireTime = DateUtils.addMonths(rentInfo.getRentalExpireTime(), monthNum);
            rentInfoService.updateExpireTime(expireTime, iid);

            RentLog rentLog = new RentLog();
            rentLog.setUid(rentInfo.getUid());
            rentLog.setRid(rentInfo.getRid());
            rentLog.setRentalExpireTime(expireTime);
            rentLog.setPay(monthNum * rentInfo.getRentalPerMonth());
            rentLogService.save(rentLog);
        }
        confirmDialog.dispose();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object object = e.getItem();
        int monthNum = Integer.valueOf(String.valueOf(object));
        confirmDialog.setMoney(monthNum);

    }

    public void setConfirmDialog(ConfirmDialog confirmDialog) {
        this.confirmDialog = confirmDialog;
    }
}
