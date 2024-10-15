package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.IVideoDao;
import vn.iotstar.dao.impl.VideoDao;
import vn.iotstar.entity.Video;
import vn.iotstar.service.IVideoService;

public class VideoService implements IVideoService {

    private IVideoDao videoDao = new VideoDao();

    @Override
    public List<Video> getAllVideos() {
        return videoDao.findAll();
    }

    @Override
    public Video getVideoById(String videoId) {
        return videoDao.findById(videoId);
    }

    @Override
    public Video saveVideo(Video video) {
        return videoDao.save(video);
    }

    @Override
    public void deleteVideo(String videoId) {
        videoDao.deleteById(videoId);
    }

    @Override
    public List<Video> searchVideos(String keyword) {
        return videoDao.searchByTitle(keyword);
    }
}
