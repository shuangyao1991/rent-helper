package renthelper.tipdialog.gui;

import org.junit.Test;
import org.springframework.core.task.TaskExecutor;
import renthelper.core.BaseUnitTest;
import renthelper.core.constants.GuiLocationEnum;
import renthelper.core.utils.GuiUtil;
import renthelper.tipdialog.listerners.ConfirmDialogListener;
import renthelper.tipdialog.listerners.TipDialogListener;
import renthelper.tipdialog.tasks.GuiTask;

import javax.annotation.Resource;

/**
 * Created with by shuangyao on 2016/10/14.
 */
public class GuiTest {

    @Test
    public void testTipShowDialog() throws Exception {
        GuiTask.startTipDialog(1, null, null, null);
    }

    @Test
    public void testConfirmDialog() throws Exception {
        GuiTask.startConfirmDialog(1, null, null, null);
    }
}
