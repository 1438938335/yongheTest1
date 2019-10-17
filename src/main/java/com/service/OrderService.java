package com.service;

import com.pojo.Order;

import java.util.List;

/**
 * @author wyy
 * @date 2019/10/17 10:43
 * @description com.service.OrderService
 */
public interface OrderService {
    public List<Order> findAll();
    /** 2、新增门店信息 */
    public void addOrder(Order order);
    /** 3、根据id删除门店信息 */
    public void deleteById(Integer id);
    /** 4、根据id查询门店信息 */
    public Order findById(Integer id);
    /** 5、根据id修改门店信息 */
    public void updateById(Order order);
}
