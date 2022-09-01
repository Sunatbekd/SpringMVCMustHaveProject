package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Lesson;
import peaksoft.repository.LessonDao;
import peaksoft.service.LessonService;

import java.util.List;
@Service
public class LessonServiceImpl implements LessonService {

    private final LessonDao lessonDao;
@Autowired
    public LessonServiceImpl(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }

    @Override
    public List<Lesson> getAllLesson(Long courseId) {
        return lessonDao.getAllLesson(courseId);
    }

    @Override
    public void addLesson(Long id, Lesson lesson) {
lessonDao.addLesson(id, lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonDao.getLessonById(id);
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
lessonDao.updateLesson(id, lesson);
    }

    @Override
    public void deleteLesson(Long id) {
lessonDao.deleteLesson(id);
    }
}
