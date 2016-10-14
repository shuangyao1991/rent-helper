package renthelper.tipdialog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import renthelper.core.constants.GuiConstant;

import javax.swing.*;


/**
 * Created with by shuangyao on 2016/10/11.
 */
public class TipDialog extends JDialog {

    private static final Logger logger = LoggerFactory.getLogger(TipDialog.class);

    private JTextPane tips;
    private JButton ok;
    private JButton cancel;

    private int width;
    private int height;
    private String title = GuiConstant.TIP_DIALOG_TITLE;
    private String message;
    private int flag;

    static {
        try {
            logger.debug("SetLookAndFeel...");
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException
                |InstantiationException
                |IllegalAccessException
                |UnsupportedLookAndFeelException e) {
            logger.error("SetLookAndFeel failed!", e);
        }
    }

    public TipDialog() {
        super();
        this.setTitle(GuiConstant.TIP_DIALOG_TITLE);

    }

    public void initializingComponent() {
        logger.debug("Initializing...");

        logger.debug("Initializing success.");
    }

}
