package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Instructor;
import peaksoft.repository.InstructorDao;
import peaksoft.service.InstructorService;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorDao instructorDao;

    @Autowired
    public InstructorServiceImpl(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }

    @Override
    public List<Instructor> getAllInstructorsByCompany(Long companyId) {
        return instructorDao.getAllInstructorsByCompany(companyId);
    }

    @Override
    public void addInstructor(Long id, Instructor instructor) {
        instructorDao.addInstructor(id, instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorDao.getInstructorById(id);
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        instructorDao.updateInstructor(id, instructor);
    }

    @Override
    public void deleteInstructor(Long instructorId) {
        instructorDao.deleteInstructor(instructorId);
    }

    @Override
    public void assignedInstructorToCourse(Long instructorID, Long courseID) {
        instructorDao.assignedInstructorToCourse(instructorID, courseID);
    }
}
