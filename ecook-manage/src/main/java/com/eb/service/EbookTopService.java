package com.eb.service;
import com.eb.pojo.EbookTop;
import com.github.pagehelper.PageInfo;

public interface EbookTopService {

	PageInfo<EbookTop> getPageInfo(Integer pageNum);
	
	String saveTop();
}
