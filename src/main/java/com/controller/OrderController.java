package com.controller;

import com.dao.DoorMapper;
import com.dao.OrderMapper;
import com.pojo.Door;
import com.pojo.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import java.util.List;

/**
 * @author wyy
 * @date 2019/10/12 14:12
 * @description com.controller.OrderController
 */
@Controller
public class OrderController {
    @Resource
    private OrderMapper dao;
    @Resource
    private DoorMapper dao2;

    @RequestMapping("/orderList")
    public String findAll(Model model){
        List<Order> list=dao.findAll();
        for(Order od:list){
            od.setDoor(dao2.findById(od.getDoorId()));
        }
         model.addAttribute("list",list);
         return "order_list";
    }
    @RequestMapping("/order_beforeAdd")
    public String BeforeAdd(Model model){
        List<Door> doors=dao2.findAll();
        model.addAttribute("doors",doors);
        return "order_add";
    }
    @RequestMapping("/orderAdd")
    public String addOrder(Order order){
        dao.addOrder(order);
        return "forward:/orderList";
    }
    @RequestMapping("/orderDelete")
    public String delOrder(Integer id){
        dao.deleteById(id);
        return "forward:/orderList";
    }
    @RequestMapping("/orderInfo")
    public String Update(Integer id,Model model){
       Order order1=dao.findById(id);
       order1.setDoor(dao2.findById(order1.getDoorId()));
       List<Door> list=dao2.findAll();
       model.addAttribute("order",order1);
        System.out.println("------------------------------------------------------------------------------------");
       System.out.println(order1.toString());
       model.addAttribute("list",list);
       return "order_update";
    }
    @RequestMapping("orderUpdate")
    public String orderUpdate(Order order){
        dao.updateById(order);
        return "forward:/orderList";
    }

}
