package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Video;
import peaksoft.repository.VideoDao;
import peaksoft.service.VideoService;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoDao videoDao;

    @Autowired
    public VideoServiceImpl(VideoDao videoDao) {
        this.videoDao = videoDao;
    }

    @Override
    public List<Video> getAllVideo(Long lessonId) {
        return videoDao.getAllVideo(lessonId);
    }

    @Override
    public void addVideo(Long lessonId, Video video) {
        videoDao.addVideo(lessonId, video);
    }

    @Override
    public Video getVideoById(Long id) {
        return videoDao.getVideoById(id);
    }

    @Override
    public void updateVideo(Long videoId, Video video) {
        videoDao.updateVideo(videoId, video);
    }

    @Override
    public void deleteVideo(Long videoId) {
        videoDao.deleteVideo(videoId);
    }
}
