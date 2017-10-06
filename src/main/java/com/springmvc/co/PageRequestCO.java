package com.springmvc.co;

/**
 * @author Jitendra Singh.
 */
public class PageRequestCO {

    private int pageNumber;
    private int pageSize = 10;
    private int offset;

    public int getPageNumber() {
        return pageNumber;
    }

    public PageRequestCO setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageRequestCO setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public PageRequestCO setOffset(int offset) {
        this.offset = offset;
        return this;
    }
}
