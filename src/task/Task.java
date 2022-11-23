package task;
import constants.Status;
/**
 * 
 * the task class holds the attributes of the tasks
 *
 */
public class Task {
	/**
	 * name of the task
	 */
	private String name; 
	/**
	 * more details about the task
	 */
	private String description;
	/**
	 * the status of the task at current state
	 */
	private Status status;
	
	/**
	 * getName method 
	 * @return 
	 */
	 public String getName(){
		 /**
		  * returns task name
		  */
			return name;
		}

	 /**
		 * setName method 
		 * @return 
		 */
	 public void setName(String name){
			this.name = name;
		}

	/**
	 * getDescription method 
	 * @return 
	 */
	public String getDescription(){
			return description;
		}

	/**
	 * setDescription method 
	 * @return 
	 */
	public void setDescription(String description){
			this.description = description;
		}

	/**
	 * getStatus method 
	 * @return 
	 */
	public Status getStatus(){
			return status;
		}

	/**
	 * setStatus method 
	 * @return 
	 */
	public void setStatus(Status status){
			this.status = status;
		}
}
