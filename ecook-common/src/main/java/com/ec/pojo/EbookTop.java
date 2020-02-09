package com.ec.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 头条新闻 pojo 对象
 * @author WEI
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("ebook_top")
public class EbookTop extends EbookPojo implements Serializable{
	private static final long serialVersionUID = 6088989235809503728L;

	@TableId(type = IdType.AUTO)	//设置主键,自增
	private Integer id;
	
	private String title;			//头条标题
	
	private String synopsis;		//简介
	
	private String author;			//作者
	
	@TableField("img_url")
	private String imgUrl;			//图片url
	
	private Integer pageviews;		//浏览量
	
	@TableField("praise_points")
	private Integer praisePoints;	//点赞数

}
