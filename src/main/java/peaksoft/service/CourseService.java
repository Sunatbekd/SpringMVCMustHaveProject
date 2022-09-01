package peaksoft.service;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse(Long id);
    void addCourse( Course course,Long companyId);
    Course getById(Long id);
    void updateCourse(Long id,Course course);
    void deleteCourse(Long id);
}
