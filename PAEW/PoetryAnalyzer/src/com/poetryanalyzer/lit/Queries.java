package com.poetryanalyzer.lit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;

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
	public ArrayList<String> Pronunciation(String word) {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<String> matches = new ArrayList<String>();
		try {
			//prevent sql injection
		    var query = "SELECT word, stress FROM pronounce WHERE word REGEXP CONCAT('^', ?, '\\\\(?');";
		    var smnt = conn.prepareStatement(query);
		    smnt.setString(1, word); 
		    //get the stress of the word!
		    rs = smnt.executeQuery();
		    while ( rs.next() ) { 
                matches.add(rs.getString("stress"));
            }
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
		return matches;
	}
}