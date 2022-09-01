package peaksoft.repository;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseDao {
    List<Course> getAllCourse(Long id);
    void addCourse(Course course,Long id);
    Course getById(Long id);
    void updateCourse(Long id,Course course);
    void deleteCourse(Long id);
}
