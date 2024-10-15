package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.entity.Video;

public interface IVideoDao {
	List<Video> findAll();
    Video findById(String videoId);
    Video save(Video video);
    void deleteById(String videoId);
    List<Video> searchByTitle(String keyword);
}
