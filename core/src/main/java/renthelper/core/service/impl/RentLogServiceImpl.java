package renthelper.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import renthelper.core.dao.RentLogDAO;
import renthelper.core.model.RentLog;
import renthelper.core.service.RentLogService;

import javax.annotation.Resource;

/**
 * Created with by shuangyao on 2016/10/21.
 */
@Service
public class RentLogServiceImpl implements RentLogService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private RentLogDAO rentLogDAO;

    @Override
    public int getMaxId() {
        return rentLogDAO.getMaxId();
    }

    @Override
    public void save(RentLog rentLog) {
        if (rentLog == null) {
            logger.warn("Essential information absent to save.");
            return;
        }

        Integer id = rentLogDAO.getMaxId();
        id = id == null ? 0 : id;
        rentLog.setLid(id + 1);
        rentLogDAO.save(rentLog);
    }
}
