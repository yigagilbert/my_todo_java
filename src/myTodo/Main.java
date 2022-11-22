
package myTodo;

import java.util.*;

import constants.Choice;
import task.Task;


public class Main {
	
	public static ArrayList<String> tasks =new ArrayList<String>();
	public static Task task = new Task();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		while(true) {
			
		System.out.println("\t\t.....ToDo Manager.....\t\t");
        
        System.out.println("What next \n 1. Enter task \n 2. View cur1rent tasks \n 3. Exit) ");
        int step = input.nextInt();
        switch (step) {
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
	}
	
	 public static void getChoice() {
		 int statusValue;
		 
	        try (Scanner input = new Scanner(System.in)) {
				System.out.println("Task status \n 1. New \n 2. Inprogress \n 3. Completed) ");
				statusValue = input.nextInt();
			}
	        switch (statusValue) {
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
	 
	 
	 public static void enterTask() {
		 Scanner input = new Scanner(System.in);
		 System.out.println("Please Enter task title : ");
//       String name = input.nextLine();
       task.setName(input.next());
       
       System.out.println("Description : ");
//       String description = input.nextLine();
       task.setDescription(input.next());
       
       getChoice();
       
       System.out.println("Name \t Description \t Status");
       System.out.println(task.getName()+"\t"+task.getDescription()+"\t"+task.getStatus());
       
      input.close();
	 }
	 
	 
	 
	 public static void viewTasks() {
		 
	 }

}
