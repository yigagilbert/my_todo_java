
import java.util.*;
public class Todo {
    public static void main(String[] args) {
        System.out.println("\t\t.....ToDo Manager.....\t\t");
        Tasks task = new Tasks();
        String[] tasks = task.printTask();
        System.out.println("Name \t Description \t Status");
        System.out.println(tasks[0]+"\t"+tasks[1]+"\t"+tasks[2]);
    }
}

class Tasks {
    public String[] printTask() {
        enum choices {
            NEW, INPROGRESS, COMPLETED
        }
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
                status = choices.NEW.toString();
                break;
            case 2:
                status = choices.INPROGRESS.toString();
                break;
            case 3:
                status = choices.COMPLETED.toString();
                break;
            default:
                status = choices.NEW.toString();
                break;
        }
        String[] data = { name, description, status };
        input.close();
        return data;
    }
}