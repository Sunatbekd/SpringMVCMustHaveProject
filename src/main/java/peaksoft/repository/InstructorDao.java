package peaksoft.repository;

import peaksoft.entity.Instructor;

import java.util.List;

public interface InstructorDao {
    List<Instructor> getAllInstructorsByCompany(Long companyId);
    void addInstructor(Long id,Instructor instructor);
    Instructor getInstructorById(Long id);
    void updateInstructor(Long id,Instructor instructor);
    void deleteInstructor(Long instructorId);
    void assignedInstructorToCourse(Long instructorID, Long courseID);
}
