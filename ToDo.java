import java.util.*;
public class ToDo {
    public static void main(String[] args) {
        System.out.println("\t\t.....ToDo Manager.....\t\t");
        Tasks task = new Tasks();
        String[] tasks = task.printTask();
        System.out.println("Title \t Description \t Status");
        System.out.println(tasks[0]+"\t"+tasks[1]+"\t"+tasks[2]);
    }
}

class Tasks {
    public String[] printTask() {
        enum choices {
            NEW, INPROGRESS, COMPLETED
        }
        String title, desc,st;
        int status;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter task title : ");
        title = sc.nextLine();
        System.out.println("Description : ");
        desc = sc.nextLine();
        System.out.println("Task status \n 1. New \n 2. Inprogress \n 3. Completed) ");
        status = sc.nextInt();
        switch (status) {
            case 1:
                st = choices.NEW.toString();
                break;
            case 2:
                st = choices.INPROGRESS.toString();
                break;
            case 3:
                st = choices.COMPLETED.toString();
                break;
            default:
                st = choices.NEW.toString();
                break;
        }
        String[] data = { title, desc, st };
        sc.close();
        return data;
    }
}