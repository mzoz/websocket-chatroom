package edu.udacity.java.nano.chatroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;

@SpringBootApplication
@RestController
public class ChatroomApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatroomApplication.class, args);
    }

    /**
     * Login Page
     */
    @GetMapping("/")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    /**
     * Chatroom Page
     */
    @PostMapping("/")
    public ModelAndView index(@RequestParam("username") String username,
                              HttpServletRequest request) throws UnknownHostException {
        ModelAndView mav = new ModelAndView("/chat");
        mav.addObject("username", username);
        return mav;
    }
}
