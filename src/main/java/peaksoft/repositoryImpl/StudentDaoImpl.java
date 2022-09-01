package peaksoft.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Course;
import peaksoft.entity.Student;
import peaksoft.repository.StudentDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudent(Long courseId) {
        return entityManager.createQuery("select s from Student s where s.course.id =: id", Student.class)
                .setParameter("id",courseId).getResultList();
    }

    @Override
    public void addStudent(Long courseId, Student student) {
        Course course = entityManager.find(Course.class,courseId);
        course.addStudent(student);
        student.setCourse(course);
        entityManager.persist(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void updateStudent(Long id, Student student) {
        Student student1 = entityManager.find(Student.class,id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setPhoneNumber(student.getPhoneNumber());
        student1.setStudyFormat(student.getStudyFormat());
        entityManager.merge(student1);
    }

    @Override
    public void deleteStudent(Long id) {
        entityManager.remove(entityManager.find(Student.class,id));
    }
}
