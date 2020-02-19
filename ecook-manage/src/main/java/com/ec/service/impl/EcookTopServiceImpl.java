package com.ec.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ec.mapper.EcookTopMapper;
import com.ec.pojo.EcookTop;
import com.ec.service.EcookTopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EcookTopServiceImpl implements EcookTopService {

	@Autowired
	private EcookTopMapper etm;

	@Override
	public String saveTop() {
		List<String> titleList = new ArrayList<>();		//新闻标题
		List<String> jjlist = new ArrayList<>();		//新闻简介
		List<String> authorList = new ArrayList<>();	//作者
		List<String> imgUrlList = new ArrayList<>();	//图片路径
		List<Integer> viewList = new ArrayList<>();		//浏览数
		List<Integer> pointList = new ArrayList<>();	//点赞数
		
		int cnt = 0;
		int index = 0;
		String url;
		Document doc;
		EcookTop entity = new EcookTop();
		long start = System.currentTimeMillis();
		for (int i = 1; i < 53; i++) {
			try {
				url = "https://www.ecook.cn/toutiao/?page="+i;
				doc = Jsoup.connect(url).get();
				Elements titleSelect = doc.select("h3.article_name a[target='_blank']");
				Elements jjSelect = doc.select("div.article_description p.article_profile");
				Elements authorSelect = doc.select("div.article_description p.article_record a[rel='nofollow']");
				Elements imgUrlSelect = doc.select("div.article_ul img");
				Elements mathSelect = doc.select("div.article_description p.article_record  span");
				
				for (Element e : titleSelect) {	//标题
					String title = e.text();
					titleList.add(title);
				}
				
				for (Element e : authorSelect) {	//作者
					String author = e.text();
					authorList.add(author);
				}
				
				
				for (Element e : jjSelect) {	//简介
					String jianjie = e.text();
					jjlist.add(jianjie);
				}
				
				for (Element e : imgUrlSelect) {	//图片url
					String imgUrl = e.attr("src");
					if(cnt == 151)
						imgUrlList.add("https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1009600391,1287960116&fm=26&gp=0.jpg");
					else {
						if(imgUrl.indexOf("!") != -1)
							imgUrl = imgUrl.substring(0, imgUrl.indexOf("!"));
						
						imgUrlList.add(imgUrl);
					}
					cnt++;
				}
				
				for (Element e : mathSelect) {
					int text = Integer.parseInt(e.text());
					if(index % 2 == 1)
						pointList.add(text);
					else
						viewList.add(text);
					index++;
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 0;i < titleList.size();i++) {
			entity.setTitle(titleList.get(i));
			entity.setAuthor(authorList.get(i));
			entity.setImgUrl(imgUrlList.get(i));
			entity.setSynopsis(jjlist.get(i));
			entity.setPageviews(viewList.get(i));
			entity.setPraisePoints(pointList.get(i));
			entity.setCreatedTime(new Date());
			entity.setUpdatedTime(new Date());
			etm.insert(entity);
		}
		
		long end = System.currentTimeMillis();
		
		log.info("所用时 => {}",end - start);
		return "insert ok";
	}

	@Override
	public PageInfo<EcookTop> getPageInfo(Integer pageNum) {
		pageNum = (pageNum == null || pageNum < 1) ? 1 : pageNum;

		QueryWrapper<EcookTop> qw = new QueryWrapper<EcookTop>();
		
		qw.orderByDesc("updated_time");
		
		PageHelper.startPage(pageNum, 20);

		List<EcookTop> list = etm.selectList(qw);
		
		return new PageInfo<EcookTop>(list);
	}

}
