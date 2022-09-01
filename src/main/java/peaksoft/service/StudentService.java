package peaksoft.service;

import peaksoft.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent(Long courseId);
    void addStudent(Long courseId,Student student);
    Student getStudentById(Long id);
    void updateStudent(Long id,Student student);
    void deleteStudent(Long id);
}
