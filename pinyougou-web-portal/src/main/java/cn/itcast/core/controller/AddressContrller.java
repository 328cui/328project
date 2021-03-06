package cn.itcast.core.controller;

import cn.itcast.core.pojo.address.Address;
import cn.itcast.core.service.AddressService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 收货地址
 */
@RestController
@RequestMapping("/address")
public class AddressContrller {


    @Reference
    private AddressService addressService;

    //根据当前登陆人查询所有收货地址
    @RequestMapping("/findListByLoginUser")
    public List<Address> findListByLoginUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return addressService.findListByLoginUser(name);
    }
}
