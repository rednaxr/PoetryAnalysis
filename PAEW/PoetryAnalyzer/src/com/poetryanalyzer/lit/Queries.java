package com.poetryanalyzer.lit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Queries {
	private Connection conn = null;
	public Queries() {
		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://localhost/words?" +
		                                   "user=root&password=123abcSyd");

		    // Do something with the Connection

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
	public String Pronunciation(String word) {
		// assume that conn is an already created JDBC connection (see previous examples)
		
		/*ResultSetMetaData metaData = resultSet.getMetaData();
		int count = metaData.getColumnCount(); //number of column
		String columnName[] = new String[count]; 

		for (int i = 1; i <= count; i++)
		{
		   columnName[i-1] = metaData.getColumnLabel(i);
		   System.out.println(columnName[i-1]);
		} */
		/////////////////////////////////////////////
		
		var stress = "";
		Statement stmt = null;
		ResultSet rs = null;

		try {
		    stmt = conn.createStatement();
		    //get the stress of the word!
		    rs = stmt.executeQuery("SELECT word, stress FROM pronounce WHERE word='"+word+"';");
		    
		    rs.first();
		    System.out.println(rs.getString("stress"));
		    return rs.getString("stress");
		}
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    // it is a good idea to release
		    // resources in a finally{} block
		    // in reverse-order of their creation
		    // if they are no-longer needed

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }
		}
		return stress;
	}
}