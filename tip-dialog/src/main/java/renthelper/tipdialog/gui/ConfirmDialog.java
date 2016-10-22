package renthelper.tipdialog.gui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import renthelper.core.layout.GBC;
import renthelper.tipdialog.listerners.ConfirmDialogListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with by shuangyao on 2016/10/20.
 */
public class ConfirmDialog extends JDialog {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final int DEFAULT_WIDTH = 200;
    private static final int DEFAULT_HEIGHT = 200;
    private static final String DEFAULT_TITLE = "ConfirmDialog";
    private static final String[] months = {"1", "3", "6", "12"};

    private JPanel infoPane;
    private JLabel nameLabel;
    private JLabel nameValueLabel;
    private JLabel mobileLabel;
    private JLabel mobileValueLabel;
    private JLabel roomLabel;
    private JLabel roomValueLabel;
    private JLabel monthsLabel;
    private JComboBox monthBox;
    private JLabel moneyLabel;
    private JTextField moneyValueField;

    private JPanel buttonPane;
    private JButton okButton;
    private JButton cancelButton;

    private int width = DEFAULT_WIDTH;
    private int height = DEFAULT_HEIGHT;
    private String title = DEFAULT_TITLE;
    private String name, mobile;
    private int room, month, moneyPerMonth;

    public ConfirmDialog(String name, String mobile, int room,
                         int month, int moneyPerMonth, String title) {
        this.name = name;
        this.mobile = mobile;
        this.room = room;
        this.month = month;
        this.moneyPerMonth = moneyPerMonth;
        this.title = title;
        initializing();
    }

    public void initializing() {
        this.setModalityType(Dialog.ModalityType.TOOLKIT_MODAL);
        this.setBounds(0, 0, width, height);
        this.setLayout(new BorderLayout());

        infoPane = new JPanel(new GridBagLayout());
        nameLabel = new JLabel("姓名：");
        nameValueLabel = new JLabel(name);
        mobileLabel = new JLabel("电话：");
        mobileValueLabel = new JLabel(mobile);
        roomLabel = new JLabel("房号：");
        roomValueLabel = new JLabel(room + "");
        monthsLabel = new JLabel("缴纳月数：");
        monthBox = new JComboBox(months);
        monthBox.setSelectedItem(month + "");
        monthBox.addActionListener(null);
        moneyLabel = new JLabel("缴纳金额：");
        moneyValueField = new JTextField();
        moneyValueField.setText(moneyPerMonth * month + "");
        moneyValueField.setEditable(false);
        infoPane.add(nameLabel, new GBC(0, 0)
                .setAnchor(GBC.EAST));
        infoPane.add(nameValueLabel, new GBC(1, 0)
                .setAnchor(GBC.WEST));
        infoPane.add(mobileLabel, new GBC(0, 1)
                .setAnchor(GBC.EAST));
        infoPane.add(mobileValueLabel, new GBC(1, 1)
                .setAnchor(GBC.WEST));
        infoPane.add(roomLabel, new GBC(0, 2)
                .setAnchor(GBC.EAST));
        infoPane.add(roomValueLabel, new GBC(1, 2)
                .setAnchor(GBC.WEST));
        infoPane.add(monthsLabel, new GBC(0, 3)
                .setAnchor(GBC.EAST));
        infoPane.add(monthBox, new GBC(1, 3)
                .setAnchor(GBC.WEST));
        infoPane.add(moneyLabel, new GBC(0, 4)
                .setAnchor(GBC.EAST));
        infoPane.add(moneyValueField, new GBC(1, 4)
                .setAnchor(GBC.WEST));
        this.add(infoPane, BorderLayout.CENTER);

        buttonPane = new JPanel();
        okButton = new JButton("ok");
        okButton.setName("ok");
        cancelButton = new JButton("cancel");
        cancelButton.setName("cancel");
        buttonPane.add(okButton);
        buttonPane.add(cancelButton);
        this.add(buttonPane, BorderLayout.SOUTH);
    }

    public void setMoney(int monthNum) {
        moneyValueField.setText(moneyPerMonth * monthNum + "");
    }

    public void addListener(ConfirmDialogListener listener) {
        listener.setConfirmDialog(this);
        okButton.addActionListener(listener);
        cancelButton.addActionListener(listener);
        monthBox.addItemListener(listener);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
