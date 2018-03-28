package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.PetService;

@RestController
@RequestMapping(value = "/pets")
public class PetController {

    @Autowired
    @Qualifier("petService")
    private PetService petService;

}
