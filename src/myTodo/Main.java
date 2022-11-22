
package myTodo;

import java.util.*;

import constants.Choice;
import task.Task;

/**
 * main class
 * @author user
 *
 */
public class Main {
	
	public static List<Task> tasks =new ArrayList<Task>();
	public static Task task = new Task();

	/**
	 * driver method.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("\t\t.....ToDo Manager.....\t\t");
        
        System.out.println("What next \n 1. Enter task \n 2. View cur1rent tasks \n 3. Exit) ");
        
	
		/**
		 * infinity loop that allows
		 * user decide weather enter new task,
		 * view tasks or even exit program. 
		 */
		while(true) {
	        switch (input.nextInt()) {
	            case 1:
	            	enterTask();
	                break;
	            case 2:
	            	viewTasks();
	                break;
	            case 3:
	                break;
	        }
	      
		}
		  input.close();
	}
	/**
	 * getChoice method
	 * allows user select the status of the task
	 */
	 public static void getChoice() {
		 
				System.out.println("Task status \n 1. New \n 2. Inprogress \n 3. Completed) ");
			
	        switch (input.nextInt()) {
	            case 1:
	            	task.setStatus(Choice.NEW);
	                break;
	            case 2:
	            	task.setStatus(Choice.IN_PROGRESS);
	                break;
	            case 3:
	            	task.setStatus(Choice.COMPLETED);
	                break;
	            default:
	            	task.setStatus(Choice.NEW);
	                break;
	        }
	      
	       
	    }
	 
	 /**
	  * enterTask method
	  * allows the user to add new task. 
	  */
	 public static void enterTask() {
		 Scanner input = new Scanner(System.in);
		 System.out.println("Please Enter task title : ");
         task.setName(input.nextLine());
       
         System.out.println("Description : ");
         task.setDescription(input.nextLine());
       
         getChoice();
       
         System.out.println("Name \t Description \t Status");
         System.out.println(task.getName()+"\t"+task.getDescription()+"\t"+task.getStatus());
       
         tasks.add(task);

	 }
	 
	 /**
	  * viewTask method that displays the currently available tasks
	  */
	 public static void viewTasks() {
		if(tasks.isEmpty()){
			System.out.println("No task at the moment!");
		         
		 }else{
		    System.out.println("ID \t\t Task \t\t Description \t\t Status");
		    for (Task task: tasks ) {
		    	System.out.println((tasks.indexOf(task) + 1)+"\t"+task.getName()+"\t" + task.getDescription()+"\t" + task.getStatus());
		       }
	
		     } 
		}	 
	 } 


