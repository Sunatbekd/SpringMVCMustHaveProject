package peaksoft.repository;

import peaksoft.entity.Task;

import java.util.List;

public interface TaskDao {
    List<Task> getAllTask(Long lessonId);
    void addTasks(Long lessonId, Task task);
    Task getTaskById(Long id);
    void updateTask(Long taskId,Task task);
    void deleteTask(Long taskId);
}
