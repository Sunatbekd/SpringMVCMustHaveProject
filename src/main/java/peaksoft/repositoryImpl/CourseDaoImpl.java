package peaksoft.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.entity.Instructor;
import peaksoft.repository.CourseDao;
import peaksoft.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseDaoImpl implements CourseDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Course> getAllCourse(Long id) {
        return manager.createQuery("select c from Course c where c.company.id = : id",Course.class)
                .setParameter("id",id).getResultList();
    }

    @Override
    public void addCourse(Course course, Long id) {
        Company company = manager.find(Company.class,id);
        company.addCourses(course);
        course.setCompany(company);
        manager.merge(course);
    }

    @Override
    public Course getById(Long id) {
        return manager.find(Course.class, id);
    }

    @Override
    public void updateCourse(Long id, Course course) {
        Course course1 = manager.find(Course.class, id);
        course1.setCourseName(course.getCourseName());
        course1.setDurationInMonth(course.getDurationInMonth());
        course1.setDescription(course.getDescription());
        course1.setDateOfStart(course.getDateOfStart());
        manager.merge(course1);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = manager.find(Course.class, id);
        for (Instructor c : course.getInstructors()) {
            c.setCourses(null);
        }
        course.setCompany(null);
        manager.remove(course);
    }
}
