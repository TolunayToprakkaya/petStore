package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import services.CategoryService;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

}
