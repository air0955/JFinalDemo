package com.zjhcsoft.uop.demo.routes;

import com.jfinal.config.Routes;
import com.zjhcsoft.uop.demo.controllers.UserManage_Controller;

public class RouteDemo extends Routes {

	@Override
	public void config() {
		// TODO Auto-generated method stub
		add("/userManage",UserManage_Controller.class);  

	}

}
