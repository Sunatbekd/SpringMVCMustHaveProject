package peaksoft.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.repository.InstructorDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class InstructorDaoImpl implements InstructorDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Instructor> getAllInstructorsByCompany(Long id) {

        return entityManager.createQuery("select i from Instructor i where i.company.id =: id", Instructor.class)
                .setParameter("id",id).getResultList();
    }

    @Override
    public void addInstructor(Long id, Instructor instructor) {
        Company company = entityManager.find(Company.class,id);
        company.addInstructor(instructor);
        instructor.setCompany(company);
        entityManager.merge(instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        Instructor instructor1 = entityManager.find(Instructor.class,id);
        instructor1.setFirstName(instructor.getFirstName());
        instructor1.setLastName(instructor.getLastName());
        instructor1.setPhoneNumber(instructor.getPhoneNumber());
        instructor1.setSpecialization(instructor.getSpecialization());
        entityManager.merge(instructor1);
    }

    @Override
    public void deleteInstructor(Long instructorId) {
        Instructor instructor = entityManager.find(Instructor.class,instructorId);
        for (Course course:instructor.getCourses()){
            course.setInstructors(null);
        }
        entityManager.remove(instructor);
    }

    @Override
    public void assignedInstructorToCourse(Long instructorID, Long courseID) {
        Instructor instructor = entityManager.find(Instructor.class, instructorID);
        Course course = entityManager.find(Course.class, courseID);
        instructor.addCourse(course);
        course.addInstructor(instructor);
        entityManager.merge(instructor);
        entityManager.merge(course);
    }
}
