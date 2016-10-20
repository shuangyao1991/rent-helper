package renthelper.tipdialog.gui;

import org.junit.Test;
import renthelper.core.constants.GuiLocationEnum;
import renthelper.core.utils.GuiUtil;

/**
 * Created with by shuangyao on 2016/10/14.
 */
public class GuiTest {

    @Test
    public void testTipShowDialog() throws Exception {
        GuiUtil.setDefaultLookAndFeel();
        TipDialog tipDialog = new TipDialog();
        GuiUtil.setLocation(tipDialog, GuiLocationEnum.BUTTOM_RIGHT);
        tipDialog.setVisible(true);
    }

    @Test
    public void testConfirmDialog() throws Exception {
        GuiUtil.setDefaultLookAndFeel();
        ConfirmDialog dialog = new ConfirmDialog("name", "mobile", 111, 3, 123, "title");
    }
}
