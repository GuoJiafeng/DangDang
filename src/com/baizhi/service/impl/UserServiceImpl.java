package com.baizhi.service.impl;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.Md5Util;
import com.baizhi.util.MybatisUtil;
import com.baizhi.util.RandomCodeUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 13:27 2017/10/17
 * @Descripon :
 */
public class UserServiceImpl implements UserService {

    @Override
    public String userRegister(User user, String code) {
        SqlSession session = null;
        ValueStack vs = ActionContext.getContext().getValueStack();
        String sessionCode = vs.findString("#session.code");
        //如果判断成功，则进行下一步
        if (sessionCode.equals(code)) {
            try {
                session = MybatisUtil.openSession();
                UserDao userDao = (UserDao) MybatisUtil.getDao(UserDao.class);
                User user1 = userDao.selectUserByUserName(user.getUser_email());
                if (user1 == null) {
                    user.setUser_status(false);
                    user.setUser_salt(RandomCodeUtil.getCode(10));
                    user.setUser_password(Md5Util.encryption(user.getUser_password() + user.getUser_salt()));
                    userDao.insertUser(user);
                    vs.setValue("#session.mailCode", RandomCodeUtil.getCode(30));
                    vs.setValue("#session.email", user.getUser_email());
                    session.commit();
                    return "success";
                } else {
                    if (user1.getUser_status()) {
                        throw new RuntimeException("邮箱已经被注册，且处于激活状态，请直接登录！");
                    } else {
                        user.setUser_status(false);
                        user.setUser_salt(RandomCodeUtil.getCode(10));
                        user.setUser_password(Md5Util.encryption(user.getUser_password() + user.getUser_salt()));
                        userDao.updateUser(user);
                        session.commit();
                        vs.setValue("#session.mailCode", RandomCodeUtil.getCode(30));
                        vs.setValue("#session.email", user.getUser_email());
                        return "repeat";
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                session.rollback();
                throw new RuntimeException("注册失败");
            } finally {
                MybatisUtil.close();
            }
        } else {
            throw new RuntimeException("验证码错误！");
        }

    }

    @Override
    public String mailCheck(String emil, String code) {
        SqlSession session = null;
        ValueStack vs = ActionContext.getContext().getValueStack();
        String mailCode = (String) vs.findValue("#session.mailCode");
        User user = new User();
        user.setUser_email(emil);
        if (mailCode.equals(code)) {
            try {
                session = MybatisUtil.openSession();
                UserDao userDao = (UserDao) MybatisUtil.getDao(UserDao.class);
                user.setUser_status(true);
                userDao.updateUser(user);
                User newUser = userDao.selectUserByUserName(emil);
                session.commit();
                vs.setValue("#session.user", newUser);
                if (vs.findValue("#session.isCart") == null) {
                    return "success";
                } else {
                    return "isCart";
                }
            } catch (Exception e) {
                e.printStackTrace();
                session.rollback();
                throw new RuntimeException("验证失败，请稍后重试！");
            } finally {
                MybatisUtil.close();
            }
        } else {
            throw new RuntimeException("验证码错误！");
        }
    }

    @Override
    public String userLogin(User user) {
        SqlSession session = null;
        ValueStack vs = ActionContext.getContext().getValueStack();
        try {
            session = MybatisUtil.openSession();
            UserDao userDao = (UserDao) MybatisUtil.getDao(UserDao.class);
            User userFromDB = userDao.selectUserByUserName(user.getUser_email());
            if (userFromDB != null) {
                String salt = userFromDB.getUser_salt();
                String passswordSalt = user.getUser_password() + salt;

                Boolean b = Md5Util.checkPassword(passswordSalt, userFromDB.getUser_password());
                session.commit();
                if (b) {
                    if (userFromDB.getUser_status()) {

                        vs.setValue("#session.user", userFromDB);
                        if (vs.findValue("#session.isCart") == null) {
                            return "success";
                        } else {
                            return "isCart";
                        }
                    } else {
                        vs.setValue("#session.mailCode", RandomCodeUtil.getCode(30));
                        vs.setValue("#session.email", userFromDB.getUser_email());
                        return "unactivated";

                    }
                } else {
                    throw new RuntimeException("用户名或者密码错误！");
                }
            } else {
                throw new RuntimeException("用户不存在！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            throw new RuntimeException(e.getMessage());
        } finally {
            MybatisUtil.close();
        }
    }

    @Override
    public String logout() {
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.setValue("#session.user", null);
        return "success";
    }

}
