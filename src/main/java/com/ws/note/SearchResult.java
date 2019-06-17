package com.ws.note;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {
	public List<String> list;
	public int  total;
	public int  pages;  
	public int pageNum;
	public int pageSize;
	public int size;
	public boolean isFirstPage;
	public boolean isLastPage;
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public boolean isFirstPage() {
		return isFirstPage;
	}
	public void setIsFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}
	public boolean isLastPage() {
		return isLastPage;
	}
	public void setIsLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
	
	
	/**
	 * list 分页
	 * @param list
	 * @param pagesize
	 * @return
	 */
	public static  SearchResult paging(List<String> list, int pageNumber, int pageSize) throws Exception{
	    List<String>pageList = new ArrayList<String>();
	    int currIdx = (pageNumber > 1 ? (pageNumber -1) * pageSize : 0);
	    for (int i = 0; i < pageSize && i < list.size() - currIdx; i++){
	    	String listNew = list.get(currIdx + i);
	        pageList.add(listNew);
	    }
	    SearchResult searchResult = new SearchResult();
	    searchResult.setList(pageList);
	    searchResult.setTotal(list.size());
	    if (searchResult.getTotal()%pageSize == 0){
	        searchResult.setPages((int)searchResult.getTotal()/pageSize);
	    }else {
	        searchResult.setPages((int)searchResult.getTotal()/pageSize + 1);
	    }
	    searchResult.setPageNum(pageNumber);
	    searchResult.setPageSize(pageSize);
	    searchResult.setSize(pageList.size());
	    //是否是第一页
	    if (pageNumber == 1){
	        searchResult.setIsFirstPage(true);
	    }else {
	        searchResult.setIsFirstPage(false);
	    }
	    //是否是最后一页
	    if ((searchResult.getTotal() - pageNumber*pageSize) > 0){
	        searchResult.setIsLastPage(false);
	    }else {
	        searchResult.setIsLastPage(true);
	    }
	    return searchResult;
	}
	
}
