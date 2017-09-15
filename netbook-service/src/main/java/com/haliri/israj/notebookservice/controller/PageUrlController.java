package com.haliri.israj.notebookservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by israjhaliri on 9/1/17.
 */
@Controller
public class PageUrlController {

    @RequestMapping(value = "example", method = RequestMethod.GET)
    public String example(){
        return "example";
    }
}
