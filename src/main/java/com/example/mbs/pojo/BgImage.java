package com.example.mbs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BgImage {
    private int userId;
    private String userNickName;
    private String imagePath;
}
