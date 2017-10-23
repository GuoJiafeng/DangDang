package com.baizhi.test;


import com.baizhi.entity.Goods;
import com.baizhi.entity.PageBean;
import com.baizhi.entity.TypeFather;
import com.baizhi.entity.User;
import com.baizhi.service.GoodsService;
import com.baizhi.service.OrderService;
import com.baizhi.service.TypeService;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.GoodsServiceImpl;
import com.baizhi.service.impl.OrderServiceImpl;
import com.baizhi.service.impl.TypeServiceImpl;
import com.baizhi.service.impl.UserServiceImpl;
import com.baizhi.util.JavaMailUtil;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import java.util.List;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public class Test01 {
    @Test
    public void showAllType() {
        TypeService typeService = new TypeServiceImpl();
        List<TypeFather> list = typeService.showBookType();
        System.out.println(list);
    }

    @Test
    public void showEditBook() {
        GoodsService service = new GoodsServiceImpl();
        List<Goods> list = service.showEditorialRecommendation();
        System.out.println(list);
    }

    @Test
    public void showHotBook() {
        GoodsService service = new GoodsServiceImpl();
        List<Goods> list = service.showHotBooks();
        System.out.println(list);
    }

    @Test
    public void showNewBook() {
        GoodsService service = new GoodsServiceImpl();
        List<Goods> list = service.showNewBooks();
        System.out.println(list);
    }

    @Test
    public void showHotNewBook() {
        GoodsService service = new GoodsServiceImpl();
        List<Goods> list = service.showNewHotBooks();
        System.out.println(list);
    }

    @Test
    public void showFatherTypeById() {
        TypeService service = new TypeServiceImpl();
        TypeFather father = service.showFatherTypeById(1);
        System.out.println(father);
    }

    @Test
    public void showSonTypeById() {
        TypeService service = new TypeServiceImpl();
        TypeFather father = service.showSonTypeById(1, 2);
        System.out.println(father);
    }

    @Test
    public void showFatherTypeAndSonType() {
        TypeService service = new TypeServiceImpl();
        TypeFather father = service.showFatherTypeAndSonType(7);
        System.out.println(father);
    }
    @Test
    public void showBooksByFatherId() {
        GoodsService service = new GoodsServiceImpl();
        PageBean pageBean = new PageBean(1,5,0);
        List<Goods> father = service.showBooksByFatherId(1,pageBean);
        for (Goods goods:father){
            System.out.println(goods);
        }


    }

    @Test
    public void showBooksBySonId() {
        GoodsService service = new GoodsServiceImpl();
        PageBean pageBean = new PageBean(1,5,0);
        List<Goods> father = service.showBooksBySonId(3,pageBean);
        for (Goods goods : father) {
            System.out.println(goods);
        }

    }

    @Test
    public void iserUser() {
        UserService userService = new UserServiceImpl();
        User user =new User();
        user.setUser_id(1);
        user.setUser_email("12312312");
        userService.userRegister(user,"1231");

    }


    @Test
    public void inserOrder(){
        OrderService orderService = new OrderServiceImpl();
    }


    @Test
    public void senEmail() throws Exception {
        JavaMailUtil.sendEmail("永远爱我的小可爱@yhm","2814221197@qq.com");
    }


}
