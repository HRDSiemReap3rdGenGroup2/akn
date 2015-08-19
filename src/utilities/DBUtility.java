package utilities;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtility {
	public Connection getConnection() {
		Context c;
		try {
			c = new InitialContext();
			DataSource ds = (DataSource) c.lookup("java:comp/env/KANEWSDB");
			return ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
