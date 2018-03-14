package com.boe.tww.base;

import java.io.Serializable;

/**
 * @author 唐万万
 * @create 2018-03-14 14:04
 */
public class BaseEntity implements Serializable {
    /**
     * 分页页码，默认为1
     */
    protected int page = 1;

    /**
     * 分页每页数量，默认20
     */
    protected int size = 20;

    /**
     * 排序列名称，默认为id
     */
    protected String sidx = "id";

    /**
     * <p>
     * 排序正序
     * <p>
     */
    protected String sord = "asc";

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }
}
