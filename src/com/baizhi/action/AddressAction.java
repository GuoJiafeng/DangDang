package com.baizhi.action;

import com.baizhi.entity.Address;
import com.baizhi.entity.User;
import com.baizhi.service.AddressService;
import com.baizhi.service.impl.AddressServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import java.util.List;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 20:57 2017/10/17
 * @Descripon :
 */
public class AddressAction extends ActionSupport {
    private Address address;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String addAddress() {
        AddressService addressService = new AddressServiceImpl();
        addressService.insertAddress(address, user);
        return "success";
    }


    public String selectAddressByAddressId() {
        AddressService addressService = new AddressServiceImpl();
        ValueStack vs = ActionContext.getContext().getValueStack();
        Address addressfromDB = addressService.selectAddressByAddressId(address.getAddress_id());
        vs.setValue("#session.address", addressfromDB);
        return "success";
    }

    public String selectAddressByUserId() {
        AddressService addressService = new AddressServiceImpl();
        ValueStack vs = ActionContext.getContext().getValueStack();
        User user1 = (User) vs.findValue("#session.user");
        List<Address> list = addressService.selectAddressByUserId(user1.getUser_id());
        vs.setValue("#session.addresslist", list);
        return null;
    }

    public String updateAddress() {
        AddressService addressService = new AddressServiceImpl();
        addressService.updateAddress(address);
        return "success";
    }

    public String nextAction() {
        ValueStack vs = ActionContext.getContext().getValueStack();
        if (vs.findValue("#session.user") != null) {

            return "success";
        } else {
            vs.setValue("#session.isCart", "ok");
            return "unlogin";
        }
    }

    public String addNewAddress() {
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.setValue("#session.address",null);
        return "success";
    }
}
