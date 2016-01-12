package com.example.day07_02_json;

import java.util.List;

class Paramz {
	private List<Feed> Feeds;
	private int pageIndex;
	private int pageSize;
	private int totalCount;
	private int totalPage;
	public List<Feed> getFeeds() {
		return Feeds;
	}
	public void setFeeds(List<Feed> feeds) {
		Feeds = feeds;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	
//	 "feeds": [], 
//     "PageIndex": 1, 
//     "PageSize": 10, 
//     "TotalCount": 53521, 
//     "TotalPage": 5353
}
