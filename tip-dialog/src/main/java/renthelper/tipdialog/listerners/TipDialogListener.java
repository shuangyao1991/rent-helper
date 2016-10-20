package renthelper.tipdialog.listerners;

import renthelper.tipdialog.gui.TipDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with by shuangyao on 2016/10/20.
 */
public class TipDialogListener implements ActionListener {

    private TipDialog tipDialog;

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getName().equals("ok")) {

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
