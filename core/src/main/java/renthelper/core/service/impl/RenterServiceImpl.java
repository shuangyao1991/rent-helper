package renthelper.core.service.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import renthelper.core.dao.RenterDAO;
import renthelper.core.model.Renter;
import renthelper.core.service.RenterService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created with by shuangyao on 2016/10/20.
 */
@Service
public class RenterServiceImpl implements RenterService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private RenterDAO renterDAO;

    @Override
    public void save(Renter renter) {
        if (renter == null || StringUtils.isBlank(renter.getName())) {
            logger.warn("Essential information absent to save.");
            return;
        }
        Integer id = renterDAO.getMaxId();
        id = id == null ? 0 : id;
        renter.setUid(id + 1);
        renterDAO.save(renter);
    }

    @Override
    public List<Renter> getAll() {
        List<Renter> renters = renterDAO.getAll();
        return renters;
    }

    @Override
    public Renter getById(int id) {
        Renter renter = renterDAO.getById(id);
        return renter;
    }

    @Override
    public Renter getByName(String name) {
        return renterDAO.getByName(name);
    }

}
