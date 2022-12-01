/**
 * 
 */
package org.pahappa.systems.todoapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.pahappa.systems.task.Task;

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
		 

	}
	
	private static void enterData()
	{
		
		try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            
            Connection connection = DriverManager.getConnection(connectionUrl,username,password);  
            
            Statement statement = connection.createStatement();  
                        
            
            System.out.println("Enter task name");
            String taskName = readFromUser();
            
            System.out.println("Enter task Description");
            String taskDescription = readFromUser();
            
            System.out.println("Enter your name");
            String createdBy = readFromUser();
            
            System.out.println("Enter task Status");
            String taskStatus = readFromUser();
            
            System.out.println("Enter task time");
            String taskAt = readFromUser();
//            
            String sql = "INSERT INTO tasks VALUES (5," +  "\"" + taskName + "\"" + ", " + "\"" + taskDescription + "\"" + ", " + "\"" + createdBy + "\"" + "," + "\"" + taskStatus+ "\"" + ","+ "\"" + taskAt + "\"" + ")";
            System.out.println(sql);
            statement.executeUpdate(sql);
           
//            while (resultset.next()) {
//            	
////            	Task task = new Task();
//            	
//            	
//            	
//                System.out.println("Enter task name");
//                String taskName = readFromUser();
//                resultset.updateString(0, taskName);
//                
//                System.out.println("Enter task Description");
//                String taskDescription = readFromUser();
//                resultset.updateString(0, taskDescription);
//                
//                System.out.println("Enter task Status");
//                String taskStatus = readFromUser();
//                resultset.updateString(0, taskStatus);
//                
//                System.out.println("Enter task Status");
//                String taskBy = readFromUser();
//                resultset.updateString(0, taskBy);
//                
//                
//              }
            connection.close();  
        }catch(Exception e){
            System.out.println(e);
        } 
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
            	
                task.setId(resultset.getInt("taskId"));
                
                task.setName(resultset.getString("taskName"));
             
                task.setDescription(resultset.getString("taskDesc"));
                
                task.setTaskBy(resultset.getString("taskCreatedBy"));
                
                task.setCreatedAt(resultset.getString("taskCreatedOn"));
                
               
                System.out.println(task.getId() + ", " + task.getName() + ", " + task.getDescription() +
                                   ", " + task.getCreatedAt() + ", " + task.getTaskBy());
                
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

}
