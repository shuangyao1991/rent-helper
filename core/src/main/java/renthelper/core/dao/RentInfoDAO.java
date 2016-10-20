package renthelper.core.dao;

import renthelper.core.model.RentInfo;

import java.util.List;

/**
 * Created with by shuangyao on 2016/10/20.
 */
public interface RentInfoDAO {

    public void save(RentInfo rentInfo);

    public void update(RentInfo rentInfo);

    public List<RentInfo> getExpireInfo(String currentTime);
}
