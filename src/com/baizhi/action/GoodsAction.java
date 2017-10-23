package com.baizhi.action;

import com.baizhi.entity.Goods;
import com.baizhi.entity.PageBean;
import com.baizhi.service.GoodsService;
import com.baizhi.service.impl.GoodsServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import java.util.List;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public class GoodsAction extends ActionSupport {
    private List<Goods> goodsList;
    private Integer fid;
    private Integer sid;
    private Integer bookid;

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String showEditorialRecommendationAction() {
        GoodsService goodsService = new GoodsServiceImpl();
        goodsList = goodsService.showEditorialRecommendation();
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.setValue("#request.showEditorialRecommendation", goodsList);
        System.out.println(goodsList);
        return null;
    }

    public String showHotBooksAction() {
        GoodsService goodsService = new GoodsServiceImpl();
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.setValue("#request.showHotBooks", goodsService.showHotBooks());
        System.out.println(goodsService.showHotBooks());
        return null;
    }

    public String showNewBooksAction() {
        GoodsService goodsService = new GoodsServiceImpl();
        goodsList = goodsService.showNewBooks();
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.setValue("#request.showNewBooks", goodsList);
        return null;
    }

    public String showNewHotBooksAction() {
        GoodsService goodsService = new GoodsServiceImpl();
        goodsList = goodsService.showNewHotBooks();
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.setValue("#request.showNewHotBooks", goodsList);
        return null;
    }

    public String showBookDetailAction() {
        GoodsService goodsService = new GoodsServiceImpl();
        Goods goods = goodsService.shwoBookDetailById(bookid);
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.setValue("#request.showBookDetail", goods);
        return "success";
    }


}
