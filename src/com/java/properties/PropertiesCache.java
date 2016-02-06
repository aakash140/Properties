package com.java.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class PropertiesCache {
	private Properties properties;
	private PropertiesConfiguration propertiesConfiguration;
	File file = new File("./application.properties");

	private PropertiesCache() {
		properties = new Properties();

		// Method 1:Keep the file in the classpath
		/*
		 * InputStream inputStream=this.getClass(). getClassLoader().
		 * getResourceAsStream("application.properties");
		 */

		try {
			// Method 2:Specify the file location.
			InputStream inputStream = new FileInputStream(file);
			propertiesConfiguration = new PropertiesConfiguration(file);
			properties.load(inputStream);
		} catch (IOException | ConfigurationException exception) {
			exception.printStackTrace();
		}
	}

	private static class PropertiesInstance {
		private static final PropertiesCache PROPERTIES_CACHE = new PropertiesCache();
	}

	public static PropertiesCache getPropertiesInstance() {
		return PropertiesInstance.PROPERTIES_CACHE;
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	public Set<String> getAllPropertiesNames() {
		return properties.stringPropertyNames();
	}

	public boolean containsKey(Object key) {
		return properties.containsKey(key);
	}

	public void setProperty(String key, String value) {
		propertiesConfiguration.setProperty(key, value);

		try {
			propertiesConfiguration.save(file);
		} catch (ConfigurationException exception) {
			exception.printStackTrace();
		}
	}
}