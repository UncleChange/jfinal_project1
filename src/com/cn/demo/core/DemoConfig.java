package com.cn.demo.core;

import com.cn.demo.controller.Rock4lifeController;
import com.cn.demo.handler.ReqSkipHandler;
import com.cn.demo.model.User;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.dialect.OracleDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

public class DemoConfig extends JFinalConfig {
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setBaseViewPath("/ftl");
		me.setError404View("/404.html");
		me.setError500View("/500.html");
		me.setViewType(ViewType.FREE_MARKER);
		
	}
	public void configRoute(Routes me) {
		me.add("/", Rock4lifeController.class);
	}
	public void configPlugin(Plugins me) {
		C3p0Plugin cp = new C3p0Plugin("jdbc:oracle:thin:@10.3.40.51:1521:TianAnOrcl", "cis", "cis");
		//配置Oracle驱动
		cp. setDriverClass("oracle.jdbc.driver.OracleDriver");
		me.add(cp);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		me.add(arp);
		// 配置Oracle方言
		arp.setDialect(new OracleDialect());
		// 配置属性名(字段名)大小写不敏感容器工厂
		arp.setContainerFactory(new CaseInsensitiveContainerFactory());
		arp.addMapping("TS_USER", "USER_ID", User.class);
	}
	public void configInterceptor(Interceptors me) {}
	public void configHandler(Handlers me) {
		me.add(new ReqSkipHandler());
	}
}
