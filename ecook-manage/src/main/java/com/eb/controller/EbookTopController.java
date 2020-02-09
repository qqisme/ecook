package com.eb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eb.pojo.EbookTop;
import com.eb.service.EbookTopService;
import com.github.pagehelper.PageInfo;

@Controller
public class EbookTopController {

	@Autowired
	private EbookTopService ets;
	
	@RequestMapping("/doIndexTop")
	public String goTop(Model model,Integer pageNum) {
		PageInfo<EbookTop> info = ets.getPageInfo(pageNum);
		System.out.println(info);
		model.addAttribute("pageInfo", info);
		return "ebookTop";
	}
	
	@RequestMapping("/doInsertTop")
	@ResponseBody
	public String info() {
		ets.saveTop();
		return "Insert topInfo Complete!";
	}
}
