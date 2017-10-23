package com.baizhi.service.impl;

import com.baizhi.dao.GoodsDao;
import com.baizhi.dao.TypeDao;
import com.baizhi.entity.TypeFather;
import com.baizhi.entity.TypeSon;
import com.baizhi.service.TypeService;
import com.baizhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public class TypeServiceImpl implements TypeService {
    @Override
    public List<TypeFather> showBookType() {
        SqlSession session = null;

        List<TypeFather> list = null;
        try {
            session = MybatisUtil.openSession();
            TypeDao typeDao = (TypeDao) MybatisUtil.getDao(TypeDao.class);
            list = typeDao.showBookType();
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();

        } finally {
            MybatisUtil.close();
        }
        return list;
    }

    @Override
    public TypeFather showFatherTypeById(Integer id) {
        SqlSession session = null;

        TypeFather typeFather = null;
        try {
            session = MybatisUtil.openSession();
            TypeDao typeDao = (TypeDao) MybatisUtil.getDao(TypeDao.class);
            typeFather = typeDao.showFatherTypeById(id);
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();

        } finally {
            MybatisUtil.close();
        }
        return typeFather;
    }

    @Override
    public TypeFather showSonTypeById(Integer fid, Integer sid) {
        SqlSession session = null;

        TypeFather typeFather = null;
        try {
            session = MybatisUtil.openSession();
            TypeDao typeDao = (TypeDao) MybatisUtil.getDao(TypeDao.class);
            typeFather = typeDao.showSonTypeById(fid, sid);

            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();

        } finally {
            MybatisUtil.close();
        }
        return typeFather;
    }

    @Override
    public TypeFather showFatherTypeAndSonType(Integer id) {
        SqlSession session = null;

        TypeFather list = null;
        Integer sum = 0;
        try {
            session = MybatisUtil.openSession();
            TypeDao typeDao = (TypeDao) MybatisUtil.getDao(TypeDao.class);
            list = typeDao.showFatherTypeAndSonType(id);

            for (TypeSon ts1 : list.getTypeSons()) {
                Integer gid = ts1.getType_son_id();
                TypeFather typeFather = typeDao.showSonTypeById(id, gid);
                for (TypeSon ts2 : typeFather.getTypeSons()) {
                    Integer count = ts2.getType_son_count();
                    sum += count;
                }
            }
            list.setType_father_count(sum);


            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();

        } finally {
            MybatisUtil.close();
        }
        return list;
    }
}
