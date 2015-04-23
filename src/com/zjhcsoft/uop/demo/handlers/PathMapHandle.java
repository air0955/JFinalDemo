package com.zjhcsoft.uop.demo.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;

public class PathMapHandle extends Handler {

	@Override
	public void handle(String target, HttpServletRequest request,
			HttpServletResponse response, boolean[] isHandled) {
		// TODO Auto-generated method stub
		if("/userManage/user_list_handle".equals(target)){
			target = "/userManage/user_list";
		}
		nextHandler.handle(target, request, response, isHandled);
	}

}
