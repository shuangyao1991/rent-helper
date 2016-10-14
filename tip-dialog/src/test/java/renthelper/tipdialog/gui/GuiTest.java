package renthelper.tipdialog.gui;

import org.junit.Test;

import static renthelper.tipdialog.TestUtil.println;
/**
 * Created with by shuangyao on 2016/10/14.
 */
public class GuiTest {

    @Test
    public void testCustomDialog() throws Exception {
        CustomDialog customDialog = new CustomDialog(null);
        customDialog.setVisible(true);
    }
}
