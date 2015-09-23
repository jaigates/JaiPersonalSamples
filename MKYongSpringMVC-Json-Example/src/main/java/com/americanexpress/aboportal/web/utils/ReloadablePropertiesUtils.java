package com.americanexpress.aboportal.web.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;


public class ReloadablePropertiesUtils extends PropertyPlaceholderConfigurer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1813140442525087842L;
	private static Map<String, String> propertiesMap;
	
	private Properties props;
	private ConfigurableListableBeanFactory beanFactory;

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactory1, Properties props1) throws BeansException {
		super.processProperties(beanFactory1, props1);
		this.props=props1;
		this.beanFactory=beanFactory1;
		propertiesMap = new HashMap<String, String>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			propertiesMap.put(keyStr, StringUtils.stripToEmpty(props.getProperty(keyStr)));
		}
	}

	public static String getProperty(String name) {
		
		return propertiesMap.get(name);
	}

}