package com.cn.demo.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;

public class ReqSkipHandler extends Handler{

	@Override
	public void handle(String target, HttpServletRequest request,
			HttpServletResponse response, boolean[] isHandled) {
		 int index = target.lastIndexOf(".html");  
	        if (index != -1)  
	        target = target.substring(0, index);  
	        nextHandler.handle(target, request, response, isHandled);  
	}

}
