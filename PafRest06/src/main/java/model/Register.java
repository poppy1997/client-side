package model;
import java.sql.*;
public class Register
{ 		//A common method to connect to the DB
	private Connection connect()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			//Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
		}
		catch (Exception e)
		{e.printStackTrace();}
		return con;
	}
	
	public String insertItem(String userName, String userPassword, String userCode, String userEmail, String userPhone)
	{
		String output = "";
		
		try
		{
			Connection con = connect();
			
			if (con == null)
			{
				return "Error while connecting to the database for inserting.";
			}
			
			// create a prepared statement
			String query = " insert into user (`userID`,`userName`,`userPassword`,`userCode`,`userEmail`, `userPhone`)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, userName);
			preparedStmt.setString(3, userPassword);
			preparedStmt.setString(4, userCode);
			preparedStmt.setString(5, userEmail);
			preparedStmt.setString(6, userPhone);
			
			
			// execute the statement
			preparedStmt.execute(); 
			con.close(); 
			output = "Inserted successfully"; 
		} 
		catch (Exception e) 
		{ 
			 output = "Error while inserting the item."; 
			 System.err.println(e.getMessage()); 
		} 
			 return output; 
	} 

	public String readItems() 
	{ 
		String output = "";
			 
		try
		{ 
			 Connection con = connect(); 
			 
			 if (con == null) 
			 {
				 return "Error while connecting to the database for reading."; 
			 } 
			 
			 // Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>User Name</th><th>User Password</th>" +
			 "<th>User Code</th>" + 
			 "<th>User Email</th>" +
			 "<th>User Phone</th></tr>"; 
			 
			 String query = "select * from user"; 
			 Statement stmt = con.createStatement(); 
			 ResultSet rs = stmt.executeQuery(query); 
			 
			 
			 // iterate through the rows in the result set
			 while (rs.next()) 
			 { 
				 String id = Integer.toString(rs.getInt("userID")); 
				 String userName = rs.getString("userName"); 
				 String userPassword = rs.getString("userPassword"); 
				 String userCode = rs.getString("userCode"); 
				 String userEmail = rs.getString("userEmail"); 
				 String userPhone = rs.getString("userPhone"); 
				 
				 // Add into the html table
				 output += "<tr><td><input id='hidItemIDUpdate' \r\n"
				 		+ " name='hidItemIDUpdate' \r\n"
				 		+ " type='hidden' value='" + userName + "</td>"; 
				 output += "<td>" + userPassword + "</td>"; 
				 output += "<td>" + userCode + "</td>"; 
				 output += "<td>" + userEmail + "</td>"; 
				 output += "<td>" + userPhone + "</td>";
				 
				 //buttons
				 output += "<td><input name='btnRemove' type='button' value='Remove'  "
				 		+ "class='btnRemove btn btn-danger' data-itemid='" + id + "'>" + "</td>"
				 		+ "<td><input name='btnUpdate' type='button' value='Update' "
						+ "class='btnUpdate btn btn-secondary' data-itemid='" + id + "'></td></tr>";
			 } 
			 
			 con.close();
			 
			 // Complete the html table
			 output += "</table>"; 
		} 
		catch (Exception e) 
		{ 
			 output = "Error while reading the items."; 
			 System.err.println(e.getMessage()); 
		} 
		return output; 
			 
	} 
	
	public String updateItem(String userID, String userName, String userPassword, String userCode, String userEmail, String userPhone)
	{ 
		String output = "";
		
		try
		{ 
			 Connection con = connect();
			 
			 if (con == null) 
			 {
				 return "Error while connecting to the database for updating."; 
			 } 
			
			 // create a prepared statement
			 String query = "UPDATE user SET userName=?,userPassword=?,userCode=?, userEmail=?, userPhone=? WHERE userID=?"; 
			 
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 
			 // binding values
			 preparedStmt.setString(1, userName); 
			 preparedStmt.setString(2, userPassword); 
			 preparedStmt.setString(3, userCode); 
			 preparedStmt.setString(4, userEmail); 
			 preparedStmt.setString(5, userPhone); 
			 preparedStmt.setInt(6, Integer.parseInt(userID)); 
			 // execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 output = "Updated successfully"; 
		} 
		catch (Exception e) 
		{ 
			output = "{\"status\":\"error\", \"data\":  \"Error while updating the item.\"}"; 
			System.err.println(e.getMessage()); 
		}
		
		return output; 
	} 
			
	public String deleteItem(String id) 
	{ 
		String output = ""; 
		
		try
		{ 
			 Connection con = connect(); 
			 
			 if (con == null) 
			 {
				 return "Error while connecting to the database for deleting."; 
			 }
			 
			 // create a prepared statement
			 String query = "delete from funders where userID=?"; 
			 
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(id)); 
			 
			 // execute the statement
			 preparedStmt.execute(); 
			 con.close();
			 
			 output = "Deleted successfully"; 
		} 
		catch (Exception e) 
		{ 
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the item.\"}";  
			System.err.println(e.getMessage()); 
		} 
		return output; 
	} 
	
	public String getUser(String email,String password)
    {
        String output = "";
        try
        {
            Connection con = connect();
       
            //create a prepared statement
        String query = "select * from user where userEmail = '" + email +"' AND userPassword = '" + password + "'";
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
       
        if(rs.next()==true)
        {
       	 
       	 output+="Loging Succsessful!";
           
        }
        else {
       	 output+="No user matching type";
        }
        con.close();
       
    }
    catch (Exception e)
    {
        output = "Error while reading Users.";
        System.err.println(e.getMessage());
    }
        return output;
    }
	
	public String logUser(String email,String password)
    {
        String output = "";
        try
        {
            Connection con = connect();
       
            //create a prepard statment
        String query = "select * from user where userEmail = '" + email +"' AND userPassword = '" + password + "'";
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
       
        if(rs.next()==true)
        {
       	 
       	 output+="Logging Succsessful!";
           
        }
        else {
       	 output+="No user matching type";
        }
        con.close();
       
    }
    catch (Exception e)
    {
        output = "Error while reading Users.";
        System.err.println(e.getMessage());
    }
        return output;
    }
} 
