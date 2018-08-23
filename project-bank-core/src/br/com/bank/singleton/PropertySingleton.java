package br.com.bank.singleton;

import java.io.IOException;
import java.util.Properties;

public class PropertySingleton {

	private static Properties p;
	
	private PropertySingleton() {}
	
	public static Properties getInstance() {
		if (p == null) {
			p = new Properties();
			try {
				p.load(PropertySingleton.class
					.getResourceAsStream("/bank.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	
}
