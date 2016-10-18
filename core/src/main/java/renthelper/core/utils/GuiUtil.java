package renthelper.core.utils;

import com.google.common.base.Preconditions;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import renthelper.core.constants.GuiConstant;
import renthelper.core.constants.GuiLocationEnum;

import javax.swing.*;
import java.awt.*;

/**
 * Created by flyig.
 * Date: 2016/10/16.
 */
public class GuiUtil {

    private static final Logger logger = LoggerFactory.getLogger(GuiUtil.class);

    public static void setLocation(Component component, GuiLocationEnum location) {
        switch (location) {
            case UP_LEFT:
                component.setLocation(0, 0);
                break;
            case UP_RIGHT:
                component.setLocation(GuiConstant.screenSize.width - component.getWidth(), 0);
                break;
            case BUTTOM_LEFT:
                component.setLocation(0,
                        GuiConstant.screenSize.height - GuiConstant.screenInsets.bottom - component.getHeight());
                break;
            case BUTTOM_RIGHT:
                component.setLocation(GuiConstant.screenSize.width - component.getWidth(),
                        GuiConstant.screenSize.height - GuiConstant.screenInsets.bottom - component.getHeight());
                break;
            default:
                component.setLocation(GuiConstant.screenSize.width / 2 - component.getWidth() / 2,
                        GuiConstant.screenSize.height / 2 - component.getHeight() / 2);
        }
    }

    public static void setLookAndFeel(String lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (ClassNotFoundException
                |InstantiationException
                |IllegalAccessException e) {
            logger.error("Catch exception {}", e);
            logger.error("SetLookAndFeel failed!", e);
        }  catch (UnsupportedLookAndFeelException e) {
            logger.debug("Catch UnsupportedLookAndFeelException, invoke default lookAndFeel.");
            setDefaultLookAndFeel();
        }
    }

    public static void setDefaultLookAndFeel() {
        try {
            logger.debug("Set default lookAndFeel...");
            UIManager.setLookAndFeel(GuiConstant.DEFAULT_LOOKANDFEEL);
        } catch (ClassNotFoundException
                |InstantiationException
                |IllegalAccessException
                |UnsupportedLookAndFeelException e) {
            logger.error("Set default lookAndFeel failed!", e);
        }
    }
}
