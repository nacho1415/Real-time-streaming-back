package com.example.realtimestreaming.Service;

import com.example.realtimestreaming.Domain.User;
import com.example.realtimestreaming.Dto.Request.User.SignupDto;
import com.example.realtimestreaming.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public User signup (SignupDto signupDto) {
        User user = new User();
        user.setEmail(signupDto.getEmail());
        user.setPassword(signupDto.getPassword());
        user.setNickname(signupDto.getNickname());
        userRepository.save(user);
        return user;
    }
}
