package com.baizhi.action;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.UserServiceImpl;
import com.baizhi.util.CreateValidateCode;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 12:49 2017/10/17
 * @Descripon :
 */
public class UserAction extends ActionSupport {
    private User user;
    private String code;
    private String mailCode;

    public String getMailCode() {
        return mailCode;
    }

    public void setMailCode(String mailCode) {
        this.mailCode = mailCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String registerUserAction() {
        UserService userService = new UserServiceImpl();
        String s = userService.userRegister(user, code);
        if (s.equals("success")) {
            return "success";
        }
        if (s.equals("repeat")) {

            return "repeat";
        }
        return null;
    }

    public String showCodeAction() throws Exception {

        //1.获得随机数
        CreateValidateCode cvc = new CreateValidateCode();
        String imageCode = cvc.getCode();

        //2.将code随机数存入session作用域
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.setValue("#session.code", imageCode);

        //3.将随机数以图片形式输出到浏览器，使用工具类的write方法
        HttpServletResponse response = ServletActionContext.getResponse();
        cvc.write(response.getOutputStream());

        return null;
    }

    public String checkMailAction() {
        UserService userService = new UserServiceImpl();
        String s = userService.mailCheck(user.getUser_email(), mailCode);
        if (s.equals("success")) {
            return "success";
        }
        if (s.equals("isCart")){
            return "isCart";
        }
        return null;
    }

    public String loginUserAction() {
        UserService userService = new UserServiceImpl();
        String s = userService.userLogin(user);
        if (s.equals("success")) {
            return "success";
        }
        if (s.equals("isCart")){
            return "isCart";
        }

        if (s.equals("unactivated")) {
            return "unactivated";
        }else {
            return null;
        }
    }

    public String logoutUserAction() {
        UserService userService = new UserServiceImpl();
        String s = userService.logout();
       return "success";

    }

}
