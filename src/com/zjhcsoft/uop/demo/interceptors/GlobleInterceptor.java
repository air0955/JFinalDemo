package com.zjhcsoft.uop.demo.interceptors;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class GlobleInterceptor implements Interceptor {
	public void intercept(ActionInvocation ai){
		System.out.println("This is a GlobleInterceptor");
		ai.invoke();
	}

}
