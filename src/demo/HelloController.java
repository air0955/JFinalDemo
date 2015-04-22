package demo; 
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

public class HelloController extends Controller { 
  public void index() { 
    renderText("Hello JFinal World."); 
    return;
  } 
  @Before(DemoInterceptor.class)
  public void helloTest(){
	  String name = getPara("helloName");
	  name = name+"headle";
	  setAttr("helloStr",name);
//	  render("/demoView/demoHTML.html");
	  redirect("/");
	  return;
  }
} 