package com.ec.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class EcookUser implements Serializable{
	private static final long serialVersionUID = -3357952361266407030L;
	
	private	Integer id;
	private	String username;
	private	String nickname;
	private	Integer phone;
	private	String password;
	private	Integer gender;
	private	String hometown;
	private	String intro;
	private	String head_photo;
	private	Date createtime;
	private	Date updatetime;
	

}
