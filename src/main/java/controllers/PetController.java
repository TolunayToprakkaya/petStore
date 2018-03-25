package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import services.PetService;

@Controller
public class PetController {

    @Autowired
    private PetService petService;

}
