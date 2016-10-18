package renthelper.tipdialog.gui;

import org.junit.Test;
import renthelper.core.constants.GuiConstant;
import renthelper.core.constants.GuiLocationEnum;
import renthelper.core.utils.GuiUtil;

/**
 * Created with by shuangyao on 2016/10/14.
 */
public class GuiTest {

    @Test
    public void testCustomDialog() throws Exception {
        GuiUtil.setDefaultLookAndFeel();
        CustomDialog customDialog = new CustomDialog(1);
        GuiUtil.setLocation(customDialog, GuiLocationEnum.BUTTOM_RIGHT);
        customDialog.setVisible(true);


    }
}
