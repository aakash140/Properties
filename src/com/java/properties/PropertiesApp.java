package com.java.properties;

public class PropertiesApp {

	public static void main(String[] args) {
		PropertiesCache cache = PropertiesCache.getPropertiesInstance();
		System.out.println(cache.getProperty("StoreID"));
		System.out.println(cache.getProperty("TillID"));
		System.out.println(cache.getProperty("WorkstationID"));
		System.out.println(cache.getProperty("StoreLocation"));

		System.out.println(cache.getAllPropertiesNames());

		if (!cache.containsKey("BackOffice"))
			cache.setProperty("BackOffice", "172.22.22.200");
		cache.setProperty("StoreID", "8000");
		System.out.println(cache.getAllPropertiesNames());
	}
}