package com.baizhi.service.impl;

import com.baizhi.dao.AddressDao;
import com.baizhi.entity.Address;
import com.baizhi.entity.User;
import com.baizhi.service.AddressService;
import com.baizhi.util.MybatisUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 19:59 2017/10/17
 * @Descripon :
 */
public class AddressServiceImpl implements AddressService {
    @Override
    public String insertAddress(Address address, User user) {
        SqlSession session = null;
        ValueStack vs = ActionContext.getContext().getValueStack();
        try {
                session = MybatisUtil.openSession();
                User userFromSession = (User)vs.findValue("#session.user");
                user.setUser_id(userFromSession.getUser_id());
                address.setUser(userFromSession);
                AddressDao addressDao = (AddressDao) MybatisUtil.getDao(AddressDao.class);
                address.getUser().setUser_id(user.getUser_id());
                addressDao.isertAddress(address);
               session.commit();
                return "success";
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            throw new RuntimeException("未知原因，地址插入失败！");

        } finally {


        }
    }
    @Override
    public void updateAddress(Address address) {
        SqlSession session = null;
        try {
            session = MybatisUtil.openSession();
            AddressDao addressDao = (AddressDao) MybatisUtil.getDao(AddressDao.class);
            addressDao.updateAddress(address);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            new RuntimeException("未知原因，地址更新失败！");

        } finally {

        }
    }
    @Override
    public Address selectAddressByAddressId(Integer id) {
        SqlSession session = null;
        Address addressList;
        try {
            session = MybatisUtil.openSession();
            AddressDao addressDao = (AddressDao) MybatisUtil.getDao(AddressDao.class);
            addressList = addressDao.selectAddressByAddressId(id);
            session.commit();
            return addressList;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            throw new RuntimeException("未知原因，地址插入失败！");
        } finally {
            MybatisUtil.close();
        }
    }

    @Override
    public List<Address> selectAddressByUserId(Integer id) {
        SqlSession session = null;
        List<Address> addressList;
        try {
            session = MybatisUtil.openSession();
            AddressDao addressDao = (AddressDao) MybatisUtil.getDao(AddressDao.class);
            addressList = addressDao.selectAddressByUserId(id);
            session.commit();
            return addressList;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            throw new RuntimeException("未知原因，地址插入失败！");
        } finally {
            MybatisUtil.close();
        }
    }
}
