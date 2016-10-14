package renthelper.tipdialog.gui;

import com.google.common.base.Preconditions;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import renthelper.core.constants.GuiConstant;

import javax.swing.*;
import java.awt.*;

/**
 * Created with by shuangyao on 2016/10/14.
 */
public class CustomDialog extends JDialog {

    private static final Logger logger = LoggerFactory.getLogger(CustomDialog.class);

    private static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    private static final String DEFAULT_LOOKANDFEEL = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
    private static final int DEFAULT_WIDTH = 200;
    private static final int DEFAULT_HEIGHT = 50;
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

    static {
        setDefaultLookAndFeel();
    }

    public CustomDialog(Frame owner) {
        super(owner, DEFAULT_TITLE);
        initializing(DEFAULT_WIDTH, DEFAULT_WIDTH, DEFAULT_MESSAGE);
    }

    public CustomDialog(Frame owner, String title, String message) {
        super(owner, title);
        initializing(DEFAULT_WIDTH, DEFAULT_WIDTH, message);
    }

    public CustomDialog (Frame owner, int width, int height, String title, String message) {
        super(owner, title);
        initializing(width, height, message);
    }

    private void initializing(int width, int height, String message) {
        this.setModalityType(ModalityType.TOOLKIT_MODAL);
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




    public static void setLookAndFeel(String lookAndFeel) {
        Preconditions.checkArgument(StringUtils.isNotBlank(lookAndFeel));
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (ClassNotFoundException
                |InstantiationException
                |IllegalAccessException e) {
            logger.error("SetLookAndFeel failed!", e);
        }  catch (UnsupportedLookAndFeelException e) {
            logger.debug("Catch UnsupportedLookAndFeelException, invoke default lookAndFeel.");
            setDefaultLookAndFeel();
        }
    }

    public static void setDefaultLookAndFeel() {
        try {
            logger.debug("Set default lookAndFeel...");
            UIManager.setLookAndFeel(DEFAULT_LOOKANDFEEL);
        } catch (ClassNotFoundException
                |InstantiationException
                |IllegalAccessException
                |UnsupportedLookAndFeelException e) {
            logger.error("Set default lookAndFeel failed!", e);
        }
    }

}
