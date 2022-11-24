
package myTodo;

import java.text.SimpleDateFormat;
import java.util.*;

import constants.Status;
import task.Task;

/**
 * main class
 * @author user
 *
 */
public class Main {
	public static List<Task> tasks =new ArrayList<Task>();
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
			System.out.println("What next \n 1. Enter task \n 2. View cur1rent tasks \n 3. Delete task \n 4. Search task \n 5. Exit) ");
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
	            	searchTask();
	            	break;
	            case 5:
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
	            	task.setStatus(Status.NEW);
	                break;
	            case 2:
	            	task.setStatus(Status.IN_PROGRESS);
	                break;
	            case 3:
	            	task.setStatus(Status.COMPLETED);
	                break;
	            default:
	            	task.setStatus(Status.NEW);

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
        
         System.out.println("Description : ");
         task.setDescription(readFromUser());
         
         getChoice();
       
         System.out.println("Task added successfully");
         addToTodoList(task);        

	 }
	 
	 private static String readFromUser() {
	        return input.nextLine();
	    }
	 
	 
	 private static void addToTodoList(Task item) {
	        tasks.add(item);
	    }
	 
	 /**
	  * viewTask method that displays the currently available tasks
	  */
	 private static void printList() {
	        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM/dd");
	        Calendar currentDate = Calendar.getInstance();
	        System.out.println("List's Date: " + simpleDate.format(currentDate.getTime()));

	        for (int listSize = 0; listSize != tasks.size(); listSize++) { 

	            System.out.println(listSize + 1 + ". " + tasks.get(listSize).getName() + ", " + tasks.get(listSize).getDescription()+ ", " + tasks.get(listSize).getStatus());
	        }
	    }
	 
	 private static void deleteTask() {
		 printList();
		 
		 System.out.println("Enter number of task to delete");
		 
		 tasks.remove(Integer.parseInt(readFromUser()));
		 
		 printList();

	 }
	 private static void searchTask() {
		 
		 System.out.println("Enter task to be searched");

		 String word = readFromUser();
		 for (int listSize = 0; listSize != tasks.size(); listSize++) { 
			 if(tasks.get(listSize).getName().compareToIgnoreCase(word) == 0){
				 System.out.println(listSize + 1 +"." +tasks.get(listSize).getName());
			 }
		 }
		 
	 }
	 
	 } 


