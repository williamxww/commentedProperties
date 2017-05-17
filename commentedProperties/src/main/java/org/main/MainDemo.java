package org.main;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.utils.CommentedProperties;


public class MainDemo {
	private static CommentedProperties properties = new CommentedProperties();
		
	public static void main(String[] args) {
		try {
			String path = ClassLoader.getSystemResource("config.properties").getPath();
			path = java.net.URLDecoder.decode(path, "UTF-8");
			File file = new File(path);
			InputStream configIs = ClassLoader.getSystemResourceAsStream("config.properties");
			properties.load(configIs, "UTF-8");
			
			configIs.close();
			FileOutputStream fos = new FileOutputStream(file);
			properties.store(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
