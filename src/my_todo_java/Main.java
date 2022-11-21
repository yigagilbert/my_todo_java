
package my_todo_java;

import java.util.*;

import task.Task;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < 3; i++) {
			int taskNumber= 0;
		System.out.println("\t\t.....ToDo Manager.....\t\t");
		
		String[][] myTasks = new String[3][];
        Task task = new Task();
        
        System.out.println("What next \n 1. Enter task \n 2. View current tasks \n 3. Exit) ");
        int step = input.nextInt();
        switch (step) {
            case 1:
            	
            	System.out.println("Please Enter task title : ");
//                String name = input.nextLine();
                task.setName(input.nextLine());
                
                System.out.println("Description : ");
//                String description = input.nextLine();
                task.setDescription(input.nextLine());
                
                task.getChoice();
                
                System.out.println("Name \t Description \t Status");
                System.out.println(task.getName()+"\t"+task.getDescription()+"\t"+task.getStatus());
                
                myTasks[taskNumber] = task.getTask();
                taskNumber+=1;
                break;
            case 2:
            	for (int k = 0; k < taskNumber; k++){
            		for (int j = 0; j < 3; j++){
            	        System.out.println(myTasks[k][j]);
            		}
            	}
                break;
            case 3:
                break;
        }
        
        
        
//        System.out.println( Arrays.toString( myTasks[i] ));
		}
        input.close();
	}

}
