package demo;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;

public class DemoInterceptor implements Interceptor {
	public void intercept(ActionInvocation ai){
		System.out.println("Before action invocation");
		Controller c = ai.getController();
		System.out.println(ai.getMethodName());
		System.out.println(ai.getActionKey());
		System.out.println(ai.getControllerKey());
		System.out.println(ai.getViewPath());
		System.out.println(ai.toString());
		ai.invoke();
		System.out.println("After action invocation");
	}

}
