package peaksoft.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import peaksoft.repository.TaskDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TaskDaoImpl implements TaskDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Task> getAllTask(Long lessonId) {
        return entityManager.createQuery("select t from Task t where t.lesson.id =: lessonId", Task.class)
                .setParameter("lessonId",lessonId).getResultList();
    }

    @Override
    public void addTasks(Long lessonId, Task task) {
        Lesson lesson = entityManager.find(Lesson.class,lessonId);
        lesson.addTask(task);
        task.setLesson(lesson);
        entityManager.persist(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public void updateTask(Long taskId, Task task) {
        Task task1 = entityManager.find(Task.class,taskId);
        task1.setTaskName(task.getTaskName());
        task1.setTaskText(task.getTaskText());
        task1.setDeadline(task.getDeadline());
        entityManager.merge(task1);
    }

    @Override
    public void deleteTask(Long taskId) {
        Task task = entityManager.find(Task.class,taskId);
        task.setLesson(null);
        entityManager.remove(task);
    }
}
