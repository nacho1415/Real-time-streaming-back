package com.example.realtimestreaming.Dto.Request.User;

import lombok.Data;

@Data
public class SignupDto {

    private String email;

    private String password;

    private String nickname;
}
