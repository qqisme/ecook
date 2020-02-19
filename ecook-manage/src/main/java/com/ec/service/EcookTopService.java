package com.ec.service;
import com.ec.pojo.EcookTop;
import com.github.pagehelper.PageInfo;

public interface EcookTopService {

	PageInfo<EcookTop> getPageInfo(Integer pageNum);
	
	String saveTop();
}
