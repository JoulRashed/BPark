package server;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class MySqlConnection {
	//singleton for the sql connection
	//when we need sql connection we call getInstance()
	private static Connection conn = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("Driver definition succeed");

            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bpark?serverTimezone=IST",
                "root", 
                "227427Bashar@"
            );
            System.out.println("SQL connection succeed");

        } catch (Exception ex) { 
            System.out.println("Connection failed: " + ex.getMessage());
        }
    }

    public static Connection getInstance() {
        return conn;
    }
	
    public static void updateParkingSpace(String pSpace, String subNumber, String OrderNumber) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Driver definition succeed");
		} catch (Exception ex) {
			/* handle the error */
			System.out.println("Driver definition failed");
		}
		try {
	        Connection conn = getInstance();
	        System.out.println("SQL connection succeed");

	        // Query with placeholders for parameters
	        String query = "UPDATE `order` SET parking_space = ? WHERE subscriberNumber = ? AND order_number =?";
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        
	        // Set the parameters (pSpace and subNumber)
	        pstmt.setString(1, pSpace);  // If pSpace is numeric, use setInt instead
	        pstmt.setString(2, subNumber);  // If subNumber is numeric, use setInt instead
	        pstmt.setString(3, OrderNumber);

	        // Execute the update
	        int rowsAffected = pstmt.executeUpdate();
	        System.out.println("Rows updated: " + rowsAffected);

	    } catch (SQLException ex) {
	        System.out.println("SQLException: " + ex.getMessage());
	        System.out.println("SQLState: " + ex.getSQLState());
	        System.out.println("VendorError: " + ex.getErrorCode());
	    }
	}
	
	public static void updateDate(LocalDate selectedDate, String subNumber, String OrderNumber) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Driver definition succeed");
		} catch (Exception ex) {
			/* handle the error */
			System.out.println("Driver definition failed");
		}
		try {
	        Connection conn = getInstance();
	        System.out.println("SQL connection succeed");

	        String query = "UPDATE `order` SET order_date = ? WHERE subscriberNumber = ? AND order_number = ?";
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        pstmt.setDate(1, Date.valueOf(selectedDate));  // Convert LocalDate to SQL Date
	        pstmt.setString(2, subNumber);  // If subNumber is numeric, use setInt instead
	        pstmt.setString(3, OrderNumber);

	        int rowsAffected = pstmt.executeUpdate();
	        System.out.println("Rows updated: " + rowsAffected);//notation line

	    } catch (SQLException ex) {
	        System.out.println("SQLException: " + ex.getMessage());
	        System.out.println("SQLState: " + ex.getSQLState());
	        System.out.println("VendorError: " + ex.getErrorCode());
	    }
	}
	
	public static ResultSet searchOrdersOfSubscriber(String searchInput) {
		try {
	        Connection conn = getInstance();
	        System.out.println("SQL connection succeed");
	        	        
	        String query = "SELECT * FROM `order` WHERE subscriberNumber = ?";
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, searchInput);
	        ResultSet orders = pstmt.executeQuery();//save the orders in a array after executing it
	        return orders;

	    } catch (SQLException ex) {
	        System.out.println("SQLException: " + ex.getMessage());
	        System.out.println("SQLState: " + ex.getSQLState());
	        System.out.println("VendorError: " + ex.getErrorCode());
	    }
		return null;
		
	}
	
	
}
