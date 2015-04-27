package com.cn.demo.model;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User>{
	public static final User dao=new User();
	
	public static String ACCOUNT="user_account";
}
