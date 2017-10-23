package com.baizhi.dao;

import com.baizhi.entity.Goods;
import com.baizhi.entity.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public interface GoodsDao {
    //显示编辑推荐
    List<Goods> showEditorialRecommendation();

    //显示热销图书

    List<Goods> showHotBooks();


    //最新上架图书
    List<Goods> showNewBooks();


    //新书热卖榜

    List<Goods> showNewHotBooks();



    //根据father typeid 查询图书

    List<Goods> showBooksByFatherId(@Param("fid") Integer fid, @Param("pb") PageBean pb);

    //根据son typeid 查询图书

    List<Goods> showBooksBySonId(@Param("sid") Integer sid,@Param("pb") PageBean pb);

    Integer getFatherTotalCount(Integer id);
    Integer getSonTotalCount(Integer id);



    Goods shwoBookDetailById(Integer id);


}
