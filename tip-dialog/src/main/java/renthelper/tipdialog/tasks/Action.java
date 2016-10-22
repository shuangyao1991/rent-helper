package renthelper.tipdialog.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import renthelper.core.constants.GuiLocationEnum;
import renthelper.core.constants.RentTypeEnum;
import renthelper.core.model.RentInfo;
import renthelper.core.model.Renter;
import renthelper.core.service.RentInfoService;
import renthelper.core.service.RenterService;
import renthelper.core.utils.GuiUtil;
import renthelper.tipdialog.gui.ConfirmDialog;
import renthelper.tipdialog.gui.TipDialog;
import renthelper.tipdialog.listerners.TipDialogListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with by shuangyao on 2016/10/21.
 */
public class Action{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "test");
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath*:/spring-context.xml");
        System.setProperty("spring.profile.active", "test");

    }

}
