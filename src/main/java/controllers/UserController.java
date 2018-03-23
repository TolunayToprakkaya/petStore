package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import services.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;


}
