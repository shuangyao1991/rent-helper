package renthelper.tipdialog.gui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import renthelper.tipdialog.listerners.TipDialogListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created with by shuangyao on 2016/10/14.
 */
public class TipDialog extends JDialog{

    private final Logger logger = LoggerFactory.getLogger(TipDialog.class);

    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 200;
    private static final String DEFAULT_TITLE = "CustomDialog";
    private static final String DEFAULT_MESSAGE = "CustomDialog Message";

    private JTextPane messagePane;
    private JButton okButton;
    private JButton cancelButton;

    private int width = DEFAULT_WIDTH;
    private int height = DEFAULT_HEIGHT;
    private String title = DEFAULT_TITLE;
    private String message = DEFAULT_MESSAGE;

    private String eventKey;

    public TipDialog() {
        initializing(null);
    }

    public TipDialog(String message, String title, int width, int height) {
        this.message = message;
        this.title = title;
        this.width = width;
        this.height = height;
        initializing(null);
    }

    private void initializing(Frame owner) {
        this.setTitle(title);
        this.setModalityType(Dialog.ModalityType.TOOLKIT_MODAL);
        this.setBounds(0, 0, width, height);
        this.setLayout(new BorderLayout());

        messagePane = new JTextPane();
        messagePane.setEditable(false);
        messagePane.setAutoscrolls(true);
        messagePane.setText(message);
        this.getContentPane().add(messagePane, BorderLayout.CENTER);

        okButton = new JButton("ok");
        okButton.setName("ok");
        cancelButton = new JButton("cacel");
        cancelButton.setName("cancel");
        JPanel buttonPane = new JPanel();
        buttonPane.add(okButton);
        buttonPane.add(cancelButton);
        this.getContentPane().add(buttonPane, BorderLayout.SOUTH);
    }

    public void close() {
        this.dispose();
    }

    public void addActionListener(TipDialogListener listener) {
        listener.setTipDialog(this);
        okButton.addActionListener(listener);
        cancelButton.addActionListener(listener);
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
