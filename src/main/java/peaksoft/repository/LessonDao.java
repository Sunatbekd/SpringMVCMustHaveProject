package peaksoft.repository;

import peaksoft.entity.Lesson;

import java.util.List;

public interface LessonDao {
    List<Lesson> getAllLesson(Long courseId);
    void addLesson(Long id,Lesson lesson);
    Lesson getLessonById(Long id);
    void updateLesson(Long id,Lesson lesson);
    void deleteLesson(Long id);
}
