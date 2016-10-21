package renthelper.core.service;

import renthelper.core.model.Renter;

import java.util.Date;
import java.util.List;

/**
 * Created with by shuangyao on 2016/10/20.
 */
public interface RenterService {

    public void save(Renter renter);

    public List<Renter> getAll();

    public Renter getById(int id);

    public Renter getByName(String name);
}
