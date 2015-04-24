/**
 * 
 */
package com.zjhcsoft.uop.demo.controllers;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;
import com.zjhcsoft.uop.demo.interceptors.DemoInterceptor;
import com.zjhcsoft.uop.demo.models.S_userModel;

/**
 * @author zhaoyz
 *
 */
@Before(DemoInterceptor.class)
public class UserManage_Controller extends Controller {
	
	// 通过@ClearInterceptor和@ClearInterceptor(ClearLayer.ALL)来清除上一级或者全部的拦截器
	public void user_list(){
		List u_list = S_userModel.dao.find("select * from s_user where user_type = ? and sts = ?","UOP_admin","A");
		setAttr("u_list", u_list);
		return;
	}
	
	
	
	// 表单提交数据
	public void user_add(){
		S_userModel new_user = getModel(S_userModel.class);
		new_user.set("id", "seq_app.nextval").set("user_type", "UOP_admin111").set("create_date", new Date()).save();
		user_list();                // 也可使用redirect("user_list");
		return;
	}
	
	
	// ajax处理返回
	public void user_ajax_add(){
		String username = getPara("username");
		String userViewname = getPara("userViewname");
		String passwd = getPara("passwd");
		S_userModel new_user = new S_userModel();
		new_user.set("id", "seq_app.nextval").set("name", username).set("Viewname", userViewname).set("passwd", passwd)
		.set("sts","A").set("user_type", "UOP_admin");
		new_user.save();
		List u_list = S_userModel.dao.find("select * from s_user where user_type = 'UOP_admin'");
		setAttr("u_list", u_list);
		setAttr("result_flag", "Success");
		renderJson();
		return;
	}
	
	// 事务控制
	public void user_batch_add(){
		boolean success = Db.tx(new IAtom() {
			@Override
			public boolean run() throws SQLException {
				// TODO Auto-generated method stub
				Record r1 = new Record().set("ID", "seq_app.nextval").set("VIEWNAME","杭州统一平台测试账号")
						.set("USER_TYPE", "UOP_admin").set("NAME", "zhaoyz_batch_01").set("CREATE_DATE", new Date());
				Db.save("s_user", r1);
				Record r2 = new Record().set("ID", "seq_app.nextval").set("VIEWNAME","杭州统一平台测试账号")
						.set("USER_TYPE", "UOP_admin").set("NAME", "zhaoyz_batch_02").set("CREATE_DATE", new Date());
				Db.save("s_user", r2);
				return false;
			}
		});
		renderFreeMarker("user_list.html");
		
	}
	
	// url后面配置参数传值
	public void getDatabyURL(){
		String param1 = getPara("param1");
		String param2 = getPara("param2");
		Long param2_long = getParaToLong("param2");
		renderText("得到参数："+param1+","+param2);
		return;
	}
	
	// 返回文件下载
	public void file_download(){
		renderFile("2015年电信统一运营平台开发项目高层设计说明书-v3.1.doc");
		return;
	}
	
	// 上传文件
	public void file_upload(){
		UploadFile file = getFile("img");
		redirect("/userManage/user_list");
		return;
	}
	
	
	


}
