package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.TagService;

@RestController
@RequestMapping(value = "/tags")
public class TagController {

    @Autowired
    @Qualifier("tagService")
    private TagService tagService;

}
