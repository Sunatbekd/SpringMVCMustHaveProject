package peaksoft.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;
import peaksoft.repository.LessonDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional

public class LessonDaoImpl implements LessonDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Lesson> getAllLesson(Long courseId) {
        return entityManager.createQuery("select l from Lesson l where l.course.id =: courseId", Lesson.class)
                .setParameter("courseId",courseId).getResultList();
    }

    @Override
    public void addLesson(Long id, Lesson lesson) {
        Course course = entityManager.find(Course.class,id);
        course.addLesson(lesson);
        lesson.setCourse(course);
        entityManager.persist(lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return entityManager.find(Lesson.class, id);
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
        Lesson lesson1 = entityManager.find(Lesson.class,id);
        lesson1.setLessonName(lesson.getLessonName());
        lesson1.setVideo(lesson.getVideo());
        entityManager.merge(lesson1);
    }

    @Override
    public void deleteLesson(Long id) {
        Lesson lesson = entityManager.find(Lesson.class,id);
        lesson.setCourse(null);
        entityManager.remove(lesson);
    }
}
