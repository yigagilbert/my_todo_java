
package myTodo;

import java.text.SimpleDateFormat;
import java.util.*;

import constants.Choice;
import task.Task;

/**
 * main class
 * @author user
 *
 */
public class Main {
	
	public static List<String> taskNames =new ArrayList<String>();
	public static List<String> taskDescriptions =new ArrayList<String>();
	public static List<String> taskStatuses =new ArrayList<String>();
	public static Task task = new Task();
	public static Scanner input = new Scanner(System.in);

	/**
	 * driver method.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("\t\t.....ToDo Manager.....\t\t");
 
	
		/**
		 * infinity loop that allows
		 * user decide weather enter new task,
		 * view tasks or even exit program. 
		 */
		while(true) {
			System.out.println("What next \n 1. Enter task \n 2. View cur1rent tasks \n 3. Delete task \n 4. Exit) ");
	        switch (Integer.parseInt(readFromUser())) {
	            case 1:
	            	enterTask();
	                break;
	            case 2:
	            	printList();
	                break;
	            case 3:
	            	deleteTask();
	            	break;
	            case 4:
	            	System.out.println("BYE BYE");
	            	System.exit(0);
	        }
	      
		}
		
		
		  
	}
	/**
	 * getChoice method
	 * allows user select the status of the task
	 */
	private static void getChoice() {
		 
				System.out.println("Task status \n 1. New \n 2. Inprogress \n 3. Completed) ");
			
	        switch (Integer.parseInt(readFromUser())) {
	            case 1:
	            	task.setStatus(Choice.NEW);
	            	addToTodoList(taskStatuses, task.getStatus().toString());
	                break;
	            case 2:
	            	task.setStatus(Choice.IN_PROGRESS);
	            	addToTodoList(taskStatuses, task.getStatus().toString());
	                break;
	            case 3:
	            	task.setStatus(Choice.COMPLETED);
	            	addToTodoList(taskStatuses, task.getStatus().toString());
	                break;
	            default:
	            	task.setStatus(Choice.NEW);
	            	addToTodoList(taskStatuses, task.getStatus().toString());
	                break;
	        }
	      
	       
	    }
	 
	 /**
	  * enterTask method
	  * allows the user to add new task. 
	  */
	 private static void enterTask() {
		 
		 System.out.println("Please Enter task title : ");
         task.setName(readFromUser());
         addToTodoList(taskNames, task.getName() );
         
         getChoice();
       
         System.out.println("Description : ");
         task.setDescription(readFromUser());
         addToTodoList(taskDescriptions, task.getDescription() );
       
       
         System.out.println("Name \t Description \t Status");
         System.out.println(task.getName()+"\t"+task.getDescription()+"\t"+task.getStatus());
       
        

	 }
	 
	 private static String readFromUser() {
	        return input.nextLine();
	    }
	 
	 
	 private static void addToTodoList(List<String> userList, String item) {
	        userList.add(item);
	    }
	 
	 /**
	  * viewTask method that displays the currently available tasks
	  */
	 private static void printList() {
	        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM/dd");
	        Calendar currentDate = Calendar.getInstance();
	        System.out.println("List's Date: " + simpleDate.format(currentDate.getTime()));

	        for (int listSize = 0; listSize != taskNames.size(); listSize++) { 
	            System.out.println(listSize + 1 + ". " + taskNames.get(listSize) + ", " + taskDescriptions.get(listSize)+ ", " + taskStatuses.get(listSize));
	        }
	    }
	 
	 private static void deleteTask() {
		 printList();
		 
		 System.out.println("Enter number of task to delete");
		 int index = Integer.parseInt(readFromUser());
		 taskNames.remove(index);
		 taskDescriptions.remove(index);
		 taskStatuses.remove(index);
		 
		 printList();

	 }
	 
	 } 


