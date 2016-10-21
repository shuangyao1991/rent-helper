package renthelper.core.service;

import renthelper.core.model.RentLog;

import java.util.List;

/**
 * Created by flyig.
 * Date: 2016/10/20.
 */
public interface RentLogService {

    public int getMaxId();

    public void save(RentLog rentLog);
}
