package com.woojin.app.home.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pager {
	
	public String getSearch() {
		if (this.search==null) {
			this.search="";
		}
		return search;
	}
	private String search;
	private String kind;
	private Long startNum;
	private Long perPage=10L;
	private Long page;
	private Long start;
	private Long end;
	private boolean endCheck;
	
	

	public Long getStartNum() {
		if (this.startNum==null || this.startNum<0) {
			this.startNum=0L;
		}
		return this.startNum;
	}
	public Long getPage() {
		if (this.page==null || this.page<1) {
			this.page=1L;
		}
		return this.page;
	}
	
	public void makeNum() throws Exception{
		this.startNum=(this.getPage()-1)*this.perPage;
	}
	
	public void make(Long totalCount) throws Exception{
		
		if (totalCount < 1) {
			totalCount = 1L;
		}
		Long totalPage = totalCount/this.perPage;
		if (totalPage % this.perPage != 0) {
			totalPage++;
		}
		
		Long totalBlock = totalPage/5;
		if (totalPage % 5 != 0) {
			totalBlock++;
		}
		
		Long curBlock = this.getPage()/5;
		if (this.getPage() % 5 != 0) {
			curBlock++;
		}
		
		this.setStart((curBlock-1)*5+1);
		this.setEnd(curBlock*5);
		
		if (totalBlock==curBlock) {
			this.setEnd(totalPage);
			this.setEndCheck(true);
		}
		
	}
	public String getKind() {
		if (this.kind==null) {
			this.kind="k1";
		}
		return kind;
	}

}