package com.zjhcsoft.uop.demo.models;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class S_userModel extends Model<S_userModel> {
	public static S_userModel dao = new S_userModel();

	
	public List<S_userModel> findAllUser(){
		String sql = "SELECT * FROM s_user";
		List<S_userModel> users = find(sql);
		System.out.println(users.size());
		return users;
		
	}
	
	
	public Page<S_userModel> paginate(int pageNum, int pageSize){
		Page<S_userModel> page = paginate(pageNum,pageSize,"select *","from s_user");

		return page;
	}
}
