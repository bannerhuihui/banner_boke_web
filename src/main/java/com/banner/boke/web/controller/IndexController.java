package com.banner.boke.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/home")
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/index.do",method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView){
        LOGGER.info("进入index方法！");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
