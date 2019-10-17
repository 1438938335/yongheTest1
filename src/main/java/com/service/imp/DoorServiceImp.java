package com.service.imp;

import com.dao.DoorMapper;
import com.pojo.Door;
import com.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wyy
 * @date 2019/10/17 10:47
 * @description com.service.imp.DoorServiceImp
 */
@Service
public class DoorServiceImp implements DoorService {
    @Autowired
    private DoorMapper dao;
    @Override
    public List<Door> findAll() {
        return dao.findAll();
    }

    @Override
    public void addDoor(Door door) {
        dao.addDoor(door);
    }

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public Door findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public void updateById(Door door) {
        dao.updateById(door);
    }
}
