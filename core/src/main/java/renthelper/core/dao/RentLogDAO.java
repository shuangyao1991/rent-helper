package renthelper.core.dao;

import org.apache.ibatis.annotations.Param;
import renthelper.core.model.RentLog;

import java.util.List;

/**
 * Created with by shuangyao on 2016/10/20.
 */
public interface RentLogDAO {

    public Integer getMaxId();

    public void save(@Param("rentLog") RentLog rentLog);
}
