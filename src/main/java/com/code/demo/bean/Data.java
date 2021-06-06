/**
  * Copyright 2021 bejson.com 
  */
package com.code.demo.bean;
import java.util.List;

/**
 * Auto-generated: 2021-05-30 1:13:39
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Data {

    private String total;
    private List<com.code.demo.bean.List> list;
    private int pageNum;
    private int pageSize;
    private int size;
    private int startRow;
    private int endRow;
    private int pages;
    private int prePage;
    private int nextPage;
    private boolean isFirstPage;
    private boolean isLastPage;
    private boolean hasPreviousPage;
    private boolean hasNextPage;
    private int navigatePages;
    private int navigateFirstPage;
    private int navigateLastPage;
    public void setTotal(String total) {
         this.total = total;
     }
     public String getTotal() {
         return total;
     }

    public void setList(List<com.code.demo.bean.List> list) {
         this.list = list;
     }
     public List<com.code.demo.bean.List> getList() {
         return list;
     }

    public void setPageNum(int pageNum) {
         this.pageNum = pageNum;
     }
     public int getPageNum() {
         return pageNum;
     }

    public void setPageSize(int pageSize) {
         this.pageSize = pageSize;
     }
     public int getPageSize() {
         return pageSize;
     }

    public void setSize(int size) {
         this.size = size;
     }
     public int getSize() {
         return size;
     }

    public void setStartRow(int startRow) {
         this.startRow = startRow;
     }
     public int getStartRow() {
         return startRow;
     }

    public void setEndRow(int endRow) {
         this.endRow = endRow;
     }
     public int getEndRow() {
         return endRow;
     }

    public void setPages(int pages) {
         this.pages = pages;
     }
     public int getPages() {
         return pages;
     }

    public void setPrePage(int prePage) {
         this.prePage = prePage;
     }
     public int getPrePage() {
         return prePage;
     }

    public void setNextPage(int nextPage) {
         this.nextPage = nextPage;
     }
     public int getNextPage() {
         return nextPage;
     }

    public void setIsFirstPage(boolean isFirstPage) {
         this.isFirstPage = isFirstPage;
     }
     public boolean getIsFirstPage() {
         return isFirstPage;
     }

    public void setIsLastPage(boolean isLastPage) {
         this.isLastPage = isLastPage;
     }
     public boolean getIsLastPage() {
         return isLastPage;
     }

    public void setHasPreviousPage(boolean hasPreviousPage) {
         this.hasPreviousPage = hasPreviousPage;
     }
     public boolean getHasPreviousPage() {
         return hasPreviousPage;
     }

    public void setHasNextPage(boolean hasNextPage) {
         this.hasNextPage = hasNextPage;
     }
     public boolean getHasNextPage() {
         return hasNextPage;
     }

    public void setNavigatePages(int navigatePages) {
         this.navigatePages = navigatePages;
     }
     public int getNavigatePages() {
         return navigatePages;
     }

    public void setNavigateFirstPage(int navigateFirstPage) {
         this.navigateFirstPage = navigateFirstPage;
     }
     public int getNavigateFirstPage() {
         return navigateFirstPage;
     }

    public void setNavigateLastPage(int navigateLastPage) {
         this.navigateLastPage = navigateLastPage;
     }
     public int getNavigateLastPage() {
         return navigateLastPage;
     }
	@Override
	public String toString() {
		return "Data [total=" + total + ", list=" + list + ", pageNum=" + pageNum + ", pageSize=" + pageSize + ", size="
				+ size + "]";
	}

     
     
}