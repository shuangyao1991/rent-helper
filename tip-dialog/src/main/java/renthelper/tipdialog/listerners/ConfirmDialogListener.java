package renthelper.tipdialog.listerners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import renthelper.core.service.RentInfoService;
import renthelper.core.service.RentLogService;
import renthelper.tipdialog.gui.ConfirmDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getName().equals("ok")) {
            logger.debug("OK button pressed.");
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
