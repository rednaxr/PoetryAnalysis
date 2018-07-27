package com.poetryanalyzer.lit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Collection;
import com.mysql.cj.xdevapi.DbDoc;
import com.mysql.cj.xdevapi.DbDocImpl;
import com.mysql.cj.xdevapi.DocResult;
import com.mysql.cj.xdevapi.JsonNumber;
import com.mysql.cj.xdevapi.JsonString;
import com.mysql.cj.xdevapi.Schema;
import com.mysql.cj.xdevapi.Session;
import com.mysql.cj.xdevapi.SessionFactory;

public class Queries {
	private Connection conn = null;
	private Schema schema;
	public Queries() {

			Session session = new SessionFactory().getSession("mysqlx://localhost:33060/test?user=user&password=123abcSyd");
	        System.err.println("Connected!");
	        schema = session.getDefaultSchema();
	        System.err.println("Default schema is: " + schema);
	        /*
		    setConn(DriverManager.getConnection("jdbc:mysql://localhost/test?" +
		                                   "user=minty&password=greatsqldb"));

		    // Do something with the Connection*/


	}
	public String Stress(String word) {
		// document walthrough
		Collection coll = schema.getCollection('stress);
		DocResult results = coll.find("$.title = "+word);
		DbDoc result = result.next();
		JsonString stress = result.get("Stress");
		return (String) stress.getString();
		
        
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
}