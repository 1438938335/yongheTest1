package com.controller;


import com.pojo.Door;
import com.pojo.Order;
import com.service.DoorService;
import com.service.OrderService;
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
    private OrderService orderService;
    @Resource
    private DoorService doorService;

    @RequestMapping("/orderList")
    public String findAll(Model model){
        List<Order> list=orderService.findAll();
        for(Order od:list){
            od.setDoor(doorService.findById(od.getDoorId()));
        }
         model.addAttribute("list",list);
         return "order_list";
    }
    @RequestMapping("/order_beforeAdd")
    public String BeforeAdd(Model model){
        List<Door> doors=doorService.findAll();
        model.addAttribute("doors",doors);
        return "order_add";
    }
    @RequestMapping("/orderAdd")
    public String addOrder(Order order){
        orderService.addOrder(order);
        return "forward:/orderList";
    }
    @RequestMapping("/orderDelete")
    public String delOrder(Integer id){
        orderService.deleteById(id);
        return "forward:/orderList";
    }
    @RequestMapping("/orderInfo")
    public String Update(Integer id,Model model){
       Order order1=orderService.findById(id);
       order1.setDoor(doorService.findById(order1.getDoorId()));
       List<Door> list=doorService.findAll();
       model.addAttribute("order",order1);
        System.out.println("------------------------------------------------------------------------------------");
       System.out.println(order1.toString());
       model.addAttribute("list",list);
       return "order_update";
    }
    @RequestMapping("orderUpdate")
    public String orderUpdate(Order order){
        orderService.updateById(order);
        return "forward:/orderList";
    }

}
