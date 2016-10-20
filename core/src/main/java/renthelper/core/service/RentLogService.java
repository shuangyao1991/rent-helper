package renthelper.core.service;

import renthelper.core.model.RentLog;

import java.util.List;

/**
 * Created by flyig.
 * Date: 2016/10/20.
 */
public interface RentLogService {

    public void getMaxId();

    public void save(RentLog rentLog);

    public List<RentLog> query(int offset, int limit);
}
