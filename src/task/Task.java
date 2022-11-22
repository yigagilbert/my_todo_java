package task;
import constants.Choice;

public class Task {
	private String name; 
	private String description;
	private Choice status;
	
	
	
	 public String[] getTask() {
		 String[] data = { name, description };
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

	public Choice getStatus(){
			return status;
		}

	public void setStatus(Choice status){
			this.status = status;
		}
//	public String[] getTask(){
//		return data;
//	}


}
