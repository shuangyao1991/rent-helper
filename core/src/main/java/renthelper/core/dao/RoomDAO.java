package renthelper.core.dao;

import org.apache.ibatis.annotations.Param;
import renthelper.core.model.Room;

import java.util.List;

/**
 * Created with by shuangyao on 2016/10/26.
 */
public interface RoomDAO {

    public void save(@Param("room") Room room);

    public List<Integer> getIds();

    public List<Room> getAll();
}
