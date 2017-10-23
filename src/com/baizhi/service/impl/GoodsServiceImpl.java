package com.baizhi.service.impl;

import com.baizhi.dao.GoodsDao;
import com.baizhi.entity.Goods;
import com.baizhi.entity.PageBean;
import com.baizhi.service.GoodsService;
import com.baizhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public class GoodsServiceImpl implements GoodsService {
    @Override
    public List<Goods> showEditorialRecommendation() {
        SqlSession session = null;
        List<Goods> list = null;
        try {
            session = MybatisUtil.openSession();
            GoodsDao goodsDao = (GoodsDao) MybatisUtil.getDao(GoodsDao.class);
            list = goodsDao.showEditorialRecommendation();
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
    public List<Goods> showHotBooks() {

        SqlSession session = null;
        List<Goods> list = null;
        try {
            session = MybatisUtil.openSession();
            GoodsDao goodsDao = (GoodsDao) MybatisUtil.getDao(GoodsDao.class);
            list = goodsDao.showHotBooks();
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
    public List<Goods> showNewBooks() {
        SqlSession session = null;
        List<Goods> list = null;
        try {
            session = MybatisUtil.openSession();
            GoodsDao goodsDao = (GoodsDao) MybatisUtil.getDao(GoodsDao.class);
            list = goodsDao.showNewBooks();
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
    public List<Goods> showNewHotBooks() {
        SqlSession session = null;
        List<Goods> list = null;
        try {
            session = MybatisUtil.openSession();
            GoodsDao goodsDao = (GoodsDao) MybatisUtil.getDao(GoodsDao.class);
            list = goodsDao.showNewHotBooks();
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
    public List<Goods> showBooksByFatherId(Integer fid,PageBean pageBean) {
        SqlSession session = null;
        List<Goods> list = null;
        try {
            session = MybatisUtil.openSession();
            GoodsDao goodsDao = (GoodsDao) MybatisUtil.getDao(GoodsDao.class);
            pageBean.setTotalCount(goodsDao.getFatherTotalCount(fid));
            list = goodsDao.showBooksByFatherId(fid,pageBean);
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
    public List<Goods> showBooksBySonId(Integer sid,PageBean pageBean) {
        SqlSession session = null;
        List<Goods> list = null;
        try {
            session = MybatisUtil.openSession();
            GoodsDao goodsDao = (GoodsDao) MybatisUtil.getDao(GoodsDao.class);
            pageBean.setTotalCount(goodsDao.getSonTotalCount(sid));
            list = goodsDao.showBooksBySonId(sid,pageBean);
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
    public Goods shwoBookDetailById(Integer id) {

        SqlSession session = null;
        Goods goods = null;
        try {
            session = MybatisUtil.openSession();
            GoodsDao goodsDao = (GoodsDao) MybatisUtil.getDao(GoodsDao.class);
            goods = goodsDao.shwoBookDetailById(id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            MybatisUtil.close();
        }
        return goods;
    }
}
