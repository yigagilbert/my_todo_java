
package my_todo_java;

import java.util.*;

import task.Task;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		for(int i = 0; i <= 2; i++) {
		System.out.println("\t\t.....ToDo Manager.....\t\t");
        Task task = new Task();
        
        System.out.println("Name \t Description \t Status");
        
        System.out.println("Please Enter task title : ");
        task.setName(input.nextLine());
        
        System.out.println("Description : ");
        task.setDescription(input.nextLine());
        
//        String[] tasks = task.printTask();
        System.out.println(task.getName()+"\t"+task.getDescription()+"\t"+task.getStatus());

        String[][] myTasks = new String[3][];
        
        myTasks[i] = task.printTask();
        
        System.out.println( Arrays.toString( myTasks ));
		}
        input.close();
	}

}
