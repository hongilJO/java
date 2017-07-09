package auth_dao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class config {

	public static String get_property(String key) {
		Properties pr = new Properties();
		try {
			pr.load(new FileInputStream("/Users/naver/Documents/workspace/authentication/src/auth_dao/conf.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pr.getProperty(key);
	}
}
