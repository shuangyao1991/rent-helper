package renthelper.tipdialog.tasks;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import renthelper.core.constants.GuiLocationEnum;
import renthelper.core.constants.RentTypeEnum;
import renthelper.core.model.RentInfo;
import renthelper.core.model.Renter;
import renthelper.core.service.RentInfoService;
import renthelper.core.service.RentLogService;
import renthelper.core.service.RenterService;
import renthelper.core.utils.GuiUtil;
import renthelper.tipdialog.gui.ConfirmDialog;
import renthelper.tipdialog.gui.TipDialog;
import renthelper.tipdialog.listerners.ConfirmDialogListener;
import renthelper.tipdialog.listerners.TipDialogListener;

/**
 * Created by flyig.
 * Date: 2016/10/22.
 */
public class GuiTask {

    private static final Logger logger = LoggerFactory.getLogger(GuiTask.class);

    public static void startTipDialog(int iid, RenterService renterService,
                               RentInfoService rentInfoService,
                                      RentLogService rentLogService) {
        RentInfo rentInfo = rentInfoService.getById(iid);
        Renter renter = renterService.getById(rentInfo.getUid());
        String message = rentInfo.getRid() + "房间的房租已到期，请及时提醒用户缴租" +
                "：" + renter.getName() + ", " + renter.getMobile();
        GuiUtil.setDefaultLookAndFeel();
        TipDialogListener listener = new TipDialogListener(renterService,
                rentInfoService, rentLogService);
        TipDialog tipDialog = new TipDialog(message, rentInfo.getIid() + "");
        tipDialog.addActionListener(listener);
        GuiUtil.setLocation(tipDialog, GuiLocationEnum.BUTTOM_RIGHT);
        tipDialog.setVisible(true);

    }

    public static void startConfirmDialog(int iid, RenterService renterService,
                                          RentInfoService rentInfoService,
                                          RentLogService rentLogService) {
        GuiUtil.setDefaultLookAndFeel();
        ConfirmDialogListener listener = new ConfirmDialogListener(rentInfoService, rentLogService);

        RentInfo rentInfo = rentInfoService.getById(iid);
        Renter renter = renterService.getById(rentInfo.getUid());
        RentTypeEnum rentType = RentTypeEnum.getByDesc(rentInfo.getType());
        int money = rentType.getMonths() * rentInfo.getRentalPerMonth();
        ConfirmDialog confirmDialog = new ConfirmDialog(renter.getName(),
                renter.getMobile(), rentInfo.getRid(), rentType.getMonths(),
                rentInfo.getRentalPerMonth(), "title");
        confirmDialog.addListener(listener);
        GuiUtil.setLocation(confirmDialog, GuiLocationEnum.CENTER);
        confirmDialog.setVisible(true);
    }
}
