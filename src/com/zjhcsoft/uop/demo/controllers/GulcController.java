package com.zjhcsoft.uop.demo.controllers;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.zjhcsoft.uop.demo.models.S_userModel;

public class GulcController extends Controller{
	
 
	public void index1(){
	//	 setAttr("users",S_userModel.dao.paginate(getParaToInt(0,1), 10,"SELECT *", "FROM s_user order by id"));
		 setAttr("users",S_userModel.dao.paginate(getParaToInt(0,1), 10));
		render("list.html");
	}

	
	public void delete(){
		S_userModel.dao.deleteById(getParaToInt("id"));
		redirect("/viewDemo_glc/index1");
	}
	
	
	public void modify(){
		setAttr("user", S_userModel.dao.findById(getParaToInt()));
	}
	
	public void update(){
		getModel(S_userModel.class).update();
		redirect("/viewDemo_glc/index1");
	}
	
	
}

