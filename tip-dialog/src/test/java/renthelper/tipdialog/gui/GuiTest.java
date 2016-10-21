package renthelper.tipdialog.gui;

import org.junit.Test;
import org.springframework.core.task.TaskExecutor;
import renthelper.core.BaseUnitTest;
import renthelper.core.constants.GuiLocationEnum;
import renthelper.core.utils.GuiUtil;

import javax.annotation.Resource;

/**
 * Created with by shuangyao on 2016/10/14.
 */
public class GuiTest {

    @Resource
    private TaskExecutor taskExecutor;

    @Test
    public void testTipShowDialog() throws Exception {
        GuiUtil.setDefaultLookAndFeel();
        TipDialog tipDialog = new TipDialog();
        GuiUtil.setLocation(tipDialog, GuiLocationEnum.BUTTOM_RIGHT);
        tipDialog.setEventKey("1");
        tipDialog.setVisible(true);
    }

    @Test
    public void testConfirmDialog() throws Exception {
        GuiUtil.setDefaultLookAndFeel();
        ConfirmDialog dialog = new ConfirmDialog("name", "mobile", 111, 3, 123, "title");
    }
}
