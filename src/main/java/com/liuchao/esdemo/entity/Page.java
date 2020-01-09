package com.liuchao.esdemo.entity;

public class Page {
    //一页显示多少条
    private int pageSize;
    //当前页
    private int pageNum;
    //总共多少条
    private int total;
    //总共多少页
    private int pageTotal;

    public Page(int pageSize,int pageNum,int total){
        this.pageNum=pageNum;
        this.pageSize=pageSize;
        this.total=total;
        this.pageTotal=total%pageSize==0?total/pageSize:(total/pageSize)+1;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public static void main(String[] args) {
       Page page=new Page(3,1,9);
        System.out.println(page.pageTotal);
    }
}
