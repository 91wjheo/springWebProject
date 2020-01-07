package org.wesley.domain;

public class PagingCriteria {
	
	// 페이지번호
	int page;
	// 한 페이지당 보여줄 게시글 수
	int perPageNum;
	
	// pagination관련
	// prev
	// next
	// 시작 페이지번호
	// 끝 페이지번호
	
	// 생성자
	public PagingCriteria() {
		this.page = 1;
		this.perPageNum = 10;
		
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}


	@Override
	public String toString() {
		return "PagingCriteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
	
	
	
	
}
