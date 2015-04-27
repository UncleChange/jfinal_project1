package com.cn.demo.core;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import com.cn.demo.util.FreeMarkerUtil;
import com.jfinal.render.Render;
import com.jfinal.render.RenderException;

import freemarker.template.Template;

/**
 * FreeMarkerRender.
 */
public class FreeMarkerRender extends Render {
	
	private static final long serialVersionUID = -7649769283048920381L;
	private transient static final String encoding = getEncoding();
	private transient static final String contentType = "text/html; charset=" + encoding;
	private String templateName;
	private Map<String, Object>  rootMap;
	public FreeMarkerRender(Map<String, Object> rootMap, String templateName) {
		   this.templateName=templateName;
		   this.rootMap=rootMap;
	}
    
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void render() {
		response.setContentType(contentType);
        Enumeration<String> attrs = request.getAttributeNames();
		Map root = new HashMap();
		while (attrs.hasMoreElements()) {
			String attrName = attrs.nextElement();
			root.put(attrName, request.getAttribute(attrName));
		}
         root.putAll(rootMap);
         
		PrintWriter writer = null;
        try {
			Template template = FreeMarkerUtil.getAppConfiguration().getTemplate(this.templateName);
			writer = response.getWriter();  //“ª±ﬂ«Î«Û£¨“ª±ﬂrender
			template.process(root, writer);		// Merge the data-model and the template
		} catch (Exception e) {
			throw new RenderException(e);
		}
		finally {
			if (writer != null)
				writer.close();
		}
	}
}