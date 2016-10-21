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

        Integer id = rentInfoDAO.getMaxId();
        id = id == null ? 0 : id;
        rentInfo.setIid(id + 1);
        rentInfoDAO.save(rentInfo);
    }

    @Override
    public void updateExpireTime(Date rentalExpireTime, int iid) {
        if (rentalExpireTime == null) {
            logger.warn("No essential information to save.");
            return;
        }

        rentInfoDAO.updateExpireTime(rentalExpireTime, iid);
    }

    @Override
    public List<RentInfo> getExpireInfo() {
        List<RentInfo> rentInfos = Lists.newArrayList();
        return rentInfoDAO.getExpireInfo();
    }

    @Override
    public RentInfo getById(int iid) {
        return rentInfoDAO.getById(iid);
    }
}
