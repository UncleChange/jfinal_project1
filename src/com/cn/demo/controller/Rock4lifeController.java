package com.cn.demo.controller;

import java.util.HashMap;
import java.util.Map;

import com.cn.demo.core.FreeMarkerRender;
import com.cn.demo.model.User;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
public class Rock4lifeController extends Controller {
	public void index() {
		
		User user=User.dao.findById("1");
		System.out.println(user.getStr(User.ACCOUNT));
		setAttr("user", user);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("title", "ROCK 4 LIFE");
		
		renderFreeMarker("index.html",map);
	}
	@ActionKey("/toBolg")
	public void toBolg(){
		render("blog.html");
	}
	@ActionKey("/toGallery")
	public void toGallery(){
		render("gallery.html");
	}
	@ActionKey("/toLayout")
	public void toLayout(){
		render("layout.html");
	}
	@ActionKey("/toSinglePost")
	public void toSinglePost(){
		render("single-post.html");
	}
	public void renderFreeMarker(String view,Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		FreeMarkerRender duRender=new FreeMarkerRender(map,view);
		
		this.render(new FreeMarkerRender(map,"index.html")) ;
	}
}