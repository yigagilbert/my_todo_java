/**
 * 
 */
package org.pahappa.systems.todoapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.pahappa.systems.task.Task;

import org.pahappa.systems.constants.*;



/**
 * @author google
 *
 */
public class Main {
	
	public static String connectionUrl = "jdbc:mysql://localhost:3306/my_todo";
	public static String username = "google";
	public static String password = "google";
	public static Scanner input = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		enterData();
		readData();
		search();
		 

	}
	
	private static void enterData()
	{
		String INSERT_RECORD = "insert into tasks values(?,?,?,?,?)";
		
	    try {
	    	Task task = new Task();
			Connection connection = DriverManager.getConnection(connectionUrl,username,password);		    
			PreparedStatement pstmt = connection.prepareStatement(INSERT_RECORD);
	    	pstmt.setString(1, "001");

	    	java.util.Date date = new java.util.Date();
	    	long t = date.getTime();
	    	java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
	        
	        System.out.println("Enter task name");
	        task.setName(readFromUser());
//            String taskName = readFromUser();
            
            System.out.println("Enter task Description");
	        task.setDescription(readFromUser());

//            String taskDescription = readFromUser();
            
            System.out.println("Enter your name");
	        task.setTaskBy(readFromUser());

//            String createdBy = readFromUser();
            
            System.out.println("Enter task Status");
	        task.setStatus(getChoice());

//            String taskStatus = getChoice();
	        
	        pstmt.setString(1, task.getName());
	        pstmt.setString(2, task.getDescription());
//	        pstmt.setString(3, task.getStatus());
	        pstmt.setString(4, task.getTaskBy());
	        pstmt.setTimestamp(5, sqlTimestamp);
	        pstmt.executeUpdate();
	        connection.close();
	        pstmt.close();


	      } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Failed to insert the record.");
	      } 
	}
	
	private static Status getChoice() {
		Status theTask;
		System.out.println("Task status \n 1. New \n 2. Inprogress \n 3. Completed ");
	
    switch (Integer.parseInt(readFromUser())) {
        case 1:
        	theTask = Status.NEW;
            break;
        case 2:
        	theTask = Status.IN_PROGRESS;
            break;
        case 3:
        	theTask = Status.COMPLETED;
            break;
        default:
        	theTask = Status.NEW;

            break;
    }
    return theTask;
  
   
}
	
	private static void readData()
	{
		try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            
            Connection connection = DriverManager.getConnection(connectionUrl,username,password);  
            
            Statement statement = connection.createStatement();  
            
            List<Task> taskList = new ArrayList<Task>();
            
            ResultSet resultset = statement.executeQuery("select * from tasks"); 
            while (resultset.next()) {
            	
            	Task task = new Task();
            	                
                task.setName(resultset.getString("taskName"));
             
                task.setDescription(resultset.getString("taskDesc"));
                
//                task.setStatus(resultset.getString("taskStatus"));

                task.setTaskBy(resultset.getString("taskCreatedBy"));
                
                task.setCreatedAt(resultset.getString("taskCreatedOn"));
                
                System.out.println("=====================================");
                
                System.out.println(String.format("Task name: %s", task.getName()));
                
                System.out.println("Task description: " + task.getDescription());

                System.out.println("Task Status: " + task.getStatus());
                
//                System.out.println("Task Status: " + task.getStatus());
                
                System.out.println("Task Created by: " + task.getTaskBy());

                System.out.println("Task Created On: " + task.getCreatedAt());
                
                System.out.println("=====================================");

                
               taskList.add(task); 
              }
            connection.close();  
        }catch(Exception e){
            System.out.println(e);
        } 
	}
	
	private static String readFromUser() {
        return input.nextLine();
    }
	
	private static void search() {
		
		Connection connection;
		try {
			connection = DriverManager.getConnection(connectionUrl,username,password);
			// Query which needs parameters
	        String query
	            = "Select * from task where taskName  ? or taskDescription ?";
	 
	        // Prepare Statement
	        PreparedStatement myStmt
	            = connection.prepareStatement(query);
	        
	        System.out.println("Enter task name");
	        String name = readFromUser();
//            String taskName = readFromUser();
            
            System.out.println("Enter task Description");
	        String  desc = readFromUser();
	 
	        // Set Parameters
	        myStmt.setString(1, name);
	        myStmt.setString(2, desc);
	 
	        // Execute SQL query
	        ResultSet resultset = myStmt.executeQuery();
	 
	        System.out.println("Age      Name");
	 
	        // Display function to show the Resultset
	        while (resultset.next()) {
	            String Name = resultset.getString("taskName");
	            int age = resultset.getInt("taskDesc");
	            System.out.println(Name + "     " + age);
	        }
	        
	     // Close the connection
	        connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		    

		
	}

}
