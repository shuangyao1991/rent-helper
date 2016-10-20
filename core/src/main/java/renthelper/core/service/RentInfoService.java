package renthelper.core.service;

import renthelper.core.model.RentInfo;

import java.util.List;

/**
 * Created by flyig.
 * Date: 2016/10/20.
 */
public interface RentInfoService {

    public int getMaxId();

    public void save(RentInfo rentInfo);

    public void update(RentInfo rentInfo);

    public List<RentInfo> getExpireInfo(String currentTime);
}
