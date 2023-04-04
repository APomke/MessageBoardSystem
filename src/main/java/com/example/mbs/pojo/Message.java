package com.example.mbs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private int id;
    private int masterId;
    private String topic;
    private String content;
    private int likes;
    private int typeId;
    private int comments;
    private String imagePath;
    private String time;
    private String userNickName;
}
