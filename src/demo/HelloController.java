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
	  Pr_order_sms_logModel.dao.set("id", "seq_app.nextval").set("receiveNums", "18958003903")
	  .set("sms_content", "JFinal_Test").save();
	  name = name+"headle";
	  setAttr("helloStr",name);
//	  render("/demoView/demoHTML.html");
	  redirect("/");
	  return;
  }
} 