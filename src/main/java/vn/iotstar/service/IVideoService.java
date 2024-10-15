package vn.iotstar.service;

import java.util.List;

import vn.iotstar.entity.Video;

public interface IVideoService {
    List<Video> getAllVideos();
    Video getVideoById(String videoId);
    Video saveVideo(Video video);
    void deleteVideo(String videoId);
    List<Video> searchVideos(String keyword);
}
