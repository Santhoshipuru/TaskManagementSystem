package Service;

import java.util.List;
import Model.Task;

public interface TaskService {

    int addTask(Task task);

    Task getTask(int id);

    Task updateTask(int id, Task task);

    void deleteTask(int id);

    List<Task> getAllTasks();
}