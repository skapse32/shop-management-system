package com.congdongjava.mvc;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.congdongjava.domain.Video;
import com.congdongjava.repo.VideoDao;

@Controller
@RequestMapping(value="/video")
public class VideoController {
	@Autowired
	private VideoDao videoDao;

    @RequestMapping(method=RequestMethod.GET)
    public String displaySortedVideos(Model model)
    {
        model.addAttribute("newVideo", new Video());
        model.addAttribute("videos", videoDao.findAllOrderedByDate());
        return "video";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String registerNewMember(@Valid @ModelAttribute("newVideo") Video newVideo, BindingResult result, Model model)
    {
        if (!result.hasErrors()) {
        	videoDao.create(newVideo);
            return "redirect:/";
        }
        else {
            model.addAttribute("videos", videoDao.findAllOrderedByDate());
            return "video";
        }
    }
}
