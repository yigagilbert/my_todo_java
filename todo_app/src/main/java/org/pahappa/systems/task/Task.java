/**
 * 
 */
/**
 * @author gilbert_yiga
 *
 */
package org.pahappa.systems.task;


import org.pahappa.systems.constants.Status;
/**
 * 
 * the task class holds the attributes of the tasks
 *
 */
public class Task {
	
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	 * the author of the task
	 */
	private String taskBy;
	/**
	 * the time at which the task was created
	 */
	private String createdAt;
	
	public String getTaskBy() {
		return taskBy;
	}

	public void setTaskBy(String taskBy) {
		this.taskBy = taskBy;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

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
