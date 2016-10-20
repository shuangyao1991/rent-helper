package renthelper.tipdialog.listerners;

import renthelper.core.dao.RentInfoDAO;
import renthelper.core.dao.RenterDAO;
import renthelper.core.model.RentInfo;
import renthelper.core.model.Renter;
import renthelper.core.service.RentInfoService;
import renthelper.core.service.RenterService;
import renthelper.core.service.impl.RenterServiceImpl;
import renthelper.tipdialog.gui.TipDialog;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with by shuangyao on 2016/10/20.
 */
public class TipDialogListener implements ActionListener {

    private TipDialog tipDialog;

    @Resource
    private RenterService renterService;

    @Resource
    private RentInfoService rentInfoService;

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getName().equals("ok")) {
            String eventKey = tipDialog.getEventKey();
            int iid = Integer.valueOf(eventKey);

        } else {
            tipDialog.close();
        }
    }

    public TipDialog getTipDialog() {
        return tipDialog;
    }

    public void setTipDialog(TipDialog tipDialog) {
        this.tipDialog = tipDialog;
    }
}
