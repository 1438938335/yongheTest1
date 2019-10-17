package com.service.imp;

import com.dao.OrderMapper;
import com.pojo.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wyy
 * @date 2019/10/17 10:47
 * @description com.service.imp.OrderServiceImp
 */
@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderMapper dao;
    @Override
    public List<Order> findAll() {
        return dao.findAll();
    }

    @Override
    public void addOrder(Order order) {
        dao.addOrder(order);
    }

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public Order findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public void updateById(Order order) {
        dao.updateById(order);
    }
}
