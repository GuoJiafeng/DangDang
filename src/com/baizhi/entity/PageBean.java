package com.baizhi.entity;

import java.io.Serializable;

public class PageBean implements Serializable{

    //页码数
    private int pageNum;
    //每页显示行数
    private int pageCount = 3;
    //总行数
    private int totalCount;
    private int begin;
    private int end;

    public int getBegin() {
        begin = this.getPageCount() * (this.getPageNum() - 1) + 1;
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        end = this.getPageNum() * this.getPageCount();
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public PageBean(int pageNum, int pageCount, int totalCount) {
        super();
        this.pageNum = pageNum;
        this.pageCount = pageCount;
        this.totalCount = totalCount;
    }

    public PageBean() {
        super();
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        if (totalCount % pageCount == 0) return totalCount / pageCount;
        else return totalCount / pageCount + 1;
    }

    @Override
    public String toString() {
        return "PageBean [pageNum=" + pageNum + ", pageCount=" + pageCount + ", totalCount=" + totalCount + ", begin="
                + begin + ", end=" + end + "]";
    }


}
