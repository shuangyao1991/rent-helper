package renthelper.core.service;

import renthelper.core.model.Room;

import java.util.List;

/**
 * Created with by shuangyao on 2016/10/26.
 */
public interface RoomService {

    public void save(Room room);

    public List<Integer> getIds();

    public List<Room> getAll();
}
