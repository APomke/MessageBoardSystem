package com.example.mbs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
    private int commentId;
    private int messageId;
    private String commentUser;
    private String commentContent;
    private int commentLevel;
    private String commentTime;
}
