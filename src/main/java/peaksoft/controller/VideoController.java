package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Video;
import peaksoft.service.VideoService;

@Controller
@RequestMapping("/videos")
public class VideoController {

    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/getAllVideos/{lessonId}")
    public String getAllVideo(@PathVariable("lessonId") Long lessonId, Model model) {
        model.addAttribute("allVideo", videoService.getAllVideo(lessonId));
        model.addAttribute("id", lessonId);
        return "/video/videos";
    }

    @GetMapping("/addVideo/{lessonId}")
    public String addVideo(@PathVariable("lessonId") Long id, Model model) {
        model.addAttribute("video", new Video());
        model.addAttribute("id", id);
        return "/video/addVideo";
    }

    @PostMapping("/saveVideo/{lessonId}")
    public String saveVideo(@PathVariable("lessonId") Long id,
                            @ModelAttribute("video") Video video) {
        videoService.addVideo(id, video);
        return "redirect:/videos/getAllVideos/" + id;
    }

    @GetMapping("/updateVideo/{videoId}")
    public String updateVideo(@PathVariable("videoId") Long id, Model model) {
        Video video = videoService.getVideoById(id);
        model.addAttribute("video", video);
        model.addAttribute("lessonId", video.getLesson().getId());
        return "/video/updateVideo";
    }

    @PostMapping("/saveUpdateVideo/{lessonId}/{videoId}")
    public String saveUpdateVideo(@PathVariable("videoId") Long videoId,
                                  @ModelAttribute("video") Video video,
                                  @PathVariable("lessonId")Long id) {
        videoService.updateVideo(videoId, video);
        return "redirect:/videos/getAllVideos/ " + id;
    }

    @RequestMapping("/deleteVideo/{lessonId}/{videoId}")
    public String deleteVideo(@PathVariable("lessonId") Long id, @PathVariable("videoId") Long videoId) {
        videoService.deleteVideo(videoId);
        return "redirect:/videos/getAllVideos/ " + id;
    }

}
