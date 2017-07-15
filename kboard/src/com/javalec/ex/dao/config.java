package com.javalec.ex.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class config {
	
	Properties p = new Properties();
	private static config conn = new config();
	private config() {
		try {
			p.load(new FileInputStream("/Users/naver/Documents/workspace/kboard/src/com/javalec/ex/dao/conf.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static config getConfig(){
		return conn;
	}
	public String getProperty(String key){
		return p.getProperty(key);
	}
}
