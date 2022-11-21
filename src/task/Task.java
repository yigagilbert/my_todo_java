package task;
import java.util.*;

import constants.choice;

public class Task {
	String name, description,status;
	int statusValue;
	
	 public void getChoice() {
	        	        
	        Scanner input = new Scanner(System.in);
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
	       
	    }
	 public String[] getTask() {
		 String[] data = { name, description, status };
//	        input.close();
	        return data;
		 
	 }
	 
	 public String getName(){
			return name;
		}

	public void setName(String name){
			this.name = name;
		}

	public String getDescription(){
			return description;
		}

	public void setDescription(String description){
			this.description = description;
		}

	public String getStatus(){
			return status;
		}

	public void setStatus(String status){
			this.status = status;
		}
//	public String[] getTask(){
//		return data;
//	}


}
