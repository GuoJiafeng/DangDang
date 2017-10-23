package com.baizhi.action;

import com.baizhi.entity.Goods;
import com.baizhi.entity.PageBean;
import com.baizhi.entity.TypeFather;
import com.baizhi.entity.TypeSon;
import com.baizhi.service.GoodsService;
import com.baizhi.service.TypeService;
import com.baizhi.service.impl.GoodsServiceImpl;
import com.baizhi.service.impl.TypeServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import java.util.List;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public class TypeAction extends ActionSupport {

    private Integer fid;
    private Integer sid;
    private Goods goods;
    private TypeFather typeFather;
    private List<TypeFather> typeSonList;
    private PageBean pageBean;
    private Integer pageNum;

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

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public TypeFather getTypeFather() {
        return typeFather;
    }

    public void setTypeFather(TypeFather typeFather) {
        this.typeFather = typeFather;
    }

    public List<TypeFather> getTypeSonList() {
        return typeSonList;
    }

    public void setTypeSonList(List<TypeFather> typeSonList) {
        this.typeSonList = typeSonList;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public Integer getPageNum() {
        if (pageNum==null){
            pageNum = 1;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String showBookTypeAction() {
        TypeService typeService = new TypeServiceImpl();
        typeSonList = typeService.showBookType();

        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.setValue("#request.list", typeSonList);

        System.out.println(typeSonList);
        return null;
    }

    public String showFatherTypeById() {
        TypeService service = new TypeServiceImpl();
        typeFather = service.showFatherTypeById(fid);
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.setValue("#request.typeFatherById", typeFather);
        System.out.println(typeFather);
        return "success";

    }

    public String showSonTypeById() {
        TypeService service = new TypeServiceImpl();
        typeFather = service.showSonTypeById(fid, sid);
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.setValue("#request.typeSonById", typeFather);
        System.out.println(typeFather);
        return "success";

    }

    public String showFatherTypeAndSonType() {
        TypeService service = new TypeServiceImpl();
        typeFather = service.showFatherTypeAndSonType(fid);
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.setValue("#request.typeSonAndFather", typeFather);
        System.out.println(typeFather);
        return null;
    }


    public String showBookListAction() {
        TypeService typeService = new TypeServiceImpl();
        GoodsService goodsService = new GoodsServiceImpl();

        if (fid != null && sid == null) {
            typeFather = typeService.showFatherTypeById(fid);
            ValueStack vs = ActionContext.getContext().getValueStack();
            vs.setValue("#request.typeFatherById", typeFather);

            PageBean pb = new PageBean(getPageNum(),5,0);
            List<Goods> list = goodsService.showBooksByFatherId(fid,pb);

            vs.setValue("#request.showBookList", list);
            vs.setValue("#request.pb", pb);
            System.out.println(typeFather);
            System.out.println(list);
        }
        if (fid != null && sid != null) {
            typeFather = typeService.showSonTypeById(fid, sid);
            ValueStack vs = ActionContext.getContext().getValueStack();
            vs.setValue("#request.typeSonById", typeFather);
            PageBean pb = new PageBean(getPageNum(),5,0);
            List<Goods> list = goodsService.showBooksBySonId(sid, pb);

            vs.setValue("#request.pb", pb);


            System.out.println(list);
            vs.setValue("#request.showBookList", list);

            System.out.println(typeFather);
        }
        typeFather = typeService.showFatherTypeAndSonType(fid);
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.setValue("#request.typeSonAndFather", typeFather);
        System.out.println(typeFather);


        return "success";
    }


}
