package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Student;
import peaksoft.repository.StudentDao;
import peaksoft.service.StudentService;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;
@Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudent(Long courseId) {
        return studentDao.getAllStudent(courseId);
    }

    @Override
    public void addStudent(Long courseId, Student student) {
studentDao.addStudent(courseId, student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public void updateStudent(Long id, Student student) {
studentDao.updateStudent(id, student);
    }

    @Override
    public void deleteStudent(Long id) {
studentDao.deleteStudent(id);
    }
}
