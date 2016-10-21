package renthelper.core.service;

import renthelper.core.model.RentInfo;

import java.util.Date;
import java.util.List;

/**
 * Created by flyig.
 * Date: 2016/10/20.
 */
public interface RentInfoService {

    public int getMaxId();

    public RentInfo getById(int iid);

    public void save(RentInfo rentInfo);

    public void updateExpireTime(Date rentalExpireTime, int iid);

    public List<RentInfo> getExpireInfo();
}
