package com.example.mbs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Comments {
    private int commentId;
    private int messageId;
    private int commentUserId;
    private String commentContent;
    private int commentLevel;
    private String commentTime;
    private String masterUrl;
    private int mainComments;
    private String userNickName;

    public Comments(int commentId, int messageId, int commentUserId, String commentContent, int commentLevel, String commentTime, String masterUrl, String userNickName) {
        this.commentId = commentId;
        this.messageId = messageId;
        this.commentUserId = commentUserId;
        this.commentContent = commentContent;
        this.commentLevel = commentLevel;
        this.commentTime = commentTime;
        this.masterUrl = masterUrl;
        this.userNickName = userNickName;
    }

    public Comments(int commentId, int messageId, int commentUserId, String commentContent, int commentLevel, String commentTime, String masterUrl, int mainComments, String userNickName) {
        this.commentId = commentId;
        this.messageId = messageId;
        this.commentUserId = commentUserId;
        this.commentContent = commentContent;
        this.commentLevel = commentLevel;
        this.commentTime = commentTime;
        this.masterUrl = masterUrl;
        this.mainComments = mainComments;
        this.userNickName = userNickName;
    }
}
