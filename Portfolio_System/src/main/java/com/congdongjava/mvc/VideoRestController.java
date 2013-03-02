package com.congdongjava.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.congdongjava.domain.Video;
import com.congdongjava.repo.VideoDao;

@Controller
@RequestMapping("/rest/videos")
public class VideoRestController {
	@Autowired
    private VideoDao videoDao;

    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Video> listAllVideos()
    {
        return videoDao.findAllOrderedByDate();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Video lookupVideoById(@PathVariable("id") Long id)
    {
        return videoDao.findById(id);
    }
}
