package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.repository.CourseDao;
import peaksoft.entity.Course;
import peaksoft.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao;

    @Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> getAllCourse(Long id) {
        return courseDao.getAllCourse(id);
    }

    @Override
    public void addCourse(Course course, Long id) {
        courseDao.addCourse(course, id);
    }

    @Override
    public Course getById(Long id) {
        return courseDao.getById(id);
    }

    @Override
    public void updateCourse(Long id, Course course){
        courseDao.updateCourse(id, course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseDao.deleteCourse(id);
    }
}
