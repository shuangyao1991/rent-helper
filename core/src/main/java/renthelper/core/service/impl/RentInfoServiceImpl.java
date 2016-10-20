package renthelper.core.service.impl;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import renthelper.core.dao.RentInfoDAO;
import renthelper.core.model.RentInfo;
import renthelper.core.service.RentInfoService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by flyig.
 * Date: 2016/10/20.
 */
@Service
public class RentInfoServiceImpl implements RentInfoService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private RentInfoDAO rentInfoDAO;

    @Override
    public int getMaxId() {
        return rentInfoDAO.getMaxId();
    }

    @Override
    public void save(RentInfo rentInfo) {
        if (rentInfo == null) {
            logger.warn("Essential information absent to save.");
            return;
        }

        int id = rentInfoDAO.getMaxId();
        rentInfo.setIid(id);
        rentInfoDAO.save(rentInfo);
    }

    @Override
    public void update(RentInfo rentInfo) {
        if (rentInfo == null || rentInfo.getIid() == null) {
            logger.warn("No essential information to save.");
            return;
        }

        rentInfoDAO.update(rentInfo);
    }

    @Override
    public List<RentInfo> getExpireInfo(String currentTime) {
        List<RentInfo> rentInfos = Lists.newArrayList();
        if (StringUtils.isBlank(currentTime)) {
            logger.warn("Null query condition.");
            return rentInfos;
        }

        try {
            Date date = new Date(currentTime);
        } catch (Exception e) {
            logger.error("Illegal query time.", e);
            return rentInfos;
        }


        return null;
    }
}
