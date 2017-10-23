package com.baizhi.service;

import com.baizhi.entity.Goods;
import com.baizhi.entity.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public interface GoodsService {
    //显示编辑推荐
    List<Goods> showEditorialRecommendation();

    //显示热销图书

    List<Goods> showHotBooks();


    //最新上架图书
    List<Goods> showNewBooks();


    //新书热卖榜

    List<Goods> showNewHotBooks();


    //根据father typeid 查询图书

    List<Goods> showBooksByFatherId(Integer fid, PageBean pageBean);

    //根据son typeid 查询图书

    List<Goods> showBooksBySonId(Integer sid,PageBean pageBean);

    //展示图书详情
    Goods shwoBookDetailById(Integer id);
}
