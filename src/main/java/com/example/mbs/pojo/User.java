package com.example.mbs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String account;
    private String password;
    private String nickname;
    private String role;
    private int deptId;
    private String email;
    private String avatarUrl;
}
