package peaksoft.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Lesson;
import peaksoft.entity.Video;
import peaksoft.repository.VideoDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class VideoDaoImpl implements VideoDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Video> getAllVideo(Long lessonId) {
        return entityManager.createQuery("select v from Video v where v.lesson.id =: lessonId ", Video.class)
                .setParameter("lessonId", lessonId).getResultList();
    }

    @Override
    public void addVideo(Long lessonId, Video video) {
        Lesson lesson = entityManager.find(Lesson.class,lessonId);
        lesson.setVideo(video);
        video.setLesson(lesson);
        entityManager.persist(video);
    }

    @Override
    public Video getVideoById(Long id) {
        return entityManager.find(Video.class, id);
    }

    @Override
    public void updateVideo(Long videoId, Video video) {
        Video video1 = entityManager.find(Video.class,videoId);
        video1.setVodeoName(video.getVodeoName());
        video1.setVideoLink(video.getVideoLink());
        entityManager.merge(video1);
    }

    @Override
    public void deleteVideo(Long videoId) {
        Video video = entityManager.find(Video.class,videoId);
        video.setLesson(null);
        entityManager.remove(video);
    }
}
