
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
	
	public static Scanner input = new Scanner(System.in);
	public static String myName;

	/**
	 * driver method.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("\t\t.....ToDo Manager.....\t\t");
		System.out.println("Enter your name:");
//		task.setTaskBy(readFromUser()); 
		myName = readFromUser();
 
	
		/**
		 * infinity loop that allows
		 * user decide weather enter new task,
		 * view tasks or even exit program. 
		 */
		while(true) {
			System.out.println("What next \n 1. Enter task \n 2. View current tasks \n 3. Delete task \n 4. Search task \n 5. Empty list \n 6. Exit) ");
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
	            	deleteTasks();
	            	break;
	            case 6:
	            	System.out.println("BYE BYE " + myName);
	            	System.exit(0);
	        }
	      
		}
		
		
		  
	}
	/**
	 * getChoice method
	 * allows user select the status of the task
	 */
	private static void getChoice(Task theTask) {
		 
				System.out.println("Task status \n 1. New \n 2. Inprogress \n 3. Completed ");
			
	        switch (Integer.parseInt(readFromUser())) {
	            case 1:
	            	theTask.setStatus(Status.NEW);
	                break;
	            case 2:
	            	theTask.setStatus(Status.IN_PROGRESS);
	                break;
	            case 3:
	            	theTask.setStatus(Status.COMPLETED);
	                break;
	            default:
	            	theTask.setStatus(Status.NEW);

	                break;
	        }
	      
	       
	    }
	 
	 /**
	  * enterTask method
	  * allows the user to add new task. 
	  */
	 private static void enterTask() {
		 Task task1 = new Task();
		 System.out.println("Please Enter task title : ");
		 task1.setName(readFromUser());       
        
         System.out.println("Description : ");
         task1.setDescription(readFromUser());
         
         task1.setCreatedAt(myName);
         
         task1.setTaskBy(myName);
         
         getChoice(task1);
       
         System.out.println("Task added successfully");
         
         addToTodoList(task1);
         

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
	        System.out.println("List Created on: " + simpleDate.format(currentDate.getTime()) + "by" + myName);

	        if(tasks.isEmpty()){
	            System.out.println("No tasks added yet!");
	        }
	        else{
	            System.out.println("ID \t\t Title \t\t\t Description \t\t\t Status");
	            for (Task tak: tasks ) {
	                System.out.println((tasks.indexOf(tak) + 1)+"\t\t"+tak.getName()+"\t\t" + tak.getDescription()+"\t\t" + tak.getStatus());
	            }

	        }
	    }
	 
	 private static void deleteTask() {
		 printList();
		 
		 System.out.println("Enter number of task to delete");
		 
		 tasks.remove(Integer.parseInt(readFromUser())-1);
		 
		 printList();

	 }

	 // method for searching for particular tasks
	    private static void searchTask(){
	        System.out.println("Enter task name or discription");
	        String searchString = readFromUser();
	        for (Task tak: tasks) {
	            if(searchString.equals(tak.getName()) || searchString.equals(tak.getStatus().toString()) || searchString.equals(tak.getDescription())){
	                System.out.println((tasks.indexOf(tak) + 1)+"\t\t"+tak.getName()+"\t\t" + tak.getDescription()+"\t\t" + tak.getStatus()
	                        + "\t\t Created By :" + tak.getTaskBy()); // + "\t\tTime Created :" + tak.getCreatedAt());
	            }
	        }
	        
	        
	    }
	    
	    
	    private static void deleteTasks(){
	        if(tasks.isEmpty()){
	            System.out.println("task list is currently empty");
	        }else {
	            tasks.clear();
	        }
	    }
}
	 
	 


