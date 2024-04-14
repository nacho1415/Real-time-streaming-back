package com.example.realtimestreaming.Controller;

import com.example.realtimestreaming.Domain.User;
import com.example.realtimestreaming.Dto.User.SignupDto;
import com.example.realtimestreaming.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup (@RequestBody SignupDto signupDto) {
        User user = userService.signup(signupDto);
        return ResponseEntity.ok(user);
    }
}
