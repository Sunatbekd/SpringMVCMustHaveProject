package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Task;
import peaksoft.repository.TaskDao;
import peaksoft.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskDao taskDao;

    @Autowired
    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public List<Task> getAllTask(Long lessonId) {
        return taskDao.getAllTask(lessonId);
    }

    @Override
    public void addTasks(Long lessonId, Task task) {
        taskDao.addTasks(lessonId, task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskDao.getTaskById(id);
    }

    @Override
    public void updateTask(Long taskId, Task task) {
        taskDao.updateTask(taskId, task);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskDao.deleteTask(taskId);
    }
}
