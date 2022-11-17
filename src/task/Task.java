package task;
import java.util.*;

import constants.choice;

public class Task {
	
	 public String[] printTask() {
	        String name, description,status;
	        int statusValue;
	        Scanner input = new Scanner(System.in);
	        System.out.println("Please Enter task title : ");
	        name = input.nextLine();
	        System.out.println("Description : ");
	        description = input.nextLine();
	        System.out.println("Task status \n 1. New \n 2. Inprogress \n 3. Completed) ");
	        statusValue = input.nextInt();
	        switch (statusValue) {
	            case 1:
	                status = choice.NEW.toString();
	                break;
	            case 2:
	                status = choice.INPROGRESS.toString();
	                break;
	            case 3:
	                status = choice.COMPLETED.toString();
	                break;
	            default:
	                status = choice.NEW.toString();
	                break;
	        }
	        String[] data = { name, description, status };
	        input.close();
	        return data;
	    }

}
