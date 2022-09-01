package peaksoft.service;

import peaksoft.entity.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructorsByCompany(Long companyId);
    void addInstructor(Long id,Instructor instructor);
    Instructor getInstructorById(Long id);
    void updateInstructor(Long id,Instructor instructor);
    void deleteInstructor(Long instructorId);
    void assignedInstructorToCourse(Long instructorID, Long courseID);
}
