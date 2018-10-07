package com.aoeai.common.utils;


import com.aoeai.common.exception.PageException;

/**
 *
 * 分页对象
 */
public class Page {

    /**
     * 每页显示的记录数
     */
    private long pageSize;

    /**
     * 总记录数
     */
    private long totalCount;

    /**
     * 总页数
     */
    private long totalPages;

    /**
     * 当前页
     */
    private long pageNum = 1;

    /**
     * Mysql limit 第一个参数
     */
    private long offset;

    public Page(long pageSize, long totalCount){
        if (pageSize < 1){
            throw new PageException(String.format("pageSize = %s 每页显示的记录数不能小于1", pageSize));
        }
        if(totalCount < 0){
            throw new PageException(String.format("totalCount = %s 总记录数不能小于0", totalCount));
        }

        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public long getTotalPages() {
        // 其中 pageSize  - 1 就是 totalCount / pageSize的最大的余数
        totalPages = (totalCount + pageSize -1) / pageSize;
        return totalPages;
    }

    public long getOffset() {
        offset = (pageNum - 1) * pageSize;
        return offset;
    }

    public Page setPageNum(long pageNum) {
        if(pageNum < 1){
            throw new PageException(String.format("pageNum = %s 当前页不能小于1", pageNum));
        }
        if(pageNum > getTotalPages()){
            throw new PageException(String.format("pageNum = %s 当前页不能大于总页数", pageNum));
        }
        this.pageNum = pageNum;

        return this;
    }

    public long getPageNum() {
        return pageNum;
    }


}
