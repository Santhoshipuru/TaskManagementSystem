package DAO;

import java.util.*;

import Model.Task;

public class TaskDaoImpl {

    private static Map<Integer, Task> tasks = new HashMap<>();
    private static int id = 100;

    public int addTask(Task task) {
        task.setId(++id);
        tasks.put(id, task);
        return id;
    }

    public Task getTask(int id) {
        return tasks.get(id);
    }

    public Task updateTask(int id, Task task) {
        task.setId(id);
        return tasks.put(id, task);
    }

    public void deleteTask(int id) {
        tasks.remove(id);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }
}