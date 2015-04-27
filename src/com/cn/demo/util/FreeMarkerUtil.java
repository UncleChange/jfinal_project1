package com.cn.demo.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.jfinal.kit.PathKit;
import com.jfinal.render.FreeMarkerRender;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;

public class FreeMarkerUtil {
	//�������в���,js·��,cs·����
	private static Map<String, Object> releaseParams = new HashMap<String, Object>();
	static{
		//releaseParams.put("csspath", "");
		
	}
	//����
	private static Configuration config = null;
	private static Configuration appConfig = null;
	/**
	 * appConfig�������в���
	 * ��дfreemarker�е�  reader��������ȡ�������ļ�
	 * @return
	 */
	public static Configuration getAppConfiguration()
	{
		if(appConfig == null)
		{
			//��freemarker�л�ȡ��������
			appConfig = (Configuration)FreeMarkerRender.getConfiguration().clone();
			try {
				//����ģ��·��
				/*	config.setDirectoryForTemplateLoading(new File(PathKit.getWebRootPath()));
				config.setObjectWrapper(new DefaultObjectWrapper());*/
				appConfig.setDirectoryForTemplateLoading(new File(PathKit.getWebRootPath()+"/ftl/"));
				appConfig.setObjectWrapper(new DefaultObjectWrapper());   
			} catch (IOException e) {
				// TODO log
			}
		}
		return appConfig;
	}
}
