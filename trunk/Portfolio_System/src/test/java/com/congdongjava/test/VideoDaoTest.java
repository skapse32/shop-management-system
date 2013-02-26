package com.congdongjava.test;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.congdongjava.domain.Video;
import com.congdongjava.repo.VideoDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class VideoDaoTest {
	
	@Autowired
	private VideoDao videoDao;
	
    @Test
    public void testFindById()
    {
        Video video = videoDao.findById(0l);

        Assert.assertEquals("saRG2fsSF2", video.getCode());
        Assert.assertEquals("One Piece 200", video.getName());
        Assert.assertEquals("www.google.com.vn", video.getLinkValue());
        return;
    }
    
    @Test
    public void testFindByCode()
    {
        Video video = videoDao.findByCode("saRG2fsSF2");

        Assert.assertEquals("saRG2fsSF2", video.getCode());
        Assert.assertEquals("One Piece 200", video.getName());
        Assert.assertEquals("www.google.com.vn", video.getLinkValue());
        return;
    }
    
    @Test
    public void testInsertUpdateDelete(){
    	Video video = new Video();
    	video.setCode("saRG2fsSF3");
    	video.setLinkValue("http://www.google.com.vn");
    	video.setName("One Piece 300");
    	video.setViewCount(0l);
    	video.setCreationDate(new Date());
    	//
    	videoDao.create(video);
        Long id = video.getVideoId();
        Assert.assertNotNull(id);
        //Assert.assertEquals(2, video.findAllOrderedByName().size());
        Video newVideo = videoDao.findById(id);
        Assert.assertEquals("saRG2fsSF3", newVideo.getCode());
        Assert.assertEquals("One Piece 300", newVideo.getName());
        Assert.assertEquals("http://www.google.com.vn", newVideo.getLinkValue());
        
        //Update
        newVideo.setName("One Piece 301");
        newVideo.setLinkValue("http://www.google.com");
        videoDao.update(newVideo);
        newVideo = videoDao.findById(id);
        Assert.assertEquals("saRG2fsSF3", newVideo.getCode());
        Assert.assertEquals("One Piece 301", newVideo.getName());
        Assert.assertEquals("http://www.google.com", newVideo.getLinkValue());
        
        //Delete
        videoDao.deleteById(id);
        newVideo = videoDao.findById(id);
        Assert.assertEquals(null, newVideo);      
    }
    
    @Test
    public void testFindAllOrderedByDate(){
    	Video video = new Video();
    	video.setCode("saRG2fsSF4");
    	video.setLinkValue("http://yahoo.com.vn");
    	video.setName("Naruto 203");
    	video.setCreationDate(new Date());
    	video.setViewCount(0l);
    	videoDao.create(video);
    	
        List<Video> videos = videoDao.findAllOrderedByDate();
        Assert.assertEquals(2, videos.size());
        Video newVideo = videos.get(0);

        Assert.assertEquals("saRG2fsSF4", newVideo.getCode());
        Assert.assertEquals("Naruto 203", newVideo.getName());
        Assert.assertEquals("http://yahoo.com.vn", newVideo.getLinkValue());
        return;
    }

}
