package com.zjhcsoft.uop.demo; 
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
import com.zjhcsoft.uop.demo.models.S_userModel;
import com.zjhcsoft.uop.demo.routes.Route_gulc;
import com.zjhcsoft.uop.demo.routes.Route_zhaoyz;

public class DemoConfig extends JFinalConfig { 
	
  public void configConstant(Constants me) { 
	me.setViewType(ViewType.FREE_MARKER);
    me.setDevMode(true);
  } 
  
  
  
  public void configRoute(Routes me) {
	  me.add(new Route_zhaoyz());
	  me.add(new Route_gulc());
	
  } 
  
  
  
  public void configPlugin(Plugins me) {
	  C3p0Plugin cp = new C3p0Plugin("jdbc:oracle:thin:@134.96.70.241:1521:zjcsc","zjcsc517","cft67ujm");
	  me.add(cp);
	  cp.setDriverClass("oracle.jdbc.driver.OracleDriver");
	  ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
	  me.add(arp);
	  arp.setDialect(new OracleDialect());
	  arp.setContainerFactory(new CaseInsensitiveContainerFactory());
	  arp.addMapping("S_USER", S_userModel.class);
  } 
  
  
  public void configInterceptor(Interceptors me) {} 
  
  
  public void configHandler(Handlers me) {
	  me.add(new ContextPathHandler());
  } 
  
  
} 