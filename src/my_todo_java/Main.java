
package my_todo_java;

import task.Task;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\t\t.....ToDo Manager.....\t\t");
        Task task = new Task();
        String[] tasks = task.printTask();
        System.out.println("Name \t Description \t Status");
        System.out.println(tasks[0]+"\t"+tasks[1]+"\t"+tasks[2]);
	}

}
