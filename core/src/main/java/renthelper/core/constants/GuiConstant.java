package renthelper.core.constants;

import javax.swing.*;
import java.awt.*;

/**
 * Created with by shuangyao on 2016/10/14.
 */
public class GuiConstant {

    public static final Dimension screenSize =
            Toolkit.getDefaultToolkit().getScreenSize();
    public static final Insets screenInsets =
            Toolkit.getDefaultToolkit().getScreenInsets(new JFrame().getGraphicsConfiguration());

    public static final String DEFAULT_LOOKANDFEEL = "javax.swing.plaf.nimbus.NimbusLookAndFeel";

    public static final String TIP_DIALOG_TITLE = "tips";
}
