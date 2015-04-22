package demo; 
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.dialect.OracleDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

public class DemoConfig extends JFinalConfig { 
  public void configConstant(Constants me) { 
	me.setViewType(ViewType.JSP);
    me.setDevMode(true);
  } 
  public void configRoute(Routes me) { 
//  me.add("/hello", HelloController.class);
me.add("/inputTest",HelloController.class);
  } 
  public void configPlugin(Plugins me) {
	  C3p0Plugin cp = new C3p0Plugin("jdbc:oracle:thin:@134.96.70.241:1521:zjcsc","zjcsc517","cft67ujm");
	  me.add(cp);
	  cp.setDriverClass("oracle.jdbc.driver.OracleDriver");
	  ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
	  me.add(arp);
	  arp.setDialect(new OracleDialect());
	  arp.setContainerFactory(new CaseInsensitiveContainerFactory());
	  arp.addMapping("pr_order_sms_log", Pr_order_sms_logModel.class);
	  
  } 
  public void configInterceptor(Interceptors me) {} 
  public void configHandler(Handlers me) {
	  me.add(new ContextPathHandler());
	  
  } 
  
  public void TestGit(){
	  System.out.println("2222");
	  System.out.println("3333");
  }
  
} 