package com.zjhcsoft.uop.demo; 
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.dialect.OracleDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.zjhcsoft.uop.demo.handlers.PathMapHandle;
import com.zjhcsoft.uop.demo.interceptors.GlobleInterceptor;
import com.zjhcsoft.uop.demo.models.S_userModel;
import com.zjhcsoft.uop.demo.routes.RouteDemo;
import com.zjhcsoft.uop.demo.routes.Route_gulc;

public class DemoConfig extends JFinalConfig { 
	
  public void configConstant(Constants me) {
	// 加载少量必要配置，随后可用getProperty(...)获取值
	loadPropertyFile("conn.properties");
	me.setViewType(ViewType.FREE_MARKER);
    me.setDevMode(true);
    me.setFileRenderPath("/userManage/download");
    me.setUploadedFileSaveDirectory(PathKit.getWebRootPath()+"/userManage/upload");
  } 
  
  
  
  public void configRoute(Routes me) {
	  me.add(new RouteDemo());
	  me.add(new Route_gulc());
  } 
  
  
  
  public void configPlugin(Plugins me) {
	  C3p0Plugin cp = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password").trim());
	  me.add(cp);
	  cp.setDriverClass(getProperty("jdbcdrive"));
	  ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
	  me.add(arp);
	  arp.setDialect(new OracleDialect());
	  arp.setContainerFactory(new CaseInsensitiveContainerFactory());
	  arp.addMapping("S_USER", (Class<? extends Model<?>>) S_userModel.class);
  }
  
  
  public void configInterceptor(Interceptors me) {
	  me.add(new GlobleInterceptor());
  } 
  
  
  public void configHandler(Handlers me) {
	    me.add(new PathMapHandle());
  } 
  
  public static void main(String[] args) {
	JFinal.start();
  }
 
} 
