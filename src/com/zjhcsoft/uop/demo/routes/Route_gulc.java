package com.zjhcsoft.uop.demo.routes;

import com.jfinal.config.Routes;
import com.jfinal.render.Render;
import com.zjhcsoft.uop.demo.controllers.GulcController;
import com.zjhcsoft.uop.demo.controllers.UserManage_Controller;

public class Route_gulc extends Routes {

	@Override
	public void config() {
		add("/viewDemo_glc", GulcController.class);
	}

}
