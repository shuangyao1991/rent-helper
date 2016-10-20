package renthelper.core.dao;

import renthelper.core.model.RentLog;

import java.util.List;

/**
 * Created with by shuangyao on 2016/10/20.
 */
public interface RentLogDAO {

    public void getMaxId();

    public void save(RentLog rentLog);

    public List<RentLog> query(int offset, int limit);
}
