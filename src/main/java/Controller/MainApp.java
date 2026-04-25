package Controller;

import java.util.List;
import java.util.Scanner;

import Model.Task;
import Service.TaskService;
import Service.TaskServiceImpl;

public class MainApp {

    public static void main(String[] args) {

        TaskService service = new TaskServiceImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- TASK MANAGER ---");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Get Task By ID");
            System.out.println("4. Update Task");
            System.out.println("5. Delete Task");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:
                System.out.print("Enter title: ");
                String title = sc.nextLine();

                System.out.print("Enter description: ");
                String desc = sc.nextLine();

                System.out.print("Enter status: ");
                String status = sc.nextLine();

                int id = service.addTask(new Task(title, desc, status));
                System.out.println("Task added with ID: " + id);
                break;

            case 2:
                List<Task> all = service.getAllTasks();

                if (all.isEmpty()) {
                    System.out.println("No tasks found!");
                } else {
                    for (Task t : all) {
                        System.out.println(t);
                    }
                }
                break;

            case 3:
                System.out.print("Enter ID: ");
                int getId = sc.nextInt();

                Task task = service.getTask(getId);

                if (task != null) {
                    System.out.println(task);
                } else {
                    System.out.println("Task not found!");
                }
                break;

            case 4:
                System.out.print("Enter ID: ");
                int uid = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter new title: ");
                String utitle = sc.nextLine();

                System.out.print("Enter new description: ");
                String udesc = sc.nextLine();

                System.out.print("Enter new status: ");
                String ustatus = sc.nextLine();

                service.updateTask(uid, new Task(utitle, udesc, ustatus));
                System.out.println("Task updated!");
                break;

            case 5:
                System.out.print("Enter ID to delete: ");
                int did = sc.nextInt();

                service.deleteTask(did);
                System.out.println("Task deleted!");
                break;

            case 6:
                System.out.println("Exited!");
                System.exit(0);
            }
        }
    }
}