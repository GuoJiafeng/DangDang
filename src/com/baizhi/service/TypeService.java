package com.baizhi.service;

import com.baizhi.entity.TypeFather;
import com.baizhi.entity.TypeSon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public interface TypeService {
    //显示图书分类
    List<TypeFather> showBookType();


    //显示一级分类
    TypeFather showFatherTypeById(Integer id);

    //显示二级分类
    TypeFather showSonTypeById(@Param("fid") Integer fid, @Param("sid") Integer sid);

    //显示图数列表左侧导航栏

    TypeFather showFatherTypeAndSonType(Integer id);

}
