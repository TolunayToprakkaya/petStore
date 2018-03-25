package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import services.TagService;

@Controller
public class TagController {

    @Autowired
    private TagService tagService;

}
