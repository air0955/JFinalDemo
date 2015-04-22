/**
 * 
 */
package com.zjhcsoft.uop;

import java.util.List;

import com.jfinal.core.Controller;

import demo.S_user;

/**
 * @author zhaoyz
 *
 */
public class UserManage_Controller extends Controller {
	public void user_list(){
		List u_list = S_user.dao.find("select * from s_user where user_type = 'UOP_admin'");
		setAttr("u_list", u_list);
		return;
	}
	
	public void user_add(){
		String username = getPara("username");
		String userViewname = getPara("userViewname");
		String psword = getPara("psword");
		S_user new_user = new S_user();
		new_user.set("id", "seq_app.nextval").set("name", username).set("Viewname", userViewname).set("passwd", psword)
		.set("sts","A").set("user_type", "UOP_admin");
		new_user.save();
		redirect("user_list");
		return;
	}

}
