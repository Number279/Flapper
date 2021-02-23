package com.tts.review.controller;

import com.tts.review.model.User;
import com.tts.review.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AuthorizationController {

    private UserService userService;

    public AuthorizationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/signup")
    public String createNewUser(@Valid User user,
                                BindingResult bindingResult,
                                Model model) {

        User userExists = userService.findByUsername(user.getUsername());

        if (userExists != null) {
            bindingResult.rejectValue("username",
                    "error.user",
                    "Username is already taken");
        }

        if (!bindingResult.hasErrors()) {
            userService.saveNewUser(user);
            model.addAttribute("success",
                    "Sign up successful!");
            model.addAttribute("user", new User());
        }

        return "registration";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET, path = "/login")
//    public String login() {
//        return "login";
//    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}

//    @GetMapping("/login")
//    public String loginPage(Model model, @RequestParam(value = "error",
//            required = false) Boolean error ){
//        if (error == null) {
//            Login login = new Login();
//            model.addAttribute("login", login);
//        } else {
//            model.addAttribute("loginError", true);
//        }
//        return "login";
//    }
//}
