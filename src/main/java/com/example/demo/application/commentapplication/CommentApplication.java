package com.example.demo.application.commentapplication;

import com.example.demo.dto.commentdtos.CommentDTO;
import com.example.demo.dto.commentdtos.CreateCommentDTO;

public interface CommentApplication {
    public CommentDTO add(CreateCommentDTO dto);
}
