package com.congdongjava.repo;

import java.util.List;

import com.congdongjava.domain.Video;

public interface VideoDao extends BaseDao<Long, Video>{
	public List<Video> findByName(final String name);
	
	public Video findByCode(final String code);
	
	public List<Video> findAllOrderedByDate();
}
