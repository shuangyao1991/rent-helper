package renthelper.tipdialog.gui;

import com.google.common.base.Preconditions;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import renthelper.core.constants.GuiLocationEnum;

import javax.swing.*;
import java.awt.*;

/**
 * Created with by shuangyao on 2016/10/14.
 */
public class CustomDialog extends JDialog{

    private static final Logger logger = LoggerFactory.getLogger(CustomDialog.class);

    private static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    private static final String DEFAULT_LOOKANDFEEL = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
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
    private int key;

    public CustomDialog() {
        initializing(null);
    }

    public CustomDialog(int key) {
        this.key = key;
        initializing(null);
    }

    public CustomDialog(int key, String message, String title, int width, int height) {
        this.key = key;
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
        cancelButton = new JButton("cacel");
        JPanel buttonPane = new JPanel();
        buttonPane.add(okButton);
        buttonPane.add(cancelButton);
        this.getContentPane().add(buttonPane, BorderLayout.SOUTH);
    }

    public int getKey() {
        return key;
    }

    public void close() {
        this.dispose();
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }
}
