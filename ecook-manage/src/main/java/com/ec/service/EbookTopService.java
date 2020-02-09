package com.ec.service;
import com.ec.pojo.EbookTop;
import com.github.pagehelper.PageInfo;

public interface EbookTopService {

	PageInfo<EbookTop> getPageInfo(Integer pageNum);
	
	String saveTop();
}
