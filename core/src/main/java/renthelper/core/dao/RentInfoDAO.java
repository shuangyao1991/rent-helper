package renthelper.core.dao;

import org.apache.ibatis.annotations.Param;
import renthelper.core.model.RentInfo;

import java.util.Date;
import java.util.List;

/**
 * Created with by shuangyao on 2016/10/20.
 */
public interface RentInfoDAO {

    public Integer getMaxId();

    public RentInfo getById(@Param("iid") int iid);

    public void save(@Param("rentInfo") RentInfo rentInfo);

    public void updateExpireTime(@Param("rentalExpireTime") Date rentalExpireTime,
                                 @Param("iid") int iid);

    public List<RentInfo> getExpireInfo();
}
