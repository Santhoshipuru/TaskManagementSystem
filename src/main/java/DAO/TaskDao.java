package DAO;

import java.util.List;
import Model.Task;

public interface TaskDao {

    int addTask(Task task);

    int updateTask(int id, Task task);

    Task getTask(int id);

    void deleteTask(int id);

    List<Task> getAllTasks();
}