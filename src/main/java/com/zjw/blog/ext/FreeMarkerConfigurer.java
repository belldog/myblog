
package com.zjw.blog.ext;

import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModelException;
import lombok.Data;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author belldog
 * 
 */
@Data
public class FreeMarkerConfigurer extends org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer {

	private Properties staticSettings;
	private Properties enumSettings;
	/*private ShiroTags shiroTags;*/

	@Override
	public void afterPropertiesSet() throws IOException, TemplateException {
		super.afterPropertiesSet();
		this.loadStaticModules();
		this.loadEnumModules();
		/*this.getConfiguration().setSharedVariable("shiro", shiroTags);*/
	}

	private void loadStaticModules() throws TemplateModelException {
		if (null != this.staticSettings) {
			BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_23).build();
			Enumeration<Object> en = this.staticSettings.keys();
			while (en.hasMoreElements()) {
				String name = (String) en.nextElement();
				String className = this.staticSettings.getProperty(name);

				TemplateHashModel staticModels = beansWrapper.getStaticModels();
				TemplateHashModel roundingModeStatics = (TemplateHashModel) staticModels.get(className);
                //添加共享变量
				this.getConfiguration().setSharedVariable(name, roundingModeStatics);
			}
		}
	}

	private void loadEnumModules() throws TemplateModelException {
		if (null != this.enumSettings) {
			BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_23).build();
			Enumeration<Object> en = this.enumSettings.keys();
			while (en.hasMoreElements()) {
				String name = (String) en.nextElement();
				String className = this.enumSettings.getProperty(name);

				TemplateHashModel enumModels = beansWrapper.getEnumModels();
				TemplateHashModel roundingModeStatics = (TemplateHashModel) enumModels.get(className);
                //添加共享变量
				this.getConfiguration().setSharedVariable(name, roundingModeStatics);
			}
		}
	}

/*	public ShiroTags getShiroTags() {
		return shiroTags;
	}

	public void setShiroTags(ShiroTags shiroTags) {
		this.shiroTags = shiroTags;
	}*/

}
