package com.zjhcsoft.uop.demo.models;

import java.sql.SQLException;
import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Page;
import com.zjhcsoft.uop.demo.controllers.MyModel;



/**
 * 
 * 表结构如下
 * Name        Type          Nullable Default    Comments             
----------- ------------- -------- ---------- -------------------- 
ID          NUMBER(12)                                             
VIEWNAME    VARCHAR2(50)  Y                                        
NAME        VARCHAR2(50)  Y                                        
PASSWD      VARCHAR2(150) Y                                        
STS         VARCHAR2(1)   Y        'A'                             
LOGINID     VARCHAR2(50)  Y                                        
LOGINDATE   DATE          Y                                        
PHONE       VARCHAR2(50)  Y                                        
USER_TYPE   VARCHAR2(50)  Y        'ADMIN_WT' 用户类型，ADMIN_WT代表网厅管理员 
YXQD        VARCHAR2(50)  Y                   营销渠道             
USERNAME    VARCHAR2(50)  Y                   用户姓名             
REMARK1     VARCHAR2(50)  Y                                        
REMARK2     VARCHAR2(50)  Y                                        
REMARK3     VARCHAR2(50)  Y                                        
REMARK4     VARCHAR2(50)  Y                                        
REMARK5     VARCHAR2(50)  Y                                        
REMARK6     VARCHAR2(50)  Y                                        
CREATE_DATE DATE          Y 
 *
 */



public class S_userModel extends MyModel<S_userModel> {
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
