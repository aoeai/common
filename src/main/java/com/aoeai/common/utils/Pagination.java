package com.aoeai.common.utils;

import java.util.List;

/**
 * 分页对象
 */
public class Pagination<T> {

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
     * 分页数据
     */
    private List<T> records;

    public long getPageSize() {
        return pageSize;
    }

    public Pagination<T> setPageSize(long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public Pagination<T> setTotalCount(long totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public Pagination<T> setTotalPages(long totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public long getPageNum() {
        return pageNum;
    }

    public Pagination<T> setPageNum(long pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public List<T> getRecords() {
        return records;
    }

    public Pagination<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }
}
