package renthelper.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import renthelper.core.dao.RoomDAO;
import renthelper.core.model.Room;
import renthelper.core.service.RoomService;

import java.util.List;

/**
 * Created with by shuangyao on 2016/10/26.
 */
@Service
public class RoomServiceImpl implements RoomService{

    private final Logger logger = LoggerFactory.getLogger(RoomService.class);

    @Autowired
    private RoomDAO roomDAO;

    @Override
    public void save(Room room) {
        if (room == null
                || room.getRid() == null
                || room.getRid().intValue() < 0) {
            logger.warn("Null room information to save.");
            return;
        }

        List<Integer> ids = roomDAO.getIds();
        if (ids != null && ids.contains(room.getRid())) {
            logger.warn("Room id {} already exists.", room.getRid());
            return;
        }

        roomDAO.save(room);
    }

    @Override
    public List<Integer> getIds() {
        return roomDAO.getIds();
    }

    @Override
    public List<Room> getAll() {
        return roomDAO.getAll();
    }
}
