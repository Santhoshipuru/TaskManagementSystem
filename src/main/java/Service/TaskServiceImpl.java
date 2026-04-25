package Service;

import java.util.List;

import DAO.TaskDaoImpl;
import Model.Task;

public class TaskServiceImpl implements TaskService {

    TaskDaoImpl dao = new TaskDaoImpl();

    @Override
    public int addTask(Task task) {
        return dao.addTask(task);
    }

    @Override
    public Task getTask(int id) {
        return dao.getTask(id);
    }

    @Override
    public Task updateTask(int id, Task task) {
        return dao.updateTask(id, task);
    }

    @Override
    public void deleteTask(int id) {
        dao.deleteTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return dao.getAllTasks();
    }
}