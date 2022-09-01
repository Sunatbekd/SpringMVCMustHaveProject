package peaksoft.repository;

import peaksoft.entity.Video;

import java.util.List;

public interface VideoDao {
    List<Video> getAllVideo(Long lessonId);
    void addVideo(Long lessonId,Video video);
    Video getVideoById(Long id);
    void updateVideo(Long videoId,Video video);
    void deleteVideo(Long videoId);
}
